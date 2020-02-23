package test;

import com.duing.domain.TestDomain;
import com.jdbc.sqlsession.SqlSessionFactory;

public class TestSqlSession {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        SqlSessionFactory instance = SqlSessionFactory.getInstance();
        // TestDomain testDomain = instance.constructByResultType(TestDomain.class);
        // System.out.println(testDomain);
    }
}
