package com.perpus.form;

import com.perpus.config.Koneksi;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class MasterPegawai extends javax.swing.JPanel {

    private int halamanSaatIni = 1;
    private int dataPerHalaman = 14;
    private int totalPages;
    private final Connection conn;

    public MasterPegawai() {
        initComponents();
        conn = Koneksi.getConnection();
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Koneksi database gagal. Periksa konfigurasi Koneksi.java.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        setTabelModel();
        loadData();
        paginationAnggota();
        setColumnWidth();
        setLayoutForm();
        dateChooser1.setDateFormat("yyyy-MM-dd");
        rbLaki.setSelected(true);
        txtID.setText(setIDPegawai()); // Set ID otomatis saat form dibuka
    }

    private void setColumnWidth() {
        TableColumnModel columnModel = tblData.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(0).setMaxWidth(40);
        columnModel.getColumn(0).setMinWidth(40);
    }

    private void setLayoutForm() {
        iconJudul.setIcon(new FlatSVGIcon("com/perpus/icon/anggota.svg", 1f));
        iconJudul2.setIcon(new FlatSVGIcon("com/perpus/icon/anggota.svg", 1f));
        iconDashboard.setIcon(new FlatSVGIcon("com/perpus/icon/dashboard.svg", 1f));
        iconDashboard2.setIcon(new FlatSVGIcon("com/perpus/icon/dashboard.svg", 1f));
        btnAdd.setIcon(new FlatSVGIcon("com/perpus/icon/add_white.svg", 1f));
        btnDelete.setIcon(new FlatSVGIcon("com/perpus/icon/delete_white.svg", 1f));
        btnCancel.setIcon(new FlatSVGIcon("com/perpus/icon/cancel_white.svg", 1f));
        btnPrint.setIcon(new FlatSVGIcon("com/perpus/icon/print_white.svg", 1f));
        btnSave.setIcon(new FlatSVGIcon("com/perpus/icon/save_white.svg", 1f));
        btnCancel2.setIcon(new FlatSVGIcon("com/perpus/icon/cancel_white.svg", 1f));

        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON,
                new FlatSVGIcon("com/perpus/icon/search.svg", 0.80f));

        txtID.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        txtNama.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        txtEmail.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        txtTelepon.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        txtTanggal.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);

        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pencarian");
        txtID.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ID pegawai");
        txtNama.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Masukkan Nama Pegawai");
        txtEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Masukkan Email Pegawai");
        txtTelepon.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Masukkan Nomor Telepon Pegawai");
        txtTanggal.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Masukkan Tanggal Bergabung Pegawai");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        rbJenisKelamin = new javax.swing.ButtonGroup();
        panelMain = new javax.swing.JPanel();
        panelView = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        iconDashboard = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_last = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        cbx_data = new javax.swing.JComboBox<>();
        btn_before = new javax.swing.JButton();
        btn_first = new javax.swing.JButton();
        lb_halaman = new javax.swing.JLabel();
        iconJudul = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        panelAdd = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        iconDashboard2 = new javax.swing.JLabel();
        iconJudul2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        rbLaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        btnSave = new javax.swing.JButton();
        btnCancel2 = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTelepon = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        dateChooser1.setTextRefernce(txtTanggal);

        setLayout(new java.awt.CardLayout());

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setPreferredSize(new java.awt.Dimension(1133, 690));
        panelMain.setLayout(new java.awt.CardLayout());

        panelView.setBackground(new java.awt.Color(255, 255, 255));
        panelView.setPreferredSize(new java.awt.Dimension(1133, 690));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Data Pegawai Perusahaan");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Master Data > Pegawai");

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));

        btn_last.setText("Last Page");

        btn_next.setText(">");

        cbx_data.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "14", "28", "54", "108" }));

        btn_before.setText("<");

        btn_first.setText("First Page");

        lb_halaman.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_halaman.setText("Halaman of Total Halaman");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_halaman, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_first)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_before, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_last)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_halaman, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_first, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_before, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_data, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_last, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        iconJudul.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        iconJudul.setForeground(new java.awt.Color(102, 102, 102));

        btnAdd.setText("TAMBAH");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCancel.setText("BATAL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnPrint.setText("PRINT");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        tblData.setGridColor(new java.awt.Color(255, 255, 255));
        tblData.setRowHeight(40);
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        btnDelete.setText("HAPUS");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelViewLayout = new javax.swing.GroupLayout(panelView);
        panelView.setLayout(panelViewLayout);
        panelViewLayout.setHorizontalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewLayout.createSequentialGroup()
                        .addComponent(iconJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 631, Short.MAX_VALUE)
                        .addComponent(iconDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        panelViewLayout.setVerticalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(iconJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(iconDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelMain.add(panelView, "card2");

        panelAdd.setBackground(new java.awt.Color(255, 255, 255));
        panelAdd.setPreferredSize(new java.awt.Dimension(1133, 690));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Tambah Data Pegawai Perusahaan");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Master Data > Dashboard");

        iconJudul2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        iconJudul2.setForeground(new java.awt.Color(102, 102, 102));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("ID");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Nama");

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Email");

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Telepon");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Jenis Kelamin");

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Tanggal Bergabung");

        rbJenisKelamin.add(rbLaki);
        rbLaki.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        rbLaki.setForeground(new java.awt.Color(51, 51, 51));
        rbLaki.setText("Laki - laki");

        rbJenisKelamin.add(rbPerempuan);
        rbPerempuan.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        rbPerempuan.setForeground(new java.awt.Color(51, 51, 51));
        rbPerempuan.setText("Perempuan");

        btnSave.setText("SIMPAN");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel2.setText("BATAL");
        btnCancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel2ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Jabatan");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jabatan", "Staff", "SPV", "Manager", "Vice Precident", "Precident" }));

        javax.swing.GroupLayout panelAddLayout = new javax.swing.GroupLayout(panelAdd);
        panelAdd.setLayout(panelAddLayout);
        panelAddLayout.setHorizontalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddLayout.createSequentialGroup()
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNama, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAddLayout.createSequentialGroup()
                                .addComponent(iconJudul2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 496, Short.MAX_VALUE)
                                .addComponent(iconDashboard2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)))
                        .addGap(20, 20, 20))
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addGroup(panelAddLayout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel2)))
                        .addContainerGap(881, Short.MAX_VALUE))
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addContainerGap(1033, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTanggal)
                    .addComponent(txtTelepon, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAddLayout.createSequentialGroup()
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addGroup(panelAddLayout.createSequentialGroup()
                                .addComponent(rbLaki)
                                .addGap(18, 18, 18)
                                .addComponent(rbPerempuan)))
                        .addGap(0, 861, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelAddLayout.setVerticalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(iconDashboard2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(iconJudul2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbLaki)
                    .addComponent(rbPerempuan))
                .addGap(18, 18, 18)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        panelMain.add(panelAdd, "card2");

        add(panelMain, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
  panelMain.removeAll();
        panelMain.add(panelAdd);
        panelMain.repaint();
        panelMain.revalidate();

        txtID.setText(setIDPegawai()); // Pastikan ID baru diatur saat tambah
        txtID.setEnabled(false);

        if (btnAdd.getText().equals("UBAH")) {
            dataTabel();
            btnSave.setText("PERBARUI");
        } else {
            btnSave.setText("SIMPAN");
            resetForm();
            txtID.setText(setIDPegawai()); // Reset ID saat tambah baru
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
if (btnSave.getText().equals("SIMPAN")) {
            insertData();
        } else if (btnSave.getText().equals("PERBARUI")) {
            updateData();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel2ActionPerformed
        showPanel();
        loadData();
    }//GEN-LAST:event_btnCancel2ActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
if (btnAdd.getText().equals("TAMBAH")) {
            btnAdd.setText("UBAH");
            btnDelete.setVisible(true);
            btnCancel.setVisible(true);
            btnPrint.setVisible(true);
        }
            
    }//GEN-LAST:event_tblDataMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        showPanel();
        loadData();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteData();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
     int row = tblData.getSelectedRow();
        if (row != -1) {
            String id = tblData.getValueAt(row, 1).toString();
            try {
                String reportPath = "src/com/perpus/reports/KartuPegawai.jasper";

                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("id", id);

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
                viewer.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih dahulu record yang akan diprint");
        }
        
        
    }//GEN-LAST:event_btnPrintActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        searchData();
    }//GEN-LAST:event_txtSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancel2;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btn_before;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JComboBox<String> cbx_data;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel iconDashboard;
    private javax.swing.JLabel iconDashboard2;
    private javax.swing.JLabel iconJudul;
    private javax.swing.JLabel iconJudul2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_halaman;
    private javax.swing.JPanel panelAdd;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelView;
    private javax.swing.ButtonGroup rbJenisKelamin;
    private javax.swing.JRadioButton rbLaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtTelepon;
    // End of variables declaration//GEN-END:variables

 private void paginationAnggota() {
        btn_first.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                halamanSaatIni = 1;
                loadData();
            }
        });

        btn_before.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (halamanSaatIni > 1) {
                    halamanSaatIni--;
                    loadData();
                }
            }
        });

        cbx_data.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataPerHalaman = Integer.parseInt(cbx_data.getSelectedItem().toString());
                halamanSaatIni = 1;
                loadData();
            }
        });

        btn_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (halamanSaatIni < totalPages) {
                    halamanSaatIni++;
                    loadData();
                }
            }
        });

        btn_last.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                halamanSaatIni = totalPages;
                loadData();
            }
        });
    }

    private int getTotalData() {
        int totalData = 0;
        try {
            String sql = "SELECT COUNT(*) AS total FROM pegawaii";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    totalData = rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(MasterPegawai.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Gagal memuat jumlah data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return totalData;
    }

    private void calculateTotalPages() {
        int totalData = getTotalData();
        totalPages = (int) Math.ceil((double) totalData / dataPerHalaman);
    }

    private void loadData() {
        calculateTotalPages();
        int totalData = getTotalData();
        lb_halaman.setText("Halaman " + halamanSaatIni + " dari Total Data " + totalData);

        int startIndex = (halamanSaatIni - 1) * dataPerHalaman;
        getData(startIndex, dataPerHalaman, (DefaultTableModel) tblData.getModel());
        btnDelete.setVisible(false);
        btnCancel.setVisible(false);
        btnPrint.setVisible(false);
    }

    private void showPanel() {
        panelMain.removeAll();
        panelMain.add(new MasterPegawai());
        panelMain.repaint();
        panelMain.revalidate();
    }

    private void resetForm() {
        txtID.setText(setIDPegawai()); // Reset dengan ID baru
        txtNama.setText("");
        txtEmail.setText("");
        txtTelepon.setText("");
        rbLaki.setSelected(true);
        txtTanggal.setText("");
        jComboBox1.setSelectedIndex(0);
    }

    private void setTabelModel() {
        DefaultTableModel model = (DefaultTableModel) tblData.getModel();
        model.addColumn("No");
        model.addColumn("ID Pegawai");
        model.addColumn("Nama");
        model.addColumn("Email");
        model.addColumn("Telepon");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Jabatan");
        model.addColumn("Tanggal Bergabung");
    }

    public void getData(int startIndex, int entriesPage, DefaultTableModel model) {
        model.setRowCount(0);
        try {
            String sql = "SELECT * FROM pegawaii LIMIT ?,?";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setInt(1, startIndex);
                st.setInt(2, entriesPage);
                ResultSet rs = st.executeQuery();

                int no = startIndex + 1;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                while (rs.next()) {
                    String idPegawai = rs.getString("id_pegawai");
                    String nama = rs.getString("nama");
                    String email = rs.getString("email");
                    String telepon = rs.getString("telepon") != null ? rs.getString("telepon") : "";
                    String jenisKelamin = rs.getString("jenis_kelamin");
                    String jabatan = rs.getString("jabatan");
                    java.sql.Date tanggalBergabung = rs.getDate("tanggal_bergabung");
                    String tanggalBergabungStr = tanggalBergabung != null ? sdf.format(tanggalBergabung) : "";

                    Object[] rowData = {"   " + no++, idPegawai, nama, email, telepon, jenisKelamin, jabatan, tanggalBergabungStr};
                    model.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(MasterPegawai.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String setIDPegawai() {
        String urutan = null;
        Date now = new Date();
        SimpleDateFormat noFormat = new SimpleDateFormat("yyMM");
        String no = noFormat.format(now);

        String sql = "SELECT RIGHT(id_pegawai, 3) AS Nomor " +
                     "FROM pegawaii " +
                     "WHERE id_pegawai LIKE 'PGW" + no + "%' " +
                     "ORDER BY id_pegawai DESC " +
                     "LIMIT 1";

        try (PreparedStatement st = conn.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor")) + 1;
                urutan = "PGW" + no + String.format("%03d", nomor);
                if (urutan.length() > 10) urutan = urutan.substring(0, 10); // Pastikan panjang max 10
            } else {
                urutan = "PGW" + no + "001";
            }
        } catch (SQLException | NumberFormatException e) {
            Logger.getLogger(MasterPegawai.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Gagal menghasilkan ID: " + e.getMessage() + ". Menggunakan default PGW" + no + "001.", "Error", JOptionPane.ERROR_MESSAGE);
            urutan = "PGW" + no + "001"; // Fallback
        }
        return urutan != null ? urutan : "PGW" + no + "001";
    }

    private void insertData() {
        String idPegawai = txtID.getText().trim();
        String nama = txtNama.getText().trim();
        String email = txtEmail.getText().trim();
        String telepon = txtTelepon.getText().trim().isEmpty() ? null : txtTelepon.getText().trim();
        String jenisKelamin = rbLaki.isSelected() ? "Laki-laki" : (rbPerempuan.isSelected() ? "Perempuan" : "");
        String tanggalBergabung = txtTanggal.getText().trim();
        String jabatan = jComboBox1.getSelectedItem().toString();

        if (idPegawai.isEmpty() || nama.isEmpty() || email.isEmpty() || jenisKelamin.isEmpty() || tanggalBergabung.isEmpty() || jabatan.equals("Pilih Jabatan")) {
            StringBuilder pesan = new StringBuilder("Kolom yang harus diisi:\n");
            if (idPegawai.isEmpty()) pesan.append("- ID Pegawai\n");
            if (nama.isEmpty()) pesan.append("- Nama\n");
            if (email.isEmpty()) pesan.append("- Email\n");
            if (jenisKelamin.isEmpty()) pesan.append("- Jenis Kelamin\n");
            if (tanggalBergabung.isEmpty()) pesan.append("- Tanggal Bergabung\n");
            if (jabatan.equals("Pilih Jabatan")) pesan.append("- Jabatan");
            JOptionPane.showMessageDialog(this, pesan.toString(), "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "INSERT INTO pegawaii (id_pegawai, nama, email, jenis_kelamin, jabatan, telepon, tanggal_bergabung) VALUES (?,?,?,?,?,?,?)";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, idPegawai);
                st.setString(2, nama);
                st.setString(3, email);
                st.setString(4, jenisKelamin);
                st.setString(5, jabatan);
                st.setString(6, telepon);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date utilDate = sdf.parse(tanggalBergabung);
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                st.setDate(7, sqlDate);

                int rowInserted = st.executeUpdate();
                if (rowInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Data Berhasil Ditambahkan");
                    resetForm();
                    loadData();
                    showPanel();
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal menambahkan data", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(MasterPegawai.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Gagal menambahkan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (java.text.ParseException e) {
            Logger.getLogger(MasterPegawai.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Format tanggal salah. Gunakan yyyy-MM-dd (contoh: 2025-07-05).", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void dataTabel() {
        panelView.setVisible(false);
        panelAdd.setVisible(true);

        int row = tblData.getSelectedRow();
        jLabel5.setText("Perbarui Data Pegawai Perusahaan");

        txtID.setEnabled(false);
        txtTanggal.setEnabled(false);

        txtID.setText(tblData.getValueAt(row, 1).toString());
        txtNama.setText(tblData.getValueAt(row, 2).toString());
        txtEmail.setText(tblData.getValueAt(row, 3).toString());
        txtTelepon.setText(tblData.getValueAt(row, 4).toString());

        String jenisKelamin = tblData.getValueAt(row, 5).toString();
        if (jenisKelamin.equals("Laki-laki")) {
            rbLaki.setSelected(true);
        } else if (jenisKelamin.equals("Perempuan")) {
            rbPerempuan.setSelected(true);
        }

        jComboBox1.setSelectedItem(tblData.getValueAt(row, 6).toString());
        txtTanggal.setText(tblData.getValueAt(row, 7).toString());
    }

    private void updateData() {
        String idPegawai = txtID.getText().trim();
        String nama = txtNama.getText().trim();
        String email = txtEmail.getText().trim();
        String telepon = txtTelepon.getText().trim().isEmpty() ? null : txtTelepon.getText().trim();
        String jenisKelamin = rbLaki.isSelected() ? "Laki-laki" : (rbPerempuan.isSelected() ? "Perempuan" : "");
        String tanggalBergabung = txtTanggal.getText().trim();
        String jabatan = jComboBox1.getSelectedItem().toString();

        if (idPegawai.isEmpty() || nama.isEmpty() || email.isEmpty() || jenisKelamin.isEmpty() || tanggalBergabung.isEmpty() || jabatan.equals("Pilih Jabatan")) {
            StringBuilder pesan = new StringBuilder("Kolom yang harus diisi:\n");
            if (idPegawai.isEmpty()) pesan.append("- ID Pegawai\n");
            if (nama.isEmpty()) pesan.append("- Nama\n");
            if (email.isEmpty()) pesan.append("- Email\n");
            if (jenisKelamin.isEmpty()) pesan.append("- Jenis Kelamin\n");
            if (tanggalBergabung.isEmpty()) pesan.append("- Tanggal Bergabung\n");
            if (jabatan.equals("Pilih Jabatan")) pesan.append("- Jabatan");
            JOptionPane.showMessageDialog(this, pesan.toString(), "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "UPDATE pegawaii SET nama=?, email=?, jenis_kelamin=?, jabatan=?, telepon=?, tanggal_bergabung=? WHERE id_pegawai=?";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, nama);
                st.setString(2, email);
                st.setString(3, jenisKelamin);
                st.setString(4, jabatan);
                st.setString(5, telepon);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date utilDate = sdf.parse(tanggalBergabung);
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                st.setDate(6, sqlDate);
                st.setString(7, idPegawai);

                int rowUpdated = st.executeUpdate();
                if (rowUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Data Berhasil Diperbarui");
                    resetForm();
                    loadData();
                    showPanel();
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal memperbarui data", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(MasterPegawai.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Gagal memperbarui data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (java.text.ParseException e) {
            Logger.getLogger(MasterPegawai.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Format tanggal salah. Gunakan yyyy-MM-dd (contoh: 2025-07-05).", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteData() {
        int selectedRow = tblData.getSelectedRow();
        int confirm = JOptionPane.showConfirmDialog(this,
                "Apakah yakin ingin menghapus data ini ?",
                "Konfirmasi Hapus Data",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String id = tblData.getValueAt(selectedRow, 1).toString();
            try {
                String sql = "DELETE FROM pegawaii WHERE id_pegawai=?";
                try (PreparedStatement st = conn.prepareStatement(sql)) {
                    st.setString(1, id);

                    int rowDeleted = st.executeUpdate();
                    if (rowDeleted > 0) {
                        JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
                    } else {
                        JOptionPane.showMessageDialog(this, "Data Gagal Dihapus");
                    }
                }
            } catch (SQLException e) {
                Logger.getLogger(MasterPegawai.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        resetForm();
        loadData();
        showPanel();
    }

    private void searchData() {
        String kataKunci = txtSearch.getText();

        DefaultTableModel model = (DefaultTableModel) tblData.getModel();
        model.setRowCount(0);

        try {
            String sql = "SELECT * FROM pegawaii WHERE nama LIKE ? OR email LIKE ?";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, "%" + kataKunci + "%");
                st.setString(2, "%" + kataKunci + "%");
                ResultSet rs = st.executeQuery();

                int no = 1;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                while (rs.next()) {
                    String idPegawai = rs.getString("id_pegawai");
                    String nama = rs.getString("nama");
                    String email = rs.getString("email");
                    String telepon = rs.getString("telepon") != null ? rs.getString("telepon") : "";
                    String jenisKelamin = rs.getString("jenis_kelamin");
                    String jabatan = rs.getString("jabatan");
                    java.sql.Date tanggalBergabung = rs.getDate("tanggal_bergabung");
                    String tanggalBergabungStr = tanggalBergabung != null ? sdf.format(tanggalBergabung) : "";

                    Object[] rowData = {"   " + no++, idPegawai, nama, email, telepon, jenisKelamin, jabatan, tanggalBergabungStr};
                    model.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(MasterPegawai.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Gagal mencari data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }}
