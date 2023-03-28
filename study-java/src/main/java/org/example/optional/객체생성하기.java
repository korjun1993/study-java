package org.example.optional;

import java.util.Optional;

/**
 * Optional 객체를 생성할 때는 of() 또는 ofNullable()을 사용한다.
 */
public class 객체생성하기 {
    public static void main(String[] args) {
        //참조변수의 값이 null일 가능성이 있으면, ofNullable()을 사용해야한다.
        Optional<String> optVal1 = Optional.ofNullable(null);

        //of(매개변수)는 NullPointerException이 발생한다.
        Optional<String> optVal2 = Optional.of(null); //NullPointerException 발생

        //Optional<T>타입의 참조변수를 기본값으로 초기화할 때는 empty()를 사용한다.
        Optional<String> optVal3 = Optional.empty(); //EMPTY = new Optional<>(null);
    }
}
