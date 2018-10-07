package com.mcv.cdmapp.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

@Component
public class ObjectToFileServiceImp implements ObjectToFileService{

	public static String FILEPATH = "/home/make";	
	
	@Override
	public void saveToFile(String result, String master) throws IOException {
		
		Path path = Paths.get(FILEPATH + master + ".txt");
		 
		try (BufferedWriter writer = Files.newBufferedWriter(path))
		{
		    writer.write(result);
		}		
	}
}
