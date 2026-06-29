package inicial;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FinanceiraAPI {
//Estrutura da API
    public static double pegarPrecoAtual(String codigoAtivo) {
        String tokenTeste = "9p7bH7b6P4X9K8e2mN4qQ1";
        String url = "https://brapi.dev/api/quote/" + codigoAtivo + "?token=" + tokenTeste;

        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest requisicao = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
            String jsonRaw = resposta.body();

            JsonObject objRaiz = JsonParser.parseString(jsonRaw).getAsJsonObject();

            JsonArray resultados = objRaiz.getAsJsonArray("results");

            if (resultados != null && resultados.size() > 0) {

                JsonObject dadosAtivo = resultados.get(0).getAsJsonObject();

                return dadosAtivo.get("regularMarketPrice").getAsDouble();
            }

            System.out.println("Ativo nao encontrado na API.");
            return 0.0;

        } catch (Exception e) {
            System.out.println("Erro ao consultar a API com o arquivo Gson: " + e.getMessage());
            return 0.0;
        }
    }
}