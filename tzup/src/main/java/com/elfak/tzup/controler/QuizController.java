package com.elfak.tzup.controler;

import com.elfak.tzup.model.QuizRequest;
import com.elfak.tzup.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {
    @Autowired
    QuizService quizService;

    @RequestMapping(value = "/quizAttempted", method = RequestMethod.POST)
    public void createQuizAttempt(@RequestBody QuizRequest quizRequest) {
        quizService.createQuizAttempt(quizRequest);
    }
}
