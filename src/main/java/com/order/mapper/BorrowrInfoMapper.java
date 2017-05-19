package com.order.mapper;

import java.util.List;

import com.order.common.BaseDao;
import com.order.vo.BlacklistVO;
import com.order.vo.SplitRequest;

public interface BorrowrInfoMapper extends BaseDao {

	/**
	 * @methodDesc: 功能描述:(匹配贷款人信息表)
	 * @author: 左越
	 * @param: @param
	 *             splitRequest
	 * @param: @return
	 * @createTime:2017年5月11日 下午4:05:47
	 * @returnType:List<BlacklistVO>
	 */
	List<BlacklistVO> queryBlackList(SplitRequest splitRequest);

}