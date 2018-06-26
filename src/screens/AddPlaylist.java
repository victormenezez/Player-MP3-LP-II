package screens;

import static audioplayer.Musics.getMusics;
import static audioplayer.Musics.insertPlaylist;
import static audioplayer.UserDAO.addPlaylistToUser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import org.json.simple.parser.ParseException;
import static screens.InitialScreen.updatePlaylistsList;

/**
 * Tela para adicionar uma nova playlist
 *
 * @author Joao Vitor
 * @author Victor Gomes
 */
public class AddPlaylist extends javax.swing.JFrame {
    private final ArrayList<String> musics;
    private String playlist_name;
    private String username;
    
    /**
     * Cria um novo form AddPlaylist
     * 
     * @param username nome do usuario logado
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException 
     */
    public AddPlaylist(String username) 
            throws IOException, FileNotFoundException, ParseException {
        initComponents();
        
        this.username=username;
        musics=getMusics();
        dlm = new DefaultListModel();
       
        if(musics != null){ 
            for (String s : musics) {this.dlm.addElement(s);
            }
        }
       
        this.playlist_list.setModel(dlm);
        
        this.setVisible(true);
    }

    private AddPlaylist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playlist_name_input = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        playlist_list = new javax.swing.JList<>();
        create_playlist_btn = new javax.swing.JButton();
        seletc_musics_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        playlist_name_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playlist_name_inputActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Playlist name:");

        jScrollPane1.setViewportView(playlist_list);

        create_playlist_btn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        create_playlist_btn.setText("Create playlist ");
        create_playlist_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_playlist_btnActionPerformed(evt);
            }
        });

        seletc_musics_label.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        seletc_musics_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seletc_musics_label.setText("Select musics to create the playlist:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(create_playlist_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playlist_name_input, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seletc_musics_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playlist_name_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(seletc_musics_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(create_playlist_btn)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void playlist_name_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playlist_name_inputActionPerformed
        
    }//GEN-LAST:event_playlist_name_inputActionPerformed
  
    private void create_playlist_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_playlist_btnActionPerformed
        
        playlist_name = (String) playlist_name_input.getText() ;
        List<String> aux1 = playlist_list.getSelectedValuesList();
        ArrayList<String> aux2 = new ArrayList<>(aux1);
        
        if(playlist_name.length() == 0 || playlist_list.isSelectionEmpty() == true  ){
            JOptionPane.showMessageDialog(this, "Voce precisa colocar um nome e selecionar musicas.", "OPS...Esta faltando algo!", ERROR_MESSAGE);
        }
        
        else{    
            try{
               
                if(insertPlaylist(playlist_name , aux2 )){
                    System.out.println(username + " "+ playlist_name);
                    addPlaylistToUser(username, playlist_name);
                    updatePlaylistsList();
                }
                
                dispose();

            }catch (IOException | ParseException e) {
                
            }
        }
        
    }//GEN-LAST:event_create_playlist_btnActionPerformed

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
            java.util.logging.Logger.getLogger(AddPlaylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPlaylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPlaylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPlaylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPlaylist().setVisible(true);
            }
        });
    }

    
    private DefaultListModel dlm;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton create_playlist_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> playlist_list;
    private javax.swing.JTextField playlist_name_input;
    private javax.swing.JLabel seletc_musics_label;
    // End of variables declaration//GEN-END:variables
}
