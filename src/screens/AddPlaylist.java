package screens;

import static audioplayer.Musics.insertPlaylist;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author joaovitordeon
 */
public class AddPlaylist extends javax.swing.JFrame {
    private ArrayList<String> musics;
    private String playlist_name;
    
    public AddPlaylist() {
        initComponents();
        this.setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playlist_name_input = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        add_musics_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        playlist_list = new javax.swing.JList<>();
        create_playlist_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        playlist_name_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playlist_name_inputActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Playlist name:");

        add_musics_btn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        add_musics_btn.setText("Add Musics");
        add_musics_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_musics_btnActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(playlist_list);

        create_playlist_btn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        create_playlist_btn.setText("Create playlist ");
        create_playlist_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_playlist_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playlist_name_input, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(add_musics_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(create_playlist_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(add_musics_btn)
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

    private void add_musics_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_musics_btnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setDialogTitle("Escolha as músicas a serem adicionadas");
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showOpenDialog(this);
//      
        if(result != JFileChooser.APPROVE_OPTION){
            
        }else{    
            try {
                dlm= new DefaultListModel();
                musics= new ArrayList<String>();
                
                File[] files = fileChooser.getSelectedFiles();
                
                for(File f: files){
                        this.dlm.addElement(f.getName());
                        this.musics.add(f.getName());
                    }
        
                this.playlist_list.setModel(dlm);
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  

    }//GEN-LAST:event_add_musics_btnActionPerformed
  
    private void create_playlist_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_playlist_btnActionPerformed
        try {
            //adiciona a playlist no json das playlists
            String playlist_name = (String) playlist_name_input.getText() ;
            insertPlaylist( playlist_name , musics );
            
            dispose();
            
        } catch (Exception e) {
            e.printStackTrace();
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
    private javax.swing.JButton add_musics_btn;
    private javax.swing.JButton create_playlist_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> playlist_list;
    private javax.swing.JTextField playlist_name_input;
    // End of variables declaration//GEN-END:variables
}
