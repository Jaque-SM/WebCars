
package objetos.web.entity;

public class Carro {
    
    private String modelo;
    private String fabricante;
    private String cor;
    private Integer ano;

    public Carro(String modelo, String fabricante, String cor, Integer ano) {
         this.modelo=modelo;
         this.fabricante=fabricante;
         this.cor=cor;
         this.ano=ano;
    }

    public Carro() {
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

    public Integer getAno() {
        return ano;
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

    public void setAno(Integer ano) {
        this.ano = ano;
    }
    
   
    
}
