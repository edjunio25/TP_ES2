package concessionaria.ApiRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;

public class ServicoFipe {
    public static MarcaApiResponse[] buscarMontadoras() throws Exception {

        String basePath = "https://parallelum.com.br/fipe/api/v1/carros/marcas";

        String response = RequestBuilder(basePath);

        Gson gson = new Gson();
        MarcaApiResponse marcaApiResponse[] = gson.fromJson(response, MarcaApiResponse[].class);
        return marcaApiResponse;
    }

    public static ModeloApiResponse buscarModelo(String codigoMontadora) throws Exception {

        String basePath = String.format("https://parallelum.com.br/fipe/api/v1/carros/marcas/%s/modelos",
                codigoMontadora);

        String response = RequestBuilder(basePath);

        Gson gson = new Gson();
        ModeloApiResponse modeloApiResponse = gson.fromJson(response, ModeloApiResponse.class);
        return modeloApiResponse;
    }

    private static String RequestBuilder(String uri) throws Exception {
        URL url = new URL(uri);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
        String jsonEmString = Util.converteJsonEmString(resposta);
        return jsonEmString;
    }
}
