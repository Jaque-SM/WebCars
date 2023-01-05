
package objetos.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import objetos.web.entity.Carro;

@SessionScoped
@ManagedBean
public class CarroBean implements Serializable{
    
    private Carro carro=new Carro();
    
    private List<Carro> carros=new ArrayList<>();;
    
    public void AddCars(){
        carros.add(carro);
        carro=new Carro();
    }

    public Carro getCarro() {
        return carro;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
    
}
