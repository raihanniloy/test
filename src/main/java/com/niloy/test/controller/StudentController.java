package com.niloy.test.controller;

import com.niloy.test.dao.StudentsDAO;
import com.niloy.test.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

     @Autowired
     StudentsDAO studentsRepo;

    @RequestMapping("/viewstudents")
    public String viewstudents(Model model)
    {
        List<Student> students = studentsRepo.findAll();
        model.addAttribute("students",students);
        return "viewstudents";
    }
    @RequestMapping("/addstudents")
    public String addstudents()
    {
        return "addstudent";
    }

    @RequestMapping("/savestudent")
    public String savestudent(Student student)
    {
        studentsRepo.save(student);
        return "redirect:/viewstudents";
    }

    @RequestMapping(value = "/deletestudent", method = RequestMethod.GET)
    public String deleteStudent(@RequestParam(name="id") int id)
    {
        //System.out.println("asdsad"+id);
        Student stu = studentsRepo.findById(id);
        studentsRepo.delete(stu);
        return "redirect:/viewstudents";
    }

    @RequestMapping("/updatestudent")
    public String updateStudent(@RequestParam(name="id") int id, Model model)
    {
        Student stu = studentsRepo.findById(id);
        model.addAttribute("stu",stu);
        return "updatestudent";

    }
}
