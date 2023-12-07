package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "customer1")
public class Customer1 {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cp1")
    @SequenceGenerator(name = "cp1",initialValue = 1001,allocationSize = 1)
    @Column(name = "cId")
    private int cId;

    @Column(name = "cName")
    private String cName;

    @OneToMany(mappedBy = "cRef",cascade = CascadeType.ALL)
    private List<Product1> product1List;

    public Customer1() {
    }

    public Customer1(String cName) {
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

    public List<Product1> getProduct1List() {
        return product1List;
    }

    public void setProduct1List(List<Product1> product1List) {
        this.product1List = product1List;
    }

    public void addData(Product1 product1)
    {
        if(product1List==null)
        {
            product1List=new ArrayList<>();
        }
        product1List.add(product1);
        product1.setcRef(this);
    }
}
