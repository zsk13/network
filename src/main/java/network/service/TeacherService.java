package network.service;

import network.model.Teacher;

import java.util.List;

public interface TeacherService {

    void createTeacher(Teacher Teacher);

    void deleteTeacherBytNumber(String tNumber);

    void updateTeacherBytNumber(Teacher teacher, String tNumber);

    Teacher findTeacher(String tNameORNumber);


    boolean login(String TeacherName, String password);

    List<Teacher> getTeachers();
}
