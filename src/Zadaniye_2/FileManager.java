package Zadaniye_2;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileManager {

    private static final int buffSize = 1024;

    public static void copyFile(String src, String dest) {
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {
            byte[] buf = new byte[buffSize];
            int count;
            while ((count=fis.read(buf))>0)
                fos.write(buf,0,count);
            System.out.println("END");
            fis.close();
            fos.close();
            JOptionPane.showMessageDialog(null,"Копирование выполнено успешно");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Копирование не выполнено","alert", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
