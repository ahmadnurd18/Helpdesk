package com.perpus.form;

import com.perpus.config.Koneksi;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.perpus.jdialog.DataPegawai;
import com.perpus.jdialog.DataPerangkatIT;
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
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class TransaksiPeminjaman extends javax.swing.JPanel {

    private int halamanSaatIni = 1;
    private int dataPerHalaman = 14;
    private int totalPages;
    private final Connection conn;
    private String userID;

    public TransaksiPeminjaman(String userID) {
        initComponents();
        conn = Koneksi.getConnection();
        this.userID = userID;
        setTabelModel();
        setTabelModelDetail();
        setTabelModelSementara();
        loadData();
        loadDataSementara();
        paginationPerangkat();
        actionButton();
        setColumnWidth();
        setLayoutForm();
        hitungTanggalKembali();
    }

    private void setColumnWidth() {
        TableColumnModel columnModel = tblData.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(0).setMaxWidth(40);
        columnModel.getColumn(0).setMinWidth(40);

        TableColumnModel columnModel2 = tblDataDetail.getColumnModel();
        columnModel2.getColumn(0).setPreferredWidth(40);
        columnModel2.getColumn(0).setMaxWidth(40);
        columnModel2.getColumn(0).setMinWidth(40);

        TableColumnModel columnModel3 = tblDataSementara.getColumnModel();
        columnModel3.getColumn(0).setPreferredWidth(40);
        columnModel3.getColumn(0).setMaxWidth(40);
        columnModel3.getColumn(0).setMinWidth(40);
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
        btnUbah.setIcon(new FlatSVGIcon("com/perpus/icon/save_white.svg", 1f));
        btnDelete.setIcon(new FlatSVGIcon("com/perpus/icon/delete_white.svg", 1f));
        btnCancelSementara.setIcon(new FlatSVGIcon("com/perpus/icon/cancel_white.svg", 1f));

        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON, 
                new FlatSVGIcon("com/perpus/icon/search.svg", 0.80f));
        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pencarian");
        txtID.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ID Peminjaman");
        txtIdPegawai.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pilih Pegawai");
        txtPegawai.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nama Pegawai");
        txtEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Email Pegawai");
        txtTelepon.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Telepon Pegawai");
        txtIdPerangkat.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pilih Perangkat IT");
        txtNamaPerangkat.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nama Perangkat");
        txtKondisi.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Kondisi Perangkat");
        txtStatus.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Status Perangkat");
    }

    private void hitungTanggalKembali() {
        String tanggalPinjam = txtTanggalPinjam.getText();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date tglPinjam = dateFormat.parse(tanggalPinjam);

            if (tanggalPinjam != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(tglPinjam);
                cal.add(Calendar.DATE, 7);
                Date tglKembali = cal.getTime();
                String tanggalKembali = dateFormat.format(tglKembali);
                txtTanggalKembali.setText(tanggalKembali);
            }
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
        txtIdPerangkat = new javax.swing.JTextField();
        txtNamaPerangkat = new javax.swing.JTextField();
        txtKondisi = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        btnUbah = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancelSementara = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDataSementara = new javax.swing.JTable();

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
        jLabel1.setText("Data Peminjaman Buku Perpustakaan");

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
        jLabel22.setText("Data Detail Peminjaman Buku Perpustakaan");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 297, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
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
        jLabel5.setText("Tambah Data Peminjaman Perangkat IT");

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
        jLabel16.setText("Status");

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Kondisi");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Nama Perangkat");

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Jenis Perangkat");

        btnSetPerangkat.setText("...");

        btnSave.setText("SIMPAN");

        btnCancelAdd.setText("BATAL");

        btnUbah.setText("UBAH");

        btnDelete.setText("HAPUS");

        btnCancelSementara.setText("BATAL");

        tblDataSementara.setRowHeight(30);
        jScrollPane3.setViewportView(tblDataSementara);

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
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelAddLayout.createSequentialGroup()
                                        .addComponent(txtIdPerangkat)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSetPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelAddLayout.createSequentialGroup()
                                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNamaPerangkat)
                                            .addComponent(txtKondisi)
                                            .addComponent(txtStatus))
                                        .addGap(56, 56, 56)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                            .addComponent(txtIdPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamaPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKondisi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelSementara, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
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
    private javax.swing.JTextField txtIdPegawai;
    private javax.swing.JTextField txtIdPerangkat;
    private javax.swing.JTextField txtKondisi;
    private javax.swing.JTextField txtNamaPerangkat;
    private javax.swing.JTextField txtPegawai;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtTanggalKembali;
    private javax.swing.JTextField txtTanggalPinjam;
    private javax.swing.JTextField txtTelepon;
    // End of variables declaration//GEN-END:variables

    
    // Button Halaman 
 private void paginationPerangkat() {
        btn_first.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                halamanSaatIni = 1;
                loadData();
            }
            
        });
        
        btn_before.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (halamanSaatIni > 1)
                {
                    halamanSaatIni--;
                    loadData();
                }
            }
            
        });
        
        cbx_data.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dataPerHalaman = Integer.parseInt(cbx_data.getSelectedItem().toString());
                halamanSaatIni = 1;
                loadData();
            }
            
        });
        
        btn_next.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (halamanSaatIni < totalPages) {
                    halamanSaatIni++;
                    loadData();
                }
            }
            
        });
        
        btn_last.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                halamanSaatIni = totalPages;
                loadData();
            }
            
        });
    }
    
    // Button Add, Save, Delete, Cancel, Search, TableMouseClick
      private void actionButton() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelMain.removeAll();
                panelMain.add(panelAdd);
                panelMain.repaint();
                panelMain.revalidate();

                txtID.setText(setIdPeminjaman());
                txtID.setEnabled(false);
                btnSave.setEnabled(false);
                btnUbah.setText("TAMBAH");
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnSave.getText().equals("TAMBAH")) {
                    btnSave.setText("SIMPAN");
                } else if (btnSave.getText().equals("SIMPAN")) {
                    insertData();
                } else if (btnSave.getText().equals("PERBARUI")) {
                    updateData();
                    resetForm();
                    loadData();
                    showPanel();
                }
            }
        });

        btnUbah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnUbah.getText().equals("TAMBAH")) {
                    insertDataSementara();
                } else if (btnUbah.getText().equals("UBAH")) {
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

        btnCancelSementara.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadDataSementara();
                resetFormPerangkat();
                btnUbah.setText("TAMBAH");
            }
        });

        btnCancelAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel();
                loadData();
            }
        });

        btnCloseDetail.addActionListener(new ActionListener() {
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
                pnDetail.setVisible(true);
                int row = tblData.getSelectedRow();
                String id = tblData.getValueAt(row, 1).toString();
                getDataDetail((DefaultTableModel) tblDataDetail.getModel(), id);
            }
        });

        tblDataSementara.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnUbah.setText("UBAH");
                btnDelete.setVisible(true);
                btnCancelSementara.setVisible(true);
                dataTabelSementara();
            }
        });

        btnSetPegawai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPegawai();
            }
        });

        btnSetPerangkat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPerangkatIT();
            }
        });

    }

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
        } catch (Exception e) {
            Logger.getLogger(TransaksiPeminjaman.class.getName()).log(Level.SEVERE, null, e);
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
        lb_halaman.setText(String.valueOf("Halaman " + halamanSaatIni + " dari Total Data " + totalData));

        int startIndex = (halamanSaatIni - 1) * dataPerHalaman;
        getData(startIndex, dataPerHalaman, (DefaultTableModel) tblData.getModel());
        btnDelete.setVisible(false);
        pnDetail.setVisible(false);
    }

    private void loadDataSementara() {
        getDataSementara((DefaultTableModel) tblDataSementara.getModel());
        btnUbah.setText("TAMBAH");
        btnDelete.setVisible(false);
        btnCancelSementara.setVisible(false);
    }

    private void showPanel() {
        panelMain.removeAll();
        panelMain.add(new TransaksiPeminjaman(userID));
        panelMain.repaint();
        panelMain.revalidate();
    }

    private void resetForm() {
        txtID.setText("");
        txtIdPegawai.setText("");
        txtPegawai.setText("");
        txtEmail.setText("");
        txtTelepon.setText("");
    }

    private void resetFormPerangkat() {
        txtIdPerangkat.setText("");
        txtNamaPerangkat.setText("");
        txtKondisi.setText("");
        txtStatus.setText("");
    }

    private void aktifPerangkat() {
        btnSetPerangkat.setEnabled(true);
        txtIdPerangkat.setEnabled(true);
        txtNamaPerangkat.setEnabled(true);
        txtKondisi.setEnabled(true);
        txtStatus.setEnabled(true);
    }

    private void nonAktifPerangkat() {
        btnSetPerangkat.setEnabled(false);
        txtIdPerangkat.setEnabled(false);
        txtNamaPerangkat.setEnabled(false);
        txtKondisi.setEnabled(false);
        txtStatus.setEnabled(false);
    }

    private void setTabelModel() {
        DefaultTableModel model = (DefaultTableModel) tblData.getModel();
        model.addColumn("No");
        model.addColumn("ID");
        model.addColumn("Tanggal Pinjam");
        model.addColumn("Tanggal Kembali");
        model.addColumn("Status");
        model.addColumn("Nama Pegawai");
    }

    public void getData(int startIndex, int entriesPage, DefaultTableModel model) {
        model.setRowCount(0);

        try {
            String sql = "SELECT pm.id_peminjaman, pm.tanggal_peminjaman, pm.Tanggal_Pengembalian, pm.status, p.nama " +
                         "FROM peminjaman pm " +
                         "INNER JOIN pegawaii p ON p.ID_Pegawai = pm.id_pegawai " +
                         "ORDER BY pm.id_peminjaman ASC LIMIT ?, ?";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setInt(1, startIndex);
                st.setInt(2, entriesPage);
                ResultSet rs = st.executeQuery();

                int no = startIndex + 1;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                while (rs.next()) {
                    String idPeminjaman = rs.getString("id_peminjaman");
                    String tanggalPinjam = rs.getString("tanggal_peminjaman") != null ? sdf.format(rs.getDate("tanggal_peminjaman")) : "";
                    String tanggalKembali = rs.getString("Tanggal_Pengembalian") != null ? sdf.format(rs.getDate("Tanggal_Pengembalian")) : "";
                    String status = rs.getString("status");
                    String namaPegawai = rs.getString("nama");

                    Object[] rowData = {"   " + no++, idPeminjaman, tanggalPinjam, tanggalKembali, status, namaPegawai};
                    model.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(TransaksiPeminjaman.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void setTabelModelDetail() {
        DefaultTableModel model = (DefaultTableModel) tblDataDetail.getModel();
        model.addColumn("No");
        model.addColumn("ID Peminjaman");
        model.addColumn("ID Perangkat");
        model.addColumn("Nama Perangkat");
        model.addColumn("Status Peminjaman");
    }

    public void getDataDetail(DefaultTableModel model, String id) {
        model.setRowCount(0);

        try {
            String sql = "SELECT dp.id_peminjaman, dp.id_perangkat, pi.nama_perangkat, dp.status_peminjaman " +
                         "FROM detail_peminjaman dp " +
                         "INNER JOIN perangkat_it pi ON pi.id_perangkat = dp.id_perangkat " +
                         "WHERE dp.id_peminjaman = ? " +
                         "ORDER BY dp.id_peminjaman ASC";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, id);
                ResultSet rs = st.executeQuery();

                int no = 1;

                while (rs.next()) {
                    String idPeminjaman = rs.getString("id_peminjaman");
                    String idPerangkat = rs.getString("id_perangkat");
                    String namaPerangkat = rs.getString("nama_perangkat");
                    String statusPeminjaman = rs.getString("status_peminjaman");

                    Object[] rowData = {"   " + no++, idPeminjaman, idPerangkat, namaPerangkat, statusPeminjaman};
                    model.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(TransaksiPeminjaman.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void setTabelModelSementara() {
        DefaultTableModel model = (DefaultTableModel) tblDataSementara.getModel();
        model.addColumn("No");
        model.addColumn("ID Perangkat");
        model.addColumn("Nama Perangkat");
        model.addColumn("Jenis");
        model.addColumn("Kondisi");
    }

    public void getDataSementara(DefaultTableModel model) {
        model.setRowCount(0);

        try {
            String sql = "SELECT * FROM peminjaman_sementara";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                ResultSet rs = st.executeQuery();

                int no = 1;

                while (rs.next()) {
                    String idPerangkat = rs.getString("id_perangkat");
                    String namaPerangkat = rs.getString("nama_perangkat");
                    String jenisPerangkat = rs.getString("jenis_perangkat");
                    String kondisi = rs.getString("kondisi");

                    Object[] rowData = {"   " + no++, idPerangkat, namaPerangkat, jenisPerangkat, kondisi};
                    model.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(TransaksiPeminjaman.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private String setIdPeminjaman() {
        String urutan = null;
        Date now = new Date();
        SimpleDateFormat noFormat = new SimpleDateFormat("yyMM");
        String no = noFormat.format(now);

        String sql = "SELECT RIGHT(id_peminjaman, 4) AS Nomor " +
                     "FROM peminjaman " +
                     "WHERE id_peminjaman LIKE 'PM" + no + "%' " +
                     "ORDER BY id_peminjaman DESC " +
                     "LIMIT 1";

        try (PreparedStatement st = conn.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor")) + 1;
                urutan = "PM" + no + String.format("%04d", nomor);
            } else {
                urutan = "PM" + no + "0001";
            }
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(TransaksiPeminjaman.class.getName()).log(Level.SEVERE, null, e);
        }

        return urutan;
    }

    private void setPegawai() {
        boolean closable = true;
        DataPegawai pegawai = new DataPegawai(null, closable);
        pegawai.setVisible(true);

        txtIdPegawai.setText(pegawai.getIdPegawai());
        txtPegawai.setText(pegawai.getNamaPegawai());
        txtEmail.setText(pegawai.getEmailPegawai());
        txtTelepon.setText(pegawai.getTeleponPegawai());

        txtIdPegawai.setEnabled(false);
        txtPegawai.setEnabled(false);
        txtEmail.setEnabled(false);
        txtTelepon.setEnabled(false);
    }

    private void setPerangkatIT() {
        boolean closable = true;
        DataPerangkatIT perangkat = new DataPerangkatIT(null, closable);
        perangkat.setVisible(true);

        txtIdPerangkat.setText(perangkat.getIdPerangkat());
        txtNamaPerangkat.setText(perangkat.getNamaPerangkat());
        txtKondisi.setText(perangkat.getKondisi());
        txtStatus.setText(perangkat.getStatus());

        txtIdPerangkat.setEnabled(false);
        txtNamaPerangkat.setEnabled(false);
        txtKondisi.setEnabled(false);
        txtStatus.setEnabled(false);
    }

    private boolean cekStatusTersedia(String idPerangkat) {
        try {
            String sql = "SELECT status FROM perangkat_it WHERE id_perangkat = ?";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, idPerangkat);
                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    String status = rs.getString("status");
                    return "Tersedia".equals(status);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void insertDataSementara() {
        String idPerangkat = txtIdPerangkat.getText();
        String namaPerangkat = txtNamaPerangkat.getText();
        String jenisPerangkat = txtKondisi.getText();
        String kondisi = txtStatus.getText();

        if (idPerangkat.isEmpty() || namaPerangkat.isEmpty() || jenisPerangkat.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi !", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!cekStatusTersedia(idPerangkat)) {
            JOptionPane.showMessageDialog(this, "Perangkat tidak tersedia untuk dipinjam!", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "INSERT INTO peminjaman_sementara (id_perangkat, nama_perangkat, jenis_perangkat, kondisi, status) VALUES (?,?,?,?,?)";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, idPerangkat);
                st.setString(2, namaPerangkat);
                st.setString(3, jenisPerangkat);
                st.setString(4, kondisi);
                st.setString(5, "Dipinjam");

                st.executeUpdate();

                loadDataSementara();

                if (JOptionPane.showConfirmDialog(this, "Mau Tambah Perangkat?",
                        "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    resetFormPerangkat();
                    btnSetPerangkat.requestFocus();
                } else {
                    resetFormPerangkat();
                    btnSave.requestFocus();
                    btnSave.setEnabled(true);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(TransaksiPeminjaman.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void insertData() {
        String idPeminjaman = txtID.getText();
        String tglPinjam = txtTanggalPinjam.getText();
        String tglKembali = txtTanggalKembali.getText();
        String idPegawai = txtIdPegawai.getText();

        if (idPeminjaman.isEmpty() || tglPinjam.isEmpty() || tglKembali.isEmpty() || idPegawai.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi !", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "INSERT INTO peminjaman (id_peminjaman, tanggal_peminjaman, Tanggal_Pengembalian, status, ID_Pegawai, ID_User) VALUES (?,?,?,?,?,?)";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, idPeminjaman);
                st.setString(2, tglPinjam);
                st.setString(3, tglKembali);
                st.setString(4, "Dipinjam");
                st.setString(5, idPegawai);
                st.setString(6, userID);

                int rowInserted = st.executeUpdate();
                if (rowInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Data Berhasil Ditambahkan");
                }

                insertDataDetail();
                deleteDataSementara();
                resetForm();
                loadData();
                showPanel();
            }
        } catch (SQLException e) {
            Logger.getLogger(TransaksiPeminjaman.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void insertDataDetail() {
        String idPeminjaman = txtID.getText();

        try {
            String sql = "INSERT INTO detail_peminjaman (id_peminjaman, id_perangkat, status_peminjaman) " +
                         "SELECT ?, id_perangkat, status FROM peminjaman_sementara";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, idPeminjaman);
                st.executeUpdate();

                String updateSql = "UPDATE perangkat_it pi " +
                                 "INNER JOIN peminjaman_sementara ps ON pi.id_perangkat = ps.id_perangkat " +
                                 "SET pi.status = 'Dipinjam' " +
                                 "WHERE pi.status = 'Tersedia'";
                try (PreparedStatement updateSt = conn.prepareStatement(updateSql)) {
                    updateSt.executeUpdate();
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(TransaksiPeminjaman.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void dataTabelSementara() {
        int row = tblDataSementara.getSelectedRow();
        if (row != -1) {
            nonAktifPerangkat();

            String id = tblDataSementara.getValueAt(row, 1).toString();
            txtIdPerangkat.setText(tblDataSementara.getValueAt(row, 1).toString());
            txtNamaPerangkat.setText(tblDataSementara.getValueAt(row, 2).toString());
            txtKondisi.setText(tblDataSementara.getValueAt(row, 3).toString());
            txtStatus.setText(tblDataSementara.getValueAt(row, 4).toString());
        }
    }

    private void updateData() {
        String idPerangkat = txtIdPerangkat.getText();

        if (idPerangkat.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus dipilih dan diisi !", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "UPDATE peminjaman_sementara SET status = ? WHERE id_perangkat = ?";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, "Dipinjam");
                st.setString(2, idPerangkat);
                int rowUpdated = st.executeUpdate();

                if (rowUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Data Berhasil Diperbarui");
                    resetFormPerangkat();
                    loadDataSementara();
                    aktifPerangkat();
                    btnSave.setEnabled(true);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(TransaksiPeminjaman.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void deleteData() {
        int selectedRow = tblDataSementara.getSelectedRow();
        int confirm = JOptionPane.showConfirmDialog(this,
                "Apakah yakin ingin menghapus data ini ?",
                "Konfirmasi Hapus Data",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String id = tblDataSementara.getValueAt(selectedRow, 1).toString();
            try {
                String sql = "DELETE FROM peminjaman_sementara WHERE id_perangkat = ?";
                try (PreparedStatement st = conn.prepareStatement(sql)) {
                    st.setString(1, id);
                    int rowDeleted = st.executeUpdate();

                    if (rowDeleted > 0) {
                        JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
                    } else {
                        JOptionPane.showMessageDialog(this, "Data Gagal Dihapus");
                    }

                    btnUbah.setText("TAMBAH");
                    aktifPerangkat();
                }
            } catch (SQLException e) {
                Logger.getLogger(TransaksiPeminjaman.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        resetFormPerangkat();
        loadDataSementara();
    }

    private void deleteDataSementara() {
        try {
            String sql = "DELETE FROM peminjaman_sementara";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(TransaksiPeminjaman.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void searchData() {
        String kataKunci = txtSearch.getText();

        DefaultTableModel model = (DefaultTableModel) tblData.getModel();
        model.setRowCount(0);

        try {
            String sql = "SELECT pm.id_peminjaman, pm.tanggal_peminjaman, pm.Tanggal_Pengembalian, pm.status, p.nama " +
                         "FROM peminjaman pm " +
                         "INNER JOIN pegawaii p ON p.ID_Pegawai = pm.id_pegawai " +
                         "WHERE pm.id_peminjaman LIKE ? OR p.nama LIKE ?";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, "%" + kataKunci + "%");
                st.setString(2, "%" + kataKunci + "%");
                ResultSet rs = st.executeQuery();

                int no = 1;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                while (rs.next()) {
                    String idPeminjaman = rs.getString("id_peminjaman");
                    String tanggalPinjam = rs.getString("tanggal_peminjaman") != null ? sdf.format(rs.getDate("tanggal_peminjaman")) : "";
                    String tanggalKembali = rs.getString("Tanggal_Pengembalian") != null ? sdf.format(rs.getDate("Tanggal_Pengembalian")) : "";
                    String status = rs.getString("status");
                    String namaPegawai = rs.getString("nama");

                    Object[] rowData = {"   " + no++, idPeminjaman, tanggalPinjam, tanggalKembali, status, namaPegawai};
                    model.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(TransaksiPeminjaman.class.getName()).log(Level.SEVERE, null, e);
        }
    }    }
