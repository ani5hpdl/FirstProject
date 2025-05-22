package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.MySqlConnection;
import model.User;

public class UserDao {
    MySqlConnection mysql = new MySqlConnection();

    public void signup(User user){
        Connection conn = mysql.openConnection();
        String sql = "INSERT INTO user (username,email,password) VALUES (?,?,?)";
        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getEmail());
            pstm.setString(3, user.getPassword());
            pstm.executeUpdate();
        }catch (SQLException ex){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection(conn);
        }
    }

    public boolean CheckUser(User user){
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setString(1, user.getEmail());
            pstm.setString(2, user.getPassword());
            ResultSet result = pstm.executeQuery();
            return result.next();
        }catch(SQLException e){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            mysql.closeConnection(conn);
        }
        return false;
    }
}
