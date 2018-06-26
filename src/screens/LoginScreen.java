package screens;

import audioplayer.Audioplayer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import static audioplayer.UserDAO.readUserJson;

/**
 *
 * @author Joao Vitor
 * @author Victor Gomes
 */
public class LoginScreen extends javax.swing.JFrame {

    InitialScreen initial;

    /**
     * Cria um novo form LoginScreen 
     */
    public LoginScreen() {
        initComponents();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_login = new javax.swing.JButton();
        txt_login = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_login)
                    .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(txt_login))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_login)
                .addGap(94, 94, 94))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Realiza o login
     * 
     * @param evt 
     */
    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        String login_screen = txt_login.getText();
        String psw_screen = new String(password.getPassword());
        JSONArray users_list;
        boolean isLogged = false;
        boolean isVip;
        try {
            users_list = readUserJson();
            for (Object o : users_list) {
                JSONObject jobj = (JSONObject) o;
                String login = (String) jobj.get("login");
                String psw = (String) jobj.get("password");
                if (login.equalsIgnoreCase(login_screen) && psw.equals(psw_screen)) {
                    isVip = (long) jobj.get("vip") == 1;
                    initial = new InitialScreen(isVip, login);
                    isLogged = true;
                    dispose();
                }
            }
            if(!isLogged)
                JOptionPane.showMessageDialog(this, "Nome de usuário ou senha inválidos. Tente novamente.", "Login Inválido", ERROR_MESSAGE);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Audioplayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField txt_login;
    // End of variables declaration//GEN-END:variables
}
