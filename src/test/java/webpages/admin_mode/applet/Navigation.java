package webpages.admin_mode.applet;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Navigation {

    private SelenideElement userList = $x(".//span[text()='User list']");
    private SelenideElement groupList = $x(".//span[text()='Group list']");
    private SelenideElement queueList = $x(".//span[text()='Queue list']");
    private SelenideElement departmentList = $x(".//span[text()='Department list']");
    private SelenideElement prefixList = $x(".//span[text()='Prefix list']");
    private SelenideElement statusList = $x(".//span[text()='Status list']");
    private SelenideElement numberList = $x(".//span[text()='Number list']");
    private SelenideElement resultCodeList = $x(".//span[text()='Result code list']");
    private SelenideElement teamList = $x(".//span[text()='Team list']");
    private SelenideElement locationList = $x(".//span[text()='Location list']");
    private SelenideElement serverList = $x(".//span[text()='Server list']");
    private SelenideElement tenantList = $x(".//span[text()='Tenant list']");
    private SelenideElement skillList = $x(".//span[text()='Skill list']");
    private SelenideElement trunkList = $x(".//span[text()='Trunk list']");
    private SelenideElement ivr = $x(".//span[text()='IVR']");
    private SelenideElement permissionProfiles = $x(".//span[text()='Permission profiles']");
    private SelenideElement other = $x(".//span[text()='Other']");
    private SelenideElement logout = $x(".//*[text()='Logout']");


    //actions
    public void clickUserList() {
        userList.click();
    }

    public void clickGroupList() {
        groupList.click();
    }

    public void clickQueueList() {
        queueList.click();
    }

    public void clickDepartmentList() {
        departmentList.click();
    }

    public void clickPrefixList() {
        prefixList.click();
    }

    public void clickStatusList() {
        statusList.click();
    }

    public void clickNumberList() {
        numberList.click();
    }

    public void clickResultCodeList() {
        resultCodeList.click();
    }

    public void clickTeamList() {
        teamList.click();
    }

    public void clickLocationList() {
        locationList.click();
    }

    public void clickServerList() {
        serverList.click();
    }

    public void clickTenantList() {
        tenantList.click();
    }

    public void clickSkillList() {
        skillList.click();
    }

    public void clickIVR() {
        ivr.click();
    }

    public void clickPermissionProfiles() {
        permissionProfiles.click();
    }

    public void clickTrunkList() {
        trunkList.click();
    }

    public void clickOther() {
        other.click();
    }

    public void clickLogout() {
        logout.hover();
        logout.click();
        logout.click();
    }


    //getters
    public SelenideElement getUserList() {
        return userList;
    }

    public SelenideElement getGroupList() {
        return groupList;
    }

    public SelenideElement getQueueList() {
        return queueList;
    }

    public SelenideElement getDepartmentList() {
        return departmentList;
    }

    public SelenideElement getPrefixList() {
        return prefixList;
    }

    public SelenideElement getStatusList() {
        return statusList;
    }

    public SelenideElement getNumberList() {
        return numberList;
    }

    public SelenideElement getResultCodeList() {
        return resultCodeList;
    }

    public SelenideElement getTeamList() {
        return teamList;
    }

    public SelenideElement getLocationList() {
        return locationList;
    }

    public SelenideElement getServerList() {
        return serverList;
    }

    public SelenideElement getTenantList() {
        return tenantList;
    }

    public SelenideElement getSkillList() {
        return skillList;
    }

    public SelenideElement getTrunkList() {
        return trunkList;
    }

    public SelenideElement getIvr() {
        return ivr;
    }

    public SelenideElement getPermissionProfiles() {
        return permissionProfiles;
    }

    public SelenideElement getOther() {
        return other;
    }

    public SelenideElement getLogout() {
        return logout;
    }
}
