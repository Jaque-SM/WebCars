
package objetos.web.bean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import objetos.web.CrudJPA.CarroCrud;

import objetos.web.entity.Carro;
import objetos.web.util.exception.ErroSistema;

@SessionScoped
@ManagedBean
public class CarroBean extends CrudBean<Carro, CarroCrud>{
    
    private CarroCrud carro;       

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

   
    
}
