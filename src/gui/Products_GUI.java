/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoNatureGreenIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMoonlightIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedLightIJTheme;
import com.mallowigi.idea.config.enums.MaterialDesign;
import dao.DonViTinh_DAO;
import dao.LoaiThuoc_DAO;
import dao.NhaCungCap_DAO;
import dao.Thuoc_DAO;
import dao.XuatXu_DAO;
import entity.DonViTinh;
import entity.GiamGia;
import entity.LoaiThuoc;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.Thuoc;
import entity.XuatXu;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;
import raven.toast.Notifications;
import java.util.Random;

public class Products_GUI extends javax.swing.JPanel {

    private Thuoc_DAO thuoc_DAO;
    private DefaultTableModel model;

    public Products_GUI() throws UnsupportedLookAndFeelException {
        initComponents();
        thuoc_DAO = new Thuoc_DAO();
        model = new DefaultTableModel(new String[]{"Mã thuốc", "Tên Thuốc", "Loại", "Xuất xứ", "Giá", "Đơn vị", "Nsx", "Hsd", "Thuế"}, 0);
        tableThuoc.setModel(model);
        initTable();
        InitJCB();

    }

    public void initTable() {
        ArrayList<Thuoc> listThuoc = thuoc_DAO.getAllThuoc();
        for (Thuoc t : listThuoc) {
            Object obj[] = initObject(t);
            model.addRow(obj);
        }

    }

    public void InitJCB() {
        ArrayList<NhaCungCap> listNCC = new NhaCungCap_DAO().getAllNhaCungCap();
        ArrayList<LoaiThuoc> listLoaiThuoc = new LoaiThuoc_DAO().getAllLoaiThuoc();
        ArrayList<XuatXu> listXuatXu = new XuatXu_DAO().getAllXuatXu();
        ArrayList<DonViTinh> listDonVi = new DonViTinh_DAO().getAllDonViTinh();
        jcb_locLoaiThuoc.addItem("Tất cả");
        jcb_locXuatXu.addItem("Tất cả");

        for (NhaCungCap ncc : listNCC) {
            jcb_NCC.addItem(ncc.getMaNCC());
        }
        for (LoaiThuoc lt : listLoaiThuoc) {
            jcb_loaiThuoc.addItem(lt.getMaLoai());
            jcb_locLoaiThuoc.addItem(lt.getTenLoai());
        }
        for (XuatXu xuatXu : listXuatXu) {
            jcb_xuatXu.addItem(xuatXu.getMaXuatXu());
            jcb_locXuatXu.addItem(xuatXu.getTen());
        }
        for (DonViTinh dvt : listDonVi) {
            jcb_donVi.addItem(dvt.getMaDonViTinh());
        }
    }

    public Object[] initObject(Thuoc t) {
        Object obj[] = new Object[9];
        obj[0] = t.getMaThuoc();
        obj[1] = t.getTenThuoc();
        obj[2] = new LoaiThuoc_DAO().getLoaiThuoc(t.getLoaiThuoc().getMaLoai()).getTenLoai();
        obj[3] = new XuatXu_DAO().getXuatXuById(t.getXuatXu().getMaXuatXu()).getTen();
        obj[4] = t.getGia();
        obj[5] = new DonViTinh_DAO().getDonViTinhById(t.getDonViTinh().getMaDonViTinh()).getTen();
        obj[6] = t.getNsx();
        obj[7] = t.getHsd();
        obj[8] = t.getThue();
        return obj;
    }

    public String xuLyMa() {
        String xuatXu = (jcb_xuatXu.getSelectedItem() + "").substring(0, 2);
        String loai = (jcb_loaiThuoc.getSelectedItem() + "").substring(0, 2);
        String ma = xuatXu + loai + generateRandomString(6);
        return ma;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        loadThuoc = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableThuoc = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_timKiemTheoTen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtf_timKiemTheoMa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcb_locXuatXu = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jcb_locLoaiThuoc = new javax.swing.JComboBox<>();
        btn_loc = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jtf_maThuoc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtf_tenThuoc = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jtf_gia = new javax.swing.JTextField();
        jtf_tonKho = new javax.swing.JTextField();
        jtf_thue = new javax.swing.JTextField();
        btn_xoa = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xuatExcel = new javax.swing.JButton();
        btn_xoaTrang = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jtf_moTa = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jDate_nsx = new com.toedter.calendar.JDateChooser();
        jDate_hsd = new com.toedter.calendar.JDateChooser();
        jcb_xuatXu = new javax.swing.JComboBox<>();
        jcb_NCC = new javax.swing.JComboBox<>();
        jcb_loaiThuoc = new javax.swing.JComboBox<>();
        jcb_donVi = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(464, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bảng thông tin thuốc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N
        jPanel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        loadThuoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Thuoc/reload.png"))); // NOI18N
        loadThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadThuocActionPerformed(evt);
            }
        });

        tableThuoc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tableThuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên", "Loại ", "Xuất xứ", "Giá", "Đơn vị", "NSX", "HSD", "Thuế"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableThuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableThuocMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableThuoc);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loadThuoc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(loadThuoc)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(463, 463, 463))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(186, 186, 186)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 203, 640, 530));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Tìm kiếm theo tên");

        jtf_timKiemTheoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_timKiemTheoTenActionPerformed(evt);
            }
        });
        jtf_timKiemTheoTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_timKiemTheoTenKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Tìm kiếm theo mã");

        jtf_timKiemTheoMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_timKiemTheoMaActionPerformed(evt);
            }
        });
        jtf_timKiemTheoMa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_timKiemTheoMaKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Xuất xứ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Loại thuốc");

        btn_loc.setText("Lọc");
        btn_loc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_locActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_timKiemTheoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_timKiemTheoMa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcb_locXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcb_locLoaiThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_loc, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(265, 265, 265))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jtf_timKiemTheoMa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jtf_timKiemTheoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcb_locLoaiThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcb_locXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_loc, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 200));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin thuốc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(0, 102, 51));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Mã thuốc :");

        jtf_maThuoc.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Tên thuốc :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Đơn vị :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Giá :");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Tồn kho :");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Thuế :");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Xuất xứ :");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Ngày sản xuất :");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Hạn sử dụng :");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Nhà cung cấp :");

        jtf_gia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_giaActionPerformed(evt);
            }
        });

        btn_xoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_them.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xuatExcel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_xuatExcel.setText("Xuất excel");

        btn_xoaTrang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_xoaTrang.setText("Xóa trắng");
        btn_xoaTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaTrangActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Loại thuốc :");

        jtf_moTa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_moTaActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Mô tả :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(jtf_maThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(jtf_gia, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(jtf_tonKho, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(jtf_thue, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(jcb_xuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(jDate_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(jDate_hsd, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_xoaTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_xuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(129, 129, 129)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtf_moTa)
                            .addComponent(jcb_NCC, 0, 208, Short.MAX_VALUE)
                            .addComponent(jcb_loaiThuoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(123, 123, 123)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtf_tenThuoc)
                            .addComponent(jcb_donVi, 0, 208, Short.MAX_VALUE)))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtf_maThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtf_tenThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jcb_donVi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_gia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_tonKho, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_thue, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_xuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDate_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDate_hsd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcb_NCC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcb_loaiThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_moTa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_xoaTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 530, 670));
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_timKiemTheoMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_timKiemTheoMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_timKiemTheoMaActionPerformed

    private void jtf_timKiemTheoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_timKiemTheoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_timKiemTheoTenActionPerformed

    private void jtf_giaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_giaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_giaActionPerformed

    private void loadThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadThuocActionPerformed
        model.setRowCount(0);
        initTable();
    }//GEN-LAST:event_loadThuocActionPerformed

    private void jtf_moTaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_moTaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_moTaActionPerformed

    private void tableThuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableThuocMouseClicked
        int index = tableThuoc.getSelectedRow();
        String maThuoc = tableThuoc.getValueAt(index, 0) + "";
        System.out.println(maThuoc);
        Thuoc thuoc = thuoc_DAO.getThuoc(maThuoc);

        jtf_maThuoc.setText(thuoc.getMaThuoc());
        jtf_tenThuoc.setText(thuoc.getTenThuoc());
        jtf_gia.setText(String.valueOf(thuoc.getGia()));
        jtf_thue.setText(String.valueOf(thuoc.getThue()));
        jtf_tonKho.setText(String.valueOf(thuoc.getSoLuongTon()));
        jtf_moTa.setText(thuoc.getMota());
        jcb_loaiThuoc.setSelectedItem(new LoaiThuoc_DAO().getLoaiThuoc(thuoc.getLoaiThuoc().getMaLoai()).getMaLoai());
        jcb_xuatXu.setSelectedItem(new XuatXu_DAO().getXuatXuById(thuoc.getXuatXu().getMaXuatXu()).getMaXuatXu());
        jcb_donVi.setSelectedItem(new DonViTinh_DAO().getDonViTinhById(thuoc.getDonViTinh().getMaDonViTinh()).getMaDonViTinh());
        jcb_NCC.setSelectedItem(new NhaCungCap_DAO().getNhaCungCap(thuoc.getNcc().getMaNCC()).getMaNCC());

        System.out.println(xuLyMa());
        Date nsx = java.sql.Date.valueOf(thuoc.getNsx());
        nsx.setYear(nsx.getYear());
        jDate_nsx.setDate(nsx);

        Date hsd = java.sql.Date.valueOf(thuoc.getHsd());
        hsd.setYear(hsd.getYear());
        jDate_hsd.setDate(hsd);
    }//GEN-LAST:event_tableThuocMouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        String maThuoc = xuLyMa();
        String tenThuoc = jtf_tenThuoc.getText();
        double gia = Double.valueOf(jtf_gia.getText());
        LocalDate hsd = utilities.ConvertDate.convert(jDate_hsd.getDate());

        LocalDate nsx = utilities.ConvertDate.convert(jDate_nsx.getDate());
        double thue = Double.valueOf(jtf_thue.getText());
        int soLuongTon = Integer.valueOf(jtf_tonKho.getText());
        String mota = jtf_moTa.getText();
        LoaiThuoc maLoai = new LoaiThuoc(jcb_loaiThuoc.getSelectedItem() + "");
        XuatXu maXuatXu = new XuatXu(jcb_xuatXu.getSelectedItem() + "");
        DonViTinh maDonViTinh = new DonViTinh(jcb_donVi.getSelectedItem() + "");

        NhaCungCap maNCC = new NhaCungCap(jcb_NCC.getSelectedItem() + "");
        Thuoc thuoc = new Thuoc(maThuoc, tenThuoc, gia, hsd, nsx, thue, soLuongTon, mota, maLoai, maXuatXu, maDonViTinh, maNCC);
        if (thuoc_DAO.create(thuoc)) {
            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Thêm thuốc thành công!");
            Object[] obj = initObject(thuoc);
            model.addRow(obj);

        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Thêm thuốc thất bại!");

        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void jtf_timKiemTheoTenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_timKiemTheoTenKeyTyped
        model.setRowCount(0);

        List<Thuoc> listThuoc = thuoc_DAO.timKiemTheoTen(jtf_timKiemTheoTen.getText().trim());
        for (Thuoc t : listThuoc) {
            Object obj[] = initObject(t);
            model.addRow(obj);
        }
    }//GEN-LAST:event_jtf_timKiemTheoTenKeyTyped

    private void jtf_timKiemTheoMaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_timKiemTheoMaKeyTyped
        model.setRowCount(0);

        List<Thuoc> listThuoc = thuoc_DAO.timKiemTheoMa(jtf_timKiemTheoMa.getText().trim());
        for (Thuoc t : listThuoc) {
            Object obj[] = initObject(t);
            model.addRow(obj);
        }
    }//GEN-LAST:event_jtf_timKiemTheoMaKeyTyped

    private void btn_locActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_locActionPerformed
        model.setRowCount(0);
        ArrayList<Thuoc> listThuoc = thuoc_DAO.filter((jcb_locLoaiThuoc.getSelectedItem() + "").trim(), (jcb_locXuatXu.getSelectedItem() + "").trim(), jtf_timKiemTheoTen.getText().trim());
        for (Thuoc t : listThuoc) {
            Object[] obj = initObject(t);
            model.addRow(obj);
        }
    }//GEN-LAST:event_btn_locActionPerformed

    private void btn_xoaTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaTrangActionPerformed
        jtf_gia.setText("");
        jtf_maThuoc.setText("");
        jtf_moTa.setText("");
        jtf_tenThuoc.setText("");
        jtf_thue.setText("");
        jtf_timKiemTheoMa.setText("");
        jtf_timKiemTheoTen.setText("");
        jtf_tonKho.setText("");
    }//GEN-LAST:event_btn_xoaTrangActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        String maThuoc = jtf_maThuoc.getText();
        String tenThuoc = jtf_tenThuoc.getText();
        double gia = Double.valueOf(jtf_gia.getText());
        LocalDate hsd = utilities.ConvertDate.convert(jDate_hsd.getDate());

        LocalDate nsx = utilities.ConvertDate.convert(jDate_nsx.getDate());
        double thue = Double.valueOf(jtf_thue.getText());
        int soLuongTon = Integer.valueOf(jtf_tonKho.getText());
        String mota = jtf_moTa.getText();
        LoaiThuoc maLoai = new LoaiThuoc(jcb_loaiThuoc.getSelectedItem() + "");
        XuatXu maXuatXu = new XuatXu(jcb_xuatXu.getSelectedItem() + "");
        DonViTinh maDonViTinh = new DonViTinh(jcb_donVi.getSelectedItem() + "");

        NhaCungCap maNCC = new NhaCungCap(jcb_NCC.getSelectedItem() + "");
        Thuoc thuoc = new Thuoc(maThuoc, tenThuoc, gia, hsd, nsx, thue, soLuongTon, mota, maLoai, maXuatXu, maDonViTinh, maNCC);
        if (thuoc_DAO.suaThuoc(maThuoc, thuoc)) {
            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Sửa thông tin thuốc thành công!");
            model.insertRow(tableThuoc.getSelectedRow(), initObject(thuoc));
            model.removeRow(tableThuoc.getSelectedRow() + 1);
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Sửa thông tin thuốc thất bại!");
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        String maThuoc = jtf_maThuoc.getText();
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa thông tin của thuốc này", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            if (thuoc_DAO.Xoa(maThuoc)) {
                
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Xóa thông tin thuốc thành công");
                model.removeRow(tableThuoc.getSelectedRow());
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, "Xóa thông tin thuốc thất bại");

            }
        }

    }//GEN-LAST:event_btn_xoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_loc;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JButton btn_xoaTrang;
    private javax.swing.JButton btn_xuatExcel;
    private com.toedter.calendar.JDateChooser jDate_hsd;
    private com.toedter.calendar.JDateChooser jDate_nsx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcb_NCC;
    private javax.swing.JComboBox<String> jcb_donVi;
    private javax.swing.JComboBox<String> jcb_loaiThuoc;
    private javax.swing.JComboBox<String> jcb_locLoaiThuoc;
    private javax.swing.JComboBox<String> jcb_locXuatXu;
    private javax.swing.JComboBox<String> jcb_xuatXu;
    private javax.swing.JTextField jtf_gia;
    private javax.swing.JTextField jtf_maThuoc;
    private javax.swing.JTextField jtf_moTa;
    private javax.swing.JTextField jtf_tenThuoc;
    private javax.swing.JTextField jtf_thue;
    private javax.swing.JTextField jtf_timKiemTheoMa;
    private javax.swing.JTextField jtf_timKiemTheoTen;
    private javax.swing.JTextField jtf_tonKho;
    private javax.swing.JButton loadThuoc;
    private javax.swing.JTable tableThuoc;
    // End of variables declaration//GEN-END:variables
}
