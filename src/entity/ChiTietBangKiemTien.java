/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author lemin
 */
public class ChiTietBangKiemTien {

    private boolean chiSo;
    private NhanVien nhanVien;
    private BangKiemTien bangKiemTien;

    public ChiTietBangKiemTien() {
    }

    public ChiTietBangKiemTien(boolean chiSo, NhanVien nhanVien, BangKiemTien bangKiemTien) {
        this.chiSo = chiSo;
        this.nhanVien = nhanVien;
        this.bangKiemTien = bangKiemTien;
    }

    public boolean getChiSo() {
        return chiSo;
    }

    public void setChiSo(boolean chiSo) {
        this.chiSo = chiSo;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public BangKiemTien getBangKiemTien() {
        return bangKiemTien;
    }

    public void setBangKiemTien(BangKiemTien bangKiemTien) {
        this.bangKiemTien = bangKiemTien;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nhanVien);
        hash = 97 * hash + Objects.hashCode(this.bangKiemTien);
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
        final ChiTietBangKiemTien other = (ChiTietBangKiemTien) obj;
        if (!Objects.equals(this.nhanVien, other.nhanVien)) {
            return false;
        }
        return Objects.equals(this.bangKiemTien, other.bangKiemTien);
    }
    
    
}
