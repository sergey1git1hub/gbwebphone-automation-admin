package utils.global_elements;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EnabledAndTypeSelects {

    static public final SelenideElement elementEnabled = $x("//*[@id='layoutCenter']//span[text()='Enabled']/following-sibling::select");
    static public final SelenideElement elementType = $x("//*[@id='layoutCenter']//span[text()='Type']/following-sibling::select");

    static public final String ALL = "ALL";
    static public final String ENABLED = "Enabled";
    static public final String DISABLED = "Disabled";

    static public final String INBOUND = "Inbound";
    static public final String OUTBOUND = "Outbound";


    public static void selectValue(SelenideElement chooseElement, String value) {

        SelenideElement element;

        if (chooseElement == elementEnabled) {
            element = elementEnabled;
            switch (value) {
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
        } else if (chooseElement == elementType) {
            element = elementType;
            switch (value) {
                case "All":
                    element.setValue("");
                    break;
                case "Inbound":
                    element.setValue("0");
                    break;
                case "Outbound":
                    element.setValue("1");
                    break;
                default:
                    element.setValue("");
            }
        }
    }
}


