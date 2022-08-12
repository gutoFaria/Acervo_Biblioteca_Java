
package controllers;

import data.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Mapa;


public class MapaController {
    private Connection con = Conectar.getConectar();
    public void CadastrarMapa(Mapa ma){
        
        
        String sql = "insert into mapa(titulo,autor,ano,tipoDeMapa,emprestado) "
                + "values(?,?,?,?,?)";
        
        try(PreparedStatement smt = con.prepareCall(sql)) {
            smt.setString(1,ma.getTitulo());
            smt.setString(2,ma.getAutor());
            smt.setString(3,ma.getAno());
            smt.setString(4,ma.getTipoDeMapa());
            smt.setBoolean(5,ma.isEsprestado());
            
            smt.executeUpdate();
            smt.close();
            con.close();
            
            JOptionPane.showMessageDialog(null,"Mapa cadastrado!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar o Mapa!"+ e.getMessage());
        }
    }
    
    public List<Mapa> ListarMapa(){
        con = Conectar.getConectar();
        List<Mapa> lista = new ArrayList();
        
        String sql = "select * from mapa";
        
        try(PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet res = smt.executeQuery();
            //colocar os atributos na lista
            while(res.next()){
                Mapa m = new Mapa();
                m.setIdRegistro(res.getInt("idRegistro"));
                m.setTitulo(res.getString("titulo"));
                m.setAutor(res.getString("autor"));
                m.setAno(res.getString("ano"));
                m.setTipoDeMapa(res.getString("tipoDeMapa"));
                
                lista.add(m);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro listar mapa!");
        }
        return lista;
    }
    
    public List<Mapa> PesquisaMapas(){
        con = Conectar.getConectar();
        List<Mapa> lista = new ArrayList();
        
        String sql = "select idRegistro,titulo,emprestado from mapa";
        
        try(PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet res = smt.executeQuery();
            //colocar os atributos na lista
            while(res.next()){
                Mapa m = new Mapa();
                m.setIdRegistro(res.getInt("idRegistro"));
                m.setTitulo(res.getString("titulo"));
                m.setEsprestado(res.getBoolean("emprestado"));

                lista.add(m);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro listar mapa!");
        }
        return lista;
    }
    
    public void FichaMapa(int registro){
        con = Conectar.getConectar();
        
        String sql = "select titulo,autor,ano,tipoDeMapa "
                + "from mapa where idRegistro = ?";
        
        try (PreparedStatement smt = con.prepareStatement(sql)){
                smt.setInt(1,registro);
                ResultSet res = smt.executeQuery();
                
                while(res.next()){
                JOptionPane.showMessageDialog(null,res.getString("autor")+"\n"+ 
                        res.getString("titulo")+res.getString("ano")+".\n"+
                        "Tipo de mapa: "+res.getString("tipoDeMapa"));    
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro ao mostrar!");
            }
    }
    
    public void AtualizarMapa(Mapa m){
        Connection con = Conectar.getConectar();
        String sql = "update mapa set titulo=?,autor=?,ano=?, tipoDeMapa=? where idRegistro = ? ";
        
        try(PreparedStatement smt = con.prepareCall(sql)) {
            smt.setString(1,m.getTitulo());
            smt.setString(2,m.getAutor());
            smt.setString(3,m.getAno());
            smt.setString(4,m.getTipoDeMapa()); 
            smt.setInt(5,m.getIdRegistro());
            
            smt.executeUpdate();
            smt.close();
            con.close();
            
            JOptionPane.showMessageDialog(null,"Mapa atualizada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro na atualização!");
        }
    }
    
    public void ExcluirMapa(int registro){
        String sql = "delete from mapa where idRegistro = ?";
        
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja excluir a mapa?",
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
    
    public void EmprestarMapa(int registro){
        String sql = "update livro set emprestado = '1' where idRegistro = ?";
        
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja emprestar o mapa?",
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
    
    public void DevolverMapa(int registro){
        String sql = "update livro set emprestado = '0' where idRegistro = ?";
        
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja devolver o mapa?",
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
