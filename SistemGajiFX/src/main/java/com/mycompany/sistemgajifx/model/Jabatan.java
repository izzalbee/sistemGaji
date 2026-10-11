package com.mycompany.sistemgajifx.model;

/**
 * Class yang merepresentasikan referensi Jabatan dalam perusahaan.
 * Class ini menyimpan informasi mengenai nama posisi dan besaran gaji pokok dasar.
 */
public class Jabatan {
    private String namaJabatan;
    private double gajiPokok;

    /**
     * Constructor untuk membuat objek Jabatan baru.
     *
     * @param namaJabatan Nama posisi atau jabatan (contoh: "Manager IT")
     * @param gajiPokok   Nominal gaji pokok dasar untuk jabatan tersebut
     */
    public Jabatan(String namaJabatan, double gajiPokok) {
        this.namaJabatan = namaJabatan;
        this.gajiPokok = gajiPokok;
    }

    /**
     * Mengambil nama jabatan.
     * @return Nama jabatan karyawan
     */
    public String getNamaJabatan() {
        return namaJabatan;
    }

    /**
     * Mengambil besaran gaji pokok.
     * @return Nominal gaji pokok
     */
    public double getGajiPokok() {
        return gajiPokok;
    }
}