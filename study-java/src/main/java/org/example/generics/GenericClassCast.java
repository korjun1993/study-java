package org.example.generics;

public class GenericClassCast {
    public static void main(String[] args) {
        // 지네릭 타입과 넌지네릭(non-generic) 타입간의 형변환은 항상 가능하다.
        FruitBox box = null;
        FruitBox<Object> objBox = null;
        box = objBox;
        objBox = box;


        // 대입된 타입이 다른 지네릭 타입간의 형변환은 항상 불가능하다.
        FruitBox<String> strBox = null;
//        strBox = (FruitBox<String>) objBox; // Error: FruitBox<String> ⧣ FruitBox<Object>
//        objBox = (FruitBox<Object>) strBox; // Error: FruitBox<Object> ⧣ FruitBox<String>


        // 다음 경우에도 형변환이 가능하다.
        FruitBox<? extends Fruit> fruitBox = null;
        FruitBox<Apple> appleBox = null;
        fruitBox = appleBox;
        appleBox = (FruitBox<Apple>) fruitBox;


        // 와일드 카드가 사용된 지네릭 타입끼리 형변환이 가능하다.
        FruitBox<? extends Banana> bananaBox = null;
        bananaBox = (FruitBox<? extends Banana>) fruitBox;
        fruitBox = (FruitBox<? extends Fruit>) bananaBox;
//        appleBox = (FruitBox<Apple>) bananaBox; // Error: FruitBox<Apple>, FruitBox<Banana> -> Apple, Banana 부모자식 관계가 아니라서 캐스팅이 안되는 것 같다.
    }
}
