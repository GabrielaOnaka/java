import java.io.File;

import jxl.Cell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;

import jxl.write.*;
import jxl.write.Number;

import jxl.read.biff.BiffException;
import java.io.IOException;

public class LerEscreverExcel {

    //#

    private final String[] as1 = new String[8];
    private final String[] as2 = new String[8];
    private final String[] as3 = new String[8];
    private final String[] as4 = new String[8];
    private final String[] as5 = new String[8];
    private String enderecoExcel = "H://FPOO/ProjetoIntegradorGabriela.xls";

    public LerEscreverExcel(String excel){
        this.enderecoExcel = excel;
    }

    public String[] getAs1(){
        System.out.println(this.as1);
        return this.as1;
    }

    public String[] getAs2(){
        return this.as2;
    }

    public String[] getAs3(){
        return this.as3;
    }

    public String[] getAs4(){
        return this.as4;
    }

    public String[] getAs5(){
        return this.as5;
    }

    public void lerExcel() throws IOException, BiffException {

        Workbook workbook = Workbook.getWorkbook(new File(enderecoExcel));

        Sheet sheet = workbook.getSheet(0);

        int linhas = sheet.getRows();

        for (int i = 0; i < linhas; i++) {

            Cell a1 = sheet.getCell(0, i);

            Cell a2 = sheet.getCell(1, i);

            Cell a3 = sheet.getCell(2, i);

            Cell a4 = sheet.getCell(3, i);

            Cell a5 = sheet.getCell(4, i);

            this.as1[i] = a1.getContents();

            this.as2[i] = a2.getContents();

            this.as3[i] = a3.getContents();

            this.as4[i] = a4.getContents();

            this.as5[i] = a5.getContents();

        }

        workbook.close();

    }



    public void escreverExcel() {

        //1. Create an Excel file
        WritableWorkbook arquivoExcel = null;
        try {

            arquivoExcel = Workbook.createWorkbook(new File(enderecoExcel));

            // create an Excel sheet
            WritableSheet planilha = arquivoExcel.createSheet("Nova Planilha", 0);

            // add something into the Excel sheet
            Label label = new Label(5, 0, "Coluna1");
            planilha.addCell(label);

            Number number = new Number(5, 1, 1);
            planilha.addCell(number);

            number = new Number(5, 2, 2);
            planilha.addCell(number);

            label = new Label(6, 0, "Coluna2");
            planilha.addCell(label);

            label = new Label(6, 1, "Texto1");
            planilha.addCell(label);

            label = new Label(6, 2, "Texto2");
            planilha.addCell(label);

            arquivoExcel.write();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } finally {

            if (arquivoExcel != null) {
                try {
                    arquivoExcel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
