package ua.com.serialization;

public class App {

    // File name in Linux format, Windows format is "d:\\employee.ser"
    private static final String FILE_NAME = "/home/alex/Desktop/employee.ser";

    public static void main(String[] args) {
        SerializationUtils<Employee> employeeSerializationUtils = new SerializationUtils<>();
        Employee employee = new Employee("Antony", "Hopkins", 7000000);
        employeeSerializationUtils.encodeAndSaveToFile(FILE_NAME, employee);
//        Employee employee = (Employee) employeeSerializationUtils.loadFromFileAndDecode(FILE_NAME);
//        System.out.println(employee);
    }
}
