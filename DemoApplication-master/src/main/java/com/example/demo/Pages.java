package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
//controller - for any path , if you want ot define, use this.
@RestController
public class Pages {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("/home")
    public String home()
    {
        return "<html>\n" +
                "<body>\n" +
                "<h1 style=\"text-align: center\">Student Registration Form</h1>\n" +
                "<form style=\"margin: auto; width: 220px;\" action=\"addUser\">\n" +
                "    <fieldset>\n" +
                "        <label>Name:</label>    <input type=\"text\"  name=\"name\" required/> <br/><br/>\n" +//Lakshmi willl be tagged with "name"
                "        <label>Phone:</label>   <input type=\"text\"  name=\"phone\" required/> <br/><br/>\n" +//911323 tagged with "phone" variable
                "        <label>Email:</label>   <input type=\"text\"  name=\"email\" required/> <br/><br/>\n" +
                "        <label>Grade:</label>  <input type=\"text\"  name=\"grade\" required/> <br/><br/>\n" +
                "        <label>Age:</label>     <input type=\"text\"  name=\"age\" required/><br/><br/>\n" +
                "        <input type=\"submit\"/>\n" +
                "    </fieldset>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>";
    }
//http://localhost:8080/
    @RequestMapping("/")
    public String index()
    {
        return "<html>\n" +
                "<body>\n" +
                "<h1 style=\"text-align: center\"> MENU </h1>\n" +
                "<form style=\"text-align: center\" action=\"getPage\">\n" +
                "    <input type=\"submit\" value=\"Get Student by ID\"/>\n" +
                "</form><br/><br/><br/>\n" +
                "\n" +
                "<form style=\"text-align: center\" action=\"allstudents\">\n" +
                "    <input type=\"submit\" value=\"List All Students\"/>\n" +
                "</form><br/><br/><br/>\n" +
                "\n" +
                "\n" +
                "<form style=\"text-align: center\" action=\"delete\">\n" +
                "    <input type=\"submit\" value=\"Delete Student\"/>\n" +
                "</form><br/><br/><br/>\n" +
                "\n" +
                "<form style=\"text-align: center\" action=\"home\">\n" +
                "    <input type=\"submit\" value=\"Add Student\"/>\n" +
                "</form><br/><br/><br/>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }

    @RequestMapping("/addUser")
    public String addemp(Student student)//aid, name, age, phone
            //addemp(String name, String age, ....)
            /*
            {
                stud = new studnet(name, age, phone...);

             */
    {
        System.out.println(student);
        System.out.println("entered add student");
        studentRepository.save(student);
        return "<html>\n" +
                "<body>\n" +
                "<h1 style= \"margin-top:auto;text-align:center;color:green\"> Added student successfully. <br/> <a href=\"/\">Menu</a></h1>\n" +
                "</body>\n" +
                "</html>";
    }

    @RequestMapping("/getPage")
    public String getform()
    {
        return "<html>\n" +
                "<body>\n" +
                "<h1 style=\"text-align: center\"> Get Form</h1>\n" +
                "<form style=\"margin: auto; width: 220px;\" action=\"getStudById\">\n" +
                "    <fieldset>\n" +
                "        <label>Student ID:</label>    <input type=\"text\"  name=\"aid\" required/> <br/><br/>\n" +
                "        <input type=\"submit\"/>\n" +
                "    </fieldset>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>";
    }

    @RequestMapping("/getStudById")
    public String getStudent(int aid)
    {
        ModelAndView mv=new ModelAndView();
        Student student=studentRepository.findByAid(aid);
        return
                "<html>\n" +
                "<body>\n" +
                "<h1>Student Details:</h1>\n" +
                "<fieldset>\n" +
                "    <br/>\n" +
                "    Student ID: "+student.getAid()+"<br/>\n" +
                "    Name: "+student.getName()+"<br/>\n" +
                "    Age: "+student.getAge()+"<br/>\n" +
                "    Email:"+student.getEmail()+"<br/>\n" +
                "    Grade: "+student.getGrade()+"<br/>\n" +
                "    Contact Details: "+student.getPhone()+"<br/>\n" +
                "</fieldset>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
    }

    @RequestMapping("/allstudents")
    public String allStudents()
    {
        List<Student> students=studentRepository.findAll();// select * from student;
        String res=new String();
        for(Student student:students)
        {
            System.out.println(student);
            res+="<fieldset>\n" +
                    "    <br/>\n" +
                    "    Student ID: "+student.getAid()+"<br/>\n" +
                    "    Name: "+student.getName()+"<br/>\n" +
                    "    Age: "+student.getAge()+"<br/>\n" +
                    "    Email:"+student.getEmail()+"<br/>\n" +
                    "    Grade: "+student.getGrade()+"<br/>\n" +
                    "    Contact Details: "+student.getPhone()+"<br/>\n" +
                    "</fieldset>\n" ;
        }

           return(
                   "<html>\n" +
                "<body>\n" +
                "<h1 style=\"text-align: center\">All Students</h1>\n" +res+
                "\n" +
                "</body>\n" +
                "</html>\n");
    }

    @RequestMapping("delete")
    public String deleteForm()
    {
        return "<html>\n" +
                "<body>\n" +
                "<h1 style=\"text-align: center\"> Delete Form</h1>\n" +
                "<form style=\"margin: auto; width: 220px;\" action=\"deleteById\">\n" +
                "    <fieldset>\n" +
                "        <label>Student ID:</label>    <input type=\"text\"  name=\"aid\" required/> <br/><br/>\n" +
                "        <input type=\"submit\"/>\n" +
                "    </fieldset>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>";
    }
    @RequestMapping("/deleteById")
    public String delete(int aid)
    {
        System.out.println("enterd delte");
        studentRepository.delete(studentRepository.findByAid(aid));
        return "<html>\n" +
                "<body>\n" +
                "<h1 style= \"margin-top:auto;text-align:center;color:green\"> Deleted successfully. <br/> <a href=\"/\">Menu</a></h1>\n" +
                "</body>\n" +
                "</html>";
    }
}
