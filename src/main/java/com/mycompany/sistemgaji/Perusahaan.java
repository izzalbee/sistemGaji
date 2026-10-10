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

public class Perusahaan {
    private String namaPerusahaan;
    private List<Departemen> daftarDepartemen;

    public Perusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
        this.daftarDepartemen = new ArrayList<>();
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void tambahDepartemen(Departemen dept) {
        daftarDepartemen.add(dept);
        System.out.println("Departemen " + dept.getNamaDepartemen() + " berhasil ditambahkan.");
    }

    public double hitungTotalGajiPerusahaan() {
        double total = 0;
        for (Departemen dept : daftarDepartemen) {
            total += dept.hitungTotalGajiDepartemen();
        }
        return total;
    }

    public void tampilkanLaporanPerusahaan() {
        System.out.println("\n=== LAPORAN PERUSAHAAN " + namaPerusahaan.toUpperCase() + " ===");
        for (Departemen dept : daftarDepartemen) {
            dept.tampilkanDaftarKaryawan();
            System.out.println("  [Total Gaji Dept " + dept.getNamaDepartemen() + ": Rp" + dept.hitungTotalGajiDepartemen() + "]\n");
        }
        System.out.printf("TOTAL PENGELUARAN PERUSAHAAN: Rp%.0f\n", hitungTotalGajiPerusahaan());
    }
}
