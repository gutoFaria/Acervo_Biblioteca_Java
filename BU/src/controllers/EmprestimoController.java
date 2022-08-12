package controllers;

import data.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Emprestimo;


public class EmprestimoController {
    private Connection con = Conectar.getConectar();
    public void CadastrarEmprestimo(Emprestimo em){
        
        
        String sql = "insert into emprestimo(idRegistro,titulo,matricula) "
                + "values(?,?,?)";
        
        try(PreparedStatement smt = con.prepareCall(sql)) {
            smt.setInt(1,em.getIdRegistro());
            smt.setString(2,em.getTitulo());
            smt.setInt(3,em.getMatricula());
            
            smt.executeUpdate();
            smt.close();
            con.close();
            
            JOptionPane.showMessageDialog(null,"Empréstimo cadastrado!"); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar o Empréstimo!"+ e.getMessage());
        }
    }
    
    public List<Emprestimo> ListarEmprestimo(){
        con = Conectar.getConectar();
        List<Emprestimo> lista = new ArrayList();
        
        String sql = "select * from emprestimo";
        
        try(PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet res = smt.executeQuery();
            //colocar os atributos na lista
            while(res.next()){
                Emprestimo em = new Emprestimo();
                em.setIdRegistro(res.getInt("idRegistro"));
                em.setTitulo(res.getString("titulo"));
                em.setMatricula(res.getInt("matricula"));

                lista.add(em);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro listar periódico!");
        }
        return lista;
    }
    
    
    public void ExcluirRelatorio(int registro){
        String sql = "delete from emprestimo where idRegistro = ?";
        
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja excluir o emprestimo?",
                "Excluir",JOptionPane.YES_NO_OPTION);
        
        if(opcao == JOptionPane.YES_OPTION){
            try (PreparedStatement smt = con.prepareStatement(sql)){
                smt.setInt(1,registro);
                smt.executeUpdate();
                smt.close();
                con.close();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro ao excluir!");
            }
        }
    }
}
