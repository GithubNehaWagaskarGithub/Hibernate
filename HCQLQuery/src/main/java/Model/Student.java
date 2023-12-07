package Model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sId")
    private int sId;
    @Column(name = "sName")
    private String sName;
    @Column(name = "sStream")
    private String sStream;
    @Column(name = "sFees")
    private double sFees;

    public Student() {
    }

    public Student(String sName, String sStream, double sFees) {
        this.sName = sName;
        this.sStream = sStream;
        this.sFees = sFees;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsStream() {
        return sStream;
    }

    public void setsStream(String sStream) {
        this.sStream = sStream;
    }

    public double getsFees() {
        return sFees;
    }

    public void setsFees(double sFees) {
        this.sFees = sFees;
    }
}
