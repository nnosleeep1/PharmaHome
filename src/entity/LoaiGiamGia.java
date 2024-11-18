package entity;

import java.util.Objects;

public class LoaiGiamGia {

    /**
     * @return the maLoaiGiamGia
     */
    public String getMaLoaiGiamGia() {
        return maLoaiGiamGia;
    }

    /**
     * @param maLoaiGiamGia the maLoaiGiamGia to set
     */
    public void setMaLoaiGiamGia(String maLoaiGiamGia) {
        this.maLoaiGiamGia = maLoaiGiamGia;
    }

    /**
     * @return the tenLoai
     */
    public String getTenLoai() {
        return tenLoai;
    }

    /**
     * @param tenLoai the tenLoai to set
     */
    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public LoaiGiamGia(String maLoaiGiamGia, String tenLoai) {
        this.maLoaiGiamGia = maLoaiGiamGia;
        this.tenLoai = tenLoai;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.maLoaiGiamGia);
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
        final LoaiGiamGia other = (LoaiGiamGia) obj;
        return Objects.equals(this.maLoaiGiamGia, other.maLoaiGiamGia);
    }

	private String maLoaiGiamGia;
	private String tenLoai;

    public LoaiGiamGia(String maLoaiGiamGia) {
        this.maLoaiGiamGia = maLoaiGiamGia;
    }

	
}