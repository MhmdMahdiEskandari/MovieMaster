package moviemaster.controller;

import moviemaster.exception.MovieNotFoundException;
import moviemaster.model.Movie;
import moviemaster.service.MovieService;
import moviemaster.service.OscarWinnerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final OscarWinnerDataService oscarWinnerDataService;

    @Autowired
    public MovieController(MovieService movieService, OscarWinnerDataService oscarWinnerDataService) {
        this.movieService = movieService;
        this.oscarWinnerDataService = oscarWinnerDataService;
    }

    @GetMapping("/{title}")
    public ResponseEntity<Movie> getMovie(@PathVariable String title) {
        Movie movie = movieService.getMovie(title);
        if (movie.getImdbID() != null) {
            return ResponseEntity.ok(movie);
        } else {
            throw new MovieNotFoundException(title);
        }
    }

    @GetMapping("/hasWonOscar")
    public ResponseEntity<String> checkIfMovieHasWonOscar(@RequestParam String title) {
        boolean hasWonOscar = oscarWinnerDataService.hasMovieWonOscar(title);
        if (hasWonOscar) {
            return ResponseEntity.ok("Yes, the movie has won an Oscar!");
        } else {
            return ResponseEntity.ok("No, the movie has not won an Oscar.");
        }
    }

}
