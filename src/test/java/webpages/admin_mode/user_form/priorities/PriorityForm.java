package webpages.admin_mode.user_form.priorities;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PriorityForm {

    private SelenideElement queue_btn = $("#priorityDialogForm\\3a priorities_selectOneMenu > div > span");
    private ElementsCollection queues = $$("#priorityDialogForm\\3a priorities_selectOneMenu_panel  li");
    private SelenideElement priority_inpt = $("#priorityDialogForm\\3a userPriority_input");


    //getters
    public SelenideElement getQueue_btn() {
        return queue_btn;
    }

    public ElementsCollection getQueues() {
        return queues;
    }

    public SelenideElement getPriority_inpt() {
        return priority_inpt;
    }
}
