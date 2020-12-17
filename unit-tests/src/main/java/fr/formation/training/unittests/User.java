package fr.formation.training.unittests;

public class User {

    private String username;

    public User(String username) {
	if (username == null) { // null
	    throw new IllegalArgumentException();
	}
	this.username = username;
    }

    public String getUsername() {
	return username;
    }
}
