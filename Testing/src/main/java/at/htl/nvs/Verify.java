package at.htl.nvs;

public class Verify {

    public boolean verifyPassword(String password){
        if(password.length() < 6){
            return false;
        }
        return true;
    }
}
