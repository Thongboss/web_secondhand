package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the categories database table.
 * 
 */
@Entity
@Table(name="categories")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="ten_danhmuc")
	private String tenDanhmuc;
	
	@ManyToOne
	@JoinColumn(
		name="user_id"
	)
	private User user;
	
	@OneToMany(mappedBy = "category")
	private List<Product> products;

//	@Column(name="user_id")
//	private int userId;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Category() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenDanhmuc() {
		return this.tenDanhmuc;
	}

	public void setTenDanhmuc(String tenDanhmuc) {
		this.tenDanhmuc = tenDanhmuc;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public int getUserId() {
//		return this.userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}

}