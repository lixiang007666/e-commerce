package top.lixiang007.taotao.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.lixiang007.taotao.pojo.TbItem;
import top.lixiang007.taotao.pojo.TbItemExample;

public interface TbItemMapper {
    int countByExample(TbItemExample example);

    int deleteByExample(TbItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    List<TbItem> selectByExample(TbItemExample example);

    TbItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbItem record, @Param("example") TbItemExample example);

    int updateByExample(@Param("record") TbItem record, @Param("example") TbItemExample example);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);

  /**
   * @Author Xiang Li
   * @Date 2021/8/30 上午11:17
   * @Since version-1.0
   * @青软实训 后台查询？
   */


    List<TbItem> getItemList();


}