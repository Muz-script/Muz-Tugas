import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Elemen UI
        Label labelNama = new Label("Nama:");
        TextField inputNama = new TextField();

        Label labelNim = new Label("NIM:");
        TextField inputNim = new TextField();

        Label labelKelas = new Label("Kelas:");
        TextField inputKelas = new TextField();

        Button submitButton = new Button("Simpan");
        Label outputLabel = new Label();

        // Aksi tombol
        submitButton.setOnAction(e -> {
            String nama = inputNama.getText();
            String kelas = inputKelas.getText();
            int nim;

            try {
                nim = Integer.parseInt(inputNim.getText());

                Mahsiswa mhs = new Mahsiswa(kelas, nama, nim);
                outputLabel.setText("Data Mahasiswa:\nNama: " + mhs.nama + "\nNIM: " + mhs.nim + "\nKelas: " + mhs.kelas);
            } catch (NumberFormatException ex) {
                outputLabel.setText("NIM harus berupa angka.");
            }
        });

        // Layout
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20;");
        root.getChildren().addAll(labelNama, inputNama, labelNim, inputNim, labelKelas, inputKelas, submitButton, outputLabel);

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("Form Mahasiswa");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}   