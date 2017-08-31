package com.revature.beans;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class BookBean {
	
	@Override
	public String toString() {
		return "BookBean [d3Id=" + d3Id + ", title=" + title + ", author=" + author + ", description=" + description
				+ ", genre=" + genre + ", quantity=" + quantity + ", user=" + user + "]";
	}

	@Id
	@Column(name="BOOK_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="book_id_seq")
	@SequenceGenerator(name="book_id_seq", sequenceName="BOOK_ID_SEQ")
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

	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="CHECKOUT")
	//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
	@JsonIgnore
	private Set<UserBean> user;
	

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

	public Set<UserBean> getUser() {
		return user;
	}

	public void setUser(Set<UserBean> user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookBean other = (BookBean) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
}
