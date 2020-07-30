package ua.com.javacore.funcinterface;

public interface CustomInterface {

    default void print() {
        printHelloWorld();
    }

    static void printHelloWorld(){
        printText("Hello world");
    }

    static void printText(String text) {
        System.out.println(text);
    }
}
