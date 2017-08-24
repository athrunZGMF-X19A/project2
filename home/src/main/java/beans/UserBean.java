package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * UserBean
 *
 */


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
	@OneToMany
	@JoinTable(name="CHECKOUT")
	private BookBean book;
	
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
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

	public BookBean getBook() {
		return book;
	}

	public void setBook(BookBean book) {
		this.book = book;
	}
	
	
}
