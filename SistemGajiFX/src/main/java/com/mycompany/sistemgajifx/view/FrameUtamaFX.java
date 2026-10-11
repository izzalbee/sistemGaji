package com.mycompany.sistemgajifx.view;

import com.mycompany.sistemgajifx.model.*;
import com.mycompany.sistemgajifx.controller.MainFX;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class FrameUtamaFX {
    private Scene scene;
    private MainFX mainApp;
    private Karyawan karyawanTerpilih;
    private BorderPane rootLayout;
    
    // Tema Warna Baru (Vibrant & Modern SaaS)
    private final String COLOR_BG = "#F1F5F9"; // Abu-abu kebiruan sangat terang (Background)
    private final String COLOR_SIDEBAR = "#4F46E5"; // Rich Indigo (Sidebar)
    private final String COLOR_PRIMARY = "#3B82F6"; // Biru utama
    private final String COLOR_TEXT_DARK = "#0F172A"; // Teks gelap utama
    private final String COLOR_TEXT_MUTED = "#64748B"; // Teks abu-abu

    public FrameUtamaFX(MainFX mainApp) {
        this.mainApp = mainApp;
        buatTampilanUtama();
    }

    private void buatTampilanUtama() {
        rootLayout = new BorderPane();
        rootLayout.setStyle("-fx-background-color: " + COLOR_BG + ";");

        // 1. Sidebar Kiri
        VBox sidebar = buatSidebar();
        rootLayout.setLeft(sidebar);

        // 2. Konten Tengah Default
        rootLayout.setCenter(buatHalamanDashboard());

        this.scene = new Scene(rootLayout, 1100, 700);
    }

    // ==========================================
    // SIDEBAR (RICH INDIGO)
    // ==========================================
    private VBox buatSidebar() {
        VBox sidebar = new VBox(20);
        sidebar.setPrefWidth(260);
        sidebar.setStyle("-fx-background-color: " + COLOR_SIDEBAR + "; -fx-padding: 30 20;");
        
        // Bayangan untuk memberi kesan melayang
        DropShadow shadow = new DropShadow(25, Color.rgb(0, 0, 0, 0.1));
        shadow.setOffsetX(5);
        sidebar.setEffect(shadow);

        // Logo
        Label lblLogo1 = new Label("Pay");
        lblLogo1.setFont(Font.font("Segoe UI", FontWeight.BOLD, 30));
        lblLogo1.setTextFill(Color.WHITE); // Putih bersih
        
        Label lblLogo2 = new Label("Roll.");
        lblLogo2.setFont(Font.font("Segoe UI", FontWeight.BOLD, 30));
        lblLogo2.setTextFill(Color.web("#A5B4FC")); // Ungu muda (Light Indigo)
        
        HBox logoBox = new HBox(lblLogo1, lblLogo2);
        logoBox.setAlignment(Pos.CENTER_LEFT);
        VBox.setMargin(logoBox, new Insets(0, 0, 40, 0));

        // Tombol Menu
        Button btnDashboard = buatTombolMenu("Overview");
        Button btnDataKaryawan = buatTombolMenu("Employee Data");

        btnDashboard.setOnAction(e -> rootLayout.setCenter(buatHalamanDashboard()));
        btnDataKaryawan.setOnAction(e -> rootLayout.setCenter(buatHalamanDataKaryawan()));

        sidebar.getChildren().addAll(logoBox, btnDashboard, btnDataKaryawan);
        return sidebar;
    }

    private Button buatTombolMenu(String teks) {
        Button btn = new Button(teks);
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setAlignment(Pos.CENTER_LEFT);
        btn.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 15));
        
        // Desain default tombol (teks ungu muda semi-transparan, tanpa background)
        btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #C7D2FE; -fx-padding: 15 20; -fx-background-radius: 8;");
        btn.setCursor(Cursor.HAND);
        
        // Efek Hover (Background Indigo lebih gelap, teks putih menyala)
        btn.setOnMouseEntered(e -> btn.setStyle("-fx-background-color: #4338CA; -fx-text-fill: white; -fx-padding: 15 20; -fx-background-radius: 8;"));
        btn.setOnMouseExited(e -> btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #C7D2FE; -fx-padding: 15 20; -fx-background-radius: 8;"));
        return btn;
    }

    // ==========================================
    // HALAMAN DASHBOARD
    // ==========================================
    private VBox buatHalamanDashboard() {
        VBox layout = new VBox(30);
        layout.setPadding(new Insets(40));

        // Header Perusahaan
        VBox headerText = new VBox(5);
        Label lblCompany = new Label("PT MAJU BERSAMA");
        lblCompany.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        lblCompany.setTextFill(Color.web(COLOR_PRIMARY));

        Label lblWelcome = new Label("Dashboard Insight");
        lblWelcome.setFont(Font.font("Segoe UI", FontWeight.BOLD, 36));
        lblWelcome.setTextFill(Color.web(COLOR_TEXT_DARK)); 
        
        Label lblSubWelcome = new Label("Pantau ringkasan performa dan pengeluaran gaji perusahaan secara real-time.");
        lblSubWelcome.setFont(Font.font("Segoe UI", 16));
        lblSubWelcome.setTextFill(Color.web(COLOR_TEXT_MUTED));
        headerText.getChildren().addAll(lblCompany, lblWelcome, lblSubWelcome);

        // Kartu Statistik
        HBox gridKartu = new HBox(25);
        
        int totalKaryawan = mainApp.getListKaryawan().size();
        long totalTetap = mainApp.getListKaryawan().stream().filter(k -> k instanceof KaryawanTetap).count();
        long totalFreelance = mainApp.getListKaryawan().stream().filter(k -> k instanceof Freelance).count();

        gridKartu.getChildren().addAll(
            buatKartuBerwarna("Total Karyawan", String.valueOf(totalKaryawan), "#3B82F6", "#2563EB"),
            buatKartuBerwarna("Karyawan Tetap", String.valueOf(totalTetap), "#10B981", "#059669"),
            buatKartuBerwarna("Freelance", String.valueOf(totalFreelance), "#F59E0B", "#D97706")
        );

        layout.getChildren().addAll(headerText, gridKartu);
        return layout;
    }

    private VBox buatKartuBerwarna(String judul, String angka, String colorStart, String colorEnd) {
        VBox card = new VBox(15);
        card.setAlignment(Pos.CENTER_LEFT);
        card.setPrefWidth(240);
        card.setPrefHeight(150);
        
        String gradientStyle = String.format("-fx-background-color: linear-gradient(to bottom right, %s, %s); -fx-background-radius: 16; -fx-padding: 30;", colorStart, colorEnd);
        card.setStyle(gradientStyle);
        
        DropShadow shadow = new DropShadow(20, Color.rgb(0, 0, 0, 0.15));
        shadow.setOffsetY(10);
        card.setEffect(shadow);

        Label lblJudul = new Label(judul);
        lblJudul.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 16));
        lblJudul.setTextFill(Color.WHITE);
        lblJudul.setOpacity(0.9);

        Label lblAngka = new Label(angka);
        lblAngka.setFont(Font.font("Segoe UI", FontWeight.BOLD, 48));
        lblAngka.setTextFill(Color.WHITE);

        card.getChildren().addAll(lblJudul, lblAngka);
        return card;
    }

    // ==========================================
    // HALAMAN DATA KARYAWAN (TABEL DINAMIS)
    // ==========================================
    private VBox buatHalamanDataKaryawan() {
        VBox layout = new VBox(25);
        layout.setPadding(new Insets(40));

        // Header
        VBox headerText = new VBox(5);
        Label lblJudul = new Label("Direktori Karyawan");
        lblJudul.setFont(Font.font("Segoe UI", FontWeight.BOLD, 28));
        lblJudul.setTextFill(Color.web(COLOR_TEXT_DARK));
        
        Label lblSubJudul = new Label("Daftar lengkap pegawai berdasarkan departemen.");
        lblSubJudul.setFont(Font.font("Segoe UI", 15));
        lblSubJudul.setTextFill(Color.web(COLOR_TEXT_MUTED));
        headerText.getChildren().addAll(lblJudul, lblSubJudul);

        // Bungkus Tabel dengan VBox putih agar terlihat seperti kartu (*Card*)
        VBox tableContainer = new VBox();
        tableContainer.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-padding: 10;");
        DropShadow tableShadow = new DropShadow(15, Color.rgb(0, 0, 0, 0.04));
        tableContainer.setEffect(tableShadow);

        TableView<Karyawan> tabel = new TableView<>();
        
        // CSS Inline DIPERBARUI: Menambahkan pengaturan warna saat baris diklik
        tabel.setStyle(
            "-fx-background-color: white;" +
            "-fx-border-color: transparent;" +
            "-fx-font-family: 'Segoe UI';" +
            "-fx-font-size: 14px;" +
            "-fx-table-cell-border-color: transparent;" +
            "-fx-selection-bar: #EEF2FF;" +             // Background baris saat diklik (Biru sangat muda)
            "-fx-selection-bar-non-focused: #EEF2FF;" + // Background saat tabel tidak sedang diklik
            "-fx-selection-bar-text: #4F46E5;"          // Warna teks saat diklik menjadi Indigo (Tidak lagi putih)
        );
        
        tabel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        TableColumn<Karyawan, String> colDept = new TableColumn<>("Departemen");
        colDept.setCellValueFactory(data -> {
            String jab = data.getValue().getJabatan().getNamaJabatan().toLowerCase();
            return new SimpleStringProperty(jab.contains("it") || jab.contains("programmer") ? "IT" : "HRD");
        });

        TableColumn<Karyawan, String> colId = new TableColumn<>("ID Pegawai");
        colId.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getId()));
        
        TableColumn<Karyawan, String> colNama = new TableColumn<>("Nama Lengkap");
        colNama.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNama()));
        
        TableColumn<Karyawan, String> colJabatan = new TableColumn<>("Posisi");
        colJabatan.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getJabatan().getNamaJabatan()));

        tabel.getColumns().addAll(colDept, colId, colNama, colJabatan);
        
        // Logika Hover DIPERBARUI: Membersihkan style saat diklik agar warna -fx-selection-bar muncul
        tabel.setRowFactory(tv -> {
            TableRow<Karyawan> row = new TableRow<>();
            
            row.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
                if (isNowSelected) {
                    row.setStyle(""); // Hapus style hover agar CSS selection bawaan tabel mengambil alih
                }
            });

            row.setOnMouseEntered(event -> {
                if (!row.isEmpty() && !row.isSelected()) {
                    row.setStyle("-fx-background-color: #F8FAFC; -fx-cursor: hand;");
                }
            });
            
            row.setOnMouseExited(event -> {
                if (!row.isEmpty() && !row.isSelected()) {
                    row.setStyle(""); 
                }
            });
            return row;
        });
        
        ObservableList<Karyawan> observableKaryawan = FXCollections.observableArrayList(mainApp.getListKaryawan());
        tabel.setItems(observableKaryawan);
        VBox.setVgrow(tabel, Priority.ALWAYS);
        
        tableContainer.getChildren().add(tabel);
        VBox.setVgrow(tableContainer, Priority.ALWAYS);

        // Tombol Aksi
        Button btnLihatDetail = new Button("Lihat Detail Gaji");
        btnLihatDetail.setStyle("-fx-background-color: " + COLOR_SIDEBAR + "; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-family: 'Segoe UI'; -fx-padding: 12 25; -fx-background-radius: 8; -fx-cursor: hand;");
        btnLihatDetail.setDisable(true);
        
        btnLihatDetail.setOnMouseEntered(e -> {
            if(!btnLihatDetail.isDisabled()) btnLihatDetail.setStyle("-fx-background-color: #4338CA; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-family: 'Segoe UI'; -fx-padding: 12 25; -fx-background-radius: 8; -fx-cursor: hand;");
        });
        btnLihatDetail.setOnMouseExited(e -> {
            if(!btnLihatDetail.isDisabled()) btnLihatDetail.setStyle("-fx-background-color: " + COLOR_SIDEBAR + "; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-family: 'Segoe UI'; -fx-padding: 12 25; -fx-background-radius: 8; -fx-cursor: hand;");
        });

        tabel.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                karyawanTerpilih = newSel;
                btnLihatDetail.setDisable(false);
                btnLihatDetail.setStyle("-fx-background-color: " + COLOR_SIDEBAR + "; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-family: 'Segoe UI'; -fx-padding: 12 25; -fx-background-radius: 8; -fx-cursor: hand;");
            }
        });

        btnLihatDetail.setOnAction(e -> mainApp.bukaFrameDetail(karyawanTerpilih));

        HBox bottomBox = new HBox(btnLihatDetail);
        bottomBox.setAlignment(Pos.CENTER_RIGHT);

        layout.getChildren().addAll(headerText, tableContainer, bottomBox);
        return layout;
    }

    public Scene getScene() {
        return scene;
    }
}