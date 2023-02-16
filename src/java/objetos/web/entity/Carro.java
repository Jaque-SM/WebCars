
package objetos.web.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;


@Entity
@Table(name="carro")
public class Carro implements Serializable {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "modelo")
    private String modelo;
    
    @Column(name = "fabricante")
    private String fabricante;
    
    @Column(name = "cor")
    private String cor;
    
    @Column(name = "ano")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ano;
    
    @OneToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name="fab_id")
    private Fabricante fab;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario user;

    public Carro(Integer id,String modelo, String fabricante, String cor, Date ano, Fabricante fab, Usuario user) {
         this.id=id;
         this.modelo=modelo;
         this.fabricante=fabricante;
         this.cor=cor;
         this.ano=ano;
         this.fab=fab;
         this.user=user;
    }
    public Carro (){
        this.fab=new Fabricante();
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

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.fabricante, other.fabricante)) {
            return false;
        }
        if (!Objects.equals(this.cor, other.cor)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        if (!Objects.equals(this.fab, other.fab)) {
            return false;
        }
        return Objects.equals(this.user, other.user);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.modelo);
        hash = 53 * hash + Objects.hashCode(this.fabricante);
        hash = 53 * hash + Objects.hashCode(this.cor);
        hash = 53 * hash + Objects.hashCode(this.ano);
        hash = 53 * hash + Objects.hashCode(this.fab);
        hash = 53 * hash + Objects.hashCode(this.user);
        return hash;
    }
  
   
    
}
