package Model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ep_generator")
    @SequenceGenerator(name = "ep_generator",initialValue = 5000,allocationSize = 10)
    @Column(name = "P_No")
    private int pNo;
    @Column(name = "P_Name")
    private String pName;
    @Column(name = "P_Type")
    private String pType;
    @Column(name = "P_Duration")
    private int pDuration;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_project",joinColumns = @JoinColumn(name = "Pro_Ref"),inverseJoinColumns = @JoinColumn(name = "Emp_Ref"))
    private List<Employee> employeeList;

    public Project() {
    }

    public Project(String pName, String pType, int pDuration) {
        this.pName = pName;
        this.pType = pType;
        this.pDuration = pDuration;
    }

    public Project(String pName, String pType, int pDuration, List<Employee> employeeList) {
        this.pName = pName;
        this.pType = pType;
        this.pDuration = pDuration;
        this.employeeList = employeeList;
    }

    public int getpNo() {
        return pNo;
    }

    public void setpNo(int pNo) {
        this.pNo = pNo;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public int getpDuration() {
        return pDuration;
    }

    public void setpDuration(int pDuration) {
        this.pDuration = pDuration;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    public void addEmployee(Employee employee)
    {
        if(employeeList==null)
        {
            employeeList=new LinkedList<>();
        }
        employeeList.add(employee);
    }
}
