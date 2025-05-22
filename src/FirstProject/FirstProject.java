/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FirstProject;
import Controller.UserController;
import database.*;
import view.MyProj;
/**
 *
 * @author anish
 */
public class FirstProject {
    public static void main(String[] args) {
        Database db = (Database) new MySqlConnection();
        if(db.openConnection() != null){
            System.out.println("Database connected Sucessfully");
        }else{
            System.out.println("Failed to connect to database");
        }
        
        MyProj myprojform = new MyProj();
        myprojform.setVisible(true);
        UserController controller = new UserController(myprojform);
        controller.open();
        
    }
}
