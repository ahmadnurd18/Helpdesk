package com.perpus.jdialog;

import com.perpus.config.Koneksi;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class DataPerangkatIT extends javax.swing.JDialog {

    private int halamanSaatIni = 1;
    private int dataPerHalaman = 14;
    private int totalPages;
    private Connection conn;
    private String idPerangkat;
    private String userRole;
    private String userIdPegawai; // ID_Pegawai dari pegawai yang sedang meminjam

    public String getIdPerangkat() { return idPerangkat; }

    public DataPerangkatIT(java.awt.Frame parent, boolean modal, String role, String idPegawaiLogin) {
        super(parent, modal);
        initComponents();
        conn = Koneksi.getConnection();
        this.userRole = role != null ? role : "user";
        this.userIdPegawai = idPegawaiLogin;
        setTabelModel();
        loadData();
        pagination();
        actionButton();
        setColumnWidth();
        setLayoutForm();
        setLocationRelativeTo(null);
        applyRowColor(); // tambahkan warna baris
    }

    private void setLayoutForm() {
        iconJudul.setIcon(new FlatSVGIcon("com/perpus/icon/device.svg", 1f));
        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Cari ID, Jenis, Merek, Serial...");
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON,
                new FlatSVGIcon("com/perpus/icon/search.svg", 0.8f));
    }

    private void setColumnWidth() {
        TableColumnModel tcm = tblData.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(40); tcm.getColumn(0).setMaxWidth(40); tcm.getColumn(0).setMinWidth(40);
        tcm.getColumn(6).setPreferredWidth(120); // kolom Status
    }

    private void applyRowColor() {
        tblData.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    String status = (String) table.getValueAt(row, 6);
                    if ("Sedang Dipinjam".equals(status)) {
                        c.setBackground(new Color(255, 220, 220)); // merah muda
                        c.setForeground(Color.BLACK);
                    } else if ("Dipinjam (Anda)".equals(status)) {
                        c.setBackground(new Color(220, 255, 220)); // hijau muda
                        c.setForeground(Color.BLACK);
                    } else {
                        c.setBackground(table.getBackground());
                        c.setForeground(table.getForeground());
                    }
                }
                return c;
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        iconJudul = new javax.swing.JLabel();
        lbJudul = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        pnHalaman = new javax.swing.JPanel();
        btn_last = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        cbx_data = new javax.swing.JComboBox<>();
        btn_before = new javax.swing.JButton();
        btn_first = new javax.swing.JButton();
        lb_halaman = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        iconJudul.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        iconJudul.setForeground(new java.awt.Color(102, 102, 102));

        lbJudul.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbJudul.setForeground(new java.awt.Color(102, 102, 102));
        lbJudul.setText("Data Perangkat");

        tblData.setRowHeight(30);
        jScrollPane1.setViewportView(tblData);

        pnHalaman.setBackground(new java.awt.Color(250, 250, 250));

        btn_last.setText("Last Page");

        btn_next.setText(">");

        cbx_data.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "14", "28", "54", "108" }));

        btn_before.setText("<");

        btn_first.setText("First Page");

        lb_halaman.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_halaman.setText("Halaman of Total Halaman");

        javax.swing.GroupLayout pnHalamanLayout = new javax.swing.GroupLayout(pnHalaman);
        pnHalaman.setLayout(pnHalamanLayout);
        pnHalamanLayout.setHorizontalGroup(
            pnHalamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHalamanLayout.createSequentialGroup()
                .addContainerGap(321, Short.MAX_VALUE)
                .addGroup(pnHalamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_halaman, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnHalamanLayout.createSequentialGroup()
                        .addComponent(btn_first)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_before, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_last)))
                .addContainerGap(322, Short.MAX_VALUE))
        );
        pnHalamanLayout.setVerticalGroup(
            pnHalamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHalamanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_halaman)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnHalamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_first, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_before, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_data, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_last, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(iconJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbJudul))
                    .addComponent(txtSearch)
                    .addComponent(jScrollPane1)
                    .addComponent(pnHalaman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnHalaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public DataPerangkatIT(java.awt.Frame parent, boolean modal) {
    this(parent, modal, "admin", null); // default ke admin saat testing
}
    public static void main(String args[]) {
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (Exception ex) {
        java.util.logging.Logger.getLogger(DataPerangkatIT.class.getName()).log(
            java.util.logging.Level.SEVERE, null, ex);
    }

    java.awt.EventQueue.invokeLater(() -> {
        DataPerangkatIT dialog = new DataPerangkatIT(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_before;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JComboBox<String> cbx_data;
    private javax.swing.JLabel iconJudul;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbJudul;
    private javax.swing.JLabel lb_halaman;
    private javax.swing.JPanel pnHalaman;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

 private void pagination() {
        btn_first.addActionListener(e -> { halamanSaatIni = 1; loadData(); });
        btn_before.addActionListener(e -> { if (halamanSaatIni > 1) { halamanSaatIni--; loadData(); } });
        cbx_data.addActionListener(e -> { dataPerHalaman = Integer.parseInt(cbx_data.getSelectedItem().toString()); halamanSaatIni = 1; loadData(); });
        btn_next.addActionListener(e -> { if (halamanSaatIni < totalPages) { halamanSaatIni++; loadData(); } });
        btn_last.addActionListener(e -> { halamanSaatIni = totalPages; loadData(); });
    }

    // ================== AKSI TOMBOL ==================
    private void actionButton() {
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                halamanSaatIni = 1;
                searchData();
            }
        });

        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Double-click
                    pilihData();
                }
            }
        });
    }

    // ================== TABEL MODEL ==================
   private void setTabelModel() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.setColumnIdentifiers(new Object[]{
            "No", "ID Perangkat", "Jenis", "Merek", "Serial", "Model", "Status"
        });
        tblData.setModel(model);
    }

    // ================== DATA & PAGINATION ==================
   private int getTotalData() {
        String sql;
        if ("admin".equalsIgnoreCase(userRole)) {
            sql = "SELECT COUNT(*) FROM perangkat";
        } else {
            sql = "SELECT COUNT(DISTINCT p.ID_Perangkat) FROM perangkat p " +
                  "LEFT JOIN detail_peminjaman dp ON p.ID_Perangkat = dp.Perangkat_ID_Perangkat " +
                  "LEFT JOIN peminjaman pm ON dp.Peminjaman_ID_Peminjaman = pm.ID_Peminjaman AND pm.Status_Peminjaman = 'Dipinjam' " +
                  "WHERE dp.Peminjaman_ID_Peminjaman IS NULL OR pm.Pegawai_ID_Pegawai = ?";
        }
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            if (!"admin".equalsIgnoreCase(userRole)) {
                st.setString(1, userIdPegawai);
            }
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

  private void calculateTotalPages() {
        int total = getTotalData();
        totalPages = (int) Math.ceil(total / (double) dataPerHalaman);
        if (totalPages == 0) totalPages = 1;
    }

    private void loadData() {
        calculateTotalPages();
        int start = (halamanSaatIni - 1) * dataPerHalaman;

        DefaultTableModel model = (DefaultTableModel) tblData.getModel();
        model.setRowCount(0);

        String sql;
        String baseSql = "FROM perangkat p " +
            "LEFT JOIN detail_peminjaman dp ON p.ID_Perangkat = dp.Perangkat_ID_Perangkat " +
            "LEFT JOIN peminjaman pm ON dp.Peminjaman_ID_Peminjaman = pm.ID_Peminjaman AND pm.Status_Peminjaman = 'Dipinjam' ";

        if ("admin".equalsIgnoreCase(userRole)) {
            sql = "SELECT p.ID_Perangkat, p.Jenis_Perangkat, p.Merek, p.No_Serial, p.Model_Perangkat, " +
                  "CASE WHEN dp.Peminjaman_ID_Peminjaman IS NULL THEN 'Tersedia' ELSE 'Sedang Dipinjam' END AS status_tersedia " +
                  baseSql + "ORDER BY p.ID_Perangkat LIMIT ?, ?";
        } else {
            sql = "SELECT p.ID_Perangkat, p.Jenis_Perangkat, p.Merek, p.No_Serial, p.Model_Perangkat, " +
                 "CASE "+
        "WHEN dp.Perangkat_ID_Perangkat IS NOT NULL AND pm.Status_Peminjaman = 'Dipinjam' THEN 'Sedang Dipinjam'"+
        "ELSE 'Tersedia'"+
    "END AS status_display"+baseSql +
                  "WHERE dp.Peminjaman_ID_Peminjaman IS NULL OR pm.Pegawai_ID_Pegawai = ? " +
                  "ORDER BY p.ID_Perangkat LIMIT ?, ?";
        }

        try (PreparedStatement st = conn.prepareStatement(sql)) {
            int idx = 1;
            if (!"admin".equalsIgnoreCase(userRole)) {
                st.setString(idx++, userIdPegawai);
                st.setString(idx++, userIdPegawai);
            }
            st.setInt(idx++, start);
            st.setInt(idx++, dataPerHalaman);

            try (ResultSet rs = st.executeQuery()) {
                int no = start + 1;
                while (rs.next()) {
                    String status = rs.getString("status_tersedia");
                    model.addRow(new Object[]{
                        no++,
                        rs.getString("ID_Perangkat"),
                        rs.getString("Jenis_Perangkat"),
                        rs.getString("Merek"),
                        rs.getString("No_Serial"),
                        rs.getString("Model_Perangkat"),
                        status
                    });
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        lb_halaman.setText("Halaman " + halamanSaatIni + " dari " + totalPages);
    }

  private void searchData() {
        String key = txtSearch.getText().trim();
        DefaultTableModel model = (DefaultTableModel) tblData.getModel();
        model.setRowCount(0);

        String sql;
        String baseSql = "FROM perangkat p " +
            "LEFT JOIN detail_peminjaman dp ON p.ID_Perangkat = dp.Perangkat_ID_Perangkat " +
            "LEFT JOIN peminjaman pm ON dp.Peminjaman_ID_Peminjaman = pm.ID_Peminjaman AND pm.Status_Peminjaman = 'Dipinjam' " +
            "WHERE (p.ID_Perangkat LIKE ? OR p.Jenis_Perangkat LIKE ? OR p.Merek LIKE ? OR p.No_Serial LIKE ? OR p.Model_Perangkat LIKE ?) ";

        if ("admin".equalsIgnoreCase(userRole)) {
            sql = "SELECT p.ID_Perangkat, p.Jenis_Perangkat, p.Merek, p.No_Serial, p.Model_Perangkat, " +
                  "CASE WHEN dp.Peminjaman_ID_Peminjaman IS NULL THEN 'Tersedia' ELSE 'Sedang Dipinjam' END AS status " +
                  baseSql + "ORDER BY p.ID_Perangkat";
        } else {
            sql = "SELECT p.ID_Perangkat, p.Jenis_Perangkat, p.Merek, p.No_Serial, p.Model_Perangkat, " +
                  "CASE WHEN dp.Peminjaman_ID_Peminjaman IS NULL THEN 'Tersedia' " +
                  "     WHEN pm.Pegawai_ID_Pegawai = ? THEN 'Dipinjam (Anda)' ELSE 'Sedang Dipinjam' END AS status " +
                  baseSql + "AND (dp.Peminjaman_ID_Peminjaman IS NULL OR pm.Pegawai_ID_Pegawai = ?) " +
                  "ORDER BY p.ID_Perangkat";
        }

        try (PreparedStatement st = conn.prepareStatement(sql)) {
            String like = "%" + key + "%";
            int idx = 1;
            for (int i = 0; i < 5; i++) st.setString(idx++, like);
            if (!"admin".equalsIgnoreCase(userRole)) {
                st.setString(idx++, userIdPegawai);
                st.setString(idx++, userIdPegawai);
            }

            try (ResultSet rs = st.executeQuery()) {
                int no = 1;
                while (rs.next()) {
                    model.addRow(new Object[]{
                        no++,
                        rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)
                    });
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        lb_halaman.setText("Ditemukan: " + model.getRowCount() + " perangkat");
    }
  
  

    // ================== PILIH DATA ==================
    private void pilihData() {
        int row = tblData.getSelectedRow();
        if (row == -1) return;
        idPerangkat = tblData.getValueAt(row, 1).toString();
        dispose();
    }}
