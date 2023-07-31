package UserManagementSystem.Controller;

import java.io.FileNotFoundException;
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
@RequestMapping("/api/User")
public class UserController {

	@Autowired
	private UserService userService;

	   @PostMapping()
	    public ResponseEntity<UserDomain> createUser(@RequestBody User user) throws IOException {
	        User createdUser = userService.createUser(user);
	        if (createdUser != null) {
	            UserDomain userDomain = new UserDomain();
	            ObjectCopier.copyObject(createdUser, userDomain);
	            return new ResponseEntity<>(userDomain, HttpStatus.CREATED);
	        }
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    }

	   
	    @GetMapping("/{id}")
	    public ResponseEntity<UserDomain> getUser(@PathVariable(value = "id") Long id)
	            throws ClassNotFoundException, IOException {
	        try {
	            User user = userService.getUser(id);
	            if (user != null) {
	                UserDomain userDomain = new UserDomain();
	                ObjectCopier.copyObject(user, userDomain);
	                return new ResponseEntity<>(userDomain, HttpStatus.OK);
	            } else {
	                return ResponseEntity.notFound().build();
	            }
	        } catch (FileNotFoundException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	     
	    @GetMapping()
	    public ResponseEntity<List<UserDomain>> getUsers() throws IOException, ClassNotFoundException {
	        List<UserDomain> listuserDomain = new ArrayList<>();
	        List<User> listUsers = userService.getUsers();
	        if (!listUsers.isEmpty()) {
	            for (User user : listUsers) {
	                UserDomain userDomain = new UserDomain();
	                ObjectCopier.copyObject(user, userDomain);
	                userDomain.setId(user.getId());
	                userDomain.setUsername(user.getUsername());
	                userDomain.setFirstName(user.getFirstName());
	                userDomain.setLastName(user.getLastName());
	                userDomain.setEmail(user.getEmail());
	                listuserDomain.add(userDomain);
	            }
	        }
	        return new ResponseEntity<>(listuserDomain, HttpStatus.OK);
	    }
}
