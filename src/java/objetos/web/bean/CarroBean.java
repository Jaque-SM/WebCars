
package objetos.web.bean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import objetos.web.dao.CarroDAO;
import objetos.web.dao.CrudDAO;
import objetos.web.entity.Carro;
import objetos.web.util.exception.ErroSistema;

@SessionScoped
@ManagedBean
public class CarroBean extends CrudBean<Carro, CarroDAO>{

    
    private CarroDAO carroDAO;       
            
    @Override
    public CarroDAO get() {
            if (carroDAO==null){     
                carroDAO=new CarroDAO();
            }
            return carroDAO;
    }

    @Override
    public Carro criarNovaEntidade() {

            return new Carro();

    }

   
    
}
