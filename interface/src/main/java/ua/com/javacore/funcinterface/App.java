package ua.com.javacore.funcinterface;

public class App {

    public static void main(String[] args) {
        SumFuncInterface summer = Integer::sum;
        System.out.println(summer.sum(1,2));

        CustomInterface.printHelloWorld();
        CustomInterface.printText("My text");

        new CustomInterface(){}.print();
    }
}
