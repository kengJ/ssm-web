package com.keng.util;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * FileName: IdCardHelper
 * 身份证信息帮助工具类
 * @author heyanzhu
 * @create 2018/10/5 9:47
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public class IdCardHelper {
    /**每位加权因子*/
    private int[] power = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };

    /**第18位校检码*/
    private String[] verifyCode = { "1", "0", "X", "9", "8", "7", "6", "5","4", "3", "2" };

    private Map<String, String> cityCodeMap = new HashMap<>();

    public IdCardHelper() {
        super();
        InputStream inputStream = null;
        InputStreamReader inputReader = null;
        BufferedReader buffer = null;
        URL fileUrl = Thread.currentThread().getContextClassLoader().getResource("City.txt");
        if(fileUrl!=null){
            String fileName = fileUrl.getFile();
            try {
                inputStream = new FileInputStream(new File(fileName));
                inputReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                buffer = new BufferedReader(inputReader);
                String line ;
                while((line = buffer.readLine()) != null) {
                    String[] textData = line.split(";");
                    cityCodeMap.put(textData[0].substring(0, 2), textData[1]);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("文件找不到");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IO流异常");
            } finally {
                try {
                    if (buffer != null){
                        buffer.close();
                    }
                    if (inputReader != null) {
                        inputReader.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean checkBirthdate(String birthday) {
        try {
            new SimpleDateFormat("yyMMdd").parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean check(String cardNo) {
        String cityName = cityCodeMap.get(cardNo.substring(0, 2));
        if(cityName == null) {
            //判断省级编号是否能匹配
            return false;
        }
        boolean dateCheck = checkBirthdate(cardNo.substring(6,14));
        if(!dateCheck){
            //判断日期是否正确
            return false;
        }
        //省份证校验码
        String checkNo = cardNo.substring(17, 18);
        String[] idCardNo = cardNo.split("");
        int sum = 0;
        //第17位号码下标
        int idCard17Index = idCardNo.length-2;
        for(int i = 0 ; i <= idCard17Index ; i++) {
            int no = Integer.parseInt(idCardNo[i]+"");
            sum += no * power[i];
        }
        return verifyCode[sum % 11].equals(checkNo);
    }

    public Map<String,Object> findMessage(String cardNo){
        Map<String,Object> result = new HashMap<>(4);
        if(check(cardNo)){
            //省份
            String cityName = cityCodeMap.get(cardNo.substring(0, 2));
            //出生日期
            String brithday = "";
            try {
                brithday = new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("yyyyMMdd").parse(cardNo.substring(6,14)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //性别
            String sex = (Integer.parseInt(cardNo.substring(14,15))%2==0)?"女":"男";
            result.put("msg", true);
            result.put("city", cityName);
            result.put("date", brithday);
            result.put("sex", sex);
        }else{
            result.put("msg", false);
        }
        return result;
    }
}
