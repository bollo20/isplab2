package laborator8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ScriereFisier {

    public static void main(String[] args) {
        String outputFile = "output8.xlsx";
        scrieFisierExcel(outputFile);
    }

    public static void scrieFisierExcel(String numeFisier) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Rezultate");

        // Structura de date
        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{"Prenume", "Nume", "Nota1", "Nota2", "Nota3", "Nota4", "MAX", "MEDIE"});
        data.put("2", new Object[]{"Amit", "Shukla", 9, 8, 7, 5});
        data.put("3", new Object[]{"Lokesh", "Gupta", 8, 9, 6, 7});
        data.put("4", new Object[]{"John", "Adwards", 8, 8, 7, 6});
        data.put("5", new Object[]{"Brian", "Schultz", 7, 6, 8, 9});

        // Stiluri
        CellStyle stilHeader = workbook.createCellStyle();
        Font fontBold = workbook.createFont();
        fontBold.setBold(true);
        stilHeader.setFont(fontBold);
        stilHeader.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        stilHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle stilGalben = workbook.createCellStyle();
        stilGalben.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        stilGalben.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        int rowNum = 0;
        for (String key : data.keySet()) {
            Row row = sheet.createRow(rowNum++);
            Object[] objArr = data.get(key);
            int cellNum = 0;

            for (Object obj : objArr) {
                Cell cell = row.createCell(cellNum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);

                // Stil pentru header
                if (key.equals("1")) {
                    cell.setCellStyle(stilHeader);
                }
            }

            // Formule doar pentru rândurile cu date (nu header)
            if (!key.equals("1")) {
                int rowIdx = Integer.parseInt(key);
                Cell maxCell = row.createCell(6); // G
                Cell avgCell = row.createCell(7); // H

                // Formula: MAX(Di:Gi) și AVERAGE(Di:Gi)
                String formulaMax = String.format("MAX(D%d:G%d)", rowIdx, rowIdx);
                String formulaAvg = String.format("AVERAGE(D%d:G%d)", rowIdx, rowIdx);

                maxCell.setCellFormula(formulaMax);
                avgCell.setCellFormula(formulaAvg);

                maxCell.setCellStyle(stilGalben);
                avgCell.setCellStyle(stilGalben);
            }
        }

        // Auto-size la coloane
        for (int i = 0; i < 8; i++) {
            sheet.autoSizeColumn(i);
        }

        // Scriere în fișier
        try (FileOutputStream out = new FileOutputStream(numeFisier)) {
            workbook.write(out);
            workbook.close();
            System.out.println("Fisierul a fost generat: " + numeFisier);
        } catch (IOException e) {
            System.err.println("Eroare la scrierea fișierului: " + e.getMessage());
        }
    }
}

