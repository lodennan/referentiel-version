package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Release extends Model {

	@Required
	public String version;

	@Required
	@Lob
	public String description;

	@Required
	public Date date;

	@ManyToOne
	public App app;

	public Release(App app, String version, String description) {
		this.app = app;
		this.version = version;
		this.description = description;
		this.date = new Date();
	}
}
