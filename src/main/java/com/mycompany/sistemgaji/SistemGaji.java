/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemgaji;

/**
 *
 * @author ACER
 */
public class SistemGaji {
    public static void main(String[] args) {
        // 1. Buat Perusahaan
        Perusahaan ptMaju = new Perusahaan("PT Maju Bersama");

        // 2. Buat Departemen
        Departemen deptIT = new Departemen("IT");
        Departemen deptHRD = new Departemen("HRD");

        ptMaju.tambahDepartemen(deptIT);
        ptMaju.tambahDepartemen(deptHRD);

        // 3. Buat Master Jabatan
        Jabatan jabManagerIT = new Jabatan("Manager IT", 10000000);
        Jabatan jabStaffHRD = new Jabatan("Staff HRD", 5000000);
        Jabatan jabFreelance = new Jabatan("Freelance Programmer", 0);

        // 4. Buat objek Tunjangan (diinisialisasi nilai masa kerjanya di sini)
        Tunjangan tunjBudi = new Tunjangan(6); // Budi masa kerja 6 tahun (Dapat 3jt)
        Tunjangan tunjAndi = new Tunjangan(2); // Andi masa kerja 2 tahun (Dapat 1jt)

        // 5. Buat Karyawan dengan memasukkan objek Tunjangan
        KaryawanTetap k1 = new KaryawanTetap("T-01", "Budi", jabManagerIT, tunjBudi); 
        KaryawanTetap k2 = new KaryawanTetap("T-02", "Andi", jabStaffHRD, tunjAndi);  
        
        Freelance f1 = new Freelance("F-01", "Siti", jabFreelance, 100000); 
        f1.tambahJamKerjaHarian(8); 
        f1.tambahJamKerjaHarian(8); 
        f1.tambahJamKerjaHarian(8); // Total 24 jam kerja

        // 6. Masukkan Karyawan ke Departemen masing-masing
        deptIT.tambahKaryawan(k1);
        deptIT.tambahKaryawan(f1);
        deptHRD.tambahKaryawan(k2);

        // 7. Cetak Laporan
        ptMaju.tampilkanLaporanPerusahaan();
    }
}
