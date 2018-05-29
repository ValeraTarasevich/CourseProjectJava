package dao.impl;

import dao.SqlManager;
import entity.Film;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlManagerImpl implements SqlManager{

    private Connection connection = null;
    private final String LOGIN = "root";
    private final String PASSWORD = "1234";
    private final String URL = "jdbc:mysql://localhost:3306/cinema";


    @Override
    public void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<User>();
        ResultSet rs = null;
        Statement stmt = null;
        try {
            getConnection();
            stmt = connection.createStatement();
            System.out.println("Connection to 'Users' Completed!");
            rs = stmt.executeQuery("SELECT * FROM Users;");
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("idUsers"));
                user.setLogin(rs.getString("Login"));
                user.setEmail(rs.getString("Email"));
                user.setSurname(rs.getString("Surname"));
                user.setName(rs.getString("Name"));
                user.setPassword(rs.getString("Password"));
                user.setRole(rs.getString("Role"));

                list.add(user);
            }
            System.out.println(("DownLoad 'Users' completed SUCCESSFULLY!"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.err.println("ErrorMsg: " + ex.getMessage());
            }
        }
        return list;
    }

    @Override
    public User getUserByLogin(String login) {
        User user = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            getConnection();
            stmt = connection.createStatement();
            System.out.println("Connection to 'Users' Completed!");
            rs = stmt.executeQuery("SELECT * FROM users where Login='"+ login +"';");
            while (rs.next()) {
                user = new User();
                user.setUserID(rs.getInt("idUsers"));
                user.setLogin(rs.getString("Login"));
                user.setEmail(rs.getString("Email"));
                user.setSurname(rs.getString("Surname"));
                user.setName(rs.getString("Name"));
                user.setPassword(rs.getString("Password"));
                user.setRole(rs.getString("Role"));
            }
            System.out.println(("DownLoad 'Users' completed SUCCESSFULLY!"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.err.println("ErrorMsg: " + ex.getMessage());
            }
        }
        return user;
    }

    @Override
    public boolean addUser(User user) {
        ResultSet rs = null;
        Statement stmt = null;
        boolean result = false;
        try {
            getConnection();
            stmt = connection.createStatement();
            System.out.println(("Connection to 'Users' Completed!"));
            StringBuilder record = new StringBuilder();
            stmt.executeUpdate("set names 'utf8';");
            record.append("insert into Users (idUsers, Surname, Name, Login, Password, Email, Role) values (DEFAULT, '")
                    .append(user.getSurname()).append("', '")
                    .append(user.getName()).append("', '")
                    .append(user.getLogin()).append("', '")
                    .append(user.getPassword()).append("', '")
                    .append(user.getEmail()).append("', '")
                    .append(user.getRole().toString()).append("');");
            stmt.executeUpdate(record.toString());
            stmt.close();
            System.out.println(("UnLoad 'Users' completed SUCCESSFULLY!"));
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.err.println("ErrorMsg: " + ex.getMessage());
                result = false;
            }
        }
        return result;
    }

    @Override
    public boolean addFilm(Film film) {
        ResultSet rs = null;
        Statement stmt = null;
        boolean result = false;
        try {
            getConnection();
            stmt = connection.createStatement();
            System.out.println(("Connection to 'Films' Completed!"));
            StringBuilder record = new StringBuilder();
            stmt.executeUpdate("set names 'utf8';");
            record.append("insert into Films (idFilm, Name, Year, Country, Style, Photo, Video) values (DEFAULT, '")
                    .append(film.getName()).append("', '")
                    .append(film.getYear()).append("', '")
                    .append(film.getCountry()).append("', '")
                    .append(film.getStyle()).append("', '")
                    .append(film.getPhoto()).append("', '")
                    .append(film.getVideo()).append("');");
            stmt.executeUpdate(record.toString());
            stmt.close();
            System.out.println(("UnLoad 'Films' completed SUCCESSFULLY!"));
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.err.println("ErrorMsg: " + ex.getMessage());
                result = false;
            }
        }
        return result;
    }

    @Override
    public List<Film> getAllFilms() {
        List<Film> list = new ArrayList<>();
        ResultSet rs = null;
        Statement stmt = null;
        try {
            getConnection();
            stmt = connection.createStatement();
            System.out.println("Connection to 'Films' Completed!");
            rs = stmt.executeQuery("SELECT * FROM films;");
            while (rs.next()) {
                Film film = new Film();
                film.setId(rs.getInt("IdFilm"));
                film.setName(rs.getString("Name"));
                film.setCountry(rs.getString("Country"));
                film.setYear(rs.getInt("Year"));
                film.setStyle(rs.getString("Style"));
                film.setPhoto(rs.getString("Photo"));
                film.setVideo(rs.getString("Video"));

                list.add(film);
            }
            System.out.println(("DownLoad 'Films' completed SUCCESSFULLY!"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.err.println("ErrorMsg: " + ex.getMessage());
            }
        }
        return list;
    }


}
