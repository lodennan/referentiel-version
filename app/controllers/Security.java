package controllers;

import models.User;

public class Security extends Secure.Security {

	/**
	 * Authentification
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	static boolean authenticate(String username, String password) {
		return User.connect(username, password) != null;
	}


	/**
	 * A la déconnexion, l'utilisateur est redirigé vers la page d'accueil
	 */
	static void onDisconnected() {
		Application.index();
	}

	
	static boolean check(String profile) {
	    if("admin".equals(profile)) {
	        return User.find("byEmail", connected()).<User>first().isAdmin;
	    }
	    return false;
	}
}
