package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.*;

public class AfishaManagerTest {

    @Test
    public void shouldRemoveIfExists() {
        AfishaManager manager = new AfishaManager();
        int idToRemove = 1;
        Movie first = new Movie(1, "first", "Comedy", "Picture");
        Movie second = new Movie(2, "second", "Fantastic", "Picture");
        Movie third = new Movie(3, "third", "Detective", "Picture");
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        AfishaManager manager = new AfishaManager();
        int idToRemove = 4;
        Movie first = new Movie(1, "first", "Comedy", "Picture");
        Movie second = new Movie(2, "second", "Fantastic", "Picture");
        Movie third = new Movie(3, "third", "Detective", "Picture");
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second, first};

        assertArrayEquals(expected, actual);
    }
}