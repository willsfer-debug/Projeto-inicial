
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectaDAO {

    private Connection conexao;

    public Connection getConexao() {
        return conexao;
    }

    public Connection connectDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/leiloes?useSSL=false", "root", "83933D&f97");
        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
        return conexao;
    }

    public void desconectar() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println(" Desconectado com Sucesso ");
            }
        } catch (SQLException se) {
            System.out.println(" Erro ao desconectar " + se);
        }
    }

}
