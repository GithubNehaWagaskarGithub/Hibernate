package Model;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pp")
    @SequenceGenerator(name = "pp",initialValue = 100,allocationSize = 100)
    @Column(name = "pId")
    private int pId;
    @Column(name = "pName")
    private String pName;
    @Column(name = "pCity")
    private String pCity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passRef")
    private Passport passRef;

    public Person() {  //If you not provide a default constructor then hibernate application will throw
                        //an exception that is NoSuchMethodException
   }

    public Person(String pName, String pCity) {
        this.pName = pName;
        this.pCity = pCity;
    }

    public Person(String pName, String pCity, Passport passRef) {
        this.pName = pName;
        this.pCity = pCity;
        this.passRef = passRef;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpCity() {
        return pCity;
    }

    public void setpCity(String pCity) {
        this.pCity = pCity;
    }

    public Passport getPassRef() {
        return passRef;
    }

    public void setPassRef(Passport passRef) {
        this.passRef = passRef;
    }
}
