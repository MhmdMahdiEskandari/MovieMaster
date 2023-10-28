package moviemaster.util;

import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import moviemaster.model.OscarWinner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVReader {

    public List<OscarWinner> readMoviesFromCSV(InputStream is) {
        List<OscarWinner> oscarWinners = new ArrayList<>();

        try (com.opencsv.CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(is))
//                .withSkipLines(1) // Skip the header row if present
                .build()) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                OscarWinner oscarWinner = new OscarWinner();
                // Assuming the CSV columns are in order: title, year, category
                oscarWinner.setTitle(nextRecord[0]);
                oscarWinner.setYear(Integer.parseInt(nextRecord[1]));
                oscarWinner.setCategory(nextRecord[2]);

                oscarWinners.add(oscarWinner);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return oscarWinners;
    }

}
