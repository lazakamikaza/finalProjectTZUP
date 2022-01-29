package com.elfak.tzup.controler;

import com.elfak.tzup.model.EnrollmentRequest;
import com.elfak.tzup.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollmentController {
    @Autowired
    EnrollmentService enrollmentService;

    @RequestMapping(value = "/createEnrollment", method = RequestMethod.POST)
    public void createCourseEnrollment(@RequestBody EnrollmentRequest enrollmentRequest) {
        enrollmentService.createEnrollment(enrollmentRequest);
    }

    @RequestMapping(value = "/deleteEnrollment", method = RequestMethod.POST)
    public void deleteCourseEnrollment(@RequestBody EnrollmentRequest enrollmentRequest) {
        enrollmentService.deleteEnrollment(enrollmentRequest);
    }
}
