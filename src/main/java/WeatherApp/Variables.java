package WeatherApp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Variables {

    @FXML private Label connectErr;
    @FXML private Label currentLocation;
    @FXML private Label newLocation;
    @FXML private Label timeAndDate;
    @FXML private TextField country_1;
    @FXML private TextField country_2;
    @FXML private TextField town_1;
    @FXML private TextField town_2;

    private String townUrl;
    private String countryUrl;
    private String jsonTextTown1;
    private String jsonTextTown2;
    private String jsonDataTextTown;
    private String time;

    public String getJsonTextTown1() {
        return jsonTextTown1;
    }

    public String getJsonTextTown2() {
        return jsonTextTown2;
    }

    public String getTownUrl() {
        return townUrl;
    }

    public String getCountryUrl() {
        return countryUrl;
    }

    public String getJsonDataTextTown() {
        return jsonDataTextTown;
    }

    public String getTime() {
        return time;
    }

    public Label getConnectErr() {
        return connectErr;
    }

    public Label getCurrentLocation() {
        return currentLocation;
    }

    public Label getNewLocation() {
        return newLocation;
    }

    public Label getTimeAndDate() {
        return timeAndDate;
    }

    public TextField getCountry_1() {
        return country_1;
    }

    public TextField getCountry_2() {
        return country_2;
    }

    public TextField getTown_1() {
        return town_1;
    }

    public TextField getTown_2() {
        return town_2;
    }

    public void setJsonTextTown1(String jsonTextTown1) {
        this.jsonTextTown1 = jsonTextTown1;
    }

    public void setJsonTextTown2(String jsonTextTown2) {
        this.jsonTextTown2 = jsonTextTown2;
    }

    public void setTownUrl(String townUrl) {
        this.townUrl = townUrl;
    }

    public void setCountryUrl(String countryUrl) {
        this.countryUrl = countryUrl;
    }

    public void setJsonDataTextTown(String jsonDataTextTown) {
        this.jsonDataTextTown = jsonDataTextTown;
    }

    public void setTime(String timeAndDate) {
        this.time = timeAndDate;
    }
}
