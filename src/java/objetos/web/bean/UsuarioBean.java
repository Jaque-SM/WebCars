
package objetos.web.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import objetos.web.CrudJPA.CarroCrud;
import objetos.web.CrudJPA.UsuarioCrud;
import objetos.web.entity.Carro;
import objetos.web.entity.Fabricante;
import objetos.web.entity.Usuario;

@SessionScoped
@ManagedBean
public class UsuarioBean extends CrudBean<Usuario, Fabricante, UsuarioCrud>{

    private List<Carro> listcars;
    
    private UsuarioCrud user;
    
    private CarroCrud ava;
    
    private Carro carts;

    public UsuarioBean() {
        this.carts=new Carro();
        this.ava=new CarroCrud();
        this.listcars=new ArrayList<>();
        this.listcars=ava.buscarJPA();
        
    }   
    
    @Override
    public UsuarioCrud get() {
        if (user==null){
            user=new UsuarioCrud();
        }
        
        return user;
        
    }

    @Override
    public Usuario criarNovaEntidade() {
            return new Usuario();

    }

    @Override
    public Fabricante fabEntidade() {
            return new Fabricante();
    }

    public Carro getCarts() {
        return carts;
    }

    public void setCarts(Carro carts) {
        this.carts = carts;
    }
    
    
      public List<Carro> getListcars() {
        return listcars;
    }

    public void setListcars(List<Carro> listcars) {
        this.listcars = listcars;
    }

    public CarroCrud getAva() {
        return ava;
    }

    public void setUser(UsuarioCrud user) {
        this.user = user;
    }
    
    public void setAva(CarroCrud ava) {
        this.ava = ava;
    }
    
    
       public void listarCars(AjaxBehaviorEvent event){
        this.listcars=ava.buscarJPA();
    }
    
    

  
}
    
    
    
    
    
    
    

