package controllers;

import data.Conectar;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AdminController {
    
    public boolean Login(String cpf,String senha){
        Connection con = Conectar.getConectar();
        
        System.out.println(cpf);
        System.out.println(senha);
        String sql = "select * from admin where cpf = ? and senha = ? ";
        //String sql = "select * from admin where cpf=" ";
        ResultSet res = null;
        
        try(PreparedStatement smt = con.prepareStatement(sql)){
            smt.setString(1, cpf);
            smt.setString(2,senha);
            res= smt.executeQuery();

            if(res.next()){
                return true;
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro " + ex.getMessage() );
        }
        
        return false;
    }
    
}
