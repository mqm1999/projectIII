package com.example.Project3.dto;

public class LedTruocDTO {
    private Integer ID_ledTruoc;
    private String Ma_sp;
    private String NCC;
    private String KT;
    private Integer D;
    private Integer R;
    private String Ngay_BD;
    private Integer TG_BH;
    private Integer TG_con_lai;

    public LedTruocDTO() {
    }

    public LedTruocDTO(Integer ID_ledTruoc, String ma_sp, String NCC, String KT, Integer d, Integer r, String ngay_BD, Integer TG_BH, Integer TG_con_lai) {
        this.ID_ledTruoc = ID_ledTruoc;
        Ma_sp = ma_sp;
        this.NCC = NCC;
        this.KT = KT;
        D = d;
        R = r;
        Ngay_BD = ngay_BD;
        this.TG_BH = TG_BH;
        this.TG_con_lai = TG_con_lai;
    }

    public Integer getID_ledTruoc() {
        return ID_ledTruoc;
    }

    public void setID_ledTruoc(Integer ID_ledTruoc) {
        this.ID_ledTruoc = ID_ledTruoc;
    }

    public String getMa_sp() {
        return Ma_sp;
    }

    public void setMa_sp(String ma_sp) {
        Ma_sp = ma_sp;
    }

    public String getNCC() {
        return NCC;
    }

    public void setNCC(String NCC) {
        this.NCC = NCC;
    }

    public String getKT() {
        return KT;
    }

    public void setKT(String KT) {
        this.KT = KT;
    }

    public Integer getD() {
        return D;
    }

    public void setD(Integer d) {
        D = d;
    }

    public Integer getR() {
        return R;
    }

    public void setR(Integer r) {
        R = r;
    }

    public String getNgay_BD() {
        return Ngay_BD;
    }

    public void setNgay_BD(String ngay_BD) {
        Ngay_BD = ngay_BD;
    }

    public Integer getTG_BH() {
        return TG_BH;
    }

    public void setTG_BH(Integer TG_BH) {
        this.TG_BH = TG_BH;
    }

    public Integer getTG_con_lai() {
        return TG_con_lai;
    }

    public void setTG_con_lai(Integer TG_con_lai) {
        this.TG_con_lai = TG_con_lai;
    }

    @Override
    public String toString() {
        return "LedTruocDTO{" +
                "ID_ledTruoc=" + ID_ledTruoc +
                ", Ma_sp='" + Ma_sp + '\'' +
                ", NCC='" + NCC + '\'' +
                ", KT='" + KT + '\'' +
                ", D=" + D +
                ", R=" + R +
                ", Ngay_BD='" + Ngay_BD + '\'' +
                ", TG_BH=" + TG_BH +
                ", TG_con_lai=" + TG_con_lai +
                '}';
    }
}
