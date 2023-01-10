
package objetos.web.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import objetos.web.dao.CarroDAO;
import objetos.web.entity.Carro;
import objetos.web.util.exception.ErroSistema;

@SessionScoped
@ManagedBean
public class CarroBean{
    
    private Carro carro=new Carro();
    
    private List<Carro> carros=new ArrayList<>();;
    
    private CarroDAO carrodao=new CarroDAO();
    
   
    public void AddCars(){
        try {
            // carros.add(carro);
            new CarroDAO().salvar(carro);
            carro=new Carro();
         addMensagem("Salvo!", "Carro salvo com sucesso", FacesMessage.SEVERITY_INFO);

        } catch (ErroSistema ex) {
             addMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);

        }
        carro=new Carro();
    }
    
    public void ListarCars(){
        try {
            carros=carrodao.buscarCarro();
            
            if (carros==null||carros.size()==0){
               addMensagem("Nenhum dado encontrado", "Não existe um carro com esse ID", FacesMessage.SEVERITY_WARN);
            }
        } catch (ErroSistema ex) {
            addMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }   
        
    }
    
    public void deletar(Carro c){
        try {
            carrodao.deletar(c.getId());
        } catch (ErroSistema ex) {
          addMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);

        }
    }
    
    public void Editar(Carro c){
        carro=c;
    }
    
    public void  addMensagem(String sumario, String detalhe, FacesMessage.Severity tipoErro){
        FacesContext context=FacesContext.getCurrentInstance();
        FacesMessage message=new FacesMessage(tipoErro, sumario, detalhe);
        
        context.addMessage(null, message);
    }

    public Carro getCarro() {
        return carro;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
    
    
}
