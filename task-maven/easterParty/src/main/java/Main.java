import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Parent> parents = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        List<String> lines = null;

        try (InputStream stream = Main.class.getResourceAsStream("attenders.json")) {
            lines = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))
                    .lines().collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (String line : lines) {
            builder.append(line);
        }

        String jsonData = builder.toString();
        JSONArray JSONparents = new JSONArray(jsonData);

        for (int i = 0; i < JSONparents.length(); ++i) {
            List<Child> children = new ArrayList<>();

            JSONObject parent = JSONparents.getJSONObject(i);
            JSONArray JSONchildren = parent.getJSONArray("children");

            for (int j = 0; j < JSONchildren.length(); ++j) {
                children.add(new Child(JSONchildren.getJSONObject(j).getString("name")));
            }

            parents.add(new Parent(children, new EasterBunny("Peter")));
        }

        System.out.println("Easter party is on!");

        try {
            for (Parent parent : parents) {
                parent.celebrateEaster();
            }

            System.out.println("Easter party is over!");
        } catch (EasterFailException e) {
            System.out.println(e.getMessage());
        }
    }
}
