package top.lixiang007;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.lixiang007.taotao.mapper.TbItemMapper;
import top.lixiang007.taotao.pojo.TbItem;

import java.util.List;

/**
 * @Author Xiang Li
 * @Date 2021/8/24 下午12:25
 * @Since version-1.0
 * @青软实训
 */

public class TestPageHelper115 {

    @Test
    public void testPageHelper115() throws Exception {
//        //1、获得mapper代理对象
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
//        TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
//        //2、设置分页
//        PageHelper.startPage(1, 30);
//        //3、执行查询
//        TbItemExample example = new TbItemExample();
//        List<TbItem> list = itemMapper.selectByExample(example);
//        //4、取分页后结果
//        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
//        long total = pageInfo.getTotal();
//        System.out.println("total:" + total);
//        int pages = pageInfo.getPages();
//        System.out.println("pages:" + pages);
//        int pageSize = pageInfo.getPageSize();
//        System.out.println("pageSize:" + pageSize);

    }

}
