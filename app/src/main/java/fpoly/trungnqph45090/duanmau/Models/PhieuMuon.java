package fpoly.trungnqph45090.duanmau.Models;

import java.util.Date;

public class PhieuMuon {
    private int maPM;
    private String maTT;
    private String maTV;
    private int MaSach;
    private Date Ngay;
    private int TraSach;
    private int TienThue;

    public PhieuMuon(int maPM, String maTT, String maTV, int maSach, Date ngay, int traSach, int tienThue) {
        this.maPM = maPM;
        this.maTT = maTT;
        this.maTV = maTV;
        MaSach = maSach;
        Ngay = ngay;
        TraSach = traSach;
        TienThue = tienThue;
    }

    public PhieuMuon(String maTT, String maTV, int maSach, Date ngay, int traSach, int tienThue) {
        this.maTT = maTT;
        this.maTV = maTV;
        MaSach = maSach;
        Ngay = ngay;
        TraSach = traSach;
        TienThue = tienThue;
    }

    public PhieuMuon() {

    }

    public int getMaPM() {
        return maPM;
    }

    public void setMaPM(int maPM) {
        this.maPM = maPM;
    }

    public String getMaTT() {
        return maTT;
    }

    public void setMaTT(String maTT) {
        this.maTT = maTT;
    }

    public String getMaTV() {
        return maTV;
    }

    public void setMaTV(String maTV) {
        this.maTV = maTV;
    }

    public int getMaSach() {
        return MaSach;
    }

    public void setMaSach(int maSach) {
        MaSach = maSach;
    }

    public Date getNgay() {
        return Ngay;
    }

    public void setNgay(Date ngay) {
        Ngay = ngay;
    }

    public int getTraSach() {
        return TraSach;
    }

    public void setTraSach(int traSach) {
        TraSach = traSach;
    }

    public int getTienThue() {
        return TienThue;
    }

    public void setTienThue(int tienThue) {
        TienThue = tienThue;
    }
}
