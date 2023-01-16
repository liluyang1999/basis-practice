import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Java46 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        //write your code here......

    }
}
class Employee{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        System.out.println("初始化函数！！！");
        this.name = name;
        this.salary = salary;
        System.out.println("名字为：" + this.name);
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