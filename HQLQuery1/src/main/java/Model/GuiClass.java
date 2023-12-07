package Model;

import javax.persistence.*;


@Entity
@Table(name = "guiclass")
public class GuiClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gId")
    private int gId;
    @Column(name = "gName")
    private String gName;
    @Column(name = "Time")
    private String  time;
    @Column(name = "Fees")
    private double Fees;

    public GuiClass() {
    }

    public GuiClass(String gName, String  time, double fees) {
        this.gName = gName;
        this.time = time;
        Fees = fees;
    }

    public int getgId() {
        return gId;
    }

    public void setgId(int gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String  getTime() {
        return time;
    }

    public void setTime(String  time) {
        this.time = time;
    }

    public double getFees() {
        return Fees;
    }

    public void setFees(double fees) {
        Fees = fees;
    }
}
