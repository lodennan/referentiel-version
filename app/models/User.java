package models;

import javax.persistence.Entity;

import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class User extends Model {

	@Required
	public String name;

	@Email
	@Required
	public String email;

	@Required
	public String password;

	public boolean isAdmin;

	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public static User connect(String email, String password) {
		return find("byEmailAndPassword", email, password).first();
	}

	@Override
	public String toString() {
		return name + " [" + email + "]";
	}

}
