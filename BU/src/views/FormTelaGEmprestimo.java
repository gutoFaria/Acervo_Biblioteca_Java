package views;

import controllers.EmprestimoController;
import controllers.LivroController;
import controllers.MapaController;
import controllers.MidiaController;
import controllers.PeriodicoController;
import controllers.RelatorioController;
import controllers.TccController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Emprestimo;
import models.Livro;
import models.Mapa;
import models.Midia;
import models.Periodico;
import models.Relatorio;
import models.Tcc;

public class FormTelaGEmprestimo extends javax.swing.JFrame {
    private LivroController lc = new LivroController();
    private PeriodicoController pc = new PeriodicoController();
    private RelatorioController rc = new RelatorioController();
    private MidiaController mc = new MidiaController();
    private MapaController mac = new MapaController();
    private TccController tc = new TccController();
    private EmprestimoController ec = new EmprestimoController();
    public FormTelaGEmprestimo() {
        initComponents();
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnGerenciarAlunos = new javax.swing.JButton();
        btnGerenciarLivros = new javax.swing.JButton();
        btnGerenciarEmprestimo = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtDevolver = new javax.swing.JComboBox<>();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEmprestimo = new javax.swing.JTable();
        btnFicha = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtMatriculaAluno = new javax.swing.JTextField();
        btnEmprestar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaPesquisa = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        btnDevolver = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/livros.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(0, 153, 0));
        jLabel2.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Biblioteca  Universitária");

        btnGerenciarAlunos.setBackground(new java.awt.Color(102, 255, 102));
        btnGerenciarAlunos.setForeground(new java.awt.Color(0, 0, 0));
        btnGerenciarAlunos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/alunos.png"))); // NOI18N
        btnGerenciarAlunos.setText("<html>\nGerenciar <br/> alunos\n</html>\n");
        btnGerenciarAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarAlunosActionPerformed(evt);
            }
        });

        btnGerenciarLivros.setBackground(new java.awt.Color(102, 255, 102));
        btnGerenciarLivros.setForeground(new java.awt.Color(0, 0, 0));
        btnGerenciarLivros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/livrosg.png"))); // NOI18N
        btnGerenciarLivros.setText("<html>\nGerenciar <br/>acervo\n</html>\n");
        btnGerenciarLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarLivrosActionPerformed(evt);
            }
        });

        btnGerenciarEmprestimo.setBackground(new java.awt.Color(102, 255, 102));
        btnGerenciarEmprestimo.setForeground(new java.awt.Color(0, 0, 0));
        btnGerenciarEmprestimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/gerenciar.png"))); // NOI18N
        btnGerenciarEmprestimo.setText("<html>\nGerenciar <br/> empréstimos\n</html>\n\n");

        btnSair.setBackground(new java.awt.Color(102, 255, 102));
        btnSair.setForeground(new java.awt.Color(0, 0, 0));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/sairg.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnGerenciarAlunos)
                    .addComponent(btnGerenciarLivros)
                    .addComponent(btnGerenciarEmprestimo)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(365, 365, 365)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(btnGerenciarAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnGerenciarLivros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnGerenciarEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSair)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 0));
        jLabel3.setText("Empréstimos");

        txtDevolver.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Livro", "Periodico", "Relatorio", "Midia", "Mapa", "Tcc" }));

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tabelaEmprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id reg", "titulo", "matrícula aluno"
            }
        ));
        jScrollPane1.setViewportView(tabelaEmprestimo);

        btnFicha.setText("Ficha Catalográfica");
        btnFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFichaActionPerformed(evt);
            }
        });

        jLabel4.setText("Digite a matrícula do aluno:");

        btnEmprestar.setText("Emprestar");
        btnEmprestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmprestarActionPerformed(evt);
            }
        });

        tabelaPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id reg", "titulo", "emprestado"
            }
        ));
        jScrollPane2.setViewportView(tabelaPesquisa);

        jButton4.setText("Consultar Empréstimos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnDevolver.setText("Devolver");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        txtPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Livro", "Periodico", "Relatorio", "Midia", "Mapa", "Tcc" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFicha))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMatriculaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEmprestar))
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addComponent(txtDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDevolver)
                        .addGap(8, 8, 8)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar)
                    .addComponent(btnFicha)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(165, 165, 165)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMatriculaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmprestar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDevolver)
                    .addComponent(txtDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(276, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnGerenciarAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciarAlunosActionPerformed
        FormTelaInicial formTelaInicial = new FormTelaInicial();
        formTelaInicial.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnGerenciarAlunosActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        String pesquisa = txtPesquisa.getSelectedItem().toString();
        

        if(pesquisa.equals("Livro")){
            List<Livro> lista = lc.PesquisaLivros();
        
            DefaultTableModel modeloTabela = (DefaultTableModel) tabelaPesquisa.getModel();
            modeloTabela.setRowCount(0);

            for(Livro l : lista){
                modeloTabela.addRow(new Object[]{
                    l.getIdRegistro(),
                    l.getTitulo(),
                    l.isEsprestado()
                });
            }
        }
        else if(pesquisa.equals("Periodico")){
            List<Periodico> lista = pc.PesquisaPeriodicos();
        
            DefaultTableModel modeloTabela = (DefaultTableModel) tabelaPesquisa.getModel();
            modeloTabela.setRowCount(0);

            for(Periodico p : lista){
                modeloTabela.addRow(new Object[]{
                    p.getIdRegistro(),
                    p.getTitulo(),
                    p.isEsprestado()
                });
            }
        }
        else if(pesquisa.equals("Relatorio")){
            List<Relatorio> lista = rc.PesquisaRelatorios();
        
            DefaultTableModel modeloTabela = (DefaultTableModel) tabelaPesquisa.getModel();
            modeloTabela.setRowCount(0);

            for(Relatorio r : lista){
                modeloTabela.addRow(new Object[]{
                    r.getIdRegistro(),
                    r.getTitulo(),
                    r.isEsprestado()
                });
            }
        }
        else if(pesquisa.equals("Midia")){
            List<Midia> lista = mc.PesquisaMidias();
        
            DefaultTableModel modeloTabela = (DefaultTableModel) tabelaPesquisa.getModel();
            modeloTabela.setRowCount(0);

            for(Midia m : lista){
                modeloTabela.addRow(new Object[]{
                    m.getIdRegistro(),
                    m.getTitulo(),
                    m.isEsprestado()
                });
            }
        }
        else if(pesquisa.equals("Mapa")){
            List<Mapa> lista = mac.PesquisaMapas();
        
            DefaultTableModel modeloTabela = (DefaultTableModel) tabelaPesquisa.getModel();
            modeloTabela.setRowCount(0);

            for(Mapa m : lista){
                modeloTabela.addRow(new Object[]{
                    m.getIdRegistro(),
                    m.getTitulo(),
                    m.isEsprestado()
                });
            }
        }
        else if(pesquisa.equals("Tcc")){
            List<Tcc> lista = tc.PesquisaTccs();
        
            DefaultTableModel modeloTabela = (DefaultTableModel) tabelaPesquisa.getModel();
            modeloTabela.setRowCount(0);

            for(Tcc t : lista){
                modeloTabela.addRow(new Object[]{
                    t.getIdRegistro(),
                    t.getTitulo(),
                    t.isEsprestado()
                });
            }
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFichaActionPerformed
        String pesquisa = txtPesquisa.getSelectedItem().toString();
        int opcao = tabelaPesquisa.getSelectedRow();

        if(pesquisa.equals("Livro")){
            if(opcao >=0){
                //pega o id do registro
                lc.FichaLivro(Integer.parseInt(tabelaPesquisa.getValueAt(opcao,0).toString()));
            }else{
                JOptionPane.showMessageDialog(null,"Selecione uma linha!");
            }
        }
        else if(pesquisa.equals("Periodico")){
            if(opcao >=0){
                //pega o id do registro
                pc.FichaPeriodico(Integer.parseInt(tabelaPesquisa.getValueAt(opcao,0).toString()));
            }else{
                JOptionPane.showMessageDialog(null,"Selecione uma linha!");
            }
        }
        else if(pesquisa.equals("Relatorio")){
            if(opcao >=0){
                //pega o id do registro
                rc.FichaRelatorio(Integer.parseInt(tabelaPesquisa.getValueAt(opcao,0).toString()));
            }else{
                JOptionPane.showMessageDialog(null,"Selecione uma linha!");
            }
        }
        else if(pesquisa.equals("Midia")){
            if(opcao >=0){
                //pega o id do registro
                mc.FichaMidia(Integer.parseInt(tabelaPesquisa.getValueAt(opcao,0).toString()));
            }else{
                JOptionPane.showMessageDialog(null,"Selecione uma linha!");
            }
        }
        else if(pesquisa.equals("Mapa")){
            if(opcao >=0){
                //pega o id do registro
                mac.FichaMapa(Integer.parseInt(tabelaPesquisa.getValueAt(opcao,0).toString()));
            }else{
                JOptionPane.showMessageDialog(null,"Selecione uma linha!");
            }
        }
        else if(pesquisa.equals("Tcc")){
            if(opcao >=0){
                //pega o id do registro
                tc.FichaTcc(Integer.parseInt(tabelaPesquisa.getValueAt(opcao,0).toString()));
            }else{
                JOptionPane.showMessageDialog(null,"Selecione uma linha!");
            }
        }
    }//GEN-LAST:event_btnFichaActionPerformed

    private void btnEmprestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmprestarActionPerformed
        String pesquisa = txtPesquisa.getSelectedItem().toString();
        int opcao = tabelaPesquisa.getSelectedRow();
        Emprestimo em = new Emprestimo();
        
        if(pesquisa.equals("Livro")){
            if(opcao >=0){
                em.setIdRegistro(Integer.parseInt(tabelaPesquisa.getValueAt(opcao,0).toString()));
                em.setTitulo(tabelaPesquisa.getValueAt(opcao,1).toString());
                em.setMatricula(Integer.parseInt(txtMatriculaAluno.getText()));
                ec.CadastrarEmprestimo(em);
                lc.EmprestaLivro(Integer.parseInt(tabelaPesquisa.getValueAt(opcao,0).toString()));
                
            }else{
                JOptionPane.showMessageDialog(null,"Selecione uma linha!");
            }
        }
        else if(pesquisa.equals("Periodico")){
            if(opcao >=0){
                em.setIdRegistro(Integer.parseInt(tabelaPesquisa.getValueAt(opcao,0).toString()));
                em.setTitulo(tabelaPesquisa.getValueAt(opcao,1).toString());
                em.setMatricula(Integer.parseInt(txtMatriculaAluno.getText()));
                ec.CadastrarEmprestimo(em);
                pc.EmprestarPeriodico(Integer.parseInt(tabelaPesquisa.getValueAt(opcao,0).toString()));
            }else{
                JOptionPane.showMessageDialog(null,"Selecione uma linha!");
            }
        }
        else if(pesquisa.equals("Relatorio")){
            if(opcao >=0){
                em.setIdRegistro(Integer.parseInt(tabelaPesquisa.getValueAt(opcao,0).toString()));
                em.setTitulo(tabelaPesquisa.getValueAt(opcao,1).toString());
                em.setMatricula(Integer.parseInt(txtMatriculaAluno.getText()));
                ec.CadastrarEmprestimo(em);
                rc.EmprestarRelatorio(Integer.parseInt(tabelaPesquisa.getValueAt(opcao,0).toString()));
            }else{
                JOptionPane.showMessageDialog(null,"Selecione uma linha!");
            }
        }
        else if(pesquisa.equals("Midia")){
            if(opcao >=0){
                em.setIdRegistro(Integer.parseInt(tabelaPesquisa.getValueAt(opcao,0).toString()));
                em.setTitulo(tabelaPesquisa.getValueAt(opcao,1).toString());
                em.setMatricula(Integer.parseInt(txtMatriculaAluno.getText()));
                ec.CadastrarEmprestimo(em);
                mc.EmprestarMidia(Integer.parseInt(tabelaPesquisa.getValueAt(opcao,0).toString()));
            }else{
                JOptionPane.showMessageDialog(null,"Selecione uma linha!");
            }
        }
        else if(pesquisa.equals("Mapa")){
            if(opcao >=0){
                em.setIdRegistro(Integer.parseInt(tabelaPesquisa.getValueAt(opcao,0).toString()));
                em.setTitulo(tabelaPesquisa.getValueAt(opcao,1).toString());
                em.setMatricula(Integer.parseInt(txtMatriculaAluno.getText()));
                ec.CadastrarEmprestimo(em);
                mac.EmprestarMapa(Integer.parseInt(tabelaPesquisa.getValueAt(opcao,0).toString()));
            }else{
                JOptionPane.showMessageDialog(null,"Selecione uma linha!");
            }
        }
        else if(pesquisa.equals("Tcc")){
            if(opcao >=0){
                em.setIdRegistro(Integer.parseInt(tabelaPesquisa.getValueAt(opcao,0).toString()));
                em.setTitulo(tabelaPesquisa.getValueAt(opcao,1).toString());
                em.setMatricula(Integer.parseInt(txtMatriculaAluno.getText()));
                ec.CadastrarEmprestimo(em);
                tc.EmprestarTcc(Integer.parseInt(tabelaPesquisa.getValueAt(opcao,0).toString()));
            }else{
                JOptionPane.showMessageDialog(null,"Selecione uma linha!");
            }
        }
    }//GEN-LAST:event_btnEmprestarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        List<Emprestimo> lista = ec.ListarEmprestimo();
        
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaEmprestimo.getModel();
        modeloTabela.setRowCount(0);
        
        for(Emprestimo e : lista){
            modeloTabela.addRow(new Object[]{
                e.getIdRegistro(),
                e.getTitulo(),
                e.getMatricula()
            });
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        String pesquisa = txtDevolver.getSelectedItem().toString();
        int opcao = tabelaEmprestimo.getSelectedRow();
        Emprestimo em = new Emprestimo();
        
        if(pesquisa.equals("Livro")){
            if(opcao >=0){
                ec.ExcluirRelatorio(Integer.parseInt(tabelaEmprestimo.getValueAt(opcao,0).toString()));
                lc.DevolveLivro(Integer.parseInt(tabelaEmprestimo.getValueAt(opcao,0).toString()));    
            }else{
                JOptionPane.showMessageDialog(null,"Selecione uma linha!");
            }
        }
        else if(pesquisa.equals("Periodico")){
            if(opcao >=0){
                
                ec.ExcluirRelatorio(Integer.parseInt(tabelaEmprestimo.getValueAt(opcao,0).toString()));
                pc.DevolverPeriodico(Integer.parseInt(tabelaEmprestimo.getValueAt(opcao,0).toString()));
            }else{
                JOptionPane.showMessageDialog(null,"Selecione uma linha!");
            }
        }
        else if(pesquisa.equals("Relatorio")){
            if(opcao >=0){
             
                ec.ExcluirRelatorio(Integer.parseInt(tabelaEmprestimo.getValueAt(opcao,0).toString()));
                rc.DevolverRelatorio(Integer.parseInt(tabelaEmprestimo.getValueAt(opcao,0).toString()));
            }else{
                JOptionPane.showMessageDialog(null,"Selecione uma linha!");
            }
        }
        else if(pesquisa.equals("Midia")){
            if(opcao >=0){
                
               ec.ExcluirRelatorio(Integer.parseInt(tabelaEmprestimo.getValueAt(opcao,0).toString()));
                mc.DevolverMidia(Integer.parseInt(tabelaEmprestimo.getValueAt(opcao,0).toString()));
            }else{
                JOptionPane.showMessageDialog(null,"Selecione uma linha!");
            }
        }
        else if(pesquisa.equals("Mapa")){
            if(opcao >=0){
                
                ec.ExcluirRelatorio(Integer.parseInt(tabelaEmprestimo.getValueAt(opcao,0).toString()));
                mac.DevolverMapa(Integer.parseInt(tabelaEmprestimo.getValueAt(opcao,0).toString()));
            }else{
                JOptionPane.showMessageDialog(null,"Selecione uma linha!");
            }
        }
        else if(pesquisa.equals("Tcc")){
            if(opcao >=0){
                
                ec.ExcluirRelatorio(Integer.parseInt(tabelaEmprestimo.getValueAt(opcao,0).toString()));
                tc.DevolverTcc(Integer.parseInt(tabelaEmprestimo.getValueAt(opcao,0).toString()));
            }else{
                JOptionPane.showMessageDialog(null,"Selecione uma linha!");
            }
        }
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void btnGerenciarLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciarLivrosActionPerformed
        FormTelaGLivro formTelaGLivro = new FormTelaGLivro();
        formTelaGLivro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnGerenciarLivrosActionPerformed
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTelaGEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTelaGEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTelaGEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTelaGEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTelaGEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnEmprestar;
    private javax.swing.JButton btnFicha;
    private javax.swing.JButton btnGerenciarAlunos;
    private javax.swing.JButton btnGerenciarEmprestimo;
    private javax.swing.JButton btnGerenciarLivros;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaEmprestimo;
    private javax.swing.JTable tabelaPesquisa;
    private javax.swing.JComboBox<String> txtDevolver;
    private javax.swing.JTextField txtMatriculaAluno;
    private javax.swing.JComboBox<String> txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
