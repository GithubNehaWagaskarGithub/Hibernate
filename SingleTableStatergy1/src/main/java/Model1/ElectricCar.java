package Model1;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "car")
@DiscriminatorValue(value = "eleCar")
public class ElectricCar extends Car {
    @Column(name = "eleType")
    private String EleCarType;
    @Column(name = "warranty")
    private String warranty;

    public ElectricCar() {
    }

    public ElectricCar(String cName, double cPrice, String eleCarType, String warranty) {
        super(cName, cPrice);
        EleCarType = eleCarType;
        this.warranty = warranty;
    }

    public String getEleCarType() {
        return EleCarType;
    }

    public void setEleCarType(String eleCarType) {
        EleCarType = eleCarType;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }
}
