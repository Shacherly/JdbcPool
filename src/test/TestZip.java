package test;

import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TestZip {
    public static void main(String[] args) {
        String desPath = "C:\\Users\\Mufasa\\Desktop\\TestZIP.rar";
        zip("D:\\Project\\DUYI_EDU\\JdbcPool\\src\\test\\Test1.java", desPath);
    }


    public static void zip(String srcFileName, String desFileName) {
        System.out.println("Start compressing……");
        File desFile = new File(desFileName);
        try {
            boolean created = desFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File srcFile = new File(srcFileName);


        String generateFile = srcFile.getParent();
        File compress = new File(generateFile);
        if (!compress.exists()) {
            compress.mkdirs();
        }
        String baseName = compress.getName();
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(desFile))) {

            // zos.putNextEntry(new ZipEntry(baseName));
            // BufferedOutputStream bos = new BufferedOutputStream(zos);
            // int temp;
            // while ((temp = bis.read()) != -1) {
            //     bos.write(temp);
            // }
            // bos.flush();
            // bos.close();
            zip(zos, compress, baseName);
            // TimeUnit.SECONDS.sleep(3);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Finished");

    }

    private static void zip(ZipOutputStream zos, File srcFile, String fileName) throws IOException {
        // 如果是文件夹
        if (srcFile.isDirectory()) {
            File[] files = srcFile.listFiles();
            // 打包下一级目录
            if (files != null) {
                zos.putNextEntry(new ZipEntry(fileName + "/"));
                fileName = fileName.length() == 0 ? "" : fileName + "/";
                for (File childFile : files) {
                    zip(zos, childFile, fileName + childFile.getName());
                }
                return;
            }
        }
        // 否则是文件
        zos.putNextEntry(new ZipEntry(fileName));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(zos);
        int temp;
        byte[] buffer = new byte[1024];
        while ((temp = bis.read(buffer, 0, 1024)) != -1) {
            bos.write(buffer);
        }
        bos.flush();
        // bos.close();
    }
}
