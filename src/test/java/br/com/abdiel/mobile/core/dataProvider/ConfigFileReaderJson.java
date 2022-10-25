package br.com.abdiel.mobile.core.dataProvider;

import br.com.abdiel.mobile.core.actions.Log;
import br.com.abdiel.mobile.core.managers.FileReaderManager;
import br.com.abdiel.mobile.core.models.DadaMass;
import com.google.gson.Gson;

import java.io.*;

public class ConfigFileReaderJson {

    private static Gson gson;
    private final String arquivoJson = FileReaderManager.getInstance().getConfigReader().getInfo("infos.json");
    private DadaMass dadaMass = null;

    public ConfigFileReaderJson() {
    }

    public DadaMass getJson() {
        try {
            File filePath = new File(arquivoJson);
            Reader reader = new FileReader(filePath);
            dadaMass = getGson().fromJson(reader, DadaMass.class);
        } catch (FileNotFoundException fnfe) {
            Log.setLog("ERROR", fnfe.getMessage());
        }
        return dadaMass;
    }

    public void readeJson(DadaMass dadaMass) {
        if (gson != null) {
            String json = gson.toJson(dadaMass);
            try {
                FileWriter writer = new FileWriter(arquivoJson);
                writer.write(json);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else
            Log.setLog("WARNING", "Classe GSON não esta inicializada!!!");
    }

    private static Gson getGson() {
        if (gson == null)
            gson = new Gson();
        return gson;
    }
}
