package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Category;
import entities.Product;
import entities.User;
import utils.JpaUtil;

public class ProductDAO {
	private EntityManager pro;
	
	public ProductDAO() {
		this.pro = JpaUtil.getEntityManager();
	}

	public Product create(Product product) throws Exception {
		try {
			this.pro.getTransaction().begin();

			this.pro.persist(product);

			this.pro.getTransaction().commit();

			return product;
		} catch (Exception e) {
			e.printStackTrace();
			this.pro.getTransaction().rollback();
			throw e;
		}
	}
	
	public List<Product> all(){
		String jpql = "SELECT o FROM Product o";
		TypedQuery<Product> query = this.pro.createQuery(jpql, Product.class);
		List<Product> result = query.getResultList();
		return result;
	}
	
	public Product findById(int id) {
		return this.pro.find(Product.class, id);
	}
	
	public Product delete(Product entity) throws Exception {
		try {
			this.pro.getTransaction().begin();
			
			this.pro.remove(entity); 
			
			this.pro.getTransaction().commit();
			
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			this.pro.getTransaction().rollback();
			throw e;
		}
	}
	
	public Product update(Product entity)throws Exception {
		try {
			this.pro.getTransaction().begin();
			
			this.pro.merge(entity);
			
			this.pro.getTransaction().commit();
			
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			this.pro.getTransaction().rollback();
			throw e;
		}
	}
	
	public List<Product> findBycate(String cate) {
		String jpql = "SELECT c FROM Category c"
			+ " WHERE c.tenDanhmuc = :cate";

		TypedQuery<Category> query = this.pro
					.createQuery(jpql, Category.class);
		query.setParameter("cate", cate);
		
		Category cat = query.getSingleResult();
		
		List<Product> result = cat.getProducts();

		return result;
	}
}
