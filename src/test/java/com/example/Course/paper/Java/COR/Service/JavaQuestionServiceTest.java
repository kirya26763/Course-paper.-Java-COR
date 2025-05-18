package com.example.Course.paper.Java.COR.Service;

import com.example.Course.paper.Java.COR.Model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private JavaQuestionService service;

    @BeforeEach
    void setUp() {
        service = new JavaQuestionService();
        service.addQuestion(new Question("Что такое ООП?", "Объектно-ориентированное программирование"));
        service.addQuestion(new Question("Что делает static?", "Принадлежность классу"));
    }

    @Test
    void addQuestion_shouldAddSuccessfully() {
        service.addQuestion(new Question("Что такое JDK?", "Java Development Kit"));
        assertEquals(3, service.getAllQuestions().size());
    }

    @Test
    void removeQuestion_shouldRemoveSuccessfully() {
        assertTrue(service.removeQuestion("Что такое ООП?"));
        assertEquals(1, service.getAllQuestions().size());
    }

    @Test
    void removeQuestion_shouldReturnFalseIfNotFound() {
        assertFalse(service.removeQuestion("Несуществующий вопрос"));
    }

    @Test
    void findQuestion_shouldReturnCorrectQuestion() {
        Optional<Question> q = service.findQuestion("Что такое ООП?");
        assertTrue(q.isPresent());
        assertEquals("Объектно-ориентированное программирование", q.get().getAnswer());
    }

    @Test
    void getRandomQuestions_shouldReturnUniqueQuestions() {
        List<Question> random = service.getRandomQuestions(2);
        assertEquals(2, random.size());
        assertNotEquals(random.get(0), random.get(1));
    }
}