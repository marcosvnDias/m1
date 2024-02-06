package abstracao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean finalizar = false;
        System.out.println("-------- BEM VINDO! ---------");

        while(!finalizar){
            System.out.println("\nDigite o número da opção que você quer executar");
            System.out.println("1 - Adicionar novo curso");

            String opcao2 = Curso.cursoList.isEmpty() ?
                    "2 - Bloqueado" : "2 - Listar cursos";
            System.out.println(opcao2);

            String opcao3 = Curso.cursoList.isEmpty() ?
                    "3 - Bloqueado" : "3 - Listar Professores";
            System.out.println(opcao3);

            String opcao4 = Curso.cursoList.isEmpty() ?
                    "4 - Bloqueado" : "4 - Progresso";
            System.out.println(opcao4);

            String opcao5 = Curso.cursoList.isEmpty() ?
                    "5 - Bloqueado" : "5 - Participação";
            System.out.println(opcao5);

            String opcao6 = Curso.cursoList.isEmpty() ?
                    "6 - Bloqueado" : "6 - Detalhes do curso do professor";
            System.out.println(opcao6);

            System.out.println("7 - Fazer a média das notas");
            System.out.println("0 - Sair");
            int opcaoEscolhida = scanner.nextInt();
            scanner.nextLine();

            if(opcaoEscolhida == 2 && opcao2.equals("2 - Bloqueado")){
                opcaoEscolhida = -1;
            } else if (opcaoEscolhida == 3 && opcao3.equals("3 - Bloqueado")) {
                opcaoEscolhida = -1;
            } else if (opcaoEscolhida == 4 && opcao4.equals("4 - Bloqueado")) {
                opcaoEscolhida = -1;
            } else if (opcaoEscolhida == 5 && opcao5.equals("5 - Bloqueado")) {
                opcaoEscolhida = -1;
            } else if (opcaoEscolhida == 6 && opcao6.equals("6 - Bloqueado")) {
                opcaoEscolhida = -1;
            }

            switch(opcaoEscolhida){
                case 1:
                    System.out.println("\n1 - Adicionar novo curso");
                    Curso curso = new Curso();
                    Professor professor = new Professor();
                    addCurso(scanner, curso, professor);
                    break;
                case 2:
                    System.out.println("\n2 - Listar cursos");
                    listarCursos();
                    break;
                case 3:
                    System.out.println("\n3 - Listar Professores");
                    listarProfessores();
                    break;
                case 4:
                    System.out.println("\n4 - Progresso");
                    int idCursoEscolhido = pedirId(scanner);

                    for(Curso cursoDaLista : Curso.cursoList){
                        if(cursoDaLista.getId() == idCursoEscolhido){
                            cursoDaLista.progresso(scanner);
                            break;
                        }
                    }

                    break;
                case 5:
                    System.out.println("\n5 - Participação");
                    int idCursoEscolhido2 = pedirId(scanner);

                    for(Curso cursoDaLista : Curso.cursoList){
                        if(cursoDaLista.getId() == idCursoEscolhido2){
                            cursoDaLista.participacao(scanner);
                            break;
                        }
                    }

                    break;
                case 6:
                    System.out.println("\n6 - Detalhes do curso do professor");
                    System.out.println("Digite o id do curso que você quer mais detalhes");

                    listarProfessores();
                    int cursoEscolhido = scanner.nextInt();
                    Professor professorAchado = acharProfessor(cursoEscolhido);

                    professorAchado.ensinar();
                    break;
                case 7:
                    System.out.println("\n7 - Fazer a média das notas");
                    Curso.notas(scanner);
                    break;
                case 0:
                    finalizar = true;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

        scanner.close();
        System.out.println("\n------- FIM DO PROGRAMA -------");

    }

    public static void addCurso(Scanner scanner, Curso curso, Professor professor){
        System.out.print("Digite o nome do curso: ");
        curso.nome = scanner.nextLine();

        System.out.print("Digite a descrição do curso: ");
        curso.descricao = scanner.nextLine();

        System.out.print("Digite a carga horaría: ");
        curso.cargaHoraria = scanner.nextFloat();

        System.out.println("\nDados do professor do curso");
        scanner.nextLine();

        System.out.print(" Nome do Professor: ");
        professor.nome = scanner.nextLine();

        System.out.print(" Especialidade: ");
        professor.especialidade = scanner.nextLine();

        professor.cursoId = curso.getId();
        curso.professores.add(professor);
        Curso.cursoList.add(curso);
        Professor.professorList.add(professor);
    }

    public static void listarCursos(){
        for(Curso curso : Curso.cursoList){
            System.out.println(" Nome do curso: " + curso.nome);
            System.out.println(" Descrição do curso: " + curso.descricao);
            System.out.println(" Carga horária do curso: " + curso.cargaHoraria);
            System.out.println(" ID do curso: " + curso.getId());

            System.out.println("\n Dados dos professores do curso ");
            for(int i = 0; i < curso.professores.size(); i++){
                System.out.println("  Nome: " + curso.professores.get(i).nome);
                System.out.println("  Especialidade: " + curso.professores.get(i).especialidade);
            }
        }
    }

    public static void listarProfessores(){
        for(Professor professor : Professor.professorList){
            System.out.println("Nome: " + professor.nome);
            System.out.println("Especialidade: " + professor.especialidade);
            System.out.println("ID do curso que ensina: " + professor.cursoId);
        }
    }

    public static int pedirId(Scanner scanner){
        listarCursos();
        System.out.println("Digite o número do id do curso que você quer acessar");
        return scanner.nextInt();
    }

    public static Professor acharProfessor(int cursoId) {
        Professor prof = null;
        for (Professor professor : Professor.professorList) {
            if (professor.cursoId == cursoId) {
                prof = professor;
            }
        }
        return prof;
    }

}
