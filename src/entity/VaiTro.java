package entity;

public class VaiTro {

	private String maVaiTro;
	private String ten;

    public VaiTro(String maVaiTro, String ten) {
        this.maVaiTro = maVaiTro;
        this.ten = ten;
    }

    public VaiTro(String maVaiTro) {
        this.maVaiTro = maVaiTro;
    }

    /**
     * @return the maVaiTro
     */
    public String getMaVaiTro() {
        return maVaiTro;
    }

    /**
     * @param maVaiTro the maVaiTro to set
     */
    public void setMaVaiTro(String maVaiTro) {
        this.maVaiTro = maVaiTro;
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

	
}