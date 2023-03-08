package com.wsk.service.Impl;

import com.wsk.dao.GoodsOfOrderFormMapper;
import com.wsk.pojo.GoodsOfOrderForm;
import com.wsk.service.GoodsOfOrderFormService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 吴健军 on 2022/12/01.
 */
@Service
public class GoodsOfOrderFormServiceImpl implements GoodsOfOrderFormService {
    @Resource
    private GoodsOfOrderFormMapper goodsOfOrderFormMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodsOfOrderFormMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GoodsOfOrderForm record) {
        return goodsOfOrderFormMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsOfOrderForm record) {
        return goodsOfOrderFormMapper.insertSelective(record);
    }

    @Override
    public GoodsOfOrderForm selectByPrimaryKey(Integer id) {
        return goodsOfOrderFormMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsOfOrderForm record) {
        return goodsOfOrderFormMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsOfOrderForm record) {
        return goodsOfOrderFormMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<GoodsOfOrderForm> selectByOFid(int ofid) {
        return goodsOfOrderFormMapper.selectByOFid(ofid);
    }
}
