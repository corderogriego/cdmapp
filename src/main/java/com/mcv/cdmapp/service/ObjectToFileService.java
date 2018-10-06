package com.mcv.cdmapp.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ObjectToFileService {

	public void saveToFile(String result, String master) throws IOException;
}
