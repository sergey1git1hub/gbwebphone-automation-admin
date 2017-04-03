package utils;


import org.assertj.db.type.Source;
import org.assertj.db.type.Table;

public class DataBaseConnection {

    private static Source source = new Source("jdbc:sqlserver://172.21.7.225\\\\corporate;DatabaseName=GBWebPhoneTest;portNumber=1438", "GBWebPhoneTest", "yt~k$tCW8%Gj");

    public static Source getSource() {
        return source;
    }

    public static Table getTable(String nameOfTable) {
//        Source source = new Source("jdbc:sqlserver://172.21.7.225\\\\corporate;DatabaseName=GBWebPhoneTest;portNumber=1438", "GBWebPhoneTest", "yt~k$tCW8%Gj");
        return new Table(source, nameOfTable);
    }
}
