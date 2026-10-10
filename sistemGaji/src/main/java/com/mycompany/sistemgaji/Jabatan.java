/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemgaji;

/**
 *
 * @author ACER
 */
public class Jabatan {
    private String namaJabatan;
    private double gajiPokok;

    public Jabatan(String namaJabatan, double gajiPokok) {
        this.namaJabatan = namaJabatan;
        this.gajiPokok = gajiPokok;
    }

    public String getNamaJabatan() {
        return namaJabatan;
    }

    public double getGajiPokok() {
        return gajiPokok;
    }
}
