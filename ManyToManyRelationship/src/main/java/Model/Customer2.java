package Model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "customer2")
public class Customer2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_Id")
    private int cId;
    @Column(name = "C_Name")
    private String cName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customer_product",joinColumns = @JoinColumn(name = "pro_ref"),inverseJoinColumns = @JoinColumn(name = "cus_ref"))
    private List<Product2> product2List;

    public Customer2() {
    }

    public Customer2(String cName) {
        this.cName = cName;
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

    public List<Product2> getProduct2List() {
        return product2List;
    }

    public void setProduct2List(List<Product2> product2List) {
        this.product2List = product2List;
    }

    public void addData(Product2 pref)
    {
        if(product2List==null)
        {
            product2List=new LinkedList<>();
        }
        product2List.add(pref);
    }
}
