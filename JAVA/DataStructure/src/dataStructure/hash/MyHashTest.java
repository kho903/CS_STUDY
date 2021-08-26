package dataStructure.hash;

public class MyHashTest {
    public static void main(String[] args) {
        String name = "DaveLee";
        System.out.println(name.charAt(0)); // D
        System.out.println((int) name.charAt(0)); // 68
        System.out.println((int) (name.charAt(0)) % 20); // 8

//        MyHash.Slot[] hashTable = new MyHash.Slot[20];
//        hashTable[0] = new MyHash.Slot("test");
//        System.out.println(hashTable[0]);
//        System.out.println(hashTable[0].value);

        MyHash mainObject = new MyHash(20);
        mainObject.saveData("KIM", "01011112222");
        mainObject.saveData("LEE", "01022223333");
        mainObject.saveData("KKK", "01033334444");
        mainObject.saveData("KKI", "01044445555");
        // Collision - 해결
        System.out.println(mainObject.getData("KIM"));
        System.out.println(mainObject.getData("KKK"));
        System.out.println(mainObject.getData("KKI"));

        System.out.println("==== LinearProbingHash ====");
        LinearProbingHash linearProbingHash = new LinearProbingHash(20);
        linearProbingHash.saveData("KIM", "01011112222");
        linearProbingHash.saveData("LEE", "01022223333");
        linearProbingHash.saveData("KKK", "01033334444");
        linearProbingHash.saveData("KKI", "01044445555");
        System.out.println(linearProbingHash.getData("KIM"));
        System.out.println(linearProbingHash.getData("KKK"));
        System.out.println(linearProbingHash.getData("KKI"));
    }
}
