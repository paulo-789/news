import com.google.gson.Gson;
import dao.Sql2oNewsDao;
import dao.Sql2oUsersDao;
import dao.Sql2oDepartmentDao;
import models.Department;
import models.News;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        Sql2oUsersDao usersDao;
        Sql2oDepartmentDao departmentDao;
        Sql2oNewsDao newsDao;
        Connection conn;
//        Gson gson = new Gson();
        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "paul", "Negotiator");
//        departmentDao = new Sql2oDepartmentDao(sql2o);
//        usersDao = new Sql2oUsersDao(sql2o);
//        newsDao = new Sql2oNewsDao(sql2o);
//        conn = sql2o.open();
//        post("/department/new", "application/json", (req, res) -> { //accept a request in format JSON
//            Department department = gson.fromJson(req.body(), Department.class);//make with GSON
//            departmentDao.add(department);//Do our thing with our DAO
//            res.status(201);//everything went well - update the response status code
//            res.type("application/json");
//            return gson.toJson(department);//send it back to be displayed
//        });
//        post("/departments/:departmentId/news/new", "application/json", (req, res) -> {
//            int departmentId = Integer.parseInt(req.params("departmentId"));
//            News news = gson.fromJson(req.body(), News.class);
//
//            news.setDepartmentId(departmentId); //we need to set this separately because it comes from our route, not our JSON input.
//            newsDao.add(news);
//            res.status(201);
//            return gson.toJson(news);
//        });
//        get("/departments", "application/json", (req, res) -> { //accept a request in format JSON from an app
//            res.type("application/json");
//            return gson.toJson(departmentDao.getAll());//send it back to be displayed
//        });
//        get("/departments/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
//            res.type("application/json");
//            int departmentId = Integer.parseInt(req.params("id"));
//            res.type("application/json");
//            return gson.toJson(departmentDao.findById(departmentId));
//        });
        get("/department", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "departmentform.hbs");
        }, new HandlebarsTemplateEngine());
        get("/users", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newsform.hbs");
        }, new HandlebarsTemplateEngine());
        get("/news", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "usersform.hbs");
        }, new HandlebarsTemplateEngine());
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();  //displaying home
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/dep", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String description = request.queryParams("description");
            int numberOfStaff= Integer.parseInt(request.queryParams("numberOfStaff"));
            Department newDepertment = new Department(name,description,numberOfStaff);
            model.put("department", newDepertment);
            return new ModelAndView(model, "departmentdetails.hbs");
        }, new HandlebarsTemplateEngine());
        post("/news", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String content = request.queryParams("content");
            String writtenBy = request.queryParams("writtenBy");
            int departmentId = Integer.parseInt(request.queryParams("departmentId"));
            News newNews = new News(content, writtenBy, departmentId);
            model.put("News", newNews);
            return new ModelAndView(model, "newsdetails.hbs");
        }, new HandlebarsTemplateEngine());

        post("/users", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String position = request.queryParams("position");
            Users newUsers = new Users(name,position);
            model.put("users", newUsers);
            return new ModelAndView(model, "usersdetails.hbs");
        }, new HandlebarsTemplateEngine());

        //FILTERS
        after((req, res) ->{
            res.type("application/json");
        });

    }
}
