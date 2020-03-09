package br.com.mercadoservicos.dao;

import br.com.mercadoservicos.domain.Categoria;
import br.com.mercadoservicos.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class CategoriaDao {
    
    public List<Categoria> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            List<Categoria> categorias = session.createQuery("from Categoria order by descricao").list();     //traz a lista de categoria 
            session.getTransaction().rollback();            //se der algo errado, desfaz tudo q foi feito no banco 
            return categorias;
         }catch(Exception e){
            e.printStackTrace();                            //Imprimindo o erro no console. 
            session.getTransaction().rollback();            //se der algo errado, desfaz tudo q foi feito no banco 
            return null;
        }
    }
    
    
    public Categoria consultar(Integer id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();             //abrindo 'negociação' c o banco de dados. 
        try{
            Categoria categoria = (Categoria) session.createQuery("from Categoria where id = " + id).uniqueResult();
            session.getTransaction().commit();   
            return categoria;
        }catch(Exception e){
            e.printStackTrace();                            //Imprimindo o erro no console. 
            session.getTransaction().rollback();            //se der algo errado, desfaz tudo q foi feito no banco 
            return null;
        }
    }
    
    
    
    
    
    public boolean inserir(Categoria categoria) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();             //abrindo 'negociação' c o banco de dados. 
        try{
            session.save(categoria);
            session.getTransaction().commit();              //se todas as informações estiverem corretas, salva tudo no banco. 
            return true;
        }catch(Exception e){
            e.printStackTrace();                            //Imprimindo o erro no console. 
            session.getTransaction().rollback();            //se der algo errado, desfaz tudo q foi feito no banco 
            return false;
        }
    }

    
    public boolean alterar(Categoria categoria) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();             //abrindo 'negociação' c o banco de dados. 
        try{
            session.update(categoria);
            session.getTransaction().commit();              //se todas as informações estiverem corretas, salva tudo no banco. 
            return true;
        }catch(Exception e){
            e.printStackTrace();                            //Imprimindo o erro no console. 
            session.getTransaction().rollback();            //se der algo errado, desfaz tudo q foi feito no banco 
            return false;
        }
    }
    
     public boolean excluir(Categoria categoria) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();             //abrindo 'negociação' c o banco de dados. 
        try{
            session.delete(categoria);
            session.getTransaction().commit();              //se todas as informações estiverem corretas, salva tudo no banco. 
            return true;
        }catch(Exception e){
            e.printStackTrace();                            //Imprimindo o erro no console. 
            session.getTransaction().rollback();            //se der algo errado, desfaz tudo q foi feito no banco 
            return false;
        }
    }

}