package com.dwilab.koprees;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import static javax.swing.BorderFactory.createTitledBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MF
 */
public class Form_anggota extends javax.swing.JFrame {
String tanggal,tanggal2;
Connection con;
Statement sta;
ResultSet rs;
DefaultTableModel tbm;
 private Dimension screensize;
    /**
     * Creates new form Form_anggota
     */
    public Form_anggota() {
        initComponents();
        tgl_sekarang();
        hak_akses();
        jPanel2.setBorder(createTitledBorder("DATA ANGGOTA"));
        jPanel3.setBorder(createTitledBorder("SIMPANAN POKOK"));
        jPanel4.setBorder(createTitledBorder("CRUD"));
        
        txt_idpetugas.setEnabled(false);
        txt_idanggota.setEnabled(false);
        txt_hakakses.setEnabled(false);
        jDate_simpanan.setEnabled(false);
        txt_simpanan.setEnabled(false);
        txt_simpanan.setText("250000");
        btnbatal.setEnabled(false);
        btnedit.setEnabled(false);
        btnhapus.setEnabled(false);
          screensize = Toolkit.getDefaultToolkit().getScreenSize();
          setLocation((screensize.width / 2) - (getSize().width / 2), (screensize.height / 2) - (getSize().height / 2));
           koneksi DB = new koneksi();
            DB.config();
            con = DB.con;
            sta = DB.stm;
            masuktabel();
            autonomor();
            
    }
private void tgl_sekarang() {
    Date date = new Date();
    jDate_simpanan.setDate(date);
}

private void tutupbutton() {
    btnhapus.setEnabled(false);
    btnedit.setEnabled(false);
}
private void autonomor(){
        String sql = "select max(id_anggota) from anggota";
        try{
            rs = sta.executeQuery(sql);
            while (rs.next()){
                int a = rs.getInt(1);
                txt_idanggota.setText(""+ Integer.toString(a+1));
            }
        }catch (Exception e){
            System.out.println(""+ e.getMessage());
        }

 }

public JTextField gettxt_typeuser() {
        return txt_hakakses;
    }

    public void settxt_typeuser(JTextField txt_username) {
        this.txt_hakakses= txt_hakakses;
    }
    
    public JTextField gettxt_idpetugas() {
        return txt_idpetugas;
    }

    public void settxt_idpetugas(JTextField txt_username) {
        this.txt_idpetugas = txt_idpetugas;
    }
   private void masuktabel(){
            try{
                sta = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                tbm = new DefaultTableModel();
                tbm.addColumn("ID");
                tbm.addColumn("Nama");
                tbm.addColumn("Alamat");
                tbm.addColumn("Tgl Lahir");
                tbm.addColumn("Tempat Lahir");
                tbm.addColumn("Jen_kel");
                tbm.addColumn("Status");
                tbm.addColumn("No Telp");
                tbm.addColumn("Keterangan");
                
                jTable1.setModel(tbm);
                rs = sta.executeQuery("SELECT id_anggota,nama,alamat,tgl_lhr,tmp_lhr,j_kel,status,no_telp,ket FROM anggota");
                while (rs.next()){
                    tbm.addRow(new Object[]{
                    rs.getString("id_anggota"),
                    rs.getString("nama"),
                    rs.getString("alamat"),
                    rs.getString("tgl_lhr"),
                    rs.getString("tmp_lhr"),
                    rs.getString("j_kel"),
                    rs.getString("status"),
                    rs.getString("no_telp"),
                    rs.getString("ket"),
                    
                });
                    jTable1.setModel(tbm);
                    }
                }catch(Exception e){
                        JOptionPane.showMessageDialog(rootPane,"Gagal"+e);
                        
                    }
    }
   
   private void bersih() {
       jPanel3.setVisible(true);
        txtnama.setText("");
        txtalamat.setText("");
        jDate_tgl_lahir.setDate(null);
        cmb_jeniskelamin.setSelectedItem("--------Pilihan--------");
        txt_notlp.setText("");
        txt_temp_lahir.setText("");
        btnbatal.setEnabled(false);
        btnedit.setEnabled(false);
        btnhapus.setEnabled(false);
   }
   
   private void hak_akses() {
       if (txt_idanggota.getText().equals("admin") ){
           jPanel2.setVisible(false);
           jPanel3.setVisible(false);
           btntambah.setEnabled(false);
           btnedit.setEnabled(false);
           btnhapus.setEnabled(false);
       } else if (txt_idanggota.getText().equals("petugas")){
            jPanel2.setVisible(true);
           jPanel3.setVisible(true);
           btntambah.setEnabled(true);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_idpetugas = new javax.swing.JTextField();
        txt_hakakses = new javax.swing.JTextField();
        txt_idanggota = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtalamat = new javax.swing.JTextField();
        jDate_tgl_lahir = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txt_temp_lahir = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmb_jeniskelamin = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        txt_notlp = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txt_simpanan = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jDate_simpanan = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        txtket_simpanan = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btntambah = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnprint = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtcari = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel1.setText("Anda Login Sebagai : ");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel2.setText("ID Petugas : ");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel3.setText("ID Anggota");

        txt_idpetugas.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txt_idpetugas.setText("jTextField1");

        txt_hakakses.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txt_hakakses.setText("jTextField2");

        txt_idanggota.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txt_idanggota.setText("jTextField3");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Nama");

        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Alamat");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Tgl Lahir");

        jDate_tgl_lahir.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDate_tgl_lahirPropertyChange(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Tempat Lahir");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Jenis Kelamin");

        cmb_jeniskelamin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--------Pilihan--------", "Laki-laki", "Perempuan" }));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("No Telp");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtalamat)
                    .addComponent(jLabel6)
                    .addComponent(jDate_tgl_lahir, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addComponent(txt_temp_lahir)
                    .addComponent(txtnama))
                .addGap(109, 109, 109)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addComponent(cmb_jeniskelamin, 0, 133, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addComponent(txt_notlp))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_jeniskelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_notlp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDate_tgl_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_temp_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Tgl Simpanan");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Besar Simpanan Pokok");

        jDate_simpanan.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDate_simpananPropertyChange(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("KET");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtket_simpanan, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDate_simpanan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                        .addComponent(txt_simpanan, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_simpanan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDate_simpanan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtket_simpanan, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btntambah.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btntambah.setText("TAMBAH ");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        btnhapus.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnhapus.setText("HAPUS");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnedit.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnedit.setText("EDIT");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton4.setText("KELUAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnprint.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnprint.setText("PRINT");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariKeyPressed(evt);
            }
        });

        btncari.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btncari.setText("CARI");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        btnbatal.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnbatal.setText("BATAL");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btntambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnprint, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnbatal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncari))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntambah)
                    .addComponent(btnedit)
                    .addComponent(btnhapus)
                    .addComponent(btnprint)
                    .addComponent(jButton4)
                    .addComponent(btnbatal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcari)
                    .addComponent(btncari, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("FORM ANGGOTA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_idpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hakakses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_idanggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_idpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_hakakses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_idanggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        if(txtnama.getText().equals("") || txtalamat.getText().equals("") ||jDate_tgl_lahir.getDate() == null||txt_notlp.getText().equals("") ||
            txt_simpanan.getText().equals("") || cmb_jeniskelamin.getSelectedItem().equals("--------Pilihan--------")) {
            JOptionPane.showMessageDialog(rootPane, "Isi Semua Data Terlebih dahulu");
        } else {
            try {
                 String sql,sql2;
                sql = ("INSERT INTO anggota(id_anggota,id_petugas,nama,alamat,tgl_lhr,tmp_lhr,j_kel,status,no_telp,ket) VALUES('"+ txt_idanggota.getText() +"','"+ txt_idpetugas.getText() +"','"+ txtnama.getText() +"','"+ txtalamat.getText() +"','"+ tanggal +"','"+ txt_temp_lahir.getText() +"','"+ cmb_jeniskelamin.getSelectedItem() +"','-','"+ txt_notlp.getText() +"','-')");
                sta.executeUpdate(sql);
                sql2 = ("INSERT INTO simpanan(nm_simpanan,id_anggota,tgl_simpanan,besar_simpanan,ket) VALUES('Simpanan Pokok','"+ txt_idanggota.getText() +"','"+ tanggal2 +"','"+ txt_simpanan.getText() +"','"+ txtket_simpanan.getText() +"')");
                sta.executeUpdate(sql2);
                JOptionPane.showMessageDialog(rootPane, "BERHASIL");
                masuktabel();
                bersih();
            } catch (Exception e) {
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btntambahActionPerformed

    private void jDate_tgl_lahirPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDate_tgl_lahirPropertyChange
    if (jDate_tgl_lahir.getDate()!=null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            tanggal = simpleDateFormat.format(jDate_tgl_lahir.getDate());}
        // TODO add your handling code here:
    }//GEN-LAST:event_jDate_tgl_lahirPropertyChange

    private void jDate_simpananPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDate_simpananPropertyChange
            if (jDate_simpanan.getDate()!=null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            tanggal2 = simpleDateFormat.format(jDate_simpanan.getDate()); }
// TODO add your handling code here:
    }//GEN-LAST:event_jDate_simpananPropertyChange

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        btnhapus.setEnabled(true);
        btnedit.setEnabled(true);
        btnbatal.setEnabled(true);
        jPanel3.setVisible(false);
        txt_idanggota.setText(tbm.getValueAt(jTable1.getSelectedRow(), 0)+"");
        txtnama.setText(tbm.getValueAt(jTable1.getSelectedRow(), 1)+"");
        txtalamat.setText(tbm.getValueAt(jTable1.getSelectedRow(), 2)+"");
         String tanggal3 = String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 3))+"";
        Date date;
        try {
           
            date = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal3);
            jDate_tgl_lahir.setDate(date);
        } catch (Exception e) {
        } 
        txt_temp_lahir.setText(tbm.getValueAt(jTable1.getSelectedRow(), 4)+"");
        cmb_jeniskelamin.setSelectedItem(tbm.getValueAt(jTable1.getSelectedRow(), 5)+"");
        txt_notlp.setText(tbm.getValueAt(jTable1.getSelectedRow(), 7)+"");
       
// TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
         try{
           String sql = "UPDATE anggota set id_petugas='"+txt_idpetugas.getText()+"',nama='"+txtnama.getText()+"', alamat='"+ txtalamat.getText()+"',tgl_lhr='"+ tanggal+"',tmp_lhr='"+ txt_temp_lahir.getText()+"',no_telp='"+ txt_notlp.getText() +"' where id_anggota='"+ txt_idanggota.getText()+"'";
            sta.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"DATA BERHASIL DI UBAH");
            
            masuktabel();
             bersih();
            jPanel3.setVisible(true);
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"GAGAL DI UBAH"+ e);
            System.out.println(e.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btneditActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        try {
            String sql = "DELETE FROM anggota WHERE id_anggota = '" + txt_idanggota.getText() + "'";
            sta.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"DATA BERHASIL DI HAPUS");
            masuktabel();
            bersih();
            jPanel3.setVisible(true);
        } catch (Exception e) {
        }
           // TODO add your handling code here:
    }//GEN-LAST:event_btnhapusActionPerformed

    private void txtcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                 btncariActionPerformed(new ActionEvent(evt.getSource(), evt.getID(), "Something Good"+ "")); 
             } // TODO add your handling code here:
    }//GEN-LAST:event_txtcariKeyPressed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
    TableRowSorter sorter = new TableRowSorter(jTable1.getModel());
        jTable1.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(Pattern.compile("(?i).*"+ txtcari.getText()+".*",Pattern.CASE_INSENSITIVE | Pattern.DOTALL).toString()));
        jTable1.setSelectionMode(1);
        // TODO add your handling code here:
    }//GEN-LAST:event_btncariActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        jPanel3.setVisible(true);
        txtnama.setText("");
        txtalamat.setText("");
        jDate_tgl_lahir.setDate(null);
        cmb_jeniskelamin.setSelectedItem("--------Pilihan--------");
        txt_notlp.setText("");
        txt_temp_lahir.setText("");
        btnbatal.setEnabled(false);
        btnedit.setEnabled(false);
        btnhapus.setEnabled(false);
// TODO add your handling code here:
    }//GEN-LAST:event_btnbatalActionPerformed

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
            java.util.logging.Logger.getLogger(Form_anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_anggota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnprint;
    private javax.swing.JButton btntambah;
    private javax.swing.JComboBox cmb_jeniskelamin;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDate_simpanan;
    private com.toedter.calendar.JDateChooser jDate_tgl_lahir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_hakakses;
    private javax.swing.JTextField txt_idanggota;
    private javax.swing.JTextField txt_idpetugas;
    private javax.swing.JTextField txt_notlp;
    private javax.swing.JTextField txt_simpanan;
    private javax.swing.JTextField txt_temp_lahir;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtket_simpanan;
    private javax.swing.JTextField txtnama;
    // End of variables declaration//GEN-END:variables

   
}