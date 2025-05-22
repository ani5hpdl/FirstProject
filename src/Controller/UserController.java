/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.UserDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.User;
import view.MyProj;

/**
 *
 * @author anish
 */
public class UserController {
    private final UserDao userDao = new UserDao();
    private final MyProj userView;
    
    public UserController(MyProj userView){
        this.userView = userView;
        userView.addAdduserListener(new AddUserListener());
    }
    
    public void open(){
        this.userView.setVisible(true);
    }

    public void close(){
        this.userView.dispose();
    }
    
    class AddUserListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            UserDao userDao = new UserDao();
            try{
                String username = userView.getnameField().getText();
                String email = userView.getemailField().getText();
                String password = userView.getpasswordField().getText();
                User user = new User(username,email,password);
                boolean check = userDao.CheckUser(user);
                if(check){
                    JOptionPane.showMessageDialog(userView,"User Already Exists");
                }else{
                    userDao.signup(user);
                }
            }catch(Exception ex){
                System.out.println("Error Adding User"+ ex.getMessage());
            }
        }
    }
    
}
