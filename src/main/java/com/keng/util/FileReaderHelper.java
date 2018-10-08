package com.keng.util;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * FileName: FileReaderHelper
 * 文件读取帮助类
 * @author heyanzhu
 * @create 2018/10/5 10:23
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public class FileReaderHelper {
    private InputStream inputStream;
    private InputStreamReader inputStreamReader = null;
    private BufferedReader br = null;
    private Boolean isGBK = false;
    private Boolean isReturnArray = false;

    public FileReaderHelper(InputStream inputStream, Boolean isGBK , Boolean isReturnArray) {
        super();
        this.inputStream = inputStream;
        this.isGBK = isGBK;
        this.isReturnArray = isReturnArray;
    }

    public FileReaderHelper(InputStream inputStream) {
        super();
        this.inputStream = inputStream;
    }

    private void createBuffer(){
        try {
            if(isGBK){
                inputStreamReader = new InputStreamReader(inputStream, "GBK");
            }else{
                inputStreamReader = new InputStreamReader(inputStream);
            }
            br = new BufferedReader(inputStreamReader);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void close(){
        try {
            br.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object formatData(){
        StringBuilder fileData = new StringBuilder();
        List<String> fileDataArray = new ArrayList<>();
        String line ;
        createBuffer();
        try {
            while((line = br.readLine())!= null){
                if(isReturnArray){
                    fileDataArray.add(line);
                }else{
                    fileData.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        close();
        return isReturnArray?fileDataArray: fileData.toString();
    }

    public String getDataToString(){
        return (String) formatData();
    }

    public List<String> getDataToArray(){
        return (List<String>) formatData();
    }
}
