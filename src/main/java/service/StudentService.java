package service;

import entity.FacultetEntity;
import entity.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentEntity addStudent(StudentEntity studentEntity);
    List<StudentEntity> getall();
    FacultetEntity createFacultet(FacultetEntity facultetEntity);
    List<FacultetEntity > getallFacultet();
    FacultetEntity findFacultetById (Integer id);
    StudentEntity deleteFromId(Integer id);
    void updateStudent(Integer id, StudentEntity studentEntity);

}
