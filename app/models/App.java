package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class App extends Model {

	public String name;

	public String description;

	@ManyToOne
	public Domain domain;

	@OneToMany(mappedBy = "app", cascade = CascadeType.ALL)
	public List<Release> releases;

	public App(Domain domain, String name, String description) {
		this.domain = domain;
		this.name = name;
		this.description = description;
		this.releases = new ArrayList<Release>();
	}

	public Release addRelease(String version, String description) {
		Release release = new Release(this, version, description).save();
		this.releases.add(release);
		return release;
	}
}
