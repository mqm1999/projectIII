package com.example.Project3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Led_Truoc {
    private int ID_ledTruoc;
    private String ma_SP;
    private String NCC;
    private String KT;
    private int D;
    private int R;
    private String Ngay_BD;
    private int TG_BH;
    private int TG_con_lai;
}
