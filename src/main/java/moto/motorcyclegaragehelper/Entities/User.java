package moto.motorcyclegaragehelper.Entities;

import jakarta.persistence.*;

import java.util.List;
/** This is an Entity class for Users
 * The class is used for storing data in its column
 * Each column has its respective getters and setters*/

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(unique = true, name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column
    private String email;

    //Joins One user to Motorcycles
    @OneToMany(mappedBy = "user")
    private List<Motorcycle> motorcycles;

    public User() {}

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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


    public long getId() {
        return id;
    }
}
