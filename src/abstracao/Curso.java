package abstracao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Curso {

    private static int id = 0;
    public String nome;

    public String descricao;

    public static List<Curso> cursoList = new ArrayList<>();
    public List<Professor> professores = new ArrayList<>();

    public float cargaHoraria;

    public Curso(){
        id++;
    }

    public void progresso(Scanner scanner){
        boolean finalizarLoop = false;
        float tempoGasto = 0;

        while(!finalizarLoop){
            System.out.println("\nQuantas horas você já assistiu desse curso?");
            tempoGasto = scanner.nextFloat();

            if(tempoGasto > cargaHoraria){
                System.out.println("Número inválido, tente novamente.");
            } else {
                finalizarLoop = true;
            }
        }

        float resultado = (tempoGasto / cargaHoraria) * 100;
        System.out.println("\nProgresso: " + resultado + "%");
    }

    public void participacao(Scanner scanner){
        boolean finalizarLoop = false;
        float tempoPartipacao = 0;

        while(!finalizarLoop){
            System.out.println("\nQuantas horas você já assistiu desse curso?");
            tempoPartipacao = scanner.nextFloat();

            if(tempoPartipacao > cargaHoraria){
                System.out.println("Número inválido, tente novamente.");
            } else {
                finalizarLoop = true;
            }
        }

        float resultado = (tempoPartipacao / cargaHoraria) * 100;
        System.out.println("\nVocê tem : " + resultado + "% de participação");
    }

    public static void notas(Scanner scanner){
        System.out.println("Sua primeira nota: ");
        float nota1 = scanner.nextInt();

        System.out.println("\nSua segunda nota: ");
        float nota2 = scanner.nextInt();

        float media = (nota1 + nota2) / 2;
        System.out.println("\nSua média foi " + media);
    }

    public int getId(){
        return id;
    }
}
