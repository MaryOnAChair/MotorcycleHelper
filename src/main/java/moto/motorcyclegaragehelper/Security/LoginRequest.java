package moto.motorcyclegaragehelper.Security;

import org.springframework.stereotype.Component;
/** This is a Component class for Login Requests
 * The class is used for getting passwords and usernames entered during login
 * This class is used in authentication requests*/

@Component
public class LoginRequest {

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
