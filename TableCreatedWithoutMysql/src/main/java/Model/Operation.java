package Model;

import javax.persistence.*;

@Entity
@Table(name = "operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Address")
    private String Address;
    @Column(name = "Marks")
    private double Marks;

    public Operation() {
    }

    public Operation(String name, String address, double marks) {
        Name = name;
        Address = address;
        Marks = marks;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public double getMarks() {
        return Marks;
    }

    public void setMarks(double marks) {
        Marks = marks;
    }
}
