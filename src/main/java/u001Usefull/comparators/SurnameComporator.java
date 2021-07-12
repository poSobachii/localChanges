package u001Usefull.comparators;

import java.util.Comparator;

class SurnameComporator implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        if (emp1.getSurname().equals("Suxena")) {
            return -1;
        }
        if (emp2.getSurname().equals("Suxena")) {
            return 1;
        }
        return emp1.getName().compareTo(emp2.getName());
    }
}
