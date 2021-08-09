package chap04;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassTest {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            ClassNotFoundException, NoSuchMethodException, SecurityException {
        Person person = new Person("Lee");
        System.out.println(person);

        Class c1 = Class.forName("chap04.Person");
        Person person1 = (Person)c1.newInstance();
        System.out.println(person1);

        Class[] parameterTypes = {String.class};
        Constructor cons = c1.getConstructor(parameterTypes);

        Object[] initargs = {"Kim"};
        Person personLee = (Person)cons.newInstance(initargs);
        System.out.println(personLee);
    }
}
