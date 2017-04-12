package webpages.admin_mode.global_elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


public class AnyElementInListGrid {

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
     public final String NUMBER = "Number";
     public final String PREFIX = "Prefix";
     public final String CODE = "Code";
     public final String PAID = "Paid";
     public final String AVAILABLE_FOR_INBOUND_CALLS = "Available for inbound calls";
     public final String AVAILABLE_FOR_DAILER_CALLS = "Available for dialer calls";

     public SelenideElement findCellInGrid(String textInCell) {
        SelenideElement element = $x("//*[@id='layoutCenter']//span[text()='" + textInCell + "']");
        return element;
    }

     public ElementsCollection findCollectionByColumn(int numberOfColumnFrom1ToN) {
        ElementsCollection element = $$x(".//*[@id='layoutCenter']//td[" + numberOfColumnFrom1ToN + "]");
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
