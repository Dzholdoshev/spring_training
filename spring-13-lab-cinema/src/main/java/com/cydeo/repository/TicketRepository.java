package com.cydeo.repository;

import com.cydeo.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    /** ------------------- DERIVED QUERIES ------------------- */

    //1. Write a derived query to count how many tickets a user bought
    Integer countTicketByUserAccount_Id(Long id);

    //2. Write a derived query to list all tickets by specific email
    List<Ticket> findByUserAccount_Email(String email);

    //3. Write a derived query to count how many tickets are sold for a specific movie
    Integer countByMovieCinema_Movie_Name(String name);

    //4. Write a derived query to list all tickets between a range of dates
    List<Ticket> findByDateTimeBetween(LocalDateTime dateTime1, LocalDateTime dateTime2);

    /** ------------------- JPQL QUERIES ------------------- */

    //5. Write a JPQL query that returns all tickets are bought from a specific user
    @Query("select t from Ticket t where  t.userAccount.id = ?1")
    List<Ticket>retrieveTicketByUser(Long userId);

    //6. Write a JPQL query that returns all tickets between a range of dates
    @Query("select  t from Ticket t where t.dateTime between ?1 and ?2")
    List<Ticket> retrieveTicketBetweenDates(LocalDateTime dateTime1, LocalDateTime dateTime2);

    /** ------------------- Native QUERIES ------------------- */

    //7. Write a native query to count the number of tickets a user bought
    @Query(value = "select count(*) from ticket t where t.user_account_id=?1", nativeQuery = true)
    Integer amountTicketsByUser(Long userId);

    //8. Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "select count(*) from ticket t where t.user_account_id=?1 and t.date_time between ?2 and ?3", nativeQuery = true)
    Integer amountTicketsByUserRangeDates(Long userId, LocalDateTime dateTime1, LocalDateTime dateTime2);

    //9. Write a native query to distinct all tickets by movie name
    @Query(value = "select distinct name from ticket t join movie_cinema mc on t.movie_cinema_id=mc.id join movie m on mc.movie_id=m.id  ",nativeQuery = true)
    List<String> distinctMovieByName();

    //10. Write a native query to find all tickets by user email
    @Query(value = "select * from ticket t join user_account ua on t.user_account_id=ua.id where ua.email=?1",nativeQuery = true)
    List<Ticket> retrieveTicketByEmail(String email);

    //11. Write a native query that returns all tickets
    @Query(value = "select * from ticket",nativeQuery = true)
    List<Ticket> retrieveAllTicket();

    //12. Write a native query to list all tickets where a specific value should be containable in the username or account name or movie name
    @Query(value = "select * from ticket t " +
            "join movie_cinema mc on t.movie_cinema_id=mc.id " +
            "join movie m on mc.movie_id=m.id " +
            "join user_account ua on t.user_account_id=ua.id  " +
            "join account_details ad on ua.account_details_id=ad.id " +
            "where m.name like ?1 or ua.username like ?1 or ad.name like ?1",nativeQuery = true)
    List<Ticket> retrieveAllTicketUserNameAccNameMovieNameContains(String pattern);

}