package test.sys;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Properties;

public class TestSystemProperties {


    public static void main(String[] args) {
    }

    @Test
    public void doit() {
        Properties properties = System.getProperties();
        Enumeration<?> en = properties.propertyNames();
        for (; ; ) {
            if (!en.hasMoreElements()) return;
            Object o = en.nextElement();
            System.out.print(o + " = ");
            System.out.println(properties.get(o));
        }

    }
}
