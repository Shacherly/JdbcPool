package test.serialize;

import com.duing.domain.Admin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Date;

public class TestSerialize {
    public static void main(String[] args) {
        Admin admin = new Admin(1, "account", 123456, new Date());
        try {

            FileOutputStream fos = new FileOutputStream("D:\\Project\\DUYI_EDU\\JdbcPool\\src\\test\\serialize\\Admin.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(admin);

            oos.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
