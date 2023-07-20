package UserManagementSystem.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import UserManagementSystem.Domain.UserDomain;
import UserManagementSystem.entity.IdGenerated;
import UserManagementSystem.entity.User;

@Repository
public class UserRepository {
	
	private final String dataDir = "data/users/";
	
	private final IdGenerated idGenerated = new IdGenerated();
	
    public User save(User user) throws IOException {  
    	user.setId(idGenerated.generateId());
        File file = new File(dataDir + user.getId() + ".ser");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(user);
        }
        idGenerated.storeLastId();
        return user;
    }

    public User findById(Long id) throws IOException, ClassNotFoundException {
        File file = new File(dataDir + id + ".ser");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (User) in.readObject();
        }
    }

    public List<User> findAll() throws IOException, ClassNotFoundException {
        List<User> users = new ArrayList<>();
        File dir = new File(dataDir);
        for (File file : dir.listFiles()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                users.add((User) in.readObject());
            }
        }
        return users;
    }
    
    public Boolean deleteUser(Long id) throws IOException, ClassNotFoundException {
    	  File file = new File(dataDir + id + ".ser");
    	  if(id != null) {
    	 return file.delete();
    	  }
    	  else {
    		  System.out.println("File not exit");
    	  }
		return false;
    }
    

}
