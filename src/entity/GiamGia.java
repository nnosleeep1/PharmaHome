package entity;

import java.util.Objects;

public class GiamGia {

    /**
     * @return the maGiamGia
     */
    public String getMaGiamGia() {
        return maGiamGia;
    }

    /**
     * @param maGiamGia the maGiamGia to set
     */
    public void setMaGiamGia(String maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

    /**
     * @return the tenGiamGia
     */
    public String getTenGiamGia() {
        return tenGiamGia;
    }

    /**
     * @param tenGiamGia the tenGiamGia to set
     */
    public void setTenGiamGia(String tenGiamGia) {
        this.tenGiamGia = tenGiamGia;
    }

    /**
     * @return the moTa
     */
    public String getMoTa() {
        return moTa;
    }

    /**
     * @param moTa the moTa to set
     */
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    /**
     * @return the donVi
     */
    public String getDonVi() {
        return donVi;
    }

    /**
     * @param donVi the donVi to set
     */
    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    /**
     * @return the LoaiGiamGia
     */
    public LoaiGiamGia getLoaiGiamGia() {
        return loaiGiamGia;
    }

    /**
     * @param loaiGiamGia the LoaiGiamGia to set
     */
    public void setLoaiGiamGia(LoaiGiamGia loaiGiamGia) {
        this.loaiGiamGia = loaiGiamGia;
    }

	private String maGiamGia;
	private String tenGiamGia;
	private String moTa;
	private String donVi;
        private LoaiGiamGia loaiGiamGia;

    public GiamGia(String maGiamGia, String tenGiamGia, String moTa, String donVi, LoaiGiamGia loaiGiamGia) {
        this.maGiamGia = maGiamGia;
        this.tenGiamGia = tenGiamGia;
        this.moTa = moTa;
        this.donVi = donVi;
        this.loaiGiamGia = loaiGiamGia;
    }

    public GiamGia(String maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.getMaGiamGia());
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
        final GiamGia other = (GiamGia) obj;
        return Objects.equals(this.getMaGiamGia(), other.getMaGiamGia());
    }
}