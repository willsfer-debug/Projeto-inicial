
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {
    
     private Connection conexao;   
     public Connection getConexao(){
     return conexao;
     }
     
    public void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/leiloes","root","83933D&f97");
            System.out.println("Conectado!");
        } catch (ClassNotFoundException cnfe) {
            System.out.println(" Falha ao carregar a classe de conexão, classe não encontrada " + cnfe);
        } catch (SQLException se){
            System.out.println(" Falha ao conectar ao banco! ERRO DE SQL " + se);
        }
    }
  
    public void desconectar(){
        try {
            if(conexao != null && !conexao.isClosed())  {
                conexao.close();
                System.out.println(" Desconectado com Sucesso ");
            }
        }catch (SQLException se){
            System.out.println(" Erro ao desconectar " + se);
        }
    }
    
}
