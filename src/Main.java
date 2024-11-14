import java.util.Random;

public class Main {

    private final static Random RANDOM = new Random();
    private final static String[] NAMES = {"Максим", "Олег", "Иван", "Алексей"};
    private final static String[] SURNAMES = {"Максимов", "Олегов", "Иванов", "Алексеев"};
    private final static String[] PATRONYMIC = {"Максимович", "Олегович", "Иванович", "Алексеевич"};

    public final static Employee[] EMPLOYEES = new Employee[10];

    private static void initEmployees() {

        for (int i = 0; i < EMPLOYEES.length; i++) {
            String fullName = SURNAMES[RANDOM.nextInt(0, SURNAMES.length)] + " " +
                    NAMES[RANDOM.nextInt(0, NAMES.length)] + " " +
                    PATRONYMIC[RANDOM.nextInt(0, PATRONYMIC.length)];
            EMPLOYEES[i] = new Employee(fullName, RANDOM.nextInt(0, 6), RANDOM.nextInt(50000, 100000));

        }

    }


    public static void main(String[] args) {
        initEmployees();
        print();
        System.out.println("Сумма ЗП: " + calculateSumsSalaries());
        System.out.println("Минимальная ЗП: " + findEmployeeMinSalary());
        System.out.println("Максимальная ЗП: " + findEmployeeMaxSalary());
        System.out.println("Средняя ЗП: " + calculateAveragesSalaries());
        printFullNames();
    }

    private static void print() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private static int calculateSumsSalaries() {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee findEmployeeMinSalary() {
        Employee employeeMinSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeMinSalary == null || employee.getSalary() < employeeMinSalary.getSalary()) {
                employeeMinSalary = employee;
            }
        }
        return employeeMinSalary;
    }

    private static Employee findEmployeeMaxSalary() {
        Employee employeeMaxSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeMaxSalary == null || employee.getSalary() > employeeMaxSalary.getSalary()) {
                employeeMaxSalary = employee;
            }
        }
        return employeeMaxSalary;
    }

    private static double calculateAveragesSalaries() {

        return (double) calculateSumsSalaries() / EMPLOYEES.length;
    }

    private static void printFullNames() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }
    }

}