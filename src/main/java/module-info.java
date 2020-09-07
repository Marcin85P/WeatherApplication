module WeatherApplication {
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpcore;
    requires gson;

    requires kotlin.stdlib;
    exports WeatherApp to javafx.graphics;
}