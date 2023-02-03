
package objetos.web.CrudJPA;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import objetos.web.DaoJPA.CrudJPA;
import objetos.web.entity.Carro;
import objetos.web.entity.Fabricante;
import objetos.web.util.exception.ErroSistema;

public class FabricanteCrud implements CrudJPA<Fabricante>{
    
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ObjetosPU");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    private Fabricante fabi;

    public Fabricante getFabi() {
        return fabi;
    }

    public void setFabi(Fabricante fabi) {
        this.fabi = fabi;
    }
    public FabricanteCrud(){
        this.fabi=new Fabricante();
    }
   
    @Override
    public void SalvarJPA(Fabricante entidade) throws ErroSistema {
           entityManager.getTransaction().begin();
                
           if (entidade.getId()==null){
           entityManager.createNativeQuery("insert into Fabricante(nome, cnpj, telefone) values(?, ?, ?);", Fabricante.class)
                 .setParameter(1, entidade.getNome())
                 .setParameter(2, entidade.getCnpj())
                 .setParameter(3, entidade.getTelefone());
           
            entityManager.persist(entidade);
            entityManager.getTransaction().commit();
            System.out.println("Salvou os dados");
                  
           }         
           else {
                   entityManager.createQuery("update Fabricante f set f.nome=:nome, f.cnpj=:cnpj, f.telefone=:telefone where u.id="+entidade.getId()+"")
                     .setParameter("nome", entidade.getNome())
                     .setParameter("cnpj", entidade.getCnpj())
                     .setParameter("telefone", entidade.getTelefone())
                     .executeUpdate();
             
              entityManager.getTransaction().commit();
              System.out.println("Fabricante atualizado com sucesso!");            
               
               
           }
    }

    @Override
    public void DeletarJPA(Fabricante entidade) throws ErroSistema {
        
         if (entidade.getId()!=null){
                 entityManager.createQuery("delete from Fabricante u where u.id="+entidade.getId()+"")
                        .executeUpdate();
                  entityManager.getTransaction().commit();
                 System.out.print("Fabricante deletado com sucesso!");  
                 
             }
        
    }
    
    @Override
    public List<Fabricante> buscarJPA() {
        
          String jp="select f from Fabricante f";

           TypedQuery<Fabricante> query2=entityManager.createQuery(jp, Fabricante.class);
       
           List<Fabricante> listaFabs = query2.getResultList();
           
           List<Fabricante> lista2=new ArrayList<>();
           
         for(Fabricante fabs: listaFabs) {
             Fabricante dao=new Fabricante();
               
              dao.setNome(fabs.getNome());
              dao.setCnpj(fabs.getCnpj());
              dao.setTelefone(fabs.getTelefone()); 
              
              lista2.add(dao);
          
       }
            
         return lista2;
    }

    public List<Fabricante> listarPorEmpresa(){        
        
      TypedQuery<Fabricante> query2=entityManager.createQuery("select f from Fabricante f", Fabricante.class);
      
      List<Fabricante> listaFabs = query2.getResultList();
      
       List<Fabricante> lista2=new ArrayList<>();   
      
       for(Fabricante fabs: listaFabs) {
          
             Fabricante dao=new Fabricante();
              dao.setNome(fabs.getNome());
              
              lista2.add(dao);
          
       }
        return lista2;
    }
    
    public static void main (String args[]){
        FabricanteCrud ava=new FabricanteCrud();
        
        List<Fabricante> list=new ArrayList<Fabricante>();
        
        list=ava.listarPorEmpresa();
        
        for (Fabricante fabe: list){
            System.out.println("Nome: "+fabe.getNome());
           


        }
        
        
        
        
        
    }
    
  
}

    
