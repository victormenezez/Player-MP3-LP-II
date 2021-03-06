package screens;

import static audioplayer.UserDAO.addUser;
import static audioplayer.UserDAO.hasUser;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JTextField;
import org.json.simple.parser.ParseException;

/**
 * Tela para adicionar um novo usuario
 *
 * @author Victor Gomes
 * @author Joao Vitor
 */
public class AddUserScreen extends javax.swing.JFrame {

    InitialScreen i;

    /**
     * Cria um novo form AddUserScreen
     *
     * @param i
     */
    public AddUserScreen(InitialScreen i) {
        this.i = i;

        initComponents();

        txt_login.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                txt_login.setBorder(new JTextField().getBorder());
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txt_login.getText().equals("") || txt_login.getText().length() < 4) {
                    txt_login.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                } else {
                    txt_login.setBorder(new JTextField().getBorder());
                }
            }
        });

        password.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                password.setBorder(new JTextField().getBorder());
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (password.getPassword().length < 4) {
                    password.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                } else {
                    password.setBorder(new JTextField().getBorder());
                }
            }
        });

        password_conf.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                password_conf.setBorder(new JTextField().getBorder());
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (password_conf.getPassword().length < 4) {
                    password_conf.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                } else {
                    password_conf.setBorder(new JTextField().getBorder());
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_login = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        password_conf = new javax.swing.JPasswordField();
        btn_register = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jchek_vip = new javax.swing.JCheckBox();
        btn_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adicionar Usuário");

        txt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_loginActionPerformed(evt);
            }
        });

        btn_register.setText("Cadastrar");
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome de usuário");

        jLabel2.setText("Senha");

        jLabel3.setText("Repita a senha");

        jchek_vip.setText("Usuário Vip");

        btn_cancel.setText("Cancelar");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jchek_vip)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_login)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(password))
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(27, 27, 27)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(password_conf, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password_conf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jchek_vip)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_register)
                    .addComponent(btn_cancel))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_loginActionPerformed

    }//GEN-LAST:event_txt_loginActionPerformed

    /**
     * Cancela a adicao de um novo usuario
     * 
     * @param evt 
     */
    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    /**
     * Cadastra um novo usuario
     * 
     * @param evt 
     */
    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        try {
            String login = txt_login.getText();
            String psw = new String(password.getPassword());
            String psw_conf = new String(password_conf.getPassword());
            int vip;

            if (jchek_vip.isSelected()) {
                vip = 1;
            } else {
                vip = 0;
            }
            if (login.isEmpty() || psw.isEmpty() || psw_conf.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos",
                        "Campo inválido", ERROR_MESSAGE);
                if (login.isEmpty()) {
                    txt_login.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                }
                if (psw.isEmpty()) {
                    password.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                }
                if (psw_conf.isEmpty()) {
                    password_conf.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                }
            } else if (!hasUser(login)) {
                txt_login.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            } else if (!psw.equals(psw_conf)) {
                JOptionPane.showMessageDialog(null, "As senhas digitadas não são iguais",
                        "Senhas diferentes", ERROR_MESSAGE);
                password.setText("");
                password_conf.setText("");
            } else if (login.length() < 4) {
                JOptionPane.showMessageDialog(null, "Escolha um nome de usuário maior que 4 caracteres",
                        "Nome de Usuário Inválido", ERROR_MESSAGE);
                txt_login.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            } else if (psw.length() < 4) {
                JOptionPane.showMessageDialog(null, "Escolha uma senha maior que 4 caracteres",
                        "Campo Inválido", ERROR_MESSAGE);
                password.setText("");
                password_conf.setText("");
            } else {
                addUser(login, psw, vip);
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!",
                        "Cadastro Realizado", INFORMATION_MESSAGE);
                dispose();
            }
        } catch (ParseException | IOException ex) {
            Logger.getLogger(AddUserScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_registerActionPerformed

    @Override
    public void setDefaultCloseOperation(int operation
    ) {
        i.setEnabled(true);
        super.setDefaultCloseOperation(operation); //To change body of generated methods, choose Tools | Templates.
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_register;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JCheckBox jchek_vip;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField password_conf;
    private javax.swing.JTextField txt_login;
    // End of variables declaration//GEN-END:variables
}
