package org.example.generics;

class ObjectServer {
    Object item;

    public void setItem(Object item) {
        this.item = item;
    }

    public Object getItem() {
        return item;
    }
}

// 지네릭 클래스 선언 방법
// 클래스 옆에 <T>를 붙이고 'Object'를 모두 'T'로 바꾼다.
// GenericsClass<T>에서 T를 '타입변수'라고 하며, 임의의 참조형 타입을 의미한다.
public class GenericServer<T> {
    T item;
//    static T item2; // 에러 발생: static 멤버에 타입 변수 T를 사용할 수 없다. 대입된 타입의 종류에 관계 없이 동일하게 동작해야 되기 떄문이다.
    T[] itemArr;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void createArr(int size) {
//        itemArr = new T[size]; // 에러 발생: new 연산자는 컴파일 시점에 타입 T가 뭔지 정확히 알아야 한다.
    }
}
