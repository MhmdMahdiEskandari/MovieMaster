package moviemaster.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(
        name = "oscar_winner",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"Title", "Year"})
        }
)
public class OscarWinner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int year;
    private String category;

    public OscarWinner() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OscarWinner that = (OscarWinner) o;
        return year == that.year && Objects.equals(title, that.title) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, category);
    }
}
