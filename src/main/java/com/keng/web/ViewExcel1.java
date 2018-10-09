package com.keng.web;

import org.apache.poi.hssf.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * FileName: ViewExcel
 * 导出视图
 * @author heyanzhu
 * @create 2018/10/5 14:59
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public class ViewExcel1 extends AbstractExcelView {
    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取日期
        Date now = new Date();
        SimpleDateFormat data = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = data.format(now) + ".xls";
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/ms-excel");
        response.setHeader("Content-Disposition", "inline; filename=" + new String(fileName.getBytes(), "iso8859-1"));
        OutputStream outputStream = response.getOutputStream();
        List<Map<String, Object>> excelData = (List<Map<String, Object>>) model.get("data");
        for (Map<String, Object> sheet : excelData) {
            createSheet(workbook, sheet);
        }
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

    public void getList(HSSFRow row, String[] list){
        int i = 0;
        for(String data : list){
            row.createCell(i).setCellValue(data);
            i++;
        }
    }

    @SuppressWarnings("unchecked" )
    public void createSheet(HSSFWorkbook workbook,Map<String, Object> model){
        // 新建工作表
        HSSFSheet sheet = workbook.createSheet((String) model.get("sheet"));
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("mm/dd/yyyy"));
        int rowNumber = 0;
        List<String[]> data = (List<String[]>) model.get("data");
        for (String[] list : data) {
            HSSFRow row = sheet.createRow(rowNumber++);
            getList(row,list);
        }
    }
}
