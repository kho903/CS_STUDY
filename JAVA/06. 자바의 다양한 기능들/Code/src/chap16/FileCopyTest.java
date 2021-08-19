package chap16;

import java.io.*;
import java.net.Socket;

public class FileCopyTest {
    public static void main(String[] args) {
        long millisecond = 0;
//        try (FileInputStream fis = new FileInputStream("a.zip");
//             FileOutputStream fos = new FileOutputStream("copy.zip")) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.zip"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.zip"))) {
            millisecond = System.currentTimeMillis();
            int i;
//            while ((i = fis.read()) != -1) {
            while ((i = bis.read()) != -1) {
//                fos.write(i);
                bos.write(i);
            }
            millisecond = System.currentTimeMillis() - millisecond;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(millisecond + "소요되었습니다.");

//        Socket socket = new Socket();
//        BufferedReader br = new BufferedInputStream(new InputStreamReader(socket.getInputStream()));
        // 보조 스트림이 다른 보조스트림을 감싸고 그 보조 스트림은 또다른 보조스트림 또는 기반 스트림을 감쌀 수 있다.
    }
}
