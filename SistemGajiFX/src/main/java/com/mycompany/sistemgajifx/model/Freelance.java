package com.mycompany.sistemgajifx.model;
import com.mycompany.sistemgajifx.model.Karyawan;
import java.util.ArrayList;
import java.util.List;

/**
 * Class yang merepresentasikan Karyawan Freelance.
 * Gaji dihitung berdasarkan total jam kerja dikali tarif per jam.
 */
public class Freelance extends Karyawan {
    private List<Integer> jamKerjaHarian;
    private double tarifPerJam;

    /**
     * Constructor untuk Freelance.
     *
     * @param id          ID karyawan
     * @param nama        Nama karyawan
     * @param jabatan     Jabatan (Gaji pokok biasanya 0)
     * @param tarifPerJam Nominal tarif upah per jam kerja
     */
    public Freelance(String id, String nama, Jabatan jabatan, double tarifPerJam) {
        super(id, nama, jabatan);
        this.tarifPerJam = tarifPerJam;
        this.jamKerjaHarian = new ArrayList<>();
    }

    /**
     * Menambahkan rekam jam kerja untuk satu hari.
     * @param jam Jumlah jam kerja (0-24)
     */
    public void tambahJamKerjaHarian(int jam) {
        if (jam >= 0 && jam <= 24) {
            jamKerjaHarian.add(jam);
        } else {
            System.out.println("Input jam kerja harian tidak valid (0-24 jam).");
        }
    }

    /**
     * Menghitung total jam kerja selama sebulan.
     * @return Total jam kerja
     */
    public int getTotalJamBulanan() {
        int total = 0;
        for (int jam : jamKerjaHarian) total += jam;
        return total;
    }

    /**
     * Mengambil nilai tarif per jam.
     * @return Tarif per jam
     */
    public double getTarifPerJam() {
        return tarifPerJam;
    }

    /**
     * Menghitung gaji Freelance.
     * Rumus: Total Jam Kerja Bulanan * Tarif per Jam.
     *
     * @return Total gaji freelance
     */
    @Override
    public double hitungGaji() {
        return getTotalJamBulanan() * tarifPerJam;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Tarif/Jam: Rp%.0f | Total Jam: %d jam | Total Gaji Akhir: Rp%.0f", 
                tarifPerJam, getTotalJamBulanan(), hitungGaji());
    }
}