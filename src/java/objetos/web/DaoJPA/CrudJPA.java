
package objetos.web.DaoJPA;

import java.util.List;
import objetos.web.util.exception.ErroSistema;


public interface CrudJPA<A> {
    
    public void SalvarJPA (A entidade) throws ErroSistema;
    
    public void DeletarJPA (A entidade) throws ErroSistema;     
        
    public  List<A> buscarJPA();
    
    
}
