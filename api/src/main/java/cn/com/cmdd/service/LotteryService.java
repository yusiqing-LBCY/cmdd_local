package cn.com.cmdd.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.cmdd.dao.LotteryDao;
import cn.com.cmdd.domain.Lottery;

import java.util.List;

@Service
public class LotteryService {
	private final static Logger LOGGER = LoggerFactory.getLogger(LotteryService.class);
	
	@Autowired
	private LotteryDao lotteryDao;

	@Transactional
	public Integer addLottery(Lottery lottery){
		
		lotteryDao.addLottery(lottery);
		
		return lottery.getId();
	}
	
	@Transactional
	public Lottery getLotteryById(int id){
		
		return lotteryDao.getLotteryById(id);
	}
	
	@Transactional
	public List<Lottery> getLotteryListByShop_id(int lottery_id){
		
		return lotteryDao.getLotteryListByShop_id(lottery_id);
	}
	
	@Transactional
	public void updateLottery(Lottery lottery){
		
		lotteryDao.updateLottery(lottery);
	}

	
}