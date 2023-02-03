
package objetos.web.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import objetos.web.CrudJPA.UsuarioCrud;
import objetos.web.entity.Fabricante;
import objetos.web.entity.Usuario;

@SessionScoped
@ManagedBean
public class UsuarioBean extends CrudBean<Usuario, Fabricante, UsuarioCrud>{

    
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

    @Override
    public Fabricante fabEntidade() {
            return new Fabricante();
    }

  
}
    
    
    
    
    
    
    

