package br.com.mercadoservicos.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name="categoria")          //identificar a tabela do banco

public class Categoria implements Serializable{            //deve ser identica as colunas e linhas da tabela do banco de dados
    
    @Id                             //dizendo que a variavel é do tipo id (chave primaria)
    @GeneratedValue(strategy=GenerationType.IDENTITY)                 //o campo id é gerado automaticamente (incremenal)
    private Integer id;
    
    @NotNull                                   //a informação não pode ser nula.
    @Size(min=1, max=45)                        //definindo o tamanho da variavel. 
    @Column(name="descricao")                 //se a coluna do banco tiver o mesmo nome da variavel, não precisa. 
    private String descricao;

    public Categoria(){
    }
    
    public Categoria(Integer id, String descricao){
        this.id = id;
        this.descricao = descricao;  
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override                               //compara os objetos pelo id e não pela memoria
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
        final Categoria other = (Categoria) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", descricao=" + descricao + '}';
    }
    
    

}
