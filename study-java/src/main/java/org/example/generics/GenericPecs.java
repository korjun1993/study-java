package org.example.generics;

import java.util.List;

/**
 * Producer - Extends : 데이터를 생산(조회)할 때, Component에서는 extends 키워드를 사용한다.
 * Consumer - Super : 데이터를 소비(저장,수정)할 때, Component에서는 super 키워드를 사용한다.
 */
public class GenericPecs {

    private static void testWithExtends(List<? extends Fruit> list) {
//        list.add(new Fruit()); // compile error!
//        list.add(new Apple()); // compile error!
//        list.add(new Banana()); // compile error!

        Fruit f = list.get(0);
    }

    private static void testWithSuper(List<? super Fruit> list) {
        list.add(new Fruit());
        list.add(new Apple());
        list.add(new Banana());

//        Fruit f = list.get(0); // compile error!
    }
}
