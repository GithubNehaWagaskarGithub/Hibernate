package Model;

import javax.persistence.*;

@Entity
@Table(name = "product1")
public class Product1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pId")
    private int pId;
    @Column(name = "pName")
    private String pName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cRef")
    private Customer1 cRef;

    public Product1() {
    }

    public Product1(String pName, Customer1 cRef) {
        this.pName = pName;
        this.cRef = cRef;
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

    public Customer1 getcRef() {
        return cRef;
    }

    public void setcRef(Customer1 cRef) {
        this.cRef = cRef;
    }
}
