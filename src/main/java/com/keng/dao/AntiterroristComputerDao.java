package com.keng.dao;

import java.util.List;
import com.keng.model.AntiterroristComputer;
/**
 * FileName: AntiterroristComputerDao
 * 反恐附件dao
 * @author heyanzhu
 * @create 2018/10/9 14:02
 * @since 1.0.0
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/
public interface AntiterroristComputerDao {
    /**
     * 随机获取电脑信息
     * @param num 随机获取的数据量
     * @return 电脑列表
     */
    List<AntiterroristComputer> findComputerForRand(int num);
}
