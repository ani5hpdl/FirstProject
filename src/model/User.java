/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anish
 */
public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    
    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    public int getId(){
        return id;
    }
    
    public void SetId(int id){
        this.id = id;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void SetUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
     
}
