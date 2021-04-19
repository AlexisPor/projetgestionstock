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
import persistence.entities.TProduit;

public class ProduitDaoImpl implements ProduitDao{
	
	private Session session;
	private Transaction tx;

	@Override
	public void add(TProduit entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		session.save(entity);
		tx.commit();
		session.close();
		
	}

	@Override
	public void delete(TProduit entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		session.delete(entity);
		tx.commit();
		session.close();
	}

	@Override
	public void update(TProduit entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		session.update(entity);
		tx.commit();
		session.close();
	}

	@Override
	public List<TProduit> findAll() {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		List<TProduit> listP = session.createQuery("from TProduit").list();
		session.close();
		
		return listP;
	}

	@Override
	public TProduit findById(int o) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		TProduit prod = session.load(TProduit.class, (Serializable) o);
		session.close();
		return prod;
	}

	public List<TProduit> findByDesign(String design) {
        List<TProduit> list = new ArrayList<TProduit>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Criteria criteria = session.createCriteria(TProduit.class);
            Criterion criterion = Restrictions.like("PDesigproduit", design);
            criteria.add(criterion);
            list = criteria.list();
            return list;
        	}
	}

	public List<TProduit> findByMarque(String marque) {
    List<TProduit> list = new ArrayList<TProduit>();
    try (Session session = HibernateUtil.getSessionFactory().openSession()){
        Criteria criteria = session.createCriteria(TProduit.class);
        Criterion criterion = Restrictions.like("PMarqueproduit", marque);
        criteria.add(criterion);
        list = criteria.list();
        return list;
		}
    
	}
	
}
