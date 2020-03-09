
package br.com.mercadoservicos.service; // e a unica que vai comunicar com o dao , cria regra de negocio 

import br.com.mercadoservicos.dao.CategoriaDao;
import br.com.mercadoservicos.domain.Categoria;
import java.util.List;



public class CategoriaService {
    
    CategoriaDao categoriaDao = new CategoriaDao();
    
    public List<Categoria> Listar(){
        return categoriaDao.listar();
    }
    public Categoria consultar(Integer id){
       return categoriaDao.consultar(id);
    }
    public boolean inserir(Categoria categoria){
        return categoriaDao.inserir(categoria);
    }
    public boolean alterar(Categoria categoria){
        return categoriaDao.alterar(categoria);
    }
    public boolean excluir(Categoria categoria){
        return categoriaDao.excluir(categoria);
    }
   
    
}
