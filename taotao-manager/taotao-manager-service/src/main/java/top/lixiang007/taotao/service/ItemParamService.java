package top.lixiang007.taotao.service;


import top.lixiang007.taotao.common.pojo.EasyUIDataGridResult;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
/**
 * @Author Xiang Li
 * @Date 2021/8/26 上午10:51
 * @Since version-1.0
 * @青软实训 规格参数
 */

public interface ItemParamService {
	EasyUIDataGridResult getItemParamList(int page, int rows);
	TaotaoResult getItemParamByCid(Long cid);
	TaotaoResult insertItemParam(Long cid, String paramData);
}
