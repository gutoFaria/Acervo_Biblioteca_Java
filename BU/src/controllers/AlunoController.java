
package controllers;

import data.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Aluno;

public class AlunoController {
    public void CadastrarAluno(Aluno a){
        Connection con  = Conectar.getConectar();
        
        //comando sql
        String sql = "insert into aluno(matricula,cpf,nome,curso,endereco,telefone) values(?,?,?,?,?,?)";
        
        //preparedStatement para setar os valores
        
        try(PreparedStatement smt = con.prepareCall(sql)) {
            //para cada ? associa um valor iniciando em 1
            
            smt.setInt(1,a.getMatricula());
            smt.setString(2,a.getCpf());
            smt.setString(3, a.getNome());
            smt.setString(4, a.getCurso());
            smt.setString(5, a.getEndereco());
            smt.setString(6,a.getTelefone());
            
            smt.executeUpdate();
            smt.close();
            con.close();
            
            JOptionPane.showMessageDialog(null, "Aluno cadastrado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno!");
        }
    }
    
    
    //atualizar
    public void AtualizarAluno(Aluno a){
        Connection con = Conectar.getConectar();
        
        String sql = "update aluno set cpf = ?, nome = ?, curso = ?, endereco = ?, telefone = ? where matricula = ?";
        
        try(PreparedStatement smt = con.prepareCall(sql)) {
            //para cada ? associa um valor iniciando em 1
            
            smt.setString(1,a.getCpf());
            smt.setString(2, a.getNome());
            smt.setString(3, a.getCurso());
            smt.setString(4, a.getEndereco());
            smt.setString(5,a.getTelefone());
            
            smt.setInt(6,a.getMatricula());
            
            smt.executeUpdate();
            smt.close();
            con.close();
            
            JOptionPane.showMessageDialog(null, "Aluno atualizado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar aluno!");
        }
        
    }
    
    //retornar uma lista de aluno
    public List<Aluno> ListarAlunos(){
        Connection con = Conectar.getConectar();
        List<Aluno> lista = new ArrayList();
        
        String sql = "select * from aluno order by nome";
        
        try(PreparedStatement smt = con.prepareStatement(sql)){
            ResultSet res = smt.executeQuery();
            
            //percorrer o res 
            //colocar os atributos entre parentes assim como eles estão no banco de dados
            while(res.next()){
                Aluno a = new Aluno();
                a.setMatricula(res.getInt("matricula"));
                a.setCpf(res.getString("cpf"));
                a.setNome(res.getString("nome"));
                a.setCurso(res.getString("curso"));
                a.setEndereco(res.getString("endereco"));
                a.setTelefone(res.getString("telefone"));
                
                lista.add(a);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro " + ex.getMessage() );
        }
        
        return lista;
    }
    
    public void ExcluirAluno(Aluno a){
        Connection con = Conectar.getConectar();
        String sql = "delete from aluno where matricula = ?";
        
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o aluno"+ a.getNome() + "?",
                " Excluir",JOptionPane.YES_NO_OPTION);
        
        if(opcao == JOptionPane.YES_OPTION){
            try(PreparedStatement smt = con.prepareStatement(sql)){
                smt.setInt(1,a.getMatricula());
                smt.executeUpdate();
                smt.close();
                con.close();
                
                JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir aluno!");
            }
        }
    }
}
