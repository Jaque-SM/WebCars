
package objetos.web.entity;

import java.util.Date;
import java.util.Objects;

public class Carro {
    
    private Integer id;
    private String modelo;
    private String fabricante;
    private String cor;
    private Date ano;

    public Carro(String modelo, String fabricante, String cor, Date ano) {
         this.modelo=modelo;
         this.fabricante=fabricante;
         this.cor=cor;
         this.ano=ano;
    }

    public Carro() {
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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        return Objects.equals(this.ano, other.ano);
    }

    
    
}
