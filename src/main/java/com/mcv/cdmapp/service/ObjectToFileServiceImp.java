package com.mcv.cdmapp.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ObjectToFileServiceImp implements ObjectToFileService{

	public static String FILEPATH = "/home/make/";
	
	
	
	private static String getTime() {
		
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		String time = cal.get(Calendar.HOUR_OF_DAY)+ "_"
				+ cal.get(Calendar.MINUTE)+ "_"
				+ cal.get(Calendar.SECOND);
		
		return time;
	}

	@Override
	public void saveToFile(String result, String master) throws IOException {
		
		Path path = Paths.get(FILEPATH + master + ".txt");
		 
		try (BufferedWriter writer = Files.newBufferedWriter(path))
		{
		    writer.write(result);
		}		
	}
}
