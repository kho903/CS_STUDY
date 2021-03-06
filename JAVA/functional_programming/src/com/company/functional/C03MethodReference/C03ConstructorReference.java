package com.company.functional.C03MethodReference;

import com.company.functional.C03MethodReference.model.Car;
import com.company.functional.C03MethodReference.model.Sedan;
import com.company.functional.C03MethodReference.model.Suv;
import com.company.functional.C03MethodReference.model.Van;
import com.company.functional.C03MethodReference.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class C03ConstructorReference {

    public static void main(String[] args) {
        User user = new User(1, "Alice");
//        BiFunction<Integer, String, User> userCreator = (Integer id, String name) -> new User(id, name);
        BiFunction<Integer, String, User> userCreator = User::new;
        User charlie = userCreator.apply(3, "Charlie");
        System.out.println(charlie);

        String[][] inputs = new String[][] {
                {"sedan", "Sonata", "Hyundai"},
                {"van", "Sienna", "Toyota"},
                {"sedan", "Model S", "Tesla"},
                {"suv", "Sorento", "KIA"}
        }; // 기존 방식

        Map<String, BiFunction<String, String, Car>> carTypeToConstructorMap = new HashMap<>();
        carTypeToConstructorMap.put("sedan", Sedan::new);
        carTypeToConstructorMap.put("suv", Suv::new);
        carTypeToConstructorMap.put("van", Van::new);

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            String[] input = inputs[i];
            String carType = input[0];
            String name = input[1];
            String brand = input[2];

            cars.add(carTypeToConstructorMap.get(carType).apply(name, brand));
        }
        for (Car car : cars) {
            car.drive();
        }
    }
}
