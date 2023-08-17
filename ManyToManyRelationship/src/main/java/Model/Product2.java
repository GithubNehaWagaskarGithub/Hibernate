package Model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "product2")
public class Product2 {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cp_generator")
    @SequenceGenerator(name = "cp_generator",initialValue = 1000,allocationSize = 10)
    @Column(name = "P_Id")
    private int pId;
    @Column(name = "P_Name")
    private String pName;
    @Column(name = "P_Price")
    private double pPrice;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customer_product",joinColumns = @JoinColumn(name = "cus_ref"),inverseJoinColumns = @JoinColumn(name = "pro_ref"))
    private List<Customer2> customer2List;

    public Product2() {
    }

    public Product2(String pName) {
        this.pName = pName;
    }

    public Product2(String pName, double pPrice) {
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

    public List<Customer2> getCustomer2List() {
        return customer2List;
    }

    public void setCustomer2List(List<Customer2> customer2List) {
        this.customer2List = customer2List;
    }
    public void addData(Customer2 cref)
    {
        if(customer2List==null)
        {
            customer2List=new LinkedList<>();
        }
        customer2List.add(cref);
    }
}
