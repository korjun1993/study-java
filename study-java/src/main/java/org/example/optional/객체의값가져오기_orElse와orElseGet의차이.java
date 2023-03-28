package org.example.optional;

import java.util.Optional;

/**
 * public T orElse(T other) {
 * return value != null ? value : other;
 * }
 * <p>
 * public T orElseGet(Supplier<? extends T> other) {
 * return value != null ? value : other.get();
 * }
 */
public class 객체의값가져오기_orElse와orElseGet의차이 {
    public static void main(String[] args) {
        String result = "";
        String userEmail = "Empty";

        /**
         * orElse
         * getUserEmail()을 호출하고 결과값을 orElse()의 매개변수로 전달
         */
        result = Optional.ofNullable(userEmail).orElse(getUserEmail()); //getUserEmail() called 출력

        System.out.println("======");

        /**
         * orElseGet
         * getUserEmail() 함수형 인터페이스를 orElseGet()의 매개변수로 전달
         * orElseGet()은 value가 Null이 아니므로 getUserEmail() 호출X
         */
        result = Optional.ofNullable(userEmail).orElseGet(() -> getUserEmail()); //getUserEmail() called 출력X
    }

    private static String getUserEmail() {
        System.out.println("getUserEmail() called");
        return "korjun1993@tistory.com";
    }
}
