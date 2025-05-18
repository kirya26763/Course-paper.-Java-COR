package com.example.Course.paper.Java.COR.Controller;

import com.example.Course.paper.Java.COR.Model.Question;
import com.example.Course.paper.Java.COR.Service.Interfaces.ExaminerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService examinerService;

    @Autowired
    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public List<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}