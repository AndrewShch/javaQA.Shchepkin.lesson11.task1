package ru.netology.manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
public class AfishaManagerTestWithSetup {

    private AfishaManager manager  = new AfishaManager();
    private Movie first = new Movie(1, "first", "Comedy", "Picture");
    private Movie second = new Movie(2, "second", "Fantastic", "Picture");
    private Movie third = new Movie(3, "third", "Detective", "Picture");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;

        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second, first};

        assertArrayEquals(expected, actual);
    }
}