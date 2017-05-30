package webpages.admin_mode.user_form.groups.skill_form;


import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class SkillForm {

    private ElementsCollection flag_chbx = $$("#addSkillForm\\3a addSkillMemberTable_data  .ui-chkbox-box");
    private ElementsCollection name_txt = $$("#addSkillForm\\3a addSkillMemberTable_data > tr > td:nth-child(2)");


    //getters
    public ElementsCollection getFlag_chbx() {
        return flag_chbx;
    }

    public ElementsCollection getName_txt() {
        return name_txt;
    }
}
