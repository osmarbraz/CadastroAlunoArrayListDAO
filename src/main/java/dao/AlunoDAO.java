package dao;

import java.util.ArrayList;
import modelo.Aluno;

/**
 * Aqui vamos simular a persistência de dados.
 */
public class AlunoDAO {

    /**
     * ArrayList que simula a persistência dos dados.
     */
    public static ArrayList<Aluno> minhaLista = new ArrayList<>();

    /**
     * Retorna o ArrayList.
     *
     * @return O ArrayList.
     */
    public static ArrayList<Aluno> getMinhaLista() {
        return minhaLista;
    }

    /**
     * Modificada o ArrayList.
     *
     * @param minhaLista Um ArrayList.
     */
    public static void setMinhaLista(ArrayList<Aluno> minhaLista) {
        AlunoDAO.minhaLista = minhaLista;
    }

    /**
     * Retorna o maior id do aluno do ArrayList.
     *
     * @return Um id com o maior id de aluno.
     */
    public static int maiorID() {
        int maiorID = 0;
        for (int i = 0; i < minhaLista.size(); i++) {
            if (minhaLista.get(i).getId() > maiorID) {
                maiorID = minhaLista.get(i).getId();
            }
        }
        return maiorID;
    }
}
