package moviemaster.service;

import moviemaster.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import moviemaster.repository.MovieRepository;
import moviemaster.util.CSVReader;


@Service
public class MovieService {
    private final CSVReader csvReader;
    private final MovieRepository movieDataRepository;
    private final OscarWinnerDataService oscarWinnerDataService;
    private final RestTemplate restTemplate;
    private final String omdbApiKey;
    private final String omdbApiUrl;

    @Autowired
    public MovieService(
            RestTemplate restTemplate,
            @Value("${omdb.api.key}") String omdbApiKey,
            @Value("${omdb.api.url}") String omdbApiUrl,
            CSVReader csvReader,
            MovieRepository movieDataRepository,
            OscarWinnerDataService oscarWinnerDataService
    ) {
        this.restTemplate = restTemplate;
        this.omdbApiKey = omdbApiKey;
        this.omdbApiUrl = omdbApiUrl;
        this.csvReader = csvReader;
        this.movieDataRepository = movieDataRepository;
        this.oscarWinnerDataService = oscarWinnerDataService;
    }

    public Movie getMovie(String title) {
        String apiUrl = omdbApiUrl + "?t=" + title + "&apikey=" + omdbApiKey;
        Movie movie = restTemplate.getForObject(apiUrl, Movie.class);
        if(!movieDataRepository.existsByImdbID(movie.getImdbID()) && movie.getImdbID() != null)
            movieDataRepository.save(movie);
        return movie;
    }



    public boolean hasWonBestPicture(Movie movieData) {

        return false;
    }

}

