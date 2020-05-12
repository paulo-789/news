package dao;

import models.Department;

import java.util.List;

public interface DepartmentDao {
    //create
    void add (Department department);
    // void addDepartmentToUsers(Department department, Users users)

    //read
    List<Department> getAll();
    Department findById(int id);
    // List<Users> getAllUsersInADepartment(int departmentId);

    //update
    void update(int id, String name,String description,int numberOfStaff );

    //delete
    void deleteById(int id);
    void clearAll();

}

