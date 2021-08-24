package top.lixiang007.taotao.mapper;

import top.lixiang007.taotao.pojo.TbUser;

import java.util.List;
import java.util.Map;

public interface TbUserMapper {

    List<TbUser> selectByKey(Map<String, Object> paramMap);

    int insert(TbUser user);

    List<TbUser> selectUserByNameOrPwd(Map<String, Object> paramMap);
}