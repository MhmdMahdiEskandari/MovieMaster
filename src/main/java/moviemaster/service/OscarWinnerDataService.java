package moviemaster.service;

import moviemaster.model.OscarWinner;
import moviemaster.repository.OscarWinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OscarWinnerDataService {
    private final OscarWinnerRepository oscarWinnerRepository;
    private List<OscarWinner> oscarWinnerList = new ArrayList<>();

    @Autowired
    public OscarWinnerDataService(OscarWinnerRepository oscarWinnerRepository) {
        this.oscarWinnerRepository = oscarWinnerRepository;
    }

    public void persistOscarWinnerData(List<OscarWinner> data) {
        oscarWinnerList = data;
        for (int i = 0; i < data.size(); i++) {
            if (!oscarWinnerRepository.existsByTitleAndYear(data.get(i).getTitle(), data.get(i).getYear()))
                oscarWinnerRepository.save(data.get(i));
        }
    }

    public boolean hasMovieWonOscar(String title) {
        return oscarWinnerRepository.existsByTitle(title);
    }
}