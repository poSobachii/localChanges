package jquery.model;

import jquery.controller.TimeChecker;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "active")
    private boolean active;


    Employee(){

    }

    public Employee(Long id, String name, String lastName, String email, String phone, boolean active) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.active = active;
        TimeChecker.TimeCheck("Employee constructor have requested #1");
    }

    public Employee(String name, String lastName, String email, String phone, boolean active) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.active = active;
        TimeChecker.TimeCheck("Employee constructor have requested #2");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
