package servlet;

import entity.FacultetEntity;
import entity.StudentEntity;
import service.StudentService;
import service.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path  = req.getPathInfo();
        switch (path){
            case "/deleteBook":{
                String bookName = req.getParameter("book");
                studentService.deleteFromId(Integer.valueOf(bookName));


                resp.sendRedirect(req.getRequestURL().toString().replaceAll(req.getPathInfo(), "/allStudents"));
                break;
            }
            case "/test":{
                List<FacultetEntity> facultetEntities = studentService.getallFacultet();

                req.setAttribute("student", facultetEntities);

                RequestDispatcher dispatcher = req.getRequestDispatcher("/test.jsp");
                dispatcher.forward(req,resp);
                break;

            }
            case "/allStudents":{
               List<StudentEntity> studentEntityList =studentService.getall();


                req.setAttribute("student", studentEntityList);

                RequestDispatcher dispatcher = req.getRequestDispatcher("/allStudent.jsp");
                dispatcher.forward(req,resp);
                break;

            }
            case "/addFacultet":{


                RequestDispatcher dispatcher = req.getRequestDispatcher("/addFacultet.jsp");
                dispatcher.forward(req,resp);
                break;

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path  = req.getPathInfo();
        switch (path) {
            case "/test" :{
                StudentEntity studentEntity = new StudentEntity();
                studentEntity.setName(req.getParameter("name"));
                studentEntity.setGroup(Integer.valueOf( req.getParameter("group")));
                FacultetEntity facultetEntity = studentService.findFacultetById(Integer.valueOf(req.getParameter("testfacultet")));
                studentEntity.setFacultet(facultetEntity.getName());
                studentEntity.setAvscore(req.getParameter("avscore"));
                studentEntity.setNumber(req.getParameter("number"));
                studentEntity.setSurname(req.getParameter("surname"));
                studentService.addStudent(studentEntity);



                resp.sendRedirect(req.getRequestURL().toString().replaceAll(req.getPathInfo(),"/test" ));
            break;
            }
            case "/addFacultet" :{
                FacultetEntity facultetEntity = new FacultetEntity();
                String message = req.getParameter("stud");

                facultetEntity.setName(message);
                studentService.createFacultet(facultetEntity);



                resp.sendRedirect(req.getRequestURL().toString().replaceAll(req.getPathInfo(), "/test?message="+message));
                break;
            }
        }
    }
}
