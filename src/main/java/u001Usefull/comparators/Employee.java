package u001Usefull.comparators;

class Employee {
    int id;
    String name;
    String surname;

    Employee(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "\nEmployee id-" + id + " name-" + name + " surname-" + surname;
    }

}
