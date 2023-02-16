
package objetos.web.bean;


import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import objetos.web.CrudJPA.CarroCrud;

import objetos.web.entity.Carro;
import objetos.web.entity.Fabricante;

@SessionScoped
@ManagedBean
public class CarroBean extends CrudBean<Carro, Fabricante, CarroCrud>{
    
    private CarroCrud carro; 
    
    private List<Fabricante> valores;
    
    private Carro car;
    
    private List<Carro> carros;
    
    public CarroBean(){
        this.valores=new ArrayList<>();
        this.carro=new CarroCrud();
        this.carros=new ArrayList<Carro>();
        this.car=new Carro();
        
        this.valores=carro.buscarB();
        
        this.carros=carro.buscarJPA();
        
    }

    public List<Fabricante> getValores() {
        return valores;
    }

    public void setValores(List<Fabricante> valores) {
        this.valores = valores;
    }
    
    

    public Carro getCar() {
        return car;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCar(Carro car) {
        this.car = car;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
    
   
    @Override
    public CarroCrud get() {
           if (carro==null){     
                carro=new CarroCrud();
                
            }
            return carro;
    }
    
   
    

    @Override
    public Carro criarNovaEntidade() {
        
        return new Carro();
        
    }

    @Override
    public Fabricante fabEntidade() {

           return new Fabricante();
    }

  
    public void listarCars(AjaxBehaviorEvent event){
        this.carros=carro.buscarJPA();
    }
    
    
    public void listaPorFabrica(AjaxBehaviorEvent event){
     this.valores=this.carro.buscarB();
     
    }
    
   
   
    
}
