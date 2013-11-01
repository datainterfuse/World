package com.di.world.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.di.world.dao.ContinentDAO;
import com.di.world.entity.ContinentEntity;
import com.di.world.entity.ContinentInfoEntity;
import com.di.world.entity.ContinentListEntity;
import com.di.world.entity.CountryListEntity;
import com.di.world.utils.RestServices;
import com.di.world.utils.XmlUtilities;

@Repository
public class ContinentDAOImpl implements ContinentDAO {

	private RestServices rest;
	private String url = "http://www.oorsprong.org/websamples.countryinfo/CountryInfoService.wso/";
	
	public ContinentDAOImpl() {
		rest = new RestServices();
	}
	
	public ContinentListEntity getContinents() throws Exception {
		String result = rest.get(url + "ListOfCountryNamesGroupedByContinent");
		return new XmlUtilities().unMarshal(result, ContinentListEntity.class);
	}

	public CountryListEntity getCountriesFromContinent(String code) throws Exception {
		ContinentListEntity list = this.getContinents();
		List<CountryListEntity> countries = new ArrayList<CountryListEntity>();
		for (ContinentInfoEntity info : list.getContinents()) {
			if (!info.getContinent().getCode().equals(code)) continue;
			for (CountryListEntity cle : info.getCountries()) {
				countries.add(cle);
			}
			break;
		}
		return countries.get(0);
	}

	public ContinentEntity getContinent(String code) throws Exception {
		ContinentListEntity list = this.getContinents();
		for (ContinentInfoEntity info : list.getContinents()) {
			if (!info.getContinent().getCode().equals(code)) continue;
			return info.getContinent();
		}
		return null;
	}

}
