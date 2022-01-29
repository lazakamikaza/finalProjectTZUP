package com.elfak.tzup.controler;

import com.elfak.tzup.model.CourseRequest;
import com.elfak.tzup.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/createCourse", method = RequestMethod.POST)
    public void createCourse(@RequestBody CourseRequest courseRequest) {
        courseService.createCourse(courseRequest);
    }

    @RequestMapping(value = "/deleteCourse", method = RequestMethod.POST)
    public void deleteCourse(@RequestBody CourseRequest courseRequest) {
        courseService.deleteCourse(courseRequest);
    }
}