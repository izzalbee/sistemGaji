package com.mycompany.sistemgajifx.model;

import com.mycompany.sistemgajifx.model.Karyawan;

/**
 * Class yang merepresentasikan Karyawan Tetap.
 * Karyawan tipe ini mendapatkan gaji pokok dan tunjangan masa kerja.
 */
public class KaryawanTetap extends Karyawan {
    private Tunjangan tunjangan;

    /**
     * Constructor Karyawan Tetap.
     *
     * @param id        ID unik karyawan
     * @param nama      Nama karyawan
     * @param jabatan   Jabatan karyawan
     * @param tunjangan Objek tunjangan berdasarkan masa kerja
     */
    public KaryawanTetap(String id, String nama, Jabatan jabatan, Tunjangan tunjangan) {
        super(id, nama, jabatan);
        this.tunjangan = tunjangan;
    }

    /** @return Objek tunjangan karyawan */
    public Tunjangan getTunjangan() { 
        return tunjangan; 
    }

    /** @param tunjangan Mengubah objek tunjangan karyawan */
    public void setTunjangan(Tunjangan tunjangan) { 
        this.tunjangan = tunjangan; 
    }

    /**
     * Menghitung gaji karyawan tetap.
     * Rumus: Gaji Pokok + Nominal Tunjangan.
     *
     * @return Total gaji karyawan tetap
     */
    @Override
    public double hitungGaji() {
        return getGajiPokok() + tunjangan.hitungNominal();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Masa Kerja: %d tahun | Tunjangan: Rp%.0f | Total Gaji Akhir: Rp%.0f", 
                tunjangan.getMasaKerja(), tunjangan.hitungNominal(), hitungGaji());
    }
}