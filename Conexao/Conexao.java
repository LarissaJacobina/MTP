package mtp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author ifg
 */
public class Conexao {

    private String url = "jdbc:postgresql://localhost/mtp2019";

    private String usuario = "postgres";

    private String senha = "ifg";

    private Connection conn;

    public Conexao() {
        conectar();
    }

    public void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        Properties props = new Properties();
        props.setProperty("user", this.usuario);
        props.setProperty("password", this.senha);

        try {
            this.conn = DriverManager.getConnection(this.url, props);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    /**
     * Método que cria a tabela pessoa para este exemplo.
     *
     * Normalmente, a criação de tabelas NÃO é feita pela aplicação.
     */
    public void criarTabela() {
        try {
            PreparedStatement st = this.conn.prepareStatement("CREATE TABLE pessoa (id serial primary key, nome text)");
            st.execute();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que insere uma pessoa no banco de dados
     *
     * Por enquanto, a pessoa está fixa!
     */
    public void inserir() {
        try {
            PreparedStatement st = this.conn.prepareStatement("INSERT INTO pessoa (nome) VALUES (?)");
            st.setString(1, "Larissa");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que atualiza todos os nomes do banco de dados
     *
     * E se for necessário alterar para uma pessoa só? O que muda?
     */
    public void atualizar() {
        try {
            PreparedStatement st = this.conn.prepareStatement("UPDATE pessoa SET nome = ?");
            st.setString(1, "Larissa 2"
                    + "");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que exclui uma determinada pessoa do banco de dados
     *
     * Está sempre excluindo a mesma pessoa! A que tem ID = 1!
     */
    public void excluir() {
        try {
            PreparedStatement st = this.conn.prepareStatement("DELETE FROM pessoa WHERE id = ?");
            st.setInt(1, 1);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public int login(String email, String senha){
        try {
            PreparedStatement ps = this.conn
                    .prepareStatement("SELECT id FROM Pessoa WHERE email = ? AND senha = ?;");
            ps.setString(1, email);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.getMessage()
        }
     }
    

}
