public class Credentials {

    private String myUsername;
    private String myPassword;
    private String myEmail;

    public Credentials(){       //default constructor
        myUsername = myPassword = myEmail = "";
    }
    public Credentials(String username, String password, String email){       //fill constructor
        myUsername = username;
        myPassword = password;
        myEmail = email;
    }

    //sets
    public void setMyUsername(String username){
        myUsername = username;
    }
    public void setMyPassword(String password){
        myPassword = password;
    }
    public void setMyEmail(String email){ myEmail = email; }

    //gets
    public String getMyUsername(){
        return myUsername;
    }
    public String getMyPassword(){
        return myPassword;
    }
    public String getMyEmail() { return myEmail; }

    //tostring
    public String toString(){
        return ("Email: " + myEmail + " Username: " + myUsername + "Password: " + myPassword);
    }
}
