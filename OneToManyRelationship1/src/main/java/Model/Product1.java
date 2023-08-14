package Model;

import javax.naming.Name;
import javax.persistence.*;

@Entity
@Table(name="product1")
public class Product1 {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "p_generator")
    @SequenceGenerator(name = "p_generator",initialValue = 100,allocationSize = 100)
    @Column(name = "P_Id")
    private int pId;
    @Column(name = "P_Name")
    private String pName;
    @Column(name = "P_Price")
    private double pPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "C_Ref")
    private Customer1 cRef;

    public Product1() {
    }

    public Product1(String pName, double pPrice, Customer1 cRef) {
        this.pName = pName;
        this.pPrice = pPrice;
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

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    public Customer1 getcRef() {
        return cRef;
    }

    public void setcRef(Customer1 cRef) {
        this.cRef = cRef;
    }
}
