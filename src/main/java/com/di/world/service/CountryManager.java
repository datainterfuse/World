package com.di.world.service;

import com.di.world.entity.CountryInfoEntity;

public interface CountryManager {
	CountryInfoEntity getInfo(String code);
}
