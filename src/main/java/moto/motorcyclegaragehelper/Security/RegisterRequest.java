package moto.motorcyclegaragehelper.Security;
/** This is a Component class for Registration Requests
 * The class is used for getting passwords and usernames and emails entered during registration
 * This class is used in authentication requests*/
public class RegisterRequest
{
    private String username;
    private String password;
    private String email;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
}
