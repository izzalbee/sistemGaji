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

public class Freelance extends Karyawan {
    private List<Integer> jamKerjaHarian;
    private double tarifPerJam;

    public Freelance(String id, String nama, Jabatan jabatan, double tarifPerJam) {
        super(id, nama, jabatan);
        this.tarifPerJam = tarifPerJam;
        this.jamKerjaHarian = new ArrayList<>();
    }

    public void tambahJamKerjaHarian(int jam) {
        if (jam >= 0 && jam <= 24) {
            jamKerjaHarian.add(jam);
        } else {
            System.out.println("Input jam kerja harian tidak valid (0-24 jam).");
        }
    }

    public int getTotalJamMingguan(int mingguKe) {
        int total = 0;
        int startIndex = (mingguKe - 1) * 7;
        int endIndex = Math.min(startIndex + 7, jamKerjaHarian.size());

        for (int i = startIndex; i < endIndex; i++) {
            total += jamKerjaHarian.get(i);
        }
        return total;
    }

    public int getTotalJamBulanan() {
        int total = 0;
        for (int jam : jamKerjaHarian) {
            total += jam;
        }
        return total;
    }

    public double getTarifPerJam() {
        return tarifPerJam;
    }

    public void setTarifPerJam(double tarifPerJam) {
        if (tarifPerJam >= 0) {
            this.tarifPerJam = tarifPerJam;
        }
    }

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
