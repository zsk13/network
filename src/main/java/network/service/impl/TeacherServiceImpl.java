package network.service.impl;

import network.dao.TeacherMapper;
import network.model.Teacher;
import network.model.TeacherExample;
import network.service.TeacherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    Log logger = LogFactory.getLog(TeacherServiceImpl.class);

    @Autowired
    private TeacherMapper teacherMapper;


    public void createTeacher(Teacher teacher) {
        teacherMapper.insert(teacher);
    }

    public void deleteTeacherBytNumber(String tNumber) {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTNumberEqualTo(tNumber);
        teacherMapper.deleteByExample(teacherExample);
    }

    public void updateTeacherBytNumber(Teacher teacher, String tNumber) {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTNumberEqualTo(tNumber);
        teacherMapper.updateByExampleSelective(teacher, teacherExample);
    }

    public boolean login(String teacherName, String password) {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTNameEqualTo(teacherName);
        List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
        Teacher teacher = teacherList.get(0);
        if (teacher == null) {
            return true;
        } else {
            if (password.equals(teacher.gettPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }

    public Teacher findTeacherBytNumber(String tNumber) {
        TeacherExample teacherExampleNumber = new TeacherExample();
        TeacherExample.Criteria criteriaNumber = teacherExampleNumber.createCriteria();
        criteriaNumber.andTNumberEqualTo(tNumber);

        List<Teacher> teacherList = teacherMapper.selectByExample(teacherExampleNumber);
        Teacher teacher = teacherList.get(0);
        return teacher;
    }

    public Teacher findTeacherBytName(String tName) {
        TeacherExample teacherExampleName = new TeacherExample();
        TeacherExample.Criteria criteriaName = teacherExampleName.createCriteria();
        criteriaName.andTNameEqualTo(tName);

        List<Teacher> teacherList = teacherMapper.selectByExample(teacherExampleName);
        Teacher teacher = teacherList.get(0);
        return teacher;
    }

    public List<Teacher> getTeachers() {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        teacherExample.setOrderByClause("t_id DESC");
        return teacherMapper.selectByExample(teacherExample);
    }

}
