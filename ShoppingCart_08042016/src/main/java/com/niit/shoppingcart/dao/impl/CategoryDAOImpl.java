package com.niit.shoppingcart.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// create new object using a constructor

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Category> list() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	@Transactional
	public boolean save(Category category) {
		try {
			// instead of transaction and commit, we can use session.flush();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(category);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Category category) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(category);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(Category category) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(category);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// This category returns the category based on id

	@Transactional
	public Category getCategoryByID(int id) {
		// return sessionFactory.getCurrentSession().get(Category.class, id);

		// Using HQL Query:

		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where id = " + id + "")
				.uniqueResult();
	}

	public Category getCategoryByName(String name) {
		ArrayList<Category> allcategories = (ArrayList<Category>) sessionFactory.getCurrentSession()
				.createQuery("from Category where name = '" + name + "'").list();

		return allcategories.get(0);

	}

}
