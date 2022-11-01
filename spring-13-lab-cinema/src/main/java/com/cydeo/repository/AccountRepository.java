package com.cydeo.repository;

import com.cydeo.entity.Account;
import com.cydeo.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.AbstractCollection;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    /** ------------------- DERIVED QUERIES ------------------- */

    //1. Write a derived query to list all accounts with a specific country or state
    List<Account> findByCountryOrState(String country, String state);

    //2. Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findByAgeLessThanEqual(Integer age);

    //3. Write a derived query to list all accounts with a specific role
    List<Account> findByRole(UserRole role);

    //4. Write a derived query to list all accounts between a range of ages
    List<Account> findByAgeBetween(int age1, int age2);

    //5. Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findByAddressStartingWith(String pattern);

    //6. Write a derived query to sort the list of accounts with age
    List<Account>findByOrderByAge();

    /** ------------------- JPQL QUERIES ------------------- */

    //7. Write a JPQL query that returns all accounts
    @Query("select a from Account a")
    List<Account> retrieveAllAccounts();

    //8. Write a JPQL query to list all admin accounts
    @Query("select a from Account a where a.role = 'ADMIN' ")
    List<Account>retrieveAccountsRoleIsAdmin();

    //9. Write a JPQL query to sort all accounts with age
    @Query("select a from Account a order by a.age desc")
    List<Account>sortAccountsByAge();

    /** ------------------- Native QUERIES ------------------- */

    //10. Write a native query to read all accounts with an age lower than a specific value
    @Query(value= "select * from account_details a where a.age < ?1 ", nativeQuery = true)
    List<Account>retrieveAccountsAgeIsLower(Integer age);

    //11. Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value="select * from account_details a " +
            "where a.name ilike concat('%',?1,'%') " +
            "or a.address like concat('%',?1,'%') " +
            "or a.country like concat('%',?1,'%') " +
            "or a.state like '%'||?1||'%' " +
            "or a.city like concat('%',?1,'%')",nativeQuery = true )
    List<Account>retrieveAccountsNameAddressCountryStateCityIs(@Param("pattern") String pattern);

    //12. Write a native query to read all accounts with an age higher than a specific value
    @Query(value="select * from account_details a where a.age > ?1 ",nativeQuery = true)
    List<Account>retrieveAccountsAgeIsGreater(Integer age);


}