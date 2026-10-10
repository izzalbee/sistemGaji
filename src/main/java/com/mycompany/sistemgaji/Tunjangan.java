/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemgaji;

/**
 *
 * @author ACER
 */
public class Tunjangan {
    private int masaKerja; // dalam hitungan tahun

    public Tunjangan(int masaKerja) {
        this.masaKerja = masaKerja;
    }

    public int getMasaKerja() {
        return masaKerja;
    }

    public void setMasaKerja(int masaKerja) {
        if (masaKerja >= 0) {
            this.masaKerja = masaKerja;
        }
    }

    // Logika penentuan besaran tunjangan
    public double hitungNominal() {
        if (masaKerja < 1) {
            return 0;           // Di bawah 1 tahun: Rp0
        } else if (masaKerja <= 3) {
            return 1000000;     // 1 - 3 tahun: Rp1.000.000
        } else if (masaKerja <= 5) {
            return 2000000;     // 4 - 5 tahun: Rp2.000.000
        } else {
            return 3000000;     // Lebih dari 5 tahun: Rp3.000.000
        }
    }
}