package objetos.web.CrudJPA;

import java.util.ArrayList;
import java.util.List;

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
           
           Carro ava=new Carro();
           
           for (Carro cars: entidade.getCars()){
                    ava.setModelo(cars.getModelo());
                    ava.setFabricante(cars.getFabricante());
                    ava.setCor(cars.getCor());
                    ava.setAno(new java.sql.Date(cars.getAno().getTime()));
                    ava.setUser(entidade);
           }
           
         if (entidade.getId()==null){          
             entityManager.createNativeQuery("INSERT INTO  Usuario(usuario, senha, users) values(?,?,?);", Usuario.class)
                    .setParameter(1, entidade.getUsuario())
                    .setParameter(2, entidade.getSenha())
                    .setParameter(3, entidade.getCars().add(ava)); 
                               
            entityManager.persist(entidade); 
            entityManager.getTransaction().commit();
            System.out.println("Usuário salvo com sucesso!");
         }
         
         else {
               entityManager.createQuery("update Usuario u set u.usuario=:usuario, u.senha=:senha, where u.id="+entidade.getId()+"")
                     .setParameter("usuario", entidade.getUsuario())
                     .setParameter("senha", entidade.getSenha())
                     .setParameter("cars", entidade.getCars().add(ava))
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
    
    
    private List<Carro> getObject(){
      
        TypedQuery<Carro> query=entityManager.createQuery("select c from Carro c", Carro.class);

         List<Carro> listaCars = query.getResultList();
        
         List<Carro> lista =new ArrayList<>();
         
        for(Carro cars: listaCars) {
           Carro ava=new Carro();
           ava.setModelo(cars.getModelo());
           ava.setFabricante(cars.getFabricante());
           ava.setCor(cars.getCor());
           ava.setAno(cars.getAno());         
           lista.add(ava);
            
       }
        
        return lista;
        
    } 
    

    @Override
    public List<Usuario> buscarJPA() {
         
        String jpql = "select u from Usuario u";
        
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
