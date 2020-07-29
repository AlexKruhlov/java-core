package ua.com.javacore.funcinterface;

public class App {

    public static void main(String[] args) {
        SumInterface summer = Integer::sum;
        System.out.println(summer.sum(1,2));
    }
}
