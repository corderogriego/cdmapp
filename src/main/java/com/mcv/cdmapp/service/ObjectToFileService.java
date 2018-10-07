package com.mcv.cdmapp.service;

import java.io.IOException;

public interface ObjectToFileService {

	/**
     * Almacena una cadena en un archivo
     * @param result cadena que se va a guardar en un archivo
     * @param master nombre con el que se va a guardar el archivo
     */
	public void saveToFile(String result, String master) throws IOException;
}
