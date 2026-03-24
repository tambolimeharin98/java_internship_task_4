import java.util.*;

// Employee class
class Employee implements Comparable<Employee> {

    int id;
    String name;
    String department;

    // constructor
    Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // natural sorting by id
    public int compareTo(Employee e) {
        return this.id - e.id;
    }

    public String toString() {
        return id + " " + name + " " + department;
    }

    // for Set uniqueness
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee e = (Employee) obj;
        return this.id == e.id;
    }

    public int hashCode() {
        return Objects.hash(id);
    }
}

// Generic class
class DataSorter<T extends Comparable<T>> {

    public void sortList(List<T> list) {
        Collections.sort(list);
    }
}

public class CollectionsTask {

    public static void main(String[] args) {

        // LIST
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(3, "Ravi", "IT"));
        list.add(new Employee(1, "Aman", "HR"));
        list.add(new Employee(2, "Neha", "Finance"));

        System.out.println("Original List:");
        for (Employee e : list) {
            System.out.println(e);
        }

        // SET (unique)
        Set<Employee> set = new HashSet<>(list);
        set.add(new Employee(1, "Aman", "HR"));  // duplicate

        System.out.println("\nSet Size (unique employees): " + set.size());

        // MAP (ID -> Employee)
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : list) {
            map.put(e.id, e);
        }

        System.out.println("\nEmployee with ID 2:");
        System.out.println(map.get(2));

        // GENERIC SORTING
        DataSorter<Employee> sorter = new DataSorter<>();
        sorter.sortList(list);

        System.out.println("\nSorted by ID:");
        for (Employee e : list) {
            System.out.println(e);
        }
    }
}