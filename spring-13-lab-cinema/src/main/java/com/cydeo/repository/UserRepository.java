package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    /** ------------------- DERIVED QUERIES ------------------- */

    //1. Write a derived query to read a user with an email?
    User findByEmail(String email);

    //2. Write a derived query to read a user with a username?
    User readByUsername(String username);

    //3. Write a derived query to list all users that contain a specific name?
    List<User> findByUsername(String username);

    //4. Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<User> findByUsernameContainingIgnoreCase(String username);

    //5. Write a derived query to list all users with an age greater than a specified age? ---------------------------------------????????????????
    List<User> findByAccount_Age(Integer age);

    /** ------------------- JPQL QUERIES ------------------- */

    //6. Write a JPQL query that returns a user read by email?
    @Query("select u from User u where u.email = ?1")
    User retrieveUserByEmail(String email);


    //7. Write a JPQL query that returns a user read by username?
    @Query("select u from User u where u.username=?1")
    User retrieveUserByUsername(String name);

    //8. Write a JPQL query that returns all users?
    @Query("select u from User u")
    List<User> retrieveAllUser();

    /** ------------------- Native QUERIES ------------------- */

    //9. Write a native query that returns all users that contain a specific name?
    @Query(value = "select *  from user_account  where username like ?1",nativeQuery = true)
    List<User> retrieveUsersNameContains(String pattern);

    //10. Write a native query that returns all users?
    @Query(value = "select * from user_account",nativeQuery = true)
    List<User> retrieveUsers();

    //11. Write a native query that returns all users in the range of ages?
    @Query(value = "select * from user_account",nativeQuery = true)
    List<User> retrieveAllUsers();

    //12. Write a native query to read a user by email?
    @Query(value = "select * from user_account where email = ?1 ",nativeQuery = true)
    List<User> retrieveUsersByEmail(String email);
}