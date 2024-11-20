/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Lenovo
 */
import entity.Thuoc;
import connect.ConnectDB;
import entity.DonViTinh;
import entity.GiamGia;
import entity.LoaiThuoc;
import entity.NhaCungCap;
import entity.XuatXu;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;


public class Thuoc_DAO {

    // Phương thức tạo mới một đối tượng Thuoc
    public Boolean create(Thuoc thuoc) {
        int n = 0;

        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement("INSERT INTO Thuoc VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, thuoc.getMaThuoc());
            ps.setString(2, thuoc.getTenThuoc());
            ps.setDouble(3, thuoc.getGia());
            ps.setDate(4, java.sql.Date.valueOf(thuoc.getHsd()));
            ps.setDate(5, java.sql.Date.valueOf(thuoc.getNsx()));
            ps.setDouble(6, thuoc.getThue());
            ps.setInt(7, thuoc.getSoLuongTon());
            ps.setString(8, thuoc.getMota());
            ps.setString(9, thuoc.getLoaiThuoc().getMaLoai());
            ps.setString(10, thuoc.getXuatXu().getMaXuatXu());
            ps.setString(11, thuoc.getDonViTinh().getMaDonViTinh());
            ps.setString(12, thuoc.getNcc().getMaNCC()); // Giả sử NhaCungCap có phương thức getMaNhaCungCap()
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }

    // Phương thức lấy tất cả các đối tượng Thuoc
    public ArrayList<Thuoc> getAllThuoc() {
        ArrayList<Thuoc> list = new ArrayList<>();

        try {
            ConnectDB.connect();
            String sql = "SELECT * FROM Thuoc";
            PreparedStatement ps = ConnectDB.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String maThuoc = rs.getString("maThuoc");
                String tenThuoc = rs.getString("tenThuoc");
                double gia = rs.getDouble("gia");

                Date hsdDate = rs.getDate("hsd");
                LocalDate hsd = (hsdDate != null) ? hsdDate.toLocalDate() : null;
                System.out.println(hsd);

                Date nsxDate = rs.getDate("nsx");
                LocalDate nsx = (nsxDate != null) ? nsxDate.toLocalDate() : null;

                double thue = rs.getDouble("thue");
                int soLuongTon = rs.getInt("soLuongTon");
                String mota = rs.getString("mota");

                LoaiThuoc maLoai = new LoaiThuoc(rs.getString("maLoai"));
                XuatXu maXuatXu = new XuatXu(rs.getString("maXuatXu"));
                DonViTinh maDonViTinh = new DonViTinh(rs.getString("maDonViTinh"));

                NhaCungCap maNCC = new NhaCungCap(rs.getString("maNCC"));
                Thuoc thuoc = new Thuoc(maThuoc, tenThuoc, gia, hsd, nsx, thue, soLuongTon, mota, maLoai, maXuatXu, maDonViTinh, maNCC);
                list.add(thuoc);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Phương thức lấy một đối tượng Thuoc theo mã thuốc
    public Thuoc getThuoc(String mt) {
        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement("SELECT * FROM Thuoc WHERE maThuoc = ?");
            ps.setString(1, mt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maThuoc = rs.getString("maThuoc");
                String tenThuoc = rs.getString("tenThuoc");
                double gia = rs.getDouble("gia");

                Date hsdDate = rs.getDate("hsd");
                LocalDate hsd = (hsdDate != null) ? hsdDate.toLocalDate() : null;
                System.out.println(hsd);

                Date nsxDate = rs.getDate("nsx");
                LocalDate nsx = (nsxDate != null) ? nsxDate.toLocalDate() : null;

                double thue = rs.getDouble("thue");
                int soLuongTon = rs.getInt("soLuongTon");
                String mota = rs.getString("mota");

                LoaiThuoc maLoai = new LoaiThuoc(rs.getString("maLoai"));
                XuatXu maXuatXu = new XuatXu(rs.getString("maXuatXu"));
                DonViTinh maDonViTinh = new DonViTinh(rs.getString("maDonViTinh"));

                NhaCungCap maNCC = new NhaCungCap(rs.getString("maNCC"));
                Thuoc thuoc = new Thuoc(maThuoc, tenThuoc, gia, hsd, nsx, thue, soLuongTon, mota, maLoai, maXuatXu, maDonViTinh, maNCC);
                return thuoc;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Phương thức cập nhật thông tin một đối tượng Thuoc
    public boolean suaThuoc(String maThuoc, Thuoc newThuoc) {
        int n = 0;
        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement(
                    "UPDATE Thuoc SET tenThuoc = ?, gia = ?, hsd = ?, nsx = ?, thue = ?, soLuongTon = ?, mota = ?, maLoai = ?, maXuatXu = ?, maNCC = ? WHERE maThuoc = ?");
            ps.setString(1, newThuoc.getTenThuoc());
            ps.setDouble(2, newThuoc.getGia());
            ps.setDate(3, java.sql.Date.valueOf(newThuoc.getHsd()));
            ps.setDate(4, java.sql.Date.valueOf(newThuoc.getNsx()));
            ps.setDouble(5, newThuoc.getThue());
            ps.setInt(6, newThuoc.getSoLuongTon());
            ps.setString(7, newThuoc.getMota());
            ps.setString(8, newThuoc.getLoaiThuoc().getMaLoai()); // Giả sử LoaiThuoc có phương thức getMaLoai()
            ps.setString(9, newThuoc.getXuatXu().getMaXuatXu()); // Giả sử XuatXu có phương thức getMaXuatXu()
            ps.setString(10, newThuoc.getNcc().getMaNCC()); // Giả sử NhaCungCap có phương thức getMaNhaCungCap()
            ps.setString(11, maThuoc);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }

    // Phương thức lấy số lượng thuốc
    public int getSize() {
        int n = 0;
        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement("SELECT COUNT(*) AS total FROM Thuoc");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                n = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    // Phương thức tìm kiếm thuốc theo mã
    public ArrayList<Thuoc> timKiemTheoMa(String ma) {
        ArrayList<Thuoc> list = new ArrayList<>();
        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement("SELECT * FROM Thuoc WHERE maThuoc LIKE ?");
            ps.setString(1, "%" + ma + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maThuoc = rs.getString("maThuoc");
                String tenThuoc = rs.getString("tenThuoc");
                double gia = rs.getDouble("gia");

                Date hsdDate = rs.getDate("hsd");
                LocalDate hsd = (hsdDate != null) ? hsdDate.toLocalDate() : null;
                System.out.println(hsd);

                Date nsxDate = rs.getDate("nsx");
                LocalDate nsx = (nsxDate != null) ? nsxDate.toLocalDate() : null;

                double thue = rs.getDouble("thue");
                int soLuongTon = rs.getInt("soLuongTon");
                String mota = rs.getString("mota");

                LoaiThuoc maLoai = new LoaiThuoc(rs.getString("maLoai"));
                XuatXu maXuatXu = new XuatXu(rs.getString("maXuatXu"));
                DonViTinh maDonViTinh = new DonViTinh(rs.getString("maDonViTinh"));

                NhaCungCap maNCC = new NhaCungCap(rs.getString("maNCC"));
                Thuoc thuoc = new Thuoc(maThuoc, tenThuoc, gia, hsd, nsx, thue, soLuongTon, mota, maLoai, maXuatXu, maDonViTinh, maNCC);
                list.add(thuoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean Xoa(String maThuoc) {
        int n = 0;
        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement("Delete FROM Thuoc WHERE maThuoc = ?");
            ps.setString(1, maThuoc);
            n = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }

    // Phương thức tìm kiếm thuốc theo tên
    public ArrayList<Thuoc> timKiemTheoTen(String ten) {
        ArrayList<Thuoc> list = new ArrayList<>();
        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement("SELECT * FROM Thuoc WHERE tenThuoc LIKE ?");
            ps.setString(1, "%" + ten + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maThuoc = rs.getString("maThuoc");
                String tenThuoc = rs.getString("tenThuoc");
                double gia = rs.getDouble("gia");
                Date hsd = rs.getDate("hsd");
                Date nsx = rs.getDate("nsx");
                double thue = rs.getDouble("thue");
                int soLuongTon = rs.getInt("soLuongTon");
                String mota = rs.getString("mota");
                LoaiThuoc maLoai = new LoaiThuoc(rs.getString("maLoai"));
                XuatXu maXuatXu = new XuatXu(rs.getString("maXuatXu"));
                DonViTinh maDonViTinh = new DonViTinh(rs.getString("maDonViTinh"));

                NhaCungCap maNCC = new NhaCungCap(rs.getString("maNCC"));
                Thuoc thuoc = new Thuoc(maThuoc, tenThuoc, gia, hsd.toLocalDate(), nsx.toLocalDate(), thue, soLuongTon, mota, maLoai, maXuatXu, maDonViTinh, maNCC);
                list.add(thuoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Thuoc> filter(String loaiThuoc, String xuatXu, String ten) {
        ArrayList<Thuoc> list = new ArrayList<>();

        try {
            int index = 1;
            StringBuilder query = new StringBuilder("SELECT t.maThuoc,t.tenThuoc,gia,hsd,nsx,soLuongTon,moTa,t.maLoai,t.maLoai,xx.maXuatXu,maDonViTinh,maNCC,thue FROM Thuoc t "
                    + "JOIN XuatXu xx ON t.maXuatXu = xx.maXuatXu "
                    + "JOIN LoaiThuoc lt ON lt.maLoai = t.maLoai WHERE 1=1 ");

            if (ten.length() > 0) {
                query.append("AND tenThuoc LIKE ? ");
            }
            if (xuatXu.length() > 0 && !xuatXu.equalsIgnoreCase("Tất cả")) {
                query.append("AND tenXuatXu = ? ");
            }
            if (loaiThuoc.length() > 0 && !loaiThuoc.equalsIgnoreCase("Tất cả")) {
                query.append("AND tenLoai = ? ");
            }

            PreparedStatement ps = ConnectDB.conn.prepareStatement(query.toString());

            if (ten.length() > 0) {
                ps.setString(index++, "%" + ten + "%");
            }
            if (xuatXu.length() > 0 && !xuatXu.equalsIgnoreCase("Tất cả")) {
                ps.setString(index++, xuatXu);
            }
            if (loaiThuoc.length() > 0 && !loaiThuoc.equalsIgnoreCase("Tất cả")) {
                ps.setString(index++, loaiThuoc);
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maThuoc = rs.getString("maThuoc");
                String tenThuoc = rs.getString("tenThuoc");
                double gia = rs.getDouble("gia");
                Date hsd = rs.getDate("hsd");
                Date nsx = rs.getDate("nsx");
                double thue = rs.getDouble("thue");
                int soLuongTon = rs.getInt("soLuongTon");
                String mota = rs.getString("mota");
                LoaiThuoc maLoai = new LoaiThuoc(rs.getString("maLoai"));
                XuatXu maXuatXu = new XuatXu(rs.getString("maXuatXu"));
                DonViTinh maDonViTinh = new DonViTinh(rs.getString("maDonViTinh"));
                NhaCungCap maNCC = new NhaCungCap(rs.getString("maNCC"));

                Thuoc thuoc = new Thuoc(maThuoc, tenThuoc, gia, hsd.toLocalDate(), nsx.toLocalDate(), thue, soLuongTon, mota, maLoai, maXuatXu, maDonViTinh, maNCC);
                list.add(thuoc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Thuoc_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Thuoc> getThuocHetHan() {
        ArrayList<Thuoc> list = new ArrayList<>();
        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement("SELECT * FROM Thuoc WHERE hsd <= getDate()");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maThuoc = rs.getString("maThuoc");
                String tenThuoc = rs.getString("tenThuoc");
                double gia = rs.getDouble("gia");
                Date hsd = rs.getDate("hsd");
                Date nsx = rs.getDate("nsx");
                double thue = rs.getDouble("thue");
                int soLuongTon = rs.getInt("soLuongTon");
                String mota = rs.getString("mota");
                LoaiThuoc maLoai = new LoaiThuoc(rs.getString("maLoai"));
                XuatXu maXuatXu = new XuatXu(rs.getString("maXuatXu"));
                DonViTinh maDonViTinh = new DonViTinh(rs.getString("maDonViTinh"));

                NhaCungCap maNCC = new NhaCungCap(rs.getString("maNCC"));
                Thuoc thuoc = new Thuoc(maThuoc, tenThuoc, gia, hsd.toLocalDate(), nsx.toLocalDate(), thue, soLuongTon, mota, maLoai, maXuatXu, maDonViTinh, maNCC);
                list.add(thuoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean capNhatSoLuong(Thuoc t, int soLuong) {
        int n = 0;
        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement(
                    "UPDATE Thuoc SET soLuongTon = ? WHERE maThuoc = ?");
            ps.setString(1, "soLuongTon - " + soLuong);
            ps.setString(2, t.getMaThuoc());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }
}
