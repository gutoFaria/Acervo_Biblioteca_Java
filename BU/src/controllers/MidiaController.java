package controllers;

import data.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Midia;
import javax.swing.JOptionPane;


public class MidiaController {
     private Connection con = Conectar.getConectar();
    public void CadastrarMidia(Midia m){
        
        
        String sql = "insert into midia(titulo,cidade,assunto,ano,cdu,emprestado,autores,tipoMidia,duracao,estudio) "
                + "values(?,?,?,?,?,?,?,?,?,?)";
        
        try(PreparedStatement smt = con.prepareCall(sql)) {
            smt.setString(1,m.getTitulo());
            smt.setString(2,m.getCidade());
            smt.setString(3,m.getAssunto());
            smt.setString(4,m.getAno());
            smt.setString(5,m.getCdu());
            smt.setBoolean(6,m.isEsprestado());
            smt.setString(7,m.getAutor());
            smt.setString(8,m.getTipoMidia());
            smt.setString(9,m.getDuracao());
            smt.setString(10,m.getEstudio());
            
            
            smt.executeUpdate();
            smt.close();
            con.close();
            
            JOptionPane.showMessageDialog(null,"Midia cadastrado!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar o Midia!"+ e.getMessage());
        }
    }
    
    public List<Midia> ListarMidia(){
        con = Conectar.getConectar();
        List<Midia> lista = new ArrayList();
        
        String sql = "select * from midia";
        
        try(PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet res = smt.executeQuery();
            //colocar os atributos na lista
            while(res.next()){
                Midia m = new Midia();
                m.setIdRegistro(res.getInt("idRegistro"));
                m.setTitulo(res.getString("titulo"));
                m.setCidade(res.getString("cidade"));
                m.setAssunto(res.getString("assunto"));
                m.setAno(res.getString("ano"));
                m.setCdu(res.getString("cdu"));
                m.setAutor(res.getString("autores"));
                m.setTipoMidia(res.getString("tipoMidia"));
                m.setDuracao(res.getString("duracao"));
                m.setEstudio(res.getString("estudio"));
                
                
                lista.add(m);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro listar mídia!");
        }
        return lista;
    }
    
    public List<Midia> PesquisaMidias(){
        con = Conectar.getConectar();
        List<Midia> lista = new ArrayList();
        
        String sql = "select idRegistro,titulo,emprestado from midia";
        
        try(PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet res = smt.executeQuery();
            //colocar os atributos na lista
            while(res.next()){
                Midia m = new Midia();
                m.setIdRegistro(res.getInt("idRegistro"));
                m.setTitulo(res.getString("titulo"));
                m.setEsprestado(res.getBoolean("emprestado"));
                
                lista.add(m);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro listar mídia!");
        }
        return lista;
    }
    
    public void FichaMidia(int registro){
        con = Conectar.getConectar();
        
        String sql = "select titulo,cidade,assunto,ano,cdu,autores,tipoMidia,duracao,estudio "
                + "from midia where idRegistro = ?";
        
        try (PreparedStatement smt = con.prepareStatement(sql)){
                smt.setInt(1,registro);
                ResultSet res = smt.executeQuery();
                
                while(res.next()){
                JOptionPane.showMessageDialog(null,res.getString("autores")+"\n"+ 
                        res.getString("titulo")+ "-"+res.getString("cidade")+": "+res.getString("ano")+".\n"+
                        res.getString("estudio")+".\n"+
                        "MIDIA: "+res.getString("tipoMidia")+ "\n"+
                        res.getString("duracao")+" min."+ res.getString("assunto")+
                        "\n\t\t" + "CDU: "+ res.getString("cdu"));
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro ao mostrar!");
            }
    }
    
    public void AtualizarMidia(Midia m){
        Connection con = Conectar.getConectar();
        String sql = "update midia set titulo=?,cidade=?,assunto=?, ano=?, cdu=?,"
                + "autores=?,tipoMidia=?,duracao=?,estudio=? where idRegistro = ? ";
        
        try(PreparedStatement smt = con.prepareCall(sql)) {
            smt.setString(1,m.getTitulo());
            smt.setString(2,m.getCidade());
            smt.setString(3,m.getAssunto());
            smt.setString(4,m.getAno());
            smt.setString(5,m.getCdu());
            smt.setString(6,m.getAutor());
            smt.setString(7,m.getTipoMidia());
            smt.setString(8,m.getDuracao());
            smt.setString(9,m.getEstudio());
            
            smt.setInt(10,m.getIdRegistro());
            
            smt.executeUpdate();
            smt.close();
            con.close();
            
            JOptionPane.showMessageDialog(null,"Mídia atualizada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro na atualização!");
        }
    }
    
    public void ExcluirMidia(int registro){
        String sql = "delete from midia where idRegistro = ?";
        
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja excluir a mídia?",
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
    
    public void EmprestarMidia(int registro){
        String sql = "update midia set emprestado = '1' where idRegistro = ?";
        
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja emprestar a mídia?",
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
    
    public void DevolverMidia(int registro){
        String sql = "update midia set emprestado = '0' where idRegistro = ?";
        
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja devolver a mídia?",
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
