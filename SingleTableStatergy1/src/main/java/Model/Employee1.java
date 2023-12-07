package Model;

import javax.persistence.*;

@Entity
@Table(name = "employee1")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "E_Type",discriminatorType = DiscriminatorType.STRING)
public class Employee1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "E_Id")
    private int eId;
    @Column(name = "E_Name")
    private String eName;
    @Column(name = "E_Sal")
    private double eSal;

    public Employee1() {
    }

    public Employee1(String eName, double eSal) {
        this.eName = eName;
        this.eSal = eSal;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public double geteSal() {
        return eSal;
    }

    public void seteSal(double eSal) {
        this.eSal = eSal;
    }
}
