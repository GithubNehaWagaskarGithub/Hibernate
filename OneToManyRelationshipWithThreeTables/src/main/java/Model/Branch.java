package Model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "b_generator")
    @SequenceGenerator(name = "b_generator",initialValue = 1000,allocationSize = 10)
    @Column(name = "B_Id")
    private int bId;
    @Column(name = "B_Add")
    private String bAdd;
    @Column(name = "IFSC_Code")
    private  String ifscCode;
    @OneToMany(mappedBy = "bRef",cascade = CascadeType.ALL)
    private List<Customer3> customer3List;

    public Branch() {
    }

    public Branch(String bAdd, String ifscCode) {
        this.bAdd = bAdd;
        this.ifscCode = ifscCode;
    }

    public Branch(String bAdd, String ifscCode, List<Customer3> customer3List) {
        this.bAdd = bAdd;
        this.ifscCode = ifscCode;
        this.customer3List = customer3List;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getbAdd() {
        return bAdd;
    }

    public void setbAdd(String bAdd) {
        this.bAdd = bAdd;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public List<Customer3> getCustomer3List() {
        return customer3List;
    }

    public void setCustomer3List(List<Customer3> customer3List) {
        this.customer3List = customer3List;
    }

    public void addCustomer3(Customer3 customer3)
    {
        if(customer3List==null)
        {
            customer3List=new LinkedList<>();
        }
        customer3List.add(customer3);
        customer3.setbRef(this);
    }
}
