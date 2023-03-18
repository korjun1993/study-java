package org.example.generics;

public class GenericClassEx {
    public static void main(String[] args) {
        // Item 타입이 Object 일 때
        ObjectServer objectServer = new ObjectServer();
        objectServer.setItem("Data");

        // Item을 가져다 쓰는 client code
        if (objectServer.getItem() instanceof String) {
            String item = (String) objectServer.getItem();
        }

        // Item 타입이 Generic 일 때
        GenericServer<String> genericServer = new GenericServer<>();
        genericServer.setItem("Data");

        // Item을 가져다 쓰는 client code
        String item = genericServer.getItem();
    }
}
