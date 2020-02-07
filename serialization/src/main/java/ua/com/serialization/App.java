package ua.com.serialization;

public class App {

    // File name in Linux format, Windows format is "c\\\\"
    private static final String FILE_NAME = "/home/alex/Desktop/employee.ser";

    public static void main(String[] args) {
        SerializationUtils<Employee> employeeSerializationUtils = new SerializationUtils<>();
        Employee employee = new Employee("Antony", "Hopkins", 7000000);
        employeeSerializationUtils.encodeAndSaveToFile("/home/alex/Desktop/employee.ser", employee);
//        Employee employee = (Employee) employeeSerializationUtils.loadFromFileAndDecode("/home/alex/Desktop/employee.ser");
//        System.out.println(employee);
    }
}
