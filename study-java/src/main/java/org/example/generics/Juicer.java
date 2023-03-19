package org.example.generics;

import java.util.ArrayList;

/**
 * wildcard 사용 예제
 */
public class Juicer {
    // wildcard
    static void makeJuice(FruitBox<? extends Fruit> box) {
        System.out.println("make juice with fruit box");
    }

    // generic method
    // :static member 에서 사용 가능하다.
    // :지네릭 메서드의 타입변수는 지네릭 클래스의 타입변수와 별개의 타입변수이다.
    static <T extends Fruit> void makeJuice2(FruitBox<T> box) {
        System.out.println("make juice with fruit box");
    }
}

class FruitBox<T> {
    private final ArrayList<T> fruits = new ArrayList<>();
}

class Fruit {

}

class Apple extends Fruit {

}

class Banana extends Fruit {

}

class Melon extends Fruit {

}
