
package objetos.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import objetos.web.util.exception.ErroSistema;


public class FabricaConexao {
    
    
    private static Connection conexao;
    private static final String URLCONEXAO="jdbc:mysql://localhost:3306/veiculos?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USERNAME="root";
    private static final String PASSWORD="123456";
    
    public static Connection getConexao() throws ErroSistema{
        if (conexao==null){
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexao=DriverManager.getConnection(URLCONEXAO,USERNAME,PASSWORD);
            
            
            } catch (ClassNotFoundException ex) {
                    throw new ErroSistema("Não foi possivel conectar ao banco de dados", ex);

            } catch (SQLException ex) {
                 throw new ErroSistema("O driver não foi encontrado!", ex);
            }
        }
        
        return conexao;
        
    }
    
    public static void fecharConexao() throws ErroSistema{
        if (conexao!=null){
            try{
                conexao.close();
                conexao=null;
            }
            catch (SQLException e){
                throw new ErroSistema("Não foi possivel fechar a conexão com o banco de"
                        + "dados", e);
            }
        }
        
    }
    
    
}
