//view= metodos sao as açoes inserir , excluir, editar .  atributo =trazer informaçao para o beckend  DESCRiCAO para gravar no banco,id,LISTA DE CATEGORIA

package br.com.mercadoservicos.controller;


import br.com.mercadoservicos.domain.Categoria;
import br.com.mercadoservicos.service.CategoriaService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

// transformar managedBean  //fazer a comunicacao com as variaveis com o beckend e fazer a navegacao
@ManagedBean(name="categoriaMB")
@RequestScoped
public class CategoriaController {
    
//    private Integer id;
    private Categoria categoria = new Categoria();
    private List<Categoria> categorias;
    private CategoriaService categoriaService = new CategoriaService();
    
    public CategoriaController(){
        listar();//view vai ter referencia na MB,quando o compilador vai le vai instanciar uma categoriaController e vai passar para um construtor e a tabela vai vim prenchida.
    }
    public void listar(){
        categorias = categoriaService.Listar();//vai ser prenchida pelo service ele pede o dao e o dao buca no banco e manda para o controller.
    }
    //como faz navegaçao de jsp --vai cair na prova, BOTAO DE ACAO CADASTRAR
    public String novo(){
        return "new.xhtml?faces-redirect=true";
    }
    
    public String salva(){
        categoriaService.inserir(categoria);
        return "list.xhtml?faces-redirect=true";
    }
    
    public String voltar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public CategoriaService getCategoriaService() {
        return categoriaService;
    }

    public void setCategoriaService(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    
    
}
