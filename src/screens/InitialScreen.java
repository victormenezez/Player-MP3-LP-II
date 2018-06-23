
package screens;

import audioplayer.Musics;
import static audioplayer.UserDAO.getPlaylistsNames;

import static audioplayer.Musics.deleteMusic;
import static audioplayer.Musics.getMusics;
import static audioplayer.Musics.getPlaylist;
import static audioplayer.Musics.insertMusic;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.json.simple.parser.ParseException;

/**
 *
 * @author joaovitordeon
 */
public class InitialScreen extends javax.swing.JFrame {
    private final boolean vip;
    private static String username;
    private DefaultListModel dlm1;
    private static DefaultListModel dlm2;
    Musics m = new Musics();
    AddPlaylist playlists;
    
    public InitialScreen(boolean vip, String username) throws IOException, FileNotFoundException, ParseException {
        this.vip = vip;
        InitialScreen.username = username;
        
        initComponents();
        
        if(vip) updatePlaylistsList();
        
        if(!vip) addPlaylistBtn.setEnabled(false); 
       
        dlm1 = new DefaultListModel();
        refreshMusicsList();
        
        user_name_label.setText(username);
        this.setVisible(true);
    }
    //-----------------------------------------------------------------------------------
    
    public static void updatePlaylistsList() throws IOException, FileNotFoundException, ParseException{
        dlm2 = new DefaultListModel(); 
            ArrayList<String> array; 
        array = getPlaylistsNames(username);
            if(array != null){
                for(String s: array){
                    dlm2.addElement(s);
                }
                playlistsList.setModel(dlm2);
            }
    
    }
    
    private void refreshMusicsList() throws IOException, FileNotFoundException, ParseException{
        ArrayList<String> usermusics = getMusics();
        
        if(getMusics() != null){
            dlm1.clear();
            
            for (String s : usermusics) {
                this.dlm1.addElement(s);
            }
        
            this.musicsList.setModel(dlm1);
        }
    
    }
    
    private void updateMusicsList(String playlist_name) throws IOException, FileNotFoundException, ParseException{
        ArrayList<String> musics = getPlaylist(playlist_name);
        
        if(getMusics() != null){
            dlm1.clear();
            
            for (String s : musics) {
                this.dlm1.addElement(s);
            }
        
            this.musicsList.setModel(dlm1);
        }
    
    }
    //--------------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_play = new javax.swing.JButton();
        btn_stop = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
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
        user_name_label = new javax.swing.JLabel();
        profileImage = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        btn_pause = new javax.swing.JButton();
        allSongsBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AudioPlayer");
        setBackground(new java.awt.Color(255, 115, 138));
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setFocusCycleRoot(false);
        setForeground(java.awt.Color.white);

        btn_play.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btn_play.setText("Play");
        btn_play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_playActionPerformed(evt);
            }
        });

        btn_stop.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btn_stop.setText("Stop");
        btn_stop.setEnabled(false);
        btn_stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_stopActionPerformed(evt);
            }
        });

        btn_next.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btn_next.setText(">> Next");
        btn_next.setEnabled(false);
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        musicsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        musicsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                musicsListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(musicsList);

        musicsLabel.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        musicsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        musicsLabel.setText("Musics");

        playlistsLabel.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        playlistsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playlistsLabel.setText("Playlists");

        playlistsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        playlistsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playlistsListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(playlistsList);

        addMusicBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
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
        signOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutBtnActionPerformed(evt);
            }
        });

        user_name_label.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        user_name_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user_name_label.setText("User name");

        profileImage.setPreferredSize(new java.awt.Dimension(170, 170));

        deleteBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        deleteBtn.setText("Delete Music");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        btn_pause.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btn_pause.setText("Pause");
        btn_pause.setEnabled(false);
        btn_pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pauseActionPerformed(evt);
            }
        });

        allSongsBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        allSongsBtn.setText("Refresh songs");
        allSongsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allSongsBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_play)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_pause)
                        .addGap(12, 12, 12)
                        .addComponent(btn_stop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_next)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addDirecBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addMusicBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(musicsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(allSongsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addPlaylistBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(playlistsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(signOutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(profileImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(user_name_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(user_name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(addMusicBtn)
                                .addGap(38, 38, 38)
                                .addComponent(deleteBtn)
                                .addGap(38, 38, 38)
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
                            .addComponent(jScrollPane2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addPlaylistBtn)
                    .addComponent(allSongsBtn))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_play)
                        .addComponent(btn_next)
                        .addComponent(btn_pause)
                        .addComponent(btn_stop))
                    .addComponent(progressBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addDirecBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDirecBtnActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Escolha varias músicas para serem adicionadas");
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        //chooser.setMultiSelectionEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showOpenDialog(this);
        if(result== JFileChooser.APPROVE_OPTION){
             try {
                File f = chooser.getSelectedFile();
                File[] filesList = f.listFiles();
                 for (File file : filesList) {
                     this.dlm1.addElement(file.getName());
                     this.musicsList.setModel(dlm1);
                     System.out.println(file.getName());
                     System.out.println(file.getAbsolutePath());
                     insertMusic(file.getName(),file.getAbsolutePath());
                 }
            } catch (IOException | ParseException ex) {
                System.out.println(ex);
            }
        
        }
         
    }//GEN-LAST:event_addDirecBtnActionPerformed

    private void addMusicBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMusicBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Escolha a música a ser adicionada");
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
//        String repeated_songs[] = null;
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = fileChooser.getSelectedFile();
                //pegar esse arquivo e jogar na playlist e usar o getName para 
                //mostrar o nome na playlist
                this.dlm1.addElement(selectedFile.getName());
                this.musicsList.setModel(dlm1);
                //adiciona a musica no json
                insertMusic(selectedFile.getName(), selectedFile.getAbsolutePath());
                System.out.println("Musica inserida");
                
            } catch (IOException | ParseException ex) {
                System.out.println(ex);
            }
           
        }
    }//GEN-LAST:event_addMusicBtnActionPerformed

    private void btn_playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_playActionPerformed
            
        if(null != musicsList.getSelectedValue()){
            try {
                if(m.getPaused() == false){
                    if(m.getPlaying() == true)  m.stopMusic();
                   
                    m.playMusic( (String) musicsList.getSelectedValue());
                    
                    btn_stop.setEnabled(true);
                    btn_next.setEnabled(true);
                    btn_pause.setEnabled(true);
                    
                }
                else{
                    btn_play.setEnabled(true);
                    m.resumeMusic();
                    m.setPausedStatus(false);
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btn_playActionPerformed

    private void btn_stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_stopActionPerformed
        try {
            m.stopMusic();
            btn_pause.setEnabled(false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btn_stopActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        int index=musicsList.getSelectedIndex();
        
        try {
            m.stopMusic();
            musicsList.setSelectedIndex(index+1);
            m.playMusic( (String) musicsList.getSelectedValue());
            btn_pause.setEnabled(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btn_nextActionPerformed

    private void addPlaylistBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlaylistBtnActionPerformed
         if(this.vip) {
             
            try {
                playlists = new AddPlaylist(username);
                
            }catch (IOException | ParseException e){
            
            }
        }   
            
    }//GEN-LAST:event_addPlaylistBtnActionPerformed

    private void musicsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_musicsListValueChanged
       
    }//GEN-LAST:event_musicsListValueChanged

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if(null != musicsList.getSelectedValue()){
           try {
              
               deleteMusic(musicsList.getSelectedValue());
               this.dlm1.removeElement(musicsList.getSelectedValue());
               this.musicsList.setModel(dlm1);

            } catch (IOException | ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void signOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutBtnActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja sair do sistema?", "",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            LoginScreen login = new LoginScreen();
            dispose();
        }
    }//GEN-LAST:event_signOutBtnActionPerformed

    private void btn_pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pauseActionPerformed
        try {
            m.pauseMusic();
            m.setPausedStatus(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btn_pauseActionPerformed

    private void playlistsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playlistsListMouseClicked
        
        if (evt.getClickCount() == 2) {
            int index = playlistsList.locationToIndex(evt.getPoint());
            String str = (String) dlm2.getElementAt(index);
            
            try {
                updateMusicsList(str);
                
            }catch (IOException | ParseException e) {
                
            }
            
        }
    }//GEN-LAST:event_playlistsListMouseClicked

    private void allSongsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allSongsBtnActionPerformed
        try {
            this.refreshMusicsList();
            
        }catch (IOException | ParseException e) {
            
        }
        
    }//GEN-LAST:event_allSongsBtnActionPerformed
   
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDirecBtn;
    private javax.swing.JButton addMusicBtn;
    private javax.swing.JButton addPlaylistBtn;
    private javax.swing.JButton allSongsBtn;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_pause;
    private javax.swing.JButton btn_play;
    private javax.swing.JButton btn_stop;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel musicsLabel;
    private javax.swing.JList<String> musicsList;
    private javax.swing.JLabel playlistsLabel;
    private static javax.swing.JList<String> playlistsList;
    private javax.swing.JLabel profileImage;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton signOutBtn;
    private javax.swing.JLabel user_name_label;
    // End of variables declaration//GEN-END:variables
}
