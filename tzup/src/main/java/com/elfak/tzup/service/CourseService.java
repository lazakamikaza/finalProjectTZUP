package com.elfak.tzup.service;

import com.elfak.tzup.model.CourseRequest;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class CourseService {
    private static final String pathToDemo = "C:/demo";

    public void createCourse(CourseRequest courseRequest) {
        Path path = Paths.get(pathToDemo + "/" + courseRequest.getCourseName());
        try {
            Files.createDirectories(path);
            Workbook workbook =  new XSSFWorkbook();
            Sheet studentsSheet = workbook.createSheet("Students");
            Row header = studentsSheet.createRow(0);
            header.createCell(0).setCellValue("Index");
            header.createCell(1).setCellValue("Last Name");
            header.createCell(2).setCellValue("First Name");
            header.createCell(3).setCellValue("Email");

            FileOutputStream outputStream = new FileOutputStream(path.toString() + "/Students.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse(CourseRequest courseRequest) {
        try{
            FileUtils.deleteDirectory(new File(pathToDemo + "/" + courseRequest.getCourseName()));
        } catch (IOException e) {
            System.err.println("Failed to delete directory!" + e.getMessage());
        }
    }
}
