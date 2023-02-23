
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
public class UsuarioBean extends CrudBean<Usuario, UsuarioCrud>{
    
    private UsuarioCrud user;
    
    private List<Usuario> listUsers;

    public UsuarioBean() {
        
        this.listUsers=new ArrayList<Usuario>();
            
        
    }   
    
    @Override
    public UsuarioCrud get() {
        if (user==null){
            user=new UsuarioCrud();
        }
        this.listUsers=user.buscarJPA();
        return user;
        
    }

    public UsuarioCrud getUser() {
        return user;
    }
        
    @Override
    public Usuario criarNovaEntidade() {
            return new Usuario();

    }

    public List<Usuario> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<Usuario> listUsers) {
        this.listUsers = listUsers;
    }

    public void setUser(UsuarioCrud user) {
        this.user = user;
    }
    
  

  
}
    
    
    
    
    
    
    

