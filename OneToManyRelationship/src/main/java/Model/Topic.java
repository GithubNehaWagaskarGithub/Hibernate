package Model;

import org.hibernate.engine.spi.Mapping;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @Column(name = "t_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tId;
    @Column(name = "t_Name")
    private String tName;

    @OneToMany(mappedBy ="tRef", cascade = CascadeType.ALL)
    private List<Question> questionList;

    public Topic() {
    }

    public Topic(String tName) {
        this.tName = tName;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public void addData(Question que)
    {
        if(questionList==null)
        {
            questionList=new LinkedList<>();
        }
        questionList.add(que);
        que.settRef(this);
    }
}
