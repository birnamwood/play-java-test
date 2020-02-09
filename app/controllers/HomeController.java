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
        String msg = "<table><tbody><thead><tr><th>ID</th><th>Name</th><th>Price</th><tbody><tr>";
        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from book");
            while (rs.next()) {
                msg += "<th>" + rs.getInt("id") + "</th>";
                msg += "<th>" + rs.getString("book_name") + "</th>";
                msg += "<th>" + rs.getInt("price") + "</th>";
            }
            msg += "</tr></tbody></table>";
        } catch (SQLException e){}

        return ok(views.html.index.render(msg));
    }

}
