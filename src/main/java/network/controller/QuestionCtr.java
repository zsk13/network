package network.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import network.model.Course;
import network.model.Question;
import network.model.Teacher;
import network.service.AnswerService;
import network.service.QuestionService;
import network.vo.AnswerVO;

@Controller
@RequestMapping(value = "question")
public class QuestionCtr {
    Log logger = LogFactory.getLog(QuestionCtr.class);

    @Autowired
    QuestionService questionservice;
    
    @Autowired
    AnswerService answerservice;


    @RequestMapping(value = "/addquestion.do")
    public ModelAndView QuestionAddView(HttpServletResponse res, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        List<Course> courseList = questionservice.getCourses(teacher.gettId());
        mv.addObject("courseList", courseList);
        mv.setViewName("question");
        return mv;
    }

    @RequestMapping(value = "/questionlist.do")
    public ModelAndView QuestionListView(HttpServletResponse res, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("questionList");
        List<Question> qs = questionservice.getQuestions();
        mv.addObject("qs", qs);
        return mv;
    }
    
    @RequestMapping(value = "/answer.do")
    public ModelAndView AnswerView(Long qid,HttpServletResponse res, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("answer");
        List<Integer> qs = answerservice.getAnswerNum(qid);
        List<AnswerVO> as = answerservice.getAnswerVO(qid);
        mv.addObject("qid", qid);
        mv.addObject("as", as);
        mv.addObject("total", qs.get(0));
        mv.addObject("correct", qs.get(1));
        mv.addObject("wrong", qs.get(2));
        return mv;
    }
    
    @RequestMapping(value = "/editquestion.do")
    public ModelAndView editQuestion(Long qid,HttpServletResponse res, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("editQuestion");
        Question q = questionservice.getQuestion(qid);
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        List<Course> courseList = questionservice.getCourses(teacher.gettId());
        mv.addObject("courseList", courseList);
        mv.addObject("q", q);
        return mv;
    }
    
    
    @RequestMapping(value = "/edit.do")
    @ResponseBody
    public String edit(Long qid,Long cId,String question,String answer,String status,HttpServletResponse res, HttpServletRequest request){
        Date first = new Date();
        DateFormat formatfirst = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createtime = formatfirst.format(first);

        Question que=new Question();
        que.setQid(qid);
        que.setAnswer(answer);
        que.setQuestion(question);
        que.setStatus(status);
        que.setCourseId(cId);
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        que.setTeacherId(teacher.gettId());

        questionservice.update(que);
        return "success";
    }

    @RequestMapping(value = "/add.do")
    @ResponseBody
    public String add(Long cId,String question,String answer,String status,HttpServletResponse res, HttpServletRequest request){
        Date first = new Date();
        DateFormat formatfirst = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createtime = formatfirst.format(first);

        Question que=new Question();
        que.setQid(first.getTime());
        que.setAnswer(answer);
        que.setQuestion(question);
        que.setStatus(status);
        que.setCourseId(cId);
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        que.setTeacherId(teacher.gettId());

        questionservice.insert(que);
        return "success";

    }
    
    @RequestMapping(value = "/export.do")
    public void export(Long qid,HttpServletResponse response, HttpServletRequest request) throws Exception {
        List<AnswerVO> as = answerservice.getAnswerVO(qid);
        
        HSSFWorkbook wb = new HSSFWorkbook();
       
        //创建一张表sheet  
        HSSFSheet sheet = wb.createSheet("sheet0");  
        //第0行，即表头  
        HSSFRow header = sheet.createRow(0);  
        //生成表头  
        String[] titles = new String[]{"序号","姓名","内容","是否正确"};
        for (int i = 0; i < titles.length; i++) {  
            header.createCell((short)i).setCellValue(titles[i]);  
        }  
        // 填充数据  
        int rowNum = 1;  
        for (Iterator<AnswerVO> iter = as.iterator(); iter.hasNext();) {  
            AnswerVO element = iter.next();  
            HSSFRow row = sheet.createRow(rowNum++);  
            row.createCell((short) 0).setCellValue(rowNum-1);  
            row.createCell((short) 1).setCellValue(element.getUsername());  
            row.createCell((short) 2).setCellValue(element.getContent());  
            row.createCell((short) 3).setCellValue(element.getCorrect());    
        }  
        try {
          response.setHeader("Content-Disposition", "attachment; filename=appointmentUser.xls");
          response.setContentType("application/vnd.ms-excel; charset=utf-8") ;
          OutputStream out = response.getOutputStream() ;
          wb.write(out) ;
          out.flush();
          out.close();
        } catch (IOException e) {
          e.printStackTrace();
        } 
    }
    
    @RequestMapping(value = "/publishQuestion.do")
    public void publishQuestion(Long qid,HttpServletResponse res, HttpServletRequest request) throws Exception {
        questionservice.publishQuestion(qid);
    }

    @RequestMapping(value = "/finishQuestion.do")
    public String finishQuestion(Long qid,HttpServletResponse res, HttpServletRequest request) throws Exception{
        questionservice.finishQuestion(qid);
        return "redirect:./questionlist.do";
    }

}
