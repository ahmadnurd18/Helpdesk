package com.perpus.form;

import com.perpus.config.Koneksi;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.perpus.jdialog.DataKategori;
import com.perpus.jdialog.DataPegawai;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class TransaksiTiket extends javax.swing.JPanel {

    private int halamanSaatIni = 1;
    private int dataPerHalaman = 14;
    private int totalPages;
    private final Connection conn;
    private String userID;

    public TransaksiTiket(String userID) {
        initComponents();
        conn = Koneksi.getConnection();
        this.userID = userID;
        setTabelModel();
        setTabelModelDetail();
        setTabelModelSementara();
        loadData();
        loadDataSementara();
        paginationTiket();
        actionButton();
        setColumnWidth();
        setLayoutForm();
        initializeStatus();
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
        iconJudul.setIcon(new FlatSVGIcon("com/perpus/icon/ticket.svg", 1f));
        iconJudul2.setIcon(new FlatSVGIcon("com/perpus/icon/ticket.svg", 1f));
        iconJudul3.setIcon(new FlatSVGIcon("com/perpus/icon/ticket.svg", 1f));
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
        txtID.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ID Tiket");
        txtIdKategori.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pilih Kategori");
        txtNamaKategori.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nama Kategori");
        txtIdPegawai.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pilih Pegawai");
        txtNamaPegawai.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nama Pegawai");
        txtPrioritas.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Prioritas");
        txtDeskripsi.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Deskripsi Tiket");
        txtEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Email");
        txtTelepon.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Telepon");
    }

    private void initializeStatus() {
        cboStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbStatus.setText(cboStatus.getSelectedItem().toString());
            }
        });
        lbStatus.setText(cboStatus.getSelectedItem().toString());
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
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnSetPegawai = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnSetKategori = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancelAdd = new javax.swing.JButton();
        txtIdPegawai = new javax.swing.JTextField();
        txtNamaPegawai = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTelepon = new javax.swing.JTextField();
        txtIdKategori = new javax.swing.JTextField();
        txtNamaKategori = new javax.swing.JTextField();
        txtPrioritas = new javax.swing.JTextField();
        btnUbah = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancelSementara = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDataSementara = new javax.swing.JTable();
        txtDeskripsi = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        cboStatus = new javax.swing.JComboBox<>();

        dateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateChooser1PropertyChange(evt);
            }
        });

        setLayout(new java.awt.CardLayout());

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setPreferredSize(new java.awt.Dimension(1133, 690));
        panelMain.setLayout(new java.awt.CardLayout());

        panelView.setBackground(new java.awt.Color(255, 255, 255));
        panelView.setPreferredSize(new java.awt.Dimension(1133, 690));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Data Tiket Helpdesk");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Transaksi > Tiket");

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
        jLabel22.setText("Data Detail Tiket Helpdesk");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 724, Short.MAX_VALUE)
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
        jLabel5.setText("Tambah Data Tiket Helpdesk");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Transaksi > Tiket");

        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(832, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("ID Pegawai");

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

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Prioritas");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Kategori");

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("ID Kategori");

        btnSetKategori.setText("...");

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Status");

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Status");

        lbStatus.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(102, 102, 102));
        lbStatus.setText("Status");

        btnSave.setText("SIMPAN");

        btnCancelAdd.setText("BATAL");

        btnUbah.setText("UBAH");

        btnDelete.setText("HAPUS");

        btnCancelSementara.setText("BATAL");

        tblDataSementara.setRowHeight(30);
        jScrollPane3.setViewportView(tblDataSementara);

        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Deskripsi");

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Open", "Proses", "Selesai", "Close" }));

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
                                        .addComponent(txtIdPegawai, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSetPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelAddLayout.createSequentialGroup()
                                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNamaPegawai)
                                            .addComponent(txtEmail)
                                            .addComponent(txtTelepon))
                                        .addGap(56, 56, 56)))
                                .addGap(18, 18, 18)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelAddLayout.createSequentialGroup()
                                        .addComponent(txtIdKategori, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSetKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelAddLayout.createSequentialGroup()
                                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNamaKategori)
                                            .addComponent(txtPrioritas)
                                            .addComponent(txtDeskripsi))
                                        .addGap(56, 56, 56)))
                                .addGap(163, 163, 163)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelAddLayout.createSequentialGroup()
                                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21)
                                            .addComponent(lbStatus)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panelAddLayout.createSequentialGroup()
                                        .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(20, 20, 20))))
        );
        panelAddLayout.setVerticalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                        .addGap(18, 18, 18)
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
                                    .addComponent(txtNamaPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelAddLayout.createSequentialGroup()
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSetKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNamaKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrioritas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelSementara, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panelMain.add(panelAdd, "card2");

        add(panelMain, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void dateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateChooser1PropertyChange

    }//GEN-LAST:event_dateChooser1PropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancelAdd;
    private javax.swing.JButton btnCancelSementara;
    private javax.swing.JButton btnCloseDetail;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSetKategori;
    private javax.swing.JButton btnSetPegawai;
    private javax.swing.JButton btnUbah;
    private javax.swing.JButton btn_before;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JComboBox<String> cboStatus;
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
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lb_halaman;
    private javax.swing.JPanel panelAdd;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelView;
    private javax.swing.JPanel pnDetail;
    private javax.swing.JTable tblData;
    private javax.swing.JTable tblDataDetail;
    private javax.swing.JTable tblDataSementara;
    private javax.swing.JTextField txtDeskripsi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIdKategori;
    private javax.swing.JTextField txtIdPegawai;
    private javax.swing.JTextField txtNamaKategori;
    private javax.swing.JTextField txtNamaPegawai;
    private javax.swing.JTextField txtPrioritas;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTelepon;
    // End of variables declaration//GEN-END:variables

    
    // Button Halaman 
   private void paginationTiket() {
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

    // Button Add, Save, Delete, Cancel, Search, TableMouseClick
    private void actionButton() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelMain.removeAll();
                panelMain.add(panelAdd);
                panelMain.repaint();
                panelMain.revalidate();

                txtID.setText(setIdTiket());
                txtID.setEnabled(false);
                btnSave.setEnabled(false);
                btnUbah.setText("TAMBAH");
                resetFormTiket();
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
                resetFormTiket();
                btnUbah.setText("TAMBAH");
                btnDelete.setVisible(false);
                btnCancelSementara.setVisible(false);
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

        btnSetKategori.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setKategori();
            }
        });

        btnSetPegawai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPegawai();
            }
        });
    }

    // Fungsi lainnya
    private int getTotalData() {
        int totalData = 0;
        try {
            String sql = "SELECT COUNT(*) AS total FROM tiket";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    totalData = rs.getInt("total");
                }
            }
        } catch (Exception e) {
            Logger.getLogger(TransaksiTiket.class.getName()).log(Level.SEVERE, null, e);
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
        pnDetail.setVisible(false);
    }

    private void loadDataSementara() {
        getDataSementara((DefaultTableModel) tblDataSementara.getModel());
        btnUbah.setText("TAMBAH");
        btnDelete.setVisible(false);
        btnCancelSementara.setVisible(false);
        btnSave.setEnabled(!((DefaultTableModel) tblDataSementara.getModel()).getDataVector().isEmpty());
    }

    private void showPanel() {
        panelMain.removeAll();
        panelMain.add(new TransaksiTiket(userID));
        panelMain.repaint();
        panelMain.revalidate();
    }

    private void resetForm() {
        txtID.setText("");
    }

    private void resetFormTiket() {
        txtIdKategori.setText("");
        txtNamaKategori.setText("");
        txtIdPegawai.setText("");
        txtNamaPegawai.setText("");
        txtEmail.setText("");
        txtTelepon.setText("");
        txtPrioritas.setText("");
        txtDeskripsi.setText("");
        txtIdKategori.setEnabled(true);
        txtNamaKategori.setEnabled(true);
        txtIdPegawai.setEnabled(true);
        txtNamaPegawai.setEnabled(true);
        txtEmail.setEnabled(true);
        txtTelepon.setEnabled(true);
    }

    private void setTabelModel() {
        DefaultTableModel model = (DefaultTableModel) tblData.getModel();
        model.addColumn("No");
        model.addColumn("ID Tiket");
        model.addColumn("Tanggal Pembuatan");
        model.addColumn("Prioritas");
        model.addColumn("Kategori");
        model.addColumn("Pegawai");
        model.addColumn("User");
        model.addColumn("Status");
    }

    public void getData(int startIndex, int entriesPage, DefaultTableModel model) {
        model.setRowCount(0);

        try {
            String sql = "SELECT t.ID_Tiket, t.Tanggal_Pembuatan, t.Prioritas, k.Nama_Kategori, p.Nama, u.username, t.Status " +
                         "FROM tiket t " +
                         "INNER JOIN kategori k ON k.ID_Kategori = t.ID_Kategori " +
                         "INNER JOIN pegawaii p ON p.ID_Pegawai = t.ID_Pegawai " +
                         "INNER JOIN users u ON u.user_id = t.user_id " +
                         "ORDER BY t.ID_Tiket ASC LIMIT ?,?";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setInt(1, startIndex);
                st.setInt(2, entriesPage);
                ResultSet rs = st.executeQuery();

                int no = startIndex + 1;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                while (rs.next()) {
                    String idTiket = rs.getString("ID_Tiket");
                    String tanggalPembuatan = sdf.format(rs.getTimestamp("Tanggal_Pembuatan"));
                    String prioritas = rs.getString("Prioritas");
                    String namaKategori = rs.getString("Nama_Kategori");
                    String namaPegawai = rs.getString("Nama");
                    String namaUser = rs.getString("username");
                    String status = rs.getString("Status");

                    Object[] rowData = {"   " + no++, idTiket, tanggalPembuatan, prioritas, namaKategori, namaPegawai, namaUser, status};
                    model.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(TransaksiTiket.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void setTabelModelDetail() {
        DefaultTableModel model = (DefaultTableModel) tblDataDetail.getModel();
        model.addColumn("No");
        model.addColumn("ID Tiket");
        model.addColumn("Deskripsi");
    }

    public void getDataDetail(DefaultTableModel model, String id) {
        model.setRowCount(0);

        try {
            String sql = "SELECT ID_Tiket, Deskripsi FROM detail_tiket WHERE ID_Tiket = ? ORDER BY ID_Tiket ASC";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, id);
                ResultSet rs = st.executeQuery();

                int no = 1;

                while (rs.next()) {
                    String idTiket = rs.getString("ID_Tiket");
                    String deskripsi = rs.getString("Deskripsi");

                    Object[] rowData = {"   " + no++, idTiket, deskripsi};
                    model.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(TransaksiTiket.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void setTabelModelSementara() {
        DefaultTableModel model = (DefaultTableModel) tblDataSementara.getModel();
        model.addColumn("No");
        model.addColumn("ID Kategori");
        model.addColumn("Nama Kategori");
        model.addColumn("ID Pegawai");
        model.addColumn("Nama Pegawai");
        model.addColumn("Email");
        model.addColumn("Telepon");
        model.addColumn("Prioritas");
        model.addColumn("Deskripsi");
    }

    public void getDataSementara(DefaultTableModel model) {
        model.setRowCount(0);

        try {
            String sql = "SELECT * FROM sementara_tiket";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                ResultSet rs = st.executeQuery();

                int no = 1;

                while (rs.next()) {
                    String idKategori = rs.getString("ID_Kategori");
                    String namaKategori = rs.getString("Nama_Kategori");
                    String idPegawai = rs.getString("ID_Pegawai");
                    String namaPegawai = rs.getString("Nama_Pegawai");
                    String email = rs.getString("Email");
                    String telepon = rs.getString("Telepon");
                    String prioritas = rs.getString("Prioritas");
                    String deskripsi = rs.getString("Deskripsi");

                    Object[] rowData = {"   " + no++, idKategori, namaKategori, idPegawai, namaPegawai, email, telepon, prioritas, deskripsi};
                    model.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(TransaksiTiket.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private String setIdTiket() {
        String urutan = null;
        Date now = new Date();
        SimpleDateFormat noFormat = new SimpleDateFormat("yyMMdd");
        String no = noFormat.format(now);

        String sql = "SELECT RIGHT(ID_Tiket, 4) AS Nomor " +
                     "FROM tiket " +
                     "WHERE ID_Tiket LIKE 'TK" + no + "%' " +
                     "ORDER BY ID_Tiket DESC " +
                     "LIMIT 1";

        try (PreparedStatement st = conn.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor")) + 1;
                urutan = "TK" + no + String.format("%04d", nomor);
            } else {
                urutan = "TK" + no + "0001";
            }
        } catch (SQLException | NumberFormatException e) {
            Logger.getLogger(TransaksiTiket.class.getName()).log(Level.SEVERE, null, e);
            urutan = "TK" + no + "0001";
        }
        return urutan;
    }

    private void setKategori() {
        boolean closable = true;
        DataKategori kategori = new DataKategori(null, closable);
        kategori.setVisible(true);

        txtIdKategori.setText(kategori.getIdKategori());
        txtNamaKategori.setText(kategori.getNamaKategori());
        txtPrioritas.setText(kategori.getPrioritas());
        txtDeskripsi.setText(kategori.getDeskripsi());

        txtIdKategori.setEnabled(false);
        txtNamaKategori.setEnabled(false);
        txtPrioritas.setEnabled(false);
        txtDeskripsi.setEnabled(false);
    }

    private void setPegawai() {
       boolean closable = true;
    DataPegawai pegawai = new DataPegawai(null, closable);
    pegawai.setVisible(true);

    String idPegawai = pegawai.getIdPegawai();
    try {
        String sql = "SELECT COUNT(*) AS count FROM pegawaii WHERE ID_Pegawai = ?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, idPegawai);
            ResultSet rs = st.executeQuery();
            if (rs.next() && rs.getInt("count") > 0) {
                txtIdPegawai.setText(idPegawai);
                txtNamaPegawai.setText(pegawai.getNamaPegawai());
                txtEmail.setText(pegawai.getEmailPegawai());
                txtTelepon.setText(pegawai.getTeleponPegawai());
                txtIdPegawai.setEnabled(false);
                txtNamaPegawai.setEnabled(false);
                txtEmail.setEnabled(false);
                txtTelepon.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "ID Pegawai tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException e) {
        Logger.getLogger(TransaksiTiket.class.getName()).log(Level.SEVERE, null, e);
    }
    }

    private void insertDataSementara() {
        String idKategori = txtIdKategori.getText();
        String namaKategori = txtNamaKategori.getText();
        String idPegawai = txtIdPegawai.getText();
        String namaPegawai = txtNamaPegawai.getText();
        String email = txtEmail.getText();
        String telepon = txtTelepon.getText();
        String prioritas = txtPrioritas.getText();
        String deskripsi = txtDeskripsi.getText();

        if (idKategori.length() > 10) {
            JOptionPane.showMessageDialog(this, "ID Kategori terlalu panjang! Maksimum 10 karakter.", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (idPegawai.length() > 10) {
            JOptionPane.showMessageDialog(this, "ID Pegawai terlalu panjang! Maksimum 10 karakter.", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (prioritas.length() > 50) {
            JOptionPane.showMessageDialog(this, "Prioritas terlalu panjang! Maksimum 50 karakter.", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (idKategori.isEmpty() || namaKategori.isEmpty() || idPegawai.isEmpty() || namaPegawai.isEmpty() || email.isEmpty() || telepon.isEmpty() || prioritas.isEmpty() || deskripsi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "INSERT INTO sementara_tiket (ID_Kategori, Nama_Kategori, ID_Pegawai, Nama_Pegawai, Email, Telepon, Prioritas, Deskripsi) VALUES (?,?,?,?,?,?,?,?)";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, idKategori);
                st.setString(2, namaKategori);
                st.setString(3, idPegawai);
                st.setString(4, namaPegawai);
                st.setString(5, email);
                st.setString(6, telepon);
                st.setString(7, prioritas);
                st.setString(8, deskripsi);

                if (st.executeUpdate() > 0) {
                    loadDataSementara();
                    if (JOptionPane.showConfirmDialog(this, "Mau Tambah Tiket Lain?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                        resetFormTiket();
                        btnSave.setEnabled(true);
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(TransaksiTiket.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void insertData() {
         String idTiket = txtID.getText();
        String idKategori = txtIdKategori.getText();
        String idPegawai = txtIdPegawai.getText();
        String prioritas = txtPrioritas.getText();
        String deskripsi = txtDeskripsi.getText();
        String status = lbStatus.getText();
        String idUser = userID; // Pastikan userID sesuai dengan user_id di tabel users

        if (idTiket.isEmpty() || idKategori.isEmpty() || idPegawai.isEmpty() || prioritas.isEmpty() || deskripsi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom wajib diisi!", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (idKategori.length() > 10 || idPegawai.length() > 10 || idUser.length() > 30 || prioritas.length() > 50) { // Diperbarui max length untuk idUser ke 30
            JOptionPane.showMessageDialog(this, "Panjang kolom melebihi batas maksimum!", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Validasi foreign key untuk kategori
            String sqlValidateKategori = "SELECT COUNT(*) AS count FROM kategori WHERE id_kategori = ?";
            try (PreparedStatement stValidateK = conn.prepareStatement(sqlValidateKategori)) {
                stValidateK.setString(1, idKategori);
                ResultSet rsK = stValidateK.executeQuery();
                if (rsK.next() && rsK.getInt("count") == 0) {
                    JOptionPane.showMessageDialog(this, "ID Kategori tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Validasi foreign key untuk pegawai
            String sqlValidatePegawai = "SELECT COUNT(*) AS count FROM pegawaii WHERE ID_Pegawai = ?";
            try (PreparedStatement stValidateP = conn.prepareStatement(sqlValidatePegawai)) {
                stValidateP.setString(1, idPegawai);
                ResultSet rsP = stValidateP.executeQuery();
                if (rsP.next() && rsP.getInt("count") == 0) {
                    JOptionPane.showMessageDialog(this, "ID Pegawai tidak ditemukan di tabel pegawaii! Silakan pilih ID Pegawai yang valid.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Validasi foreign key untuk user
            String sqlValidateUser = "SELECT COUNT(*) AS count FROM users WHERE user_id = ?"; // Diperbarui ke users.user_id
            try (PreparedStatement stValidateU = conn.prepareStatement(sqlValidateUser)) {
                stValidateU.setString(1, idUser);
                ResultSet rsU = stValidateU.executeQuery();
                if (rsU.next() && rsU.getInt("count") == 0) {
                    JOptionPane.showMessageDialog(this, "ID User tidak ditemukan di tabel users! Silakan periksa ID User yang digunakan.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Insert ke tabel tiket
            String sql = "INSERT INTO tiket (ID_Tiket, Tanggal_Pembuatan, Prioritas, ID_Kategori, ID_Pegawai, user_id, Status) VALUES (?, CURRENT_TIMESTAMP, ?, ?, ?, ?, ?)"; // Diperbarui ke user_id
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, idTiket);
                st.setString(2, prioritas);
                st.setString(3, idKategori);
                st.setString(4, idPegawai);
                st.setString(5, idUser); // Gunakan user_id
                st.setString(6, status);

                int rowInserted = st.executeUpdate();
                if (rowInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Data Tiket Berhasil Ditambahkan");

                    // Insert deskripsi ke detail_tiket
                    String sqlDetail = "INSERT INTO detail_tiket (ID_Tiket, Deskripsi) VALUES (?, ?)";
                    try (PreparedStatement stDetail = conn.prepareStatement(sqlDetail)) {
                        stDetail.setString(1, idTiket);
                        stDetail.setString(2, deskripsi);
                        stDetail.executeUpdate();
                    }

                    resetForm();
                    loadData();
                    showPanel();
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(TransaksiTiket.class.getName()).log(Level.SEVERE, "Error saat menyimpan data: " + e.getMessage(), e);
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void insertDataDetail() {
        String idTiket = txtID.getText();

        try {
            String sql = "INSERT INTO detail_tiket (ID_Tiket, Deskripsi) SELECT ?, Deskripsi FROM sementara_tiket";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, idTiket);
                st.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(TransaksiTiket.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void dataTabelSementara() {
        int row = tblDataSementara.getSelectedRow();
        if (row != -1) {
            txtIdKategori.setText(tblDataSementara.getValueAt(row, 1).toString());
            txtNamaKategori.setText(tblDataSementara.getValueAt(row, 2).toString());
            txtIdPegawai.setText(tblDataSementara.getValueAt(row, 3).toString());
            txtNamaPegawai.setText(tblDataSementara.getValueAt(row, 4).toString());
            txtEmail.setText(tblDataSementara.getValueAt(row, 5).toString());
            txtTelepon.setText(tblDataSementara.getValueAt(row, 6).toString());
            txtPrioritas.setText(tblDataSementara.getValueAt(row, 7).toString());
            txtDeskripsi.setText(tblDataSementara.getValueAt(row, 8).toString());
            txtDeskripsi.requestFocus();

            txtIdKategori.setEnabled(false);
            txtNamaKategori.setEnabled(false);
            txtIdPegawai.setEnabled(false);
            txtNamaPegawai.setEnabled(false);
            txtEmail.setEnabled(false);
            txtTelepon.setEnabled(false);
            txtPrioritas.setEnabled(false);
            txtDeskripsi.setEnabled(false);
        }
    }

    private void updateData() {
        String idKategori = txtIdKategori.getText();
        String idPegawai = txtIdPegawai.getText();
        String prioritas = txtPrioritas.getText();
        String deskripsi = txtDeskripsi.getText();

        if (idKategori.isEmpty() || idPegawai.isEmpty() || prioritas.isEmpty() || deskripsi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "UPDATE sementara_tiket SET Prioritas = ?, Deskripsi = ? WHERE ID_Kategori = ? AND ID_Pegawai = ?";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, prioritas);
                st.setString(2, deskripsi);
                st.setString(3, idKategori);
                st.setString(4, idPegawai);
                int rowUpdated = st.executeUpdate();

                if (rowUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Data Berhasil Diperbarui");
                    resetFormTiket();
                    loadDataSementara();
                    btnSave.setEnabled(true);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(TransaksiTiket.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void deleteData() {
        int selectedRow = tblDataSementara.getSelectedRow();
        int confirm = JOptionPane.showConfirmDialog(this,
                "Apakah yakin ingin menghapus data ini?",
                "Konfirmasi Hapus Data",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String idKategori = tblDataSementara.getValueAt(selectedRow, 1).toString();
            try {
                String sql = "DELETE FROM sementara_tiket WHERE ID_Kategori = ?";
                try (PreparedStatement st = conn.prepareStatement(sql)) {
                    st.setString(1, idKategori);
                    int rowDeleted = st.executeUpdate();

                    if (rowDeleted > 0) {
                        JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
                    } else {
                        JOptionPane.showMessageDialog(this, "Data Gagal Dihapus");
                    }
                    btnUbah.setText("TAMBAH");
                }
            } catch (SQLException e) {
                Logger.getLogger(TransaksiTiket.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        resetFormTiket();
        loadDataSementara();
    }

    private void deleteDataSementara() {
        try {
            String sql = "DELETE FROM sementara_tiket";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(TransaksiTiket.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void searchData() {
        String kataKunci = txtSearch.getText();

        DefaultTableModel model = (DefaultTableModel) tblData.getModel();
        model.setRowCount(0);

        try {
            String sql = "SELECT t.ID_Tiket, t.Tanggal_Pembuatan, t.Prioritas, k.Nama_Kategori, p.Nama_Pegawai, u.Nama_User, t.Status " +
                         "FROM tiket t " +
                         "INNER JOIN kategori k ON k.ID_Kategori = t.ID_Kategori " +
                         "INNER JOIN pegawaii p ON p.ID_Pegawai = t.ID_Pegawai " +
                         "INNER JOIN users u ON u.user_id = t.user_id " +
                         "WHERE t.ID_Tiket LIKE ? OR k.Nama_Kategori LIKE ? OR p.Nama_Pegawai LIKE ? OR u.Nama_User LIKE ?";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, "%" + kataKunci + "%");
                st.setString(2, "%" + kataKunci + "%");
                st.setString(3, "%" + kataKunci + "%");
                st.setString(4, "%" + kataKunci + "%");
                ResultSet rs = st.executeQuery();

                int no = 1;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                while (rs.next()) {
                    String idTiket = rs.getString("ID_Tiket");
                    String tanggalPembuatan = sdf.format(rs.getTimestamp("Tanggal_Pembuatan"));
                    String prioritas = rs.getString("Prioritas");
                    String namaKategori = rs.getString("Nama_Kategori");
                    String namaPegawai = rs.getString("Nama_Pegawai");
                    String namaUser = rs.getString("Nama_User");
                    String status = rs.getString("Status");

                    Object[] rowData = {"   " + no++, idTiket, tanggalPembuatan, prioritas, namaKategori, namaPegawai, namaUser, status};
                    model.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(TransaksiTiket.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
