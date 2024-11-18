/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.ConnectDB;
import entity.ChiTietDoiTra;
import entity.DoiTra;
import entity.HoaDon;
import entity.NhanVien;
import enums.TrangThaiDoiTra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HÀ NHƯ
 */
public class DoiTra_DAO {
    
    public static String getMaxSequence(String prefix) {
        try {
        prefix += "%";
        String sql = "  SELECT TOP 1  * FROM HoaDonDoiTra WHERE maHoaDonDoiTra LIKE '"+prefix+"' ORDER BY maHoaDonDoiTra DESC;";
        PreparedStatement st = ConnectDB.conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            String maHDDT = rs.getString("maHoaDonDoiTra");
            return maHDDT;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
    }

    
//    @Override
    public DoiTra getOne(String id) {
        DoiTra returnOrder = null;
        try {
            PreparedStatement st = ConnectDB.conn.prepareStatement("SELECT * FROM HoaDonDoiTra WHERE maHoaDonDoiTra = ?");
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {                
                String maHDDT = rs.getString("maHoaDon");
                boolean loai = rs.getBoolean("loaiDoiTra");
                int trangThai = rs.getInt("trangThai");
                Date ngayDT = rs.getDate("ngayDoiTra");
                String maNV = rs.getString("maNhanVien");
                double tienTra = rs.getDouble("soTienTra");
                String liDo = rs.getString("moTa");
                HoaDon hoaDon = new HoaDon_DAO().getHoaDon(maNV);
                NhanVien nhVien = new NhanVien_DAO().getNhanVien(maNV);
                ArrayList<ChiTietDoiTra> listDetail = getAllReturnOrderDetail(maHDDT);
                returnOrder = new DoiTra(ngayDT, TrangThaiDoiTra.CANCEL, maHDDT, nhVien, hoaDon, loai, tienTra, listDetail, liDo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnOrder;
    }

//    @Override
    public ArrayList<DoiTra> getAll() {
        ArrayList<DoiTra> result = new ArrayList<>();
        try {
            Statement st = ConnectDB.conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM HoaDonDoiTra");
            
            while (rs.next()) {                
                String maHDDT = rs.getString("maHoaDonDoiTra");
                String maHD = rs.getString("maHoaDon");
                int trangThai = rs.getInt("trangThai");
                Date ngayDT = rs.getDate("ngayDoiTra");
                String maNV = rs.getString("maNhanVien");
                boolean loai = rs.getBoolean("loaiDoiTra");
                double tienTra = rs.getDouble("soTienTra");
                String liDo = rs.getString("moTa");
                HoaDon hoaDon = new HoaDon(maHD);
                NhanVien nhVien = new NhanVien(maNV);
                ArrayList<ChiTietDoiTra> listDetail = getAllReturnOrderDetail(maHDDT);
                DoiTra returnOrder = new DoiTra(ngayDT, TrangThaiDoiTra.CANCEL, maHDDT, nhVien, hoaDon, loai, tienTra, listDetail, liDo);

                result.add(returnOrder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Boolean create(DoiTra doiTra) {
        int n = 0;
        try {
            PreparedStatement st = ConnectDB.conn.prepareStatement("INSERT INTO HoaDonDoiTra(maHoaDonDoiTra, maHoaDon, trangThai, ngayDoiTra, maNhanVien, loaiDoiTra, soTienTra, moTa) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"); 
            st.setString(1, doiTra.getMaHDDT());
            st.setString(2, doiTra.getHoaDon().getMaHD());
            st.setInt(3, doiTra.getTrangThai().getValue());
            st.setDate(4, new java.sql.Date(doiTra.getNgayDoiTra().getTime()));
            st.setString(5, doiTra.getNhanvien().getMaNhanVien());
            st.setBoolean(6, doiTra.isLoai());
            st.setDouble(7, doiTra.getTienTra());
            st.setString(8, doiTra.getLiDO());
            n = st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n > 0;
    }

//    @Override
    public Boolean update(String id, DoiTra doiTra) {
        int n = 0;
        try {
            PreparedStatement st = ConnectDB.conn.prepareStatement("UPDATE HoaDonDoiTra "
                    + "SET trangThai = ?, ngayDoiTra = ? "
                    + "WHERE maHoaDonDoiTra = ?"); 
            int i = 1;
            st.setInt(i++, doiTra.getTrangThai().getValue());
            st.setDate(i++, new java.sql.Date(doiTra.getNgayDoiTra().getTime()));
            st.setString(i++, id);
            n = st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n > 0;
    }

    public static ArrayList<ChiTietDoiTra> getAllReturnOrderDetail(String maHDDT) {
        return new ChiTietDoiTra_DAO().getAllForOrderReturnID(maHDDT);
    }

    public ArrayList<DoiTra> findById(String returnOrderID) {
        ArrayList<DoiTra> result = new ArrayList<>();
        String query = """
                       SELECT * FROM HoaDonDoiTra
                       where maHoaDonDoiTra LIKE ?
                       """;
        try {

            PreparedStatement st = ConnectDB.conn.prepareStatement(query);
            st.setString(1, returnOrderID + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (rs != null) {
                    result.add(getReturnOrderData(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private DoiTra getReturnOrderData(ResultSet rs) throws SQLException {
        DoiTra result = null;
        try {
            //Lấy thông tin tổng quát của lớp ReturnOrder
            String maHDDT = rs.getString("maHoaDonDoiTra");
            boolean loai = rs.getBoolean("loaiDoiTra");
            int trangThai = rs.getInt("trangThai");
            Date ngayDT = rs.getDate("ngayDoiTra");
            String maHD = rs.getString("maHoaDon");
            String maNV = rs.getString("maNhanVien");
            double tienTra = rs.getDouble("soTienTra");
            String liDo = rs.getString("moTa");
            HoaDon hoaDon = new HoaDon(maHD);
            NhanVien nhanVien = new NhanVien(maNV);
            ArrayList<ChiTietDoiTra> listDetail = getAllReturnOrderDetail(maHDDT);
            result = new DoiTra(ngayDT, TrangThaiDoiTra.fromInt(trangThai), maHDDT, nhanVien, hoaDon, loai, tienTra, listDetail, liDo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    public ArrayList<DoiTra> filter(int type, int status) {
        ArrayList<DoiTra> result = new ArrayList<>();
//        Index tự động tăng phụ thuộc vào số lượng biến số có
        int index = 1;
        String query = "select * from HoaDonDoiTra WHERE maHoaDonDoiTra like '%'";
//        Xét loại đơn đổi trả
        if (type != 0)
            query += " and type = ?";
//            Xét trạng thái 
        if (status != 0)
            query += " and status = ?";
        try {
            PreparedStatement st = ConnectDB.conn.prepareStatement(query);
            if(type == 1)
                st.setInt(index++, 0);
            else if(type == 2)
                st.setInt(index++, 1);
            if(status == 1)
                st.setInt(index++, 0);
            else if(status == 2)
                st.setInt(index++, 1);
            else if(status == 3)
                st.setInt(index++, 2);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (rs != null) {
                    result.add(getReturnOrderData(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public int getNumberOfReturnOrderInMonth(int month, int year){
        int result=0;


        try {
            PreparedStatement st = ConnectDB.conn.prepareStatement("select count(maHoaDonDoiTra) as sl from [HoaDonDoiTra] where YEAR(ngayDoiTra) = ? and Month(ngayDoiTra) = ? ");
            st.setInt(1, year);
            st.setInt(2, month);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int sl = rs.getInt("sl");
                result=sl;

                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    public double getTotalReturnOrderInMonth(int month, int year) {
        double result = 0;

        try {
            PreparedStatement st = ConnectDB.conn.prepareStatement("select sum(soTienTra) as total from [HoaDonDoiTra] join [HoaDon] on [HoaDon].maHD=HoaDonDoiTra.maHoaDOn where YEAR(ngayLap) = ? and Month(ngayLap) = ? and [HoaDonDoiTra].trangThai=1");
            st.setInt(1, year);
            st.setInt(2, month);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                double total = rs.getDouble("total");
                result = total;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static DoiTra getOneForOrderID(String maHD) {
        DoiTra doiTra = null;
        try {
            PreparedStatement st = ConnectDB.conn.prepareStatement("SELECT * FROM HoaDonDoiTra WHERE maHoaDon = ?");
            st.setString(1, maHD);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {                
                String maHDDT = rs.getString("maHoaDonDoiTra");
                boolean loai = rs.getBoolean("loaiDoiTra");
                int trangThai = rs.getInt("trangThai");
                Date ngayDT = rs.getDate("ngayDoiTra");
                String nhanVien = rs.getString("maNhanVien");
                double tienTra = rs.getDouble("soTienTra");
                String liDo = rs.getString("moTa");
                HoaDon hoaDon = new HoaDon_DAO().getHoaDon(maHDDT);
                NhanVien nhVien = new NhanVien(maHDDT);
                ArrayList<ChiTietDoiTra> listDetail = getAllReturnOrderDetail(maHDDT);
                doiTra = new DoiTra(ngayDT, TrangThaiDoiTra.fromInt(trangThai), maHDDT, nhVien, hoaDon, loai, tienTra, listDetail, liDo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doiTra;
    }
   
}
