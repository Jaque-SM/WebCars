
package objetos.web.CrudJPA;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import objetos.web.DaoJPA.CrudJPA;
import objetos.web.entity.Carro;
import objetos.web.util.exception.ErroSistema;
     
   
public class CarroCrud implements CrudJPA<Carro> {

    
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ObjetosPU");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();
    
        
    @Override
    public void SalvarJPA(Carro entidade) throws ErroSistema {
         entityManager.getTransaction().begin();
         
        if (entidade.getId()==null){
         Query q=entityManager.createNativeQuery("INSERT INTO Carro (modelo, fabricante, cor, ano) VALUES(?,?,?,?);", Carro.class)
             .setParameter(1, entidade.getModelo())
             .setParameter(2, entidade.getFabricante())
             .setParameter(3, entidade.getCor())
             .setParameter(4, entidade.getAno());
            
        System.out.println("Salvou os dados");
        entityManager.persist(entidade);
        entityManager.getTransaction().commit();
        }
        else {
           entityManager.createQuery("update Carro c set c.modelo=:modelo, c.fabricante=:fabricante, c.cor=:cor, c.ano=:ano where c.id = "+entidade.getId()+"")
            .setParameter("modelo", entidade.getModelo())
            .setParameter("fabricante", entidade.getFabricante())
            .setParameter("cor", entidade.getCor())
            .setParameter("ano", entidade.getAno())
            .executeUpdate();
                       
              entityManager.getTransaction().commit();
              System.out.println("Atualizado com sucesso!");
            
        }
        entityManager.close();
	entityManagerFactory.close();
     }
    
     @Override
     public void DeletarJPA(Carro entidade) throws ErroSistema {
        entityManager.getTransaction().begin();
         entityManager.createQuery("delete from Carro c where c.id="+entidade.getId()+"")
            .executeUpdate();         
         entityManager.getTransaction().commit();
         entityManager.close();
         
       System.out.print("Deletado com sucesso!");
         
     }

    @Override
     public List<Carro> buscarJPA() {
         
        String jpql = "select c from Carro c";
        
        TypedQuery<Carro> query=entityManager.createQuery(jpql, Carro.class);
        List<Carro> listaCarros = query.getResultList();
        
         List<Carro> lista=new ArrayList();

        for(Carro carros: listaCarros) {
           Carro ava=new Carro();
           ava.setId(carros.getId());
           ava.setModelo(carros.getModelo());
           ava.setFabricante(carros.getFabricante());
           ava.setCor(carros.getCor());
           ava.setAno(carros.getAno());
            lista.add(ava);
       }
         
         return lista;
         
     }
    

    
    
}
