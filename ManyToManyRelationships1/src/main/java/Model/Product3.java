package Model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "product3")
public class Product3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pId")
    private int pId;
    @Column(name = "pName")
    private String pName;

    @Column(name="pPrice")
    private double pPrice;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "custpro",joinColumns = @JoinColumn(name = "proRef"),inverseJoinColumns = @JoinColumn(name = "custRef"))
    private List<Customer3> customer3List;

    public Product3() {
    }

    public Product3(String pName, double pPrice) {
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

    public List<Customer3> getCustomer3List() {
        return customer3List;
    }

    public void setCustomer3List(List<Customer3> customer3List) {
        this.customer3List = customer3List;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    public void addData(Customer3 customer3)
    {
        if(customer3List==null)
        {
            customer3List=new LinkedList<>();
        }
        customer3List.add(customer3);
    }
}
