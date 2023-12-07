package Model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "customer3")
public class Customer3 {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ccpp")
    @SequenceGenerator(name = "ccpp",initialValue = 100,allocationSize = 100)
    @Column(name = "cId")
    private int cId;
    @Column(name = "cName")
    private String cName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "custpro",joinColumns = @JoinColumn(name = "custRef"),inverseJoinColumns = @JoinColumn(name = "proRef"))
    private List<Product3> product3List;

    public Customer3() {
    }

    public Customer3(String cName) {
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

    public List<Product3> getProduct3List() {
        return product3List;
    }

    public void setProduct3List(List<Product3> product3List) {
        this.product3List = product3List;
    }

    public void addData(Product3 product3)
    {
        if(product3List==null)
        {
            product3List=new LinkedList<>();
        }
        product3List.add(product3);
    }
}
