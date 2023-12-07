package Model;

import javax.persistence.*;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passId")
    private int passId;
    @Column(name = "passName")
    private String passName;
    @Column(name = "passCountry")
    private String passCountry;

    public Passport() {
    }

    public Passport(String passName, String passCountry) {
        this.passName = passName;
        this.passCountry = passCountry;
    }

    public int getPassId() {
        return passId;
    }

    public void setPassId(int passId) {
        this.passId = passId;
    }

    public String getPassName() {
        return passName;
    }

    public void setPassName(String passName) {
        this.passName = passName;
    }

    public String getPassCountry() {
        return passCountry;
    }

    public void setPassCountry(String passCountry) {
        this.passCountry = passCountry;
    }
}
