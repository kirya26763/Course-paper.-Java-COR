package com.example.Course.paper.Java.COR.Service.Interfaces;

import com.example.Course.paper.Java.COR.Model.Question;

import java.util.List;

public interface ExaminerService {
    List<Question> getQuestions(int amount);
}