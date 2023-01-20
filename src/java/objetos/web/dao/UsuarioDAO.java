
package objetos.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.web.entity.Usuario;
import objetos.web.util.FabricaConexao;
import objetos.web.util.exception.ErroSistema;


public class UsuarioDAO implements CrudDAO<Usuario> {

    public UsuarioDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void salvar(Usuario entidade) throws ErroSistema {
          try {
              Connection conexao=FabricaConexao.getConexao();
            
           PreparedStatement  ps;
           
            if (entidade.getId()==null){
            ps = conexao.prepareCall
        
            ("INSERT INTO `veiculos`.`usuario`(`usuario`,`senha`)VALUES(?,?);");
            
            }
            else {
                ps=conexao.prepareCall
        ("UPDATE `veiculos`.`usuario` SET `usuario` = ?,`senha` = ? WHERE `id` =?;");
                   ps.setInt(3, entidade.getId());
            }
                ps.setString(1, entidade.getUsuario());
                ps.setString(2, entidade.getSenha());
                
                
                ps.execute();
                
                FabricaConexao.fecharConexao();
            }catch (SQLException ex) {
                   throw new ErroSistema("Erro ao salvar o usuario!", ex); 
            }


    }

    @Override
    public void deletar(Usuario entidade) throws ErroSistema {
            try {
            Connection conexao=FabricaConexao.getConexao();
            
            PreparedStatement  ps=conexao.prepareCall("delete from usuario where id=?");
            
            ps.setInt(1, entidade.getId());
            ps.execute();
            
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar o carro!", ex);

        }

    }

    @Override
    public List<Usuario> buscar() {
          try {
               
          Connection conexao = FabricaConexao.getConexao();

          PreparedStatement  ps;
          
            ps = conexao.prepareCall("select * from usuario");
       
            ResultSet resultlist=ps.executeQuery();
            
            List<Usuario> usuario=new ArrayList();

            while (resultlist.next()){
                  Usuario user=new Usuario();
                
                user.setId(resultlist.getInt("id"));
                user.setUsuario(resultlist.getString("usuario"));
                user.setSenha(resultlist.getString("senha"));
                
                usuario.add(user);
            }
                
            return usuario;
        
      
        } 
        catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ErroSistema ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

          return null;

    }
    
    
    
    
}
