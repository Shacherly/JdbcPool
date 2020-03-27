package test;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TestZip {
    public static void main(String[] args) {
        zip("D:\\Project\\DUYI_EDU\\JdbcPool\\src\\test\\Test1.java", "Test1.zip");
    }


    public static void zip(String srcFileName, String desFileName) {
        System.out.println("Start compress");
        File zip = new File(desFileName);
        try {
            boolean created = zip.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File srcFile = new File(srcFileName);
        String base = srcFile.getName();
        try (FileInputStream fis = new FileInputStream(srcFile);
             BufferedInputStream bis = new BufferedInputStream(fis);
             FileOutputStream fos = new FileOutputStream(zip);
             ZipOutputStream zos = new ZipOutputStream(fos)
        ) {
            zos.putNextEntry(new ZipEntry(base));
            BufferedOutputStream bos = new BufferedOutputStream(zos);
            int temp;
            while ((temp = bis.read()) != -1) {
                bos.write(temp);
            }
            bos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Finished");

    }
}
