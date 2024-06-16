package data;
import model.Usuario;
import java.sql.*;

public class UsuarioDAO {
    // indicando que pode ocorrer um erro durante a execução do código SQL.
    public void create(Usuario usuario) throws SQLException {
        //uma string contendo uma instrução SQL para inserir dados na tabela Usuario. 
        String sql = "INSERT INTO Usuario (Login, Senha) VALUES (?, ?)";
       //conexão com o banco de dados seja fechada corretamente após o uso 
        try (Connection conn = Conexao.getConnection();
            //utilizado para executar comandos sql parametrizados 
            PreparedStatement stmt = conn.prepareStatement(sql)) {
                //define o valor do primeiro parametro (placeholder) como senha do usuario
                stmt.setString(1, usuario.getLogin());
                stmt.setString(2, usuario.getSenha());
                //executa a atualizacao no banco de dados. 
                stmt.executeUpdate();
    
            }

    }
    // Método para ler um usuário pelo login
    public Usuario read(String login) throws SQLException {
        String sql = "SELECT * FROM Usuario WHERE Login = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, login);
            try (ResultSet rs = stmt.executeQuery()) {
                // Verifica se o ResultSet tem algum resultado
                if (rs.next()) {
                    return new Usuario(
                        rs.getString("Login"),
                        rs.getString("Senha")
                    );
                } else {
                    // Retorna null se o usuário não for encontrado
                    return null;
                }
            }
        }
    }

    public void update(Usuario usuario) throws SQLException {
        String sql = "UPDATE Usuario SET Senha = ? WHERE Login = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getSenha());
            stmt.setString(2, usuario.getLogin());
            stmt.executeUpdate();
        }
    }

    public void delete(String login) throws SQLException {
        String sql = "DELETE FROM Usuario WHERE Login = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, login);
            stmt.executeUpdate();
        }
    }
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }
}