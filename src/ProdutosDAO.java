
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
    
        
        
    }
    
    public void salvarProduto (ProdutosDTO produto){

    String sql = "INSERT INTO produtos (nome, valor) VALUES (?, ?)";

    try {
        conectaDAO conexao = new conectaDAO();
        conexao.conectar();

        PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);

        stmt.setString(1, produto.getNome());
        stmt.setInt(2, produto.getValor());

        stmt.executeUpdate();

        stmt.close();
        conexao.desconectar();

        System.out.println("Produto salvo com sucesso!");

    } catch (SQLException e) {
        System.out.println("Erro ao salvar produto: " + e.getMessage());
    }
}
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

