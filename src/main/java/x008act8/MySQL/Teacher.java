package x008act8.MySQL;

public class Teacher {

    private int id;
    private String firstName;
    private String lastName;

    public Teacher(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Teacher(){

    }

    public int getID() {

        return id;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    @Override
    public String toString() {
        return firstName + "" + lastName;
    }
}
