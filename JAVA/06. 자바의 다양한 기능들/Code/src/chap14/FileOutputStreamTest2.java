package chap14;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest2 {
    public static void main(String[] args) throws FileNotFoundException {
//        FileOutputStream fos = new FileOutputStream("output2.txt");
        FileOutputStream fos = new FileOutputStream("output3.txt", true); // append : true - 이어 붙여줌
        try(fos) {
            byte[] bs = new byte[26];
            byte data = 65;
            for (int i = 0; i< bs.length; i++) {
                bs[i] = data++;
            }
//            fos.write(bs);
            fos.write(bs, 2, 10);
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("end");
    }
}
