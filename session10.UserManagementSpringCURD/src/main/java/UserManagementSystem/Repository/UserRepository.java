package UserManagementSystem.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.IdGenerator;

import UserManagementSystem.Domain.UserDomain;
import UserManagementSystem.entity.User;

@Repository
public class UserRepository {

    private final String dataDir = "data/users/";

    @Autowired
    private IdGenerator idGenerator;

    /**
     * Saves a user object to the file-based storage.
     *
     * @param user The user object to be saved.
     * @return The user object that has been saved.
     * @throws IOException If there is an I/O error during the save process.
     */
    public User save(User user) throws IOException {
        user.setId(idGenerator.generateId());
        File file = new File(dataDir + user.getId() + ".ser");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(user);
        }
        idGenerator.storeLastId();
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

    
    public void delete(Long id) throws IOException, ClassNotFoundException {
        File file = new File(dataDir + id + ".ser");
        file.delete();
    }
}