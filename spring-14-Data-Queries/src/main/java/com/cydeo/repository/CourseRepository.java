package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long> {

    //Find all courses by category
    List<Course> findAllByCategory(String category);
    @Query("select e from Course e where e.category =?1")
    List<Course> retrieveByCategory(String category);

    //Find all courses by category and order by name
    List<Course> findByCategoryOrderByName(String category);

    //Checks if a course with the supplied name exists. Return true if exists, false otherwise
    boolean existsByName(String name);

    //return count of the course for the given category
    Integer countByCategory(String category);

    //Find all the courses that starts with the given course name string
    List<Course> findAllByNameStartingWith(String name);

    //Find all courses by category and return a stream
   Stream<Course> streamAllByCategory(String category);

    ////Find all courses by category and return a stream
    Optional<Course> findById(Long id);//if id doesn't exist it returns NullPointer Exception


    @Query("select c from Course c where c.category = :category and c.rating > :rating")
    List<Course>retrieveAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);



    //____________________________________________________________________________






    }
