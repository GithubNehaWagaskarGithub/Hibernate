package Model;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)         //When we are use Auto-Increment for column Id then we have to use
                                                                //GenerationType is IDENTITY
    @Column(name="cId")
    private int cId;
    @Column(name="cName")
    private String cName;
    @Column(name="cAdd")
    private String sAdd;

    public Customer() {

    }

    public Customer(String cName, String sAdd) {
        this.cName = cName;
        this.sAdd = sAdd;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getsAdd() {
        return sAdd;
    }

    public void setsAdd(String sAdd) {
        this.sAdd = sAdd;
    }
}
