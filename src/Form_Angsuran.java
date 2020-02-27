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
public class Form_Angsuran extends javax.swing.JFrame {
private Dimension screensize;
Connection con;
Statement sta;
Statement stat;
ResultSet rs;
DefaultTableModel tbm;
String tanggal;
    private String tanggal2;
    private String tanggal3;
        
    /**
     * Creates new form Form_Angsuran
     */
    public Form_Angsuran() {
        initComponents();
        date_pembayaran.setEnabled(false);
        txtangsuran_ke.setEnabled(false);
        btnbayar.setEnabled(false);
        panel_data.setBorder(createTitledBorder("DATA"));
        panel_perhitungan.setBorder(createTitledBorder("ANGSURAN"));
        panel_table.setBorder(createTitledBorder("TRANSAKSI SEBELUMNYA"));
        
         screensize = Toolkit.getDefaultToolkit().getScreenSize();
          setLocation((screensize.width / 2) - (getSize().width / 2), (screensize.height / 2) - (getSize().height / 2));
          
          koneksi DB = new koneksi();
            DB.config();
            con = DB.con;
            sta = DB.stm;
            id_anggota();
            autonomor();
            tgl_sekarang();
            
            angsuran_tabel();
    }
    
    private void tgl_sekarang() {
       Date date = new Date();
               date_pembayaran.setDate(date);
    }
    
    private void autonomor(){
        String sql = "select max(id_angsuran) from angsuran";
        try{
            rs = sta.executeQuery(sql);
            while (rs.next()){
                int a = rs.getInt(1);
                txtidangsuran.setText(""+ Integer.toString(a+1));
            }
        }catch (Exception e){
            System.out.println(""+ e.getMessage());
        }

 }
    
    private void angsuran_tabel() {
        try{
                sta = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                tbm = new DefaultTableModel();
                tbm.addColumn("ID");
                tbm.addColumn("ID Anggota");
                tbm.addColumn("ID Pinjaman");
                tbm.addColumn("Nama");
                tbm.addColumn("TGL Pembayaran");
                tbm.addColumn("TGL Tempo");
                tbm.addColumn("Angsuran Ke");
                tbm.addColumn("Besar");
                tbm.addColumn("Keterangan");
                
                jTable1.setModel(tbm);
                rs = sta.executeQuery("SELECT angsuran.*,anggota.id_anggota,anggota.nama,detail_angsuran.tgl_jatuh_tempo FROM angsuran,anggota,detail_angsuran WHERE angsuran.id_anggota = anggota.id_anggota AND angsuran.id_angsuran = detail_angsuran.id_angsuran AND angsuran.ket='belum lunas'");
                while (rs.next()){
                    tbm.addRow(new Object[]{
                    rs.getString("id_angsuran"),
                    rs.getString("id_anggota"),    
                    rs.getString("id_pinjaman"),
                    rs.getString("nama"),
                    rs.getString("tgl_pembayaran"),
                    rs.getString("tgl_jatuh_tempo"),
                    rs.getString("angsuran_ke"),
                    rs.getString("besar_angsuran"),
                    rs.getString("ket"),
                });
                    jTable1.setModel(tbm);
                    }
                }catch(Exception e){
                        JOptionPane.showMessageDialog(rootPane,"Gagal"+e);
                        
                    }
    }
    
    private void autoangsuranke(){
        String sql = "select max(angsuran_ke) from angsuran WHERE id_angsuran='"+ txtidangsuran.getText() +"'";
        try{
            rs = sta.executeQuery(sql);
            while (rs.next()){
                int a = rs.getInt(1);
                txtangsuran_ke.setText(""+ Integer.toString(a+1));
            }
        }catch (Exception e){
            System.out.println(""+ e.getMessage());
        }

 }
    
    private void id_anggota() {
        try {
            String sql;
            sql = ("SELECT id_pinjaman FROM pinjaman WHERE ket='Disetujui'");
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                cmb_pinjaman.addItem(rs.getString("id_pinjaman"));
               
            } 
        } catch (Exception e) {
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
        panel_data = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtidangsuran = new javax.swing.JTextField();
        cmb_pinjaman = new javax.swing.JComboBox();
        txtnama_anggota = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtid_anggota = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtkategori_pinjaman = new javax.swing.JTextField();
        txtbesar_pinjaman = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtno_telp = new javax.swing.JTextField();
        panel_table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtcari = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        panel_perhitungan = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtbesar_bayar = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtlama_angsuran = new javax.swing.JTextField();
        btnbayar = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        date_pembayaran = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtangsuran_ke = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtbesar_angsuran = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("FORM ANGSURAN");

        panel_data.setBackground(new java.awt.Color(255, 255, 255));
        panel_data.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("ID Angsuran");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Nama Anggota");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("ID Pinjaman");

        cmb_pinjaman.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-------pilihan----------" }));
        cmb_pinjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_pinjamanActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setText("ID Anggota");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setText("Kategori Pinjaman");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel15.setText("Besar Pinjaman");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel16.setText("No Telp");

        javax.swing.GroupLayout panel_dataLayout = new javax.swing.GroupLayout(panel_data);
        panel_data.setLayout(panel_dataLayout);
        panel_dataLayout.setHorizontalGroup(
            panel_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dataLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panel_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_dataLayout.createSequentialGroup()
                        .addGroup(panel_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_dataLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtkategori_pinjaman))
                            .addGroup(panel_dataLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(26, 26, 26)
                                .addComponent(txtbesar_pinjaman)))
                        .addContainerGap())
                    .addGroup(panel_dataLayout.createSequentialGroup()
                        .addGroup(panel_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(jLabel16))
                        .addGap(33, 33, 33)
                        .addGroup(panel_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtid_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_pinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidangsuran, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_dataLayout.createSequentialGroup()
                                .addGroup(panel_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtno_telp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                    .addComponent(txtnama_anggota))
                                .addContainerGap())))))
        );
        panel_dataLayout.setVerticalGroup(
            panel_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtidangsuran, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmb_pinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtid_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnama_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtno_telp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtkategori_pinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtbesar_pinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_table.setBackground(new java.awt.Color(255, 255, 255));
        panel_table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        btncari.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btncari.setText("CARI");

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton5.setText("KELUAR");

        javax.swing.GroupLayout panel_tableLayout = new javax.swing.GroupLayout(panel_table);
        panel_table.setLayout(panel_tableLayout);
        panel_tableLayout.setHorizontalGroup(
            panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panel_tableLayout.createSequentialGroup()
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncari)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_tableLayout.createSequentialGroup()
                        .addGap(0, 458, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        panel_tableLayout.setVerticalGroup(
            panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tableLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncari, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton5)
                .addGap(47, 47, 47))
        );

        panel_perhitungan.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setText("Besar Bayar (bln)");

        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setText("TGL Jatuh Tempo");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setText("Lama Angsuran");

        btnbayar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnbayar.setText("BAYAR");
        btnbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbayarActionPerformed(evt);
            }
        });

        btnbatal.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnbatal.setText("BATAL");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setText("bln");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Tgl Pembayaran");

        date_pembayaran.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                date_pembayaranPropertyChange(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Angsuran Ke-");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Besar Angsuran");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setText("KELUAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_perhitunganLayout = new javax.swing.GroupLayout(panel_perhitungan);
        panel_perhitungan.setLayout(panel_perhitunganLayout);
        panel_perhitunganLayout.setHorizontalGroup(
            panel_perhitunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_perhitunganLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_perhitunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_perhitunganLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtbesar_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_perhitunganLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(panel_perhitunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_perhitunganLayout.createSequentialGroup()
                                .addComponent(txtlama_angsuran, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_perhitunganLayout.createSequentialGroup()
                        .addGroup(panel_perhitunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel12)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel_perhitunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtangsuran_ke, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_perhitunganLayout.createSequentialGroup()
                        .addGroup(panel_perhitunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_perhitunganLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_perhitunganLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_perhitunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel_perhitunganLayout.createSequentialGroup()
                                .addComponent(btnbayar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtbesar_angsuran, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panel_perhitunganLayout.setVerticalGroup(
            panel_perhitunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_perhitunganLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_perhitunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtbesar_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_perhitunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panel_perhitunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_perhitunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(txtlama_angsuran, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panel_perhitunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_perhitunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtangsuran_ke, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_perhitunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtbesar_angsuran, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(panel_perhitunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbayar)
                    .addComponent(btnbatal)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(panel_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_perhitungan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(panel_table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(427, 427, 427)
                        .addComponent(jLabel1)))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_perhitungan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_table, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
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

    private void cmb_pinjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_pinjamanActionPerformed
        btnbayar.setEnabled(true);
        autoangsuranke();
        try {
            String sql;
            sql = ("SELECT pinjaman.*,anggota.* FROM pinjaman,anggota WHERE id_pinjaman='"+ cmb_pinjaman.getSelectedItem() +"' AND pinjaman.id_anggota=anggota.id_anggota");
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                
                String nama = rs.getString("nama");
                String id = rs.getString("id_anggota");
                String notlp = rs.getString("no_telp");
                String kategori;
                        String besar = rs.getString("besar_pinjaman");
                
                    txtnama_anggota.setText(nama);
                    txtid_anggota.setText(id);
                    txtno_telp.setText(notlp);
                    txtkategori_pinjaman.setText(kategori = rs.getString("kategori_pinjaman"));
                    txtbesar_pinjaman.setText(besar);
                    
                    
                    
                    if (txtkategori_pinjaman.getText().equals("Pinjaman Jangka Pendek")) {
                        txtlama_angsuran.setText("2");
                    } else if (txtkategori_pinjaman.getText().equals("Pinjaman Jangka Panjang")) {
                        txtlama_angsuran.setText("12");
                    }
                    
                    int besar1 = Integer.parseInt(besar);
                    long besar_perbulan1 = besar1 * 2/100;
                    String lam = txtlama_angsuran.getText();
                    int lama = Integer.parseInt(lam);
                    long besar_perbulan2 = besar1/lama ;
                    long besar_perbulan3 = besar_perbulan1+besar_perbulan2;
                    String besarperbulan = String.valueOf(besar_perbulan3);
                    txtbesar_bayar.setText(besarperbulan);
                    long besar_angsuran = besar_perbulan3 * lama;
                    String besar_angsuran1 = String.valueOf(besar_angsuran);
                    txtbesar_angsuran.setText(besar_angsuran1);
                    
                    
            } 
        } catch (Exception e) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_pinjamanActionPerformed

    private void btnbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbayarActionPerformed
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date bayar = df.parse(tanggal3);
            Date sebelum = df.parse(tanggal2);
            long bayar1 = bayar.getTime();
            long sebelum1 = sebelum.getTime();
            long diff = bayar1-sebelum1;
            long lama2 = diff/(24*60*60*1000);
            String hari = (Long.toString(lama2));
            int harih = Integer.valueOf(hari);
        
        String lama = txtlama_angsuran.getText();
        String angsuran = txtangsuran_ke.getText();
        int lama_angsur = Integer.parseInt(lama);
        int angsuran_ke = Integer.parseInt(angsuran);
        
        if (cmb_pinjaman.getSelectedItem().equals("-------pilihan----------")) {
            JOptionPane.showMessageDialog(rootPane, "Masukkan Semua Data");
            
        } else if (harih >= 1) {
             try {
                  JOptionPane.showMessageDialog(rootPane, "Sudah Lewat Batas Waktu");
                 String sql;
                sql = ("UPDATE angsuran set ket='Tertunggak' WHERE id_pinjaman='"+ cmb_pinjaman.getSelectedItem() +"'");
                sta.executeUpdate(sql);
                new Form_Angsuran().setVisible(true);
                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
           
        }
        else if (angsuran_ke==1) {
             try {
                 String sql,sql2;
                sql = ("INSERT INTO angsuran(id_angsuran,id_pinjaman,id_anggota,tgl_pembayaran,angsuran_ke,besar_angsuran,ket) VALUES('"+ txtidangsuran.getText() +"','"+ cmb_pinjaman.getSelectedItem() +"','"+ txtid_anggota.getText() +"','"+ tanggal3 +"','"+ txtangsuran_ke.getText() +"','"+ txtbesar_angsuran.getText() +"','belum lunas')");
                sta.executeUpdate(sql);
                sql2 = ("INSERT INTO detail_angsuran(id_angsuran,tgl_jatuh_tempo,besar_angsuran,ket) VALUES('"+ txtidangsuran.getText() +"','"+ tanggal2 +"','"+ txtbesar_angsuran.getText() +"','Belum Lunas')");
                sta.executeUpdate(sql2);
                JOptionPane.showMessageDialog(rootPane, "BERHASIL");
                new Form_Angsuran().setVisible(true);
                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            } 
            
        } else if (angsuran_ke < lama_angsur) {
            try {
                 String sql;
                sql = ("UPDATE angsuran SET tgl_pembayaran='"+ tanggal3 +"',angsuran_ke='"+ txtangsuran_ke.getText() +"' WHERE id_angsuran='"+ txtidangsuran.getText() +"' ");
                sta.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "BERHASIL");
                new Form_Angsuran().setVisible(true);
                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            } 
        }
        else if (angsuran_ke>=lama_angsur) {
            try {
                 String sql,sql2,sql3,sql4;
                sql = ("UPDATE angsuran SET tgl_pembayaran='"+ tanggal3 +"',angsuran_ke='"+ txtangsuran_ke.getText() +"',ket='Sudah Lunas' WHERE id_angsuran='"+ txtidangsuran.getText() +"' ");
                sta.executeUpdate(sql);
                sql2 = ("UPDATE detail_angsuran set ket='Sudah Lunas' WHERE id_angsuran='"+ txtidangsuran.getText() +"'");
                sta.executeUpdate(sql2);
                sql3 = ("UPDATE angsuran set ket='Sudah Lunas' WHERE id_angsuran='"+ txtidangsuran.getText() +"'");
                sta.executeUpdate(sql3);
                sql4 = ("UPDATE pinjaman set tgl_pelunasan='" +tanggal3+ "',ket='Sudah Lunas' WHERE id_pinjaman='"+ cmb_pinjaman.getSelectedItem() +"'");
                sta.executeUpdate(sql4);
                JOptionPane.showMessageDialog(rootPane, "ANDA LUNAS");
                new Form_Angsuran().setVisible(true);
                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        } catch (Exception e) {
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbayarActionPerformed

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
          if (jDateChooser1.getDate()!=null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            tanggal2 = simpleDateFormat.format(jDateChooser1.getDate());}
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void date_pembayaranPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_date_pembayaranPropertyChange
         if (date_pembayaran.getDate()!=null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            tanggal3 = simpleDateFormat.format(date_pembayaran.getDate());}
        // TODO add your handling code here:
    }//GEN-LAST:event_date_pembayaranPropertyChange

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        autoangsuranke();
        txtidangsuran.setText(tbm.getValueAt(jTable1.getSelectedRow(), 0)+"");
        cmb_pinjaman.setSelectedItem(tbm.getValueAt(jTable1.getSelectedRow(), 2)+"");
        String tanggal3 = String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 5))+"";
        Date date;
        try {
           
            date = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal3);
           jDateChooser1.setDate(date);
        } catch (Exception e) {
        } 
        try {
            String sql;
            sql = ("SELECT pinjaman.*,anggota.* FROM pinjaman,anggota WHERE id_pinjaman='"+ cmb_pinjaman.getSelectedItem() +"' AND pinjaman.id_anggota=anggota.id_anggota");
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                
                String nama = rs.getString("nama");
                String id = rs.getString("id_anggota");
                String notlp = rs.getString("no_telp");
                String kategori;
                        String besar = rs.getString("besar_pinjaman");
                
                    txtnama_anggota.setText(nama);
                    txtid_anggota.setText(id);
                    txtno_telp.setText(notlp);
                    txtkategori_pinjaman.setText(kategori = rs.getString("kategori_pinjaman"));
                    txtbesar_pinjaman.setText(besar); }
        } catch (Exception e) {
        }
            
                  
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Angsuran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Angsuran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Angsuran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Angsuran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Angsuran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnbayar;
    private javax.swing.JButton btncari;
    private javax.swing.JComboBox cmb_pinjaman;
    private com.toedter.calendar.JDateChooser date_pembayaran;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panel_data;
    private javax.swing.JPanel panel_perhitungan;
    private javax.swing.JPanel panel_table;
    private javax.swing.JTextField txtangsuran_ke;
    private javax.swing.JTextField txtbesar_angsuran;
    private javax.swing.JTextField txtbesar_bayar;
    private javax.swing.JTextField txtbesar_pinjaman;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtid_anggota;
    private javax.swing.JTextField txtidangsuran;
    private javax.swing.JTextField txtkategori_pinjaman;
    private javax.swing.JTextField txtlama_angsuran;
    private javax.swing.JTextField txtnama_anggota;
    private javax.swing.JTextField txtno_telp;
    // End of variables declaration//GEN-END:variables
}
