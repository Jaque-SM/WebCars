/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package objetos.web.DaoJPA;

import java.util.List;
import objetos.web.util.exception.ErroSistema;


public interface CrudJPA<A> {
    
    public void SalvarJPA (A entidade) throws ErroSistema;
    
    public void DeletarJPA (A entidade) throws ErroSistema;     
        
    public  List<A> buscarJPA();
}
