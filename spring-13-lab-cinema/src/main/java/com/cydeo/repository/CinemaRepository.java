package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    /** ------------------- DERIVED QUERIES ------------------- */

    //1. Write a derived query to get cinema with a specific name
    Optional<Cinema> getCinemaByName(String name);

    //2. Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> getTop3ByNameContains(String sponsoredName);
    List<Cinema> findFirst3BySponsoredNameContainingOrderBySponsoredName(String sponsoredName);

    //3. Write a derived query to list all cinemas in a specific country
    List<Cinema> getCinemaByLocation_Country(String country);

    //4. Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> getCinemaByNameOrSponsoredName(String name, String sponsoredName);

    /** ------------------- JPQL QUERIES ------------------- */

    //5. Write a JPQL query to read the cinema name with a specific id
    @Query("select c.name from Cinema c where c.id = ?1" )
    List<String> retrieveById(Long id);

    /** ------------------- Native QUERIES ------------------- */

    //6. Write a native query to read all cinemas by location country
    @Query(value = "select * from cinema c join location l on c.location_id=l.id where l.country = ?1 ", nativeQuery = true)
    List<Cinema> retrieveCinemaByLocationName (String country);

    //7. Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "select * from cinema where name ilike '%'||?1||'%' or sponsored_name ilike %?1%  ", nativeQuery = true)
    List<Cinema> retrieveCinemaByNameOrSponsoredNameContains (String input);

    //8. Write a native query to sort all cinemas by name
    @Query(value = "select * from cinema order by name", nativeQuery = true)
    List<Cinema> sortCinemaByName ();

    //9. Write a native query to distinct all cinemas by sponsored name
    @Query(value = "select distinct * from cinema ", nativeQuery = true)
    List<Cinema> distinctCinemaBySponsoredName ();

}