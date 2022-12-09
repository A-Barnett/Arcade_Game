module com.example.snake_test {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.snake_test to javafx.fxml;
    exports com.example.snake_test;
}