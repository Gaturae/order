package com.order.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.common.EmptyUtil;
import com.order.common.ListTool;
import com.order.mapper.BorrowrInfoMapper;
import com.order.mapper.ContactsInfoMapper;
import com.order.mapper.DefriendInfoMapper;
import com.order.service.BlacklistService;
import com.order.vo.BlacklistResponse;
import com.order.vo.BlacklistVO;
import com.order.vo.HitResponse;
import com.order.vo.SplitRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * @classDesc: 功能描述:(黑名单-接口实现)
 * @author: 左越  
 * @createTime: 2017年5月11日 下午2:04:10  
 * @version: v1.0  
 * @copyright:善林(上海)金融信息服务有限公司
 */
@Slf4j
@Service
public class BlacklistServiceImpl implements BlacklistService {
	
	@Autowired
	private BorrowrInfoMapper borrowrInfoMapper;
	
	@Autowired
	private DefriendInfoMapper defriendInfoMapper;
	
	@Autowired
	private ContactsInfoMapper contactsInfoMapper;

	@Override
	public BlacklistResponse getBlacklist(List<SplitRequest> splitRequests) throws Exception {
		try {
			List<HitResponse> hitResponseList = new ArrayList<HitResponse>();
			for (SplitRequest splitRequest : splitRequests) {
				// 匹配到了返回一致，返回所有的，匹配不一致，返回不一致，然后返回hitNo,selectContent,machField,machingContent,machingResult
				List<BlacklistVO> vos = borrowrInfoMapper.queryBlackList(splitRequest);
				matchType(splitRequest, vos, hitResponseList);
			}
			BlacklistResponse blacklistResponse = new BlacklistResponse();
			blacklistResponse.setHitResponseList(hitResponseList);
			blacklistResponse.setCount(hitResponseList.size());
			return blacklistResponse;
		} catch (Exception e) {
			log.error("###getBlacklist()### ERROR:{}", e);
			throw new Exception(e);
		}
	}

	/**
	 * @methodDesc: 功能描述:(封装返回数据结果集)
	 * @author: 朱彬  
	 * @param: @param splitRequest		拆分请求数据
	 * @param: @param vos				数据库查询结果集
	 * @param: @param hitResponseList   命中结果集（不允许为null）
	 * @createTime:2017年5月16日 下午3:28:53
	 * @returnType:void
	 */
	public void matchType(SplitRequest splitRequest, List<BlacklistVO> vos, List<HitResponse> hitResponseList) {
		// 匹配类型 （1.身份证 2.手机号 3.固定电话 4.地址 5.单位名称）
		Integer matchType = splitRequest.getMatchType();
		if (!ListTool.isEmpty(vos)) {
			//遍历黑名单封装的集合  进行逐个匹配
			for (BlacklistVO blacklistVO : vos) {
				if (matchType == 1) {
					//匹配上之后  调用addHitResponse()方法中进行设置数据 
					addHitResponse(splitRequest, blacklistVO, hitResponseList, null);
				} else if (matchType == 2) {
					if (splitRequest.getSplitContent().equals(blacklistVO.getBorrowerPhoneNum())) {
						addHitResponse(splitRequest, blacklistVO, hitResponseList, null);
					}
					if (splitRequest.getSplitContent().equals(blacklistVO.getSpousePhoneNum())) {
						addHitResponse(splitRequest, blacklistVO, hitResponseList, null);
					}
					if (splitRequest.getSplitContent().equals(blacklistVO.getContactsPhone())) {
						addHitResponse(splitRequest, blacklistVO, hitResponseList, null);
					}
				} else if (matchType == 3) {
					if (splitRequest.getSplitContent().equals(blacklistVO.getHomePhone())) {
						//如果匹配一致  machingContent为null
						addHitResponse(splitRequest, blacklistVO, hitResponseList, null);
					} else {
						//如果匹配不一致    machingContent为不一致的结果
						addHitResponse(splitRequest, blacklistVO, hitResponseList, blacklistVO.getHomePhone());
					}
				} else if (matchType == 4) {
					if (splitRequest.getSplitContent().equals(blacklistVO.getHomeAddress())) {
						addHitResponse(splitRequest, blacklistVO, hitResponseList, null);
					}
					if (splitRequest.getSplitContent().equals(blacklistVO.getWorkAddress())) {
						addHitResponse(splitRequest, blacklistVO, hitResponseList, null);
					}
				} else if (matchType == 5) {
					addHitResponse(splitRequest, blacklistVO, hitResponseList, null);
				}
			}
		} else {
			//未命中
			addHitResponse(splitRequest, null, hitResponseList, null);
		}
	}
	
	/**
	 * @methodDesc: 功能描述:()
	 * @author: 朱彬  
	 * @param: splitRequest 	拆分请求
	 * @param: blacklistVO		黑名单数据库查询封装集合
	 * @param: hitResponseList	命中结果集（不允许为null）
	 * @param: machingContent   命中字段（相似时该字段不允许为空）
	 * @createTime:2017年5月16日 下午3:22:25
	 * @returnType:void
	 */
	public void addHitResponse(SplitRequest splitRequest, BlacklistVO blacklistVO, List<HitResponse> hitResponseList, String machingContent) {
		//黑名单封装返回数据-命中结果集
		HitResponse hitResponse = new HitResponse();
		//匹配成功  命中结果集 +1
		hitResponse.setHitNo(String.valueOf(hitResponseList.size() + 1));
		hitResponse.setSelectContent(splitRequest.getSplitContent());
		hitResponse.setMachField(splitRequest.getSplitField());
		if (!EmptyUtil.isBlank(blacklistVO)) {
			hitResponse.setMachingResult("一致");
			hitResponse.setMachingContent(splitRequest.getSplitContent());
			if (!EmptyUtil.isBlank(machingContent)) {
				hitResponse.setMachingContent(machingContent);
				hitResponse.setMachingResult("相似");
			}
			hitResponse.setBlackLabel(blacklistVO.getBlacklistTag());
			hitResponse.setBlackDate(blacklistVO.getConfirmAt());
			hitResponse.setBlackkDesc(blacklistVO.getDefriendDes());
			hitResponse.setProductName(blacklistVO.getLoanName());
			hitResponse.setIsInside(blacklistVO.getIsInterior());
			hitResponse.setSource(blacklistVO.getDefriendSource());
		} else {
			//blacklistVO为null  返回不一致
			hitResponse.setMachingResult("不一致");
		}
		hitResponseList.add(hitResponse);
	}
}
