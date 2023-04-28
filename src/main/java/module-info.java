module com.example.testingjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.testingjavafx to javafx.fxml;
    exports com.example.testingjavafx;
}