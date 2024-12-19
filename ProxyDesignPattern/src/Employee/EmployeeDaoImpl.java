package Employee;

public class EmployeeDaoImpl implements EmployeeDao {


    @Override
    public void create(String client, EmployeeObj employeeObj) {
        System.out.println("Object is created ");
    }

    @Override
    public void delete(String client, int employeeId) {
        System.out.println("User with "+employeeId+"is deleted");
    }
}
