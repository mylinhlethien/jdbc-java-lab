import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptDAO extends DAO<Dept> {


	public DeptDAO(Connection connect) {
		super(connect);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = DriverManager.getConnection( "jdbc:oracle:thin:system/oracle@localhost:49161:xe", "system", "oracle" );// instantiate here a new Connection.
		DAO<Dept> departmentDao = new DeptDAO(connection);
		Dept dept20 = departmentDao.find(20);
		System.out.println(dept20.toString()); // Don't forget to add toString() method in Dept.java to be able to pass it to System.out.println.
	}

	@Override
	public Dept find(int id) {
		// TODO Auto-generated method stub
		Dept dept = new Dept();
        try {
            ResultSet result = this .connect
                                    .createStatement(
                                                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT * FROM dept WHERE deptno = " + id
                                             );
            if(result.first())
                    dept = new Dept(
                                        id, 
                                        result.getString("dname"),
                                        result.getString("loc")
                                    );
            
            } catch (SQLException e) {
                    e.printStackTrace();
            }
           return dept;
	}

	@Override
	public boolean create(Dept object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Dept object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Dept object) {
		// TODO Auto-generated method stub
		return false;
	}

}
