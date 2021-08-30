package top.lixiang007.taotao.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.lixiang007.taotao.pojo.TbItemCat;
import top.lixiang007.taotao.pojo.TbItemCatExample;

public interface TbItemCatMapper {
    int countByExample(TbItemCatExample example);

    int deleteByExample(TbItemCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbItemCat record);

    int insertSelective(TbItemCat record);

    List<TbItemCat> selectByExample(TbItemCatExample example);

    TbItemCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbItemCat record, @Param("example") TbItemCatExample example);

    int updateByExample(@Param("record") TbItemCat record, @Param("example") TbItemCatExample example);

    int updateByPrimaryKeySelective(TbItemCat record);

    int updateByPrimaryKey(TbItemCat record);
    /**
     * @Author Xiang Li
     * @Date 2021/8/30 上午11:19
     * @Since version-1.0
     * @青软实训 写后台的时候
     */

    List<TbItemCat> getItemCatByParentId(long parentId);

    String getItemCatNameById(long id);
}