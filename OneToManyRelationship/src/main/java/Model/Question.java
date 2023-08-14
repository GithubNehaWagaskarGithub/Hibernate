package Model;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="q_generator")
    @SequenceGenerator(name = "q_generator",initialValue = 5000,allocationSize = 10)
    @Column(name = "q_Id")
    private int qId;

    @Column(name = "q_Name")
    private String qName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "t_Ref")
    private Topic tRef;

    public Question() {
    }

    public Question(String qName, Topic tRef) {
        this.qName = qName;
        this.tRef = tRef;
    }

    public int getqId() {
        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
    }

    public String getqName() {
        return qName;
    }

    public void setqName(String qName) {
        this.qName = qName;
    }

    public Topic gettRef() {
        return tRef;
    }

    public void settRef(Topic tRef) {
        this.tRef = tRef;
    }
}
