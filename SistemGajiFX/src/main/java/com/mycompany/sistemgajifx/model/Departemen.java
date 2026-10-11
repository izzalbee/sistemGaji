package com.mycompany.sistemgajifx.model;

import com.mycompany.sistemgajifx.model.Karyawan;
import java.util.ArrayList;
import java.util.List;

/**
 * Class yang merepresentasikan sebuah departemen atau unit kerja.
 * Class ini mengelola daftar karyawan yang bekerja di departemen terkait.
 */
public class Departemen {
    private String namaDepartemen;
    private List<Karyawan> daftarKaryawan;

    /**
     * Constructor untuk membuat departemen baru.
     *
     * @param namaDepartemen Nama dari departemen (contoh: "IT", "HRD")
     */
    public Departemen(String namaDepartemen) {
        this.namaDepartemen = namaDepartemen;
        this.daftarKaryawan = new ArrayList<>();
    }

    /**
     * Mengambil nama departemen.
     * @return Nama departemen
     */
    public String getNamaDepartemen() { 
        return namaDepartemen; 
    }

    /**
     * Menambahkan karyawan baru ke dalam departemen ini.
     * @param k Objek Karyawan yang akan ditambahkan
     */
    public void tambahKaryawan(Karyawan k) { 
        daftarKaryawan.add(k); 
    }

    /**
     * Menghitung total beban gaji seluruh karyawan di dalam departemen ini.
     * Memanfaatkan konsep Polymorphism saat memanggil hitungGaji() dari tiap objek Karyawan.
     *
     * @return Total pengeluaran gaji untuk departemen ini
     */
    public double hitungTotalGajiDepartemen() {
        double total = 0;
        for (Karyawan k : daftarKaryawan) {
            total += k.hitungGaji();
        }
        return total;
    }

    /**
     * Menampilkan rincian data seluruh karyawan yang terdaftar di departemen ini
     * beserta perhitungan total gaji masing-masing.
     */
    public void tampilkanDaftarKaryawan() {
        System.out.println("  Departemen: " + namaDepartemen);
        if (daftarKaryawan.isEmpty()) {
            System.out.println("   - (Belum ada karyawan)");
            return;
        }
        
        for (Karyawan k : daftarKaryawan) {
            // Pemanggilan implicit terhadap k.toString()
            System.out.println("   - " + k.toString());
        }
    }
}