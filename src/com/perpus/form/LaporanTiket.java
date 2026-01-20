package com.perpus.form;

import com.perpus.config.Koneksi;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
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

public class LaporanTiket extends javax.swing.JPanel {
    private int halamanSaatIni = 1;
    private int dataPerHalaman = 14;
    private int totalPages;
    private final Connection conn;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Date tanggalMulai;
    private Date tanggalAkhir;

    private final String userID;   // ID user yang login
    private final String userRole; // "admin" atau "user"

    public LaporanTiket(String userID, String userRole) {
        initComponents();
        conn = Koneksi.getConnection();
        this.userID = userID;
        this.userRole = userRole != null ? userRole.toLowerCase() : "user";

        setTabelModel();
        loadData(); // otomatis load saat buka form
        paginationTiket();
        actionButton();
        setColumnWidth();
        setLayoutForm();
    }

    private void setColumnWidth() {
        TableColumnModel columnModel = tblData.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(0).setMaxWidth(40);
        columnModel.getColumn(0).setMinWidth(40);
    }

    private void setLayoutForm() {
        iconJudul.setIcon(new FlatSVGIcon("com/perpus/icon/ticket.svg", 1f));
        iconDashboard.setIcon(new FlatSVGIcon("com/perpus/icon/dashboard.svg", 1f));
        btnTampilkan.setIcon(new FlatSVGIcon("com/perpus/icon/display.svg", 1f));
        btnCancel.setIcon(new FlatSVGIcon("com/perpus/icon/cancel_white.svg", 1f));
        btnPrint.setIcon(new FlatSVGIcon("com/perpus/icon/print_white.svg", 1f));

        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Cari ID / Judul / User");
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON,
                new FlatSVGIcon("com/perpus/icon/search.svg", 0.80f));
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
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        txtTanggalMulai = new javax.swing.JTextField();
        txtTanggalAkhir = new javax.swing.JTextField();
        btnTampilkan = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        dateChooser1.setTextRefernce(txtTanggalMulai);

        dateChooser2.setTextRefernce(txtTanggalAkhir);

        setLayout(new java.awt.CardLayout());

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setPreferredSize(new java.awt.Dimension(1133, 690));
        panelMain.setLayout(new java.awt.CardLayout());

        panelView.setBackground(new java.awt.Color(255, 255, 255));
        panelView.setPreferredSize(new java.awt.Dimension(1133, 690));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Laporan Tiket Helpdesk");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Laporan > Tiket");

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

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Tanggal Mulai");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Tanggal Sampai");

        btnTampilkan.setText("TAMPILKAN");
        btnTampilkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTampilkanActionPerformed(evt);
            }
        });

        btnCancel.setText("BATAL");

        btnPrint.setText("PRINT");

        tblData.setRowHeight(40);
        jScrollPane1.setViewportView(tblData);

        javax.swing.GroupLayout panelViewLayout = new javax.swing.GroupLayout(panelView);
        panelView.setLayout(panelViewLayout);
        panelViewLayout.setHorizontalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addComponent(iconJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelViewLayout.createSequentialGroup()
                        .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txtTanggalMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelViewLayout.createSequentialGroup()
                                .addComponent(txtTanggalAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTampilkan)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel)
                                .addGap(18, 18, 18)
                                .addComponent(btnPrint)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelViewLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(0, 798, Short.MAX_VALUE)))))
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
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTanggalMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTanggalAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTampilkan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelMain.add(panelView, "card2");

        add(panelMain, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnTampilkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTampilkanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTampilkanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnTampilkan;
    private javax.swing.JButton btn_before;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JComboBox<String> cbx_data;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JLabel iconDashboard;
    private javax.swing.JLabel iconJudul;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_halaman;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelView;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTanggalAkhir;
    private javax.swing.JTextField txtTanggalMulai;
    // End of variables declaration//GEN-END:variables

    // Button Halaman
    private void paginationTiket() {
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

    private void actionButton() {
        btnTampilkan.addActionListener(e -> loadData());
        btnCancel.addActionListener(e -> clearForm());
        btnPrint.addActionListener(e -> cetakLaporan());

        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                searchData();
            }
        });
    }

    private void clearForm() {
        txtTanggalMulai.setText("");
        txtTanggalAkhir.setText("");
        txtSearch.setText("");
        loadData();
    }

    private boolean validasiTanggal() {
        String mulai = txtTanggalMulai.getText().trim();
        String akhir = txtTanggalAkhir.getText().trim();

        if (mulai.isEmpty() || akhir.isEmpty()) {
            tanggalMulai = null;
            tanggalAkhir = null;
            return true; // jika kosong → tampilkan semua (sesuai role)
        }

        try {
            tanggalMulai = dateFormat.parse(mulai);
            tanggalAkhir = dateFormat.parse(akhir);
            if (tanggalMulai.after(tanggalAkhir)) {
                JOptionPane.showMessageDialog(this, "Tanggal mulai tidak boleh lebih besar dari tanggal akhir!", "Validasi", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Format tanggal salah (yyyy-MM-dd)", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private int getTotalData() {
        if (!validasiTanggal()) return 0;

        String sql = "admin".equals(userRole)
                ? "SELECT COUNT(*) FROM tiket WHERE (? IS NULL OR StartDate >= ?) AND (? IS NULL OR StartDate <= ?)"
                : "SELECT COUNT(*) FROM tiket WHERE User_ID_User = ? AND (? IS NULL OR StartDate >= ?) AND (? IS NULL OR StartDate <= ?)";

        try (PreparedStatement st = conn.prepareStatement(sql)) {
            int idx = 1;
            if (!"admin".equals(userRole)) st.setString(idx++, userID);
            st.setDate(idx++, tanggalMulai == null ? null : new java.sql.Date(tanggalMulai.getTime()));
            st.setDate(idx++, tanggalMulai == null ? null : new java.sql.Date(tanggalMulai.getTime()));
            st.setDate(idx++, tanggalAkhir == null ? null : new java.sql.Date(tanggalAkhir.getTime()));
            st.setDate(idx++, tanggalAkhir == null ? null : new java.sql.Date(tanggalAkhir.getTime()));

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) return rs.getInt(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(LaporanTiket.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    private void calculateTotalPages() {
        int totalData = getTotalData();
        totalPages = (int) Math.ceil((double) totalData / dataPerHalaman);
        if (totalPages < 1) totalPages = 1;
    }

    private void loadData() {
        if (!validasiTanggal()) return;
        calculateTotalPages();
        int start = (halamanSaatIni - 1) * dataPerHalaman;

        DefaultTableModel model = (DefaultTableModel) tblData.getModel();
        model.setRowCount(0);

        String sql = "admin".equals(userRole)
                ? "SELECT t.ID_Tiket, t.Judul_Tiket, t.Deskripsi_Tiket, t.Prioritas_Tiket, "
                + "t.StartDate, t.EndDate, t.Status_Tiket, u.Nama_Full AS Nama_User, "
                + "p.Nama_Pegawai AS Nama_Pegawai "
                + "FROM tiket t "
                + "JOIN user u ON t.User_ID_User = u.ID_User "
                + "LEFT JOIN pegawai p ON t.Pegawai_ID_Pegawai = p.ID_Pegawai "
                + "WHERE (? IS NULL OR t.StartDate >= ?) AND (? IS NULL OR t.StartDate <= ?) "
                + "ORDER BY t.StartDate DESC LIMIT ?, ?"
                : "SELECT t.ID_Tiket, t.Judul_Tiket, t.Deskripsi_Tiket, t.Prioritas_Tiket, "
                + "t.StartDate, t.EndDate, t.Status_Tiket, u.Nama_Full AS Nama_User, "
                + "p.Nama_Pegawai AS Nama_Pegawai "
                + "FROM tiket t "
                + "JOIN user u ON t.User_ID_User = u.ID_User "
                + "LEFT JOIN pegawai p ON t.Pegawai_ID_Pegawai = p.ID_Pegawai "
                + "WHERE t.User_ID_User = ? AND (? IS NULL OR t.StartDate >= ?) AND (? IS NULL OR t.StartDate <= ?) "
                + "ORDER BY t.StartDate DESC LIMIT ?, ?";

        try (PreparedStatement st = conn.prepareStatement(sql)) {
            int idx = 1;
            if (!"admin".equals(userRole)) st.setString(idx++, userID);
            st.setDate(idx++, tanggalMulai == null ? null : new java.sql.Date(tanggalMulai.getTime()));
            st.setDate(idx++, tanggalMulai == null ? null : new java.sql.Date(tanggalMulai.getTime()));
            st.setDate(idx++, tanggalAkhir == null ? null : new java.sql.Date(tanggalAkhir.getTime()));
            st.setDate(idx++, tanggalAkhir == null ? null : new java.sql.Date(tanggalAkhir.getTime()));
            st.setInt(idx++, start);
            st.setInt(idx++, dataPerHalaman);

            try (ResultSet rs = st.executeQuery()) {
                int no = start + 1;
                while (rs.next()) {
                    model.addRow(new Object[]{
                        no++,
                        rs.getString("ID_Tiket"),
                        rs.getString("Judul_Tiket"),
                        rs.getString("Deskripsi_Tiket"),
                        rs.getString("Prioritas_Tiket"),
                        rs.getDate("StartDate") != null ? new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("StartDate")) : "-",
                        rs.getDate("EndDate") != null ? new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("EndDate")) : "-",
                        rs.getString("Status_Tiket"),
                        rs.getString("Nama_User"),
                        rs.getString("Nama_Pegawai") != null ? rs.getString("Nama_Pegawai") : "-"
                    });
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        lb_halaman.setText("Halaman " + halamanSaatIni + " dari " + totalPages);
    }

    private void searchData() {
        if (!validasiTanggal()) return;
        String keyword = "%" + txtSearch.getText().trim() + "%";

        DefaultTableModel model = (DefaultTableModel) tblData.getModel();
        model.setRowCount(0);

        String sql = "admin".equals(userRole)
                ? "SELECT t.ID_Tiket, t.Judul_Tiket, t.Deskripsi_Tiket, t.Prioritas_Tiket, "
                + "t.StartDate, t.EndDate, t.Status_Tiket, u.Nama_Full AS Nama_User, "
                + "p.Nama_Pegawai AS Nama_Pegawai "
                + "FROM tiket t "
                + "JOIN user u ON t.User_ID_User = u.ID_User "
                + "LEFT JOIN pegawai p ON t.Pegawai_ID_Pegawai = p.ID_Pegawai "
                + "WHERE (? IS NULL OR t.StartDate >= ?) AND (? IS NULL OR t.StartDate <= ?) "
                + "AND (t.ID_Tiket LIKE ? OR t.Judul_Tiket LIKE ? OR u.Nama_Full LIKE ?) "
                + "ORDER BY t.StartDate DESC"
                : "SELECT t.ID_Tiket, t.Judul_Tiket, t.Deskripsi_Tiket, t.Prioritas_Tiket, "
                + "t.StartDate, t.EndDate, t.Status_Tiket, u.Nama_Full AS Nama_User, "
                + "p.Nama_Pegawai AS Nama_Pegawai "
                + "FROM tiket t "
                + "JOIN user u ON t.User_ID_User = u.ID_User "
                + "LEFT JOIN pegawai p ON t.Pegawai_ID_Pegawai = p.ID_Pegawai "
                + "WHERE t.User_ID_User = ? AND (? IS NULL OR t.StartDate >= ?) AND (? IS NULL OR t.StartDate <= ?) "
                + "AND (t.ID_Tiket LIKE ? OR t.Judul_Tiket LIKE ? OR u.Nama_Full LIKE ?) "
                + "ORDER BY t.StartDate DESC";

        try (PreparedStatement st = conn.prepareStatement(sql)) {
            int idx = 1;
            if (!"admin".equals(userRole)) st.setString(idx++, userID);
            st.setDate(idx++, tanggalMulai == null ? null : new java.sql.Date(tanggalMulai.getTime()));
            st.setDate(idx++, tanggalMulai == null ? null : new java.sql.Date(tanggalMulai.getTime()));
            st.setDate(idx++, tanggalAkhir == null ? null : new java.sql.Date(tanggalAkhir.getTime()));
            st.setDate(idx++, tanggalAkhir == null ? null : new java.sql.Date(tanggalAkhir.getTime()));
            st.setString(idx++, keyword);
            st.setString(idx++, keyword);
            st.setString(idx++, keyword);

            try (ResultSet rs = st.executeQuery()) {
                int no = 1;
                while (rs.next()) {
                    model.addRow(new Object[]{
                        no++,
                        rs.getString("ID_Tiket"),
                        rs.getString("Judul_Tiket"),
                        rs.getString("Deskripsi_Tiket"),
                        rs.getString("Prioritas_Tiket"),
                        rs.getDate("StartDate") != null ? new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("StartDate")) : "-",
                        rs.getDate("EndDate") != null ? new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("EndDate")) : "-",
                        rs.getString("Status_Tiket"),
                        rs.getString("Nama_User"),
                        rs.getString("Nama_Pegawai") != null ? rs.getString("Nama_Pegawai") : "-"
                    });
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setTabelModel() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("No");
        model.addColumn("ID Tiket");
        model.addColumn("Judul Tiket");
        model.addColumn("Deskripsi");
        model.addColumn("Prioritas");
        model.addColumn("Start Date");
        model.addColumn("End Date");
        model.addColumn("Status");
        model.addColumn("User");
        model.addColumn("Petugas");
        tblData.setModel(model);
    }

    private void cetakLaporan() {
  if (!validasiTanggal()) {
        JOptionPane.showMessageDialog(this, "Filter tanggal tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        String reportPath = "src/com/perpus/reports/LaporanTiket.jasper"; // sesuaikan path kalau beda

        HashMap<String, Object> parameters = new HashMap<>();

        // Filter user: null = admin (lihat semua), String = user (lihat sendiri)
        parameters.put("userID", "admin".equalsIgnoreCase(userRole) ? null : userID);

        // Tanggal: null = tidak filter
        parameters.put("tanggalMulai", tanggalMulai == null ? null : new java.sql.Date(tanggalMulai.getTime()));
        parameters.put("tanggalAkhir", tanggalAkhir == null ? null : new java.sql.Date(tanggalAkhir.getTime()));

        // Text periode untuk header (tampil rapi kalau kosong)
        String periode = (tanggalMulai == null && tanggalAkhir == null) ? "Semua Tanggal" :
                         (tanggalMulai == null ? "s.d. " + dateFormat.format(tanggalAkhir) :
                          tanggalAkhir == null ? dateFormat.format(tanggalMulai) + " s.d. Sekarang" :
                          dateFormat.format(tanggalMulai) + " s.d. " + dateFormat.format(tanggalAkhir));
        parameters.put("periodeText", periode);

        JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
        JasperViewer viewer = new JasperViewer(print, false);
        viewer.setTitle("Laporan Tiket Helpdesk - PT. Macro Trend Technology");
        viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
        viewer.setVisible(true);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal cetak laporan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }}


