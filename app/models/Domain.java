package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Domain extends Model {

	public String name;
	
	public String description;
	
	public String serverVersion;
	
	@OneToMany(mappedBy = "domain", cascade = CascadeType.ALL)
	public List<App> apps;
	
	public Domain(String name, String description, String serverVersion){
		this.name = name;
		this.description = description;
		this.serverVersion = serverVersion;
		this.apps = new ArrayList<App>();
	}
	
	public App addApp(String name, String description){
		App app = new App(this, name, description).save();
		this.apps.add(app);
		return app;
	}

}
