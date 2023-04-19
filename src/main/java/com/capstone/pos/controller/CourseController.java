package com.capstone.pos.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.pos.model.CourseModel;
import com.capstone.pos.repository.CourseModelRepository;
import com.capstone.pos.response.CoursesResponseModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.pos.model.ProgramOfStudy;
import com.capstone.pos.model.StudentCourseModel;
import com.capstone.pos.response.ValidationResponseModel;


@RestController
@RequestMapping("/courses")
public class CourseController {


    @Autowired
    private CourseModelRepository courseModelRepository;

    @GetMapping("/{id}")
    public CoursesResponseModel getCoursesByDept(@PathVariable int id) {
        CoursesResponseModel responseModel = new CoursesResponseModel();

        try{

        List<CourseModel> courseList = courseModelRepository.findByDepartmentCode(id);
        if (!courseList.isEmpty()) {
            responseModel.setData(courseList);
            responseModel.setStatus(200);
            responseModel.setErrorMessage("Success");
            return responseModel;
        } else {

            responseModel.setData(null);
            responseModel.setErrorMessage("Error");
           
        }
    }catch(Exception e){
        responseModel.setErrorMessage(e.getMessage());
    }
    return responseModel;
    }

    final int MAJOR = 1;
    final int MINOR = 2;
    final int MATH = 3;

    @PostMapping("/validate")
    public ValidationResponseModel validateProgramOfStudy(@RequestBody ProgramOfStudy programOfStudy) {
        int totalCredits = 0;
        int majorCredits = 0;
        int minorCredits = 0;
        int mathCredits = 0;
        boolean hasEthicsCourse = false;
        int num700LevelCredits = 0;
        int mastersCredits = 0;
        ValidationResponseModel responseModel = new ValidationResponseModel();
        // Validate credits for each section
        for (StudentCourseModel course : programOfStudy.getCourses()) {
            // if (!isValidCourseCode(course.getCode())) {
            //     return ResponseEntity.badRequest().body("Invalid course code: " + course.getCode());
            // }
            totalCredits += course.getCredits();

            if (course.getArea() == MAJOR) {
                majorCredits += course.getCredits();
            } else if (course.getArea() == MINOR) {
                minorCredits += course.getCredits();
            } else if (course.getArea() == MATH) {
                mathCredits += course.getCredits();
            }
             // Check for 700 level or higher courses
           
            if (course.getCourseLevel() >= 700 && course.getCourseLevel()<800) {
                num700LevelCredits += course.getCredits();
            }
          
            if(course.isMastersCourse()){
                mastersCredits+=course.getCredits();
            }
           

        }

        // Check total credit hours
        if (totalCredits < 66 ) {
            responseModel.setStatusCode(400);
                responseModel.setErrorMessage("Total credits must be atleast 66");
                return responseModel;
        }

        // Check major area credits
        if (majorCredits < 21) {
            responseModel.setStatusCode(400);
            responseModel.setErrorMessage("At least 21 credits must be in the major area");
            return responseModel;

        }

        // Check minor area credits
        if (minorCredits < 9) {
            responseModel.setStatusCode(400);
            responseModel.setErrorMessage("At least 9 credits must be in the minor area");
            return responseModel;
        }

        // Check math/quantitative methods credits
        if (mathCredits < 6) {
            responseModel.setStatusCode(400);
            responseModel.setErrorMessage("At least 6 credits must be in math/quantitative methods");
            return responseModel;
        }

        // Check for ethics course
        if (!hasEthicsCourse) {
            responseModel.setStatusCode(400);
            responseModel.setErrorMessage("Must have completed the Ethics and Engineering Communication course (xxx700)");
            return responseModel;

        }

        if(mastersCredits>33){
            responseModel.setStatusCode(400);
            responseModel.setErrorMessage("Only upto 33 credits can be transferred from Master's Program");
        }

        if (num700LevelCredits < 26) {
            responseModel.setStatusCode(400);
            responseModel.setErrorMessage("At least 26 credits must be at the 700 level or higher");
            return responseModel;
        }
        
       

        // // Check GPA in each area
        // if (programOfStudy.getMajorGPA() < 3.0 || programOfStudy.getMinorGPA() < 3.0 || programOfStudy.getMathGPA() < 3.0 || programOfStudy.getEthicsGPA() < 3.0) {
        //     return ResponseEntity.badRequest().body("GPA must be at least 3.0 in all areas");
        // }

        // Check for valid major area
        // if (!isValidMajorArea(programOfStudy.getMajorArea())) {
        //     return ResponseEntity.badRequest().body("Invalid major area: " + programOfStudy.getMajorArea());
        // }


        // Check for valid minor area
        // if (!isValidMinorArea(programOfStudy.getMinorArea())) {
        //     return ResponseEntity.badRequest().body("Invalid minor area: " + programOfStudy.getMinorArea());
        // }

        responseModel.setStatusCode(200);
        responseModel.setErrorMessage("Program of Study form fulfills all credit requirement");
        return responseModel;

      
        
    }
        


    
}
