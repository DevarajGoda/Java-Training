package session7.OnlineBiddingSystem;

import java.util.ArrayList;
import java.util.List;

public class UserManagementService {
	
	private List<User> users;
	private User currentuser;

	public User getUser() {
		return currentuser;
	}

	public void setUser(User user) {
		this.currentuser = user;
	}

	public UserManagementService() {
		this.users = new ArrayList<>();
	}

	public void createUser(String username, String password) {
		User user = new User(username, password);
		users.add(user);
	}

	public User authenticateUser(String username, String password) {
		// Authenticate user and return user object
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				currentuser=user;
				return user;
			}
		}
		return null; 
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}