package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


    //display all employees with email address
    List<Employee> findAllByEmailIs(String pattern);

    //Display all employees with firstName XXXX also email address XXX
    List<Employee> findAllByFirstNameAndLastNameOrEmail(String firstName,String lastName,String email);
    //Display all employees that firstname is not XXX
    List<Employee> findAllByFirstNameIsNot(String name);

    //Display all employees where last name starts with
    List<Employee> findAllByLastNameStartingWith(String lastName);

    //Display all employees with salaries higher than XXX
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employees with salaries less than XXXX
    List<Employee> findBySalaryLessThan(Integer salary);

    //Display all employees that has been hired between XX and XX
    List<Employee> findAllByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where salaries greater and equal to XXX in order
    List<Employee>findAllBySalaryGreaterThanEqualOrderBySalary(Integer salary);

    //Display top unique 3 employees that is making less than ""
    List<Employee> findDisticntTop3BySalaryLessThan(Integer salary);

    //Display all employees than do not have email address
    List<Employee> findAllByEmailIsNull();


    @Query("select employee from Employee employee where employee.email = 'amcnee1@google.es'  ")
    Employee retrieveEmployeedetail();

    @Query("select e.salary from Employee e where e.email= 'amcnee1@google.es' ")
    Integer retrieveEmployeeSalary();

    //Not equal
    @Query("select e from Employee e where e.salary <> ?1 ")
    List<Employee>retrieveEmployeeSalaryNotEqula(int salary);

    //Like  / Contains / StartWith / EndWith

    @Query("select e from Employee e where e.firstName like ?1")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

    //Less than
    @Query ("select e.firstName from Employee e where e.salary < ?1")
    List<String> retrieveEmployeeSalaryLessThan(int salary);

    //Greater than
    @Query ("select e from Employee e where e.salary > ?1")
    List<Employee> retrieveEmployeeSalaryGreaterThan(int salary);

    //Between
    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> retrieveEmployeeSalaryBetween(int salary1, int salary2);

    //before
    @Query("select e from Employee e where e.hireDate > ?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);

    // Null
    @Query("select e from Employee e where e.email is NULL" )
    List<Employee> retrieveEmployeeEmailIsNull();

    //Not Null
    @Query("select e from Employee e where e.email is not NULL" )
    List<Employee> retrieveEmployeeEmailIsNotNull();

    //SORTING in ASC Order
    @Query("select e from Employee e ORDER BY e.salary asc " )
    List<Employee> retrieveEmployeeSalaryOrderAsc();

    //SORTING in Desc Order
    @Query("select e from Employee e ORDER BY e.salary desc " )
    List<Employee> retrieveEmployeeSalaryOrderDesc();

    //Native QUERY

    @Query(value = "select * from employees where salary =?1", nativeQuery = true)
    List<Employee> retrieveEmployeeDetailBySalary(int salary);


    //Named Parameter
    @Query("select e from Employee e where e.salary = :salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary") int salary);

    //_____________________________________________________________________














}
