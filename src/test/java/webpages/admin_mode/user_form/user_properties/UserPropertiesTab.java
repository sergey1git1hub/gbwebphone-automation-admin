package webpages.admin_mode.user_form.user_properties;


import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class UserPropertiesTab {

    private ElementsCollection properties = $$("#userDialogForm\\3a tabs\\3a properties_data > tr");


    //getters
    public ElementsCollection getProperties() {
        return properties;
    }
}
