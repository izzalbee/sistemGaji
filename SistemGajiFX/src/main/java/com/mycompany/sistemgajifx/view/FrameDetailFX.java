package com.mycompany.sistemgajifx.view;

import com.mycompany.sistemgajifx.model.*;
import com.mycompany.sistemgajifx.controller.MainFX;

import java.util.Optional;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.Cursor;

public class FrameDetailFX {
    private Scene scene;
    private MainFX mainApp;
    private Karyawan karyawan;

    // Komponen UI
    private Label lblNamaDetail;
    private Label lblJabatanDetail;
    private Label lblGajiPokok;
    private Label lblInfoTambahan;
    private Label lblTotalGaji;
    private Button btnInputJam;

    public FrameDetailFX(MainFX mainApp, Karyawan karyawan) {
        this.mainApp = mainApp;
        this.karyawan = karyawan;
        buatTampilan();
        perbaruiTeks();
    }

    private void buatTampilan() {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #F1F5F9;"); // Sesuai dengan background FrameUtamaFX
        root.setPadding(new Insets(40));

        // ==========================================
        // 1. TOMBOL KEMBALI (NAVIGASI ATAS)
        // ==========================================
        Button btnKembali = new Button("<< Kembali ke Direktori");
        btnKembali.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        btnKembali.setStyle("-fx-background-color: transparent; -fx-text-fill: #4F46E5; -fx-cursor: hand; -fx-padding: 10 0;");
        
        btnKembali.setOnMouseEntered(e -> btnKembali.setStyle("-fx-background-color: transparent; -fx-text-fill: #312E81; -fx-cursor: hand; -fx-padding: 10 0;"));
        btnKembali.setOnMouseExited(e -> btnKembali.setStyle("-fx-background-color: transparent; -fx-text-fill: #4F46E5; -fx-cursor: hand; -fx-padding: 10 0;"));
        
        btnKembali.setOnAction(e -> mainApp.bukaFrameUtama());

        HBox topBox = new HBox(btnKembali);
        topBox.setAlignment(Pos.CENTER_LEFT);
        root.setTop(topBox);

        // ==========================================
        // 2. KARTU DETAIL (TENGAH)
        // ==========================================
        VBox card = new VBox(25);
        card.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 16; -fx-padding: 40;");
        card.setMaxWidth(600);
        card.setAlignment(Pos.TOP_LEFT);

        DropShadow shadow = new DropShadow(30, Color.rgb(0, 0, 0, 0.05));
        shadow.setOffsetY(10);
        card.setEffect(shadow);

        // Header Profil
        lblNamaDetail = new Label();
        lblNamaDetail.setFont(Font.font("Segoe UI", FontWeight.BOLD, 32));
        lblNamaDetail.setTextFill(Color.web("#0F172A"));

        lblJabatanDetail = new Label();
        lblJabatanDetail.setFont(Font.font("Segoe UI", 16));
        lblJabatanDetail.setTextFill(Color.web("#64748B"));

        VBox headerBox = new VBox(5, lblNamaDetail, lblJabatanDetail);

        // Garis Pembatas Halus
        Separator sep = new Separator();
        sep.setStyle("-fx-padding: 10 0;");

        // Rincian Komponen Gaji
        VBox detailsBox = new VBox(15);
        
        lblGajiPokok = new Label();
        lblGajiPokok.setFont(Font.font("Segoe UI", 15));
        lblGajiPokok.setTextFill(Color.web("#334155"));
        
        lblInfoTambahan = new Label();
        lblInfoTambahan.setFont(Font.font("Segoe UI", 15));
        lblInfoTambahan.setTextFill(Color.web("#334155"));

        detailsBox.getChildren().addAll(lblGajiPokok, lblInfoTambahan);

        // Highlight Box untuk Total Gaji Akhir
        VBox totalBox = new VBox(8);
        totalBox.setStyle("-fx-background-color: #EEF2FF; -fx-background-radius: 12; -fx-padding: 25;");
        totalBox.setAlignment(Pos.CENTER_LEFT);

        Label lblTotalText = new Label("Total Take-Home Pay");
        lblTotalText.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 14));
        lblTotalText.setTextFill(Color.web("#4F46E5"));

        lblTotalGaji = new Label();
        lblTotalGaji.setFont(Font.font("Segoe UI", FontWeight.BOLD, 42));
        lblTotalGaji.setTextFill(Color.web("#4F46E5"));

        totalBox.getChildren().addAll(lblTotalText, lblTotalGaji);

        // Tombol Aksi (Khusus Freelance)
        btnInputJam = new Button("Input Jam Kerja Harian");
        btnInputJam.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        btnInputJam.setStyle("-fx-background-color: #4F46E5; -fx-text-fill: white; -fx-padding: 12 25; -fx-background-radius: 8; -fx-cursor: hand;");
        
        btnInputJam.setOnMouseEntered(e -> btnInputJam.setStyle("-fx-background-color: #4338CA; -fx-text-fill: white; -fx-padding: 12 25; -fx-background-radius: 8; -fx-cursor: hand;"));
        btnInputJam.setOnMouseExited(e -> btnInputJam.setStyle("-fx-background-color: #4F46E5; -fx-text-fill: white; -fx-padding: 12 25; -fx-background-radius: 8; -fx-cursor: hand;"));
        
        btnInputJam.setOnAction(e -> handleInputJam());

        HBox actionBox = new HBox(btnInputJam);
        actionBox.setAlignment(Pos.CENTER_RIGHT);
        actionBox.setPadding(new Insets(10, 0, 0, 0));

        card.getChildren().addAll(headerBox, sep, detailsBox, totalBox, actionBox);
        
        // Membungkus kartu agar berada di tengah layar secara vertikal dan horizontal
        VBox centerWrapper = new VBox(card);
        centerWrapper.setAlignment(Pos.CENTER);
        root.setCenter(centerWrapper);

        this.scene = new Scene(root, 1100, 700);
    }

    private void handleInputJam() {
        if (karyawan instanceof Freelance) {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Input Jam Kerja");
            dialog.setHeaderText("Masukkan jam kerja harian tambahan untuk " + karyawan.getNama());
            
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(jamStr -> {
                try {
                    int jam = Integer.parseInt(jamStr);
                    ((Freelance) karyawan).tambahJamKerjaHarian(jam);
                    perbaruiTeks(); 
                } catch (NumberFormatException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Input harus berupa angka bulat!");
                    alert.show();
                }
            });
        }
    }

    private void perbaruiTeks() {
        // Menggunakan format %,.0f agar muncul titik pemisah ribuan pada nominal Rupiah
        lblNamaDetail.setText(karyawan.getNama());
        lblJabatanDetail.setText(karyawan.getJabatan().getNamaJabatan());
        lblTotalGaji.setText(String.format("Rp%,.0f", karyawan.hitungGaji()).replace(',', '.'));

        if (karyawan instanceof KaryawanTetap) {
            KaryawanTetap kt = (KaryawanTetap) karyawan;
            lblGajiPokok.setText(String.format("Gaji Pokok Jabatan: Rp%,.0f", kt.getGajiPokok()).replace(',', '.'));
            lblInfoTambahan.setText(String.format("Tunjangan Masa Kerja (%d Tahun): Rp%,.0f", kt.getTunjangan().getMasaKerja(), kt.getTunjangan().hitungNominal()).replace(',', '.'));
            
            // Sembunyikan tombol input jam sepenuhnya dan hilangkan ruang kosongnya
            btnInputJam.setVisible(false); 
            btnInputJam.setManaged(false); 
            
        } else if (karyawan instanceof Freelance) {
            Freelance fr = (Freelance) karyawan;
            lblGajiPokok.setText("Gaji Pokok: Rp0 (Sistem Tarif Per Jam)");
            lblInfoTambahan.setText(String.format("Tarif Upah: Rp%,.0f / Jam   |   Total Terkumpul: %d Jam", fr.getTarifPerJam(), fr.getTotalJamBulanan()).replace(',', '.'));
            
            // Munculkan tombol input jam khusus freelance
            btnInputJam.setVisible(true); 
            btnInputJam.setManaged(true);
        }
    }

    public Scene getScene() {
        return scene;
    }
}