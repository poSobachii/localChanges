package JPAExample.databaseS.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "EMAILTABLE")
public class EmailAdress {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "id") private Long id;
    @Column(name = "email") private String email;
    @Column (name = "domainx") private String domain;
    @Column (name = "host") private String host;

    //    @OneToOne(mappedBy = "email") private User user;


    public EmailAdress(){

    }


}
