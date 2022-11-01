package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    /** ------------------- DERIVED QUERIES ------------------- */

    //1. Write a derived query to read movie cinema with id
   Optional<MovieCinema> findMovieCinemaById(Long id);

    //2. Write a derived query to count all movie cinemas with a specific cinema id
    Integer countAllByCinemaIdIs(Long id);

    //3. Write a derived query to count all movie cinemas with a specific movie id
    Integer countAllByMovieIdIs(Long id);

    //4. Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> getMovieCinemaByDateTimeGreaterThan(LocalDateTime dateTime);

    //5. Write a derived query to find the top 3 expensive movieCinemas
    List<MovieCinema>  findTop3ByOrderByMovie_Price();

    //6. Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findByMovie_NameContains(String pattern);

    //7. Write a derived query to list all movie cinemas in a specific location name
    List<MovieCinema> findAllByCinema_Location_Name(String name);

    /** ------------------- JPQL QUERIES ------------------- */

    //8. Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query("select m from MovieCinema m where m.dateTime > ?1")
    List<MovieCinema> retrieveMovieCinemasDateGreater(LocalDateTime dateTime);

    /** ------------------- Native QUERIES ------------------- */

    //9. Write a native query to count all movie cinemas by cinema id
    @Query(value = "select count(*) from movie_cinema where cinema_id = ?1", nativeQuery = true)
    Integer amountMovieCinemaByCinemaId(Long id);

    //10. Write a native query that returns all movie cinemas by location name
    @Query(value = "select * from movie_cinema m join cinema c on m.cinema_id=c.id  join location l on c.location_id=l.id where l.name= ?1",nativeQuery = true)
       List<MovieCinema> retrieveMovieCinemasByLocationName(String name);

}