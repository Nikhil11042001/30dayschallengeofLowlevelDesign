package Employee;

public class EmployeeProxyDaoImpl implements EmployeeDao{

    EmployeeDao employeeDao;

    public EmployeeProxyDaoImpl(){
        employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public void create(String client, EmployeeObj employeeObj) {
         if("ADMIN".equals(client)){
             employeeDao.create(client,employeeObj);
         }
         else
             System.out.println("Invalid User !");
    }

    @Override
    public void delete(String client, int employeeId) {
        if("ADMIN".equals(client)){
            employeeDao.delete(client,employeeId);
        }
        else
            System.out.println("Invalid user!!");
    }
}
