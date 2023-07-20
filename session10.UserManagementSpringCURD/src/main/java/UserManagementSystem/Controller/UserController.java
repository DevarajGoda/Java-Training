package UserManagementSystem.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UserManagementSystem.Domain.UserDomain;
import UserManagementSystem.ObjectCopier.ObjectCopier;
import UserManagementSystem.Service.UserService;
import UserManagementSystem.entity.User;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<UserDomain> createUser(@RequestBody User user) throws IOException, ClassNotFoundException{

		User users = userService.createUser(user);
		if (users != null) {
			UserDomain userDomain = new UserDomain();
			ObjectCopier.copyObject(user, userDomain);
			return new ResponseEntity<>(userDomain, HttpStatus.CREATED);
		}
		return new ResponseEntity<UserDomain>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDomain> getUser(@PathVariable Long id) throws IOException, ClassNotFoundException {
		User users = userService.getUser(id);
		if (users != null) {
			UserDomain userDomain = new UserDomain();
			ObjectCopier.copyObject(users, userDomain);
			return new ResponseEntity<>(userDomain, HttpStatus.OK);
		}
		return new ResponseEntity<UserDomain>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers() throws IOException, ClassNotFoundException {
		List<User> users = userService.getUsers();
		return  new ResponseEntity<List<User>>(users, HttpStatus.OK);
	 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Boolean> deleteUser(@PathVariable Long id) throws IOException, ClassNotFoundException {
		Boolean b = userService.deleteUser(id);
		return new ResponseEntity<>(b, HttpStatus.OK);
		
	}

}
