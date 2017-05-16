package utils;

import webpages.login.LoginPage;
import webpages.select_user_or_admin.SelectModePage;


public class AdminPage {

    private static LoginPage loginPage = new LoginPage();
    private static UserData data = new UserData();
    private static SelectModePage selectModePage = new SelectModePage();
    private static SpinnerWaiter spinnerWaiter = new SpinnerWaiter();

    public void getAdminPage() {
        spinnerWaiter.waitSpinner();
        loginPage.setUserData(data.getUsernameAdminValid(), data.getPasswordAdminValid());
        spinnerWaiter.waitSpinner();
        loginPage.clickConnect();
        spinnerWaiter.waitSpinner();
        selectModePage.clickAdminPanel();
    }

}
