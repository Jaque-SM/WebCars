
package objetos.web.bean;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import objetos.web.CrudJPA.CarroCrud;

import objetos.web.entity.Carro;
import objetos.web.entity.Fabricante;

@SessionScoped
@ManagedBean
public class CarroBean extends CrudBean<Carro, CarroCrud>{
    
    private CarroCrud carro; 
    
    private CarroCrud carCrud;
    
    private Carro ava;
    
    private List<Fabricante> valores;
        
    private List<Carro> carros;
    
     public CarroBean(){
        this.valores=new ArrayList<>();
        this.carros=new ArrayList<Carro>();
        
        
        
       this.carCrud=new CarroCrud();
       this.carros=carCrud.buscarJPA();

        
    }
    
    @Override
    public Carro criarNovaEntidade() {
        return new Carro();
        
    }

    public Carro getAva() {
        return ava;
    }

    public void setAva(Carro ava) {
        this.ava = ava;
    }
    
    
    
    @Override
    public CarroCrud get() {
           if (carro==null){     
                carro=new CarroCrud();                
                
            }
           return carro;
    }
    
    
   

    public CarroCrud getCarro() {
        return carro;
    }
    
    public CarroCrud getCarCrud() {
        return carCrud;
    }

    public void setCarro(CarroCrud carro) {
        this.carro = carro;
    }

    public void setCarCrud(CarroCrud carCrud) {
        this.carCrud = carCrud;
    }
    
    public List<Fabricante> getValores() {
        return valores;
    }

    public void setValores(List<Fabricante> valores) {
        this.valores = valores;
    }
    
    


    public List<Carro> getCarros() {
        return carros;
    }


    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
    
   
    public boolean FilterFunction(Object value, Object filter, Locale locale){
        String filtertext = (filter==null)? null: filter.toString().trim().toLowerCase();
        
        
        
        return false;
    } 
    
   
    

    

  
    public void listarCars(AjaxBehaviorEvent event){
        this.carros=carro.buscarJPA();
    }
    
    
    public void listaPorFabrica(AjaxBehaviorEvent event){
     this.valores=this.carro.buscarB();
     
    }

   
   
    
}
