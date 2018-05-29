package dao;

import entity.Film;
import entity.User;

import java.util.List;

public interface SqlManager {

    void getConnection();

    List<User> getAllUsers();

    User getUserByLogin(String login);

    boolean addUser(User user);

    List<Film> getAllFilms();

    boolean addFilm(Film film);
}
