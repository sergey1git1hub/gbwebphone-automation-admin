package utils.global_elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


public class AnyElementByText {

     public final String ID = "id";
     public final String NAME = "Name";
     public final String DESCRIPTION = "Description";
     public final String TENANT = "Tenant";
     public final String ENABLED = "Enabled";
     public final String USERNAME = "Username";
     public final String FIRSTNAME = "Firstname";
     public final String LASTNAME = "Lastname";
     public final String EMAIL = "Email";
     public final String GROUPS = "Groups";
     public final String TEAM = "Team";
     public final String QUEUES = "Queues";

     public SelenideElement findCellInGrid(String textInCell) {
        SelenideElement element = $x("//*[@id='layoutCenter']//span[text()='" + textInCell + "']");
        return element;
    }

     public ElementsCollection findCollectionByColumn(int numberOfColumn) {
        ElementsCollection element = $$x(".//*[@id='layoutCenter']//td[" + numberOfColumn + "]");
        return element;
    }

     public SelenideElement findUpperInput(String name) {
        SelenideElement element = $x("//*[@id='layoutCenter']//span[text()='" + name + "']/following-sibling::input");
        return element;
    }

     public SelenideElement findUpperSort(String name) {
        SelenideElement element = $x("//*[@id='layoutCenter']//span[text()='" + name + "']");
        return element;
    }

}
