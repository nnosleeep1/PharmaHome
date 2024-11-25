package dao;

import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Voucher;
import connect.ConnectDB;
import entity.ChiTietHoaDon;
import entity.DonViTinh;
import entity.LoaiThuoc;
import entity.NhaCungCap;
import entity.ThangVaDoanhThu;
import entity.Thuoc;
import entity.XuatXu;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.ConvertDate;

public class HoaDon_DAO {

    // Phương thức tạo mới một đối tượng HoaDon
    public Boolean create(HoaDon hoaDon) {
        int n = 0;

        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement("INSERT INTO HoaDon VALUES (?,?,?,?,?,?)");
            ps.setString(1, hoaDon.getMaHD());
            ps.setDate(2, java.sql.Date.valueOf(hoaDon.getNgayLap()));
            ps.setDouble(3, hoaDon.getTongTien());
            ps.setString(4, hoaDon.getNhanVien().getMaNhanVien());
            ps.setString(5, hoaDon.getKhachHang().getMaKH());

            ps.setString(6, hoaDon.getVoucher().getMaVoucher());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }

    // Phương thức lấy tất cả các đối tượng HoaDon
    public ArrayList<HoaDon> getAllHoaDon() {
        ArrayList<HoaDon> list = new ArrayList<>();

        try {
            ConnectDB.connect();
            String sql = "SELECT * FROM HoaDon";
            PreparedStatement ps = ConnectDB.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String maHD = rs.getString("maHD");
                LocalDate ngayLap = rs.getDate("ngayLap").toLocalDate();
                double tongTien = rs.getDouble("tongTien");

                String maVoucher = rs.getString("maVoucher");
                String maKhachHang = rs.getString("maKH");
                String maNhanVien = rs.getString("maNhanVien");

                Voucher voucher = new Voucher_DAO().getVoucher(maVoucher);  // Lấy thông tin Voucher
                KhachHang khachHang = new KhachHang_DAO().getKhachHang(maKhachHang); // Lấy thông tin khách hàng
                NhanVien nhanVien = new NhanVien_DAO().getNhanVien(maNhanVien); // Lấy thông tin nhân viên

                HoaDon hoaDon = new HoaDon(maHD, ngayLap, tongTien, voucher, khachHang, nhanVien);
                list.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Phương thức lấy một đối tượng HoaDon theo mã hóa đơn
    public HoaDon getHoaDon(String maHD) {
        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement("SELECT * FROM HoaDon WHERE maHD = ?");
            ps.setString(1, maHD);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                LocalDate ngayLap = rs.getDate("ngayLap").toLocalDate();
                double tongTien = rs.getDouble("tongTien");

                String maVoucher = rs.getString("maVoucher");
                String maKhachHang = rs.getString("maKH");
                String maNhanVien = rs.getString("maNhanVien");

                Voucher voucher = new Voucher_DAO().getVoucher(maVoucher);
                KhachHang khachHang = new KhachHang_DAO().getKhachHang(maKhachHang);
                NhanVien nhanVien = new NhanVien_DAO().getNhanVien(maNhanVien);

                return new HoaDon(maHD, ngayLap, tongTien, voucher, khachHang, nhanVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Phương thức cập nhật thông tin một đối tượng HoaDon
    public boolean suaHoaDon(String maHD, HoaDon newHoaDon) {
        int n = 0;
        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement(
                    "UPDATE HoaDon SET ngayLap = ?, tongTien = ?, maVoucher = ?, maKhachHang = ?, maNhanVien = ? WHERE maHD = ?");
            ps.setDate(1, java.sql.Date.valueOf(newHoaDon.getNgayLap()));
            ps.setDouble(2, newHoaDon.getTongTien());
            ps.setString(3, newHoaDon.getVoucher().getMaVoucher());
            ps.setString(4, newHoaDon.getKhachHang().getMaKH());
            ps.setString(5, newHoaDon.getNhanVien().getMaNhanVien());
            ps.setString(6, maHD);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }

    // Phương thức xóa một đối tượng HoaDon
    public boolean deleteHoaDon(String maHD) {
        int n = 0;
        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement("DELETE FROM HoaDon WHERE maHD = ?");
            ps.setString(1, maHD);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }

    // Phương thức lấy số lượng hóa đơn
    public int getSize() {
        int n = 0;
        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement("SELECT COUNT(*) AS total FROM HoaDon");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                n = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public ArrayList<ChiTietHoaDon> getChiTietHoaDon(String maHD) {
        ArrayList<ChiTietHoaDon> listCTHD = new ArrayList<>();
        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement("SELECT * FROM ChiTietHoaDon WHERE maHD = ?");
            ps.setString(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maThuoc = rs.getString("maThuoc");
                int soLuong = rs.getInt("soLuong");
                double donGia = rs.getDouble("donGia");
                ChiTietHoaDon cthd = new ChiTietHoaDon(soLuong, donGia, new Thuoc_DAO().getThuoc(maThuoc), new HoaDon_DAO().getHoaDon(maHD));
                listCTHD.add(cthd);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCTHD;
    }

    public ArrayList<ThangVaDoanhThu> getDoanhThuTheoThang(int nam) {
        ArrayList<ThangVaDoanhThu> topThuocList = new ArrayList<>();

        try {
            // SQL query to get total revenue per month for the specified year
            String sql = "SELECT MONTH(ngayLap) AS Thang, SUM(tongTien) AS TongTien "
                    + "FROM HoaDon "
                    + "WHERE YEAR(ngayLap) = ? "
                    + "GROUP BY MONTH(ngayLap) "
                    + "ORDER BY MONTH(ngayLap)";  // Order by month

            PreparedStatement ps = ConnectDB.conn.prepareStatement(sql);
            ps.setInt(1, nam); // Set the year parameter (it should be an integer, not a date)

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int thang = rs.getInt("Thang"); // Retrieve the month
                double tongTien = rs.getDouble("TongTien"); // Retrieve total revenue

                // Assuming you want to get the medicine for the corresponding month, 
                // you might need to fetch it based on your application logic.
                // For this example, I'll leave it as is. Adjust as needed.
                // Method to retrieve medicine data
                ThangVaDoanhThu thuocDoanhThu = new ThangVaDoanhThu(thang, tongTien);
                topThuocList.add(thuocDoanhThu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return topThuocList;
    }

    public ArrayList<ThangVaDoanhThu> getDoanhThuTheoNgay(int thang, int nam) {
        ArrayList<ThangVaDoanhThu> dailyRevenueList = new ArrayList<>();

        try {
            // SQL query to get total revenue per day for the specified month and year
            String sql = "SELECT DAY(ngayLap) AS Ngay, SUM(tongTien) AS TongTien "
                    + "FROM HoaDon "
                    + "WHERE MONTH(ngayLap) = ? AND YEAR(ngayLap) = ? "
                    + "GROUP BY DAY(ngayLap) "
                    + "ORDER BY DAY(ngayLap)";  // Order by day

            PreparedStatement ps = ConnectDB.conn.prepareStatement(sql);
            ps.setInt(1, thang); // Set the month parameter
            ps.setInt(2, nam);   // Set the year parameter

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ngay = rs.getInt("Ngay");           // Retrieve the day
                double tongTien = rs.getDouble("TongTien"); // Retrieve total revenue for that day

                // Create a NgayVaDoanhThu object to store daily revenue
                ThangVaDoanhThu dailyRevenue = new ThangVaDoanhThu(ngay, tongTien);
                dailyRevenueList.add(dailyRevenue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dailyRevenueList;
    }

    public int getSizeOfMonth(int month, int year) {
        int count = 0;
        String query = "SELECT COUNT(*) AS total FROM HoaDon WHERE MONTH(ngayLap) = ? AND YEAR(ngayLap) = ?";
        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement(query);
            ps.setInt(1, month);  // Set the month parameter
            ps.setInt(2, year);   // Set the year parameter
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getSizeHoaDonTheoNgay(int day, int month, int year) {
        int count = 0;
        String query = "SELECT COUNT(*) AS total FROM HoaDon WHERE DAY(ngayLap) = ? AND MONTH(ngayLap) = ? AND YEAR(ngayLap) = ?";
        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement(query);
            ps.setInt(1, day);    // Set the day parameter
            ps.setInt(2, month);  // Set the month parameter
            ps.setInt(3, year);   // Set the year parameter
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    ArrayList<HoaDon> getTatCaHoaDonTrongKetToan(String maKetToan) {
        ArrayList<HoaDon> kq = new ArrayList<>();
        try {
            String sql = "SELECT * FROM HoaDon WHERE maKetToan = ?";
            PreparedStatement preparedStatement = ConnectDB.conn.prepareStatement(sql);
            preparedStatement.setString(1, maKetToan);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String maHoaDon = resultSet.getString("maHD");
                LocalDate ngayLap = ConvertDate.convert(resultSet.getDate("ngayLap"));
                Double tongTien = resultSet.getDouble("tongTien");
                String maNV = resultSet.getString("maNhanVien");
                String maKH = resultSet.getString("maKhachHang");
                String maVoucher = resultSet.getString("maVoucher");
                boolean atm = resultSet.getBoolean("atm");
                Double tienDaDua = resultSet.getDouble("tienDaDua");
                HoaDon hoaDon = null;
                if (maVoucher != null) {
                    hoaDon = new HoaDon(maHoaDon, ngayLap, tongTien, new Voucher_DAO().getVoucher(maVoucher), new KhachHang_DAO().getKhachHang(maKH), new NhanVien_DAO().getNhanVien(maNV), new ChiTietHoaDon_DAO().getAllChiTietHoaDon(), atm, tienDaDua);
                } else {
                    hoaDon = new HoaDon(maHoaDon, ngayLap, tongTien, new Voucher_DAO().getVoucher(maVoucher), new KhachHang_DAO().getKhachHang(maKH), new NhanVien_DAO().getNhanVien(maNV), new ChiTietHoaDon_DAO().getAllChiTietHoaDon(), atm, tienDaDua);
                }

                kq.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public ArrayList<HoaDon> filter(String maHD, String sdt, double doanhThu, LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        ArrayList<HoaDon> list = new ArrayList<>();

        try {
            int index = 1;
            StringBuilder query = new StringBuilder("SELECT maHD,nv.tenNhanVien,kh.sdt,ngayLap,tongTien,maVoucher,hd.maKH,hd.maNhanVien from HoaDon hd "
                    + "JOIN NhanVien nv ON nv.maNhanVien = hd.maNhanVien "
                    + "JOIN KhachHang kh ON kh.maKhachHang = hd.maKH WHERE 1=1 ");

            if (!maHD.equalsIgnoreCase("")) {
                query.append("AND maHD = ? ");
            }
            if (!sdt.equalsIgnoreCase("")) {
                query.append("AND kh.sdt = ? ");
            }
            if (doanhThu != 0) {
                query.append("AND tongTien > ? ");
            }
            if (ngayBatDau != null && ngayKetThuc != null) {
                query.append("AND ngayLap > ? and ngayLap < ? ");
            }

            PreparedStatement ps = ConnectDB.conn.prepareStatement(query.toString());
            System.out.println(query);

            if (!maHD.equalsIgnoreCase("")) {
                ps.setString(index++, maHD);
            }
            if (!sdt.equalsIgnoreCase("")) {
                ps.setString(index++, sdt);
            }
            if (doanhThu > 0) {
                ps.setDouble(index++, doanhThu);
            }
            if (ngayBatDau != null && ngayKetThuc != null) {
                ps.setDate(index++, Date.valueOf(ngayBatDau));
                ps.setDate(index++, Date.valueOf(ngayKetThuc));
            }

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String maHoaDon = resultSet.getString("maHD");
                LocalDate ngayLap = ConvertDate.convert(resultSet.getDate("ngayLap"));
                Double tongTien = resultSet.getDouble("tongTien");
                String maNV = resultSet.getString("maNhanVien");
                String maKH = resultSet.getString("maKH");
                String maVoucher = resultSet.getString("maVoucher");
                HoaDon hoaDon = null;
                if (maVoucher != null) {
                    hoaDon = new HoaDon(maHoaDon, ngayLap, tongTien, new Voucher_DAO().getVoucher(maVoucher), new KhachHang_DAO().getKhachHang(maKH), new NhanVien_DAO().getNhanVien(maNV), this.getChiTietHoaDon(maHD));
                } else {
                    hoaDon = new HoaDon(maHoaDon, ngayLap, tongTien, new Voucher_DAO().getVoucher(maVoucher), new KhachHang_DAO().getKhachHang(maKH), new NhanVien_DAO().getNhanVien(maNV), this.getChiTietHoaDon(maHD));
                }
                list.add(hoaDon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Thuoc_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int getSoLuongKhachHangNam(int year) {
        int count = 0;
        String query = "select count(maKH) as soKhachHang from HoaDon where year(ngayLap) =?";
        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement(query);
            ps.setInt(1, year);  // Set the month parameter
            // Set the year parameter
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("soKhachHang");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getSoLuongKhachHangThang(int month, int year) {
        int count = 0;
        String query = "select count(maKH) as soKhachHang from HoaDon where month(ngayLap)=? and year(ngayLap) =?";
        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement(query);
            ps.setInt(1, month);
            ps.setInt(2, year);// Set the month parameter
            // Set the year parameter
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("soKhachHang");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public double getDoanhThuCuaNam(int year) {
        double count = 0;
        String query = "SELECT SUM(tongTien) AS doanhthu "
                + "FROM hoadon "
                + "WHERE  YEAR(ngayLap) = ?";
        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement(query);
            ps.setInt(1, year);  // Set the month parameter

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getDouble("doanhthu");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }



    public int getSoLuongKhachHangNgay(int day, int month, int year) {
        int count = 0;
        String query = "select count(maKH) as soKhachHang from HoaDon where day(ngayLap)=? and month(ngayLap)=? and year(ngayLap) =?";
        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement(query);
            ps.setInt(1, day);
            ps.setInt(2, month);
            ps.setInt(3, year);// Set the month parameter
            // Set the year parameter
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("soKhachHang");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getSizeOfYear(int year) {
        int count = 0;
        String query = "SELECT COUNT(*) AS total FROM HoaDon WHERE  YEAR(ngayLap) = ?";
        try {
            PreparedStatement ps = ConnectDB.conn.prepareStatement(query);
            ps.setInt(1, year);  // Set the month parameter
            // Set the year parameter
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }



}
