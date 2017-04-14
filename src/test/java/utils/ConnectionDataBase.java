package utils;


import org.assertj.db.type.Source;
import org.assertj.db.type.Table;

import static utils.Constants.*;

public class ConnectionDataBase {

    private static Source source = new Source(DB_URL, DB_USER, DB_PASSWORD);

    public static Source getSource() {
        return source;
    }

    public static Table getTable(String nameOfTable) {
//        Source source = new Source("jdbc:sqlserver://172.21.7.225\\\\corporate;DatabaseName=GBWebPhoneTest;portNumber=1438", "GBWebPhoneTest", "yt~k$tCW8%Gj");
        return new Table(source, nameOfTable);
    }
}
