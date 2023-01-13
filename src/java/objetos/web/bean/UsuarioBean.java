
package objetos.web.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import objetos.web.dao.UsuarioDAO;
import objetos.web.entity.Usuario;


@SessionScoped
@ManagedBean
public class UsuarioBean extends CrudBean<Usuario, UsuarioDAO>{

    
    private UsuarioDAO user;
    
   @Override
    public UsuarioDAO get() {
        
        if (user==null){
            user=new UsuarioDAO();
        }

        return user;
    }

    @Override
    public Usuario criarNovaEntidade() {
            return  new Usuario();

    }   

  
}
    
    
    
    
    
    
    

