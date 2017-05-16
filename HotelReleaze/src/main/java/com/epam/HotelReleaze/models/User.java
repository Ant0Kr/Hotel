package com.epam.HotelReleaze.models;

import javax.persistence.*;



/**
 * Created by Antoha12018 on 10.05.2017.
 */
@Entity
@Table(name = "users")
public class User  {

    @Id
    @Column(name = "userID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private boolean role;

    public User(String username, String password,Boolean role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(){}

    public User(User user){
        this.userID = user.userID;
        this.username = user.username;
        this.password = user.password;
        this.role = user.role;
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int id) {
        this.userID = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getRole(){
        return role;
    }

    public void setRole(boolean role){
        this.role = role;
    }

    public String getStringRole(){
        if(role)
            return "Admin";
        else
            return "User";
    }

}
