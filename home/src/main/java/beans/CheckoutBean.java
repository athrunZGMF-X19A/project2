package beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.ForeignKey;
import org.springframework.web.bind.annotation.Mapping;

@Entity
public class CheckoutBean {
	
	
	private int bookId;
	
	private int userId;
	
	private boolean checkedOut;
	

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isCheckedOut() {
		return checkedOut;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

}
