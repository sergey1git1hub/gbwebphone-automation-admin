package webpages.admin_mode.user_form.priorities;


import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class PrioritiesTab {

    private ElementsCollection priorities = $$("#userDialogForm\\3a tabs\\3a priorities_data > tr");


    //getters
    public ElementsCollection getPriorities() {
        return priorities;
    }
}
