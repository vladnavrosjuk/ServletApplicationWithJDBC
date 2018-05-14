import auth.VK;
import entity.FacultetEntity;
import entity.StudentEntity;
import service.StudentService;
import service.StudentServiceImpl;

public class Test {
    public static void main(String[] args) {
            StudentService studentService = new StudentServiceImpl();
            StudentEntity studentEntity = studentService.getall().get(0);
            studentEntity.setName("sdssd");
            studentService.updateStudent(studentEntity.getId(),studentEntity);


    }
}
