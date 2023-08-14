package Model;

import javax.naming.Name;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "customer1")
public class Customer1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_Id")
    private int cId;
    @Column(name = "C_Name")
    private String cName;
    @Column(name = "C_Add")
    private String cAdd;

    @OneToMany(mappedBy = "cRef",cascade = CascadeType.ALL)
    private List<Product1> product1List;

    public Customer1() {
    }

    public Customer1(String cName, String cAdd) {
        this.cName = cName;
        this.cAdd = cAdd;
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

    public String getcAdd() {
        return cAdd;
    }

    public void setcAdd(String cAdd) {
        this.cAdd = cAdd;
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
            product1List=new LinkedList<>();
        }
        product1List.add(product1);
        product1.setcRef(this);
    }
}
