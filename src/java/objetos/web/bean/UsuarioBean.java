
package objetos.web.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import objetos.web.CrudJPA.UsuarioCrud;
import objetos.web.entity.Usuario;

@SessionScoped
@ManagedBean
public class UsuarioBean extends CrudBean<Usuario, UsuarioCrud>{

    
    private UsuarioCrud user;

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

  
}
    
    
    
    
    
    
    

