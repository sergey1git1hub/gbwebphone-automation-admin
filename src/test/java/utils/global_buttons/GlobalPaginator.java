package utils.global_buttons;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GlobalPaginator {

    private SelenideElement paginator = $("#layoutCenter .ui-paginator.ui-paginator-bottom.ui-widget-header.ui-corner-bottom");


    //getters
    public SelenideElement getPaginator() {
        return paginator;
    }
}
