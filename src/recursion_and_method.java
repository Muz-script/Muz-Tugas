import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class recursion_and_method extends Application {

    // Metode untuk perkalian menggunakan rekursi
    private int kaliRekursi(int a, int b) {
        if (b == 0) {
            return 0;
        } else if (b > 0) {
            return a + kaliRekursi(a, b - 1);
        } else { // Jika b negatif
            return -kaliRekursi(a, -b);
        }
    }
    
    // Metode untuk menghitung pangkat menggunakan rekursi
    private int pangkatRekursi(int a, int b) {
        if (b == 0) {
            return 1;
        } else if (b > 0) {
            return a * pangkatRekursi(a, b - 1);
        } else { // Jika pangkat negatif
            return 1 / pangkatRekursi(a, -b);
        }
    }

    @Override
    public void start(Stage primaryStage) {
        Label label1 = new Label("Angka 1 :");
        TextField input1 = new TextField();
        Label label2 = new Label("Angka 2 :");
        TextField input2 = new TextField();
        Button btnHitung = new Button("Hitung Perkalian");
        Button btnPangkat = new Button("Hitung Pangkat");
        Label hasil = new Label("Hasil");

        btnHitung.setOnAction(e -> {
            try {
                int angka1 = Integer.parseInt(input1.getText());
                int angka2 = Integer.parseInt(input2.getText());
                int hasilkali = kaliRekursi(angka1, angka2);
                hasil.setText("Hasil Perkalian: " + hasilkali);
            } catch (NumberFormatException ex) {
                hasil.setText("Input tidak valid");
            }
        });

        btnPangkat.setOnAction(e -> {
            try {
                int angka1 = Integer.parseInt(input1.getText());
                int angka2 = Integer.parseInt(input2.getText());
                int hasilPangkat = pangkatRekursi(angka1, angka2);
                hasil.setText("Hasil Pangkat: " + hasilPangkat);
            } catch (NumberFormatException ex) {
                hasil.setText("Input tidak valid");
            }
        });

        VBox layout = new VBox(10, label1, input1, label2, input2, btnHitung, btnPangkat, hasil);
        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setTitle("Operasi Rekursif");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
