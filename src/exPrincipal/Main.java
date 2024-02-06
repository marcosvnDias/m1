package exPrincipal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean finalizar = false;

        System.out.println("------- Bem Vindo! -------");
        while(!finalizar){
            System.out.println("\nDigite o número da opção que você deseja executar");
            System.out.println("1 - Adicionar");

            String opcao2 = cursos.isEmpty() ?
                    "2 - Opção bloqueada" : "2 - Listar";
            System.out.println(opcao2);

            String opcao3 = cursos.isEmpty() ?
                    "3 - Opção bloqueada" : "3 - Remover";
            System.out.println(opcao3);

            String opcao4 = cursos.isEmpty() ?
                    "4 - Opção bloqueada" : "4 - Marcar curso como concluído";
            System.out.println(opcao4);

            String opcao5 = cursosConcluidos.isEmpty() ?
                    "5 - Opção bloqueada" : "5 - Listar cursos concluídos";
            System.out.println(opcao5);
            System.out.println("0 - Sair");

            int opcaoEscolhida = scanner.nextInt();
            scanner.nextLine();

            if(opcaoEscolhida == 2 && opcao2.equals("2 - Opção bloqueada")){
                opcaoEscolhida = -1;
            } else if(opcaoEscolhida == 3 && opcao3.equals("3 - Opção bloqueada")){
                opcaoEscolhida = -1;
            } else if(opcaoEscolhida == 4 && opcao4.equals("4 - Opção bloqueada")){
                opcaoEscolhida = -1;
            } else if(opcaoEscolhida == 5 && opcao5.equals("5 - Opção bloqueada")){
                opcaoEscolhida = -1;
            }

            switch(opcaoEscolhida){
                case 1:
                    System.out.println("\n1 - Adicionar");

                    System.out.println("Nome do curso: ");
                    String curso = scanner.nextLine();

                    System.out.println("\nNome do professor");
                    String professor = scanner.nextLine();

                    adicionar(curso, professor);
                    break;
                case 2:
                    System.out.println("\n2 - Listar");
                    listar();
                    break;
                case 3:
                    System.out.println("\n3 - Remover");
                    removerItemLista(scanner);
                    break;
                case 4:
                    System.out.println("\n4 - Marcar curso como concluído");
                    marcarComoConcluido(scanner);
                    break;
                case 5:
                    System.out.println("\n5 - Listar cursos concluídos");
                    listarCursosConcluidos();
                    break;
                case 0:
                    finalizar = true;
                    break;
                default:
                    System.out.println("Opção inválida\n");
            }
        }

        scanner.close();
        System.out.println("\n------- FIM DO PROGRAMA ------");

    }

    public static List<String> cursos = new ArrayList<>();

    public static List<String> professores = new ArrayList<>();

    public static List<String> cursosConcluidos = new ArrayList<>();


    public static void adicionar(String curso, String professor){
        cursos.add(curso);
        professores.add(professor);
    }

    public static void listar(){
        System.out.println("Cursos:");
        for(int i = 0; i < cursos.size(); i++){
            System.out.println(" [" + i + "] " + cursos.get(i));
        }

        System.out.println("\nProfessores:");
        for(int i = 0; i < professores.size(); i++){
            System.out.println(" [" + i + "] " + professores.get(i));
        }
    }

    public static int pedirIndice(Scanner scanner){
        listar();
        System.out.println("\nDigite o número do curso que você quer");
        return scanner.nextInt();
    }

    public static void removerItem(int indexItem){
        cursos.remove(indexItem);
        professores.remove(indexItem);
    }

    public static void removerItemLista(Scanner scanner){
        int indexItem = pedirIndice(scanner);
        removerItem(indexItem);
    }

    public static void marcarComoConcluido(Scanner scanner){
        int indice = pedirIndice(scanner);
        cursosConcluidos.add(cursos.get(indice) + " - " + professores.get(indice));
        removerItem(indice);
    }

    public static void listarCursosConcluidos(){
        for(String curso : cursosConcluidos){
            System.out.println(" " + curso);
        }
    }
}