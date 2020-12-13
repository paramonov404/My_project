import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static ArrayList<Task> tasks;
    static HttpClient httpClient = HttpClient.newHttpClient();
    static Gson gson = new Gson();
    private static String uriTask = "http://gitlessons2020.rtuitlab.ru:3000/reflectionTasks";
    static Handler handler = new Handler();
    static Class<Handler> handlerClass = Handler.class;

    public static void main(String[] args) throws IOException, InterruptedException, InvocationTargetException, IllegalAccessException {
        Type collectionTask = new TypeToken<ArrayList<Task>>() {}.getType();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(uriTask))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        tasks = gson.fromJson(response.body(),collectionTask);

        List<Method> taskMethods = Arrays.stream(handlerClass
                .getDeclaredMethods())
                .filter(m -> Arrays.stream(m.getAnnotations()).anyMatch(a -> a instanceof TaskAnnotation))
                .collect(Collectors.toList());

        for (Task task : tasks){
           for (Method method : taskMethods){
               if (task.getType().equals(method.getName())){
                   method.invoke(handler,task.getData());
               }
           }
        }
    }
}
