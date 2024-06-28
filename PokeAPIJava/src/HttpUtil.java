/*
    Http Class
    Contains methods to execute HTTP GET requests.
    Returns the response as a String to PokeAPI.java to parse.
 */
import com.google.gson.Gson;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class HttpUtil {
    // pokeInfo can be either a pokemon name or the pokemon #id, since the API uses whichever.
    // Api request:  https://pokeapi.co/api/v2/pokemon/{endpoint}/
    public static Pokemon getPokemonFromAPI(String pokeInfo){
        String urlComposing = "https://pokeapi.co/api/v2/pokemon/" + pokeInfo.toLowerCase(); // TODO: check if this last / is needed

        try {
            URL url = new URI(urlComposing).toURL();
            HttpsURLConnection connection = (HttpsURLConnection)  url.openConnection();
            connection.setRequestMethod("GET");

            System.out.println("Url that is being requeste:" + urlComposing);
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder jsonBuilder = new StringBuilder();

            String line;
            while((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            reader.close();
            connection.disconnect();

            return(jsonParser(jsonBuilder.toString()));

        } catch (Exception e){
            System.out.println("Oh noes, there is a problem: ");
            e.printStackTrace();
            return null;
        }
    }

    private static Pokemon jsonParser(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Pokemon.class);
    }
}
