package ch.tbz.task.address;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Address {

    @Id
    private Integer id;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private Date registrationDate;

    public Address(int id, String firstname, String lastname, String phonenumber) {
        this(id, firstname, lastname, phonenumber, null);
    }
    public Address(int id, String firstname, String lastname, String phonenumber, Date registrationDate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.registrationDate = registrationDate;
    }

    public Address() {

    }
}
