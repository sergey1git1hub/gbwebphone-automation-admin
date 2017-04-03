package webpages.admin_mode.department_list;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class AddAndCount {

    private SelenideElement add = $("#departmentDataForm:btn_add_department");
    private SelenideElement counter = $("#departmentDataForm:counter");


    //actions
    public void clickAdd() {
        add.click();
    }


    //getters
    public SelenideElement getAdd() {
        return add;
    }

    public SelenideElement getCounter() {
        return counter;
    }

}
