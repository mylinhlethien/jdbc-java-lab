import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO extends DAO<Emp> {

	public EmployeeDAO(Connection connection) {
		// TODO Auto-generated constructor stub
		super(connection);
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = DriverManager.getConnection( "jdbc:oracle:thin:system/oracle@localhost:49161:xe", "system", "oracle" );// instantiate here a new Connection.
		DAO<Emp> employeeDao = new EmployeeDAO(connection);
		//Emp emp = employeeDao.find(7698);
		employeeDao.find(7698);
		//System.out.println(emp.toString()); // Don't forget to add toString() method in Dept.java to be able to pass it to System.out.println.
	}

	@Override
	public Emp find(int idManager) {
		// TODO Auto-generated method stub
		Emp emp = new Emp();
        try {
            ResultSet result = this .connect
                                    .createStatement(
                                                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT * FROM EMP WHERE mgr = " + idManager
                                             );
            while(result.next()) {
                    emp = new Emp(
                    					idManager, 
                                        result.getString("ename"),
                                        result.getString("efirst")
                                    );
                    System.out.println("\n");
            		System.out.println(emp.toString());
            }
            } catch (SQLException e) {
                    e.printStackTrace();
            }
		return emp;
	}

	@Override
	public boolean create(Emp object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Emp object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Emp object) {
		// TODO Auto-generated method stub
		return false;
	}

}
