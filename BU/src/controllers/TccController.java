
package controllers;

import data.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Tcc;


public class TccController {
    private Connection con = Conectar.getConectar();
    public void CadastrarTcc(Tcc t){
        
        
        String sql = "insert into tcc(titulo,autor,curso,ano,tema,numPaginas,emprestado) "
                + "values(?,?,?,?,?,?,?)";
        
        try(PreparedStatement smt = con.prepareCall(sql)) {
            smt.setString(1,t.getTitulo());
            smt.setString(2,t.getAutor());
            smt.setString(3,t.getCurso());
            smt.setString(4,t.getAno());
            smt.setString(5,t.getTema());
            smt.setInt(6,t.getNumPaginas());
            smt.setBoolean(7,t.isEsprestado());
            
            smt.executeUpdate();
            smt.close();
            con.close();
            
            JOptionPane.showMessageDialog(null,"Tcc cadastrado!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar o Tcc!"+ e.getMessage());
        }
    }
    
    public List<Tcc> ListarTcc(){
        con = Conectar.getConectar();
        List<Tcc> lista = new ArrayList();
        
        String sql = "select * from tcc";
        
        try(PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet res = smt.executeQuery();
            //colocar os atributos na lista
            while(res.next()){
                Tcc t = new Tcc();
                t.setIdRegistro(res.getInt("idRegistro"));
                t.setTitulo(res.getString("titulo"));
                t.setAutor(res.getString("autor"));
                t.setCurso(res.getString("curso"));
                t.setAno(res.getString("ano"));
                t.setTema(res.getString("tema"));
                t.setNumPaginas(res.getInt("numPaginas"));
                
                lista.add(t);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro listar tcc!");
        }
        return lista;
    }
    
    public List<Tcc> PesquisaTccs(){
        con = Conectar.getConectar();
        List<Tcc> lista = new ArrayList();
        
        String sql = "select idRegistro,titulo,emprestado from tcc";
        
        try(PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet res = smt.executeQuery();
            //colocar os atributos na lista
            while(res.next()){
                Tcc t = new Tcc();
                t.setIdRegistro(res.getInt("idRegistro"));
                t.setTitulo(res.getString("titulo"));
                t.setEsprestado(res.getBoolean("emprestado"));
                
                lista.add(t);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro listar tcc!");
        }
        return lista;
    }
    
    public void FichaTcc(int registro){
        con = Conectar.getConectar();
        
        String sql = "select titulo,autor,curso,ano,tema,numPaginas "
                + "from tcc where idRegistro = ?";
        
        try (PreparedStatement smt = con.prepareStatement(sql)){
                smt.setInt(1,registro);
                ResultSet res = smt.executeQuery();
                
                while(res.next()){
                JOptionPane.showMessageDialog(null,res.getString("autor")+"\n"+ 
                        res.getString("titulo")+res.getString("ano")+".\n"+res.getString("curso")+
                        "TEMA: "+res.getString("tema") + res.getInt("numPaginas")+" pág.");    
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro ao mostrar!");
            }
    }
    
    public void AtualizarTcc(Tcc t){
        Connection con = Conectar.getConectar();
        String sql = "update tcc set titulo=?,autor=?,curso=?, ano=?, tema=?,"
                + " numPaginas=? where idRegistro = ? ";
        
        try(PreparedStatement smt = con.prepareCall(sql)) {
            smt.setString(1,t.getTitulo());
            smt.setString(2,t.getAutor());
            smt.setString(3,t.getCurso());
            smt.setString(4,t.getAno());
            smt.setString(5,t.getTema());
            smt.setInt(6,t.getNumPaginas());

            smt.setInt(7,t.getIdRegistro());
            
            smt.executeUpdate();
            smt.close();
            con.close();
            
            JOptionPane.showMessageDialog(null,"Tcc atualizaso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro na atualização!");
        }
    }
    
    public void ExcluirTcc(int registro){
        String sql = "delete from tcc where idRegistro = ?";
        
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja excluir o tcc?",
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
    
    public void EmprestarTcc(int registro){
        String sql = "update livro set emprestado = '1' where idRegistro = ?";
        
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja emprestar o tcc?",
                "Emprestar",JOptionPane.YES_NO_OPTION);
        
        if(opcao == JOptionPane.YES_OPTION){
            try (PreparedStatement smt = con.prepareStatement(sql)){
                smt.setInt(1,registro);
                smt.executeUpdate();
                smt.close();
                con.close();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro ao emprestar!");
            }
        }
    }
    
    public void DevolverTcc(int registro){
        String sql = "update livro set emprestado = '0' where idRegistro = ?";
        
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja devolver o tcc?",
                "Devolver",JOptionPane.YES_NO_OPTION);
        
        if(opcao == JOptionPane.YES_OPTION){
            try (PreparedStatement smt = con.prepareStatement(sql)){
                smt.setInt(1,registro);
                smt.executeUpdate();
                smt.close();
                con.close();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro ao devolver!");
            }
        }
    }
}
