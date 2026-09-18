package pattern.structural_pattern;

import java.util.ArrayList;
import java.util.List;

public class Composite {

    public static void main(String[] args) {
        Employee ceo = new Employee("Tom", "CEO", 30000);
        Employee headSales = new Employee("Jenny", "Head Sales", 20000);
        Employee headMarketing = new Employee("Michael", "Head Marketing", 20000);

        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);

        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

        ceo.add(headSales);
        ceo.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        System.out.println(ceo);
        for (Employee headEmployee : ceo.getSubordinates()) {
            System.out.println(headEmployee);
            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
        }
    }

}

class Employee {

    private String name;

    private String dept;

    private Integer salary;

    private List<Employee> subordinates;

    public Employee(String name, String dept, Integer salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.subordinates = new ArrayList<>();
    }

    public void add(Employee employee) {
        java.util.Objects.requireNonNull(employee);
        if (employee.contains(this)) throw new IllegalArgumentException("cycle in employee hierarchy");
        if (subordinates.contains(employee)) throw new IllegalArgumentException("duplicate child");
        subordinates.add(employee);
    }

    private boolean contains(Employee target) {
        java.util.Set<Employee> visited = new java.util.HashSet<>();
        java.util.Deque<Employee> pending = new java.util.ArrayDeque<>();
        pending.push(this);
        while (!pending.isEmpty()) {
            Employee current = pending.pop();
            if (current == target) return true;
            if (visited.add(current)) pending.addAll(current.subordinates);
        }
        return false;
    }

    public void remove(Employee employee) {
        subordinates.remove(employee);
    }

    public List<Employee> getSubordinates() {
        return List.copyOf(this.subordinates);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                ", subordinates number=" + subordinates.size() +
                '}';
    }

}
