package service;

import dao.StudentDBConnector;
import dao.StudentDBConnectorImpl;
import entity.FacultetEntity;
import entity.StudentEntity;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDBConnector dao = new StudentDBConnectorImpl();
    @Override
    public StudentEntity addStudent(StudentEntity studentEntity) {
        return dao.createStudent(studentEntity);
    }

    @Override
    public List<StudentEntity> getall() {
        return dao.getall();
    }

    @Override
    public FacultetEntity createFacultet(FacultetEntity facultetEntity) {
        return dao.createFacultet(facultetEntity);
    }

    @Override
    public List<FacultetEntity> getallFacultet() {
        return dao.getallFacultet();
    }

    @Override
    public FacultetEntity findFacultetById(Integer id) {
        return dao.findFacultetById(id);
    }

    @Override
    public StudentEntity deleteFromId(Integer id) {
        return dao.deleteFromId(id);
    }

    @Override
    public void updateStudent(Integer id, StudentEntity studentEntity) {
        dao.updateStudent(id,studentEntity);
    }
}
