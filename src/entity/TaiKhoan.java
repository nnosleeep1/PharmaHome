package entity;

public class TaiKhoan {

	private String ten;
	private String password;
	private boolean trangThai;
        private VaiTro vaiTro;
        private NhanVien nhanVien;

        @Override
    public String toString() {
		throw new UnsupportedOperationException();
	}

    public TaiKhoan(String ten) {
        this.ten = ten;
    }

    public TaiKhoan(String ten, String password, boolean trangThai, VaiTro vaiTro, NhanVien nhanVien) {
        this.ten = ten;
        this.password = password;
        this.trangThai = trangThai;
        this.vaiTro = vaiTro;
        this.nhanVien = nhanVien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public VaiTro getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(VaiTro vaiTro) {
        this.vaiTro = vaiTro;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

}