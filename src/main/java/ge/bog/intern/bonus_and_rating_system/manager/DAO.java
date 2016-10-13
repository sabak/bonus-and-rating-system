package ge.bog.intern.bonus_and_rating_system.manager;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import ge.bog.intern.bonus_and_rating_system.manager.db.DBInfo;
import ge.bog.intern.bonus_and_rating_system.model.Department;
import ge.bog.intern.bonus_and_rating_system.model.Employee;
import ge.bog.intern.bonus_and_rating_system.model.Position;
import ge.bog.intern.bonus_and_rating_system.util.SHAHasher;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

    private DataSource dataSource;

    public DAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Boolean isUserValid(String username, String password) {

        Boolean ans = false;

        try {
            Connection con = dataSource.getConnection();
            String query = "SELECT * FROM " + "user" + " WHERE "
                    + "username " + " =  ?" + " AND password_hash =  ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, SHAHasher.hashText(password));

            System.out.println(SHAHasher.hashText(password));
            System.out.println(SHAHasher.hashText(password).length());

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                ans = true;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ans;
    }

    public Position getPositionByID(Integer id) {
        Position pos = null;
        try {
            Connection con = dataSource.getConnection();
            String query = "SELECT * FROM " + "position " + " WHERE "
                    + "position_id " + " =  ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String description = rs.getString("position_description");
                pos = new Position(id, description);

            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pos;
    }

    public Department getDepartmentByID(Integer id) {
        Department department = null;
        try {
            Connection con = dataSource.getConnection();
            String query = "SELECT * FROM " + "department " + " WHERE "
                    + "department_id " + " =  ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String description = rs.getString("department_name");
                department = new Department(id, description);

            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return department;
    }


    public Employee getEmployeeByUsername(String username) {

        Employee employee = null;

        try {
            Connection con = dataSource.getConnection();
            String query = " SELECT e.* FROM " + " user u, employee e "
                    + " WHERE " + " u.username = ? and u.employee_id = e.employee_id";

            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();


            if (rs.next()) {
                Integer employeeId = rs.getInt("employee_id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String dateOfBirth = rs.getString("date_of_birth");
                String sex = rs.getString("sex");
                String pid = rs.getString("pid");
                Integer positionID = rs.getInt("position_id");
                Integer salary = rs.getInt("salary");
                Integer departmentID = rs.getInt("department_id");
                Integer managerID = rs.getInt("manager_id");

                employee = new Employee(employeeId, name, surname, dateOfBirth, sex, pid, getPositionByID(positionID),
                        salary, getDepartmentByID(departmentID), managerID);

            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }

    public static void main(String[] args) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("saba");
        dataSource.setURL("jdbc:mysql://localhost:3306/bonus_and_rating_system");

        DAO dao = new DAO(dataSource);

        Employee emp = dao.getEmployeeByUsername("user");
        System.out.println(emp.getName());

    }

}
