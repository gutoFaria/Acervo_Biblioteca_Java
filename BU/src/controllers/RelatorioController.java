package controllers;

import data.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Relatorio;

public class RelatorioController {
    private Connection con = Conectar.getConectar();
    public void CadastrarRelatorio(Relatorio r){
        
        
        String sql = "insert into relatorio(titulo,cidade,assunto,ano,cdu,emprestado,numPaginas,autores,isbn) "
                + "values(?,?,?,?,?,?,?,?,?)";
        
        try(PreparedStatement smt = con.prepareCall(sql)) {
            smt.setString(1,r.getTitulo());
            smt.setString(2,r.getCidade());
            smt.setString(3,r.getAssunto());
            smt.setString(4,r.getAno());
            smt.setString(5,r.getCdu());
            smt.setBoolean(6,r.isEsprestado());
            smt.setInt(7,r.getNumPaginas());
            smt.setString(8,r.getAutor());
            smt.setString(9,r.getIsbn());
            
            
            smt.executeUpdate();
            smt.close();
            con.close();
            
            JOptionPane.showMessageDialog(null,"Relatório cadastrado!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar o Relatório!"+ e.getMessage());
        }
    }
    
    public List<Relatorio> ListarRelatorio(){
        con = Conectar.getConectar();
        List<Relatorio> lista = new ArrayList();
        
        String sql = "select * from relatorio";
        
        try(PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet res = smt.executeQuery();
            //colocar os atributos na lista
            while(res.next()){
                Relatorio r = new Relatorio();
                r.setIdRegistro(res.getInt("idRegistro"));
                r.setTitulo(res.getString("titulo"));
                r.setCidade(res.getString("cidade"));
                r.setAssunto(res.getString("assunto"));
                r.setAno(res.getString("ano"));
                r.setCdu(res.getString("cdu"));
                r.setNumPaginas(res.getInt("numPaginas"));
                r.setAutor(res.getString("autores"));
                r.setIsbn(res.getString("isbn"));
                
                
                lista.add(r);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro listar periódico!");
        }
        return lista;
    }
    
    public List<Relatorio> PesquisaRelatorios(){
        con = Conectar.getConectar();
        List<Relatorio> lista = new ArrayList();
        
        String sql = "select * from relatorio";
        
        try(PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet res = smt.executeQuery();
            //colocar os atributos na lista
            while(res.next()){
                Relatorio r = new Relatorio();
                r.setIdRegistro(res.getInt("idRegistro"));
                r.setTitulo(res.getString("titulo"));
                r.setCidade(res.getString("cidade"));
                r.setAssunto(res.getString("assunto"));
                r.setAno(res.getString("ano"));
                r.setCdu(res.getString("cdu"));
                r.setNumPaginas(res.getInt("numPaginas"));
                r.setAutor(res.getString("autores"));
                r.setIsbn(res.getString("isbn"));
                
                
                lista.add(r);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro listar periódico!");
        }
        return lista;
    }
    
    public void FichaRelatorio(int registro){
        con = Conectar.getConectar();
        
        String sql = "select titulo,cidade,assunto,ano,cdu,numPaginas,autores,isbn "
                + "from relatorio where idRegistro = ?";
        
        try (PreparedStatement smt = con.prepareStatement(sql)){
                smt.setInt(1,registro);
                ResultSet res = smt.executeQuery();
                
                while(res.next()){
                JOptionPane.showMessageDialog(null,res.getString("autores")+"\n"+ 
                        res.getString("titulo")+ "-"+res.getString("cidade")+": "+res.getString("ano")+".\n"+
                        res.getInt("numPaginas")+".\n"+
                        "ISBN: "+res.getString("isbn")+ "\n"+
                        res.getString("assunto")+". "+res.getString("titulo")+
                        "\n\t\t" + "CDU: "+ res.getString("cdu"));
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro ao mostrar!");
            }
    }
    
    public void AtualizarRelatorio(Relatorio r){
        Connection con = Conectar.getConectar();
        String sql = "update relatorio set titulo=?,cidade=?,assunto=?, ano=?, cdu=?,"
                + " numPaginas=?,autores=?,isbn=? where idRegistro = ? ";
        
        try(PreparedStatement smt = con.prepareCall(sql)) {
            smt.setString(1,r.getTitulo());
            smt.setString(2,r.getCidade());
            smt.setString(3,r.getAssunto());
            smt.setString(4,r.getAno());
            smt.setString(5,r.getCdu());
            smt.setInt(6,r.getNumPaginas());
            smt.setString(7,r.getAutor());
            smt.setString(8,r.getIsbn());
            
            smt.setInt(9,r.getIdRegistro());
            
            smt.executeUpdate();
            smt.close();
            con.close();
            
            JOptionPane.showMessageDialog(null,"Relatório atualizaso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro na atualização!");
        }
    }
    
    public void ExcluirRelatorio(int registro){
        String sql = "delete from relatorio where idRegistro = ?";
        
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja excluir o relatorio?",
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
    
    public void EmprestarRelatorio(int registro){
        String sql = "update relatorio set emprestado = '1' where idRegistro = ?";
        
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja emprestar o relatorio?",
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
    
    public void DevolverRelatorio(int registro){
        String sql = "update relatorio set emprestado = '0' where idRegistro = ?";
        
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja devolver o relatorio?",
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
