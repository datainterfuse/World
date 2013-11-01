package com.di.world.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.di.world.dao.FlagDAO;
import com.di.world.entity.FlagInfoEntity;
import com.di.world.service.FlagManager;

@Service
public class FlagManagerImpl implements FlagManager {
	@Autowired
	FlagDAO dao;

	public List<FlagInfoEntity> getFlags() {
		try {
			return dao.getFlags();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
