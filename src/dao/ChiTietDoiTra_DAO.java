/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.ConnectDB;
import entity.ChiTietDoiTra;
import entity.DoiTra;
import entity.Thuoc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HÀ NHƯ
 */
public class ChiTietDoiTra_DAO implements DAOBase<ChiTietDoiTra>{

    public ChiTietDoiTra getOne(String maHDDT, String maThuoc) {
        ChiTietDoiTra chiTietDoiTra = null;
        try {
            PreparedStatement st = ConnectDB.conn.prepareStatement("SELECT * FROM ChiTietDoiTra "
                    + "WHERE maHoaDonDoiTra = ? AND maThuoc = ?");
            st.setString(1, maHDDT);
            st.setString(2, maThuoc);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                maHDDT = rs.getString("maHoaDonDoiTra");
                maThuoc = rs.getString("maThuoc");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("donGia");
                DoiTra doiTra = new DoiTra(maHDDT);
                Thuoc product = new Thuoc(maThuoc);
                chiTietDoiTra = new ChiTietDoiTra(doiTra, product, soLuong, gia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietDoiTra;
    }

//    @Override
    public ArrayList<ChiTietDoiTra> getAll() {
        ArrayList result = new ArrayList<>();
        try {
            Statement st = ConnectDB.conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ChiTietDoiTra");
            
            while (rs.next()) {                
                String maHDDT = rs.getString("maHoaDonDoiTra");
                String maThuoc = rs.getString("maThuoc");
                int soLuong = rs.getInt("soLuong");
                DoiTra doiTra = new DoiTra(maHDDT);
                Thuoc thuoc = new Thuoc(maThuoc);
                ChiTietDoiTra chiTietDoiTra = new ChiTietDoiTra(doiTra, thuoc, soLuong, thuoc.getGia());
                result.add(chiTietDoiTra);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Boolean create(ChiTietDoiTra chiTietDoiTra) {
        int n = 0;
        try {
            PreparedStatement st = ConnectDB.conn.prepareStatement("INSERT INTO ChiTietDoiTra(maHoaDonDoiTra, maThuoc, soLuong, donGia)  "
                    + "VALUES (?,?, ?, ?)");
            st.setString(1, chiTietDoiTra.getDoiTra().getMaHDDT());
            st.setString(2, chiTietDoiTra.getSanPham().getMaThuoc());
            st.setInt(3, chiTietDoiTra.getSoLuong());
            st.setDouble(4, chiTietDoiTra.getGia());
            n = st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n > 0;
    }
    public Boolean updateProduct(String id, int soLuong) {
        int n = 0;
        Thuoc product = new Thuoc_DAO().getThuoc(id);
        int newSoluong = product.getSoLuongTon()- soLuong;
        try {
            PreparedStatement st = ConnectDB.conn.prepareStatement("UPDATE Thuoc "
                    + "SET soLuongTon = ? "
                    + "WHERE maThuoc = ?");
            st.setInt(1, newSoluong);
            st.setString(2, id);
            n = st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n > 0;
    }
    public Boolean updateRefund(ChiTietDoiTra chiTietDoiTra) {
        int n = 0;
        
        return n > 0;
    }
    public ArrayList<ChiTietDoiTra> getAllForOrderReturnID(String id) {
        ArrayList result = new ArrayList<>();
        try {
            PreparedStatement st = ConnectDB.conn.prepareStatement("SELECT * FROM ChiTietDoiTra "
                    + "WHERE maHoaDonDoiTra = ?");
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maThuoc = rs.getString("maThuoc");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("donGia");
                Thuoc thuoc = new Thuoc_DAO().getThuoc(id);
                DoiTra doiTra = new DoiTra(id);
                ChiTietDoiTra returnOrderDetail = new ChiTietDoiTra(doiTra, thuoc, soLuong, gia);
                result.add(returnOrderDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static void createReturnOrderDetail(DoiTra newReturnOrder, ArrayList<ChiTietDoiTra> cart) {
        for (ChiTietDoiTra chiTietDoiTra : cart) {
            try {
                chiTietDoiTra.setReturnOrder(newReturnOrder);
                ChiTietDoiTra_DAO.create(chiTietDoiTra);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
   
}

    
