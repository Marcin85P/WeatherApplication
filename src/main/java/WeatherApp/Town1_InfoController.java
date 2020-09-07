package WeatherApp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.File;

public class Town1_InfoController extends Functions {

    private double day = 0;

    @FXML private ImageView weatherImageTown1_day1;
    @FXML private ImageView weatherImageTown1_day2;
    @FXML private ImageView weatherImageTown1_day3;
    @FXML private ImageView weatherImageTown1_day4;

    @FXML private Label dateTown1_day1;
    @FXML private Label dateTown1_day2;
    @FXML private Label dateTown1_day3;
    @FXML private Label dateTown1_day4;

    @FXML private Label cloudsTown1_day1;
    @FXML private Label cloudsTown1_day2;
    @FXML private Label cloudsTown1_day3;
    @FXML private Label cloudsTown1_day4;

    @FXML private Label tempTown1_day1;
    @FXML private Label tempTown1_day2;
    @FXML private Label tempTown1_day3;
    @FXML private Label tempTown1_day4;

    @FXML private Label pressureTown1_day1;
    @FXML private Label pressureTown1_day2;
    @FXML private Label pressureTown1_day3;
    @FXML private Label pressureTown1_day4;

    @FXML private Label humidityTown1_day1;
    @FXML private Label humidityTown1_day2;
    @FXML private Label humidityTown1_day3;
    @FXML private Label humidityTown1_day4;

    @FXML private Label windTown1_day1;
    @FXML private Label windTown1_day2;
    @FXML private Label windTown1_day3;
    @FXML private Label windTown1_day4;

    @FXML private ImageView thermImageTown1_day1;
    @FXML private ImageView thermImageTown1_day2;
    @FXML private ImageView thermImageTown1_day3;
    @FXML private ImageView thermImageTown1_day4;

    @FXML private ImageView pressureImageTown1_day1;
    @FXML private ImageView pressureImageTown1_day2;
    @FXML private ImageView pressureImageTown1_day3;
    @FXML private ImageView pressureImageTown1_day4;

    @FXML private ImageView humidityImageTown1_day1;
    @FXML private ImageView humidityImageTown1_day2;
    @FXML private ImageView humidityImageTown1_day3;
    @FXML private ImageView humidityImageTown1_day4;

    @FXML private ImageView windImageTown1_day1;
    @FXML private ImageView windImageTown1_day2;
    @FXML private ImageView windImageTown1_day3;
    @FXML private ImageView windImageTown1_day4;

    @FXML private ImageView[] weatherImage;
    @FXML private Label[] dayDate;
    @FXML private Label[] clouds;
    @FXML private Label[] temperature;
    @FXML private Label[] pressure;
    @FXML private Label[] humidity;
    @FXML private Label[] wind;
    @FXML private ImageView[] thermImg;
    @FXML private ImageView[] pressureImg;
    @FXML private ImageView[] humidityImg;
    @FXML private ImageView[] windImg;

    @FXML
    public void initialize() {
        weatherImage = new ImageView[] {weatherImageTown1_day1, weatherImageTown1_day2, weatherImageTown1_day3,
                weatherImageTown1_day4};
        dayDate = new Label[] {dateTown1_day1, dateTown1_day2, dateTown1_day3, dateTown1_day4};
        clouds = new Label[] {cloudsTown1_day1, cloudsTown1_day2, cloudsTown1_day3, cloudsTown1_day4};
        temperature = new Label[] {tempTown1_day1, tempTown1_day2, tempTown1_day3, tempTown1_day4};
        pressure = new Label[] {pressureTown1_day1, pressureTown1_day2, pressureTown1_day3, pressureTown1_day4};
        humidity = new Label[] {humidityTown1_day1, humidityTown1_day2, humidityTown1_day3, humidityTown1_day4};
        wind = new Label[] {windTown1_day1, windTown1_day2, windTown1_day3, windTown1_day4};
        thermImg = new ImageView[] {thermImageTown1_day1, thermImageTown1_day2, thermImageTown1_day3, thermImageTown1_day4};
        pressureImg = new ImageView[] {pressureImageTown1_day1, pressureImageTown1_day2, pressureImageTown1_day3,
                pressureImageTown1_day4};
        humidityImg = new ImageView[] {humidityImageTown1_day1, humidityImageTown1_day2, humidityImageTown1_day3,
                humidityImageTown1_day4};
        windImg = new ImageView[] {windImageTown1_day1, windImageTown1_day2, windImageTown1_day3, windImageTown1_day4};
    }

    public void setDateTown1(All results, String town, Label currentLocation) {
        town = town.replace("+", " ");
        currentLocation.setText(town + ", " + results.city.country);

        day = results.list[0].dt;
        int j = 0;

        for(int i = 0; i < results.list.length; i++) {

            if(day == results.list[i].dt) {

                if(j < 4) {
                    setClouds(results.list[i].weather[0].id, clouds[j], weatherImage[j]);
                    dayDate[j].setText(cutDate(results.list[i].dt_txt));
                    temperature[j].setText(convertTemp(results.list[i].main.temp) + "  C");
                    pressure[j].setText(results.list[i].main.pressure + " hPa");
                    humidity[j].setText(results.list[i].main.humidity + " %");
                    wind[j].setText(results.list[i].wind.speed + " m/s");
                    setInfoImage(thermImg[j], pressureImg[j], humidityImg[j], windImg[j]);
                }

                j++;
                day = day + 86400;
            }
        }
    }

    public void setDateTown_1_Err(int numberOfDays) {

        for(int i = 0; i < numberOfDays; i++) {
            File file = new File("");
            setImage(file, weatherImage[i]);
            dayDate[i].setText("");
            clouds[i].setText("");
            temperature[i].setText("");
            pressure[i].setText("");
            humidity[i].setText("");
            wind[i].setText("");
            setImage(file, thermImg[i]);
            setImage(file, pressureImg[i]);
            setImage(file, humidityImg[i]);
            setImage(file, windImg[i]);
        }
    }
}
