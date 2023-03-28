package org.example.optional;

import java.util.Optional;
import java.util.OptionalInt;

/**
 * Optional<T>: T get()
 * OptionalInt: int getAsInt()
 * OptionalLong: long getAsLong()
 * OptionalDouble: double getAsDouble()
 */
public class 기본형을값으로갖는Optional {
    /**
     * public final class OptionalInt {
     * private final boolean isPresent;
     * private final int value; // int타입의 변수
     * }
     */
    public static void main(String[] args) {
        OptionalInt opt = OptionalInt.of(0);
        OptionalInt opt2 = OptionalInt.empty();

        //값이 0인것과 없는 것은 구별 가능하다.
        System.out.println(opt.isPresent()); //true
        System.out.println(opt2.isPresent()); //false

        System.out.println(opt.getAsInt()); //0
        System.out.println(opt2.getAsInt()); //NoSuchElementException 발생
        System.out.println(opt.equals(opt2)); //false

        //Optional 객체의 경우 null을 저장하면 비어있는 것과 동일하게 취급한다.
        Optional<String> opt3 = Optional.ofNullable(null);
        Optional<String> opt4 = Optional.empty();
        System.out.println(opt3.equals(opt4)); //true
    }
}
