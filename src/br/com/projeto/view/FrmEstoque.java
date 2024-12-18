/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.projeto.view;

import br.com.projeto.dao.FornecedoresDAO;
import br.com.projeto.dao.ProdutosDAO;
import br.com.projeto.model.Fornecedores;
import br.com.projeto.model.Produtos;
import br.com.projeto.model.Utilitarios;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class FrmEstoque extends javax.swing.JFrame {

    int idproduto, qtd_nova;

    // Metodo Listar
    public void listarProdutos() {

        ProdutosDAO dao = new ProdutosDAO();
        List<Produtos> lista = dao.listarProdutos();
        DefaultTableModel dados = (DefaultTableModel) tabelaEstoque.getModel();
        dados.setNumRows(0);

        for (Produtos c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getDescricao(),
                c.getPreco(),
                c.getQtd_estoque(),
                c.getFornecedor().getNome(),});
        }
    }

    public FrmEstoque() {
        initComponents();
        this.getContentPane().setBackground(Color.white);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ConsutaProdutos = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        txtdescricao = new javax.swing.JTextField();
        btnpesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEstoque = new javax.swing.JTable();
        jLabel116 = new javax.swing.JLabel();
        txtestoque = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        txtqtd = new javax.swing.JTextField();
        brnadicionar = new javax.swing.JButton();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        txtdiminuir = new javax.swing.JTextField();
        brnDiminuir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Controle de Estoque");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tst.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ConsutaProdutos.setBackground(new java.awt.Color(255, 255, 255));

        jLabel115.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel115.setText("Descrição:");

        txtdescricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtdescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescricaoActionPerformed(evt);
            }
        });

        btnpesquisar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnpesquisar.setText("Pesquisar");
        btnpesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesquisarActionPerformed(evt);
            }
        });

        tabelaEstoque.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabelaEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Preço", "Qtd.Estoque", "Fornecedor"
            }
        ));
        tabelaEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEstoqueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaEstoque);

        jLabel116.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel116.setText("Estoque Atual:");

        txtestoque.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtestoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtestoqueActionPerformed(evt);
            }
        });

        jLabel117.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel117.setText("Qtd:");

        txtqtd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtqtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqtdActionPerformed(evt);
            }
        });

        brnadicionar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        brnadicionar.setText("Adicionar");
        brnadicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnadicionarActionPerformed(evt);
            }
        });

        jLabel118.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel118.setText("Lista de Produtos:");

        jLabel119.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel119.setText("Qtd:");

        txtdiminuir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtdiminuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiminuirActionPerformed(evt);
            }
        });

        brnDiminuir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        brnDiminuir.setText("Diminuir");
        brnDiminuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnDiminuirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel115)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtdescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnpesquisar))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel116)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtestoque, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(599, 599, 599))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel118)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel117)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtqtd))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel119)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtdiminuir, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(brnadicionar)
                                    .addComponent(brnDiminuir))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel115)
                    .addComponent(txtdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpesquisar))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel116)
                    .addComponent(txtestoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel119)
                            .addComponent(txtdiminuir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel117)
                            .addComponent(txtqtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(brnDiminuir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(brnadicionar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel118)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        ConsutaProdutos.addTab("Consultar de Produtos", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ConsutaProdutos)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConsutaProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // Carrega Lista
        listarProdutos();
    }//GEN-LAST:event_formWindowActivated

    private void tabelaEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEstoqueMouseClicked
        idproduto = Integer.parseInt(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 0).toString());
        txtdescricao.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 1).toString());
        txtestoque.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_tabelaEstoqueMouseClicked

    private void btnpesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesquisarActionPerformed
        // Botão pesquisar
        String nome = "%" + txtdescricao.getText() + "%";

        ProdutosDAO dao = new ProdutosDAO();
        List<Produtos> lista = dao.buscarProdutosPorNome(nome);
        DefaultTableModel dados = (DefaultTableModel) tabelaEstoque.getModel();
        dados.setNumRows(0);

        for (Produtos c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getDescricao(),
                c.getPreco(),
                c.getQtd_estoque(),
                c.getFornecedor().getNome(),});
        }
    }//GEN-LAST:event_btnpesquisarActionPerformed

    private void txtdescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescricaoActionPerformed

    private void txtestoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtestoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtestoqueActionPerformed

    private void txtqtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqtdActionPerformed

    private void brnadicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnadicionarActionPerformed
        // botao add produto no estoque
        try {
            int qtd_estoque, qtd_atualizada, qtd;

            qtd_estoque = Integer.parseInt(txtestoque.getText());
            qtd = Integer.parseInt(txtqtd.getText());
            qtd_nova = qtd_estoque + qtd;

            ProdutosDAO dao = new ProdutosDAO();
            dao.adiconarEstoque(idproduto, qtd_nova);

            JOptionPane.showMessageDialog(null, "Estoque do Produto Atualizada!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecione o Produto e informa a nova qtd!" + e);
        }
    }//GEN-LAST:event_brnadicionarActionPerformed

    private void txtdiminuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiminuirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiminuirActionPerformed

    private void brnDiminuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnDiminuirActionPerformed
        // Botao de diminuir
        try {
            try {
                int qtd_estoque, qtd, qtd_nova;

                // Pega os valores do estoque atual e da quantidade informada
                qtd_estoque = Integer.parseInt(txtestoque.getText()); // Estoque atual
                qtd = Integer.parseInt(txtdiminuir.getText());             // Quantidade informada

                // Verifica se a operação é para somar ou subtrair
                if (qtd_estoque >= qtd) {
                    // Atualiza o estoque subtraindo a quantidade informada
                    qtd_nova = qtd_estoque - qtd;

                    ProdutosDAO dao = new ProdutosDAO();
                    dao.DiminuirEstoque(idproduto, qtd_nova); // Chame o método no DAO para atualizar

                    JOptionPane.showMessageDialog(null, "Estoque do Produto Atualizado! Nova quantidade: " + qtd_nova);
                    listarProdutos(); // Atualiza a tabela de produtos
                } else {
                    JOptionPane.showMessageDialog(null, "Quantidade insuficiente no estoque!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: Selecione o Produto e informe a quantidade válida! " + e.getMessage());
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_brnDiminuirActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmEstoque().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTabbedPane ConsutaProdutos;
    private javax.swing.JButton brnDiminuir;
    private javax.swing.JButton brnadicionar;
    private javax.swing.JButton btnpesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaEstoque;
    private javax.swing.JTextField txtdescricao;
    private javax.swing.JTextField txtdiminuir;
    private javax.swing.JTextField txtestoque;
    private javax.swing.JTextField txtqtd;
    // End of variables declaration//GEN-END:variables

    private static class DefaultTable {

        public DefaultTable() {
        }
    }
}
