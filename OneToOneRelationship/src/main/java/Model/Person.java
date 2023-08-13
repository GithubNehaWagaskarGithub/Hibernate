package Model;

import javax.persistence.*;

@Entity
@Table(name="person")

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PId")
    private int PId;
    @Column(name = "PName")
    private String PName;
    @Column(name = "PAdd")
    private String PAdd;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ARef")
    private AdharCard ARef;

    public Person() {

    }

    public Person(int PId) {
        this.PId = PId;
    }

    public Person(String PName, String PAdd, AdharCard ARef) {
        this.PName = PName;
        this.PAdd = PAdd;
        this.ARef = ARef;
    }

    public Person(Class<Person> personClass, int i) {
    }

    public int getPId() {
        return PId;
    }

    public void setPId(int PId) {
        this.PId = PId;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public String getPAdd() {
        return PAdd;
    }

    public void setPAdd(String PAdd) {
        this.PAdd = PAdd;
    }

    public AdharCard getARef() {
        return ARef;
    }

    public void setARef(AdharCard ARef) {
        this.ARef = ARef;
    }
}
