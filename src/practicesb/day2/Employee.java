package practicesb.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;



public class Employee {
    private String name, surname, position;
    private int salary;


    public Employee(String name, String surname, String position, int salary) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }
}