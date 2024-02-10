package fpoly.trungnqph45090.duanmau.Models;

public class ThanhVien {
    private String MaTV;
    private String HoTen;
    private String NamSinh;

    public ThanhVien(String maTV, String hoTen, String namSinh) {
        MaTV = maTV;
        HoTen = hoTen;
        NamSinh = namSinh;
    }

    public ThanhVien(String hoTen, String namSinh) {
        HoTen = hoTen;
        NamSinh = namSinh;
    }

    public ThanhVien() {

    }

    public String getMaTV() {
        return MaTV;
    }

    public void setMaTV(String maTV) {
        MaTV = maTV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(String namSinh) {
        NamSinh = namSinh;
    }
}