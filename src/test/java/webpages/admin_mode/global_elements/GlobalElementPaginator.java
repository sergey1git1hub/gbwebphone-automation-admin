package webpages.admin_mode.global_elements;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GlobalElementPaginator {

    private SelenideElement paginator = $("#layoutCenter .ui-paginator.ui-paginator-bottom.ui-widget-header.ui-corner-bottom");


    //getters
    public SelenideElement getPaginator() {
        return paginator;
    }
}
