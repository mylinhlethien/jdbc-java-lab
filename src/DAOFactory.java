import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
	
	Connection connexion;
	
    public DAOFactory(Connection connexion) {
          this.connexion = connexion;
    }

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connexion = DriverManager.getConnection( "jdbc:oracle:thin:system/oracle@localhost:49161:xe", "system", "oracle" );
		DAOFactory daoFactory = new DAOFactory(connexion);
        DAO<Dept> daoDept = daoFactory.getDeptDAO();
        Dept dept20 = daoDept.find(20);
        System.out.println(dept20);
        DAO<Emp> employeeDao = new EmployeeDAO(connexion);
		employeeDao.find(7698);
	}
	
	public DAO<Dept> getDeptDAO() {
        return new DeptDAO(connexion);
	}
	
      public DAO<Emp> getEmpDAO() {
        return new EmployeeDAO(connexion);
      }

}
