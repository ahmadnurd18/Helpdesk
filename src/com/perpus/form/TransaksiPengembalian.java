package com.perpus.form;

import com.perpus.config.Koneksi;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.perpus.jdialog.DataPeminjaman;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.*;

public class TransaksiPengembalian extends javax.swing.JPanel {

   private int halamanSaatIni = 1;
    private int dataPerHalaman = 14;
    private int totalPages;
    private final Connection conn;
    private String userID;
    private String userRole;

    public TransaksiPengembalian(String userID, String userRole) {
     initComponents();
    conn = Koneksi.getConnection();
    this.userID = userID;
    this.userRole = userRole != null ? userRole.toLowerCase() : "user";

    // Setup tabel dulu
    setTabelModel();
    setTabelModelDetail();
    setTabelModelSementara();

    // Baru set lebar kolom
    setColumnWidth();  // ← Harus setelah setTabelModel!

    // Lalu load data dan lainnya
    loadData();
    paginationPengembalian();
    actionButton();
    setLayoutForm();
        txtID.setEnabled(false); // ID Pengembalian tidak bisa diubah
         pnDetail.setVisible(false); 
    }
   // ← TAMBAHKAN INI: sembunyikan detail saat pertama buka
    private void setTabelModelSementara() {
       DefaultTableModel model = new DefaultTableModel() {
        @Override public boolean isCellEditable(int row, int column) { return false; }
    };
    model.setColumnIdentifiers(new Object[]{"No", "ID Perangkat", "Jenis", "Merek", "Serial"});
    tblDataSementara.setModel(model);
    }
  

   private void setColumnWidth() {
        TableColumnModel tcm = tblData.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(40); tcm.getColumn(0).setMaxWidth(40); tcm.getColumn(0).setMinWidth(40);
        TableColumnModel tcm2 = tblDataDetail.getColumnModel();
        tcm2.getColumn(0).setPreferredWidth(40); tcm2.getColumn(0).setMaxWidth(40); tcm2.getColumn(0).setMinWidth(40);
    }

    private void setLayoutForm() {
        iconJudul.setIcon(new FlatSVGIcon("com/perpus/icon/pengembalian.svg", 1f));
        iconJudul2.setIcon(new FlatSVGIcon("com/perpus/icon/pengembalian.svg", 1f));
        iconJudul3.setIcon(new FlatSVGIcon("com/perpus/icon/pengembalian.svg", 1f));
        iconDashboard.setIcon(new FlatSVGIcon("com/perpus/icon/dashboard.svg", 1f));
        iconDashboard2.setIcon(new FlatSVGIcon("com/perpus/icon/dashboard.svg", 1f));

        btnAdd.setIcon(new FlatSVGIcon("com/perpus/icon/add_white.svg", 1f));
        btnSave.setIcon(new FlatSVGIcon("com/perpus/icon/save_white.svg", 1f));
        btnCancel.setIcon(new FlatSVGIcon("com/perpus/icon/cancel_white.svg", 1f));

        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON,
                new FlatSVGIcon("com/perpus/icon/search.svg", 0.8f));
        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Cari ID Pengembalian / Peminjaman");

        txtIdPeminjaman.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pilih Peminjaman");
        txtTanggalPinjam.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Tanggal Peminjaman");
        txtTanggalKembali.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Tanggal Pengembalian");
        txtIdPegawai.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ID Pegawai");
        txtNamaPegawai.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nama Pegawai");
        txtIdPerangkat.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ID Perangkat");
        txtJenisPerangkat.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Jenis Perangkat");
        txtMerek.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Merek");
        txtNoSerial.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "No. Serial");
//        txtDenda.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Denda");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        panelAdd = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        iconDashboard2 = new javax.swing.JLabel();
        iconJudul2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnGetPeminjaman = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtTanggalAktual = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtIdPeminjaman = new javax.swing.JTextField();
        txtTanggalPinjam = new javax.swing.JTextField();
        txtTanggalKembali = new javax.swing.JTextField();
        txtIdPegawai = new javax.swing.JTextField();
        txtNamaPegawai = new javax.swing.JTextField();
        txtNoSerial = new javax.swing.JTextField();
        txtMerek = new javax.swing.JTextField();
        txtJenisPerangkat = new javax.swing.JTextField();
        txtIdPerangkat = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtDenda = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDataSementara = new javax.swing.JTable();

        dateChooser1.setTextRefernce(txtTanggalAktual);

        setLayout(new java.awt.CardLayout());

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setPreferredSize(new java.awt.Dimension(1133, 690));
        panelMain.setLayout(new java.awt.CardLayout());

        panelView.setBackground(new java.awt.Color(255, 255, 255));
        panelView.setPreferredSize(new java.awt.Dimension(1133, 690));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Pengembalian Perangkat IT");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Transaksi > Pengembalian");

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
        jLabel22.setText("Data Detail Pengembalian Perangkat IT");

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
                    .addGroup(pnDetailLayout.createSequentialGroup()
                        .addComponent(iconJudul3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 409, Short.MAX_VALUE)
                        .addComponent(btnCloseDetail))
                    .addComponent(jScrollPane2))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(tblData);

        btnAdd.setText("TAMBAH");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 358, Short.MAX_VALUE)
                        .addComponent(iconDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addComponent(btnAdd)
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
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelMain.add(panelView, "card2");

        panelAdd.setBackground(new java.awt.Color(255, 255, 255));
        panelAdd.setPreferredSize(new java.awt.Dimension(1133, 690));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Tambah Data Pengembalian Perangkat");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Transaksi > Pengembalian");

        iconJudul2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        iconJudul2.setForeground(new java.awt.Color(102, 102, 102));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Peminjaman");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Tanggal Pinjam");

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Tanggal Kembali");

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("ID Pegawai");

        btnGetPeminjaman.setText("...");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("No Serial");

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Merek");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Jenis Perangkat");

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("ID Perangkat");

        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Nama Pegawai");

        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("ID");

        jLabel26.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Tanggal Kembali");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(txtTanggalAktual, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(336, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTanggalAktual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSave.setText("SIMPAN");

        btnCancel.setText("BATAL");

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Denda");

        tblDataSementara.setRowHeight(30);
        jScrollPane3.setViewportView(tblDataSementara);

        javax.swing.GroupLayout panelAddLayout = new javax.swing.GroupLayout(panelAdd);
        panelAdd.setLayout(panelAddLayout);
        panelAddLayout.setHorizontalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddLayout.createSequentialGroup()
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAddLayout.createSequentialGroup()
                                .addComponent(iconJudul2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(iconDashboard2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(panelAddLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdPeminjaman)
                                    .addComponent(txtTanggalPinjam)
                                    .addComponent(txtTanggalKembali)
                                    .addComponent(txtIdPegawai)
                                    .addComponent(txtNamaPegawai))
                                .addGap(18, 18, 18)
                                .addComponent(btnGetPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdPerangkat)
                                    .addComponent(txtJenisPerangkat)
                                    .addComponent(txtMerek)
                                    .addComponent(txtNoSerial)
                                    .addComponent(txtDenda))
                                .addGap(166, 166, 166)))
                        .addGap(20, 20, 20))
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTanggalPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTanggalKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamaPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelAddLayout.createSequentialGroup()
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelAddLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnGetPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelAddLayout.createSequentialGroup()
                                .addComponent(txtIdPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtJenisPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMerek, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNoSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(77, 77, 77)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelMain.add(panelAdd, "card2");

        add(panelMain, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCloseDetail;
    private javax.swing.JButton btnGetPeminjaman;
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
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JTextField txtDenda;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIdPegawai;
    private javax.swing.JTextField txtIdPeminjaman;
    private javax.swing.JTextField txtIdPerangkat;
    private javax.swing.JTextField txtJenisPerangkat;
    private javax.swing.JTextField txtMerek;
    private javax.swing.JTextField txtNamaPegawai;
    private javax.swing.JTextField txtNoSerial;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTanggalAktual;
    private javax.swing.JTextField txtTanggalKembali;
    private javax.swing.JTextField txtTanggalPinjam;
    // End of variables declaration//GEN-END:variables

    
    // Button Halaman 
 private void paginationPengembalian() {
     btn_first.addActionListener(e -> { halamanSaatIni = 1; loadData(); });
        btn_before.addActionListener(e -> { if (halamanSaatIni > 1) { halamanSaatIni--; loadData(); } });
        cbx_data.addActionListener(e -> {
            dataPerHalaman = Integer.parseInt(cbx_data.getSelectedItem().toString());
            halamanSaatIni = 1;
            loadData();
        });
        btn_next.addActionListener(e -> { if (halamanSaatIni < totalPages) { halamanSaatIni++; loadData(); } });
        btn_last.addActionListener(e -> { halamanSaatIni = totalPages; loadData(); });
    }

 private void searchData() {
       String key = "%" + txtSearch.getText().trim() + "%";
    DefaultTableModel model = (DefaultTableModel) tblData.getModel();
    model.setRowCount(0);

    String sql = "admin".equals(userRole)
        ? "SELECT pg.ID_Pengembalian, pg.Tanggal_Pengembalian, pg.Peminjaman_ID_Peminjaman, " +
          "u.Nama_Full AS peminjam, peg.Nama_Pegawai AS pegawai " +
          "FROM pengembalian pg " +
          "JOIN peminjaman pm ON pg.Peminjaman_ID_Peminjaman = pm.ID_Peminjaman " +
          "JOIN user u ON pm.User_ID_User = u.ID_User " +
          "JOIN pegawai peg ON pg.Pegawai_ID_Pegawai = peg.ID_Pegawai " +
          "WHERE pg.ID_Pengembalian LIKE ? OR pg.Peminjaman_ID_Peminjaman LIKE ? " +
          "ORDER BY pg.ID_Pengembalian DESC"
        : "SELECT pg.ID_Pengembalian, pg.Tanggal_Pengembalian, pg.Peminjaman_ID_Peminjaman, " +
          "u.Nama_Full AS peminjam, peg.Nama_Pegawai AS pegawai " +
          "FROM pengembalian pg " +
          "JOIN peminjaman pm ON pg.Peminjaman_ID_Peminjaman = pm.ID_Peminjaman " +
          "JOIN user u ON pm.User_ID_User = u.ID_User " +
          "JOIN pegawai peg ON pg.Pegawai_ID_Pegawai = peg.ID_Pegawai " +
          "WHERE pm.User_ID_User = ? AND (pg.ID_Pengembalian LIKE ? OR pg.Peminjaman_ID_Peminjaman LIKE ?) " +
          "ORDER BY pg.ID_Pengembalian DESC";

    try (PreparedStatement st = conn.prepareStatement(sql)) {
        int idx = 1;
        if (!"admin".equals(userRole)) {
            st.setString(idx++, userID);
        }
        st.setString(idx++, key);
        st.setString(idx++, key);

        try (ResultSet rs = st.executeQuery()) {
            int no = 1;
            while (rs.next()) {
                model.addRow(new Object[]{
                    no++,
                    rs.getString("ID_Pengembalian"),
                    rs.getString("Tanggal_Pengembalian"),
                    rs.getString("Peminjaman_ID_Peminjaman"),
                    rs.getString("peminjam"),
                    rs.getString("pegawai")
                });
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error search: " + e.getMessage());
    }
    }

 
  private void calculateTotalPages() {
        String sql = "admin".equals(userRole)
            ? "SELECT COUNT(*) FROM pengembalian"
            : "SELECT COUNT(*) FROM pengembalian WHERE Peminjaman_ID_Peminjaman IN (SELECT ID_Peminjaman FROM peminjaman WHERE User_ID_User = ?)";

        try (PreparedStatement st = conn.prepareStatement(sql)) {
            if (!"admin".equals(userRole)) st.setString(1, userID);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    int total = rs.getInt(1);
                    totalPages = (int) Math.ceil(total / (double) dataPerHalaman);
                    if (totalPages == 0) totalPages = 1;
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
    private void actionButton() {
   btnAdd.addActionListener(e -> {
        panelMain.removeAll();
        panelMain.add(panelAdd);
        panelMain.repaint();
        panelMain.revalidate();
        txtID.setText(generateID());
        txtTanggalAktual.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        resetForm();
    });

    btnSave.addActionListener(e -> insertData());
    btnCancel.addActionListener(e -> showPanel());

    // Tombol X untuk tutup detail
    btnCloseDetail.addActionListener(e -> pnDetail.setVisible(false));

    btnGetPeminjaman.addActionListener(e -> pilihPeminjaman());

    // Search saat ketik
    txtSearch.addKeyListener(new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
            searchData();
        }
    });

    // KLIK BARIS tblData → tampilkan detail pengembalian
    tblData.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = tblData.getSelectedRow();
            if (row != -1) {
                String idPengembalian = tblData.getValueAt(row, 1).toString();
                loadDetail(idPengembalian);
                pnDetail.setVisible(true); // ← BARU MUNCUL SAAT DIKLIK
            }
        }
    });

    // Klik tblDataSementara → isi field perangkat (untuk form tambah)
    tblDataSementara.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = tblDataSementara.getSelectedRow();
            if (row != -1) {
                txtIdPerangkat.setText(tblDataSementara.getValueAt(row, 1).toString());
                txtJenisPerangkat.setText(tblDataSementara.getValueAt(row, 2).toString());
                txtMerek.setText(tblDataSementara.getValueAt(row, 3).toString());
                txtNoSerial.setText(tblDataSementara.getValueAt(row, 4).toString());
                hitungDenda();
            }
        }
    });
    }

    private void pilihPeminjaman() {
       DataPeminjaman dialog = new DataPeminjaman(null, true, userID, userRole);
        dialog.setVisible(true);
        if (dialog.getIdPeminjaman() != null) {
            loadPeminjamanData(dialog.getIdPeminjaman());
        }
    }

private void resetFormPerangkat() {
        txtIdPerangkat.setText("");
        txtJenisPerangkat.setText("");
        txtMerek.setText("");
        txtNoSerial.setText("");
        txtDenda.setText("0");
        DefaultTableModel model = (DefaultTableModel) tblDataSementara.getModel();
        model.setRowCount(0);
    }
    private void loadPeminjamanData(String idPeminjaman) {
        resetFormPerangkat();

        String sqlHeader = "SELECT p.ID_Peminjaman, p.Tanggal_Peminjaman, p.Tanggal_Pengembalian, p.Pegawai_ID_Pegawai, pg.Nama_Pegawai "
                + "FROM peminjaman p JOIN pegawai pg ON p.Pegawai_ID_Pegawai = pg.ID_Pegawai WHERE p.ID_Peminjaman = ? "
                + "AND p.Status_Peminjaman = 'Dipinjam'";

        String sqlDetail = "SELECT pr.ID_Perangkat, pr.Jenis_Perangkat, pr.Merek, pr.No_Serial "
                + "FROM detail_peminjaman dp JOIN perangkat pr "
                + "ON dp.Perangkat_ID_Perangkat = pr.ID_Perangkat "
                + "WHERE dp.Peminjaman_ID_Peminjaman = ?";

        try {
            // Header
            try (PreparedStatement st = conn.prepareStatement(sqlHeader)) {
                st.setString(1, idPeminjaman);
                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        txtIdPeminjaman.setText(rs.getString("ID_Peminjaman"));
                        txtTanggalPinjam.setText(rs.getString("Tanggal_Peminjaman"));
                        txtTanggalKembali.setText(rs.getString("Tanggal_Pengembalian"));
                        txtIdPegawai.setText(rs.getString("Pegawai_ID_Pegawai"));
                        txtNamaPegawai.setText(rs.getString("Nama_Pegawai"));

                        JTextField[] fields = {txtIdPeminjaman, txtTanggalPinjam, txtTanggalKembali,
                                txtIdPegawai, txtNamaPegawai};
                        for (JTextField f : fields) f.setEnabled(false);
                    }
                }
            }

            // Detail perangkat → isi ke tblDataSementara
            try (PreparedStatement st = conn.prepareStatement(sqlDetail)) {
                st.setString(1, idPeminjaman);
                try (ResultSet rs = st.executeQuery()) {
                    DefaultTableModel model = (DefaultTableModel) tblDataSementara.getModel();
                    model.setRowCount(0);
                    int no = 1;
                    while (rs.next()) {
                        model.addRow(new Object[]{
                            no++,
                            rs.getString("ID_Perangkat"),
                            rs.getString("Jenis_Perangkat"),
                            rs.getString("Merek"),
                            rs.getString("No_Serial")
                        });
                    }
                }
            }
            hitungDenda();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal memuat data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getIdPegawaiDariUserID(String userID) {
    String sql = "SELECT Pegawai_ID_Pegawai FROM user WHERE ID_User = ?";
    try (PreparedStatement st = conn.prepareStatement(sql)) {
        st.setString(1, userID);
        try (ResultSet rs = st.executeQuery()) {
            if (rs.next()) {
                return rs.getString("Pegawai_ID_Pegawai"); // bisa NULL untuk admin
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
private void hitungDenda() {
        String tglKembali = txtTanggalKembali.getText();
        String tglAktual = txtTanggalAktual.getText();
        if (tglKembali.isEmpty() || tglAktual.isEmpty()) {
            txtDenda.setText("0");
            return;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date kembali = sdf.parse(tglKembali);
            Date aktual = sdf.parse(tglAktual);
            long diff = aktual.getTime() - kembali.getTime();
            long mingguTelat = diff / (1000 * 60 * 60 * 24 * 7);
            if (mingguTelat < 0) mingguTelat = 0;
            int denda = (int) mingguTelat * 5000;
            txtDenda.setText(String.valueOf(denda));
        } catch (ParseException e) {
            txtDenda.setText("0");
        }
    }

    private String generateID() {
       String prefix = "PG" + new SimpleDateFormat("yyMM").format(new Date());
        String sql = "SELECT RIGHT(ID_Pengembalian, 4) FROM pengembalian WHERE ID_Pengembalian LIKE ? ORDER BY ID_Pengembalian DESC LIMIT 1";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, prefix + "%");
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    int n = Integer.parseInt(rs.getString(1)) + 1;
                    return prefix + String.format("%04d", n);
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return prefix + "0001";
    }

private void insertData() {
    String idPengembalian = txtID.getText();
    String tglAktual = txtTanggalAktual.getText();
    String idPeminjaman = txtIdPeminjaman.getText();
    String dendaStr = txtDenda.getText();

    if (idPeminjaman.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Pilih peminjaman terlebih dahulu!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    DefaultTableModel model = (DefaultTableModel) tblDataSementara.getModel();
    if (model.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "Tidak ada perangkat yang dikembalikan!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // AMBIL ID_Pegawai dari user yang login (bukan userID!)
    String idPegawaiPegawai = getIdPegawaiDariUserID(userID);
    if (idPegawaiPegawai == null) {
        JOptionPane.showMessageDialog(this, "Pegawai tidak ditemukan! (User tidak terkait pegawai)", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        conn.setAutoCommit(false);

        // 1. Insert pengembalian (PAKAI ID_Pegawai, BUKAN userID)
        String sqlHeader = "INSERT INTO pengembalian (ID_Pengembalian, Tanggal_Pengembalian, Denda_Pengembalian, Peminjaman_ID_Peminjaman, Pegawai_ID_Pegawai) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement st = conn.prepareStatement(sqlHeader)) {
            st.setString(1, idPengembalian);
            st.setString(2, tglAktual);
            st.setBigDecimal(3, new java.math.BigDecimal(dendaStr));
            st.setString(4, idPeminjaman);
            st.setString(5, idPegawaiPegawai); // ← INI YANG BENAR!
            st.executeUpdate();
        }

        // 2. Insert detail pengembalian
        String sqlDetail = "INSERT INTO detail_pengembalian (Pengembalian_ID_Pengembalian, Perangkat_ID_Perangkat, Jumlah_Denda) VALUES (?, ?, ?)";
        try (PreparedStatement st = conn.prepareStatement(sqlDetail)) {
            for (int i = 0; i < model.getRowCount(); i++) {
                String idPerangkat = model.getValueAt(i, 1).toString();
                st.setString(1, idPengembalian);
                st.setString(2, idPerangkat);
                st.setBigDecimal(3, new java.math.BigDecimal(dendaStr));
                st.addBatch();
            }
            st.executeBatch();
        }

        // 3. Update status perangkat jadi Tersedia
        String sqlUpdatePerangkat = "UPDATE perangkat SET status = 'Tersedia' WHERE ID_Perangkat = ?";
try (PreparedStatement st = conn.prepareStatement(sqlUpdatePerangkat)) {
    for (int i = 0; i < model.getRowCount(); i++) {
        st.setString(1, model.getValueAt(i, 1).toString());
        st.addBatch();
    }
    st.executeBatch();
        }

        // 4. Update status peminjaman
        String sqlUpdatePeminjaman = "UPDATE peminjaman SET Status_Peminjaman = 'Dikembalikan' WHERE ID_Peminjaman = ?";
        try (PreparedStatement st = conn.prepareStatement(sqlUpdatePeminjaman)) {
            st.setString(1, idPeminjaman);
            st.executeUpdate();
        }

        conn.commit();
        JOptionPane.showMessageDialog(this, "Pengembalian berhasil!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        showPanel();
    } catch (SQLException e) {
        try { conn.rollback(); } catch (SQLException ex) {}
        JOptionPane.showMessageDialog(this, "Gagal menyimpan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } finally {
        try { conn.setAutoCommit(true); } catch (SQLException ex) {}
    }
}

    private void loadData() {
    calculateTotalPages();
    int start = (halamanSaatIni - 1) * dataPerHalaman;
    DefaultTableModel model = (DefaultTableModel) tblData.getModel();
    model.setRowCount(0);

    String sql;
    if ("admin".equals(userRole)) {
        sql = "SELECT pg.ID_Pengembalian, pg.Tanggal_Pengembalian, pg.Peminjaman_ID_Peminjaman, " +
              "u.Nama_Full AS peminjam, peg.Nama_Pegawai AS pegawai " +
              "FROM pengembalian pg " +
              "JOIN peminjaman pm ON pg.Peminjaman_ID_Peminjaman = pm.ID_Peminjaman " +
              "JOIN user u ON pm.User_ID_User = u.ID_User " +
              "JOIN pegawai peg ON pg.Pegawai_ID_Pegawai = peg.ID_Pegawai " +
              "ORDER BY pg.ID_Pengembalian DESC LIMIT ?, ?";
    } else {
        sql = "SELECT pg.ID_Pengembalian, pg.Tanggal_Pengembalian, pg.Peminjaman_ID_Peminjaman, " +
              "u.Nama_Full AS peminjam, peg.Nama_Pegawai AS pegawai " +
              "FROM pengembalian pg " +
              "JOIN peminjaman pm ON pg.Peminjaman_ID_Peminjaman = pm.ID_Peminjaman " +
              "JOIN user u ON pm.User_ID_User = u.ID_User " +
              "JOIN pegawai peg ON pg.Pegawai_ID_Pegawai = peg.ID_Pegawai " +
              "WHERE pm.User_ID_User = ? " +
              "ORDER BY pg.ID_Pengembalian DESC LIMIT ?, ?";
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
            while (rs.next()) {
                model.addRow(new Object[]{
                    no++,
                    rs.getString("ID_Pengembalian"),
                    rs.getString("Tanggal_Pengembalian"),
                    rs.getString("Peminjaman_ID_Peminjaman"),
                    rs.getString("peminjam"),
                    rs.getString("pegawai")
                });
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    lb_halaman.setText("Halaman " + halamanSaatIni + " dari " + totalPages);
}
    private void loadDetail(String idPengembalian) {
DefaultTableModel model = (DefaultTableModel) tblDataDetail.getModel();
    model.setRowCount(0);

    String sql = "SELECT dp.Perangkat_ID_Perangkat, pr.Jenis_Perangkat, pr.Merek, pr.No_Serial, " +
                 "pr.Model_Perangkat, COALESCE(dp.Jumlah_Denda, 0) AS Jumlah_Denda " +
                 "FROM detail_pengembalian dp " +
                 "JOIN perangkat pr ON dp.Perangkat_ID_Perangkat = pr.ID_Perangkat " +
                 "WHERE dp.Pengembalian_ID_Pengembalian = ?";

    try (PreparedStatement st = conn.prepareStatement(sql)) {
        st.setString(1, idPengembalian);
        try (ResultSet rs = st.executeQuery()) {
            int no = 1;
            while (rs.next()) {
                model.addRow(new Object[]{
                    no++,
                    rs.getString("Perangkat_ID_Perangkat"),
                    rs.getString("Jenis_Perangkat"),
                    rs.getString("Merek"),
                    rs.getString("No_Serial"),
                    rs.getString("Model_Perangkat"),
                    "Rp " + rs.getBigDecimal("Jumlah_Denda")
                });
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }



    private void showPanel() {
    panelMain.removeAll();
    panelMain.add(panelView);
    panelMain.repaint();
    panelMain.revalidate();
    loadData();
    pnDetail.setVisible(false);
    }
    

private void resetForm() {
        JTextField[] fields = {txtIdPeminjaman, txtTanggalPinjam, txtTanggalKembali,
                txtIdPegawai, txtNamaPegawai, txtIdPerangkat, txtJenisPerangkat,
                txtMerek, txtNoSerial, txtDenda};
        for (JTextField f : fields) {
            f.setText("");
            f.setEnabled(true);
        }
        resetFormPerangkat();
    }

    private void setTabelModel() {
      DefaultTableModel model = new DefaultTableModel() {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        model.setColumnIdentifiers(new Object[]{"No", "ID Pengembalian", "Tgl Pengembalian", "ID Peminjaman", "Peminjam", "Pegawai"});
        tblData.setModel(model);
    }

    private void setTabelModelDetail() {
   DefaultTableModel model = new DefaultTableModel() {
        @Override public boolean isCellEditable(int row, int column) { return false; }
    };
    model.setColumnIdentifiers(new Object[]{"No", "ID Perangkat", "Jenis", "Merek", "No Serial", "Model", "Denda (Rp)"});
    tblDataDetail.setModel(model);
    }    
}
