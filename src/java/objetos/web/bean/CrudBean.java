
package objetos.web.bean;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import objetos.web.dao.CrudDAO;
import objetos.web.util.exception.ErroSistema;


public abstract class CrudBean <E, D extends CrudDAO> {


    private String estadoTela= "buscar"; //inserir, editar, buscar
    
    
    private E entidade;
    
    
    private List<E> entidades;
    

    public String getEstadoTela() {
        return estadoTela;
    }
    
      public void setEstadoTela(String estadoTela) {
        this.estadoTela = estadoTela;
    }


    public E getEntidade() {
        return entidade;
    }

    public List<E> getEntidades() {
        return entidades;
    }

  
    public void setEntidade(E entidade) {
        this.entidade = entidade;
    }

    public void setEntidades(List<E> entidades) {
        this.entidades = entidades;
    }
    
    public void adicionarMensagem(String texto, FacesMessage.Severity tipoErro){
        FacesMessage fm=new FacesMessage(tipoErro, texto, null);
        FacesContext.getCurrentInstance().addMessage(null, fm);
        
    }
    
    public void novo(){
         entidade=criarNovaEntidade();
         mudarParaInserir();
    }
    
    public void salvar(){
        try {
            get().salvar(entidade);
            entidade=criarNovaEntidade();
            adicionarMensagem("Salvo com sucesso", FacesMessage.SEVERITY_INFO);
            
        } catch (Exception e) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, e);
            adicionarMensagem(e.getMessage(), FacesMessage.SEVERITY_ERROR);
        
        }
        
    }
    public void editar(E entidade){
        this.entidade=entidade;
        mudarParaEditar();
        
    }
    
    public void deletar(E entidade){
        try {
            get().deletar(entidade);
            entidades.remove(entidade);
           adicionarMensagem("Deletado com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
              
        }
    }
    
    public void  buscar(){
        if (isbuscar()==false) {
            mudarParaBuscar();
            return;
        
        } 
        try {
            entidades=get().buscar();
            if (entidades==null||entidades.size()<1){
                 adicionarMensagem("Não temos nada cadastrado", FacesMessage.SEVERITY_WARN);
                
            }
        }  
         catch (Exception e) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, e);
            
         }
    }
    
    public abstract D get();
    
    public abstract E criarNovaEntidade();
    
    
    public boolean isInserir(){
        
        return "inserir".equals(estadoTela);
        
    }
    
    public boolean iseditar(){
        
        return "editar".equals(estadoTela);
    }
    
    public boolean isbuscar(){
        
        return "buscar".equals(estadoTela);
    }
    
    public void mudarParaInserir(){
        
        estadoTela="inserir";
    }

    public void mudarParaEditar(){
    
    estadoTela="editar";

    }
    public void mudarParaBuscar(){
        estadoTela="buscar";
}
    
}
