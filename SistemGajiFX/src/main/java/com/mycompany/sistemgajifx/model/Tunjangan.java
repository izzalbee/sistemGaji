package com.mycompany.sistemgajifx.model;

/**
 * Class yang bertanggung jawab memproses aturan bisnis terkait tunjangan.
 * Tunjangan dihitung secara dinamis berdasarkan masa kerja karyawan (dalam tahun).
 */
public class Tunjangan {
    private int masaKerja; // dalam hitungan tahun

    /**
     * Constructor untuk inisialisasi data tunjangan.
     *
     * @param masaKerja Lama waktu karyawan bekerja (dalam tahun)
     */
    public Tunjangan(int masaKerja) {
        this.masaKerja = masaKerja;
    }

    /**
     * Mengambil data masa kerja.
     * @return Masa kerja dalam tahun
     */
    public int getMasaKerja() {
        return masaKerja;
    }

    /**
     * Mengubah data masa kerja.
     * @param masaKerja Nilai masa kerja baru (tidak boleh negatif)
     */
    public void setMasaKerja(int masaKerja) {
        if (masaKerja >= 0) {
            this.masaKerja = masaKerja;
        }
    }

    /**
     * Menghitung nominal tunjangan berdasarkan akumulasi masa kerja.
     * Skema:
     * - < 1 tahun: Rp0
     * - 1 - 3 tahun: Rp1.000.000
     * - 4 - 5 tahun: Rp2.000.000
     * - > 5 tahun: Rp3.000.000
     *
     * @return Nominal besaran tunjangan yang didapatkan
     */
    public double hitungNominal() {
        if (masaKerja < 1) {
            return 0;           
        } else if (masaKerja <= 3) {
            return 1000000;     
        } else if (masaKerja <= 5) {
            return 2000000;     
        } else {
            return 3000000;     
        }
    }
}