package br.com.abdiel.mobile.core.managers;


import br.com.abdiel.mobile.core.dataProvider.ConfigFileReader;
import br.com.abdiel.mobile.core.dataProvider.ConfigFileReaderJson;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;

	private static ConfigFileReaderJson configFileReaderJson;

	private FileReaderManager() {
	}

	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}

	public ConfigFileReader getConfigReader() {
		return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	}

	public ConfigFileReaderJson getConfigReaderJson() {
		return (configFileReaderJson == null) ? new ConfigFileReaderJson() : configFileReaderJson;
	}
}