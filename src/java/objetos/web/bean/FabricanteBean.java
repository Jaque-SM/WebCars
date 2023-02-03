
package objetos.web.bean;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import objetos.web.CrudJPA.FabricanteCrud;
import objetos.web.entity.Carro;
import objetos.web.entity.Fabricante;

@SessionScoped
@ManagedBean
public class FabricanteBean extends CrudBean<Fabricante, Carro, FabricanteCrud>{

    private FabricanteCrud fab;
    
    private  List<Fabricante> valor;
    
    private Fabricante fabrica;  

 
    public FabricanteBean (){
        this.valor=new ArrayList<Fabricante>();
        this.fab=new FabricanteCrud();
        this.fabrica=new Fabricante();
        
        this.valor=fab.listarPorEmpresa();
    }
    
    
    public void setFabrica(Fabricante fabrica) {
        this.fabrica = fabrica;
    }
    

    public Fabricante getFabrica() {
        return fabrica;
    }    

    public void setFab(FabricanteCrud fab) {
        this.fab = fab;
    }

    
    
    @Override
    public FabricanteCrud get() {
        if (fab==null){
            fab=new FabricanteCrud();
        }
        
       return fab;
    }

    @Override
    public Fabricante criarNovaEntidade() {

        return new Fabricante();
    }

    @Override
    public Carro fabEntidade() {
        
        return new Carro();
    }
    

    public List<Fabricante> getValor() {
        return valor;
    }

    public void setValor(List<Fabricante> valor) {
        this.valor = valor;
    }

    public void listaPorFabrica(AjaxBehaviorEvent event){
     this.valor=this.fab.listarPorEmpresa();
     
    }
    
   
   

}
