package dao;

import models.Department;
import models.Users;

import java.util.List;

public interface UsersDao {
    //create
    void add(Users users);
    void addUsersToDepartment(Users users, Department department);

    //read
    List<Users> getAll();
    List<Department> getAllDepartmentForUsers(int id);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}
