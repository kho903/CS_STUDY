package chap06.generic;
import chap06.noGeneric.Plastic;
import chap06.noGeneric.Powder;

public class GenericPrinterTest {
    public static void main(String[] args) {
        Powder powder = new Powder();
        GenericPrinter<Powder> powderPrinter = new GenericPrinter<>();
        powderPrinter.setMaterial(powder);

        Powder p = powderPrinter.getMaterial();
        System.out.println(powderPrinter);

        GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<>();
        plasticPrinter.setMaterial(new Plastic());
        System.out.println(plasticPrinter);
    }
}
