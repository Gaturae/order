package com.order.util;

import java.util.ArrayList;
import java.util.List;

import com.order.common.EmptyUtil;
import com.order.vo.BlacklistRequest;
import com.order.vo.ContactRequest;
import com.order.vo.SplitRequest;

/**
 * 
 * @classDesc: 功能描述:(拆分请求工具类)
 * @author: 王浩
 * @createTime: 2017年5月15日 下午6:34:30
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
public class SplitRequestUtil {

	public static List<SplitRequest> splitRequest(BlacklistRequest param) {

//		String identification = param.getIdentification();
//		if (EmptyUtil.isBlank(identification)) {
//			return null;
//		}
		List<SplitRequest> splitRequests = new ArrayList<SplitRequest>();

		// 拆分借款人身份证号
		String borrowerIdNum = param.getBorrowerIdNum();
		if (!EmptyUtil.isBlank(borrowerIdNum) && RegexUtils.checkIdCard(borrowerIdNum)) {
			SplitRequest split1 = new SplitRequest();
//			split1.setIdentification(identification);
			split1.setMatchType(1);
			split1.setSplitContent(borrowerIdNum);
			split1.setSplitField("借款人身份证号");
			splitRequests.add(split1);
		}

		// 拆分借款人手机号
		String borrowerPhoneNum = param.getBorrowerPhoneNum();
		if (!EmptyUtil.isBlank(borrowerPhoneNum) && RegexUtils.checkMobile(borrowerPhoneNum)) {
			SplitRequest split2 = new SplitRequest();
//			split2.setIdentification(identification);
			split2.setMatchType(2);
			split2.setSplitContent(borrowerPhoneNum);
			split2.setSplitField("借款人手机号");
			splitRequests.add(split2);
		}

		// 拆分配偶手机号
		String spousePhoneNum = param.getSpousePhoneNum();
		if (!EmptyUtil.isBlank(spousePhoneNum) && RegexUtils.checkMobile(spousePhoneNum)) {
			SplitRequest split3 = new SplitRequest();
//			split3.setIdentification(identification);
			split3.setMatchType(2);
			split3.setSplitContent(spousePhoneNum);
			split3.setSplitField("配偶手机号");
			splitRequests.add(split3);
		}

		// 拆分家庭电话
		String homePhone = param.getHomePhone();
		if (!EmptyUtil.isBlank(homePhone) && RegexUtils.checkPhone(homePhone)) {
			SplitRequest split4 = new SplitRequest();
//			split4.setIdentification(identification);
			split4.setMatchType(3);
			split4.setSplitContent(homePhone);
			split4.setSplitField("家庭电话");
			splitRequests.add(split4);
		}

		// 拆分家庭住址
		String homeAddress = param.getHomeAddress();
		if (!EmptyUtil.isBlank(homeAddress)) {
			SplitRequest split5 = new SplitRequest();
//			split5.setIdentification(identification);
			split5.setMatchType(4);// 地址
			split5.setSplitContent(homeAddress);
			split5.setSplitField("家庭住址");
			splitRequests.add(split5);
		}

		// 拆分单位电话
		String companyPhone = param.getCompanyPhone();
		if (!EmptyUtil.isBlank(companyPhone) && RegexUtils.checkPhone(companyPhone)) {
			SplitRequest split6 = new SplitRequest();
//			split6.setIdentification(identification);
			split6.setMatchType(3);
			split6.setSplitContent(companyPhone);
			split6.setSplitField("单位电话");
			splitRequests.add(split6);
		}

		// 拆分工作单位地址
		String companyAddress = param.getCompanyAddress();
		if (!EmptyUtil.isBlank(companyAddress)) {
			SplitRequest split7 = new SplitRequest();
//			split7.setIdentification(identification);
			split7.setMatchType(4);// 地址
			split7.setSplitContent(companyAddress);
			split7.setSplitField("工作单位地址");
			splitRequests.add(split7);
		}

		// 拆分单位名称
		String companyName = param.getCompanyName();
		if (!EmptyUtil.isBlank(companyName)) {
			SplitRequest split8 = new SplitRequest();
//			split8.setIdentification(identification);
			split8.setMatchType(5);// 单位名称
			split8.setSplitContent(companyName);
			split8.setSplitField("单位名称");
			splitRequests.add(split8);
		}

		// 联系人请求封装
		List<ContactRequest> contactRequests = param.getContactRequests();
		if (!EmptyUtil.isBlank(contactRequests)) {
			for (ContactRequest contactRequest : contactRequests) {
				String contactsPhone = contactRequest.getContactsPhone();
				if (!EmptyUtil.isBlank(contactsPhone) && RegexUtils.checkMobile(contactsPhone)) {
					SplitRequest split = new SplitRequest();
//					split.setIdentification(identification);
					split.setMatchType(2);// 手机号
					split.setSplitContent(contactsPhone);
					split.setSplitField("联系人" + contactRequest.getContactsName());
					splitRequests.add(split);
				}
			}
		}
		return splitRequests;
	}
}
