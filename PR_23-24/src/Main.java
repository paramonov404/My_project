import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;

public class Main {
    static Gson  gson = new Gson();
    static HttpClient httpClient = HttpClient.newHttpClient();
    static String path = "D:/IJ проекты/PR_23-24/src/db.json";
    static String uriTask = "http://80.87.199.76:3000//tasks/";
    static String uriReports = "http://80.87.199.76:3000//reports";
    static ArrayList <Integer> taskIds = new ArrayList<>();
    static ArrayList<String> Lines = new ArrayList<>();
    static int id = 1;

    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .GET()
                        .uri(URI.create(uriTask + id))
                        .build();
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                if(gson.fromJson(response.body(), Task.class).getId() == id) {
                    toReport(toCalculate(gson.fromJson(response.body(), Task.class).getExpression()));
                    id++;
                }
            }
            catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            TimeUnit.SECONDS.sleep((long)(Math.random() + 1));
        }
    }

    public static void toReport(double result) throws IOException, InterruptedException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            while (line != null) {
                Lines.add(line);
                line = reader.readLine();
            }
            int count = 1;
            for (int i = 0; i < Lines.size(); i++) {
                if (Lines.get(i).contains("\"taskId\":" + count)) {
                    taskIds.add(count);
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!taskIds.contains(id)) {
            Report report = new Report(id, result);
            try {
                String body = gson.toJson(report);
                HttpRequest request = HttpRequest.newBuilder()
                        .POST(HttpRequest.BodyPublishers.ofString(body))
                        .uri(URI.create(uriReports))
                        .setHeader("Content-Type", "application/json")
                        .build();
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            }
            catch (IOException | InterruptedException  e) {
                e.printStackTrace();
            }

            try {
                FileWriter writer = new FileWriter(path);
                if (report.getTaskId() != 1) {
                    writer.write(",");
                }
                writer.write("\n" + gson.toJson(report)
                        .replace(",", ",\n ")
                        .replace("{", "{\n ")
                        .replace("}", "\n}"));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static double toCalculate(String expression) {
        expression = expression.replace(" ", "");
        Pattern pattern = Pattern.compile("([-+]*\\d+)([*/+-])([-+]*\\d+)");
        Matcher matcher = pattern.matcher(expression);
        double result = 0;
        while (matcher.find()) {
            if (matcher.group(2).contains("+")) {
                result = parseInt(matcher.group(1)) + parseInt(matcher.group(3));
            }
            else if (matcher.group(2).contains("-")) {
                result = parseInt(matcher.group(1)) - parseInt(matcher.group(3));
            }
            else if (matcher.group(2).contains("/")) {
                result = (double) parseInt(matcher.group(1)) / (double) parseInt(matcher.group(3));
            }
            else if (matcher.group(2).contains("*")) {
                result = parseInt(matcher.group(1)) * parseInt(matcher.group(3));
            }
        }
        return Math.ceil(result * 100) / 100;
    }
}

