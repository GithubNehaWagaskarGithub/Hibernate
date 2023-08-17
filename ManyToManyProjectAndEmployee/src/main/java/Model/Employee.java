package Model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "E_No")
    private int eNo;
    @Column(name = "E_Name")
    private String eName;
    @Column(name = "Join_Date")
    private String joinDate;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_project",joinColumns = @JoinColumn(name = "Emp_Ref"),inverseJoinColumns = @JoinColumn(name="Pro_Ref"))
    private List<Project> projectList;

    public Employee() {
    }

    public Employee(String eName, String joinDate) {
        this.eName = eName;
        this.joinDate = joinDate;
    }

    public Employee(String eName, String joinDate, List<Project> projectList) {
        this.eName = eName;
        this.joinDate = joinDate;
        this.projectList = projectList;
    }

    public int geteNo() {
        return eNo;
    }

    public void seteNo(int eNo) {
        this.eNo = eNo;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public void addProject(Project project)
    {
        if(projectList==null)
        {
            projectList=new LinkedList<>();
        }
        projectList.add(project);
    }
}
