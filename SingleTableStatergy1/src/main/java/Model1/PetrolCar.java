package Model1;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "car")
@DiscriminatorValue(value = "petCar")
public class PetrolCar extends Car {
    @Column(name = "petCarType")
    private String petCarType;
    @Column(name = "insurance")
    private String Insurance;

    public PetrolCar() {
    }

    public PetrolCar(String cName, double cPrice, String petCarType, String insurance) {
        super(cName, cPrice);
        this.petCarType = petCarType;
        Insurance = insurance;
    }

    public String getPetCarType() {
        return petCarType;
    }

    public void setPetCarType(String petCarType) {
        this.petCarType = petCarType;
    }

    public String getInsurance() {
        return Insurance;
    }

    public void setInsurance(String insurance) {
        Insurance = insurance;
    }
}
