package entity;

import java.util.Objects;

public class NhaCungCap {

    /**
     * @return the maNCC
     */
    public String getMaNCC() {
        return maNCC;
    }

    /**
     * @param maNCC the maNCC to set
     */
    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }
	private String maNCC;
	private String tenNCC;
	private String diaChi;
	private String email;
	private String sdt;
	private boolean trangThai;

    public NhaCungCap(String maNCC) {
        this.maNCC = maNCC;
    }
	

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public NhaCungCap(String maNCC, String tenNCC, String diaChi, String email, String sdt, boolean trangThai) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.maNCC);
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
        final NhaCungCap other = (NhaCungCap) obj;
        return Objects.equals(this.maNCC, other.maNCC);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }
}
