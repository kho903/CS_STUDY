package com.company.design;

import com.company.design.adapter.*;
import com.company.design.aop.AopBrowser;
import com.company.design.decorator.A3;
import com.company.design.decorator.A4;
import com.company.design.decorator.A5;
import com.company.design.decorator.Audi;
import com.company.design.decorator.ICar;
import com.company.design.facade.Ftp;
import com.company.design.facade.Reader;
import com.company.design.facade.SftpClient;
import com.company.design.facade.Writer;
import com.company.design.observer.Button;
import com.company.design.observer.IButtonListener;
import com.company.design.proxy.Browser;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBrowser;
import com.company.design.singleton.AClazz;
import com.company.design.singleton.BClazz;
import com.company.design.singleton.SocketClient;
import com.company.design.strategy.*;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {
        /*
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두개의 객체가 동일한가 ? ");
        System.out.println(aClient.equals(bClient));
        // getInstance() 일때는 true
        // this.socketClient = new SocketClient(); 일 때는 false

        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
//        connect(cleaner);
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
//        connect(airConditioner);
        Electronic110V airAdapter = new SocketAdapter(airConditioner);
        connect(airAdapter);

         */

        /*
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();


        IBrowser browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();


        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser  aopBrowser = new AopBrowser("www.namver.com",
                ()-> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()-> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );
        aopBrowser.show();
        System.out.println("loading time : " + end.get());


        aopBrowser.show();
        System.out.println("loading time : " + end.get());

        // decorator
        ICar audi = new Audi(1000);
        audi.showPrice();

        // a3
        ICar audi3 = new A3(audi, "A3");
        audi3.showPrice();
        // a4
        ICar audi4 = new A4(audi, "A4");
        audi4.showPrice();

        // a5
        ICar audi5 = new A5(audi, "A5");
        audi5.showPrice();

        // Observer 패턴
        Button button = new Button("버튼");

        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });

        button.click("메시지 전달 : click1");
        button.click("메시지 전달 : click2");
        button.click("메시지 전달 : click3");
        button.click("메시지 전달 : click4");


        // Facade 패턴
        Ftp ftpClient = new Ftp("www.foo.co.kr", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnect();

        // Facade 패턴 적용 후
        SftpClient sftpClient = new SftpClient("www.foo.co.kr", 22, "/home/etc/", "text.tmp");
        sftpClient.connect();

        sftpClient.write();
        sftpClient.read();

        sftpClient.disConnect();

         */

        Encoder encoder = new Encoder();

        // base64
        EncodingStrategy base64 = new Base64Strategy();

        // normal
        EncodingStrategy normal = new NormalStrategy();

        String message = "hello java";
        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);

        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);
    }

    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}
