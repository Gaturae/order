
package com.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.common.DaoTableConstant;
import com.order.mapper.DemoMapper;
import com.order.service.DemoService;
import com.order.vo.DemoEntity;

@Service
public class DemoServiceImpl implements DemoService {
	@Autowired
	private DemoMapper demoMapper;

	@Override
	public Long saveDemo(DemoEntity demoVo) {
		demoMapper.insertPrimaryKey(demoVo, DaoTableConstant.TABLE_DEMO);
		return demoVo.getId();
	}

	@Override
	public List<DemoEntity> getDemoVo(DemoEntity demoVo) {
		return demoMapper.getDemoVo(demoVo);

	}

}
