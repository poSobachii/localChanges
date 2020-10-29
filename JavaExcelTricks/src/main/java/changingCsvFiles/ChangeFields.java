package changingCsvFiles;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ChangeFields {

    static List<ObjecWrapper> objecWrapperList = new ArrayList<>();
    static List<LanguagePropWrapper> langPropertiesList = new ArrayList<>();
    static String firstline;

    public static void main(String[] args) {
//        changingCsvFiles();
            readPropertiesToExcel();
    }

    static void changingCsvFiles(){
        readFile();
        uploadFile();
        renameFields();
        saveFile();
    }

    static void  readPropertiesToExcel(){
        readPropertiesFile();
        createLangPropExcelFile();

    }

    static void readPropertiesFile(){
        String propertiesFile = "C:\\Users\\agr\\Desktop\\messages_en.properties";
        try (BufferedReader br = new BufferedReader(new FileReader(propertiesFile))) {
            String readLine = "";
            while ((readLine = br.readLine()) != null){
                if(!readLine.isEmpty()) {
                    if(!(readLine.charAt(0) == '#')) {
                        String[] values = readLine.split("=");
                        langPropertiesList.add(new LanguagePropWrapper(values[0].trim(), values[1].trim()));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void createLangPropExcelFile(){

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("En_vocabulary");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Unique ID");
        cell = row.createCell(1);
        cell.setCellValue("Value");
        System.out.println(langPropertiesList.size());
        for (int i = 0; i < langPropertiesList.size() ; i++) {
            row = sheet.createRow(i + 1);
            cell = row.createCell(0);
            cell.setCellValue(langPropertiesList.get(i).getIndentificator());
            cell = row.createCell(1);
            cell.setCellValue(langPropertiesList.get(i).getValue());

        }

        File currDir = new File("C:\\Users\\agr\\Desktop\\.");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "english_properties.xlsx";

        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(fileLocation);
            workbook.write(outputStream);
            workbook.close();
        } catch ( IOException e) {
            e.printStackTrace();
        }

    }


    static void uploadFile(){
        String csvFile = "/Users/aleksandrs.grisanovs/Desktop/accountid_externalid_scastatus.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int index = 1;
            firstline = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(cvsSplitBy);
                objecWrapperList.add(new ObjecWrapper(index, fields[0], fields[1], fields[2]));
                index++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void renameFields(){
        for (ObjecWrapper obj : objecWrapperList) {
            String externald = obj.getExternalId();
            externald = externald.substring(0, 8) + "-"
                    +externald.substring(8, 12) + "-"
                    +externald.substring(12, 16) + "-"
                    +externald.substring(16, 20) + "-"
                    +externald.substring(20);
            obj.setExternalId(externald);
        }
    }

    static void saveFile(){
        try (PrintWriter writer = new PrintWriter("/Users/aleksandrs.grisanovs/Desktop/accountid_externalid_scastatus_separated.csv", "UTF-8");) {
            writer.println(firstline);
            for (ObjecWrapper obj: objecWrapperList) {
                writer.println(obj.getAccountId() + "," + obj.getExternalId() + "," + obj.getState());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    static void readFile(){
        String jsonFile = "/Users/aleksandrs.grisanovs/Desktop/Migration/import_customers_acct_1EmILKCmHoRdeuFT_all.json";
        separateFile(jsonFile);
    }

    static void separateFile(String filePath){
        String line = "";
        String previousLine = "";
        int x = 1;
        boolean save = false;
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            while ((line = br.readLine()) != null) {

                if (!line.contains("}") || line.contains("},")) {
                    stringBuffer.append("\n");
                }
                if (x%300000 == 0){
                    save = true;
                }
                if (save) {
                    if ((previousLine.equals("    }")) && line.equals("  },")) {
                        stringBuffer.append("} \n }");
                        saveJson(stringBuffer.toString(), x);
                        stringBuffer.delete(0, stringBuffer.length());
                        stringBuffer.append("{");
                        save = false;
                        continue;
                    }
                }
                x++;
                stringBuffer.append(line);
                previousLine = line;


            }
            System.out.println("result= " + stringBuffer.length() );
            System.out.println("x= " + x);
            saveJson(stringBuffer.toString(), x);
        } catch (IOException e ){
            e.printStackTrace();
        }
    }
    static void saveJson(String toSave, int number){
        try (PrintWriter writer = new PrintWriter("/Users/aleksandrs.grisanovs/Desktop/Migration/part" + number + ".json", "UTF-8");) {
            writer.println(toSave);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
