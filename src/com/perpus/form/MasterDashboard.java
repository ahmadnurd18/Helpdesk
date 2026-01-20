package com.perpus.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.perpus.config.Koneksi;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class MasterDashboard extends javax.swing.JPanel {

    private Connection conn;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private final String userID;
    private final String userRole; // "admin" atau "user"

    private static final Color ENABLED_COLOR = new Color(0, 153, 153);
    private static final Color DISABLED_COLOR = new Color(150, 150, 150);
    private static final Color HOVER_COLOR = new Color(0, 180, 180);

    public MasterDashboard(String userID, String userRole) {
        initComponents();
        conn = Koneksi.getConnection();

        this.userID = userID;
        this.userRole = userRole != null ? userRole.toLowerCase() : "user";

        loadData(); // update jumlah di card
        setupCards(); // klik + hak akses + hover
        showRiwayatTiket(); // default tampil tiket
        setLayoutForm();
        setColumnWidth();
    }

    private void setColumnWidth() {
        TableColumnModel columnModel = tblData.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(0).setMaxWidth(40);
        columnModel.getColumn(0).setMinWidth(40);
    }

    private void setLayoutForm() {
        cardPegawai.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
        cardPerangkat.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
        cardPeminjaman.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
        cardTiket.putClientProperty(FlatClientProperties.STYLE, "arc: 20");

        iconDashboard.setIcon(new FlatSVGIcon("com/perpus/icon/dashboard.svg", 1f));
        iconPegawai.setIcon(new FlatSVGIcon("com/perpus/icon/anggota_white.svg", 2f));
        iconPerangkat.setIcon(new FlatSVGIcon("com/perpus/icon/device-white.svg", 2f));
        iconPeminjaman.setIcon(new FlatSVGIcon("com/perpus/icon/peminjaman_white.svg", 2f));
        iconTiket.setIcon(new FlatSVGIcon("com/perpus/icon/ticket_white.svg", 2f));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        riwayat = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        iconDashboard = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        cardPegawai = new javax.swing.JPanel();
        iconPegawai = new javax.swing.JLabel();
        lbJumlahPegawai = new javax.swing.JLabel();
        lb_anggota = new javax.swing.JLabel();
        cardPerangkat = new javax.swing.JPanel();
        lbJumlahPerangkat = new javax.swing.JLabel();
        lb_anggota1 = new javax.swing.JLabel();
        iconPerangkat = new javax.swing.JLabel();
        cardPeminjaman = new javax.swing.JPanel();
        lbJumlahPeminjaman = new javax.swing.JLabel();
        lb_anggota5 = new javax.swing.JLabel();
        iconPeminjaman = new javax.swing.JLabel();
        cardTiket = new javax.swing.JPanel();
        lbJumlahTiket = new javax.swing.JLabel();
        lb_anggota3 = new javax.swing.JLabel();
        iconTiket = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1133, 690));

        riwayat.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        riwayat.setForeground(new java.awt.Color(102, 102, 102));
        riwayat.setText("Lorem Ipsum");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Master Data > Dashboard");

        tblData.setGridColor(new java.awt.Color(255, 255, 255));
        tblData.setRowHeight(40);
        tblData.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(tblData);

        cardPegawai.setBackground(new java.awt.Color(0, 153, 153));

        iconPegawai.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        iconPegawai.setForeground(new java.awt.Color(0, 102, 153));

        lbJumlahPegawai.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lbJumlahPegawai.setForeground(new java.awt.Color(255, 255, 255));
        lbJumlahPegawai.setText("999");

        lb_anggota.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lb_anggota.setForeground(new java.awt.Color(204, 204, 204));
        lb_anggota.setText("PEGAWAI");

        javax.swing.GroupLayout cardPegawaiLayout = new javax.swing.GroupLayout(cardPegawai);
        cardPegawai.setLayout(cardPegawaiLayout);
        cardPegawaiLayout.setHorizontalGroup(
            cardPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPegawaiLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(cardPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbJumlahPegawai)
                    .addComponent(lb_anggota))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(iconPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        cardPegawaiLayout.setVerticalGroup(
            cardPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPegawaiLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(cardPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cardPegawaiLayout.createSequentialGroup()
                        .addComponent(lb_anggota)
                        .addGap(20, 20, 20)
                        .addComponent(lbJumlahPegawai)))
                .addGap(20, 20, 20))
        );

        cardPerangkat.setBackground(new java.awt.Color(0, 153, 153));

        lbJumlahPerangkat.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lbJumlahPerangkat.setForeground(new java.awt.Color(255, 255, 255));
        lbJumlahPerangkat.setText("999");

        lb_anggota1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lb_anggota1.setForeground(new java.awt.Color(204, 204, 204));
        lb_anggota1.setText("PERANGKAT");

        iconPerangkat.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        iconPerangkat.setForeground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout cardPerangkatLayout = new javax.swing.GroupLayout(cardPerangkat);
        cardPerangkat.setLayout(cardPerangkatLayout);
        cardPerangkatLayout.setHorizontalGroup(
            cardPerangkatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPerangkatLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(cardPerangkatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbJumlahPerangkat)
                    .addComponent(lb_anggota1))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(iconPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        cardPerangkatLayout.setVerticalGroup(
            cardPerangkatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPerangkatLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(cardPerangkatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cardPerangkatLayout.createSequentialGroup()
                        .addComponent(lb_anggota1)
                        .addGap(20, 20, 20)
                        .addComponent(lbJumlahPerangkat)))
                .addGap(20, 20, 20))
        );

        cardPeminjaman.setBackground(new java.awt.Color(0, 153, 153));

        lbJumlahPeminjaman.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lbJumlahPeminjaman.setForeground(new java.awt.Color(255, 255, 255));
        lbJumlahPeminjaman.setText("999");

        lb_anggota5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lb_anggota5.setForeground(new java.awt.Color(204, 204, 204));
        lb_anggota5.setText("PEMINJAMAN");

        iconPeminjaman.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        iconPeminjaman.setForeground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout cardPeminjamanLayout = new javax.swing.GroupLayout(cardPeminjaman);
        cardPeminjaman.setLayout(cardPeminjamanLayout);
        cardPeminjamanLayout.setHorizontalGroup(
            cardPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPeminjamanLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(cardPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbJumlahPeminjaman)
                    .addComponent(lb_anggota5))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(iconPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        cardPeminjamanLayout.setVerticalGroup(
            cardPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPeminjamanLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(cardPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cardPeminjamanLayout.createSequentialGroup()
                        .addComponent(lb_anggota5)
                        .addGap(20, 20, 20)
                        .addComponent(lbJumlahPeminjaman)))
                .addGap(20, 20, 20))
        );

        cardTiket.setBackground(new java.awt.Color(0, 153, 153));

        lbJumlahTiket.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lbJumlahTiket.setForeground(new java.awt.Color(255, 255, 255));
        lbJumlahTiket.setText("999");

        lb_anggota3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lb_anggota3.setForeground(new java.awt.Color(204, 204, 204));
        lb_anggota3.setText("TIKET");

        iconTiket.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        iconTiket.setForeground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout cardTiketLayout = new javax.swing.GroupLayout(cardTiket);
        cardTiket.setLayout(cardTiketLayout);
        cardTiketLayout.setHorizontalGroup(
            cardTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardTiketLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(cardTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbJumlahTiket)
                    .addComponent(lb_anggota3))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(iconTiket, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        cardTiketLayout.setVerticalGroup(
            cardTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardTiketLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(cardTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconTiket, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cardTiketLayout.createSequentialGroup()
                        .addComponent(lb_anggota3)
                        .addGap(20, 20, 20)
                        .addComponent(lbJumlahTiket)))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(riwayat)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cardPegawai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(48, 48, 48)
                                .addComponent(cardPerangkat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(48, 48, 48)
                                .addComponent(cardPeminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50, 50, 50)
                                .addComponent(cardTiket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cardPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cardPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cardPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cardTiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(riwayat)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2)
                .addGap(10, 10, 10))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardPegawai;
    private javax.swing.JPanel cardPeminjaman;
    private javax.swing.JPanel cardPerangkat;
    private javax.swing.JPanel cardTiket;
    private javax.swing.JLabel iconDashboard;
    private javax.swing.JLabel iconPegawai;
    private javax.swing.JLabel iconPeminjaman;
    private javax.swing.JLabel iconPerangkat;
    private javax.swing.JLabel iconTiket;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbJumlahPegawai;
    private javax.swing.JLabel lbJumlahPeminjaman;
    private javax.swing.JLabel lbJumlahPerangkat;
    private javax.swing.JLabel lbJumlahTiket;
    private javax.swing.JLabel lb_anggota;
    private javax.swing.JLabel lb_anggota1;
    private javax.swing.JLabel lb_anggota3;
    private javax.swing.JLabel lb_anggota5;
    private javax.swing.JLabel riwayat;
    private javax.swing.JTable tblData;
    // End of variables declaration//GEN-END:variables

 private void setupCards() {
        boolean isAdmin = "admin".equals(userRole);

        // Card Pegawai - Admin only
        setupCard(cardPegawai, isAdmin, () -> showTabelPegawai());

        // Card Perangkat - Admin only
        setupCard(cardPerangkat, isAdmin, () -> showTabelPerangkat());

        // Card Peminjaman - semua role
        setupCard(cardPeminjaman, true, () -> showRiwayatPeminjaman());

        // Card Tiket - semua role
        setupCard(cardTiket, true, () -> showRiwayatTiket());
    }

    private void setupCard(javax.swing.JPanel card, boolean enabled, Runnable action) {
        if (enabled) {
            card.setBackground(ENABLED_COLOR);
            card.setCursor(new Cursor(Cursor.HAND_CURSOR));

            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    action.run();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    card.setBackground(HOVER_COLOR);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    card.setBackground(ENABLED_COLOR);
                }
            });
        } else {
            card.setBackground(DISABLED_COLOR);
            card.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }

    private int jumlahPegawai() {
        int total = 0;
        try (PreparedStatement st = conn.prepareStatement("SELECT COUNT(*) FROM pegawai");
             ResultSet rs = st.executeQuery()) {
            if (rs.next()) total = rs.getInt(1);
        } catch (SQLException e) { e.printStackTrace(); }
        return total;
    }

    private int jumlahPerangkat() {
        int total = 0;
        try (PreparedStatement st = conn.prepareStatement("SELECT COUNT(*) FROM perangkat");
             ResultSet rs = st.executeQuery()) {
            if (rs.next()) total = rs.getInt(1);
        } catch (SQLException e) { e.printStackTrace(); }
        return total;
    }

    private int jumlahPeminjamanAktif() {
        int total = 0;
        try (PreparedStatement st = conn.prepareStatement("SELECT COUNT(*) FROM peminjaman WHERE Status_Peminjaman = 'Dipinjam'");
             ResultSet rs = st.executeQuery()) {
            if (rs.next()) total = rs.getInt(1);
        } catch (SQLException e) { e.printStackTrace(); }
        return total;
    }

    private int jumlahTiket() {
        int total = 0;
        try (PreparedStatement st = conn.prepareStatement("SELECT COUNT(*) FROM tiket");
             ResultSet rs = st.executeQuery()) {
            if (rs.next()) total = rs.getInt(1);
        } catch (SQLException e) { e.printStackTrace(); }
        return total;
    }

    private void loadData() {
        lbJumlahPegawai.setText(String.valueOf(jumlahPegawai()));
        lbJumlahPerangkat.setText(String.valueOf(jumlahPerangkat()));
        lbJumlahPeminjaman.setText(String.valueOf(jumlahPeminjamanAktif()));
        lbJumlahTiket.setText(String.valueOf(jumlahTiket()));
    }

    // === TAMPIL TABEL BERDASARKAN KLIK CARD ===

    private void showTabelPegawai() {
       riwayat.setText("Pegawai");
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) { return false; }
    };
    model.addColumn("No");
    model.addColumn("ID Pegawai");
    model.addColumn("Nama");
    model.addColumn("Email");
    model.addColumn("Telepon");
    model.addColumn("Jenis Kelamin");
    model.addColumn("Tanggal Bergabung");
    tblData.setModel(model);

    String sql = "SELECT ID_Pegawai, Nama_Pegawai, Email, Telepon, Jenis_Kelamin, Tanggal_Bergabung FROM pegawai ORDER BY ID_Pegawai";
    fillTable(sql, model, null);
    }

    private void showTabelPerangkat() {
       riwayat.setText("Perangkat");

    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) { return false; }
    };
    model.addColumn("No");
    model.addColumn("ID Perangkat");
    model.addColumn("Jenis");
    model.addColumn("Merek");
    model.addColumn("No Serial");
    model.addColumn("Model");
    model.addColumn("Status");
    tblData.setModel(model);

    // QUERY LANGSUNG + PASTIKAN ADA DATA
    String sql = "SELECT ID_Perangkat, Jenis_Perangkat, Merek, No_Serial, Model_Perangkat, status "
               + "FROM perangkat ORDER BY ID_Perangkat ASC";

    fillTable(sql, model, null);
    }

    private void showRiwayatPeminjaman() {
       riwayat.setText("Riwayat Peminjaman Detail");

    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) { return false; }
    };
    model.addColumn("No");
    model.addColumn("ID Peminjaman");
    model.addColumn("Tanggal Pinjam");
    model.addColumn("Tanggal Kembali");
    model.addColumn("Status");
    model.addColumn("Nama Pegawai");
    model.addColumn("User");
    model.addColumn("ID Perangkat");
    model.addColumn("Jenis");
    model.addColumn("Merek");
    model.addColumn("No Serial");
    model.addColumn("Model");
    tblData.setModel(model);

    String sql = "admin".equals(userRole)
            ? "SELECT p.ID_Peminjaman, p.Tanggal_Peminjaman, p.Tanggal_Pengembalian, p.Status_Peminjaman, "
            + "pg.Nama_Pegawai, u.Nama_Full AS Nama_User, "
            + "pr.ID_Perangkat, pr.Jenis_Perangkat, pr.Merek, pr.No_Serial, pr.Model_Perangkat "
            + "FROM peminjaman p "
            + "JOIN pegawai pg ON p.Pegawai_ID_Pegawai = pg.ID_Pegawai "
            + "JOIN user u ON p.User_ID_User = u.ID_User "
            + "JOIN detail_peminjaman dp ON p.ID_Peminjaman = dp.Peminjaman_ID_Peminjaman "
            + "JOIN perangkat pr ON dp.Perangkat_ID_Perangkat = pr.ID_Perangkat "
            + "ORDER BY p.Tanggal_Peminjaman DESC, p.ID_Peminjaman, pr.ID_Perangkat LIMIT 30"
            : "SELECT p.ID_Peminjaman, p.Tanggal_Peminjaman, p.Tanggal_Pengembalian, p.Status_Peminjaman, "
            + "pg.Nama_Pegawai, u.Nama_Full AS Nama_User, "
            + "pr.ID_Perangkat, pr.Jenis_Perangkat, pr.Merek, pr.No_Serial, pr.Model_Perangkat "
            + "FROM peminjaman p "
            + "JOIN pegawai pg ON p.Pegawai_ID_Pegawai = pg.ID_Pegawai "
            + "JOIN user u ON p.User_ID_User = u.ID_User "
            + "JOIN detail_peminjaman dp ON p.ID_Peminjaman = dp.Peminjaman_ID_Peminjaman "
            + "JOIN perangkat pr ON dp.Perangkat_ID_Perangkat = pr.ID_Perangkat "
            + "WHERE p.User_ID_User = ? "
            + "ORDER BY p.Tanggal_Peminjaman DESC, p.ID_Peminjaman, pr.ID_Perangkat LIMIT 30";

    fillTable(sql, model, "admin".equals(userRole) ? null : userID);
    }

    private void showRiwayatTiket() {
        riwayat.setText("Riwayat Tiket");
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        model.addColumn("No");
        model.addColumn("ID Tiket");
        model.addColumn("Judul");
        model.addColumn("Prioritas");
        model.addColumn("Start Date");
        model.addColumn("End Date");
        model.addColumn("Status");
        model.addColumn("User");
        model.addColumn("Petugas");
        tblData.setModel(model);

        String sql = "admin".equals(userRole)
                ? "SELECT t.ID_Tiket, t.Judul_Tiket, t.Prioritas_Tiket, t.StartDate, t.EndDate, t.Status_Tiket, "
                + "u.Nama_Full AS Nama_User, pg.Nama_Pegawai AS Nama_Petugas "
                + "FROM tiket t "
                + "JOIN user u ON t.User_ID_User = u.ID_User "
                + "LEFT JOIN pegawai pg ON t.Pegawai_ID_Pegawai = pg.ID_Pegawai "
                + "ORDER BY t.StartDate DESC LIMIT 20"
                : "SELECT t.ID_Tiket, t.Judul_Tiket, t.Prioritas_Tiket, t.StartDate, t.EndDate, t.Status_Tiket, "
                + "u.Nama_Full AS Nama_User, pg.Nama_Pegawai AS Nama_Petugas "
                + "FROM tiket t "
                + "JOIN user u ON t.User_ID_User = u.ID_User "
                + "LEFT JOIN pegawai pg ON t.Pegawai_ID_Pegawai = pg.ID_Pegawai "
                + "WHERE t.User_ID_User = ? "
                + "ORDER BY t.StartDate DESC LIMIT 20";

        fillTable(sql, model, "admin".equals(userRole) ? null : userID);
    }

  private void fillTable(String sql, DefaultTableModel model, String param) {
    model.setRowCount(0);
    try (PreparedStatement st = conn.prepareStatement(sql)) {
        if (param != null) st.setString(1, param);

        try (ResultSet rs = st.executeQuery()) {
            int no = 1;
            while (rs.next()) {
                // DETEKSI BERDASARKAN QUERY STRING (PALING AKURAT)
                if (sql.toLowerCase().contains("from pegawai") && !sql.toLowerCase().contains("join")) {
                    // PEGAWAI
                    model.addRow(new Object[]{
                        no++,
                        rs.getString("ID_Pegawai"),
                        rs.getString("Nama_Pegawai"),
                        rs.getString("Email"),
                        rs.getString("Telepon"),
                        rs.getString("Jenis_Kelamin"),
                        rs.getDate("Tanggal_Bergabung") != null ? sdf.format(rs.getDate("Tanggal_Bergabung")) : ""
                    });
                } else if (sql.toLowerCase().contains("from perangkat")) {
                    // PERANGKAT
                    model.addRow(new Object[]{
                        no++,
                        rs.getString("ID_Perangkat"),
                        rs.getString("Jenis_Perangkat"),
                        rs.getString("Merek"),
                        rs.getString("No_Serial"),
                        rs.getString("Model_Perangkat"),
                        rs.getString("status")
                    });
                } else if (sql.toLowerCase().contains("peminjaman") && sql.toLowerCase().contains("detail_peminjaman")) {
                    // DETAIL PEMINJAMAN
                    model.addRow(new Object[]{
                        no++,
                        rs.getString("ID_Peminjaman"),
                        rs.getDate("Tanggal_Peminjaman") != null ? sdf.format(rs.getDate("Tanggal_Peminjaman")) : "",
                        rs.getDate("Tanggal_Pengembalian") != null ? sdf.format(rs.getDate("Tanggal_Pengembalian")) : "",
                        rs.getString("Status_Peminjaman"),
                        rs.getString("Nama_Pegawai"),
                        rs.getString("Nama_User"),
                        rs.getString("ID_Perangkat"),
                        rs.getString("Jenis_Perangkat"),
                        rs.getString("Merek"),
                        rs.getString("No_Serial"),
                        rs.getString("Model_Perangkat")
                    });
                } else if (sql.toLowerCase().contains("tiket")) {
                    // TIKET
                    model.addRow(new Object[]{
                        no++,
                        rs.getString("ID_Tiket"),
                        rs.getString("Judul_Tiket"),
                        rs.getString("Prioritas_Tiket"),
                        rs.getDate("StartDate") != null ? sdf.format(rs.getDate("StartDate")) : "",
                        rs.getDate("EndDate") != null ? sdf.format(rs.getDate("EndDate")) : "-",
                        rs.getString("Status_Tiket"),
                        rs.getString("Nama_User"),
                        rs.getString("Nama_Petugas") != null ? rs.getString("Nama_Petugas") : "-"
                    });
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage());
    }
}
}

