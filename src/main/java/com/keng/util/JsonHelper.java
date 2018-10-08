package com.keng.util;

import com.alibaba.fastjson.JSONArray;
import com.keng.bean.ExcelBook;

import java.util.*;

/**
 * FileName: JsonHelper
 * Json 工具类
 * @author heyanzhu
 * @create 2018/10/5 14:49
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public class JsonHelper {
    public static String excelMapToString(List<String[]> datas, String sheetName){
        //设置默认表
        sheetName = "".equals(sheetName)?"sheet1":sheetName;

        ExcelBook book = new ExcelBook();
        ExcelBook.Sheet sheet = book.createSheet();
        sheet.setSheetName(sheetName);
        sheet.setSheetData(datas);
        book.addSheet(sheet);

        return mapToString(book);
    }

    public static String excelMapToString(Map<String,List<String[]>> datas){
        ExcelBook book = new ExcelBook();
        Set<String> keys = datas.keySet();
        for(String key : keys){
            ExcelBook.Sheet sheet = book.createSheet();
            sheet.setSheetName(key);
            sheet.setSheetData(datas.get(key));
            book.addSheet(sheet);
        }
        return mapToString(book);
    }

    private static String mapToString(ExcelBook book){
        List<ExcelBook.Sheet> sheets = book.getSheets();
        JSONArray json = new JSONArray();
        json.addAll(sheets);

        return json.toJSONString();
    }

    public static List<Map<String, Object>> stringToMap(String json){
        List<Map<String, Object>> datas = new ArrayList<>();
        List<ExcelBook.Sheet> jsonDatas = JSONArray.parseArray(json, ExcelBook.Sheet.class);

        for(ExcelBook.Sheet sheet : jsonDatas){
            Map<String, Object> line = new HashMap<>(2);
            line.put("sheet", sheet.getSheetName());
            line.put("data", sheet.getSheetData());
            datas.add(line);
        }
        return datas;
    }
}
