package dao;

import entity.FacultetEntity;
import entity.StudentEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDBConnectorImpl implements StudentDBConnector {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/netcracker?createDatabaseIfNotExist=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";

    private static final String insertStudent = "INSERT  INTO students " +
            "(name, surname, studentgroup, facultet, avscore, number) VALUES (?, ?, ?,?, ?, ?)";
    private static final String insertFacultet = "INSERT  INTO facultet " +
            "(namefacultet) VALUES (?)";
    private static final String selectAllStudet = "SELECT * FROM students";
    private static final String selectAllFacultet = "SELECT * FROM facultet";
    private static final String selectFacultetFromID = "SELECT * FROM facultet " +
            "WHERE id = ?";
    private static final String deleteStudentFormId= "DELETE FROM students " +
            "WHERE id = ?";
    private static final String updateStudentFromId= "UPDATE students SET name = ?, surname= ?, studentgroup= ?, facultet= ? , avscore= ?, number= ? "+ "WHERE id= ?";

    @Override
    public StudentEntity createStudent( StudentEntity studentEntity) {

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement ps = conn.prepareStatement(insertStudent, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, studentEntity.getName());
            ps.setString(2, studentEntity.getSurname());
            ps.setInt(3, studentEntity.getGroup());
            ps.setString(4, studentEntity.getFacultet());
            ps.setString(5, studentEntity.getAvscore());
            ps.setString(6, studentEntity.getNumber());
            ps.execute();

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return studentEntity;
    }

    @Override
    public List<StudentEntity> getall() {
        List<StudentEntity> studentEntityList = new ArrayList<>();
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement ps = conn.prepareStatement(selectAllStudet);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudentEntity studentEntity = new StudentEntity();
                studentEntity.setId(rs.getInt("id"));
                studentEntity.setName(rs.getString("name"));
                studentEntity.setSurname(rs.getString("surname"));
                studentEntity.setGroup(rs.getInt("studentgroup"));
                studentEntity.setFacultet(rs.getString("facultet"));
                studentEntity.setAvscore(rs.getString("avscore"));
                studentEntity.setNumber(rs.getString("number"));
                studentEntityList.add(studentEntity);

            }
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return studentEntityList;
    }

    @Override
    public FacultetEntity createFacultet(FacultetEntity facultetEntity) {

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement ps = conn.prepareStatement(insertFacultet, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, facultetEntity.getName());

            ps.execute();

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return facultetEntity;
    }

    @Override
    public List<FacultetEntity> getallFacultet() {
        List<FacultetEntity> facultetEntities = new ArrayList<>();
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement ps = conn.prepareStatement(selectAllFacultet);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               FacultetEntity facultetEntity = new FacultetEntity();
                facultetEntity.setName(rs.getString("namefacultet"));
                facultetEntity.setId(rs.getInt("id"));

                facultetEntities.add(facultetEntity);

            }
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return facultetEntities;
    }

    @Override
    public FacultetEntity findFacultetById(Integer id) {
        Connection conn = null;
        FacultetEntity facultetEntity = new FacultetEntity();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement ps = conn.prepareStatement(selectFacultetFromID);
            ps.setString(1,String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                facultetEntity.setName(rs.getString("namefacultet"));
            }





            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return facultetEntity;

    }

    @Override
    public StudentEntity deleteFromId(Integer id) {
        StudentEntity studentEntity = new StudentEntity();
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement ps = conn.prepareStatement(deleteStudentFormId, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, String.valueOf(id));

            ps.execute();

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return studentEntity;
    }

    @Override
    public void updateStudent(Integer id, StudentEntity studentEntity) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement ps = conn.prepareStatement(updateStudentFromId, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, studentEntity.getName());
            ps.setString(2, studentEntity.getSurname());
            ps.setInt(3, studentEntity.getGroup());
            ps.setString(4, studentEntity.getFacultet());
            ps.setString(5, studentEntity.getAvscore());
            ps.setString(6, studentEntity.getNumber());
            ps.setInt(7, id);
            ps.execute();

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
