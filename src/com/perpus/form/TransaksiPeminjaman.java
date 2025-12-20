package com.perpus.form;

import com.perpus.config.Koneksi;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.perpus.jdialog.DataPegawai;
import com.perpus.jdialog.DataPerangkatIT;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class TransaksiPeminjaman extends javax.swing.JPanel {

    private String userRole; // tambahkan ini
    private int halamanSaatIni = 1;
    private int dataPerHalaman = 14;
    private int totalPages;
    private final Connection conn;
    private String userID;

  public TransaksiPeminjaman(String userID, String userRole) { // tambahkan parameter role
    initComponents();
    conn = Koneksi.getConnection();
    this.userID = userID;
    this.userRole = userRole != null ? userRole.toLowerCase() : "user"; // default user
    setTabelModel();
    setTabelModelDetail();
    setTabelModelSementara();
    loadData(); // otomatis difilter berdasarkan role
    loadDataSementara();
    paginationPerangkat();
    actionButton();
    setColumnWidth();
    setLayoutForm();
    txtTanggalPinjam.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    hitungTanggalKembali();
    pnDetail.setVisible(false);
}

    private void setColumnWidth() {
        TableColumnModel columnModel = tblData.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40); columnModel.getColumn(0).setMaxWidth(40); columnModel.getColumn(0).setMinWidth(40);

        TableColumnModel columnModel2 = tblDataDetail.getColumnModel();
        columnModel2.getColumn(0).setPreferredWidth(40); columnModel2.getColumn(0).setMaxWidth(40); columnModel2.getColumn(0).setMinWidth(40);

        TableColumnModel columnModel3 = tblDataSementara.getColumnModel();
        columnModel3.getColumn(0).setPreferredWidth(40); columnModel3.getColumn(0).setMaxWidth(40); columnModel3.getColumn(0).setMinWidth(40);
    }

    private void setLayoutForm() {
        iconJudul.setIcon(new FlatSVGIcon("com/perpus/icon/peminjaman.svg", 1f));
        iconJudul2.setIcon(new FlatSVGIcon("com/perpus/icon/peminjaman.svg", 1f));
        iconJudul3.setIcon(new FlatSVGIcon("com/perpus/icon/peminjaman.svg", 1f));
        iconDashboard.setIcon(new FlatSVGIcon("com/perpus/icon/dashboard.svg", 1f));
        iconDashboard2.setIcon(new FlatSVGIcon("com/perpus/icon/dashboard.svg", 1f));
        btnAdd.setIcon(new FlatSVGIcon("com/perpus/icon/add_white.svg", 1f));
        btnSave.setIcon(new FlatSVGIcon("com/perpus/icon/save_white.svg", 1f));
        btnCancelAdd.setIcon(new FlatSVGIcon("com/perpus/icon/cancel_white.svg", 1f));

        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON,
                new FlatSVGIcon("com/perpus/icon/search.svg", 0.80f));
        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pencarian");

        txtID.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ID Peminjaman");
        txtIdPegawai.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ID Pegawai");
        txtPegawai.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nama Pegawai");
        txtEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Email");
        txtTelepon.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Telepon");
        txtIDPerangkat.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ID Perangkat");
        txtJnsPerangkat.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Jenis Perangkat");
        txtMrkPerangkat.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Merek");
        txtSerialPerangkat.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Serial");
        txtModelPerangkat.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Model");
    }

    private void hitungTanggalKembali() {
        String tanggalPinjam = txtTanggalPinjam.getText();
        if (tanggalPinjam == null || tanggalPinjam.isEmpty()) return;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date tglPinjam = sdf.parse(tanggalPinjam);
            Calendar cal = Calendar.getInstance();
            cal.setTime(tglPinjam);
            cal.add(Calendar.DATE, 7);
            txtTanggalKembali.setText(sdf.format(cal.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        dateChooser2 = new com.raven.datechooser.DateChooser();
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
        pnDetail = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        iconJudul3 = new javax.swing.JLabel();
        btnCloseDetail = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDataDetail = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        panelAdd = new javax.swing.JPanel();
        iconJudul2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        iconDashboard2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtTanggalPinjam = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtTanggalKembali = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnSetPegawai = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnSetPerangkat = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancelAdd = new javax.swing.JButton();
        txtIdPegawai = new javax.swing.JTextField();
        txtPegawai = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTelepon = new javax.swing.JTextField();
        txtIDPerangkat = new javax.swing.JTextField();
        txtMrkPerangkat = new javax.swing.JTextField();
        txtSerialPerangkat = new javax.swing.JTextField();
        txtModelPerangkat = new javax.swing.JTextField();
        btnUbah = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancelSementara = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDataSementara = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        txtJnsPerangkat = new javax.swing.JTextField();

        dateChooser1.setTextRefernce(txtTanggalPinjam);
        dateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateChooser1PropertyChange(evt);
            }
        });

        dateChooser2.setTextRefernce(txtTanggalKembali);

        setLayout(new java.awt.CardLayout());

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setPreferredSize(new java.awt.Dimension(1133, 690));
        panelMain.setLayout(new java.awt.CardLayout());

        panelView.setBackground(new java.awt.Color(255, 255, 255));
        panelView.setPreferredSize(new java.awt.Dimension(1133, 690));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Peminjaman Perangkat IT");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Transaksi > Peminjaman");

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

        pnDetail.setBackground(new java.awt.Color(250, 250, 250));

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("Detail Peminjaman Perangkat");

        iconJudul3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        iconJudul3.setForeground(new java.awt.Color(102, 102, 102));

        btnCloseDetail.setForeground(new java.awt.Color(255, 255, 255));
        btnCloseDetail.setText("X");

        jScrollPane2.setViewportView(tblDataDetail);

        javax.swing.GroupLayout pnDetailLayout = new javax.swing.GroupLayout(pnDetail);
        pnDetail.setLayout(pnDetailLayout);
        pnDetailLayout.setHorizontalGroup(
            pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(pnDetailLayout.createSequentialGroup()
                        .addComponent(iconJudul3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCloseDetail)))
                .addContainerGap())
        );
        pnDetailLayout.setVerticalGroup(
            pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconJudul3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCloseDetail))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnAdd.setText("TAMBAH");

        jScrollPane1.setViewportView(tblData);

        javax.swing.GroupLayout panelViewLayout = new javax.swing.GroupLayout(panelView);
        panelView.setLayout(panelViewLayout);
        panelViewLayout.setHorizontalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewLayout.createSequentialGroup()
                        .addComponent(iconJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 625, Short.MAX_VALUE)
                        .addComponent(iconDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(pnDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelMain.add(panelView, "card2");

        panelAdd.setBackground(new java.awt.Color(255, 255, 255));
        panelAdd.setPreferredSize(new java.awt.Dimension(1133, 690));

        iconJudul2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        iconJudul2.setForeground(new java.awt.Color(102, 102, 102));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Tambah Peminjaman Perangkat IT");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Transaksi > Peminjaman");

        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("ID");

        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Tanggal Pinjam");

        jLabel26.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Tanggal Kembali");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(txtTanggalPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(txtTanggalKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTanggalKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTanggalPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Pegawai");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Nama");

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Email");

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Telepon");

        btnSetPegawai.setText("...");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Model");

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("No Serial");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Merek");

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("ID Perangkat");

        btnSetPerangkat.setText("...");

        btnSave.setText("SIMPAN");

        btnCancelAdd.setText("BATAL");

        btnUbah.setText("UBAH");

        btnDelete.setText("HAPUS");

        btnCancelSementara.setText("BATAL");

        tblDataSementara.setRowHeight(30);
        jScrollPane3.setViewportView(tblDataSementara);

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Jenis Perangkat");

        javax.swing.GroupLayout panelAddLayout = new javax.swing.GroupLayout(panelAdd);
        panelAdd.setLayout(panelAddLayout);
        panelAddLayout.setHorizontalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelAdd)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddLayout.createSequentialGroup()
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelAddLayout.createSequentialGroup()
                                .addComponent(iconJudul2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(iconDashboard2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)))
                        .addGap(20, 20, 20))))
            .addGroup(panelAddLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addComponent(btnUbah)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelSementara)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddLayout.createSequentialGroup()
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAddLayout.createSequentialGroup()
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelAddLayout.createSequentialGroup()
                                        .addComponent(txtIdPegawai)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSetPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelAddLayout.createSequentialGroup()
                                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPegawai)
                                            .addComponent(txtEmail)
                                            .addComponent(txtTelepon))
                                        .addGap(56, 56, 56)))
                                .addGap(18, 18, 18)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelAddLayout.createSequentialGroup()
                                        .addComponent(txtIDPerangkat)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSetPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelAddLayout.createSequentialGroup()
                                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMrkPerangkat)
                                            .addComponent(txtSerialPerangkat)
                                            .addComponent(txtModelPerangkat)
                                            .addComponent(txtJnsPerangkat))
                                        .addGap(56, 56, 56)))))
                        .addGap(20, 20, 20))))
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
                    .addComponent(btnCancelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSetPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSetPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJnsPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMrkPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSerialPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelSementara, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelMain.add(panelAdd, "card2");

        add(panelMain, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void dateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateChooser1PropertyChange
        hitungTanggalKembali();
    }//GEN-LAST:event_dateChooser1PropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancelAdd;
    private javax.swing.JButton btnCancelSementara;
    private javax.swing.JButton btnCloseDetail;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSetPegawai;
    private javax.swing.JButton btnSetPerangkat;
    private javax.swing.JButton btnUbah;
    private javax.swing.JButton btn_before;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JComboBox<String> cbx_data;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JLabel iconDashboard;
    private javax.swing.JLabel iconDashboard2;
    private javax.swing.JLabel iconJudul;
    private javax.swing.JLabel iconJudul2;
    private javax.swing.JLabel iconJudul3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb_halaman;
    private javax.swing.JPanel panelAdd;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelView;
    private javax.swing.JPanel pnDetail;
    private javax.swing.JTable tblData;
    private javax.swing.JTable tblDataDetail;
    private javax.swing.JTable tblDataSementara;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDPerangkat;
    private javax.swing.JTextField txtIdPegawai;
    private javax.swing.JTextField txtJnsPerangkat;
    private javax.swing.JTextField txtModelPerangkat;
    private javax.swing.JTextField txtMrkPerangkat;
    private javax.swing.JTextField txtPegawai;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSerialPerangkat;
    private javax.swing.JTextField txtTanggalKembali;
    private javax.swing.JTextField txtTanggalPinjam;
    private javax.swing.JTextField txtTelepon;
    // End of variables declaration//GEN-END:variables

    
    // Button Halaman 
 private void paginationPerangkat() {
        btn_first.addActionListener(e -> { halamanSaatIni = 1; loadData(); });
        btn_before.addActionListener(e -> { if (halamanSaatIni > 1) { halamanSaatIni--; loadData(); } });
        cbx_data.addActionListener(e -> { dataPerHalaman = Integer.parseInt(cbx_data.getSelectedItem().toString()); halamanSaatIni = 1; loadData(); });
        btn_next.addActionListener(e -> { if (halamanSaatIni < totalPages) { halamanSaatIni++; loadData(); } });
        btn_last.addActionListener(e -> { halamanSaatIni = totalPages; loadData(); });
    }

    // ================== ACTION BUTTONS ==================
    private void actionButton() {
        btnAdd.addActionListener(e -> {
            panelMain.removeAll();
            panelMain.add(panelAdd);
            panelMain.repaint();
            panelMain.revalidate();
            txtID.setText(generateID());
            txtID.setEnabled(false);
            clearForm();
            clearSementara();
            loadDataSementara();
            btnUbah.setEnabled(false);
            btnDelete.setEnabled(false);
        });

        btnSave.addActionListener(e -> {
            if (validateInput()) {
                insertData();
            }
        });

        btnCancelAdd.addActionListener(e -> showPanel());

        btnCloseDetail.addActionListener(e -> pnDetail.setVisible(false));

        txtSearch.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) { searchData(); }
        });

        tblData.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = tblData.getSelectedRow();
                if (row != -1) {
                    String id = tblData.getValueAt(row, 1).toString();
                    getDataDetail(id);
                    pnDetail.setVisible(true);
                }
            }
        });

        btnSetPegawai.addActionListener(e -> setPegawai());
        btnSetPerangkat.addActionListener(e -> setPerangkatIT());

        tblDataSementara.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = tblDataSementara.getSelectedRow();
                if (row != -1 && e.getClickCount() == 1) {
                    txtIDPerangkat.setText(tblDataSementara.getValueAt(row, 1).toString());
                    txtJnsPerangkat.setText(tblDataSementara.getValueAt(row, 2).toString());
                    txtMrkPerangkat.setText(tblDataSementara.getValueAt(row, 3).toString());
                    txtSerialPerangkat.setText(tblDataSementara.getValueAt(row, 4).toString());
                    txtModelPerangkat.setText(tblDataSementara.getValueAt(row, 5).toString());
                    btnUbah.setEnabled(true);
                    btnDelete.setEnabled(true);
                }
            }
        });

        btnUbah.addActionListener(e -> updateSementara());
        btnDelete.addActionListener(e -> deleteSementara());
        btnCancelSementara.addActionListener(e -> clearFormPerangkat());
    }

    // ================== TABEL MODEL ==================
    private void setTabelModel() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        model.setColumnIdentifiers(new Object[]{"No", "ID", "Tgl Pinjam", "Tgl Kembali", "Status", "Pegawai"});
        tblData.setModel(model);
    }

    private void setTabelModelDetail() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        model.setColumnIdentifiers(new Object[]{"No", "ID Perangkat", "Jenis", "Merek", "Serial", "Model"});
        tblDataDetail.setModel(model);
    }

    private void setTabelModelSementara() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        model.setColumnIdentifiers(new Object[]{"No", "ID Perangkat", "Jenis", "Merek", "Serial", "Model"});
        tblDataSementara.setModel(model);
    }

    // ================== GENERATE ID (PM25110001) ==================
    private String generateID() {
       String prefix = "PM" + new SimpleDateFormat("yyMM").format(new Date());
    String sql = "SELECT RIGHT(ID_Peminjaman, 4) AS nomor FROM peminjaman WHERE ID_Peminjaman LIKE ? ORDER BY ID_Peminjaman DESC LIMIT 1";
    try (PreparedStatement st = conn.prepareStatement(sql)) {
        st.setString(1, prefix + "%");
        try (ResultSet rs = st.executeQuery()) {
            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("nomor")) + 1;
                return prefix + String.format("%04d", nomor);
            } else {
                return prefix + "0001";
            }
        }
    } catch (SQLException e) { e.printStackTrace(); }
    return prefix + "0001";
    }

    // ================== PEGAWAI & PERANGKAT ==================
    private void setPegawai() {
        DataPegawai dialog = new DataPegawai(null, true);
        dialog.setVisible(true);
        if (dialog.getIdPegawai() != null) {
            txtIdPegawai.setText(dialog.getIdPegawai());
            txtPegawai.setText(dialog.getNamaPegawai());
            txtEmail.setText(dialog.getEmailPegawai());
            txtTelepon.setText(dialog.getTeleponPegawai());
            txtIdPegawai.setEnabled(false);
            txtPegawai.setEnabled(false);
            txtEmail.setEnabled(false);
            txtTelepon.setEnabled(false);
        }
    }

    private void setPerangkatIT() {
       DataPerangkatIT dialog = new DataPerangkatIT(null, true);
    dialog.setVisible(true);
    if (dialog.getIdPerangkat() != null) {
        String id = dialog.getIdPerangkat();
        if (cekPerangkatTersedia(id)) {
            insertSementara(id);
            JOptionPane.showMessageDialog(this, "Perangkat ditambahkan ke daftar!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Perangkat sedang dipinjam!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }

   private boolean cekPerangkatTersedia(String id) {
    String sql = "SELECT COUNT(*) FROM detail_peminjaman dp " +
                 "JOIN peminjaman p ON dp.Peminjaman_ID_Peminjaman = p.ID_Peminjaman " +
                 "WHERE dp.Perangkat_ID_Perangkat = ? AND p.Status_Peminjaman = 'Dipinjam'";
    try (PreparedStatement st = conn.prepareStatement(sql)) {
        st.setString(1, id);
        try (ResultSet rs = st.executeQuery()) {
            if (rs.next()) return rs.getInt(1) == 0;
        }
    } catch (SQLException e) { e.printStackTrace(); }
    return false;
}

    private void insertSementara(String idPerangkat) {
        try {
            String sql = "INSERT IGNORE INTO sementara (Perangkat_ID_Perangkat) VALUES (?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, idPerangkat);
            st.executeUpdate();
            loadDataSementara();
            clearFormPerangkat();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Perangkat sudah ada di daftar!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void updateSementara() {
        String id = txtIDPerangkat.getText().trim();
        if (id.isEmpty()) return;
        if (!cekPerangkatTersedia(id)) {
            JOptionPane.showMessageDialog(this, "Perangkat tidak tersedia!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        insertSementara(id);
    }

    private void deleteSementara() {
        int row = tblDataSementara.getSelectedRow();
        if (row == -1) return;
        String id = tblDataSementara.getValueAt(row, 1).toString();
        try {
            String sql = "DELETE FROM sementara WHERE Perangkat_ID_Perangkat = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
            loadDataSementara();
            clearFormPerangkat();
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
    }

    private void clearFormPerangkat() {
        txtIDPerangkat.setText("");
        txtJnsPerangkat.setText("");
        txtMrkPerangkat.setText("");
        txtSerialPerangkat.setText("");
        txtModelPerangkat.setText("");
        btnUbah.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    private void clearForm() {
        txtIdPegawai.setText(""); txtPegawai.setText(""); txtEmail.setText(""); txtTelepon.setText("");
        txtIdPegawai.setEnabled(true); txtPegawai.setEnabled(true); txtEmail.setEnabled(true); txtTelepon.setEnabled(true);
        clearFormPerangkat();
    }

    private void clearSementara() {
        try {
            String sql = "DELETE FROM sementara";
            conn.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
    }

    private boolean validateInput() {
        if (txtIdPegawai.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih pegawai terlebih dahulu!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (getSementaraCount() == 0) {
            JOptionPane.showMessageDialog(this, "Pilih minimal 1 perangkat!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private int getSementaraCount() {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) FROM sementara";
            ResultSet rs = conn.prepareStatement(sql).executeQuery();
            if (rs.next()) count = rs.getInt(1);
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
        return count;
    }

    // ================== INSERT DATA ==================
    private void insertData() {
       String id = txtID.getText();
    String tglPinjam = txtTanggalPinjam.getText();
    String tglKembali = txtTanggalKembali.getText();
    String idPegawai = txtIdPegawai.getText();

    try {
        conn.setAutoCommit(false);

        // 1. Insert ke peminjaman
        String sql = "INSERT INTO peminjaman (ID_Peminjaman, Tanggal_Peminjaman, Tanggal_Pengembalian, Status_Peminjaman, User_ID_User, Pegawai_ID_Pegawai) " +
                     "VALUES (?, ?, ?, 'Dipinjam', ?, ?)";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, id);
            st.setString(2, tglPinjam);
            st.setString(3, tglKembali);
            st.setString(4, userID);
            st.setString(5, idPegawai);
            st.executeUpdate();
        }

        // 2. Insert ke detail_peminjaman
        String sqlDetail = "INSERT INTO detail_peminjaman (Peminjaman_ID_Peminjaman, Perangkat_ID_Perangkat) " +
                           "SELECT ?, Perangkat_ID_Perangkat FROM sementara";
        try (PreparedStatement st = conn.prepareStatement(sqlDetail)) {
            st.setString(1, id);
            st.executeUpdate();
        }

        conn.commit();
        JOptionPane.showMessageDialog(this, "Peminjaman berhasil!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        showPanel();
    } catch (SQLException e) {
        try { conn.rollback(); } catch (SQLException ex) {}
        JOptionPane.showMessageDialog(this, "Gagal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try { conn.setAutoCommit(true); } catch (SQLException ex) {}
    }
    }

    // ================== LOAD DATA ==================
    private void getDataDetail(String idPeminjaman) {
        DefaultTableModel model = (DefaultTableModel) tblDataDetail.getModel();
        model.setRowCount(0);
        try {
            String sql = "SELECT p.ID_Perangkat, p.Jenis_Perangkat, p.Merek, p.No_Serial, p.Model_Perangkat FROM detail_peminjaman dp JOIN perangkat p ON dp.Perangkat_ID_Perangkat = p.ID_Perangkat WHERE dp.Peminjaman_ID_Peminjaman = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, idPeminjaman);
            ResultSet rs = st.executeQuery();
            int no = 1;
            while (rs.next()) {
                model.addRow(new Object[]{no++, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadDataSementara() {
        DefaultTableModel model = (DefaultTableModel) tblDataSementara.getModel();
        model.setRowCount(0);
        try {
            String sql = "SELECT p.ID_Perangkat, p.Jenis_Perangkat, p.Merek, p.No_Serial, p.Model_Perangkat FROM sementara s JOIN perangkat p ON s.Perangkat_ID_Perangkat = p.ID_Perangkat";
            ResultSet rs = conn.prepareStatement(sql).executeQuery();
            int no = 1;
            while (rs.next()) {
                model.addRow(new Object[]{no++, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadData() {
       calculateTotalPages();
    int start = (halamanSaatIni - 1) * dataPerHalaman;
    DefaultTableModel model = (DefaultTableModel) tblData.getModel();
    model.setRowCount(0);

    String sql;
    if ("admin".equals(userRole)) {
        sql = "SELECT p.ID_Peminjaman, p.Tanggal_Peminjaman, p.Tanggal_Pengembalian, p.Status_Peminjaman, g.Nama_Pegawai " +
              "FROM peminjaman p JOIN pegawai g ON p.Pegawai_ID_Pegawai = g.ID_Pegawai " +
              "ORDER BY p.ID_Peminjaman DESC LIMIT ?, ?";
    } else {
        sql = "SELECT p.ID_Peminjaman, p.Tanggal_Peminjaman, p.Tanggal_Pengembalian, p.Status_Peminjaman, g.Nama_Pegawai " +
              "FROM peminjaman p JOIN pegawai g ON p.Pegawai_ID_Pegawai = g.ID_Pegawai " +
              "WHERE p.User_ID_User = ? " +
              "ORDER BY p.ID_Peminjaman DESC LIMIT ?, ?";
    }

    try (PreparedStatement st = conn.prepareStatement(sql)) {
        int idx = 1;
        if (!"admin".equals(userRole)) {
            st.setString(idx++, userID);
        }
        st.setInt(idx++, start);
        st.setInt(idx++, dataPerHalaman);

        try (ResultSet rs = st.executeQuery()) {
            int no = start + 1;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            while (rs.next()) {
                model.addRow(new Object[]{
                    no++,
                    rs.getString(1),
                    rs.getDate(2) != null ? sdf.format(rs.getDate(2)) : "",
                    rs.getDate(3) != null ? sdf.format(rs.getDate(3)) : "",
                    rs.getString(4),
                    rs.getString(5)
                });
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    lb_halaman.setText("Halaman " + halamanSaatIni + " dari " + totalPages);
    }

    private void calculateTotalPages() {
       try {
        String sql;
        if ("admin".equals(userRole)) {
            sql = "SELECT COUNT(*) FROM peminjaman";
        } else {
            sql = "SELECT COUNT(*) FROM peminjaman WHERE User_ID_User = ?";
        }
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            if (!"admin".equals(userRole)) {
                st.setString(1, userID);
            }
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    int total = rs.getInt(1);
                    totalPages = (int) Math.ceil(total / (double) dataPerHalaman);
                    if (totalPages == 0) totalPages = 1;
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    private void searchData() {
        String key = txtSearch.getText().trim();
    DefaultTableModel model = (DefaultTableModel) tblData.getModel();
    model.setRowCount(0);

    String sql;
    if ("admin".equals(userRole)) {
        sql = "SELECT p.ID_Peminjaman, p.Tanggal_Peminjaman, p.Tanggal_Pengembalian, p.Status_Peminjaman, g.Nama_Pegawai " +
              "FROM peminjaman p JOIN pegawai g ON p.Pegawai_ID_Pegawai = g.ID_Pegawai " +
              "WHERE p.ID_Peminjaman LIKE ? OR g.Nama_Pegawai LIKE ? " +
              "ORDER BY p.ID_Peminjaman DESC";
    } else {
        sql = "SELECT p.ID_Peminjaman, p.Tanggal_Peminjaman, p.Tanggal_Pengembalian, p.Status_Peminjaman, g.Nama_Pegawai " +
              "FROM peminjaman p JOIN pegawai g ON p.Pegawai_ID_Pegawai = g.ID_Pegawai " +
              "WHERE p.User_ID_User = ? AND (p.ID_Peminjaman LIKE ? OR g.Nama_Pegawai LIKE ?) " +
              "ORDER BY p.ID_Peminjaman DESC";
    }

    try (PreparedStatement st = conn.prepareStatement(sql)) {
        int idx = 1;
        String like = "%" + key + "%";
        if (!"admin".equals(userRole)) {
            st.setString(idx++, userID);
        }
        st.setString(idx++, like);
        st.setString(idx++, like);

        try (ResultSet rs = st.executeQuery()) {
            int no = 1;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            while (rs.next()) {
                model.addRow(new Object[]{
                    no++,
                    rs.getString(1),
                    rs.getDate(2) != null ? sdf.format(rs.getDate(2)) : "",
                    rs.getDate(3) != null ? sdf.format(rs.getDate(3)) : "",
                    rs.getString(4),
                    rs.getString(5)
                });
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    private String getUserRole() {
    String sql = "SELECT Role FROM user WHERE ID_User = ?";
    try (PreparedStatement st = conn.prepareStatement(sql)) {
        st.setString(1, userID);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return rs.getString("Role");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return "user";
}

    private void showPanel() {
        panelMain.removeAll();
        panelMain.add(panelView);
        panelMain.repaint();
        panelMain.revalidate();
        loadData();
        pnDetail.setVisible(false);
        clearSementara();
    }
}
