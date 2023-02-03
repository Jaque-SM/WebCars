
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
    
    private Fabricante fab;
    
    private Carro car;
    
    private List<Carro> carros;
    
    public CarroBean(){
        this.carro=new CarroCrud();
        this.carros=new ArrayList<Carro>();
        this.car=new Carro();
        carros=carro.buscarJPA();
        
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
    
    public Fabricante getFabs(){
        if (fab==null){
            fab=new Fabricante();
        }
        return fab;
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
    
   
    
}
