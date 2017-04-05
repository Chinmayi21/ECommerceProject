package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<User> list() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User getUser(String id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public User getUserByName(String Name) {

		return (User) sessionFactory.getCurrentSession().createQuery("from Supplier where name = '" + Name + "'")
				.list();
	}

	public boolean save(User user) {
		try {
			// instead of transaction and commit, we can use session.flush();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			user.setRole("role_user"); // to set the default value as user
			user.setEnabled(true);
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(User user) {
		try {
			// instead of transaction and commit, we can use session.flush();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(user);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean validate(String id, String password) {

		// select * from user where id = ' ' and password = ' ' -> implement

		String hql = "from User where id = '" + id + "' and password = '" + password + "'";

		if (getSession().createQuery(hql).uniqueResult() == null) {
			return false;
		} else
			return true;
	}

	public boolean delete(String Id) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(getUser(Id));
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(User user) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
