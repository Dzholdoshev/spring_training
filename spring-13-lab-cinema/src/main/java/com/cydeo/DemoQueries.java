package com.cydeo;

import com.cydeo.entity.Account;
import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import com.cydeo.enums.UserRole;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Component
public class DemoQueries implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;
    private final GenreRepository genreRepository;
    private final MovieCinemaRepository movieCinemaRepository;
    private final MovieRepository movieRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public DemoQueries(AccountRepository accountRepository, CinemaRepository cinemaRepository, GenreRepository genreRepository, MovieCinemaRepository movieCinemaRepository, MovieRepository movieRepository, TicketRepository ticketRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
        this.genreRepository = genreRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.movieRepository = movieRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        /** _________________AccountRepository________________________________ */
        System.out.println("1. findByCountryOrState: " + accountRepository.findByCountryOrState("United States", "Kentucky"));
        System.out.println("2. findByAgeLessThanEqual: " + accountRepository.findByAgeLessThanEqual(30));
        System.out.println("3. findByRole = " + accountRepository.findByRole(UserRole.ADMIN));
        System.out.println("4. findByAgeBetween: "+accountRepository.findByAgeBetween(20,30));
        System.out.println("5. findByAddressStartingWith : "+accountRepository.findByAddressStartingWith("New"));
        System.out.println("6. findByOrderByAge: " + accountRepository.findByOrderByAge());
        System.out.println("7. retrieveAllAccounts: " + accountRepository.retrieveAllAccounts());
        System.out.println("8. retrieveAccountsRoleIsAdmin: " + accountRepository.retrieveAccountsRoleIsAdmin());
        System.out.println("9. sortAccountsByAge: " + accountRepository.sortAccountsByAge());
        System.out.println("10. retrieveAccountsAgeIsLower:"+accountRepository.retrieveAccountsAgeIsLower(25));
        System.out.println("11. retrieveAccountsNameAddressCountryStateCityIs:"+accountRepository.retrieveAccountsNameAddressCountryStateCityIs("New York"));
        System.out.println("12. retrieveAccountsAgeIsGreater: "+accountRepository.retrieveAccountsAgeIsGreater(30));

        /** _________________CinemaRepository________________________________ */

        System.out.println("1. getCinemaByName : "+cinemaRepository.getCinemaByName("Tenet"));
        System.out.println("2. getTop3ByNameContains: "+cinemaRepository.getTop3ByNameContains("Kodak"));
        System.out.println("3. getCinemaByLocation_Country : "+cinemaRepository.getCinemaByLocation_Country("United States"));
        System.out.println("4. getCinemaByNameOrSponsoredName : "+cinemaRepository.getCinemaByNameOrSponsoredName("Tenet","Kodak"));
        System.out.println("5. RetrieveById : "+cinemaRepository.retrieveById(1L));
        System.out.println("6. retrieveCinemaByLocationName: "+cinemaRepository.retrieveCinemaByLocationName("AMC Empire 25"));
        System.out.println("7. retrieveCinemaByNameOrSponsoredNameContains: "+cinemaRepository.retrieveCinemaByNameOrSponsoredNameContains("Hall 1 - EMPIRE"));
        System.out.println("8. sortCinemaByName: "+cinemaRepository.sortCinemaByName());
        System.out.println("9. distinctCinemaBySponsoredName: "+cinemaRepository.distinctCinemaBySponsoredName());

        /** _________________GenreRepository________________________________ */
        System.out.println("1. retrieveGenre: "+genreRepository.retrieveGenre());
        System.out.println("2. retrieveByNameContains :"+genreRepository.retrieveByNameContains("Comedy"));

        /** _________________MovieCinemaRepository________________________________ */

        System.out.println("1. findMovieCinemaById:" + movieCinemaRepository.findMovieCinemaById(1l));
        System.out.println("2. countAllByCinemaIdIs: " + movieCinemaRepository.countAllByCinemaIdIs(1l));
        System.out.println("3. countAllByMovieIdIs: "+ movieCinemaRepository.countAllByMovieIdIs(1L));
        System.out.println("4. getMovieCinemaByDateTimeGreaterThan" + movieCinemaRepository.getMovieCinemaByDateTimeGreaterThan(LocalDateTime.of(2020, 12, 8, 20, 0)));
        System.out.println("5. findTop3ByMovie_Price: " + movieCinemaRepository.findTop3ByOrderByMovie_Price());
        System.out.println("6. findByMovie_NameContains: " + movieCinemaRepository.findByMovie_NameContains("Aven"));
        System.out.println("7. findAllByCinema_Location_Name: "+ movieCinemaRepository.findAllByCinema_Location_Name("AMC Empire 25"));
        System.out.println("8. retrieveMovieCinemasDateGreater: "+movieCinemaRepository.retrieveMovieCinemasDateGreater(LocalDateTime.of(2020,12,6,20,0)));
        System.out.println("9. amountMovieCinemaByCinemaId: " + movieCinemaRepository.amountMovieCinemaByCinemaId(1l));
        System.out.println("10. retrieveMovieCinemasByLocationName "+ movieCinemaRepository.retrieveMovieCinemasByLocationName("AMC Empire 25"));

        /** _________________MovieRepository________________________________ */

        System.out.println("1. readByName: "+movieRepository.readByName("Tenet"));
        System.out.println("2. findAllByPriceBetween: " + movieRepository.findByPriceBetween(BigDecimal.valueOf(20), BigDecimal.valueOf(40)));
        System.out.println("3. findByDurationIn: " + movieRepository.findByDurationIn(150, 175));
        System.out.println("4. findByReleaseDateGreaterThan" + movieRepository.findByReleaseDateGreaterThan(LocalDate.of(2012, 12, 15)));
        System.out.println("5. findByStateAndType: "+ movieRepository.findByStateAndType(MovieState.ACTIVE, MovieType.REGULAR));
        System.out.println("6. retrieveMoviesPriceBetween: " + movieRepository.retrieveMoviesPriceBetween(BigDecimal.valueOf(15), BigDecimal.valueOf(20)));
        System.out.println("7. retrieveMoviesNames: " + movieRepository.retrieveMoviesNames());
        System.out.println("8. retrieveMovieByName: " + movieRepository.retrieveMovieByName("Tenet"));
        System.out.println("9. retrieveMovieByRangePrice: " + movieRepository.retrieveMovieByRangePrice(BigDecimal.valueOf(20), BigDecimal.valueOf(35)));
        System.out.println("10. retrieveMovieByRangeDuration: " + movieRepository.retrieveMovieByRangeDuration(150, 170));
        System.out.println("11. retrieveTop5Price: " + movieRepository.retrieveTop5Price());

        /** _________________TicketRepository________________________________ */

        System.out.println("1. countTicketByUserAccount_Id: " + ticketRepository.countTicketByUserAccount_Id(2l));
        System.out.println("2. findByUserAccount_Email: "+ ticketRepository.findByUserAccount_Email("sdsd@jhj"));
        System.out.println("3. countByMovieCinema_Movie_Name:" + ticketRepository.countByMovieCinema_Movie_Name("Tenet"));
        System.out.println("4. findByDateTimeBetween" + ticketRepository.findByDateTimeBetween(LocalDateTime.of(2019, 12, 8, 20, 0),
                LocalDateTime.of(2021, 12, 8, 20, 0)));
        System.out.println("5. retrieveTicketByUser: " + ticketRepository.retrieveTicketByUser(1L));
        System.out.println("6. retrieveTicketBetweenDates: "+ticketRepository.retrieveTicketBetweenDates(
                LocalDateTime.of(2019, 12, 8, 20, 0),
                LocalDateTime.of(2021, 12, 8, 20, 0)));
        System.out.println("7. amountTicketsByUser: " + ticketRepository.amountTicketsByUser(1L));
        System.out.println("8. amountTicketsByUserRangeDates: " + ticketRepository.amountTicketsByUserRangeDates(1L, LocalDateTime.of(2020, 12, 05, 20, 0), LocalDateTime.of(2020, 12, 7, 20, 0)));
        System.out.println("9. distinctMovieByName" + ticketRepository.distinctMovieByName());
        System.out.println("10. retrieveTicketByEmail" + ticketRepository.retrieveTicketByEmail("faith.p@email.com"));
        System.out.println("11. retrieveAllTicket: " + ticketRepository.retrieveAllTicket());
        System.out.println("12. retrieveAllTicketUserNameAccNameMovieNameContains" + ticketRepository.retrieveAllTicketUserNameAccNameMovieNameContains("bernard"));

        /** _________________UserRepository________________________________ */

        System.out.println("1. findByEmail : "+userRepository.findByEmail("email@ru")    );
        System.out.println("2. readByUsername : "+userRepository.readByUsername("bernard"));
        System.out.println("3. findByUsername : "+userRepository.findByUsername("bernard"));
        System.out.println("4. findByUsernameContainingIgnoreCase : "+userRepository.findByUsernameContainingIgnoreCase("bernard"));
        System.out.println("5. findByAccount_Age : "+userRepository.findByAccount_Age(25));
        System.out.println("6. retrieveUserByEmail : "+userRepository.retrieveUserByEmail("mail@gmail.com"));
        System.out.println("7. retrieveUserByUsername: "+userRepository.retrieveUserByUsername("bernard"));
        System.out.println("8. retrieveAllUser: " + userRepository.retrieveAllUser());
        System.out.println("9. retrieveUsersNameContains: " + userRepository.retrieveUsersNameContains("ber%"));
        System.out.println("10. retrieveUsers : "+ userRepository.retrieveUsers());
        System.out.println("11. retrieveAllUsers : "+ userRepository.retrieveAllUsers());
        System.out.println("12. retrieveUsersByEmail : "+ userRepository.retrieveUsersByEmail("mail@gmail.com"));


    }

}
