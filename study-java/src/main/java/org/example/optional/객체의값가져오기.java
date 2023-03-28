package org.example.optional;

import java.util.Optional;

public class 객체의값가져오기 {
    public static void main(String[] args) {
        //Optional 객체에 저장된 값을 가져올 때는 get()을 사용한다.
        //값이 Null일 때는 NoSuchElementException이 발생한다.
        Optional<String> optVal = Optional.of("abc");
        String str1 = optVal.get();

        //값이 Null일 때를 대비하여 orElse()로 대체할 값을 지정
        String str2 = optVal.orElse("empty");

        //값이 Null일 때를 대비하여, Null을 대체할 값을 반환하는 람다식을 지정
        String str3 = optVal.orElseGet(() -> "ABC");

        //값이 Null일 때를 대비하여, 지정된 예외를 발생
        String str4 = optVal.orElseThrow(NullPointerException::new);

        //값이 존재하는지 확인
        optVal.isPresent();
    }
}
