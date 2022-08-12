
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Conectar {
    //variável estática e sem poder mudar 'final'
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost";
    private static final String PORT = "3306";
    private static final String USER = "admin";
    private static final String PASS = "admin";
    private static final String DB = "bu";
    private static final String TIMEZONE = "useTimezone=true&serverTimezone=UTC";
    
    private static final String conexao = URL + ":" + PORT + "/" + DB + "?" + TIMEZONE;
   
    
    //método para criar a conexão com banco de dados 
    //o método retorna um objeto de conexão com o banco de dados
    public static Connection getConectar(){
        Connection con = null;
        try {
            //colocar qual o driver utilizado
            Class.forName(DRIVER);
            con = DriverManager.getConnection(conexao, USER, PASS); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados \n"+ e.getMessage());
        }
        
        return con;
    }
}
