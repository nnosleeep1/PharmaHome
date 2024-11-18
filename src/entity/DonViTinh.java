package entity;

import java.util.Objects;

public class DonViTinh {

    /**
     * @return the maDonViTinh
     */
    public String getMaDonViTinh() {
        return maDonViTinh;
    }

    /**
     * @param maDonViTinh the maDonViTinh to set
     */
    public void setMaDonViTinh(String maDonViTinh) {
        this.maDonViTinh = maDonViTinh;
    }

    /**
     * @return the ten
     */
    public String getTen() {
        return ten;
    }

    /**
     * @param ten the ten to set
     */
    public void setTen(String ten) {
        this.ten = ten;
    }

    private String maDonViTinh;
    private String ten;

    public DonViTinh(String maDonViTinh, String ten) {
        this.maDonViTinh = maDonViTinh;
        this.ten = ten;
    }

    public DonViTinh(String maDonViTinh) {
        this.maDonViTinh = maDonViTinh;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.maDonViTinh);
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
        final DonViTinh other = (DonViTinh) obj;
        return Objects.equals(this.maDonViTinh, other.maDonViTinh);
    }
}
