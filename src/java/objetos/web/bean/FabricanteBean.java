
package objetos.web.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import objetos.web.CrudJPA.FabricanteCrud;
import objetos.web.entity.Carro;
import objetos.web.entity.Fabricante;
import objetos.web.model.FabricanteDataModel;

@SessionScoped
@ManagedBean
public class FabricanteBean extends CrudBean<Fabricante, FabricanteCrud>{

    private FabricanteCrud fab;
    
      private FabricanteCrud fabs;
    
    private  List<Fabricante> valor;
    
     private  List<Fabricante> valores;
    
    private Fabricante fabrica; 
    
    private Fabricante fabCrud;
    
    private FabricanteDataModel fabsModel;

    public FabricanteBean (){
        this.valor=new ArrayList<Fabricante>(); 
        
        this.valores=new ArrayList<Fabricante>();
        
        this.fabrica=new Fabricante();
        this.fabs=new FabricanteCrud();
        this.valores=fabs.buscarJPA();
        
        fabsModel=new FabricanteDataModel(this.valores);
        
    }

    public Fabricante getFabCrud() {
        return fabCrud;
    }

    public void setFabCrud(Fabricante fabCrud) {
        this.fabCrud = fabCrud;
    }
      
    public FabricanteCrud getFab() {
        return fab;
    }

    public FabricanteCrud getFabs() {
        return fabs;
    }

    public void setFabs(FabricanteCrud fabs) {
        this.fabs = fabs;
    }

    public List<Fabricante> getValores() {
        return valores;
    }

    public void setValores(List<Fabricante> valores) {
        this.valores = valores;
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


    public FabricanteDataModel getFabsModel() {
        return fabsModel;
    }

    public void setFabsModel(FabricanteDataModel fabsModel) {
        this.fabsModel = fabsModel;
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

  
    public List<Fabricante> getValor() {
        return valor;
    }

    public void setValor(List<Fabricante> valor) {
        this.valor = valor;
    }

   

}
