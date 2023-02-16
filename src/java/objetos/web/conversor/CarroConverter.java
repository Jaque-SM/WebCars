
package objetos.web.conversor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import objetos.web.entity.Carro;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import objetos.web.CrudJPA.CarroCrud;
import objetos.web.bean.CarroBean;
import objetos.web.entity.Fabricante;


@FacesConverter("CarroConverter")
public class CarroConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       
        if (value==null||value.isEmpty()){
            return null;
        }
        try {
            return findIdObject(value);
            
        } catch (NumberFormatException e) {
          throw new ConverterException(new FacesMessage(("this is not a valid car id")), e);
    
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
            if (value==null||value.equals("")){
                return "";
            }
                    
        return "";
    
    }

    private Fabricante findIdObject(String value) {
        CarroCrud ava=new CarroCrud();  
        List<Fabricante> fabs=ava.buscarB();
          Iterator<Fabricante> iterator = fabs.iterator();
          while (iterator.hasNext()){
              
              Fabricante fab=iterator.next();
              if (fab.getNome().equals(value)){
                  return fab;
              }
          }
        return null;
    }
    
}
