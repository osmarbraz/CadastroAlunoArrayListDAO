package modelo;

import dao.AlunoDAO;
import java.util.ArrayList;

/**
 * Classe que representa uma Aluno.
 */
public class Aluno extends Pessoa {

    /**
     * Curso que o aluno realiza.
     */
    private String curso;
    /**
     * Fase que o aluno se encontra.
     */
    private int fase;

    /**
     * Construtor de Objeto Vazio.
     */
    public Aluno() {
        this(0,"",0,"",0);
    }
    
    /**
     * Construtor com parâmetro.
     * 
     * @param id Identificador do aluno.
     * @param nome Nome do aluno.
     * @param idade Idade do aluno.
     * @param curso Curso do aluno.
     * @param fase Fase do aluno.
     */
    public Aluno( int id, String nome, int idade, String curso, int fase) {
        super(id, nome, idade);
        this.curso = curso;
        this.fase = fase;
    }

    // Métodos GET e SET
    /**
     * Retorna o curso do aluno.
     * 
     * @return Uma String com o nome do curso do aluno.
     */
    public String getCurso() {
        return curso;
    }

    /**
     * Modifica o curso do aluno.
     * 
     * @param curso Uma string com o nome do curso do aluno.
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * Retorna a fase do aluno.
     * 
     * @return  Um inteiro com a fase do aluno.
     */
    public int getFase() {
        return fase;
    }

    /**
     * Modifica a fase do aluno.
     * 
     * @param fase Um int com a fase do aluno.
     */
    public void setFase(int fase) {
        this.fase = fase;
    }

    /**
     * Retorna os dados do aluno em uma string.
     * 
     * @return Uma string com todos os dados do aluno concatenado.
     */
    @Override
    public String toString() {
        return super.toString() + "curso=" + curso + ", fase=" + fase;
    }
 
    /*  ABAIXO OS MéTODOS PARA USO JUNTO COM O DAO
        SIMULANDO A ESTRUTURA EM CAMADAS PARA USAR COM BANCOS DE DADOS.
    */    
    /**
     * Retorna a Lista de Alunos(objetos).
     * 
     * @return Um ArrayList com todos os Alunos.
     */
    public ArrayList<Aluno> getMinhaLista() {
        return AlunoDAO.getMinhaLista();
    }

    /**
     * Insere um novo aluno.
     * 
     * @param nome O nome do aluno.
     * @param idade A idade do aluno.
     * @param curso O curso do aluno
     * @param fase A fase do aluno.
     * @return Verdadeiro ou falso se conseguiu fazer a inclusão.
     */
    public boolean insertAlunoBD(String nome, int idade, String curso, int fase) {
        int id = this.maiorID() + 1;
        Aluno objeto = new Aluno(id, nome, idade, curso, fase);
        AlunoDAO.minhaLista.add(objeto);
        return true;
    }

    /**
     * Deleta um aluno especÍfico pelo seu ID.
     * 
     * @param id Id do aluno a ser excluído.
     * @return Verdadeiro ou falso se conseguiu fazer a exclusão.
     */
    public boolean deleteAlunoBD(int id) {
        int indice = this.procuraIndice(id);
        AlunoDAO.minhaLista.remove(indice);
        return true;
    }

    /**
     * Edita um aluno especÍfico pelo seu ID.
     * 
     * @param id O id do aluno.
     * @param nome O nome do aluno.
     * @param idade A idade do aluno.
     * @param curso O curso do aluno
     * @param fase A fase do aluno.
     * @return Verdadeiro ou falso se conseguiu fazer a inclusão.
     */
    public boolean updateAlunoBD(int id, String nome, int idade, String curso, int fase) {
        Aluno objeto = new Aluno(id, nome, idade, curso, fase);
        int indice = this.procuraIndice(id);
        AlunoDAO.minhaLista.set(indice, objeto);
        return true;
    }
    
    /**
     * Procura o INDICE de objeto da MinhaLista que contem o ID enviado.
     * 
     * @param id O Id do aluno a ser procurado.
     * @return Um inteiro com a posição do aluno no ArrayList.
     */
    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < AlunoDAO.minhaLista.size(); i++) {
            if (AlunoDAO.minhaLista.get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }
    
    /**
     * Carrega dados de um aluno especÍfico pelo seu ID.
     * 
     * @param id O id do aluno a ser carregado.
     * @return Um objeto aluno preenchido.
     */
    public Aluno carregaAluno(int id) {
        int indice = this.procuraIndice(id);
        return AlunoDAO.minhaLista.get(indice);
    }
    
    /**
     * Retorna o maior ID da nossa base de dados.
     * 
     * @return Um inteiro com o maior valor de Id de aluno.
     */
    public int maiorID(){
        return AlunoDAO.maiorID();
    }   
}
