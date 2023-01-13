
package objetos.web.entity;

import java.util.Objects;


public class Usuario {
    
    private Integer id;
    private String usuario;
    private String senha;

    public Usuario(Integer id, String usuario, String senha) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario() {
    }
    
    

    public Integer getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.usuario);
        hash = 29 * hash + Objects.hashCode(this.senha);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    
    
    
    
    
    
    
    
}
