package dao;

import entity.FacultetEntity;
import entity.StudentEntity;

import java.util.List;

public interface StudentDBConnector {
    StudentEntity createStudent( StudentEntity studentEntity);
    List<StudentEntity> getall();
    FacultetEntity createFacultet(FacultetEntity facultetEntity);
    List<FacultetEntity > getallFacultet();
    FacultetEntity findFacultetById (Integer id);
    StudentEntity deleteFromId(Integer id);
    void updateStudent(Integer id, StudentEntity studentEntity);
}
