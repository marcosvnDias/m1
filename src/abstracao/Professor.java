package abstracao;

import java.util.ArrayList;
import java.util.List;

public class Professor {

    public static List<Professor> professorList = new ArrayList<>();

    public String nome;

    public String especialidade;

    public int cursoId;

    public void ensinar(){
        for(Curso curso : Curso.cursoList){
            if(curso.getId() == cursoId){
                System.out.println("Nome do curso: " + curso.nome);
                System.out.println("Descrição do curso: " + curso.descricao);
                System.out.println("Carga horária do curso: " + curso.cargaHoraria);
                System.out.println("ID do curso: " + curso.getId());
            }
        }
    }

}
