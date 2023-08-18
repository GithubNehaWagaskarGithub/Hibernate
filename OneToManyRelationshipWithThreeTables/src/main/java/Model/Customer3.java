package Model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "customer3")
public class Customer3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_Id")
    private int cId;
    @Column(name="C_Name")
    private String cName;
    @Column(name = "C_City")
    private  String cCity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "B_Ref")
    private Branch bRef;

    @OneToMany(mappedBy = "cRef",cascade = CascadeType.ALL)
    private List<BankAccount> bankAccountList;


    public Customer3() {
    }

    public Customer3(String cName, String cCity, Branch bRef) {
        this.cName = cName;
        this.cCity = cCity;
        this.bRef = bRef;
    }

    public Customer3(String cName, String cCity, Branch bRef, List<BankAccount> bankAccountList) {
        this.cName = cName;
        this.cCity = cCity;
        this.bRef = bRef;
        this.bankAccountList = bankAccountList;
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

    public String getcCity() {
        return cCity;
    }

    public void setcCity(String cCity) {
        this.cCity = cCity;
    }

    public Branch getbRef() {
        return bRef;
    }

    public void setbRef(Branch bRef) {
        this.bRef = bRef;
    }

    public List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    public void setBankAccountList(List<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }

    public void addBankAccount(BankAccount bankAccount)
    {
        if (bankAccountList==null)
        {
            bankAccountList=new LinkedList<>();
        }
        bankAccountList.add(bankAccount);
        bankAccount.setcRef(this);
    }
}
