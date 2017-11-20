package tests.admin_side;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ConfigurationsExtentReport;
import utils.UserData;
import webpages.login.LoginPage;
import webpages.select_user_or_admin.SelectModePage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.codeborne.selenide.WebDriverRunner.url;
import static utils.ConfigurationsExtentReport.extent;

@Listeners(VideoListener.class)
public class AdminCanLogin {

    private LoginPage loginPage = new LoginPage();
    private UserData data = new UserData();
    private SelectModePage selectModePage = new SelectModePage();

    @Video
    @Test(description = "This TC#00003 verifies that Admin can Login")
    public void testAdminCanLogin() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanLogin", "This TC#00003 verifies that Admin can Login");

        loginPage.setUserData(data.getUsernameAdminValid(), data.getPasswordAdminValid());
        loginPage.clickConnect();
        selectModePage.clickAdminPanel();
        Assert.assertEquals(url(), "http://172.21.7.239/gbwebphone/admin/userList.jsf");  //todo change verification
    }

    @BeforeSuite
    public void cleanup() throws SQLException, ClassNotFoundException {
        System.out.println("Run SQL query.");
        updateRecord(getConnection());
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        System.out.println("Get connection.");
        String userName = "GBWebPhoneTest";
        String password = "yt~k$tCW8%Gj";
        String url = "jdbc:sqlserver://172.21.7.225\\\\corporate;DatabaseName=GBWebPhoneTest;portNumber=1438";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(url, userName, password);
        return conn;
    }

    public static void updateRecord(Connection con) throws SQLException {
        System.out.println("Create query.");
        String query;
       /* query =
        "delete from wbp_user where username = '81600';" +
        "delete from wbp_department where department_name = 'Name_of_Department';" +
        "delete from wbp_group where group_name = 'Name_of_Group';" +
        "delete from wbp_location where name = 'Name_of_Location';" +
        "delete from wbp_number where number_name = 'Name_of_Number';" +
        "delete from wbp_prefix where prefix_name = 'Name_of_Prefix';" +
        "delete from wbp_queue where queue_name = 'Name_of_Queue';" +
        "delete from wbp_result_code where result_code_text = 'Name_of_ResultCode';" +
        "delete from wbp_server where name = 'Name_of_Server';" +
        "delete from wbp_skill where skill_name = 'Name_of_Skill';" +
        "delete from wbp_status where status_text = 'Name_of_Status';" +
        "delete from wbp_team where team_name = 'Name_of_Team';" +
        "delete from wbp_tenant where name = 'Name_of_Tenant';" +
        "delete from wbp_trunk where name = 'Name_of_Trunk';";*/
query =
        "update wbp_user set deleted = 1 where username = '81600';" +
        "update wbp_department set deleted = 1 where department_name = 'Name_of_Department';" +
        "update wbp_group set deleted = 1 where group_name = 'Name_of_Group';" +
        "update wbp_location set deleted = 1 where name = 'Name_of_Location';" +
        "update wbp_number set deleted = 1 where number_name = 'Name_of_Number';" +
        "update wbp_prefix set deleted = 1 where prefix_name = 'Name_of_Prefix';" +
        "update wbp_queue set deleted = 1 where queue_name = 'Name_of_Queue';" +
        "update wbp_result_code set deleted = 1 where result_code_text = 'Name_of_ResultCode';" +
        "update wbp_server set deleted = 1 where name = 'Name_of_Server';" +
        "update wbp_skill set deleted = 1 where skill_name = 'Name_of_Skill';" +
        "update wbp_status set deleted = 1 where status_text = 'Name_of_Status';" +
        "update wbp_team set deleted = 1 where team_name = 'Name_of_Team';" +
        "update wbp_tenant set deleted = 1 where name = 'Name_of_Tenant';" +
        "update wbp_trunk set deleted = 1 where name = 'Name_of_Trunk';";


        Statement stmt = con.createStatement();
        stmt.execute(query);
    }

}
