
package objetos.web.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Carro {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String modelo;
    private String fabricante;
    private String cor;
    private Date ano;
    
    @OneToOne(cascade= CascadeType.PERSIST)
    private Fabricante fab=new Fabricante();


    public Carro(Integer id,String modelo, String fabricante, String cor, Date ano, Fabricante fab) {
         this.id=id;
         this.modelo=modelo;
         this.fabricante=fabricante;
         this.cor=cor;
         this.ano=ano;
         this.fab=fab;
    }
    public Carro (){
    }
 

    public Integer getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getCor() {
        return cor;
    }

    public Date getAno() {
        return ano;
    }

    public Fabricante getFab() {
        return fab;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public void setFab(Fabricante fab) {
        this.fab = fab;
    }

   
    
    
    
}
