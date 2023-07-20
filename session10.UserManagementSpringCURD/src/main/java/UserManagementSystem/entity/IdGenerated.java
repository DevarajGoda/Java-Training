package UserManagementSystem.entity;

import org.springframework.stereotype.Component;

@Component
public class IdGenerated {
	  private Long lastId = 0L;
	public synchronized Long generateId() {
        
		lastId++;
        return lastId;
    }

    // Method to store the last generated ID (you can customize the storage mechanism)
    public synchronized void storeLastId() {
        // For simplicity, we will just print the lastId here.
        System.out.println("Last generated ID: " + lastId);
    }

}
