package at.htl.nvs;

import at.htl.nvs.entities.User;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {

    private List<User> userList;
    private Verify verify;

    public EntityManager(Verify verify){
        userList = new ArrayList<User>();
        this.verify = verify;
    }

    public boolean addUser(String username, String password){
        if(verify.verifyPassword(password)){
            User user = new User(username, password);
            userList.add(user);
            return true;
        }
        return false;
    }

}
