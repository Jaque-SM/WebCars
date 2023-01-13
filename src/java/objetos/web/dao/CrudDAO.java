
package objetos.web.dao;

import java.util.List;
import objetos.web.util.exception.ErroSistema;

//esqueleto de todas as classes que implementa o crud
public interface CrudDAO<E> {
    
    
    public void salvar(E entidade) throws ErroSistema;
               
   public void deletar (E entidade) throws ErroSistema;     
        
   public  List<E> buscar();
    
    
    
        
    
}
