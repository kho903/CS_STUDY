package chap06.noGeneric;

public class ThreeDPrinterTest {
    public static void main(String[] args) {
        Powder powder = new Powder();
        ThreeDPrinter3 printer = new ThreeDPrinter3();

        printer.setMaterial(powder);
        // 형변환 필요 - 번거로움
        Powder p = (Powder) printer.getMaterial();
    }
}
