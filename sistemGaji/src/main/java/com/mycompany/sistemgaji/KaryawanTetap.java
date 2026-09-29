/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemgaji;

/**
 *
 * @author ACER
 */
public class KaryawanTetap extends Karyawan {
    private Tunjangan tunjangan; // Menggunakan class Tunjangan

    public KaryawanTetap(String id, String nama, Jabatan jabatan, Tunjangan tunjangan) {
        super(id, nama, jabatan);
        this.tunjangan = tunjangan;
    }

    public Tunjangan getTunjangan() {
        return tunjangan;
    }

    public void setTunjangan(Tunjangan tunjangan) {
        this.tunjangan = tunjangan;
    }

    @Override
    public double hitungGaji() {
        // Gaji Pokok + Nominal Tunjangan hasil kalkulasi masa kerja
        return getGajiPokok() + tunjangan.hitungNominal();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Masa Kerja: %d tahun | Tunjangan: Rp%.0f | Total Gaji Akhir: Rp%.0f", 
                tunjangan.getMasaKerja(), tunjangan.hitungNominal(), hitungGaji());
    }
}
