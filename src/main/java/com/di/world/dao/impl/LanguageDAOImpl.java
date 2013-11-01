package com.di.world.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.di.world.dao.LanguageDAO;
import com.di.world.entity.CountryArrayEntity;
import com.di.world.entity.CountryEntity;
import com.di.world.entity.CountryInfoEntity;
import com.di.world.entity.CurrencyEntity;
import com.di.world.entity.CurrencyListEntity;
import com.di.world.entity.LanguageCountryListEntity;
import com.di.world.entity.LanguageEntity;
import com.di.world.entity.LanguageInfoEntity;
import com.di.world.entity.LanguageListEntity;
import com.di.world.utils.RestServices;
import com.di.world.utils.XmlUtilities;

@Repository
public class LanguageDAOImpl implements LanguageDAO {
	private RestServices rest;
	private String url = "http://www.oorsprong.org/websamples.countryinfo/CountryInfoService.wso/";
	
	public LanguageDAOImpl() {
		rest = new RestServices();
	}

	@Cacheable("languages")
	public LanguageCountryListEntity getLanguages() throws Exception {
		LanguageCountryListEntity entity = new LanguageCountryListEntity();
		Map<String, List<CountryEntity>> values = new HashMap<String, List<CountryEntity>>();
		String result = rest.get(url + "FullCountryInfoAllCountries");
		CountryArrayEntity country =  new XmlUtilities().unMarshal(result, CountryArrayEntity.class);
		for (CountryInfoEntity cie : country.getCountries()) {
			for (LanguageEntity le : cie.getLanguages().getLanguages()) {
				if (values.containsKey(le.getName())) {
					List<CountryEntity> list = values.get(le.getName());
					CountryEntity ce = new CountryEntity();
					ce.setCode(cie.getName());
					ce.setName(cie.getName());
					list.add(ce);
				} else {
					List<CountryEntity> first = new ArrayList<CountryEntity>();
					CountryEntity ce = new CountryEntity();
					ce.setCode(cie.getName());
					ce.setName(cie.getName());
					first.add(ce);
					values.put(le.getName(), first);
				}
			}
		}
		for (String lang : values.keySet()) {
			LanguageInfoEntity lie = new LanguageInfoEntity();
			LanguageEntity lEntity = new LanguageEntity();
			lEntity.setName(lang);
			lie.setLanguage(lEntity);
			lie.setCountries(values.get(lang));
			entity.getLanguages().add(lie);
			
		}
		
		return entity;
	}

}
