package UserManagementSystem.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UserManagementSystem.Domain.UserDomain;
import UserManagementSystem.Repository.UserRepository;
import UserManagementSystem.entity.User;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;

    public User createUser(User user) throws IOException {
        user.setId(System.currentTimeMillis());
        return userRepository.save(user);
    }

    public User getUser(Long id) throws IOException, ClassNotFoundException {
        return userRepository.findById(id);
    }

    public List<User> getUsers() throws IOException, ClassNotFoundException {
        return userRepository.findAll();
    }

	public Boolean deleteUser(Long id) throws ClassNotFoundException, IOException {
		return userRepository.deleteUser(id);
	}

}
