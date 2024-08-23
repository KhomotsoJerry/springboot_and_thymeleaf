package com.khomotso.springboot_thymeleaf_crud_web_app.controller;


import com.khomotso.springboot_thymeleaf_crud_web_app.model.Student;
import com.khomotso.springboot_thymeleaf_crud_web_app.service.StudentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
   @Autowired
    private StudentServiceImplementation studentServiceImplementation;

   @GetMapping("/")
    public String viewHomePage(Model model){
       model.addAttribute("listEmployee",studentServiceImplementation.getAllStudents());
       return "index";
   }
   @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
       Student student = new Student();
       model.addAttribute("student",student);
       return "new_student";
   }
   @GetMapping("/showFormDelete/{id}")
   public String showFormDelete(@PathVariable("id") Long id){
       this.studentServiceImplementation.deleteById(id);
       return "redirect:/";
   }
   @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student){
       // save student in the database
       studentServiceImplementation.saveStudent(student);
       return "redirect:/";
   }
   @GetMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable("id") Long id , Model model){
       // get student from service
       Student student = studentServiceImplementation.getStudentById(id);
       // set model as a attribute to pre-populate the form
       model.addAttribute("student",student);
       return "update_student";
   }
}
