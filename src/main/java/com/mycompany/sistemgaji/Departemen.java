/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemgaji;

/**
 *
 * @author ACER
 */
import java.util.ArrayList;
import java.util.List;

public class Departemen {
    private String namaDepartemen;
    private List<Karyawan> daftarKaryawan;

    public Departemen(String namaDepartemen) {
        this.namaDepartemen = namaDepartemen;
        this.daftarKaryawan = new ArrayList<>();
    }

    public String getNamaDepartemen() { return namaDepartemen; }
    public void tambahKaryawan(Karyawan k) { daftarKaryawan.add(k); }

    public double hitungTotalGajiDepartemen() {
        double total = 0;
        for (Karyawan k : daftarKaryawan) {
            total += k.hitungGaji();
        }
        return total;
    }

    public void tampilkanDaftarKaryawan() {
        System.out.println("  Departemen: " + namaDepartemen);
        if (daftarKaryawan.isEmpty()) {
            System.out.println("   - (Belum ada karyawan)");
            return;
        }
        
        for (Karyawan k : daftarKaryawan) {
            // CUKUP MEMANGGIL OBJEK 'k', JAVA OTOMATIS MENJALANKAN toString()
            System.out.println("   - " + k.toString());
        }
    }
}