import java.util.ArrayList;
import java.util.List;

public class Java46 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        //write your code here......
        employees.add(new Employee("小明", 2500));
        employees.add(new Employee("小军", 8000));
        employees.add(new Employee("小红", 100000));

        for (Employee each : employees) {
            String name = each.getName();
            double salary = each.getSalary() - 3500;
            double tax;
            if (salary > 80000) {
                tax = salary * 0.45 - 13505;
            } else if (salary > 55000) {
                tax = salary * 0.35 - 5505;
            } else if (salary > 35000) {
                tax = salary * 0.3 - 2755;
            } else if (salary > 9000) {
                tax = salary * 0.25 - 1005;
            } else if (salary > 4500) {
                tax = salary * 0.2 - 555;
            } else if (salary > 1500) {
                tax = salary * 0.1 - 105;
            } else if (salary > 0) {
                tax = salary * 0.03;
            } else {
                tax = 0.0;
            }
            System.out.printf(name + "应该缴纳的个人所得税是：%。1f\n", tax);
        }
    }

    static class Employee{
        private String name;
        private double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }
    }
}
