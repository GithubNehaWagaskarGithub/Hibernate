package Model;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="pid_generator")
    @SequenceGenerator(name="pid_generator",initialValue = 100,allocationSize = 10)
    @Column(name="pId")
    private int pId;
    @Column(name="pName")
    private String pName;
    @Column(name="pPrice")
    private double pPrice;

    public Product(String pName, double pPrice) {
        this.pName = pName;
        this.pPrice = pPrice;
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
}
