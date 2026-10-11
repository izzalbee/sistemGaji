package com.mycompany.sistemgajifx.model;

import com.mycompany.sistemgajifx.model.Departemen;
import java.util.ArrayList;
import java.util.List;

/**
 * Class utama pengelola struktur organisasi yang menampung departemen-departemen.
 * Class ini berfungsi untuk mengumpulkan dan memproses keseluruhan laporan keuangan gaji.
 */
public class Perusahaan {
    private String namaPerusahaan;
    private List<Departemen> daftarDepartemen;

    /**
     * Constructor untuk membuat entitas Perusahaan.
     *
     * @param namaPerusahaan Nama resmi dari perusahaan
     */
    public Perusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
        this.daftarDepartemen = new ArrayList<>();
    }

    /**
     * Mengambil nama perusahaan.
     * @return Nama perusahaan
     */
    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    /**
     * Mendaftarkan atau menambahkan departemen baru ke dalam perusahaan.
     * @param dept Objek Departemen yang akan ditambahkan
     */
    public void tambahDepartemen(Departemen dept) {
        daftarDepartemen.add(dept);
        System.out.println("Departemen " + dept.getNamaDepartemen() + " berhasil ditambahkan.");
    }

    /**
     * Mengkalkulasi total seluruh beban gaji perusahaan dari semua departemen.
     * @return Total biaya pengeluaran gaji perusahaan
     */
    public double hitungTotalGajiPerusahaan() {
        double total = 0;
        for (Departemen dept : daftarDepartemen) {
            total += dept.hitungTotalGajiDepartemen();
        }
        return total;
    }

    /**
     * Menampilkan laporan komprehensif ke terminal/console.
     * Mencakup detail karyawan per departemen, sub-total departemen, dan Grand Total perusahaan.
     */
    public void tampilkanLaporanPerusahaan() {
        System.out.println("\n=== LAPORAN PERUSAHAAN " + namaPerusahaan.toUpperCase() + " ===");
        for (Departemen dept : daftarDepartemen) {
            dept.tampilkanDaftarKaryawan();
            System.out.printf("  [Total Gaji Dept %s: Rp%.0f]\n\n", 
                              dept.getNamaDepartemen(), 
                              dept.hitungTotalGajiDepartemen());
        }
        System.out.printf("TOTAL PENGELUARAN PERUSAHAAN: Rp%.0f\n", hitungTotalGajiPerusahaan());
    }
}