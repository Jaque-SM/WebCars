
package objetos.web.CrudJPA;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import objetos.web.DaoJPA.CrudJPA;
import objetos.web.entity.Carro;
import objetos.web.entity.Usuario;
import objetos.web.util.exception.ErroSistema;


public class UsuarioCrud implements CrudJPA<Usuario>{

    private static  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ObjetosPU");
    private static  EntityManager entityManager=entityManagerFactory.createEntityManager();;
    

    @Override
    public void SalvarJPA(Usuario entidade) throws ErroSistema {
           entityManager.getTransaction().begin();
         
         if (entidade.getId()==null){
            entityManager.createNativeQuery("insert into Usuario(usuario, senha) values(usuario, senha);", Usuario.class)
                    .setParameter(1, entidade.getUsuario())
                    .setParameter(2, entidade.getSenha());
                      
             entityManager.persist(entidade); 
            entityManager.getTransaction().commit();
            System.out.println("Usuario salvo com sucesso!");
            entityManager.close();

         }
         else {
             entityManager.createQuery("update Usuario u set u.usuario=:usuario, u.senha=:senha where u.id="+entidade.getId()+"")
                     .setParameter("usuario", entidade.getUsuario())
                     .setParameter("senha", entidade.getSenha())
                     .executeUpdate();
             
              entityManager.getTransaction().commit();
              System.out.println("Usuario atualizado com sucesso!");

         }
	
    }

    @Override
    public void DeletarJPA(Usuario entidade) throws ErroSistema {
             entityManager.getTransaction().begin();

             if (entidade.getId()!=null){
                 entityManager.createQuery("delete from Usuario u where u.id="+entidade.getId()+"")
                        .executeUpdate();
                  entityManager.getTransaction().commit();
                 System.out.print("Usuario deletado com sucesso!");  
                 
             }
    }

    @Override
    public List<Usuario> buscarJPA() {
         
        String jpql = "select c from Usuario c";
        
        TypedQuery<Usuario> query=entityManager.createQuery(jpql, Usuario.class);
        List<Usuario> listaUsers = query.getResultList();
        
         List<Usuario> lista=new ArrayList();

        for(Usuario user: listaUsers) {
           Usuario ava=new Usuario();
           ava.setId(user.getId());
           System.out.println("Id: "+user.getId());
           ava.setUsuario(user.getUsuario());
           System.out.println("Usuario: "+user.getUsuario());
           ava.setSenha(user.getSenha());
           System.out.println("Senha: "+user.getSenha());


            lista.add(ava);
       }
         
         return lista;

    }
 

   

    
}
