package com.keng.service;

import com.keng.model.AntiterroristComputer;
import com.keng.model.AntiterroristMessage;
import java.util.List;
import java.util.Map;

/**
 * FileName: AntiterroristService
 * 反恐附件 service 接口
 * @author heyanzhu
 * @create 2018/10/9 15:22
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/

public interface AntiterroristService {
    List<AntiterroristComputer> findComputerForRand(int num);
    List<AntiterroristMessage> findAllMessage();
    Map<String,Object> formatMap();
}

