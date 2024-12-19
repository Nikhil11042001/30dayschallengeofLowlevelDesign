import Employee.EmployeeDao;
import Employee.EmployeeObj;
import Employee.EmployeeProxyDaoImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        EmployeeDao emp=new EmployeeProxyDaoImpl();
        EmployeeObj empObj=new EmployeeObj();
            emp.create("Hero",empObj);
        }
}