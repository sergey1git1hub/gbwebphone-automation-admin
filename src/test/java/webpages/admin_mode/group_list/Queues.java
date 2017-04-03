package webpages.admin_mode.group_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Queues {

    private SelenideElement queuesInput = $(By.xpath(".//*[@id='groupDataForm:groupTable_head']//span[text()='Queues']/following-sibling::input"));
    private ElementsCollection queueCollection = $$(By.xpath(".//*[@id='groupDataForm:groupTable_data']//td[4]"));

    //actions
    public void fillQueuesInput(String queues) {
        queuesInput.sendKeys(queues);
    }

    //getters
    public SelenideElement getQueuesInput() {
        return queuesInput;
    }

    public ElementsCollection getQueueCollection() {
        return queueCollection;
    }
}
