
package audioplayer;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

/**
 *
 * @author joaovitordeon
 */
public class InterfaceGrafica extends javax.swing.JFrame {

    private final DefaultListModel dlm1;
    private final DefaultListModel dlm2;
   
    public InterfaceGrafica() {
       
        dlm1 = new DefaultListModel();
        dlm2 = new DefaultListModel(); 
            
        initComponents();
        
        this.setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playBtn = new javax.swing.JButton();
        pauseBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        musicsList = new javax.swing.JList<>();
        musicsLabel = new javax.swing.JLabel();
        playlistsLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        playlistsList = new javax.swing.JList<>();
        progressBar = new javax.swing.JProgressBar();
        addMusicBtn = new javax.swing.JButton();
        addDirecBtn = new javax.swing.JButton();
        addPlaylistBtn = new javax.swing.JButton();
        signOutBtn = new javax.swing.JButton();
        userNameLabel = new javax.swing.JLabel();
        profileImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AudioPlayer");
        setBackground(new java.awt.Color(255, 115, 138));
        setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        setFocusCycleRoot(false);
        setForeground(java.awt.Color.white);

        playBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        playBtn.setIcon(new javax.swing.ImageIcon("/home/joaovitordeon/Documentos/Player-MP3-LP-II/src/images/Play.gif")); // NOI18N
        playBtn.setText("Play");
        playBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playBtnActionPerformed(evt);
            }
        });

        pauseBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        pauseBtn.setIcon(new javax.swing.ImageIcon("/home/joaovitordeon/Documentos/Player-MP3-LP-II/src/images/Pause.png")); // NOI18N
        pauseBtn.setText("Pause");
        pauseBtn.setEnabled(false);
        pauseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseBtnActionPerformed(evt);
            }
        });

        nextBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        nextBtn.setText(">> Next");
        nextBtn.setEnabled(false);
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        musicsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(musicsList);

        musicsLabel.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        musicsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        musicsLabel.setText("Musics");

        playlistsLabel.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        playlistsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playlistsLabel.setText("Playlists");

        playlistsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane2.setViewportView(playlistsList);

        addMusicBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        addMusicBtn.setIcon(new javax.swing.ImageIcon("/home/joaovitordeon/Documentos/Player-MP3-LP-II/src/images/Open.png")); // NOI18N
        addMusicBtn.setText("Add Music");
        addMusicBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMusicBtnActionPerformed(evt);
            }
        });

        addDirecBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        addDirecBtn.setText("Add Direc");
        addDirecBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDirecBtnActionPerformed(evt);
            }
        });

        addPlaylistBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        addPlaylistBtn.setText("Add Playlist");
        addPlaylistBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlaylistBtnActionPerformed(evt);
            }
        });

        signOutBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        signOutBtn.setText("Sing out");

        userNameLabel.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        userNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userNameLabel.setText("User name");

        profileImage.setIcon(new javax.swing.ImageIcon("/home/joaovitordeon/Documentos/Player-MP3-LP-II/src/images/image2.png")); // NOI18N
        profileImage.setPreferredSize(new java.awt.Dimension(170, 170));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pauseBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextBtn)
                        .addGap(21, 21, 21)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addDirecBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addMusicBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(musicsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addPlaylistBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playlistsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(signOutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(profileImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(userNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(addMusicBtn)
                                .addGap(18, 18, 18)
                                .addComponent(addDirecBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(profileImage, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(signOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(playlistsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(musicsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(14, 14, 14)
                        .addComponent(addPlaylistBtn)))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(playBtn)
                        .addComponent(pauseBtn)
                        .addComponent(nextBtn))
                    .addComponent(progressBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addDirecBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDirecBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addDirecBtnActionPerformed

    
    private void addMusicBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMusicBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to add");
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            //System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            //pegar esse arquivo e jogar na playlist e usar o getName para mostrar o nome na playlist
            //System.out.println( selectedFile.getName());
            this.dlm1.addElement(selectedFile.getName());
            this.musicsList.setModel(dlm1);
            
        
        }
    }//GEN-LAST:event_addMusicBtnActionPerformed

    private void playBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playBtnActionPerformed
       
        if(null != musicsList.getSelectedValue()){
            try {
                String way ="/home/joaovitordeon/NetBeansProjects/audioplayer/src/"+musicsList.getSelectedValue();
                m = new Musics(way);
                m.playMusic();
                pauseBtn.setEnabled(true);
                nextBtn.setEnabled(true);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_playBtnActionPerformed

    private void pauseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseBtnActionPerformed
        try {
            m.stopMusic();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_pauseBtnActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nextBtnActionPerformed

    private void addPlaylistBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlaylistBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addPlaylistBtnActionPerformed

    
    
    private Musics m;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDirecBtn;
    private javax.swing.JButton addMusicBtn;
    private javax.swing.JButton addPlaylistBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel musicsLabel;
    private javax.swing.JList<String> musicsList;
    private javax.swing.JButton nextBtn;
    private javax.swing.JButton pauseBtn;
    private javax.swing.JButton playBtn;
    private javax.swing.JLabel playlistsLabel;
    private javax.swing.JList<String> playlistsList;
    private javax.swing.JLabel profileImage;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton signOutBtn;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
