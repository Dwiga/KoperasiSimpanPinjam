/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static javax.print.attribute.Size2DSyntax.MM;
import static javax.swing.BorderFactory.createTitledBorder;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author MF
 */
public class Form_Simpanan2 extends javax.swing.JFrame {
private Dimension screensize;
 Connection con;
Statement sta;
ResultSet rs;
DefaultTableModel tbm;
String tanggal;
    private Border createTitleBorder;
    private String tanggal5;
    private String tanggal6;
    private String tanggal4;
    /**
     * Creates new form Form_Simpanan2
     */
    public Form_Simpanan2() {
        initComponents();
        panel_pertama.setVisible(false);
        panel_lanjutan.setVisible(false);
        txtbesar_simpanan_pertama.setText("200000");
        txtbesar_simpananbayar.setText("200000");
        txtbesar_simpanan_pertama.setEnabled(false);
        txtbesar_simpananbayar.setEnabled(false);
        
        tgl_sekarang();
        date_sukarela.setEnabled(false);
        panel_pertama.setBorder(createTitledBorder("TRANSAKSI PERTAMA"));
        panel_lanjutan.setBorder(createTitledBorder("TRANSAKSI LANJUTAN"));
        
         screensize = Toolkit.getDefaultToolkit().getScreenSize();
          setLocation((screensize.width / 2) - (getSize().width / 2), (screensize.height / 2) - (getSize().height / 2));
          
         koneksi DB = new koneksi();
            DB.config();
            con = DB.con;
            sta = DB.stm;
            
            id_petugas();
            id_petugas_simpan_pertama();
            id_petugas_simpan_lanjutan();
            
    }

    private void id_petugas() {
        try {
            String sql;
            sql = ("SELECT id_anggota FROM anggota");
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                cmb_anggota.addItem(rs.getString("id_anggota"));
                
            } 
        } catch (Exception e) {
        }
    }
    
    private void id_petugas_simpan_pertama() {
        try {
            String sql;
            sql = ("SELECT id_anggota FROM anggota WHERE ket='-'");
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                cmbanggota_pertama.addItem(rs.getString("id_anggota"));
                
            } 
        } catch (Exception e) {
        }
    }
    
    private void id_petugas_simpan_lanjutan() {
        try {
            String sql;
            sql = ("SELECT id_anggota FROM anggota WHERE ket='menyimpan'");
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                cmbanggota_lanjutan.addItem(rs.getString("id_anggota"));
                
            } 
        } catch (Exception e) {
        }
    }
    
    private void tgl_sekarang() {
    Date date = new Date();
    date_sukarela.setDate(date);
    date_pembayaran.setDate(date);
    date_pembayaran_pertama.setDate(date);
            
}
    
    private void masuktabel() {
       try{
                sta = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                tbm = new DefaultTableModel();
                tbm.addColumn("ID Simpanan");
                tbm.addColumn("ID Anggota");
                tbm.addColumn("Nama");
                tbm.addColumn("TGL Simpanan");
                tbm.addColumn("Besar Simpanan");
                tbm.addColumn("KET");
                
                tblsimpanan_lanjutan.setModel(tbm);
                rs = sta.executeQuery("SELECT simpanan.id_simpanan,simpanan.id_anggota,anggota.nama,simpanan.tgl_simpanan,simpanan.besar_simpanan,simpanan.ket FROM simpanan,anggota WHERE simpanan.id_anggota=anggota.id_anggota AND simpanan.nm_simpanan='Simpanan Wajib' AND simpanan.id_anggota='"+ cmbanggota_lanjutan.getSelectedItem() +"'");
                while (rs.next()){
                    tbm.addRow(new Object[]{
                    rs.getString("id_simpanan"),
                    rs.getString("id_anggota"),
                    rs.getString("nama"),
                    rs.getString("tgl_simpanan"),
                    rs.getString("besar_simpanan"),
                    rs.getString("ket"),
                    
                });
                    tblsimpanan_lanjutan.setModel(tbm);
                    }
                }catch(Exception e){
                        JOptionPane.showMessageDialog(rootPane,"Gagal"+e);
                        
                    }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmb_anggota = new javax.swing.JComboBox();
        date_sukarela = new com.toedter.calendar.JDateChooser();
        txtbesar_sukarela = new javax.swing.JTextField();
        txtket_sukarela = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        panel_lanjutan = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cmbanggota_lanjutan = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        date_pembayaran = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        date_terakhir_membayar = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        txtbesar_simpananbayar = new javax.swing.JTextField();
        btnbayar_lanjutan = new javax.swing.JButton();
        btnbtal_lanjutan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsimpanan_lanjutan = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cmbopsi = new javax.swing.JComboBox();
        panel_pertama = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmbanggota_pertama = new javax.swing.JComboBox();
        date_pembayaran_pertama = new com.toedter.calendar.JDateChooser();
        txtbesar_simpanan_pertama = new javax.swing.JTextField();
        btnbayar_simpanan_lanjutan = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("ID Anggota");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Tgl Simpanan");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Besar Simpanan");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Keterangan");

        cmb_anggota.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "------pilihan--------" }));

        date_sukarela.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                date_sukarelaPropertyChange(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setText("BAYAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton2.setText("BATAL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(190, 190, 190)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(date_sukarela, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(174, 174, 174)
                        .addComponent(txtbesar_sukarela, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(202, 202, 202)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtket_sukarela, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmb_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(date_sukarela, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtbesar_sukarela, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtket_sukarela, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(250, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Simpanan Sukarela", jPanel1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        panel_lanjutan.setBackground(new java.awt.Color(255, 255, 255));
        panel_lanjutan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("ID Anggota");

        cmbanggota_lanjutan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---------pilihan----------" }));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setText("Tanggal Pembayaran");

        date_pembayaran.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                date_pembayaranPropertyChange(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setText("Tanggal Terakhir Membayar");

        date_terakhir_membayar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                date_terakhir_membayarPropertyChange(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setText("Besar Simpanan");

        btnbayar_lanjutan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnbayar_lanjutan.setText("BAYAR");
        btnbayar_lanjutan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbayar_lanjutanActionPerformed(evt);
            }
        });

        btnbtal_lanjutan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnbtal_lanjutan.setText("BATAL");
        btnbtal_lanjutan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbtal_lanjutanActionPerformed(evt);
            }
        });

        tblsimpanan_lanjutan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblsimpanan_lanjutan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsimpanan_lanjutanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblsimpanan_lanjutan);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton3.setText("TAMPILKAN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_lanjutanLayout = new javax.swing.GroupLayout(panel_lanjutan);
        panel_lanjutan.setLayout(panel_lanjutanLayout);
        panel_lanjutanLayout.setHorizontalGroup(
            panel_lanjutanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_lanjutanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_lanjutanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_lanjutanLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnbayar_lanjutan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnbtal_lanjutan))
                    .addGroup(panel_lanjutanLayout.createSequentialGroup()
                        .addGroup(panel_lanjutanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jButton3)
                            .addGroup(panel_lanjutanLayout.createSequentialGroup()
                                .addGroup(panel_lanjutanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGroup(panel_lanjutanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_lanjutanLayout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addGroup(panel_lanjutanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbanggota_lanjutan, 0, 145, Short.MAX_VALUE)
                                            .addComponent(date_pembayaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtbesar_simpananbayar)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_lanjutanLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(date_terakhir_membayar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_lanjutanLayout.setVerticalGroup(
            panel_lanjutanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_lanjutanLayout.createSequentialGroup()
                .addGroup(panel_lanjutanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel_lanjutanLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel_lanjutanLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(cmbanggota_lanjutan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(date_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panel_lanjutanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(date_terakhir_membayar, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panel_lanjutanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtbesar_simpananbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(panel_lanjutanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbtal_lanjutan)
                    .addComponent(btnbayar_lanjutan))
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel7.setText("Opsi Pembayaran : ");

        cmbopsi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--------pilihan-------", "Transaksi Pertama", "Transaksi Lanjutan" }));
        cmbopsi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbopsiMouseClicked(evt);
            }
        });
        cmbopsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbopsiActionPerformed(evt);
            }
        });

        panel_pertama.setBackground(new java.awt.Color(255, 255, 255));
        panel_pertama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setText("ID Anggota");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setText("Tanggal Pembayaran");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setText("Besar Simpanan");

        cmbanggota_pertama.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---------pilihan---------" }));

        date_pembayaran_pertama.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                date_pembayaran_pertamaPropertyChange(evt);
            }
        });

        txtbesar_simpanan_pertama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbesar_simpanan_pertamaActionPerformed(evt);
            }
        });

        btnbayar_simpanan_lanjutan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnbayar_simpanan_lanjutan.setText("BAYAR");
        btnbayar_simpanan_lanjutan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbayar_simpanan_lanjutanActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton5.setText("BATAL");

        javax.swing.GroupLayout panel_pertamaLayout = new javax.swing.GroupLayout(panel_pertama);
        panel_pertama.setLayout(panel_pertamaLayout);
        panel_pertamaLayout.setHorizontalGroup(
            panel_pertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_pertamaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_pertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_pertamaLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbanggota_pertama, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_pertamaLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(date_pembayaran_pertama, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_pertamaLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtbesar_simpanan_pertama, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_pertamaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnbayar_simpanan_lanjutan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        panel_pertamaLayout.setVerticalGroup(
            panel_pertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_pertamaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panel_pertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cmbanggota_pertama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panel_pertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_pertamaLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel12))
                    .addGroup(panel_pertamaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(date_pembayaran_pertama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panel_pertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtbesar_simpanan_pertama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(panel_pertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(btnbayar_simpanan_lanjutan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel14.setText("Simpanan wajib adalah simpanan yang dibayar setiap bulan ");

        jLabel15.setText("dan besarnya simpanan wajib ditetapkan/disepakati oleh seluruh anggota koperasi. ");

        jLabel16.setText("Simpanan wajib tidak bisa diambil oleh anggota kecuali anggota tersebut keluar dari koperasi.");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(panel_lanjutan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel_pertama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbopsi, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbopsi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_lanjutan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(panel_pertama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Simpanan Wajib", jPanel4);

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton4.setText("KELUAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(85, 85, 85))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void date_sukarelaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_date_sukarelaPropertyChange
        if (date_sukarela.getDate()!=null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            tanggal = simpleDateFormat.format(date_sukarela.getDate());}
        // TODO add your handling code here:
    }//GEN-LAST:event_date_sukarelaPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String bsr = txtbesar_sukarela.getText();
        int besar_simpanan = Integer.parseInt(bsr);
        if (txtbesar_sukarela.getText().equals("") || txtket_sukarela.getText().equals("") || cmb_anggota.getSelectedItem().equals("------pilihan--------")){
            JOptionPane.showMessageDialog(rootPane, "Masukkan Semua Data");
        }
        else if (besar_simpanan < 20000) {
            JOptionPane.showMessageDialog(rootPane, "Simpanan Harus Diatas 20.000");
        }
        else {
            try {
                String sql2;
                sql2 = ("INSERT INTO simpanan(nm_simpanan,id_anggota,tgl_simpanan,besar_simpanan,ket) VALUES('Simpanan Sukarela','"+ cmb_anggota.getSelectedItem()+"','"+ tanggal +"','"+ txtbesar_sukarela.getText() +"','"+ txtket_sukarela.getText() +"')");
                sta.executeUpdate(sql2);
                JOptionPane.showMessageDialog(rootPane, "BERHASIL");
                new Form_Simpanan2().setVisible(true);
                this.dispose();
            } catch (Exception e) {
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void date_pembayaranPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_date_pembayaranPropertyChange
        if (date_pembayaran.getDate()!=null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            tanggal4 = simpleDateFormat.format(date_pembayaran.getDate());}
        // TODO add your handling code here:
    }//GEN-LAST:event_date_pembayaranPropertyChange

    private void date_terakhir_membayarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_date_terakhir_membayarPropertyChange
        if (date_terakhir_membayar.getDate()!=null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            tanggal5 = simpleDateFormat.format(date_terakhir_membayar.getDate());}
        // TODO add your handling code here:
    }//GEN-LAST:event_date_terakhir_membayarPropertyChange

    private void btnbayar_lanjutanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbayar_lanjutanActionPerformed
        try{
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date bayar = df.parse(tanggal4);
            Date sebelum = df.parse(tanggal5);
            long bayar1 = bayar.getTime();
            long sebelum1 = sebelum.getTime();
            long diff = bayar1-sebelum1;
            long lama = diff/(24*60*60*1000);
            String hari = (Long.toString(lama));
            int harih = Integer.valueOf(hari);

            if (harih<31) {
                JOptionPane.showMessageDialog(rootPane, "Satu Bulan Sekali WAL");
            } else if (harih>=40) {
                String denda1 = txtbesar_simpananbayar.getText();
                int denda = Integer.valueOf(denda1);
                int hasil_akhir = denda+50000;
                int penjumlahan = denda+hasil_akhir;
                String hasil_akhir2 = (Integer.toString(penjumlahan));
                txtbesar_simpananbayar.setText(hasil_akhir2);
                int msgbo = JOptionPane.showConfirmDialog(null, "Anggota mendapatkan denda sebesar = 50000","Pertanyaan",JOptionPane.OK_OPTION);
                if (msgbo == JOptionPane.OK_OPTION) {
                    String sql;
                sql = ("UPDATE simpanan set tgl_simpanan='"+ tanggal4 +"', besar_simpanan='"+ penjumlahan +"' WHERE id_anggota='"+ cmbanggota_lanjutan.getSelectedItem()+"' AND nm_simpanan='Simpanan Wajib'");
                sta.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "BERHASIL");
                new Form_Simpanan2().setVisible(true);
                this.dispose();
                } 
            } else if (harih>=31&&harih<40) {
                String biaya = txtbesar_simpanan_pertama.getText();
                int biaya2 = Integer.valueOf(biaya);
                int hasilnya = biaya2+200000;
                String sql2;
                sql2 = ("UPDATE simpanan set tgl_simpanan='"+ tanggal4 +"',besar_simpanan='"+ hasilnya +"' WHERE id_anggota='"+ cmbanggota_lanjutan.getSelectedItem()+"' AND nm_simpanan='Simpanan Wajib'");
                sta.executeUpdate(sql2);
                JOptionPane.showMessageDialog(rootPane, "BERHASIL");
                new Form_Simpanan2().setVisible(true);
                this.dispose();
            }

        }catch (Exception e){
            System.out.println(""+ e.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbayar_lanjutanActionPerformed

    private void btnbtal_lanjutanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbtal_lanjutanActionPerformed
        cmbanggota_lanjutan.setSelectedItem("---------pilihan----------");
        date_terakhir_membayar.setDate(null);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnbtal_lanjutanActionPerformed

    private void tblsimpanan_lanjutanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsimpanan_lanjutanMouseClicked
        try {
            String tanggal3 = String.valueOf(tblsimpanan_lanjutan.getValueAt(tblsimpanan_lanjutan.getSelectedRow(), 3))+"";
            Date date;
            try {

                date = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal3);
                date_terakhir_membayar.setDate(date);
            } catch (Exception e) {
            }
        txtbesar_simpananbayar.setText(tbm.getValueAt(tblsimpanan_lanjutan.getSelectedRow(), 4)+"");} catch (Exception e) {
        }
            
        // TODO add your handling code here:
    }//GEN-LAST:event_tblsimpanan_lanjutanMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        masuktabel();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cmbopsiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbopsiMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbopsiMouseClicked

    private void cmbopsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbopsiActionPerformed
        if(cmbopsi.getSelectedItem().equals("--------pilihan-------")){
            panel_pertama.setVisible(false);
            panel_lanjutan.setVisible(false);
        }
        else if (cmbopsi.getSelectedItem().equals("Transaksi Pertama")) {
            panel_lanjutan.setVisible(false);
            panel_pertama.setVisible(true);
        }
        else if (cmbopsi.getSelectedItem().equals("Transaksi Lanjutan")) {
            panel_lanjutan.setVisible(true);
            panel_pertama.setVisible(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbopsiActionPerformed

    private void date_pembayaran_pertamaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_date_pembayaran_pertamaPropertyChange
        if (date_pembayaran_pertama.getDate()!=null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            tanggal6 = simpleDateFormat.format(date_pembayaran_pertama.getDate());}
        // TODO add your handling code here:
    }//GEN-LAST:event_date_pembayaran_pertamaPropertyChange

    private void txtbesar_simpanan_pertamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbesar_simpanan_pertamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbesar_simpanan_pertamaActionPerformed

    private void btnbayar_simpanan_lanjutanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbayar_simpanan_lanjutanActionPerformed
        if (txtbesar_simpanan_pertama.getText().equals("") || cmbanggota_pertama.getSelectedItem().equals("---------pilihan---------")) {
            JOptionPane.showMessageDialog(rootPane, "Isi Semua Data");
        } else {
            try {
                String sql2,sql;
                sql2 = ("INSERT INTO simpanan(nm_simpanan,id_anggota,tgl_simpanan,besar_simpanan,ket) VALUES('Simpanan Wajib','"+ cmbanggota_pertama.getSelectedItem()+"','"+ tanggal6 +"','"+ txtbesar_simpanan_pertama.getText() +"','-')");
                sta.executeUpdate(sql2);
                sql = ("UPDATE anggota set ket='menyimpan' WHERE id_anggota='"+ cmbanggota_pertama.getSelectedItem()+"'");
                sta.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "BERHASIL");
                new Form_Simpanan2().setVisible(true);
                this.dispose();
            } catch (Exception e) {
            } }
            // TODO add your handling code here:
    }//GEN-LAST:event_btnbayar_simpanan_lanjutanActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Simpanan2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Simpanan2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Simpanan2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Simpanan2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Simpanan2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbayar_lanjutan;
    private javax.swing.JButton btnbayar_simpanan_lanjutan;
    private javax.swing.JButton btnbtal_lanjutan;
    private javax.swing.JComboBox cmb_anggota;
    private javax.swing.JComboBox cmbanggota_lanjutan;
    private javax.swing.JComboBox cmbanggota_pertama;
    private javax.swing.JComboBox cmbopsi;
    private com.toedter.calendar.JDateChooser date_pembayaran;
    private com.toedter.calendar.JDateChooser date_pembayaran_pertama;
    private com.toedter.calendar.JDateChooser date_sukarela;
    private com.toedter.calendar.JDateChooser date_terakhir_membayar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panel_lanjutan;
    private javax.swing.JPanel panel_pertama;
    private javax.swing.JTable tblsimpanan_lanjutan;
    private javax.swing.JTextField txtbesar_simpanan_pertama;
    private javax.swing.JTextField txtbesar_simpananbayar;
    private javax.swing.JTextField txtbesar_sukarela;
    private javax.swing.JTextField txtket_sukarela;
    // End of variables declaration//GEN-END:variables
}
