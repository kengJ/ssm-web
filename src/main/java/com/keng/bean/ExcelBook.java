package com.keng.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: ExcelBook
 * Excel 信息包装模型
 * @author heyanzhu
 * @create 2018/10/5 9:36
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public class ExcelBook {
    private List<Sheet> sheets;

    public List<Sheet> getSheets() {
        return sheets;
    }

    public void setSheets(List<Sheet> sheets) {
        this.sheets = sheets;
    }

    public Sheet createSheet(){
        return new Sheet();
    }

    public void addSheet(Sheet sheet){
        this.sheets.add(sheet);
    }

    public ExcelBook() {
        super();
        this.sheets = new ArrayList<>();
    }

    public static class Sheet{
        private String sheetName;

        private List<String[]> sheetData;

        public String getSheetName() {
            return sheetName;
        }

        public void setSheetName(String sheetName) {
            this.sheetName = sheetName;
        }

        public List<String[]> getSheetData() {
            return sheetData;
        }

        public void setSheetData(List<String[]> sheetData) {
            this.sheetData = sheetData;
        }

        public Sheet(String sheetName, List<String[]> sheetData) {
            super();
            this.sheetName = sheetName;
            this.sheetData = sheetData;
        }

        public Sheet() {
            super();
        }

        @Override
        public String toString() {
            return "Sheet [SheetName=" + sheetName + ", SheetData=" + sheetData + "]";
        }
    }
}
