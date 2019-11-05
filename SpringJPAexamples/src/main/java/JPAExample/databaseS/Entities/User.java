package JPAExample.databaseS.Entities;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.HashMap;
import java.util.Map;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "myUSER")
public class User {

    @Id @GeneratedValue(strategy = IDENTITY) private Long id;
    @Column(name = "USERNAME") private String name;
    @Column(name = "USERSURNAME") private String surname;
    @Column(name = "USERAGE") private int age;
    @Column(name = "EMAILADRESS") private String emailadress;
    @Column(name = "USERADRESS") private String userAdress;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id", referencedColumnName = "id")
//    private EmailAddres address;

//    project example
//    @CollectionTable(name = "paymentagreement_parameters", joinColumns = @JoinColumn(name = "id"))
//    private final Map<String, String> parameters = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

