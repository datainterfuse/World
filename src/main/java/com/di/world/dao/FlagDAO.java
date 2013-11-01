package com.di.world.dao;

import java.util.List;

import com.di.world.entity.FlagInfoEntity;

public interface FlagDAO {
	
	public List<FlagInfoEntity> getFlags() throws Exception;

}
