package com.di.world.utils;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;


public class XmlUtilities {
	
	public <T> T unMarshal(String content, Class<T> clasz) throws Exception {
	  JAXBContext jc = JAXBContext.newInstance( clasz );
	  Unmarshaller u = jc.createUnmarshaller();
	  return u.unmarshal(new StreamSource( new StringReader( content )), clasz).getValue();
	}

}
