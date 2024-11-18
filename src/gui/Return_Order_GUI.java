package gui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLightLaf;
import dao.ChiTietDoiTra_DAO;
import dao.ChiTietHoaDon_DAO;
import dao.DoiTra_DAO;
import dao.HoaDon_DAO;
import dao.NhanVien_DAO;
import dao.Thuoc_DAO;
import entity.ChiTietDoiTra;
import entity.ChiTietHoaDon;
import entity.DoiTra;
import entity.HoaDon;
import entity.NhanVien;
import entity.TaiKhoan;
import entity.Thuoc;
import enums.TrangThaiDoiTra;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import raven.toast.Notifications;
import utilities.FormatNumber;
import utilities.ReturnOrderPrinter;

/**
 *
 * @author HÀ NHƯ
 */
public class Return_Order_GUI extends javax.swing.JPanel {

    private ArrayList<ChiTietHoaDon> cart;
    private DefaultTableModel tblModel_HD;
    private DefaultTableModel tblModel_SP;
    private HoaDon_DAO hd_DAO;
    private int maxSoLuong;
    private double tongTienTra;
    private HoaDon hoaDon;
    private TaiKhoan tk;
    private NhanVien nv;
    ArrayList<ChiTietHoaDon> listSPHoan;
    ArrayList<ChiTietDoiTra> listDoiTra;
    private DoiTra doiTra;

    public Return_Order_GUI(TaiKhoan tk) {

        initComponents();
        try {
            connect.ConnectDB.connect();
        } catch (SQLException ex) {
            Logger.getLogger(Return_Order_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.tk = tk;
        cart = new ArrayList<>();
        hd_DAO = new HoaDon_DAO();
        listSPHoan = new ArrayList<>();
        listDoiTra = new ArrayList<>();

        txtMaHDDT.setText(TaoID());
        initNhanVien();
        doiTra = new DoiTra(txtMaHDDT.getText());
        buttonGroup1.add(rdn_Doi);
        buttonGroup1.add(rdn_Tra);

    }

    public void initNhanVien() {
        this.nv = new NhanVien_DAO().getNhanVien(tk.getNhanVien().getMaNhanVien());
        txtMaNV.setText(this.nv.getMaNhanVien());
        txtTenNV.setText(this.nv.getTenNhanVien());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txt_MaHD = new javax.swing.JTextField();
        btn_searchReturnOrder = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_HD = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lbl_MaHDDT = new javax.swing.JLabel();
        txtMaHDDT = new javax.swing.JTextField();
        lbl_MaHD = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        lbl_NgayDT = new javax.swing.JLabel();
        lbl_BangSanPham = new javax.swing.JLabel();
        lbl_TienHoan = new javax.swing.JLabel();
        lbl_LyDo = new javax.swing.JLabel();
        txt_soTienTra = new javax.swing.JTextField();
        txt_MoTa = new javax.swing.JTextField();
        btn_XoaTrang = new javax.swing.JButton();
        btn_Them = new javax.swing.JButton();
        btn_TaoHDDT = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lbl_LoaiDT = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_SanPham = new javax.swing.JTable();
        jdatechooser_return = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        rdn_Doi = new javax.swing.JRadioButton();
        rdn_Tra = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        lbl_MaNV = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        lbl_TenNV = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();

        txt_MaHD.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Nhập mã hóa đơn");
        txt_MaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MaHDActionPerformed(evt);
            }
        });
        txt_MaHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_MaHDKeyPressed(evt);
            }
        });

        btn_searchReturnOrder.setBackground(new java.awt.Color(102, 153, 255));
        btn_searchReturnOrder.setText("Tìm kiếm");
        btn_searchReturnOrder.setMaximumSize(new java.awt.Dimension(79, 43));
        btn_searchReturnOrder.setPreferredSize(new java.awt.Dimension(90, 50));
        btn_searchReturnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchReturnOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(txt_MaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_searchReturnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 114, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_MaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_searchReturnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N

        table_HD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Tổng tiền"
            }
        ));
        jScrollPane1.setViewportView(table_HD);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin đổi trả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MaHDDT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_MaHDDT.setText("Mã HDDT:");
        jPanel3.add(lbl_MaHDDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 119, 30));

        txtMaHDDT.setEnabled(false);
        jPanel3.add(txtMaHDDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 32, 310, 30));

        lbl_MaHD.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_MaHD.setText("Mã hóa đơn:");
        jPanel3.add(lbl_MaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 119, 30));
        jPanel3.add(txtMaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 70, 310, 30));

        lbl_NgayDT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_NgayDT.setText("Ngày đổi trả:");
        jPanel3.add(lbl_NgayDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 119, 30));

        lbl_BangSanPham.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_BangSanPham.setText("Sản phẩm:");
        jPanel3.add(lbl_BangSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 119, 30));

        lbl_TienHoan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_TienHoan.setText("Tiền hoàn:");
        jPanel3.add(lbl_TienHoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 80, 20));

        lbl_LyDo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_LyDo.setText("Lý do:");
        jPanel3.add(lbl_LyDo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 70, 20));
        jPanel3.add(txt_soTienTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 300, 30));
        jPanel3.add(txt_MoTa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 300, 30));

        btn_XoaTrang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_XoaTrang.setText("Xóa trắng");
        btn_XoaTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaTrangActionPerformed(evt);
            }
        });
        jPanel3.add(btn_XoaTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        btn_Them.setBackground(new java.awt.Color(0, 153, 102));
        btn_Them.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_Them.setText("Thêm sp");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });
        jPanel3.add(btn_Them, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, -1, -1));

        btn_TaoHDDT.setBackground(new java.awt.Color(102, 153, 255));
        btn_TaoHDDT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_TaoHDDT.setText("Tạo đơn đổi trả");
        btn_TaoHDDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TaoHDDTActionPerformed(evt);
            }
        });
        jPanel3.add(btn_TaoHDDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 489, -1, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setText("Sản phẩm:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 119, 30));

        lbl_LoaiDT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_LoaiDT.setText("Loại:");
        jPanel3.add(lbl_LoaiDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        table_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng"
            }
        ));
        jScrollPane2.setViewportView(table_SanPham);

        jScrollPane3.setViewportView(jScrollPane2);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 450, 170));
        jPanel3.add(jdatechooser_return, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 112, 310, 30));

        rdn_Doi.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdn_Doi.setText("Đổi");

        rdn_Tra.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdn_Tra.setText("Trả");
        rdn_Tra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdn_TraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(rdn_Tra)
                .addGap(59, 59, 59)
                .addComponent(rdn_Doi)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdn_Tra)
                    .addComponent(rdn_Doi))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 310, 30));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N

        lbl_MaNV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_MaNV.setText("Mã nhân viên: ");

        txtMaNV.setEnabled(false);

        lbl_TenNV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_TenNV.setText("Tên nhân viên: ");

        txtTenNV.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaNV))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl_TenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenNV)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_TenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
 private void init() {
        hoaDon = hd_DAO.getHoaDon(txt_MaHD.getText());
        //set txt ma hoa don
        txtMaHD.setText(hoaDon.getMaHD());
        cart = hd_DAO.getChiTietHoaDon(txt_MaHD.getText());
        //model
        tblModel_HD = new DefaultTableModel(new String[]{"Mã hoá đơn", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Tổng tiền"}, 0);
        table_HD.setModel(tblModel_HD);
        tblModel_SP = new DefaultTableModel(new String[]{"Mã sản phẩm", "Tên sản phẩm", "Số lượng"}, 0);
        table_SanPham.setModel(tblModel_SP);
        for (ChiTietHoaDon cthd : cart) {
            Object[] obj = initObject(cthd);
            tblModel_HD.addRow(obj);
        }

        table_SanPham.getModel().addTableModelListener((e) -> {
            int row = e.getFirstRow();
            int col = e.getColumn();
            //Không xử lí nếu row hoặc col = -1 và col không phải là ô nhập số lượng
            if (row == -1 || col == -1 && col != 2) {
                return;
            }
            int newValue = Integer.parseInt(tblModel_SP.getValueAt(row, col).toString());
            ChiTietHoaDon current = cart.get(row);
            if (newValue == 0 && JOptionPane.showConfirmDialog(this, "Xóa sản phẩm " + current.getThuoc().getMaThuoc() + " ra khỏi giỏ hàng", "Xóa sản phẩm khỏi giỏ", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    cart.remove(current);
                    // renderProductTable();
                    return;
                } catch (Exception ex) {
                    Notifications.getInstance().show(Notifications.Type.WARNING, ex.getMessage());
                }
            }
            try {
                if (maxSoLuong >= newValue) {
                    //Cập nhật giá trị mới
                    current.setSoLuong(newValue);
                    //renderProductTable();
                } else {
                    //Trả về giá trị cũ
                    table_SanPham.setValueAt(current.getSoLuong(), row, col);
                    Notifications.getInstance().show(Notifications.Type.ERROR, "Số lượng sản phẩm không hợp lệ!");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                Notifications.getInstance().show(Notifications.Type.ERROR, "Không thể cập nhật số lượng mới!");
            }
        });
//        renderCurrentEmployee();
    }

    public Object[] initObject(ChiTietHoaDon item) {
        Object[] obj = new Object[6];
        obj[0] = hoaDon.getMaHD();
        obj[1] = item.getThuoc().getMaThuoc();
        obj[2] = item.getThuoc().getTenThuoc();
        obj[3] = item.getSoLuong();
        obj[4] = item.getDonGia();
        obj[5] = item.thanhTien();
        return obj;

    }

    private void renderOrderDetail(String maHD) {
        tblModel_HD.setRowCount(0);
        ArrayList<ChiTietHoaDon> dsHDDT = ChiTietHoaDon_DAO.getAllChiTietHoaDon();
        for (ChiTietHoaDon CTHD : dsHDDT) {
            double gia = CTHD.getDonGia();
            String[] newRow = {CTHD.getHoaDon().getMaHD(), CTHD.getThuoc().getMaThuoc(), CTHD.getThuoc().getTenThuoc(), CTHD.getSoLuong() + "", gia + "", CTHD.getSoLuong() * gia + ""};
            tblModel_HD.addRow(newRow);
        }
    }

    private void addItemToCart(String maThuoc, int soLuong, double gia) {
        Thuoc item = new Thuoc_DAO().getThuoc(maThuoc);
        if (item == null) {
            Notifications.getInstance().show(Notifications.Type.INFO, "Không tìm thấy sản phẩm có mã " + maThuoc);
        } else {
            maxSoLuong = soLuong;
            try {
                //Thêm vào giỏ hàng
                Thuoc thuoc = new Thuoc_DAO().getThuoc(maThuoc);
                ChiTietDoiTra newCTDT = new ChiTietDoiTra(thuoc, 1, gia);
                listDoiTra.add(newCTDT);
                // renderProductTable();
                toggleChangeQuantity();
            } catch (Exception ex) {
                ex.printStackTrace();
                Notifications.getInstance().show(Notifications.Type.ERROR, "Có lỗi xảy ra khi thêm sản phẩm " + maThuoc);
            }
        }
    }

    private void toggleChangeQuantity() {
        int row = cart.size() - 1;
        table_SanPham.requestFocus();
        table_SanPham.changeSelection(row, 2, false, false);
        table_SanPham.setColumnSelectionInterval(2, 2);
        table_SanPham.setRowSelectionInterval(row, row);
        table_SanPham.editCellAt(row, 2);
    }


    private void btn_searchReturnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchReturnOrderActionPerformed
        init();
    }//GEN-LAST:event_btn_searchReturnOrderActionPerformed

    private void txt_MaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MaHDActionPerformed

    }//GEN-LAST:event_txt_MaHDActionPerformed

    private void btn_TaoHDDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TaoHDDTActionPerformed
        doiTra.setHoaDon(hoaDon);
        try {
            doiTra.setLiDO(txt_MoTa.getText());
        } catch (Exception ex) {
            Logger.getLogger(Return_Order_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        doiTra.setListDetail(listDoiTra);
        doiTra.setLoai(true);
        if (rdn_Doi.isSelected()) {
            doiTra.setLoai(false);

        }
        doiTra.setMaHDDT(txtMaHDDT.getText());
        doiTra.setNgayDoiTra(jdatechooser_return.getDate());
        try {
            doiTra.setNhanvien(nv);
        } catch (Exception ex) {
            Logger.getLogger(Return_Order_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        doiTra.setTienTra(Double.valueOf(txt_soTienTra.getText()));
        doiTra.setTrangThai(TrangThaiDoiTra.PENDING);
        doiTra.setListDetail(listDoiTra);
        if (hoaDon == null) {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Vui lòng chọn hoá đơn để đổi trả");
            txt_MaHD.requestFocus();
            return;

        }
        if (checkDate()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Ngày đổi trả không được khác ngày hiện tại");
            return;
        }
        if (tblModel_SP.getRowCount() == 0) {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Chưa chọn sản phẩm để đổi trả");
            return;
        }
        if (rdn_Doi.isSelected()) {
            for (ChiTietDoiTra CTDT : listDoiTra) {
                if (new Thuoc_DAO().getThuoc(CTDT.getSanPham().getMaThuoc()).getSoLuongTon() < CTDT.getSoLuong()) {
                    Notifications.getInstance().show(Notifications.Type.WARNING, "Sản phẩm " + CTDT.getSanPham().getMaThuoc() + " không đủ để thực hiện đổi hàng");
                    return;
                }
            }
        }
        try {
            ReturnOrderPrinter printer = new ReturnOrderPrinter(doiTra);
            printer.generatePDF();
        } catch (Exception ex) {
            Notifications.getInstance().show(Notifications.Type.WARNING, ex.getMessage());
        }

    }//GEN-LAST:event_btn_TaoHDDTActionPerformed

    private void rdn_TraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdn_TraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdn_TraActionPerformed

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed

        int rowIndex = table_HD.getSelectedRow();
        double tienTra = 0;
        String maThuoc = table_HD.getValueAt(rowIndex, 1).toString();
        String tenThuoc = table_HD.getValueAt(rowIndex, 2) + "";
        int soLuong = Integer.valueOf(table_HD.getValueAt(rowIndex, 3).toString());
        tblModel_SP.addRow(new Object[]{maThuoc, tenThuoc, soLuong});
        listSPHoan.add(cart.get(rowIndex));
        Thuoc sanPham = new Thuoc_DAO().getThuoc(maThuoc);

        for (ChiTietHoaDon item : listSPHoan) {
            tienTra += item.thanhTien();
            listDoiTra.add(new ChiTietDoiTra(new DoiTra(txtMaHDDT.getText()), sanPham, soLuong, item.thanhTien()));

        }
        txt_soTienTra.setText(tienTra + "");


    }//GEN-LAST:event_btn_ThemActionPerformed

    private void txt_MaHDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_MaHDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String maHD = txt_MaHD.getText();
            if (maHD.isBlank()) {
                Notifications.getInstance().show(Notifications.Type.INFO, "Vui lòng nhập mã hoá đơn để tìm");
                return;
            }
            hoaDon = hd_DAO.getHoaDon(maHD);
            if (maHD == null) {
                Notifications.getInstance().show(Notifications.Type.WARNING, "Mã hoá đơn " + maHD + " không tìm thấy");
                return;
            }
//            if (bus.isExist(order)) {
//                Notifications.getInstance().show(Notifications.Type.WARNING, "Hoá đơn này đã thực hiện đổi trả");
//                return;
//            }
            if (!isAvaiable(hoaDon)) {
                Notifications.getInstance().show(Notifications.Type.WARNING, "Hoá đơn này không đủ điều kiện thực hiện đổi trả");
                return;
            }
            renderOrderDetail(maHD);
        }
    }//GEN-LAST:event_txt_MaHDKeyPressed

    private void btn_XoaTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaTrangActionPerformed
        //renderReturnOrderInfor();
    }//GEN-LAST:event_btn_XoaTrangActionPerformed

    public String TaoID() {
        // Khởi tạo mã hóa đơn đổi trả
        String prefix = "HDDT";
        // Lấy 2 chữ số cuối của năm hiện tại
        int nam = LocalDate.now().getYear() % 100; // Lấy hai chữ số cuối
        int thang = LocalDate.now().getMonthValue();
        int ngay = LocalDate.now().getDayOfMonth();
        prefix += String.format("%02d%02d%02d", nam, thang, ngay) + generateRandomString(6);
        System.out.println(prefix);
        return prefix;
    }

    public String generateRandomString(int length) {

        char[] number = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char[] charArray = chars.toCharArray();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomNumber = (int) Math.floor(Math.random() * 2);
            if (randomNumber == 0) {
                sb.append(number[(int) (Math.random() * 9)]);
            } else {
                sb.append(charArray[(int) (Math.random() * charArray.length)]);
            }
        }

        return sb.toString();
    }

    private boolean isAvaiable(HoaDon order) {
        LocalDate now = LocalDate.now();
        LocalDate orderDate = order.getNgayLap();

        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(orderDate, now);
        return daysBetween <= 7;
    }

    private boolean checkDate() {
        LocalDate now = LocalDate.now();
        LocalDate orderDate = jdatechooser_return.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Nếu ngày `orderDate` trước `now`, trả về `true`
        if (orderDate.isBefore(now)) {
            return true;
        }

        // Tính số ngày giữa `now` và `orderDate`
        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(now, orderDate);
        return daysBetween > 0;
    }

    private void createNewReturnOrder(DoiTra newReturnOrder) {
        if ((DoiTra_DAO.create(newReturnOrder))) {
            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Thêm thành công");
            ChiTietDoiTra_DAO.createReturnOrderDetail(newReturnOrder, listDoiTra);
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Thêm không thành công");
        }
    }
//    private void Print(DoiTra returnOrder) {
//        ReturnOrderPrinter printer = new ReturnOrderPrinter(returnOrder);
//        printer.generatePDF();
//        ReturnOrderPrinter.PrintStatus status = printer.printFile();
//        if (status == ReturnOrderPrinter.PrintStatus.NOT_FOUND_FILE) {
//            Notifications.getInstance().show(Notifications.Type.ERROR, "Lỗi không thể in hóa đơn: Không tìm thấy file");
//        } else if (status == ReturnOrderPrinter.PrintStatus.NOT_FOUND_PRINTER) {
//            Notifications.getInstance().show(Notifications.Type.ERROR, "Lỗi không thể in hóa đơn: Không tìm thấy máy in");
//        }
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_TaoHDDT;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_XoaTrang;
    private javax.swing.JButton btn_searchReturnOrder;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jdatechooser_return;
    private javax.swing.JLabel lbl_BangSanPham;
    private javax.swing.JLabel lbl_LoaiDT;
    private javax.swing.JLabel lbl_LyDo;
    private javax.swing.JLabel lbl_MaHD;
    private javax.swing.JLabel lbl_MaHDDT;
    private javax.swing.JLabel lbl_MaNV;
    private javax.swing.JLabel lbl_NgayDT;
    private javax.swing.JLabel lbl_TenNV;
    private javax.swing.JLabel lbl_TienHoan;
    private javax.swing.JRadioButton rdn_Doi;
    private javax.swing.JRadioButton rdn_Tra;
    private javax.swing.JTable table_HD;
    private javax.swing.JTable table_SanPham;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaHDDT;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txt_MaHD;
    private javax.swing.JTextField txt_MoTa;
    private javax.swing.JTextField txt_soTienTra;
    // End of variables declaration//GEN-END:variables

}
