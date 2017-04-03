package utils;


import com.codeborne.selenide.SelenideElement;

public class Enabled {


    public static void selectEnabled(SelenideElement element, String text) {

        switch (text) {
            case "All":
                element.setValue("");
                break;
            case "Enabled":
                element.setValue("true");
                break;
            case "Disabled":
                element.setValue("false");
                break;
            default:
                element.setValue("");
        }
    }

}
