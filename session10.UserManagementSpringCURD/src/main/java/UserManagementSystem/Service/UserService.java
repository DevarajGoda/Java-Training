package UserManagementSystem.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UserManagementSystem.Domain.UserDomain;
import UserManagementSystem.Repository.UserRepository;
import UserManagementSystem.entity.User;

@Service
public interface UserService {

	
	public User createUser(User user) throws IOException;
	
	public User updateUser(Long id, User user) throws IOException, ClassNotFoundException;
	
	public User getUser(Long id) throws IOException, ClassNotFoundException;
	
	public List<User> getUsers() throws IOException, ClassNotFoundException;
	
	public void deleteUser(Long id) throws IOException, ClassNotFoundException;
}
