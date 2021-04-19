package persistence.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import persistance.util.HibernateUtil;
import persistence.entities.TStockuser;

public class StockUserDaoImpl implements StockUserDao{
	
	Session session;
	Transaction tx;

	@Override
	public void add(TStockuser entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		session.save(entity);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(TStockuser entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		session.delete(entity);
		tx.commit();
		session.close();
	}

	@Override
	public void update(TStockuser entity) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		session.update(entity);
		tx.commit();
		session.close();
	}

	@Override
	public List<TStockuser> findAll() {
		session = HibernateUtil.getSessionFactory().openSession();
		List<TStockuser> listTS = session.createQuery("from TStockuser").list();
		session.close();
		
		return listTS;
		
	}

	@Override
	public TStockuser findById(int o) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public TStockuser findUserByLoginAndPassword(String login, String password) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(TStockuser.class);
        Criterion criterionLogin = Restrictions.eq("SUsername", login);
        Criterion criterionPassword = Restrictions.eq("SPassword", password);
        criteria.add(criterionLogin);
        criteria.add(criterionPassword);
        TStockuser user = (TStockuser) criteria.uniqueResult();
        return user;
    }

}
