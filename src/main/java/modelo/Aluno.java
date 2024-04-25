package modelo;

import dao.AlunoDAO;
import java.util.ArrayList;

public class Aluno extends Pessoa {

    // Atributos
    private String curso;
    private int fase;

    // Construtor de Objeto Vazio
    public Aluno() {
        this(0,"",0,"",0);
    }

    // Construtor com parâmetro
    public Aluno( int id, String nome, int idade, String curso, int fase) {
        super(id, nome, idade);
        this.curso = curso;
        this.fase = fase;
    }

    // Métodos GET e SET
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    @Override
    public String toString() {
        return super.toString() + "curso=" + curso + ", fase=" + fase;
    }
 
    /*  ABAIXO OS MéTODOS PARA USO JUNTO COM O DAO
        SIMULANDO A ESTRUTURA EM CAMADAS PARA USAR COM BANCOS DE DADOS.
    */
    
    // Retorna a Lista de Alunos(objetos)
    public ArrayList getMinhaLista() {
        return AlunoDAO.MinhaLista;
    }

    // Cadastra novo aluno
    public boolean InsertAlunoBD(String nome, int idade, String curso, int fase) {
        int id = this.maiorID() + 1;
        Aluno objeto = new Aluno(id, nome, idade, curso, fase);
        AlunoDAO.MinhaLista.add(objeto);
        return true;

    }

    // Deleta um aluno especÍfico pelo seu campo ID
    public boolean DeleteAlunoBD(int id) {
        int indice = this.procuraIndice(id);
        AlunoDAO.MinhaLista.remove(indice);
        return true;
    }

    // Edita um aluno especÍfico pelo seu campo ID
    public boolean UpdateAlunoBD(int id, String nome, int idade, String curso, int fase) {
        Aluno objeto = new Aluno(id, nome, idade, curso, fase);
        int indice = this.procuraIndice(id);
        AlunoDAO.MinhaLista.set(indice, objeto);
        return true;
    }

    // procura o INDICE de objeto da MinhaLista que contem o ID enviado.
    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < AlunoDAO.MinhaLista.size(); i++) {
            if (AlunoDAO.MinhaLista.get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }
    
    // carrega dados de um aluno especÍfico pelo seu ID
    public Aluno carregaAluno(int id) {
        int indice = this.procuraIndice(id);
        return AlunoDAO.MinhaLista.get(indice);
    }
    
    // retorna o maior ID da nossa base de dados
    public int maiorID(){
        return AlunoDAO.maiorID();
    }   
}