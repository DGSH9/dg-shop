package com.sheryians.major.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@Table(name="users")
//@Data is for we dont have to write getter and setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty()
    @Column(nullable = false)
    private String firstName;
    private String lastName;

    @NotEmpty
    @Column(nullable = false,unique = true)
    @Email(message = "{errors.invalid_email}")
    private String email;


    private String password;

    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")}

    )
    private List<Role> roles;

    //parameterised constructor
    public User(User user) {
        this.id = id;
        this.firstName = user.firstName;
        this.lastName =user.lastName;
        this.email = user.email;
        this.password =user.password;
        this.roles = user.roles;
    }

    //Default constructor
    public User(){

    }

}
