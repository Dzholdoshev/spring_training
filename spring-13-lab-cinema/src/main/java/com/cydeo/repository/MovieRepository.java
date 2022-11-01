package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    /** ------------------- DERIVED QUERIES ------------------- */

    //1. Write a derived query to read a movie with a name
    Movie readByName(String name);

    //2. Write a derived query to list all movies between a range of prices
List<Movie> findByPriceBetween(BigDecimal price1, BigDecimal price2);

    //3. Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie>findByDurationIn(Integer... duration);//_____________________________________????????????????????????

    //4. Write a derived query to list all movies with higher than a specific release date
    List<Movie>findByReleaseDateGreaterThan(LocalDate date);

    //5. Write a derived query to list all movies with a specific state and type
    List<Movie> findByStateAndType(MovieState state, MovieType type);

    /** ------------------- JPQL QUERIES ------------------- */

    //6. Write a JPQL query to list all movies between a range of prices
    @Query("select m from Movie m where m.price between ?1 and ?2")
    List<Movie> retrieveMoviesPriceBetween(BigDecimal price1, BigDecimal price2);

    //7. Write a JPQL query that returns all movie names
    @Query("select distinct m.name from Movie m")
    List<String> retrieveMoviesNames();

    /** ------------------- Native QUERIES ------------------- */

    //8. Write a native query that returns a movie by name
    @Query(value = "select * from Movie where name = ?1",nativeQuery = true)
    Movie retrieveMovieByName(String name);

    //9. Write a native query that return the list of movies in a specific range of prices
    @Query(value = "select * from Movie where price between ?1 and ?2",nativeQuery = true)
    List<Movie> retrieveMovieByRangePrice(BigDecimal from, BigDecimal to);

    //10. Write a native query to return all movies where duration exists in the range of duration
    @Query(value = "select * from Movie m where  m.duration in  (:durations) ",nativeQuery = true)
    List<Movie> retrieveMovieByRangeDuration(@Param("durations") int...durations);

    //11. Write a native query to list the top 5 most expensive movies
    @Query(value = "select  * from Movie m  order by price desc limit 5  ",nativeQuery = true)
    List<Movie> retrieveTop5Price();

}