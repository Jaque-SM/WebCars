package objetos.web.model;

import java.util.List;
import javax.faces.model.ListDataModel;
import objetos.web.entity.Fabricante;
import org.primefaces.model.SelectableDataModel;

public class FabricanteDataModel extends ListDataModel<Fabricante>  implements SelectableDataModel<Fabricante>  {

    public FabricanteDataModel() {
        
    }
    
    public FabricanteDataModel(List<Fabricante> dados) {
        super(dados);
    }

    @Override
    public Fabricante getRowData(String string) {
       List<Fabricante> fabsd = (List<Fabricante>) getWrappedData();

         for(Fabricante fab : fabsd) {
            if(fab.getId().toString().equals(string));
                return fab;
        }

       
        return null;
    }

    @Override
    public Object getRowKey(Fabricante t) {
         
        return t.getId();

    }
    
}
