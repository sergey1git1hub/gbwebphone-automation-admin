package webpages.admin_mode.user_form.groups;


import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

//UserForm-->Groups-->GroupList
public class Groups {


    private ElementsCollection groups = $$("#userDialogForm\\3a tabs\\3a groups_data > tr > td:nth-child(2)");
    private ElementsCollection idS = $$("#userDialogForm\\3a tabs\\3a groups_data > tr > td:nth-child(1)");


    //getters
    public ElementsCollection getGroups() {
        return groups;
    }

    public ElementsCollection getIdS() {
        return idS;
    }
}
