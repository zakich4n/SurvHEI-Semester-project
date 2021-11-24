package ConnexionTest;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class AddUserTest {

/*
    @Test
    public void shouldAddFilm() throws Exception {
        // GIVEN
        Film filmToCreate = new Film(null, "My new film", LocalDate.of(2019, Month.OCTOBER, 20),
                new Genre(1, "Drama"), 123, "my new director", "my new summary");
        // WHEN
        Film filmCreated = filmDao.addFilm(filmToCreate);
        // THEN
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM film WHERE film_id = ?")) {
            stmt.setInt(1, filmCreated.getId());
            try (ResultSet rs = stmt.executeQuery()) {
                assertThat(rs.next()).isTrue();
                assertThat(rs.getInt("film_id")).isEqualTo(filmCreated.getId());
                assertThat(rs.getString("title")).isEqualTo("My new film");
                assertThat(rs.getDate("release_date").toLocalDate()).isEqualTo(LocalDate.of(2019, Month.OCTOBER, 20));
                assertThat(rs.getInt("genre_id")).isEqualTo(1);
                assertThat(rs.getInt("duration")).isEqualTo(123);
                assertThat(rs.getString("director")).isEqualTo("my new director");
                assertThat(rs.getString("summary")).isEqualTo("my new summary");
                assertThat(rs.next()).isFalse();
            }
        }
    }
*/
}
