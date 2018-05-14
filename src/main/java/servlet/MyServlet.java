package servlet;

import auth.GitHub;
import auth.VK;
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
import java.util.Map;

public class MyServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path  = req.getPathInfo();
        switch (path){
            case "/vk":{
                VK vk = new VK();
                vk.execute(resp);


                break;
            }
            case "/github":{
                GitHub gitHub = new GitHub();
                gitHub.execute(resp);


                break;
            }

            case "/deleteStudent":{
                String student = req.getParameter("student");
                studentService.deleteFromId(Integer.valueOf(student));


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
            case "/editStudent":{
                List<FacultetEntity> facultetEntities = studentService.getallFacultet();

                req.setAttribute("student", facultetEntities);
                String message = req.getParameter("studentID");


                req.setAttribute("studentValue", message);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/editStudent.jsp");

                dispatcher.forward(req,resp);
                break;

            }
            case "/allStudents":{
                VK vk = new VK();
                GitHub gitHub = new GitHub();

               List<StudentEntity> studentEntityList =studentService.getall();
               if (req.getParameter("type")!=null) {
                   if (req.getParameter("type").equals("vk")) {
                       String code = req.getParameter("code");
                       String name = vk.getName(code);

                       req.setAttribute("studentNameValue", name);
                       req.getSession().setAttribute("name", name);
                       req.setAttribute("student", studentEntityList);

                   }
                   if (req.getParameter("type").equals("github")) {
                       String code = req.getParameter("code");
                       String name = gitHub.getName(code);
                       System.out.println();
                       req.setAttribute("studentNameValue", name);
                       req.getSession().setAttribute("name", name);
                       req.setAttribute("student", studentEntityList);
                   }
               }

                else  {
                    req.setAttribute("studentNameValue", req.getSession().getAttribute("name"));

                }
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
            case "/editStudent" :{


                String id = req.getParameter("studentId");

                StudentEntity studentEntity = new StudentEntity();
                studentEntity.setName(req.getParameter("name"));
                studentEntity.setGroup(Integer.valueOf( req.getParameter("group")));
                FacultetEntity facultetEntity = studentService.findFacultetById(Integer.valueOf(req.getParameter("testfacultet")));
                studentEntity.setFacultet(facultetEntity.getName());
                studentEntity.setAvscore(req.getParameter("avscore"));
                studentEntity.setNumber(req.getParameter("number"));
                studentEntity.setSurname(req.getParameter("surname"));
                studentService.updateStudent(Integer.valueOf(id),studentEntity);



                resp.sendRedirect(req.getRequestURL().toString().replaceAll(req.getPathInfo(),"/allStudents" ));
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
