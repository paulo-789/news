package dao;

import models.Department;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;
public class Sql2oUsersDao implements UsersDao {
    private final Sql2o sql2o;
    public Sql2oUsersDao(Sql2o sql2o){ this.sql2o = sql2o; }

    @Override
    public void add(Users users) {
        String sql = "INSERT INTO users (name,position) VALUES (:name,:position)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(users)
                    .executeUpdate()
                    .getKey();
            users.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void addUsersToDepartment(Users users, Department department) {
        String sql = "INSERT INTO users_departments (usersid, departmentid) VALUES (:usersId, :departmentId)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("departmentId", department.getId())
                    .addParameter("usersId", users.getId())
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public List<Users> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM users")
                    .executeAndFetch(Users.class);
        }
    }

    @Override
    public List<Department> getAllDepartmentForUsers(int id) {
       ArrayList<Department>departments = new ArrayList<>();
        String joinQuery = "SELECT departmentid FROM users_department WHERE usersid = :usersId";

        try (Connection con = sql2o.open()) {
            List<Integer> allDepartmentIds = con.createQuery(joinQuery)
                    .executeAndFetch(Integer.class);
            for (Integer departmentId : allDepartmentIds){
                String departmentQuery = "SELECT * FROM departments WHERE id = :departmentId";
                departments.add(
                        con.createQuery(departmentQuery)
                                .addParameter("restaurantId", departmentId)
                                .executeAndFetchFirst(Department.class));
            }
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
        return departments;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from users WHERE id=:id"; //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from users";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
    }

