package com.cydeo.repository;

import com.cydeo.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    /** ------------------- JPQL QUERIES ------------------- */

    // 1. Write a JPQL query that return all genres
    @Query("select g from Genre g")
    List<Genre> retrieveGenre();


    /** ------------------- Native QUERIES ------------------- */

    //2. Write a native query that returns genres by containing name
    @Query(value = "select * from genre g where g.name ilike %?1% ", nativeQuery = true )
    List<Genre> retrieveByNameContains(String pattern);

}