package Model1;

import javax.persistence.*;

@Entity
@Table(name = "car")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "cType",discriminatorType = DiscriminatorType.STRING)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cId")
    private int cId;
    @Column(name = "cName")
    private String cName;
    @Column(name = "cPrice")
    private double cPrice;

    public Car() {
    }

    public Car(String cName, double cPrice) {
        this.cName = cName;
        this.cPrice = cPrice;
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

    public double getcPrice() {
        return cPrice;
    }

    public void setcPrice(double cPrice) {
        this.cPrice = cPrice;
    }
}

