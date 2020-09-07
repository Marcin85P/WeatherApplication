package WeatherApp;

import com.google.gson.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Functions extends Variables{

    public void setImage(File file, ImageView weatherImage) {
        Image image = new Image(file.toURI().toString());
        weatherImage.setImage(image);
    }

    public String setJsonText(TextField town, Label location, TextField country) {
        if(country.getText().equals("") && town.getText().equals("")) {
            location.setText("WYBIERZ PAŃSTWO I MIASTO");
        }else if(town.getText().equals("")) {
            location.setText("WYBIERZ MIASTO");
        }else if(country.getText().equals("")) {
            location.setText("WYBIERZ PAŃSTWO");
        }else{
            setCountryUrl(country.getText());
            setCountryUrl(getCountryUrl().trim());
            setCountryUrl(getCountryUrl().toUpperCase());

            String codeCountry = countryCheck(country);

            setTownUrl(town.getText());
            setTownUrl(getTownUrl().trim());
            setTownUrl(getTownUrl().toUpperCase());
            setTownUrl(getTownUrl().replace(" ", "+"));

            if(codeCountry.length() > 0) {
                setJsonDataTextTown(doHttpGet(getTownUrl(), codeCountry));

                if(getJsonDataTextTown().contains("city not found")) {
                    location.setText("BŁĘDNA NAZWA MIEJSCOWOŚCI");
                    getConnectErr().setOpacity(0);
                    return null;
                } else if(getJsonDataTextTown().isEmpty()) {
                    getConnectErr().setOpacity(1);
                    location.setText("BRAK DANYCH O POGODZIE");
                    return null;
                } else {
                    getConnectErr().setOpacity(0);
                    return getJsonDataTextTown();
                }
            }
            else
                location.setText("BŁĘDNA NAZWA PAŃSTWA");
        }
        return null;
    }

    private String countryCheck(TextField country){
        try {
            String contents = new String((Files.readAllBytes(Paths.get("src/main/java/WeatherApp/codeCountry.json"))));
            Gson gson = new Gson();
            Country resultsCountry = gson.fromJson(contents, Country.class);

            country.setText(country.getText().trim());
            country.setText(country.getText().toLowerCase());
            for(int i = 0; i < resultsCountry.allCountry.length; i++){
                if((resultsCountry.allCountry[i].name_pl.toLowerCase()).equals(country.getText())){
                    String code = resultsCountry.allCountry[i].code;
                    return code;
                }
            }
        }catch (IOException ioe){
            return "";
        }
        return "";
    }

    private String doHttpGet(String town, String countryCode){
        String url = "http://api.openweathermap.org/data/2.5/forecast?q=" + town + "," + countryCode + "&appid" +
                "=a39f2ed5f06902d56e0d45c7816e9071";

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse resp = null;

        try {
            resp = client.execute(get);
            HttpEntity entity = resp.getEntity();
            return EntityUtils.toString(entity);
        } catch (IOException ioe) {
            return "";
        }
    }

    public All jsonData(String weatherJson){
        Gson gson = new Gson();
        All results = gson.fromJson(weatherJson, All.class);
        return results;
    }

    public String time() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy  HH:mm");
        setTime(dateFormat.format(date));
        return getTime();
    }

    public int convertTemp(double temperature) {
        double temp = temperature - 273.15;
        return (int)temp;
    }

    public void setClouds(int id, Label cloudsTown, ImageView weatherImage) {
        if(id >= 200 && id <= 299) {
            cloudsTown.setText("Burza z piorunami");
            File file = new File("src/main/java/image/11d.png");
            setImage(file, weatherImage);
        }
        else if (id >= 300 && id <= 399) {
            cloudsTown.setText("Mżawka");
            File file = new File("src/main/java/image/09d.png");
            setImage(file, weatherImage);
        }
        else if (id >= 500 && id <= 504) {
            cloudsTown.setText("Przelotny deszcz");
            File file = new File("src/main/java/image/10d.png");
            setImage(file, weatherImage);
        }
        else if (id >= 505 && id <= 599) {
            cloudsTown.setText("Deszcz");
            File file = new File("src/main/java/image/09d.png");
            setImage(file, weatherImage);
        }
        else if (id >= 600 && id <= 699) {
            cloudsTown.setText("Śnieg");
            File file = new File("src/main/java/image/13d.png");
            setImage(file, weatherImage);
        }
        else if (id >= 700 && id <= 799) {
            cloudsTown.setText("Mgła");
            File file = new File("src/main/java/image/50d.png");
            setImage(file, weatherImage);
        }
        else if (id == 800) {
            cloudsTown.setText("Pogodnie");
            File file = new File("src/main/java/image/01d.png");
            setImage(file, weatherImage);
        }
        else if (id == 801) {
            cloudsTown.setText("Zachmurzenie małe");
            File file = new File("src/main/java/image/02d.png");
            setImage(file, weatherImage);
        }
        else if (id == 802) {
            cloudsTown.setText("Zachmurzenie umiarkowane");
            File file = new File("src/main/java/image/03d.png");
            setImage(file, weatherImage);
        }
        else if (id >= 802 && id <= 899) {
            cloudsTown.setText("Zachmurzenie duże");
            File file = new File("src/main/java/image/04d.png");
            setImage(file, weatherImage);
        }
        else {
            cloudsTown.setText("Brak danych");
            File file = new File("");
            setImage(file, weatherImage);
        }
    }

    public String cutDate(String dateTown){
        dateTown = dateTown.substring(0, 10);
        return dateTown;
    }

    public void setInfoImage(ImageView thermImage, ImageView pressureImage, ImageView humidityImage,
                             ImageView windImage) {
        File fileTerm = new File("src/main/java/image/Thermometer-44.png");
        setImage(fileTerm, thermImage);

        File filePress = new File("src/main/java/image/AtmosphericPressure-44.png");
        setImage(filePress, pressureImage);

        File fileHum = new File("src/main/java/image/Humidity_44px.png");
        setImage(fileHum, humidityImage);

        File fileWind = new File("src/main/java/image/WindSpeed98-102_44px.png");
        setImage(fileWind, windImage);
    }


}
