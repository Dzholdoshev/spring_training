package com.cydeo;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.SchemaOutputResolver;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("____________________REGIONS__________________________");
        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
        System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainsOrderByRegion: " + regionRepository.findByCountryContainsOrderByRegion("United"));
        System.out.println("findTop2ByCountry: " + regionRepository.findTop2ByCountry("United States"));
        System.out.println("findTopByCountryContainsOrderByRegion:" + regionRepository.findTopByCountryContainsOrderByRegion("United States"));

        System.out.println("____________________DEPARTMENTS__________________________");
        System.out.println("findAllByDepartment: " + departmentRepository.findAllByDepartment("Furniture"));
        System.out.println("findByDivision: " + departmentRepository.findByDivision("Health"));
        System.out.println("findAllByDivisionEndingWith: " + departmentRepository.findAllByDivisionEndingWith("ics"));
        System.out.println("findDistinctTop3ByDivisionContaining: " + departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));

        System.out.println("____________________EMPLOYEE__________________________");
        System.out.println("findAllByEmailIs: " + employeeRepository.findAllByEmailIs("john@gmail.com"));

        System.out.println("____________________JPQL__________________________________");
        System.out.println("retrieveEmployeedetail: " + employeeRepository.retrieveEmployeedetail());
        System.out.println("retrieveEmployeeSalary: " + employeeRepository.retrieveEmployeeSalary());

        System.out.println(employeeRepository.retrieveEmployeeFirstNameLike("%gismun_"));

        System.out.println("retrieveEmployeeSalaryBetween: " + employeeRepository.retrieveEmployeeSalaryBetween(100000, 200000));

        System.out.println("retrieveDepartmentDivision"+departmentRepository.retrieveDepartmentDivision("Health", "Fashion"));

        System.out.println("____________________Native query__________________________________");



    }
}