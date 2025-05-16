package Assessment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;

public class WordGetter {

    private static final String API_URL = "https://random-word-api.herokuapp.com/word?number=1";

    public static String getRandomWord() {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            connection.disconnect();

            // Parse JSON array like: ["word"]
            JSONArray jsonArray = new JSONArray(content.toString());
            return jsonArray.getString(0);
        } catch (Exception e) {
            System.out.println("Error fetching word from API: " + e.getMessage());
            return "default"; // fallback word
        }
    }
}
