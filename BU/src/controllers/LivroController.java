package controllers;

import data.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Livro;


public class LivroController {
    private Connection con = Conectar.getConectar();
    public void CadastrarLivro(Livro l){
        
        
        String sql = "insert into livro(titulo,cidade,assunto,ano,cdu,emprestado,numPaginas,editora,autores,isbn,numEdicao) "
                + "values(?,?,?,?,?,?,?,?,?,?,?)";
        
        try(PreparedStatement smt = con.prepareCall(sql)) {
            smt.setString(1,l.getTitulo());
            smt.setString(2,l.getCidade());
            smt.setString(3,l.getAssunto());
            smt.setString(4,l.getAno());
            smt.setString(5,l.getCdu());
            smt.setBoolean(6,l.isEsprestado());
            smt.setInt(7,l.getNumPaginas());
            smt.setString(8,l.getEditora());
            smt.setString(9,l.getAutores());
            smt.setString(10,l.getIsbn());
            smt.setInt(11,l.getNumEdicao());
            
            smt.executeUpdate();
            smt.close();
            con.close();
            
            JOptionPane.showMessageDialog(null,"Livro cadastrado!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar o livro!"+ e.getMessage());
        }
    }
    
    public List<Livro> ListarLivros(){
        con = Conectar.getConectar();
        List<Livro> lista = new ArrayList();
        
        String sql = "select * from livro";
        
        try(PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet res = smt.executeQuery();
            //colocar os atributos na lista
            while(res.next()){
                Livro l = new Livro();
                l.setIdRegistro(res.getInt("idRegistro"));
                l.setTitulo(res.getString("titulo"));
                l.setCidade(res.getString("cidade"));
                l.setAssunto(res.getString("assunto"));
                l.setAno(res.getString("ano"));
                l.setCdu(res.getString("cdu"));
                l.setNumPaginas(res.getInt("numPaginas"));
                l.setEditora(res.getString("editora"));
                l.setAutores(res.getString("autores"));
                l.setIsbn(res.getString("isbn"));
                l.setNumEdicao(res.getInt("numEdicao"));
                
                lista.add(l);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro listar livro!");
        }
        return lista;
    }
    
    public List<Livro> PesquisaLivros(){
        con = Conectar.getConectar();
        List<Livro> lista = new ArrayList();
        
        String sql = "select idRegistro,titulo,emprestado from livro";
        
        try(PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet res = smt.executeQuery();
            //colocar os atributos na lista
            while(res.next()){
                Livro l = new Livro();
                l.setIdRegistro(res.getInt("idRegistro"));
                l.setTitulo(res.getString("titulo"));
                l.setEsprestado(res.getBoolean("emprestado"));

                lista.add(l);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro listar livro!");
        }
        return lista;
    }
    
    public void FichaLivro(int registro){
        con = Conectar.getConectar();
        
        String sql = "select titulo,cidade,assunto,ano,cdu,emprestado,numPaginas,editora,autores,isbn,numEdicao "
                + "from livro where idRegistro = ?";
        
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
    
    public void AtualizarLivro(Livro l){
        String sql = "update livro set titulo=?,cidade=?,assunto=?, ano=?, cdu=?, emprestado=?,"
                + " numPaginas=?, editora=?,autores=?,isbn=?,numEdicao=? where idRegistro = ? ";
        
        try(PreparedStatement smt = con.prepareCall(sql)) {
            smt.setString(1,l.getTitulo());
            smt.setString(2,l.getCidade());
            smt.setString(3,l.getAssunto());
            smt.setString(4,l.getAno());
            smt.setString(5,l.getCdu());
            smt.setBoolean(6,l.isEsprestado());
            smt.setInt(7,l.getNumPaginas());
            smt.setString(8,l.getEditora());
            smt.setString(9,l.getAutores());
            smt.setString(10,l.getIsbn());
            smt.setInt(11,l.getNumEdicao());
            
            smt.setInt(12,l.getIdRegistro());
            smt.executeUpdate();
            smt.close();
            con.close();
            
            JOptionPane.showMessageDialog(null,"Livro atualizaso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro na atualização!");
        }
    }
    
    public void ExcluirLivro(int registro){
        String sql = "delete from livro where idRegistro = ?";
        
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja excluir o livro?",
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
    
    public void EmprestaLivro(int registro){
        String sql = "update livro set emprestado = '1' where idRegistro = ?";
        
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja emprestar o livro?",
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
    
    public void DevolveLivro(int registro){
        String sql = "update livro set emprestado = '0' where idRegistro = ?";
        
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja devolver o livro?",
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
