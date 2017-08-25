package beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class BookBean {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int d3Id;
	@NotBlank
	private String title;
	@NotBlank
	private String author;
	@NotBlank
	private String description;
	@NotBlank
	private String genre;
	
	private int quantity;

	//private List<UserBean> user;
	

	public BookBean() {
		super();
	}

	public BookBean(int d3Id, String title, String author, String description, String genre, int quantity) {
		super();
		this.d3Id = d3Id;
		this.title = title;
		this.author = author;
		this.description = description;
		this.genre = genre;
		this.quantity = quantity;
	}

	public int getD3Id() {
		return d3Id;
	}

	public void setD3Id(int d3Id) {
		this.d3Id = d3Id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
