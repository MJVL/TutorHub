public class Credentials {

    private String myUsername;
    private String myPassword;

    public Credentials(){       //default constructor
        myUsername = myPassword = "";
    }
    public Credentials(String username, String password){       //fill constructor
        myUsername = username;
        myPassword = password;
    }

    //sets
    public void setMyUsername(String username){
        myUsername = username;
    }
    public void setMyPassword(String password){
        myPassword = password;
    }

    //gets
    public String getMyUsername(){
        return myUsername;
    }
    public String getMyPassword(){
        return myPassword;
    }

    //tostring
    public String toString(){
        return ("Username: " + myUsername + "Password: " + myPassword);
    }
}
