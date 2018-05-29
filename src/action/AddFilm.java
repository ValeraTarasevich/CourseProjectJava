package action;

import dao.SqlFactory;
import dao.SqlManager;
import entity.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AddFilm implements Action {

    private final String NAME_REGULAR = "^[a-zA-Z0-9]{2,20}$";
    private final String YEAR_REGULAR = "^[1-2][0-9]{3}$";
    private final String STYLE_REGULAR = "^[a-zA-Z]{3,20}$";
    private final String COUNTRY_REGULAR = "^[a-zA-Z]{3,20}$";
    private final String PICTURE_REGULAR = "^[a-zA-Z0-9_.+-]+[.][a-zA-Z0-9-.]{3,20}$";
    private final String VIDEO_REGULAR = "^[a-zA-Z0-9_.+-]+[.][a-zA-Z0-9-.]{3,20}$";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");

            SqlManager sql = SqlFactory.getInstance().getSqlManager();

            String nameFilm = (String) request.getParameter("nameFilm");
            String year = (String)request.getParameter("year");
            String style = (String) request.getParameter("style");
            String country = (String) request.getParameter("country");
            String picture = (String) request.getParameter("picture");
            String video = (String) request.getParameter("video");
            String error;
            HttpSession session = request.getSession();


            List<Film> films = sql.getAllFilms();

            if (!nameFilm.matches(NAME_REGULAR)){
                ErrorMsg.getInstance().setErrorMsg("Incorrect name film. You can enter 2-20 English letters and numbers.");
                return "AddFilm.jsp";
            }
            if (!year.matches(YEAR_REGULAR)){
                ErrorMsg.getInstance().setErrorMsg("Incorrect year. You can enter 4 numbers.");
                return "AddFilm.jsp";
            }
            if (!style.matches(STYLE_REGULAR)){
                ErrorMsg.getInstance().setErrorMsg("Incorrect style. You can enter 3-20 English letters.");
                return "AddFilm.jsp";
            }
            if (!country.matches(COUNTRY_REGULAR)){
                ErrorMsg.getInstance().setErrorMsg("Incorrect country. You can enter 3-20 English letters.");
                return "AddFilm.jsp";
            }
            if (!picture.matches(PICTURE_REGULAR)){
                ErrorMsg.getInstance().setErrorMsg("Incorrect picture. You can enter 3-20 English letters, numbers and point.");
                return "AddFilm.jsp";
            }
            if (!video.matches(VIDEO_REGULAR)){
                ErrorMsg.getInstance().setErrorMsg("Incorrect video. You can enter 3-20 English letters, numbers and point.");
                return "AddFilm.jsp";
            }

            for (Film film : films) {
                if (film.getName().equals(nameFilm)) {
                    ErrorMsg.getInstance().setErrorMsg("This name used.");

                    return "AddFilm.jsp";
                }
            }

            if (isEmpty(nameFilm) || isEmpty(year) || isEmpty(style) || isEmpty(country) || isEmpty(picture) || isEmpty(video)) {
                ErrorMsg.getInstance().setErrorMsg("Fill in all the fields.");
                return "AddFilm.jsp";
            }

            Film film = new Film();
            film.setName(nameFilm);
            film.setStyle(style);
            film.setYear(Integer.parseInt(year));
            film.setCountry(country);
            film.setPhoto(picture);
            film.setVideo(video);

            if (sql.addFilm(film)) {
                ErrorMsg.getInstance().setErrorMsg("");
                return "/main";
            } else {
                ErrorMsg.getInstance().setErrorMsg("DataBase error.");
                return "AddFilm.jsp";
            }

        } catch (Exception e) {
            System.out.println("ERROR:" + e);
            return "/main";
        }
    }

    private boolean isEmpty(String str) {
        if (str == null || str.equals("")) {
            return true;
        } else {
            return false;
        }
    }
}

