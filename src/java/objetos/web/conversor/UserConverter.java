package objetos.web.conversor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import objetos.web.CrudJPA.CarroCrud;
import objetos.web.entity.Carro;
import objetos.web.entity.Fabricante;


@FacesConverter("UsuarioConverter")
public class UserConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {         

        if (value==null||value.isEmpty()){
            return null;
        }
        try {
         
            return findIdObject(value);
        } catch (NumberFormatException e) {
          throw new ConverterException(new FacesMessage(("este é um id invalido de carro")), e);
            
        }
      
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
            
        return "";
    }

    private List<Carro> findIdObject(String value) {
        CarroCrud ava=new CarroCrud();
        List<Carro> cars=ava.buscarJPA();
               
        List<Carro> novoList=new ArrayList<>();
        
      Iterator<Carro> iterator = cars.iterator();
         while (iterator.hasNext()){
              
              Carro carros=iterator.next();
              if (carros.getModelo().equals(value)){
                  novoList.add(carros);
                  
                  return novoList;
              }
          }       
        return null;
    }

    
}
