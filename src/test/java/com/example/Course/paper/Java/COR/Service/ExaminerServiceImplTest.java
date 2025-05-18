package com.example.Course.paper.Java.COR.Service;

import com.example.Course.paper.Java.COR.Model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExaminerServiceImplTest {

    private ExaminerServiceImpl examinerService;
    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
        javaQuestionService.addQuestion(new Question("Q1", "A1"));
        javaQuestionService.addQuestion(new Question("Q2", "A2"));
        javaQuestionService.addQuestion(new Question("Q3", "A3"));
        examinerService = new ExaminerServiceImpl(javaQuestionService);
    }

    @Test
    void getQuestions_shouldReturnRequestedAmount() {
        List<Question> questions = examinerService.getQuestions(2);
        assertEquals(2, questions.size());
    }

    @Test
    void getQuestions_shouldReturnUniqueQuestions() {
        List<Question> questions = examinerService.getQuestions(3);
        assertEquals(3, questions.size());
        assertEquals(3, questions.stream().distinct().count());
    }

    @Test
    void getQuestions_shouldThrowIfAmountTooLarge() {
        assertThrows(ResponseStatusException.class, () -> examinerService.getQuestions(10));
    }
}
