package com.mycompany.sistemgajifx.model;

/**
 * Class abstract yang merepresentasikan entitas dasar Karyawan.
 * Class ini menjadi induk bagi KaryawanTetap dan Freelance.
 */
public abstract class Karyawan {
    private String id;
    private String nama;
    private Jabatan jabatan;

    /**
     * Constructor untuk membuat objek Karyawan.
     *
     * @param id      ID unik karyawan
     * @param nama    Nama lengkap karyawan
     * @param jabatan Objek Jabatan yang menentukan gaji pokok
     */
    public Karyawan(String id, String nama, Jabatan jabatan) {
        this.id = id;
        this.nama = nama;
        this.jabatan = jabatan;
    }

    /** @return ID karyawan */
    public String getId() { return id; }
    
    /** @return Nama karyawan */
    public String getNama() {
        return nama; 
    }
    
    /** @return Objek Jabatan karyawan */
    public Jabatan getJabatan() {
        return jabatan; 
    }
    
    /** 
     * Mengambil gaji pokok dari jabatan yang diemban.
     * @return Nominal gaji pokok
     */
    public double getGajiPokok() { 
        return jabatan.getGajiPokok(); 
    }

    /**
     * Method abstract untuk menghitung total gaji.
     * Wajib diimplementasikan oleh class turunannya.
     * 
     * @return Total gaji akhir
     */
    public abstract double hitungGaji();

    @Override
    public String toString() {
        return String.format("%s (%s) | Gaji Pokok: Rp%.0f", 
                nama, jabatan.getNamaJabatan(), getGajiPokok());
    }
}