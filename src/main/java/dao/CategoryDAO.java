package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Category;
import entities.Product;
import entities.User;
import utils.JpaUtil;

public class CategoryDAO {
	private EntityManager ca;

	public CategoryDAO() {
		this.ca = JpaUtil.getEntityManager();
	}

	public Category create(Category cate) throws Exception {
		try {
			this.ca.getTransaction().begin();

			this.ca.persist(cate);

			this.ca.getTransaction().commit();

			return cate;
		} catch (Exception e) {
			e.printStackTrace();
			this.ca.getTransaction().rollback();
			throw e;
		}
	}
	
	public List<Category> all(){
		String jpql = "SELECT o FROM Category o";
		TypedQuery<Category> query = this.ca.createQuery(jpql, Category.class);
		List<Category> result = query.getResultList();
		return result;
	}
	
	public Category findById(int id) {
		return this.ca.find(Category.class, id);
	}
	
	public Category delete(Category entity) throws Exception {
		try {
			this.ca.getTransaction().begin();
			
			this.ca.remove(entity); 
			
			this.ca.getTransaction().commit();
			
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			this.ca.getTransaction().rollback();
			throw e;
		}
	}
	
	public Category update(Category entity)throws Exception {
		try {
			this.ca.getTransaction().begin();
			
			this.ca.merge(entity);
			
			this.ca.getTransaction().commit();
			
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			this.ca.getTransaction().rollback();
			throw e;
		}
	}
	
	public Category findBycate(String tenDanhmuc) {
		String jpql = "SELECT c FROM Category c"
			+ " WHERE c.tenDanhmuc = :tenDanhmuc";

		TypedQuery<Category> query = this.ca
					.createQuery(jpql, Category.class);
		query.setParameter("tenDanhmuc", tenDanhmuc);
		

		return query.getSingleResult();
	}
	
	
}
