package dao;

import java.util.ArrayList;
import modelo.Aluno;

/**
 *  Aqui vamos simular a persistência de dados.
 */
public class AlunoDAO {

    public static ArrayList<Aluno> MinhaLista = new ArrayList<>();

    public static ArrayList<Aluno> getMinhaLista() {
        return MinhaLista;
    }

    public static void setMinhaLista(ArrayList<Aluno> MinhaLista) {
        AlunoDAO.MinhaLista = MinhaLista;
    }

    public static int maiorID() {        
        int maiorID = 0;
        for (int i = 0; i < MinhaLista.size(); i++) {
            if (MinhaLista.get(i).getId() > maiorID) {
                maiorID = MinhaLista.get(i).getId();
            }
        }
        return maiorID;        
    }
}
