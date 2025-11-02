package com.perpus.form;

import com.perpus.config.Koneksi;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class MasterPerangkatIT extends javax.swing.JPanel {

    private int halamanSaatIni = 1;
    private int dataPerHalaman = 14;
    private int totalPages;
    private final Connection conn;

    public MasterPerangkatIT() {
        initComponents();
        conn = Koneksi.getConnection();
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Koneksi database gagal. Periksa konfigurasi Koneksi.java.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        setTabelModel();
        loadData();
        paginationPerangkat();
        actionButton();
        setColumnWidth();
        setLayoutForm();
    }

    private void setColumnWidth() {
        TableColumnModel columnModel = tblData.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40); // No
        columnModel.getColumn(0).setMaxWidth(40);
        columnModel.getColumn(0).setMinWidth(40);
        columnModel.getColumn(1).setPreferredWidth(100); // ID Perangkat
        columnModel.getColumn(2).setPreferredWidth(150); // Nama Perangkat
        columnModel.getColumn(3).setPreferredWidth(100); // Jenis Perangkat
        columnModel.getColumn(4).setPreferredWidth(100); // Merek
        columnModel.getColumn(5).setPreferredWidth(150); // Model
        columnModel.getColumn(6).setPreferredWidth(120); // Serial Number
        columnModel.getColumn(7).setPreferredWidth(100); // Tanggal Pembelian
        columnModel.getColumn(8).setPreferredWidth(80); // Kondisi
        columnModel.getColumn(9).setPreferredWidth(80); // Status
    }

    private void setLayoutForm() {
        iconJudul.setIcon(new FlatSVGIcon("com/perpus/icon/device.svg", 1f));
        iconJudul2.setIcon(new FlatSVGIcon("com/perpus/icon/device.svg", 1f));
        iconDashboard.setIcon(new FlatSVGIcon("com/perpus/icon/dashboard.svg", 1f));
        iconDashboard2.setIcon(new FlatSVGIcon("com/perpus/icon/dashboard.svg", 1f));
        btnAdd.setIcon(new FlatSVGIcon("com/perpus/icon/add_white.svg", 1f));
        btnDelete.setIcon(new FlatSVGIcon("com/perpus/icon/delete_white.svg", 1f));
        btnCancel.setIcon(new FlatSVGIcon("com/perpus/icon/cancel_white.svg", 1f));
        btnSave.setIcon(new FlatSVGIcon("com/perpus/icon/save_white.svg", 1f));
        btnCancel2.setIcon(new FlatSVGIcon("com/perpus/icon/cancel_white.svg", 1f));

        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON,
                new FlatSVGIcon("com/perpus/icon/search.svg", 0.80f));

        txtID.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        txtNamaPerangkat.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        txtMerek.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        txtModel.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        txtSerialNumber.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);

        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Cari nama, merek, atau serial number");
        txtID.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ID Perangkat");
        txtNamaPerangkat.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Masukkan Nama Perangkat");
        txtMerek.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Masukkan Merek");
        txtModel.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Masukkan Model");
        txtSerialNumber.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Masukkan Serial Number");

        cboJenis.setForeground(new Color(153, 153, 153));
        cboJenis.addActionListener(e -> {
            cboJenis.setForeground(cboJenis.getSelectedItem().equals("Laptop") ? new Color(153, 153, 153) : new Color(0, 0, 0));
        });

        cboKondisi.setForeground(new Color(153, 153, 153));
        cboKondisi.addActionListener(e -> {
            cboKondisi.setForeground(cboKondisi.getSelectedItem().equals("Baru") ? new Color(153, 153, 153) : new Color(0, 0, 0));
        });

        cboStatus.setForeground(new Color(153, 153, 153));
        cboStatus.addActionListener(e -> {
            cboStatus.setForeground(cboStatus.getSelectedItem().equals("Tersedia") ? new Color(153, 153, 153) : new Color(0, 0, 0));
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        btnCancel = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        panelAdd = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        menu = new javax.swing.JLabel();
        iconDashboard2 = new javax.swing.JLabel();
        iconJudul2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNamaPerangkat = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMerek = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cboJenis = new javax.swing.JComboBox<>();
        DatePembelian = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        cboKondisi = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cboStatus = new javax.swing.JComboBox<>();
        txtModel = new javax.swing.JTextField();
        txtSerialNumber = new javax.swing.JTextField();
        btnCancel2 = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setPreferredSize(new java.awt.Dimension(1133, 690));
        panelMain.setLayout(new java.awt.CardLayout());

        panelView.setBackground(new java.awt.Color(255, 255, 255));
        panelView.setPreferredSize(new java.awt.Dimension(1133, 690));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Data Perangkat IT");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Master Data > Perangkat IT");

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

        btnDelete.setText("HAPUS");

        tblData.setRowHeight(100);
        jScrollPane1.setViewportView(tblData);

        btnCancel.setText("BATAL");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelViewLayout = new javax.swing.GroupLayout(panelView);
        panelView.setLayout(panelViewLayout);
        panelViewLayout.setHorizontalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewLayout.createSequentialGroup()
                        .addComponent(iconJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 566, Short.MAX_VALUE)
                        .addComponent(iconDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
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
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelMain.add(panelView, "card2");

        panelAdd.setBackground(new java.awt.Color(255, 255, 255));
        panelAdd.setPreferredSize(new java.awt.Dimension(1133, 690));

        jScrollPane2.setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        title.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(102, 102, 102));
        title.setText("Tambah Data Perangkat IT");

        menu.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        menu.setForeground(new java.awt.Color(102, 102, 102));
        menu.setText("Master Data > Perangkat");

        iconJudul2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        iconJudul2.setForeground(new java.awt.Color(102, 102, 102));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("ID");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Nama Perangkat");

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Jenis Perangkat");

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Merek");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Model");

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Nomor Seri");

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Tanggal Pembelian");

        cboJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Printer", "Switch", "Monitor", "Lainnya" }));

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Kondisi");

        cboKondisi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baru", "Rusak", "Bekas" }));

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Status");

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tersedia", "Dipinjam", "Rusak" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15))
                        .addGap(548, 778, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboKondisi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DatePembelian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboJenis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMerek)
                            .addComponent(txtNamaPerangkat)
                            .addComponent(txtID)
                            .addComponent(cboStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtModel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSerialNumber, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(cboJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtMerek, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(txtSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DatePembelian, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboKondisi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        btnCancel2.setText("BATAL");

        btnSave.setText("SIMPAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(iconJudul2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(title)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(iconDashboard2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(menu))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(247, 247, 247))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconDashboard2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconJudul2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout panelAddLayout = new javax.swing.GroupLayout(panelAdd);
        panelAdd.setLayout(panelAddLayout);
        panelAddLayout.setHorizontalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        panelAddLayout.setVerticalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelMain.add(panelAdd, "card2");

        add(panelMain, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        searchData();
    }//GEN-LAST:event_txtSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DatePembelian;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancel2;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btn_before;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JComboBox<String> cboJenis;
    private javax.swing.JComboBox<String> cboKondisi;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JComboBox<String> cbx_data;
    private javax.swing.JLabel iconDashboard;
    private javax.swing.JLabel iconDashboard2;
    private javax.swing.JLabel iconJudul;
    private javax.swing.JLabel iconJudul2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_halaman;
    private javax.swing.JLabel menu;
    private javax.swing.JPanel panelAdd;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelView;
    private javax.swing.JTable tblData;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMerek;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtNamaPerangkat;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSerialNumber;
    // End of variables declaration//GEN-END:variables

    
 private void paginationPerangkat() {
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

    // Button Actions
    private void actionButton() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelMain.removeAll();
                panelMain.add(panelAdd);
                panelMain.repaint();
                panelMain.revalidate();

                String newId = setIDPerangkat(); // Pastikan ID dihasilkan
                txtID.setText(newId);
                txtID.setEnabled(false);

                if (btnAdd.getText().equals("UBAH")) {
                    dataTabel();
                    btnSave.setText("PERBARUI");
                } else {
                    btnSave.setText("SIMPAN");
                    resetForm();
                }
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnSave.getText().equals("SIMPAN")) {
                    insertData();
                } else if (btnSave.getText().equals("PERBARUI")) {
                    updateData();
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteData();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel();
                loadData();
            }
        });

        btnCancel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel();
                loadData();
            }
        });

        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                searchData();
            }
        });

        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (btnAdd.getText().equals("TAMBAH")) {
                    btnAdd.setText("UBAH");
                    btnDelete.setVisible(true);
                    btnCancel.setVisible(true);
                }
            }
        });
    }

    // Other Functions
    private int getTotalData() {
        int totalData = 0;
        try {
            String sql = "SELECT COUNT(*) AS total FROM perangkat_it";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    totalData = rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(MasterPerangkatIT.class.getName()).log(Level.SEVERE, null, e);
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
        lb_halaman.setText("Halaman " + halamanSaatIni + " dari Total Halaman " + totalPages);

        int startIndex = (halamanSaatIni - 1) * dataPerHalaman;
        getData(startIndex, dataPerHalaman, (DefaultTableModel) tblData.getModel());
        btnDelete.setVisible(false);
        btnCancel.setVisible(false);
    }

    private void showPanel() {
        panelMain.removeAll();
        panelMain.add(new MasterPerangkatIT());
        panelMain.repaint();
        panelMain.revalidate();
    }

    private void resetForm() {
        txtID.setText("");
        txtNamaPerangkat.setText("");
        txtMerek.setText("");
        txtModel.setText("");
        txtSerialNumber.setText("");
        cboJenis.setSelectedIndex(0);
        DatePembelian.setDate(null);
        cboKondisi.setSelectedIndex(0);
        cboStatus.setSelectedIndex(0);
    }

    private void setTabelModel() {
        DefaultTableModel model = (DefaultTableModel) tblData.getModel();
        model.addColumn("No");
        model.addColumn("ID Perangkat");
        model.addColumn("Nama Perangkat");
        model.addColumn("Jenis Perangkat");
        model.addColumn("Merek");
        model.addColumn("Model");
        model.addColumn("Serial Number");
        model.addColumn("Tanggal Pembelian");
        model.addColumn("Kondisi");
        model.addColumn("Status");
    }

    public void getData(int startIndex, int entriesPage, DefaultTableModel model) {
        model.setRowCount(0);
        try {
            String sql = "SELECT id_perangkat, nama_perangkat, jenis_perangkat, merek, model, serial_number, tanggal_pembelian, kondisi, status " +
                         "FROM perangkat_it ORDER BY id_perangkat ASC LIMIT ?,?";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setInt(1, startIndex);
                st.setInt(2, entriesPage);
                ResultSet rs = st.executeQuery();

                int no = startIndex + 1;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                while (rs.next()) {
                    String idPerangkat = rs.getString("id_perangkat");
                    String namaPerangkat = rs.getString("nama_perangkat");
                    String jenisPerangkat = rs.getString("jenis_perangkat");
                    String merek = rs.getString("merek") != null ? rs.getString("merek") : "";
                    String modelStr = rs.getString("model") != null ? rs.getString("model") : "";
                    String serialNumber = rs.getString("serial_number") != null ? rs.getString("serial_number") : "";
                    Date tanggalPembelian = rs.getDate("tanggal_pembelian");
                    String kondisi = rs.getString("kondisi");
                    String status = rs.getString("status");

                    String tanggalPembelianStr = tanggalPembelian != null ? sdf.format(tanggalPembelian) : "";

                    Object[] rowData = {"   " + no++, idPerangkat, namaPerangkat, jenisPerangkat, merek, modelStr, serialNumber, tanggalPembelianStr, kondisi, status};
                    model.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(MasterPerangkatIT.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String setIDPerangkat() {
        String urutan = null;
        Date now = new Date();
        SimpleDateFormat noFormat = new SimpleDateFormat("yyMM");
        String no = noFormat.format(now); // Misalnya, "2507" untuk 11:50 AM WIB, 5 Juli 2025

        String sql = "SELECT RIGHT(id_perangkat, 4) AS Nomor " +
                     "FROM perangkat_it " +
                     "WHERE id_perangkat LIKE 'PKT" + no + "%' " +
                     "ORDER BY id_perangkat DESC " +
                     "LIMIT 1";

        try (PreparedStatement st = conn.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor")) + 1;
                urutan = "PKT" + no + String.format("%04d", nomor);
            } else {
                urutan = "PKT" + no + "0001";
            }
        } catch (SQLException | NumberFormatException e) {
            Logger.getLogger(MasterPerangkatIT.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Gagal menghasilkan ID: " + e.getMessage() + ". Menggunakan default PKT" + no + "0001.", "Error", JOptionPane.ERROR_MESSAGE);
            urutan = "PKT" + no + "0001"; // Fallback
        }
        if (urutan != null && urutan.length() > 12) {
            urutan = urutan.substring(0, 12); // Potong jika melebihi 12 karakter
        }
        return urutan != null ? urutan : "PKT" + no + "0001";
    }

    private void insertData() {
        String idPerangkat = txtID.getText().trim();
        if (idPerangkat.isEmpty()) {
            idPerangkat = setIDPerangkat(); // Gunakan ID otomatis jika kosong
        } else if (idPerangkat.length() > 12) { // Sesuaikan dengan panjang kolom
            JOptionPane.showMessageDialog(this, "ID Perangkat terlalu panjang. Maksimum 12 karakter.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String namaPerangkat = txtNamaPerangkat.getText().trim();
        String jenisPerangkat = cboJenis.getSelectedItem().toString();
        String merek = txtMerek.getText().trim();
        String model = txtModel.getText().trim();
        String serialNumber = txtSerialNumber.getText().trim();
        Date tanggalPembelian = DatePembelian.getDate();
        String kondisi = cboKondisi.getSelectedItem().toString();
        String status = cboStatus.getSelectedItem().toString();

        try {
            String sql = "INSERT INTO perangkat_it (id_perangkat, nama_perangkat, jenis_perangkat, merek, model, serial_number, tanggal_pembelian, kondisi, status) " +
                         "VALUES (?,?,?,?,?,?,?,?,?)";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, idPerangkat);
                st.setString(2, namaPerangkat.isEmpty() ? "Unnamed Device" : namaPerangkat);
                st.setString(3, jenisPerangkat);
                st.setString(4, merek.isEmpty() ? null : merek);
                st.setString(5, model.isEmpty() ? null : model);
                st.setString(6, serialNumber.isEmpty() ? null : serialNumber);
                st.setDate(7, tanggalPembelian != null ? new java.sql.Date(tanggalPembelian.getTime()) : null);
                st.setString(8, kondisi);
                st.setString(9, status);

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
            Logger.getLogger(MasterPerangkatIT.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Gagal menambahkan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void dataTabel() {
        panelView.setVisible(false);
        panelAdd.setVisible(true);

        int row = tblData.getSelectedRow();
        title.setText("Perbarui Data Perangkat IT");

        txtID.setEnabled(false);
        txtID.setText(tblData.getValueAt(row, 1).toString());
        txtNamaPerangkat.setText(tblData.getValueAt(row, 2).toString());
        cboJenis.setSelectedItem(tblData.getValueAt(row, 3).toString());
        txtMerek.setText(tblData.getValueAt(row, 4).toString());
        txtModel.setText(tblData.getValueAt(row, 5).toString());
        txtSerialNumber.setText(tblData.getValueAt(row, 6).toString());
        try {
            String tanggalPembelianStr = tblData.getValueAt(row, 7).toString();
            if (!tanggalPembelianStr.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                DatePembelian.setDate(sdf.parse(tanggalPembelianStr));
            } else {
                DatePembelian.setDate(null);
            }
        } catch (Exception e) {
            Logger.getLogger(MasterPerangkatIT.class.getName()).log(Level.SEVERE, null, e);
            DatePembelian.setDate(null); // Fallback jika parsing gagal
        }
        cboKondisi.setSelectedItem(tblData.getValueAt(row, 8).toString());
        cboStatus.setSelectedItem(tblData.getValueAt(row, 9).toString());
    }

    private void updateData() {
        String idPerangkat = txtID.getText().trim();
        String namaPerangkat = txtNamaPerangkat.getText().trim();
        String jenisPerangkat = cboJenis.getSelectedItem().toString();
        String merek = txtMerek.getText().trim();
        String model = txtModel.getText().trim();
        String serialNumber = txtSerialNumber.getText().trim();
        Date tanggalPembelian = DatePembelian.getDate();
        String kondisi = cboKondisi.getSelectedItem().toString();
        String status = cboStatus.getSelectedItem().toString();

        try {
            String sql = "UPDATE perangkat_it SET nama_perangkat=?, jenis_perangkat=?, merek=?, model=?, serial_number=?, tanggal_pembelian=?, kondisi=?, status=? " +
                         "WHERE id_perangkat=?";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, namaPerangkat.isEmpty() ? "Unnamed Device" : namaPerangkat);
                st.setString(2, jenisPerangkat);
                st.setString(3, merek.isEmpty() ? null : merek);
                st.setString(4, model.isEmpty() ? null : model);
                st.setString(5, serialNumber.isEmpty() ? null : serialNumber);
                st.setDate(6, tanggalPembelian != null ? new java.sql.Date(tanggalPembelian.getTime()) : null);
                st.setString(7, kondisi);
                st.setString(8, status);
                st.setString(9, idPerangkat);

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
            Logger.getLogger(MasterPerangkatIT.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Gagal memperbarui data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteData() {
        int selectedRow = tblData.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Apakah yakin ingin menghapus data ini?",
                "Konfirmasi Hapus Data",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String id = tblData.getValueAt(selectedRow, 1).toString();
            try {
                String sql = "DELETE FROM perangkat_it WHERE id_perangkat=?";
                try (PreparedStatement st = conn.prepareStatement(sql)) {
                    st.setString(1, id);
                    int rowDeleted = st.executeUpdate();
                    if (rowDeleted > 0) {
                        JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
                    } else {
                        JOptionPane.showMessageDialog(this, "Gagal menghapus data", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException e) {
                Logger.getLogger(MasterPerangkatIT.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        resetForm();
        loadData();
        showPanel();
    }

    private void searchData() {
        String kataKunci = txtSearch.getText().trim();
        DefaultTableModel model = (DefaultTableModel) tblData.getModel();
        model.setRowCount(0);

        try {
            String sql = "SELECT id_perangkat, nama_perangkat, jenis_perangkat, merek, model, serial_number, tanggal_pembelian, kondisi, status " +
                         "FROM perangkat_it " +
                         "WHERE nama_perangkat LIKE ? OR merek LIKE ? OR serial_number LIKE ?";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, "%" + kataKunci + "%");
                st.setString(2, "%" + kataKunci + "%");
                st.setString(3, "%" + kataKunci + "%");
                ResultSet rs = st.executeQuery();

                int no = 1;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                while (rs.next()) {
                    String idPerangkat = rs.getString("id_perangkat");
                    String namaPerangkat = rs.getString("nama_perangkat");
                    String jenisPerangkat = rs.getString("jenis_perangkat");
                    String merek = rs.getString("merek") != null ? rs.getString("merek") : "";
                    String modelStr = rs.getString("model") != null ? rs.getString("model") : "";
                    String serialNumber = rs.getString("serial_number") != null ? rs.getString("serial_number") : "";
                    Date tanggalPembelian = rs.getDate("tanggal_pembelian");
                    String kondisi = rs.getString("kondisi");
                    String status = rs.getString("status");

                    String tanggalPembelianStr = tanggalPembelian != null ? sdf.format(tanggalPembelian) : "";

                    Object[] rowData = {"   " + no++, idPerangkat, namaPerangkat, jenisPerangkat, merek, modelStr, serialNumber, tanggalPembelianStr, kondisi, status};
                    model.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(MasterPerangkatIT.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Gagal mencari data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

