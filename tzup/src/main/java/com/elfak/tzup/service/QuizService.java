package com.elfak.tzup.service;

import com.elfak.tzup.model.QuizRequest;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;

@Service
public class QuizService {
    private static final String pathToDemo = "C:/demo";

    public void createQuizAttempt(QuizRequest quizRequest) {
        String pathToQuiz = pathToDemo + "/" + quizRequest.getCourseName();
        FileInputStream inputStream = null;
        File f = new File(pathToQuiz + "/" + quizRequest.getQuizId());
        if (f.exists() && f.isDirectory()) {
            try {
                inputStream = new FileInputStream(pathToQuiz + "/" + quizRequest.getQuizId() + "/Attempts.xlsx");
                Workbook workbook = WorkbookFactory.create(inputStream);
                Sheet sheet = workbook.getSheet("Attempts");
                int rowCount = sheet.getLastRowNum();
                Row row = sheet.createRow(++rowCount);

                Timestamp timestamp = new Timestamp(Long.parseLong(quizRequest.getTimeCreated()));
                row.createCell(0).setCellValue(quizRequest.getStudentIndex());
                row.createCell(1).setCellValue(quizRequest.getStudentLastname());
                row.createCell(2).setCellValue(quizRequest.getStudentFirstname());
                row.createCell(3).setCellValue(timestamp.toLocalDateTime().toLocalDate().toString());

                inputStream.close();

                FileOutputStream outputStream = new FileOutputStream(pathToQuiz + "/" + quizRequest.getQuizId() + "/Attempts.xlsx");
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Files.createDirectories(Paths.get(pathToQuiz + "/" + quizRequest.getQuizId()));
                Workbook workbook =  new XSSFWorkbook();
                Sheet attemptsSheet = workbook.createSheet("Attempts");
                Row header = attemptsSheet.createRow(0);
                header.createCell(0).setCellValue("Index");
                header.createCell(1).setCellValue("Last Name");
                header.createCell(2).setCellValue("First Name");
                header.createCell(3).setCellValue("Time of Attempt");

                Row row = attemptsSheet.createRow(1);

                Timestamp timestamp = new Timestamp(Long.parseLong(quizRequest.getTimeCreated()));
                row.createCell(0).setCellValue(quizRequest.getStudentIndex());
                row.createCell(1).setCellValue(quizRequest.getStudentLastname());
                row.createCell(2).setCellValue(quizRequest.getStudentFirstname());
                row.createCell(3).setCellValue(timestamp.toLocalDateTime().toLocalDate().toString());

                FileOutputStream outputStream = new FileOutputStream(pathToQuiz + "/" + quizRequest.getQuizId() + "/Attempts.xlsx");
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
