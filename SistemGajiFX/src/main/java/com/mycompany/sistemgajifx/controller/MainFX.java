package com.mycompany.sistemgajifx.controller;

import com.mycompany.sistemgajifx.view.FrameDetailFX;
import com.mycompany.sistemgajifx.view.FrameUtamaFX;
import com.mycompany.sistemgajifx.model.Freelance;
import com.mycompany.sistemgajifx.model.Jabatan;
import com.mycompany.sistemgajifx.model.Karyawan;
import com.mycompany.sistemgajifx.model.KaryawanTetap;
import com.mycompany.sistemgajifx.model.Tunjangan;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class MainFX extends Application {
    private Stage primaryStage;
    private List<Karyawan> listKaryawan = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Aplikasi Penggajian JavaFX");
        
        inisialisasiData();
        bukaFrameUtama(); // Buka layar pertama
        
        primaryStage.show();
    }

    private void inisialisasiData() {
        Jabatan jabManagerIT = new Jabatan("Manager IT", 10000000);
        Jabatan jabStaffHRD = new Jabatan("Staff HRD", 5000000);
        Jabatan jabFreelance = new Jabatan("Freelance Programmer", 0);
        
        listKaryawan.add(new KaryawanTetap("T-01", "Budi", jabManagerIT, new Tunjangan(6)));
        listKaryawan.add(new KaryawanTetap("T-02", "Andi", jabStaffHRD, new Tunjangan(2)));
        listKaryawan.add(new Freelance("F-01", "Siti", jabFreelance, 100000));
    }

    public List<Karyawan> getListKaryawan() {
        return listKaryawan;
    }

    // --- METHOD UNTUK PERPINDAHAN FRAME ---

    public void bukaFrameUtama() {
        FrameUtamaFX frameUtama = new FrameUtamaFX(this);
        primaryStage.setScene(frameUtama.getScene());
    }

    public void bukaFrameDetail(Karyawan karyawanTerpilih) {
        FrameDetailFX frameDetail = new FrameDetailFX(this, karyawanTerpilih);
        primaryStage.setScene(frameDetail.getScene());
    }

    public static void main(String[] args) {
        launch(args);
    }
}