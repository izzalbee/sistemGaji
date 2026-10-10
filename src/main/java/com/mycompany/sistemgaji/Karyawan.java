/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemgaji;

/**
 *
 * @author ACER
 */
public abstract class Karyawan {
    private String id;
    private String nama;
    private Jabatan jabatan;

    public Karyawan(String id, String nama, Jabatan jabatan) {
        this.id = id;
        this.nama = nama;
        this.jabatan = jabatan;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public Jabatan getJabatan() {
        return jabatan;
    }
    
    public double getGajiPokok() { 
        return jabatan.getGajiPokok(); 
    }

    public abstract double hitungGaji();

    @Override
    public String toString() {
        return String.format("%s (%s) | Gaji Pokok: Rp%.0f", 
                nama, jabatan.getNamaJabatan(), getGajiPokok());
    }
}
