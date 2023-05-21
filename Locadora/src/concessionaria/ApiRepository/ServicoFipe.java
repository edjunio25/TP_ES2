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
    public static MarcaApiResponse[] buscarFipe(String sufixo) throws Exception{

        String basePath = String.format("https://parallelum.com.br/fipe/api/v1/carros/%s",sufixo);

        URL url = new URL(basePath);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
        String jsonEmString = Util.converteJsonEmString(resposta);

        Gson gson = new Gson();
        MarcaApiResponse marcaApiResponse[] = gson.fromJson(jsonEmString, MarcaApiResponse[].class);
        return marcaApiResponse;
    }

    public static ModeloApiResponse buscarModelo(String numeroModelo) throws Exception{

        String basePath = String.format("https://parallelum.com.br/fipe/api/v1/carros/marcas/%s/modelos",numeroModelo);

        URL url = new URL(basePath);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
        String jsonEmString = Util.converteJsonEmString(resposta);

        Gson gson = new Gson();
        ModeloApiResponse modeloApiResponse = gson.fromJson(jsonEmString, ModeloApiResponse.class);
        return modeloApiResponse;
    }
}
