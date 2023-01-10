
package objetos.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import objetos.web.entity.Carro;
import objetos.web.util.FabricaConexao;
import objetos.web.util.exception.ErroSistema;


public class CarroDAO {
    
    public void salvar (Carro carro) throws ErroSistema{
          
        try {
              Connection conexao=FabricaConexao.getConexao();
            
           PreparedStatement  ps;
           
            if (carro.getId()==null){
            ps = conexao.prepareCall("INSERT INTO `veiculos`.`carro`(`modelo`,`fabricante`,`cor`,`ano`) VALUES(?,?,?,?)");
            }
            else {
                ps=conexao.prepareCall("update carro set modelo=?, fabricante=?, cor=?, ano=? where id=?");
                   ps.setInt(5, carro.getId());
            }
                ps.setString(1, carro.getModelo());
                ps.setString(2, carro.getFabricante());
                ps.setString(3, carro.getCor());
                ps.setDate(4, new java.sql.Date(carro.getAno().getTime()));
                
                ps.execute();
                
                FabricaConexao.fecharConexao();
            }catch (SQLException ex) {
                   throw new ErroSistema("Erro ao salvar o carro!", ex); 
            }
  
    }
    public void deletar(Integer idCarro) throws ErroSistema{
        try {
            Connection conexao=FabricaConexao.getConexao();
            
            PreparedStatement  ps=conexao.prepareCall("delete from carro where id=?");
            
            ps.setInt(1, idCarro);
            ps.execute();
            
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar o carro!", ex);

        }
        
        
        
        
    }
    public List buscarCarro() throws ErroSistema{
         Connection conexao=FabricaConexao.getConexao();

          PreparedStatement  ps;
          
           try {
            ps = conexao.prepareCall("select * from carro");
       
            ResultSet resultlist=ps.executeQuery();
            
            List<Carro> carros=new ArrayList();

            while (resultlist.next()){
                  Carro carro=new Carro();

                carro.setId(resultlist.getInt("id"));
                carro.setModelo(resultlist.getString("modelo"));
                carro.setFabricante(resultlist.getString("fabricante"));
                carro.setCor(resultlist.getString("cor"));
                carro.setAno(resultlist.getDate("ano"));
                
                carros.add(carro);
            }
                
            return carros;
        
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar buscar o carro!", ex);
        }

    }
}
