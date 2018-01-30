package ConcurrentCollections;

public class Employee {
    private int id;
    private String department;
    private boolean deleted;

    public Employee(int id,String department, boolean deleted){
        this.id=id;
        this.deleted=deleted;
        this.department=department;
    }

    public int getId(){
        return id;
    }

    public String getDepartment(){
        return department;
    }

    public boolean isDeleted(){
        return deleted;
    }
}
