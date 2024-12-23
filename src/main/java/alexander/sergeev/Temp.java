package alexander.sergeev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Temp {

    public static void main(String[] args) {
        Employee employee1 = new Employee(1, 5, List.of(2, 3));
        Employee employee2 = new Employee(2, 3, List.of(4));
        Employee employee3 = new Employee(3, 4, List.of());
        Employee employee4 = new Employee(4, 1, List.of());
        List<Employee> list = List.of(employee1, employee2, employee3, employee4);
        int id = 1;
        System.out.println(getImportance(list, id));
    }

    static List<Integer> subordinates = new ArrayList<>();
    static Map<Integer, Employee> map = new HashMap<>();

    public static int getImportance(List<Employee> employees, int id) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.id == id) {
                sum += employee.importance;
            }
            map.put(employee.id, employee);
        }
        getSubordinates(id);
        for (int ids : subordinates) {
            sum += map.get(ids).importance;
        }
        return sum;
    }

    private static void getSubordinates(int id) {
        Employee employee = map.get(id);
        if (employee == null && employee.subordinates.isEmpty()) return;
        subordinates.addAll(employee.subordinates);
        for (int ids : employee.subordinates) {
            getSubordinates(ids);
        }
    }

    static class Employee {

        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", importance=" + importance +
                    ", subordinates=" + subordinates +
                    '}';
        }
    }
}