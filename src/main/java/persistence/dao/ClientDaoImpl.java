package persistence.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import persistance.util.HibernateUtil;
import persistence.entities.TClient;

public class ClientDaoImpl implements ClientDao{

	
	private Session session;
	private Transaction tx;
	
	@Override
	public void add(TClient entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		session.save(entity);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(TClient entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		session.delete(entity);
		tx.commit();
		session.close();
	}

	@Override
	public void update(TClient entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		session.update(entity);
		tx.commit();
		session.close();
	}

	@Override
	public List<TClient> findAll() {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		List<TClient> listC = session.createQuery("from TClient").list();
		session.close();
		return listC;
	}

	@Override
	public TClient findById(int o) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		TClient client = session.load(TClient.class, (Serializable) o);
		session.close();
		return client;
	}

	public List<TClient> findByNom(String nom) {
	        List<TClient> list = new ArrayList<TClient>();
	        try (Session session = HibernateUtil.getSessionFactory().openSession()){
	            Criteria criteria = session.createCriteria(TClient.class);
	            Criterion criterion = Restrictions.eq("CNomclient", nom);
	            criteria.add(criterion);
	            list = criteria.list();
	            return list;
	        }
	}
	
	public List<TClient> findByPrenom(String prenom) {
        List<TClient> list = new ArrayList<TClient>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Criteria criteria = session.createCriteria(TClient.class);
            Criterion criterion = Restrictions.eq("CPrenomclient", prenom);
            criteria.add(criterion);
            list = criteria.list();
            return list;
        }
        
	}
	
	public List<TClient> findByDate(String date) {
        List<TClient> list = new ArrayList<TClient>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Criteria criteria = session.createCriteria(TClient.class);
            Criterion criterion = Restrictions.eq("CDatenaissanceclient", date);
            criteria.add(criterion);
            list = criteria.list();
            return list;
        }
        
	}

}
