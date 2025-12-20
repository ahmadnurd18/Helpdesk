package com.perpus.form;

import com.perpus.config.Koneksi;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class TransaksiTiket extends javax.swing.JPanel {

    private int halamanSaatIni = 1;
    private int dataPerHalaman = 14;
    private int totalPages;
    private final Connection conn;
    private final String currentUserID;
    private final String currentRole;
    private String selectedTiketID = null;
    private boolean isEditMode = false; // tambahan untuk kontrol state

    public TransaksiTiket(String userID, String role) {
        this.currentUserID = userID;
        this.currentRole = role;
        initComponents();
        conn = Koneksi.getConnection();
        setTabelModel();
        loadData();
        paginationUser();
        setColumnWidth();
        setLayoutForm();
        resetButtonState(); // pastikan tombol awal benar
    }

    private void setColumnWidth() {
        TableColumnModel columnModel = tblData.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(0).setMaxWidth(40);
        columnModel.getColumn(0).setMinWidth(40);
        columnModel.getColumn(9).setPreferredWidth(120); // kolom Petugas (indeks 9)
columnModel.getColumn(9).setMinWidth(100);
    }
    
    private void resetButtonState() {
        btnAdd.setText("TAMBAH");
        btnDelete.setVisible(false);
        btnCancel.setVisible(false);
        isEditMode = false;
    }
    

    private void setLayoutForm() {
        iconJudul.setIcon(new FlatSVGIcon("com/perpus/icon/ticket.svg", 1f));
        iconJudul2.setIcon(new FlatSVGIcon("com/perpus/icon/ticket.svg", 1f));
        iconDashboard.setIcon(new FlatSVGIcon("com/perpus/icon/dashboard.svg", 1f));
        iconDashboard2.setIcon(new FlatSVGIcon("com/perpus/icon/dashboard.svg", 1f));
        btnAdd.setIcon(new FlatSVGIcon("com/perpus/icon/add_white.svg", 1f));
        btnDelete.setIcon(new FlatSVGIcon("com/perpus/icon/delete_white.svg", 1f));
        btnCancel.setIcon(new FlatSVGIcon("com/perpus/icon/cancel_white.svg", 1f));
        btnSave.setIcon(new FlatSVGIcon("com/perpus/icon/save_white.svg", 1f));
        btnCancel2.setIcon(new FlatSVGIcon("com/perpus/icon/cancel_white.svg", 1f));
        btnDone.setIcon(new FlatSVGIcon("com/perpus/icon/check_white.svg", 1f));

        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON,
                new FlatSVGIcon("com/perpus/icon/search.svg", 0.80f));
        txtID.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        txtJudulTiket.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pencarian");
        txtID.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ID Tiket");
        txtJudulTiket.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Judul Tiket");

        cbxPrioritas.setForeground(new Color(153, 153, 153));
        cbxPrioritas.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                cbxPrioritas.setForeground(cbxPrioritas.getSelectedIndex() == 0
                        ? new Color(153, 153, 153) : Color.BLACK);
            }
        });
        cbxPrioritas.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                cbxPrioritas.setForeground(cbxPrioritas.getSelectedIndex() == 0
                        ? new Color(153, 153, 153) : Color.BLACK);
            }
        });
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        panelAdd = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        iconDashboard2 = new javax.swing.JLabel();
        iconJudul2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbPassword = new javax.swing.JLabel();
        cbxPrioritas = new javax.swing.JComboBox<>();
        txtID = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel2 = new javax.swing.JButton();
        txtJudulTiket = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtDesk = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        StartDate = new com.toedter.calendar.JDateChooser();
        lbPassword1 = new javax.swing.JLabel();
        EndDate = new com.toedter.calendar.JDateChooser();
        btnDone = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setPreferredSize(new java.awt.Dimension(1133, 690));
        panelMain.setLayout(new java.awt.CardLayout());

        panelView.setBackground(new java.awt.Color(255, 255, 255));
        panelView.setPreferredSize(new java.awt.Dimension(1133, 690));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Tiket Helpdesk");

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

        tblData.setMinimumSize(new java.awt.Dimension(60, 400));
        tblData.setPreferredSize(new java.awt.Dimension(300, 400));
        tblData.setRowHeight(40);
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        btnAdd.setText("TAMBAH");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("HAPUS");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCancel.setText("BATAL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 768, Short.MAX_VALUE)
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
                        .addGap(18, 18, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelMain.add(panelView, "card2");

        panelAdd.setBackground(new java.awt.Color(255, 255, 255));
        panelAdd.setPreferredSize(new java.awt.Dimension(1133, 690));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Buat Tiket");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Transaksi > Tiket");

        iconJudul2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        iconJudul2.setForeground(new java.awt.Color(102, 102, 102));
        iconJudul2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/perpus/icon/tiket.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("ID");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Judul");

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Deskripsi");

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Prioritas");

        lbPassword.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbPassword.setForeground(new java.awt.Color(102, 102, 102));
        lbPassword.setText("Start Date");

        cbxPrioritas.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cbxPrioritas.setForeground(new java.awt.Color(102, 102, 102));
        cbxPrioritas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Prioritas", "Low", "Medium", "High", "Very High" }));
        cbxPrioritas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPrioritasActionPerformed(evt);
            }
        });

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

        TxtDesk.setColumns(20);
        TxtDesk.setRows(5);
        jScrollPane2.setViewportView(TxtDesk);

        jLabel13.setFont(new java.awt.Font("SansSerif", 2, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Pilih prioritas sesuai kebutuhan anda. ");

        lbPassword1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbPassword1.setForeground(new java.awt.Color(102, 102, 102));
        lbPassword1.setText("End Date");

        btnDone.setText("DONE");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAddLayout = new javax.swing.GroupLayout(panelAdd);
        panelAdd.setLayout(panelAddLayout);
        panelAddLayout.setHorizontalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addComponent(cbxPrioritas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addComponent(txtID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAddLayout.createSequentialGroup()
                                .addComponent(iconJudul2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 810, Short.MAX_VALUE)
                                .addComponent(iconDashboard2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addComponent(txtJudulTiket, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAddLayout.createSequentialGroup()
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAddLayout.createSequentialGroup()
                                        .addComponent(lbPassword)
                                        .addGap(118, 118, 118)
                                        .addComponent(lbPassword1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAddLayout.createSequentialGroup()
                                        .addComponent(btnSave)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDone))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAddLayout.createSequentialGroup()
                                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13))
                                        .addGap(4, 4, 4)
                                        .addComponent(EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(btnCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtJudulTiket, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxPrioritas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        panelMain.add(panelAdd, "card2");

        add(panelMain, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
  panelMain.removeAll();
        panelMain.add(panelAdd);
        panelMain.repaint();
        panelMain.revalidate();

        resetForm();
        txtID.setText(generateTiketID());
        txtID.setEnabled(false);
        EndDate.setEnabled("admin".equals(currentRole));
        btnDone.setVisible(false);

        if (btnAdd.getText().equals("UBAH")) {
            int row = tblData.getSelectedRow();
            selectedTiketID = tblData.getValueAt(row, 1).toString();

            // Cek status tiket sebelum load
            String status = tblData.getValueAt(row, 7).toString();
            if (!"OPEN".equals(status) && !"admin".equals(currentRole)) {
                JOptionPane.showMessageDialog(this, "Tiket sudah diproses dan tidak dapat diubah oleh user!", 
                    "Akses Ditolak", JOptionPane.WARNING_MESSAGE);
                showPanel();
                return;
            }

            loadTiketToForm(selectedTiketID);

            if ("admin".equals(currentRole) && "ON PROGRESS".equals(status)) {
                btnDone.setVisible(true);
            }
            btnSave.setText("PERBARUI");
        } else {
            btnSave.setText("SIMPAN");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
   if (tblData.getSelectedRow() == -1) return;

        // Hanya ubah tombol jika belum dalam mode edit
        if (!isEditMode) {
            btnAdd.setText("UBAH");
            btnDelete.setVisible(true);
            btnCancel.setVisible(true);
            isEditMode = true;
        }
            
    }//GEN-LAST:event_tblDataMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        showPanel();
        resetButtonState();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
    int row = tblData.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih tiket yang akan dihapus!");
            return;
        }

        String status = tblData.getValueAt(row, 7).toString();
        if (!"OPEN".equals(status) && !"admin".equals(currentRole)) {
            JOptionPane.showMessageDialog(this, "Tiket sudah diproses dan tidak dapat dihapus oleh user!", 
                "Akses Ditolak", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
            "Yakin ingin menghapus tiket ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            deleteData();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        searchData();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnCancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel2ActionPerformed
        showPanel();
        resetButtonState();
    }//GEN-LAST:event_btnCancel2ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
   if (!isValidInput()) return;

        if (btnSave.getText().equals("SIMPAN")) {
            insertTiket();
        } else if (btnSave.getText().equals("PERBARUI")) {
            updateTiket();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cbxPrioritasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPrioritasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPrioritasActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
    if (!"admin".equals(currentRole)) {
            JOptionPane.showMessageDialog(this, "Hanya admin yang dapat menutup tiket!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
                "Apakah tiket ini sudah selesai?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            closeTiket();
        }
    }//GEN-LAST:event_btnDoneActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser EndDate;
    private com.toedter.calendar.JDateChooser StartDate;
    private javax.swing.JTextArea TxtDesk;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancel2;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btn_before;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JComboBox<String> cbxPrioritas;
    private javax.swing.JComboBox<String> cbx_data;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel iconDashboard;
    private javax.swing.JLabel iconDashboard2;
    private javax.swing.JLabel iconJudul;
    private javax.swing.JLabel iconJudul2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbPassword1;
    private javax.swing.JLabel lb_halaman;
    private javax.swing.JPanel panelAdd;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelView;
    private javax.swing.ButtonGroup rbJenisKelamin;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtJudulTiket;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

private void insertTiket() {
        try {
            String sql = "INSERT INTO tiket " +
                "(ID_Tiket, Judul_Tiket, Deskripsi_Tiket, Prioritas_Tiket, StartDate, EndDate, Status_Tiket, User_ID_User) " +
                "VALUES (?, ?, ?, ?, ?, NULL, 'OPEN', ?)";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, txtID.getText());
            st.setString(2, txtJudulTiket.getText());
            st.setString(3, TxtDesk.getText());
            st.setString(4, cbxPrioritas.getSelectedItem().toString());
            st.setDate(5, new java.sql.Date(StartDate.getDate().getTime()));
            st.setString(6, currentUserID);

            if (st.executeUpdate() > 0) {
                insertDetailTiket("OPEN");
                JOptionPane.showMessageDialog(this, "Tiket berhasil dibuat!");
                showPanel();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTiket() {
    try {
        String status = "OPEN";
        String pegawaiID = null;

        if ("admin".equals(currentRole)) {
            if (EndDate.getDate() != null) {
                status = "ON PROGRESS";
                pegawaiID = getCurrentPegawaiID(); // admin yang sedang login
            }
        }

        String sql = "UPDATE tiket SET " +
            "Judul_Tiket = ?, Deskripsi_Tiket = ?, Prioritas_Tiket = ?, " +
            "StartDate = ?, EndDate = ?, Status_Tiket = ?, Pegawai_ID_Pegawai = ? " +
            "WHERE ID_Tiket = ?";

        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, txtJudulTiket.getText());
        st.setString(2, TxtDesk.getText());
        st.setString(3, cbxPrioritas.getSelectedItem().toString());
        st.setDate(4, new java.sql.Date(StartDate.getDate().getTime()));
        st.setDate(5, EndDate.getDate() != null ? new java.sql.Date(EndDate.getDate().getTime()) : null);
        st.setString(6, status);
        st.setString(7, pegawaiID);
        st.setString(8, selectedTiketID);

        if (st.executeUpdate() > 0) {
            updateDetailTiket(status);
            JOptionPane.showMessageDialog(this, "Tiket diperbarui! Status: " + status);
            showPanel();
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void closeTiket() {
    try {
        String pegawaiID = getCurrentPegawaiID();

        String sql = "UPDATE tiket SET Status_Tiket = 'CLOSED', Pegawai_ID_Pegawai = COALESCE(Pegawai_ID_Pegawai, ?) " +
                     "WHERE ID_Tiket = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, pegawaiID);
        st.setString(2, selectedTiketID);

        if (st.executeUpdate() > 0) {
            updateDetailTiket("CLOSED");
            JOptionPane.showMessageDialog(this, "Tiket selesai!");
            showPanel();
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal: " + e.getMessage());
    }
}

    private void insertDetailTiket(String status) throws SQLException {
        String sql = "INSERT INTO detail_tiket (Tiket_ID_Tiket, Status_Tiket) VALUES (?, ?)";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, txtID.getText());
        st.setString(2, status);
        st.executeUpdate();
    }

    private void updateDetailTiket(String status) throws SQLException {
        String sql = "UPDATE detail_tiket SET Status_Tiket = ? WHERE Tiket_ID_Tiket = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, status);
        st.setString(2, selectedTiketID);
        st.executeUpdate();
    }

    private void loadTiketToForm(String tiketID) {
        try {
            String sql = "SELECT * FROM tiket WHERE ID_Tiket = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, tiketID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                txtID.setText(rs.getString("ID_Tiket"));
                txtJudulTiket.setText(rs.getString("Judul_Tiket"));
                TxtDesk.setText(rs.getString("Deskripsi_Tiket"));
                cbxPrioritas.setSelectedItem(rs.getString("Prioritas_Tiket"));
                StartDate.setDate(rs.getDate("StartDate"));
                EndDate.setDate(rs.getDate("EndDate"));
            }
        } catch (SQLException e) {
            Logger.getLogger(TransaksiTiket.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private String generateTiketID() {
        String urutan = null;
        Date now = new Date();
        SimpleDateFormat noFormat = new SimpleDateFormat("yyMM");
        String no = noFormat.format(now);
        String sql = "SELECT RIGHT(ID_Tiket, 3) AS Nomor FROM tiket WHERE ID_Tiket LIKE 'TKT" + no + "%' ORDER BY ID_Tiket DESC LIMIT 1";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor")) + 1;
                urutan = "TKT" + no + String.format("%03d", nomor);
            } else {
                urutan = "TKT" + no + "001";
            }
        } catch (SQLException e) {
      Logger.getLogger(TransaksiTiket.class.getName()).log(Level.SEVERE, null, e);
        }
        return urutan;
    }

    private boolean isValidInput() {
        if (txtJudulTiket.getText().trim().isEmpty() || TxtDesk.getText().trim().isEmpty() ||
            StartDate.getDate() == null || cbxPrioritas.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Lengkapi semua field!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private void updateButtonVisibility() {
        btnDone.setVisible("admin".equals(currentRole));
    }

    private String getCurrentUserRole() {
        return currentRole != null ? currentRole : "user";
    }

    private String getCurrentUserID() {
        return currentUserID != null ? currentUserID : "USR2511002";
    }

    private void setTabelModel() {
        DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(new Object[]{
        "No", "ID Tiket", "Judul", "Deskripsi", "Prioritas", "Start", "End", "Status", "User", "Petugas"
    });
    tblData.setModel(model);
    }

    private void loadData() {

        int totalData = getTotalData();
        lb_halaman.setText("Halaman " + halamanSaatIni + " dari " + totalData);
        int startIndex = (halamanSaatIni - 1) * dataPerHalaman;
        getData(startIndex, dataPerHalaman, (DefaultTableModel) tblData.getModel());
        btnDelete.setVisible(false);
        btnCancel.setVisible(false);
    }

   public void getData(int startIndex, int entriesPage, DefaultTableModel model) {
    model.setRowCount(0);
    try {
        String sql;
        PreparedStatement st;
        if ("admin".equals(currentRole)) {
            sql = "SELECT t.*, u.Nama_Full AS User_Name, p.Nama_Pegawai AS Petugas_Name " +
                  "FROM tiket t " +
                  "JOIN user u ON t.User_ID_User = u.ID_User " +
                  "LEFT JOIN pegawai p ON t.Pegawai_ID_Pegawai = p.ID_Pegawai " +
                  "ORDER BY t.StartDate DESC LIMIT ?, ?";
            st = conn.prepareStatement(sql);
            st.setInt(1, startIndex);
            st.setInt(2, entriesPage);
        } else {
            sql = "SELECT t.*, u.Nama_Full AS User_Name, p.Nama_Pegawai AS Petugas_Name " +
                  "FROM tiket t " +
                  "JOIN user u ON t.User_ID_User = u.ID_User " +
                  "LEFT JOIN pegawai p ON t.Pegawai_ID_Pegawai = p.ID_Pegawai " +
                  "WHERE t.User_ID_User = ? " +
                  "ORDER BY t.StartDate DESC LIMIT ?, ?";
            st = conn.prepareStatement(sql);
            st.setString(1, currentUserID);
            st.setInt(2, startIndex);
            st.setInt(3, entriesPage);
        }

        ResultSet rs = st.executeQuery();
        int no = startIndex + 1;
        while (rs.next()) {
            String status = rs.getString("Status_Tiket");
            if (status == null) status = "OPEN";

            String petugas = rs.getString("Petugas_Name");
            if (petugas == null || status.equals("OPEN")) {
                petugas = "-"; // atau "" jika ingin kosong
            }

            model.addRow(new Object[]{
                no++,
                rs.getString("ID_Tiket"),
                rs.getString("Judul_Tiket"),
                rs.getString("Deskripsi_Tiket"),
                rs.getString("Prioritas_Tiket"),
                rs.getDate("StartDate"),
                rs.getDate("EndDate"),
                status,
                rs.getString("User_Name"),
                petugas
            });
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error load data: " + e.getMessage());
    }
}

   private int getTotalData() {
        int total = 0;
        try {
            String sql;
            if ("admin".equals(currentRole)) {
                sql = "SELECT COUNT(*) FROM tiket";
            } else {
                sql = "SELECT COUNT(*) FROM tiket WHERE User_ID_User = ?";
            }
            PreparedStatement st = conn.prepareStatement(sql);
            if (!"admin".equals(currentRole)) {
                st.setString(1, currentUserID);
            }
            ResultSet rs = st.executeQuery();
            if (rs.next()) total = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    private void paginationUser() {
        btn_first.addActionListener(e -> { halamanSaatIni = 1; loadData(); });
        btn_before.addActionListener(e -> { if (halamanSaatIni > 1) { halamanSaatIni--; loadData(); } });
        cbx_data.addActionListener(e -> { dataPerHalaman = Integer.parseInt(cbx_data.getSelectedItem().toString()); halamanSaatIni = 1; loadData(); });
        btn_next.addActionListener(e -> { if (halamanSaatIni < totalPages) { halamanSaatIni++; loadData(); } });
        btn_last.addActionListener(e -> { halamanSaatIni = totalPages; loadData(); });
    }

    private void showPanel() {
       panelMain.removeAll();
        panelMain.add(panelView);
        panelMain.repaint();
        panelMain.revalidate();
        loadData();
        resetButtonState(); 
    }

    private void resetForm() {
        txtID.setText("");
        txtJudulTiket.setText("");
        TxtDesk.setText("");
        cbxPrioritas.setSelectedIndex(0);
        StartDate.setDate(null);
        EndDate.setDate(null);
        selectedTiketID = null;
    }

    private void deleteData() {
        int row = tblData.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih tiket yang akan dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
            "Apakah Anda yakini ingin menghapus tiket ini?",
            "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String id = tblData.getValueAt(row, 1).toString();
            try {
                conn.setAutoCommit(false);
                String sql1 = "DELETE FROM detail_tiket WHERE Tiket_ID_Tiket = ?";
                try (PreparedStatement ps1 = conn.prepareStatement(sql1)) {
                    ps1.setString(1, id);
                    ps1.executeUpdate();
                }
                String sql2 = "DELETE FROM tiket WHERE ID_Tiket = ?";
                try (PreparedStatement ps2 = conn.prepareStatement(sql2)) {
                    ps2.setString(1, id);
                    ps2.executeUpdate();
                }
                conn.commit();
                JOptionPane.showMessageDialog(this, "Tiket dihapus!");
                loadData();
            } catch (SQLException e) {
                try { conn.rollback(); } catch (SQLException ex) { }
                JOptionPane.showMessageDialog(this, "Gagal menghapus tiket: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try { conn.setAutoCommit(true); } catch (SQLException ex) { }
            }
        }
    }

   private void searchData() {
    String keyword = txtSearch.getText().trim();
    DefaultTableModel model = (DefaultTableModel) tblData.getModel();
    model.setRowCount(0);
    try {
        String sql;
        PreparedStatement st;

        if ("admin".equals(currentRole)) {
            sql = "SELECT t.*, u.Nama_Full AS User_Name, p.Nama_Pegawai AS Petugas_Name " +
                  "FROM tiket t " +
                  "JOIN user u ON t.User_ID_User = u.ID_User " +
                  "LEFT JOIN pegawai p ON t.Pegawai_ID_Pegawai = p.ID_Pegawai " +
                  "WHERE t.ID_Tiket LIKE ? OR t.Judul_Tiket LIKE ? " +
                  "OR u.Nama_Full LIKE ? OR p.Nama_Pegawai LIKE ?";
            st = conn.prepareStatement(sql);
            String like = "%" + keyword + "%";
            st.setString(1, like);
            st.setString(2, like);
            st.setString(3, like);
            st.setString(4, like);
        } else {
            sql = "SELECT t.*, u.Nama_Full AS User_Name, p.Nama_Pegawai AS Petugas_Name " +
                  "FROM tiket t " +
                  "JOIN user u ON t.User_ID_User = u.ID_User " +
                  "LEFT JOIN pegawai p ON t.Pegawai_ID_Pegawai = p.ID_Pegawai " +
                  "WHERE t.User_ID_User = ? AND (t.ID_Tiket LIKE ? OR t.Judul_Tiket LIKE ?)";
            st = conn.prepareStatement(sql);
            st.setString(1, currentUserID);
            st.setString(2, "%" + keyword + "%");
            st.setString(3, "%" + keyword + "%");
        }

        ResultSet rs = st.executeQuery();
        int no = 1;
        while (rs.next()) {
            String status = rs.getString("Status_Tiket");
            if (status == null) status = "OPEN";

            String petugas = rs.getString("Petugas_Name");
            if (petugas == null || status.equals("OPEN")) petugas = "-";

            model.addRow(new Object[]{
                no++,
                rs.getString("ID_Tiket"),
                rs.getString("Judul_Tiket"),
                rs.getString("Deskripsi_Tiket"),
                rs.getString("Prioritas_Tiket"),
                rs.getDate("StartDate"),
                rs.getDate("EndDate"),
                status,
                rs.getString("User_Name"),
                petugas
            });
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
   
   private String getCurrentPegawaiID() {
    String pegawaiID = null;
    try {
        String sql = "SELECT Pegawai_ID_Pegawai FROM user WHERE ID_User = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, currentUserID);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            pegawaiID = rs.getString("Pegawai_ID_Pegawai");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return pegawaiID;
}
}