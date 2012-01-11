package controllers;

import java.util.List;

import models.App;
import models.Domain;
import models.Release;
import play.mvc.Controller;

public class Application extends Controller {

	public static void index() {
		List<Domain> domains = Domain.findAll();
		render(domains);
	}

	public static void addDomain(String name, String description,
			String serverVersion) {
		Domain domain = new Domain(name, description, serverVersion);
		domain.save();
		Application.index();
	}

	public static void apps(Long domainId) {
		Domain domain = Domain.findById(domainId);
		List<App> apps = domain.apps;
		render(domain, apps);
	}

	public static void addApp(Long domainId, String name, String description) {
		Domain domain = Domain.findById(domainId);
		domain.addApp(name, description);
		Application.apps(domainId);
	}

	public static void releases(Long appId) {
		App app = App.findById(appId);
		List<Release> releases = app.releases;
		render(app, releases);
	}

	public static void addRelease(Long appId, String version, String description) {
		App app = App.findById(appId);
		app.addRelease(version, description);
		Application.releases(appId);
	}

}