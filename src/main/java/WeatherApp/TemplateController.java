package WeatherApp;

import javafx.fxml.FXML;

public class TemplateController extends Functions {

    @FXML private Town1_InfoController town1_infoController;
    @FXML private Town2_InfoController town2_infoController;

    @FXML
    private void look() {
        setJsonTextTown1(setJsonText(getTown_1(), getCurrentLocation(), getCountry_1()));
        if(getJsonTextTown1() != null) {
            All results = jsonData(getJsonTextTown1());
            town1_infoController.setDateTown1(results, getTownUrl(), getCurrentLocation());
        } else {
            town1_infoController.setDateTown_1_Err(4);
        }

        setJsonTextTown2(setJsonText(getTown_2(), getNewLocation(), getCountry_2()));
        if(getJsonTextTown2() != null) {
            All results = jsonData(getJsonTextTown2());
            town2_infoController.setDateTown2(results, getTownUrl(), getNewLocation());
        } else {
            town2_infoController.setDateTown_2_Err(4);
        }

        getTimeAndDate().setText(time());
    }

    @FXML
    private void close_widget(){
        System.exit(0);
    }
}
