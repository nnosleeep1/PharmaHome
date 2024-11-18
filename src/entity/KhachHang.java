package entity;

import java.util.Objects;

public class KhachHang {

    /**
     * @return the maKH
     */
    public String getMaKH() {
        return maKH;
    }

    /**
     * @param maKH the maKH to set
     */
    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    /**
     * @return the tenKhachHang
     */
    public String getTenKhachHang() {
        return tenKhachHang;
    }

    /**
     * @param tenKhachHang the tenKhachHang to set
     */
    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    /**
     * @return the sdt
     */
    public String getSdt() {
        return sdt;
    }

    /**
     * @param sdt the sdt to set
     */
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    /**
     * @return the diemTichLuy
     */
    public double getDiemTichLuy() {
        return diemTichLuy;
    }

    /**
     * @param diemTichLuy the diemTichLuy to set
     */
    public void setDiemTichLuy(double diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    private String maKH;
    private String tenKhachHang;
    private String sdt;
    private double diemTichLuy;

  
    public KhachHang(String maKH, String tenKhachHang, String sdt, double diemTichLuy) {
        this.maKH = maKH;
        this.tenKhachHang = tenKhachHang;
        this.sdt = sdt;
        this.diemTichLuy = diemTichLuy;
    }

   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.getMaKH());
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
        final KhachHang other = (KhachHang) obj;
        return Objects.equals(this.getMaKH(), other.getMaKH());
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }

}
