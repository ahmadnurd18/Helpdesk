package com.perpus.jdialog;

import com.perpus.config.Koneksi;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class DataPerangkatIT extends javax.swing.JDialog {

    private int halamanSaatIni = 1;
    private int dataPerHalaman = 14;
    private int totalPages;
    private Connection conn;

    private String idPerangkat;
    private String namaPerangkat;
    private String kondisi;
    private String status;

    public String getIdPerangkat() {
        return idPerangkat;
    }

    public String getNamaPerangkat() {
        return namaPerangkat;
    }

    public String getKondisi() {
        return kondisi;
    }

    public String getStatus() {
        return status;
    }

    public DataPerangkatIT(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pencarian");
        conn = Koneksi.getConnection();
        setTabelModel();
        loadData();
        paginationAnggota();
        actionButton();
        setColumnWidth();
        setLayoutForm();
    }

    private void setLayoutForm() {
        iconJudul.setIcon(new FlatSVGIcon("com/perpus/icon/device.svg", 1f));
        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pencarian Perangkat IT");
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON, 
                new FlatSVGIcon("com/perpus/icon/search.svg", 0.80f));
    }

    private void setColumnWidth() {
        TableColumnModel columnModel = tblData.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(0).setMaxWidth(40);
        columnModel.getColumn(0).setMinWidth(40);
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
        lbJudul.setText("Data Perangkat It");

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

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPerangkatIT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

    private void actionButton() {
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                searchData();
            }
        });

        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pilihData();
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
            Logger.getLogger(DataPerangkatIT.class.getName()).log(Level.SEVERE, null, e);
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
    }

    private void setTabelModel() {
        DefaultTableModel model = (DefaultTableModel) tblData.getModel();
        model.addColumn("  No");
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
            String sql = "SELECT id_perangkat, nama_perangkat, jenis_perangkat, merek, model, serial_number, " +
                         "tanggal_pembelian, kondisi, status FROM perangkat_it ORDER BY id_perangkat ASC LIMIT ?, ?";
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
                    String model_perangkat = rs.getString("model") != null ? rs.getString("model") : "";
                    String serialNumber = rs.getString("serial_number") != null ? rs.getString("serial_number") : "";
                    String tanggalPembelian = rs.getString("tanggal_pembelian") != null ? sdf.format(rs.getDate("tanggal_pembelian")) : "";
                    String kondisi = rs.getString("kondisi") != null ? rs.getString("kondisi") : "Baru";
                    String status = rs.getString("status") != null ? rs.getString("status") : "Tersedia";

                    Object[] rowData = {
                        "   " + no++, idPerangkat, namaPerangkat, jenisPerangkat, merek, model_perangkat, serialNumber,
                        tanggalPembelian, kondisi, status
                    };
                    model.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(DataPerangkatIT.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void searchData() {
        String kataKunci = txtSearch.getText();

        DefaultTableModel model = (DefaultTableModel) tblData.getModel();
        model.setRowCount(0);

        try {
            String sql = "SELECT id_perangkat, nama_perangkat, jenis_perangkat, merek, model, serial_number, " +
                         "tanggal_pembelian, kondisi, status FROM perangkat_it " +
                         "WHERE nama_perangkat LIKE ? OR id_perangkat LIKE ?";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, "%" + kataKunci + "%");
                st.setString(2, "%" + kataKunci + "%");
                ResultSet rs = st.executeQuery();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                while (rs.next()) {
                    String idPerangkat = rs.getString("id_perangkat");
                    String namaPerangkat = rs.getString("nama_perangkat");
                    String jenisPerangkat = rs.getString("jenis_perangkat");
                    String merek = rs.getString("merek") != null ? rs.getString("merek") : "";
                    String model_perangkat = rs.getString("model") != null ? rs.getString("model") : "";
                    String serialNumber = rs.getString("serial_number") != null ? rs.getString("serial_number") : "";
                    String tanggalPembelian = rs.getString("tanggal_pembelian") != null ? sdf.format(rs.getDate("tanggal_pembelian")) : "";
                    String kondisi = rs.getString("kondisi") != null ? rs.getString("kondisi") : "Baru";
                    String status = rs.getString("status") != null ? rs.getString("status") : "Tersedia";

                    Object[] rowData = {
                        idPerangkat, namaPerangkat, jenisPerangkat, merek, model_perangkat, serialNumber,
                        tanggalPembelian, kondisi, status
                    };
                    model.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(DataPerangkatIT.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void pilihData() {
        int row = tblData.getSelectedRow();

        idPerangkat = tblData.getValueAt(row, 1).toString(); // ID Perangkat (kolom 1)
        namaPerangkat = tblData.getValueAt(row, 2).toString(); // Nama Perangkat (kolom 2)
        kondisi = tblData.getValueAt(row, 8).toString(); // Kondisi (kolom 8)
        status = tblData.getValueAt(row, 9).toString(); // Status (kolom 9)

        dispose();
    }}
