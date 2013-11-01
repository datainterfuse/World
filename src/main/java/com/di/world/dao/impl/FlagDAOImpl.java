package com.di.world.dao.impl;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.di.world.dao.FlagDAO;
import com.di.world.entity.CountryArrayEntity;
import com.di.world.entity.CountryInfoEntity;
import com.di.world.entity.FlagInfoEntity;
import com.di.world.utils.RestServices;
import com.di.world.utils.XmlUtilities;

@Repository
public class FlagDAOImpl implements FlagDAO {
	private RestServices rest;
	private String url = "http://www.oorsprong.org/websamples.countryinfo/CountryInfoService.wso/";
	
	public FlagDAOImpl() {
		rest = new RestServices();
	}

	@Cacheable("flags")
	public List<FlagInfoEntity> getFlags() throws Exception {
		List<FlagInfoEntity> list = new ArrayList<FlagInfoEntity>();
		String result = rest.get(url + "FullCountryInfoAllCountries");
		CountryArrayEntity country =  new XmlUtilities().unMarshal(result, CountryArrayEntity.class);
		for (CountryInfoEntity cie : country.getCountries()) {
			FlagInfoEntity fie = new FlagInfoEntity();
			fie.setName(cie.getName());
			fie.setCode(cie.getCode());
			fie.setLink(cie.getFlagLink());
			list.add(fie);
		}
		Collections.sort(list);
		return list;
	}

}
