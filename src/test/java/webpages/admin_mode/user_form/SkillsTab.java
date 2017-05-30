package webpages.admin_mode.user_form;


import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class SkillsTab {

    private ElementsCollection skills = $$("#userDialogForm\\3a tabs\\3a skills_data > tr > td:nth-child(3)");
    private ElementsCollection idS = $$("#userDialogForm\\3a tabs\\3a skills_data > tr > td:nth-child(2)");


    //getters
    public ElementsCollection getSkills() {
        return skills;
    }

    public ElementsCollection getIdS() {
        return idS;
    }
}
