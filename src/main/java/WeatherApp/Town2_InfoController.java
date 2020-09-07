package WeatherApp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.File;

public class Town2_InfoController extends Functions {

    private double day = 0;

    @FXML private ImageView weatherImageTown2_day1;
    @FXML private ImageView weatherImageTown2_day2;
    @FXML private ImageView weatherImageTown2_day3;
    @FXML private ImageView weatherImageTown2_day4;

    @FXML private Label dateTown2_day1;
    @FXML private Label dateTown2_day2;
    @FXML private Label dateTown2_day3;
    @FXML private Label dateTown2_day4;

    @FXML private Label cloudsTown2_day1;
    @FXML private Label cloudsTown2_day2;
    @FXML private Label cloudsTown2_day3;
    @FXML private Label cloudsTown2_day4;

    @FXML private Label tempTown2_day1;
    @FXML private Label tempTown2_day2;
    @FXML private Label tempTown2_day3;
    @FXML private Label tempTown2_day4;

    @FXML private Label pressureTown2_day1;
    @FXML private Label pressureTown2_day2;
    @FXML private Label pressureTown2_day3;
    @FXML private Label pressureTown2_day4;

    @FXML private Label humidityTown2_day1;
    @FXML private Label humidityTown2_day2;
    @FXML private Label humidityTown2_day3;
    @FXML private Label humidityTown2_day4;

    @FXML private Label windTown2_day1;
    @FXML private Label windTown2_day2;
    @FXML private Label windTown2_day3;
    @FXML private Label windTown2_day4;

    @FXML private ImageView thermImageTown2_day1;
    @FXML private ImageView thermImageTown2_day2;
    @FXML private ImageView thermImageTown2_day3;
    @FXML private ImageView thermImageTown2_day4;

    @FXML private ImageView pressureImageTown2_day1;
    @FXML private ImageView pressureImageTown2_day2;
    @FXML private ImageView pressureImageTown2_day3;
    @FXML private ImageView pressureImageTown2_day4;

    @FXML private ImageView humidityImageTown2_day1;
    @FXML private ImageView humidityImageTown2_day2;
    @FXML private ImageView humidityImageTown2_day3;
    @FXML private ImageView humidityImageTown2_day4;

    @FXML private ImageView windImageTown2_day1;
    @FXML private ImageView windImageTown2_day2;
    @FXML private ImageView windImageTown2_day3;
    @FXML private ImageView windImageTown2_day4;

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
        weatherImage = new ImageView[] {weatherImageTown2_day1, weatherImageTown2_day2, weatherImageTown2_day3,
                weatherImageTown2_day4};
        dayDate = new Label[] {dateTown2_day1, dateTown2_day2, dateTown2_day3, dateTown2_day4};
        clouds = new Label[] {cloudsTown2_day1, cloudsTown2_day2, cloudsTown2_day3, cloudsTown2_day4};
        temperature = new Label[] {tempTown2_day1, tempTown2_day2, tempTown2_day3, tempTown2_day4};
        pressure = new Label[] {pressureTown2_day1, pressureTown2_day2, pressureTown2_day3, pressureTown2_day4};
        humidity = new Label[] {humidityTown2_day1, humidityTown2_day2, humidityTown2_day3, humidityTown2_day4};
        wind = new Label[] {windTown2_day1, windTown2_day2, windTown2_day3, windTown2_day4};
        thermImg = new ImageView[] {thermImageTown2_day1, thermImageTown2_day2, thermImageTown2_day3,
                thermImageTown2_day4};
        pressureImg = new ImageView[] {pressureImageTown2_day1, pressureImageTown2_day2, pressureImageTown2_day3,
                pressureImageTown2_day4};
        humidityImg = new ImageView[] {humidityImageTown2_day1, humidityImageTown2_day2, humidityImageTown2_day3,
                humidityImageTown2_day4};
        windImg = new ImageView[] {windImageTown2_day1, windImageTown2_day2, windImageTown2_day3, windImageTown2_day4};
    }

    public void setDateTown2(All results, String town, Label newLocation) {
        town = town.replace("+", " ");
        newLocation.setText(town + ", " + results.city.country);

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

    public void setDateTown_2_Err(int numberOfDays) {

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
