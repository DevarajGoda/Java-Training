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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UserManagementSystem.Domain.UserDomain;
import UserManagementSystem.ObjectCopier.ObjectCopier;
import UserManagementSystem.Service.UserService;
import UserManagementSystem.entity.User;
@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    
    @GetMapping(value = "/user")
    public ResponseEntity<List<User>> getUsers() throws IOException, ClassNotFoundException {
        List<User> listUsers = userService.getUsers();
        return new ResponseEntity<>(listUsers, HttpStatus.OK);
    }

    
    @PutMapping(value= "/{id}")
    public ResponseEntity<UserDomain> updateUser(@PathVariable(value = "id") Long id, @RequestBody User user)
            throws ClassNotFoundException, IOException {
        try {
            User updatedUser = userService.updateUser(id, user);
            if (updatedUser != null) {
                UserDomain userDomain = new UserDomain();
                ObjectCopier.copyObject(updatedUser, userDomain);
                return new ResponseEntity<>(userDomain, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (FileNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

     
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deleteUserId(@PathVariable(value = "id") Long id)
            throws ClassNotFoundException, IOException {
        try {
        	userService.deleteUser(id);
            return ResponseEntity.ok().build();
        } catch (FileNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}