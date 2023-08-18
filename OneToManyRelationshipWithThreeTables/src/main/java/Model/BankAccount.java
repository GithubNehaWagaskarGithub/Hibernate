package Model;

import javax.persistence.*;

@Entity
@Table(name = "bankaccount")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ba_generator")
    @SequenceGenerator(name = "ba_generator",initialValue = 5000,allocationSize = 1000)
    @Column(name = "BA_No")
    private int baNo;
    @Column(name = "BA_Name")
    private String baName;
    @Column(name = "BA_Type")
    private String baType;
    @Column(name = "BA_Balance")
    private double baBalance;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "C_Ref")
    private Customer3 cRef;

    public BankAccount() {
    }

    public BankAccount(String baName, String baType, double baBalance, Customer3 cRef) {
        this.baName = baName;
        this.baType = baType;
        this.baBalance = baBalance;
        this.cRef = cRef;
    }

    public int getBaNo() {
        return baNo;
    }

    public void setBaNo(int baNo) {
        this.baNo = baNo;
    }

    public String getBaName() {
        return baName;
    }

    public void setBaName(String baName) {
        this.baName = baName;
    }

    public String getBaType() {
        return baType;
    }

    public void setBaType(String baType) {
        this.baType = baType;
    }

    public double getBaBalance() {
        return baBalance;
    }

    public void setBaBalance(double baBalance) {
        this.baBalance = baBalance;
    }

    public Customer3 getcRef() {
        return cRef;
    }

    public void setcRef(Customer3 cRef) {
        this.cRef = cRef;
    }
}
