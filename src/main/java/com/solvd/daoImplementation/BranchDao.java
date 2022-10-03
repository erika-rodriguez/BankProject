package  com.solvd.daoImplementation;

import  com.solvd.daoInterfaces.IBranchDAO;
import  com.solvd.entities.Branch;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BranchDao extends DB_Connection implements IBranchDAO {
    final String INSERT="INSERT INTO branch (city) VALUES (?)";
    final String UPDATE="UPDATE branch SET city=? WHERE id_branch=?";
    final String DELETE="DELETE FROM branch WHERE id_branch=?";
    final String GETALL="SELECT * FROM branch";
    final String GETONE="SELECT * FROM branch WHERE id_branch=?";
    public BranchDao(Connection connection) {
    }    public Branch turnToBranch(ResultSet rs) throws SQLException {
        String city= rs.getString("city");

        Branch branch=new Branch(city);
        branch.setId_branch(rs.getInt("id_branch"));
        return branch;
    }

    @Override
    public Branch getOne(Integer id) {
        Branch branch=null;
        try {
            connectToDB();
            statement=connection.prepareStatement(GETONE);
            statement.setInt(1,id);
            result= statement.executeQuery();
            if (result.next()){
                branch=turnToBranch(result);
            }
            connection.commit();
            System.out.println("GetOne succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return branch;
    }

    @Override
    public List<Branch> getAll() {
        List <Branch> branchList=new ArrayList<>();
        try {
            connectToDB();
            statement=connection.prepareStatement(GETALL);
            result= statement.executeQuery();
            while (result.next()){
                branchList.add(turnToBranch(result));
            }
            connection.commit();
            System.out.println("GetAll succeed");
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
        return branchList;
    }

    @Override
    public void insert(Branch branch) {
        try {
            connectToDB();
            statement=connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,branch.getCity());

            statement.executeUpdate();

            connection.commit();
            System.out.println("Insert succeed");
            ResultSet result=statement.getGeneratedKeys();
            if (result.next()){
                branch.setId_branch(result.getInt(1));//set the id from result mysql into the java object, bc it is AI
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            disconnectToDB();
        }
    }

    @Override
    public void update(Branch branch, Integer id) {
        try {
            connectToDB();
            statement=connection.prepareStatement(UPDATE);
            statement.setString(1, branch.getCity());
            statement.setInt(2, id);

            statement.executeUpdate();

            connection.commit();
            System.out.println("Update succeed");

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            disconnectToDB();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            connectToDB();
            statement=connection.prepareStatement(DELETE);
            statement.setInt(1,id);

            statement.executeUpdate();

            connection.commit();
            System.out.println("Delete succeed");

        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            disconnectToDB();
        }
    }


}
