package chap09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileExceptionHandling {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("a.txt");
            System.out.println("read");
//            try {
//                fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            System.out.println(e);
//            try {
//                fis.close();
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
            return;
        } finally { // 위에 return이 있어도 항상 불림
            if (fis!= null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("finally");
        }
        System.out.println("end");
    }
}
