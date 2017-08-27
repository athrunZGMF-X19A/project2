package beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;


@Entity
public class UserBean {
	@Id
	@Min(value=0)
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotBlank
	private String username;
	
	@DecimalMin(value="0")
	private int numberOfBooks;
	
	@OneToMany(targetEntity=BookBean.class)
	@JoinColumn(name="Book_Id", referencedColumnName="BOOK_ID", nullable=false)
	private List<BookBean> books;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getNumberOfBooks() {
		return numberOfBooks;
	}

	public void setNumberOfBooks(int numberOfBooks) {
		this.numberOfBooks = numberOfBooks;
	}

	public List<BookBean> getBooks() {
		return books;
	}

	public void setBooks(List<BookBean> books) {
		this.books = books;
	}

	public UserBean() {
		super();
		
	}

	public UserBean(int id, String username, int numberOfBooks, List<BookBean> books) {
		super();
		this.id = id;
		this.username = username;
		this.numberOfBooks = numberOfBooks;
		this.books = books;
	}
	
	
	
}
