/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


import enums.TrangThaiDoiTra;
import enums.TrangThaiDoiTra;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 *
 * @author HÀ NHƯ
 */
public class DoiTra {
    private final String ORDER_ERROR="Order không được rỗng";
    private final String EMPLOYEE_ERROR="Employee không được rỗng";
    private final String REASON_EMPTY = "Lý do không được rỗng";
    private final String TYPE_EMPTY = "Loại đơn đổi trả không được rỗng";
    private final String RETURNORDERID_VALID = "Mã đơn đổi trả không đúng cú pháp";

    
    
    private Date ngayDoiTra;
    private TrangThaiDoiTra trangThai;
    private String maHDDT;
    private NhanVien nhanvien;
    private HoaDon hoaDon;
    private boolean loai;
    private double tienTra;
    private ArrayList<ChiTietDoiTra> listDetail;
    private String liDO;

    @Override
    public String toString() {
        return "DoiTra{" + "ORDER_ERROR=" + ORDER_ERROR + ", EMPLOYEE_ERROR=" + EMPLOYEE_ERROR + ", REASON_EMPTY=" + REASON_EMPTY + ", TYPE_EMPTY=" + TYPE_EMPTY + ", RETURNORDERID_VALID=" + RETURNORDERID_VALID + ", ngayDoiTra=" + ngayDoiTra + ", trangThai=" + trangThai + ", maHDDT=" + maHDDT + ", nhanvien=" + nhanvien + ", hoaDon=" + hoaDon + ", loai=" + loai + ", tienTra=" + tienTra + ", listDetail=" + listDetail + ", liDO=" + liDO + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.maHDDT);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DoiTra other = (DoiTra) obj;
        return Objects.equals(this.maHDDT, other.maHDDT);
    }

    public DoiTra(Date ngayDoiTra, TrangThaiDoiTra trangThai, String maHDDT, NhanVien nhanvien, HoaDon hoaDon, boolean loai, double tienTra, ArrayList<ChiTietDoiTra> listDetail, String liDO) {
        this.ngayDoiTra = ngayDoiTra;
        this.trangThai = trangThai;
        this.maHDDT = maHDDT;
        this.nhanvien = nhanvien;
        this.hoaDon = hoaDon;
        this.loai = loai;
        this.tienTra = tienTra;
        this.listDetail = listDetail;
        this.liDO = liDO;
    }

    public DoiTra(String maHDDT) {
        this.maHDDT = maHDDT;
    }
 


    public DoiTra() {
    }

    public Date getNgayDoiTra() {
        return ngayDoiTra;
    }

    public void setNgayDoiTra(Date ngayDoiTra) {
        this.ngayDoiTra = ngayDoiTra;
    }

    public TrangThaiDoiTra getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThaiDoiTra trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaHDDT() {
        return maHDDT;
    }

    public void setMaHDDT(String maHDDT) {
        this.maHDDT = maHDDT;
    }

    public NhanVien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(NhanVien nhanvien) throws Exception {
        if(nhanvien!=null)
            this.nhanvien = nhanvien;
        else
            throw new Exception(EMPLOYEE_ERROR);
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public boolean isLoai() {
        return loai;
    }

    public void setLoai(boolean loai) {
        this.loai = loai;
    }

    public double getTienTra() {
        return tienTra;
    }

    public void setTienTra(double tienTra) {
        this.tienTra = tienTra;
         if(this.loai == false
                )
            this.tienTra = 0;
        else {
            for (ChiTietDoiTra returnOrderDetail : listDetail) {
                this.tienTra += returnOrderDetail.getGia();
            }
        }
    }

    public String getLiDO() {
        return liDO;
    }

    public void setLiDO(String liDO) throws Exception {
        this.liDO = liDO;
        if(liDO.isBlank())
            throw new Exception(REASON_EMPTY);
        this.liDO = liDO;
    }

    public ArrayList<ChiTietDoiTra> getListDetail() {
        return listDetail;
    }

    public void setListDetail(ArrayList<ChiTietDoiTra> listDetail) {
        this.listDetail = listDetail;
    }

}
