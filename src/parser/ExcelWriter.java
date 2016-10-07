package parser;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ExcelWriter {

    public static void writeExcel() throws IOException, WriteException {
        File file = new File("e:/test.xls");
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(file);
        WritableSheet writableSheet = writableWorkbook.createSheet("mySheet", 0);
        Label label = new Label(0,0,"data 1");
        writableSheet.addCell(label);
        writableWorkbook.write();
        writableWorkbook.close();
    }

    public static void writeNamesToExcel(List<String> names) throws IOException, WriteException {
        File file = new File("e:/names.xls");
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(file);
        WritableSheet writableSheet = writableWorkbook.createSheet("mySheet", 0);

        int i = 0;
        for (String name : names) {
            Label label = new Label(0, i++, name);
            writableSheet.addCell(label);
        }

        writableWorkbook.write();
        writableWorkbook.close();
    }
}
