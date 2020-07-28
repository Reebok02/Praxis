package practicesb.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;


class MainTask1 {
    private ArrayList<Employee> employees = new ArrayList<>();
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    //добавление сотрудника в список
    private void add() throws IOException {
        System.out.println("Скольких сотрудников вы хотите добавить?");
        int n = Integer.parseInt(input.readLine());
        for (int i = 1; i <= n; i++) {
            System.out.println("Добавляем " + i + "-го сотрудника: \n" + "Введите фамилию ");
            String surname = input.readLine();
            System.out.println("Введите имя");
            String name = input.readLine();
            System.out.println("Введите должность");
            String position = input.readLine();
            System.out.println("Введите размер зарплаты");
            int salary = Integer.parseInt(input.readLine());
            Employee employee = new Employee(name, surname, position, salary);
            employees.add(employee);
        }
    }

    //поиск по должности
    private void searchPosition() throws IOException {
        System.out.println("Введите название должности");
        String position = input.readLine();
        boolean isFound = false;
        for (Employee employee : employees) {
            if (position.equals(employee.getPosition())) {
                System.out.print(employee.getSurname() + " " + employee.getName() + "\t");
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("Сотрудников с данной должностью нет в списке");
        }

    }

    //вывод информации о сотрудниках на экран
    private void showInformation() {
        if (employees.size() == 0) {
            System.out.println("Список сотрудников пуст");
        } else {
            System.out.println("Фамилия" + "\t\t\t" + "Имя" + "\t\t\t" + "Должность" + "\t\t\t" + "Зарплата");
            for (int i = 0; i < employees.size(); i++) {
                System.out.printf("%25s", employees.get(i).getSurname() + "\t\t\t" + employees.get(i).getName() + "\t\t\t" + employees.get(i).getPosition() + "\t\t\t" + employees.get(i).getSalary());
                System.out.println();
            }
        }
    }

    //сортировка по фамилии и по зарплате
    private void sorting() {
        Comparator<Employee> comparator = Comparator.comparing(Employee::getSurname);
        comparator = comparator.thenComparing(Employee::getSalary);
        employees.sort(comparator);
        System.out.println("Список отсортирован!");
    }


    //меню выбора следующего действия
    private void showMenuChoise() throws IOException {
        while (true) {
            System.out.println();
            System.out.println("1. Добавить сотрудника \n" +
                    "2. Вывести информацию о сотрудниках \n" +
                    "3. Поиск сотрудника по должности \n" +
                    "4. Сортировка списка по фамилии и по зарплате \n" +
                    "5. Выход");
            int num = Integer.parseInt(input.readLine());
            switch (num) {
                case 1:
                    add();
                    break;
                case 2:
                    showInformation();
                    break;
                case 3:
                    searchPosition();
                    break;
                case 4:
                    sorting();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Введена неправильно цифра");
            }
        }
    }

    class Employee {
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

    public static void main(String[] args) throws IOException {
        MainTask1 mainTask1 = new MainTask1();
        mainTask1.showMenuChoise();
    }
}