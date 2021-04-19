package persistence.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistance.util.HibernateUtil;
import persistence.entities.TCategorie;

public class CategorieDaoImpl implements CategorieDao{

	
	private Session session;
	private Transaction tx;

	@Override
	public List<TCategorie> findAll() {
		session = HibernateUtil.getSessionFactory().openSession();
		
		List<TCategorie> listC = session.createQuery("from TCategorie").list();
		session.close();
		
		return listC;
		
	}

	@Override
	public TCategorie findById(int o) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		TCategorie cate = session.load(TCategorie.class, (Serializable) o);
		
		return cate;
		
	}

	@Override
	public void add(TCategorie entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		session.save(entity);
		tx.commit();
		session.close();
		
	}

	@Override
	public void delete(TCategorie entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		session.delete(entity);
		tx.commit();
		session.close();
		
	}

	@Override
	public void update(TCategorie entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		session.update(entity);
		tx.commit();
		session.close();
	}

}
