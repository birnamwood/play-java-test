package controllers;

import play.mvc.*;
import play.db.*;
import play.data.*;

import java.sql.*;
import javax.inject.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    @Inject Database db;

    public Result index() {
        String msg = "database record:<br>";
        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from book");
            msg += "<ul>";
            while (rs.next()) {
                msg += "<li>" + rs.getInt("id") + ":" + rs.getString("book_name") +
                rs.getInt("price");
            }
            msg += "<ul>";
        } catch (SQLException e){}

        return ok(views.html.index.render(msg));
    }

}
