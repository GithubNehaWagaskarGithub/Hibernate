package Model;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value ="ContractEmp")
@Table(name = "employee2")
public class ContractEmp extends Employee2{
    @Column(name = "Time_Duration")
    private String timeDuration;
    @Column(name = "Con_Desi")
    private String conDesi;

    public ContractEmp() {
    }

    public ContractEmp(String eName, double eSal, String timeDuration, String conDesi) {
        super(eName, eSal);
        this.timeDuration = timeDuration;
        this.conDesi = conDesi;
    }

    public String getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(String timeDuration) {
        this.timeDuration = timeDuration;
    }

    public String getConDesi() {
        return conDesi;
    }

    public void setConDesi(String conDesi) {
        this.conDesi = conDesi;
    }
}
