package moviemaster.configuration;

import moviemaster.model.OscarWinner;
import moviemaster.service.OscarWinnerDataService;
import moviemaster.util.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Configuration
public class MyConfiguration {

    private final ResourceLoader resourceLoader;
    private final OscarWinnerDataService oscarWinnerDataService;

    @Autowired
    public MyConfiguration(ResourceLoader resourceLoader, OscarWinnerDataService oscarWinnerDataService) {
        this.resourceLoader = resourceLoader;
        this.oscarWinnerDataService = oscarWinnerDataService;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ApplicationRunner applicationRunner(CSVReader csvReader) {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                Resource resource = resourceLoader.getResource("classpath:static/oscar_movies.csv");
                try (InputStream is = resource.getInputStream()) {
                    List<OscarWinner> csvData = csvReader.readMoviesFromCSV(is);
                    oscarWinnerDataService.persistOscarWinnerData(csvData);

                } catch (IOException e) {
                    // Handle exceptions
                }
            }
        };
    }
}
