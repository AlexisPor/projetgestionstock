package persistence.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import persistance.util.HibernateUtil;
import persistence.entities.TCommande;

public class CommandeDaoImpl implements CommandeDao {
	
	private Session session;
	private Transaction tx;

	@Override
	public void add(TCommande entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		session.save(entity);
		tx.commit();
		session.close();
		
	}

	@Override
	public void delete(TCommande entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		session.delete(entity);
		tx.commit();
		session.close();
		
	}

	@Override
	public void update(TCommande entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		session.update(entity);
		tx.commit();
		session.close();
		
	}

	@Override
	public List<TCommande> findAll() {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		List<TCommande> listC = session.createQuery("from TCommande").list();
		session.close();
		return listC;
	}

	@Override
	public TCommande findById(int o) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		TCommande co = session.load(TCommande.class, (Serializable) o);
		
		session.close();
		return co;
	}

	public List<TCommande> findByDate(Date dDebut,Date dFin) {
	    List<TCommande> list = new ArrayList<TCommande>();
	    try (Session session = HibernateUtil.getSessionFactory().openSession()){
	        Criteria criteria = session.createCriteria(TCommande.class);
	        Criterion criterion = Restrictions.between("CDatecommande", dDebut, dFin);
	        criteria.add(criterion);
	        list = criteria.list();
	        return list;
			}

	}
	public List<TCommande> findByEtat(BigDecimal etat) {
	    List<TCommande> list = new ArrayList<TCommande>();
	    try (Session session = HibernateUtil.getSessionFactory().openSession()){
	        Criteria criteria = session.createCriteria(TCommande.class);
	        Criterion criterion = Restrictions.eq("CEtatcommande", etat);
	        criteria.add(criterion);
	        list = criteria.list();
	        return list;
			}

	}
	
}
