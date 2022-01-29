package com.elfak.tzup.service;

import com.elfak.tzup.model.EnrollmentRequest;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class EnrollmentService {
    private static final String pathToDemo = "C:/demo";

    public void createEnrollment(EnrollmentRequest enrollmentRequest) {
        String pathToFile = pathToDemo + "/" + enrollmentRequest.getCourseName() + "/Students.xlsx";
            try {
                FileInputStream inputStream = new FileInputStream(pathToFile);
                Workbook workbook = WorkbookFactory.create(inputStream);

                Sheet sheet = workbook.getSheet("Students");

                int rowCount = sheet.getLastRowNum();
                Row row = sheet.createRow(++rowCount);
                row.createCell(0).setCellValue(enrollmentRequest.getStudentIndex());
                row.createCell(1).setCellValue(enrollmentRequest.getStudentLastname());
                row.createCell(2).setCellValue(enrollmentRequest.getStudentFirstname());
                row.createCell(3).setCellValue(enrollmentRequest.getStudentEmail());

                inputStream.close();

                FileOutputStream outputStream = new FileOutputStream(pathToFile);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (IOException | EncryptedDocumentException
                    | InvalidFormatException ex) {
                ex.printStackTrace();
            }
    }

    public void deleteEnrollment(EnrollmentRequest enrollmentRequest) {
        String pathToFile = pathToDemo + "/" + enrollmentRequest.getCourseName() + "/Students.xlsx";
        try {
            FileInputStream inputStream = new FileInputStream(pathToFile);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet("Students");
            int indexForDelete = 0;
            for(Row row : sheet) {
                if(!row.getCell(3).getStringCellValue().equals(enrollmentRequest.getStudentEmail())) {
                    indexForDelete++;
                }
            }

            removeRow(sheet, indexForDelete);

            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(pathToFile);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException | EncryptedDocumentException
                | InvalidFormatException ex) {
            ex.printStackTrace();
        }
    }

    public static void removeRow(Sheet sheet, int rowIndex) {
        int lastRowNum = sheet.getLastRowNum();
        if (rowIndex >= 0 && rowIndex < lastRowNum) {
            sheet.shiftRows(rowIndex + 1, lastRowNum, -1);
        }
        if (rowIndex == lastRowNum) {
            Row removingRow = sheet.getRow(rowIndex);
            if (removingRow != null) {
                sheet.removeRow(removingRow);
            }
        }
    }
}
