package controllers;

import data.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Periodico;


public class PeriodicoController {
    private Connection con = Conectar.getConectar();
    public void CadastrarPeriodico(Periodico p){
        
        
        String sql = "insert into periodico(titulo,cidade,assunto,ano,cdu,emprestado,numPaginas,editora,autores,isbn,numEdicao) "
                + "values(?,?,?,?,?,?,?,?,?,?,?)";
        
        try(PreparedStatement smt = con.prepareCall(sql)) {
            smt.setString(1,p.getTitulo());
            smt.setString(2,p.getCidade());
            smt.setString(3,p.getAssunto());
            smt.setString(4,p.getAno());
            smt.setString(5,p.getCdu());
            smt.setBoolean(6,p.isEsprestado());
            smt.setInt(7,p.getNumPaginas());
            smt.setString(8,p.getEditora());
            smt.setString(9,p.getAutores());
            smt.setString(10,p.getIsbn());
            smt.setInt(11,p.getNumEdicao());
            
            smt.executeUpdate();
            smt.close();
            con.close();
            
            JOptionPane.showMessageDialog(null,"Periódico cadastrado!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar o periódico!"+ e.getMessage());
        }
    }
    
    public List<Periodico> ListarPeriodico(){
        con = Conectar.getConectar();
        List<Periodico> lista = new ArrayList();
        
        String sql = "select * from periodico";
        
        try(PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet res = smt.executeQuery();
            //colocar os atributos na lista
            while(res.next()){
                Periodico p = new Periodico();
                p.setIdRegistro(res.getInt("idRegistro"));
                p.setTitulo(res.getString("titulo"));
                p.setCidade(res.getString("cidade"));
                p.setAssunto(res.getString("assunto"));
                p.setAno(res.getString("ano"));
                p.setCdu(res.getString("cdu"));
                p.setNumPaginas(res.getInt("numPaginas"));
                p.setEditora(res.getString("editora"));
                p.setAutores(res.getString("autores"));
                p.setIsbn(res.getString("isbn"));
                p.setNumEdicao(res.getInt("numEdicao"));
                
                lista.add(p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro listar periódico!");
        }
        return lista;
    }
    
    public void FichaPeriodico(int registro){
        con = Conectar.getConectar();
        
        String sql = "select titulo,cidade,assunto,ano,cdu,emprestado,numPaginas,editora,autores,isbn,numEdicao "
                + "from periodico where idRegistro = ?";
        
        try (PreparedStatement smt = con.prepareStatement(sql)){
                smt.setInt(1,registro);
                ResultSet res = smt.executeQuery();
                
                while(res.next()){
                JOptionPane.showMessageDialog(null,res.getString("autores")+"\n"+ 
                        res.getString("titulo")+ "-"+res.getInt("numEdicao")+" - "+res.getString("cidade")+": "+res.getString("editora")+", "+res.getString("ano")+".\n"+
                        res.getInt("numPaginas")+".\n"+
                        "ISBN: "+res.getString("isbn")+ "\n"+
                        res.getString("assunto")+". "+res.getString("titulo")+
                        "\n\t\t" + "CDU: "+ res.getString("cdu"));
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro ao mostrar!");
            }
    }
    
    public List<Periodico> PesquisaPeriodicos(){
        con = Conectar.getConectar();
        List<Periodico> lista = new ArrayList();
        
        String sql = "select idRegistro,titulo,emprestado from periodico";
        
        try(PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet res = smt.executeQuery();
            //colocar os atributos na lista
            while(res.next()){
                Periodico p = new Periodico();
                p.setIdRegistro(res.getInt("idRegistro"));
                p.setTitulo(res.getString("titulo"));
                p.setEsprestado(res.getBoolean("emprestado"));
               
                lista.add(p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro listar periódico!");
        }
        return lista;
    }
    
    public void AtualizarPeriodico(Periodico p){
        Connection con = Conectar.getConectar();
        String sql = "update periodico set titulo=?,cidade=?,assunto=?, ano=?, cdu=?,"
                + " numPaginas=?, editora=?,autores=?,isbn=?,numEdicao=? where idRegistro = ? ";
        
        try(PreparedStatement smt = con.prepareCall(sql)) {
            smt.setString(1,p.getTitulo());
            smt.setString(2,p.getCidade());
            smt.setString(3,p.getAssunto());
            smt.setString(4,p.getAno());
            smt.setString(5,p.getCdu());
            smt.setInt(6,p.getNumPaginas());
            smt.setString(7,p.getEditora());
            smt.setString(8,p.getAutores());
            smt.setString(9,p.getIsbn());
            smt.setInt(10,p.getNumEdicao());
            
            smt.setInt(11,p.getIdRegistro());
            
            smt.executeUpdate();
            smt.close();
            con.close();
            
            JOptionPane.showMessageDialog(null,"Periódico atualizaso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro na atualização!");
        }
    }
    
    public void ExcluirPeriodico(int registro){
        String sql = "delete from periodico where idRegistro = ?";
        
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja excluir o periodico?",
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
    
    public void EmprestarPeriodico(int registro){
        String sql = "update periodico set emprestado = '1' where idRegistro = ?";
        
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja excluir o periodico?",
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
    
    public void DevolverPeriodico(int registro){
        String sql = "update periodico set emprestado = '0' where idRegistro = ?";
        
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja devolver o periodico?",
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
