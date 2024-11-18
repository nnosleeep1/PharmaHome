package entity;

import java.util.Objects;

public class XuatXu {

    /**
     * @return the maXuatXu
     */
    public String getMaXuatXu() {
        return maXuatXu;
    }

    /**
     * @param maXuatXu the maXuatXu to set
     */
    public void setMaXuatXu(String maXuatXu) {
        this.maXuatXu = maXuatXu;
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

    private String maXuatXu;
    private String ten;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.getMaXuatXu());
        return hash;
    }

    public XuatXu(String maXuatXu, String ten) {
        this.maXuatXu = maXuatXu;
        this.ten = ten;
    }

    public XuatXu(String maXuatXu) {
        this.maXuatXu = maXuatXu;
    }

    public XuatXu() {
        throw new UnsupportedOperationException();
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
        final XuatXu other = (XuatXu) obj;
        return Objects.equals(this.getMaXuatXu(), other.getMaXuatXu());
    }

}
