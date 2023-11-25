package backend;

import com.google.gson.Gson;
import backend.data.createUserForGorest;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.core.StringContains.containsString;


public class backendTestGorest {

    private static final String baseURL = "https://gorest.co.in";
    private static final String email = String.format(
            "test_%s@test.com", new SimpleDateFormat("yyyyMMdd_HHmmssSS").format(new Date()));
    private static final String token = "Bearer be4b802658dfbf4c6a0b1bb38b5a9be9a98ebae21168f2c74b8d09f968cefc35";
    Gson gson = new Gson();

    @Test
    public void createUser() throws IOException, InterruptedException {
        String userURL = "/public/v2/users";
        String checkURL = "/public/v2/users/";
        createUserForGorest creatingUser = new createUserForGorest(
                "Name", email, "male", "active");
        HttpRequest request = HttpRequest.newBuilder()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .uri(URI.create(baseURL + userURL))
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(creatingUser)))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> createUserResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        HttpRequest requestCheck = HttpRequest.newBuilder()
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .uri(URI.create(baseURL + checkURL))
                .GET()
                .build();
        HttpClient httpClientCheck = HttpClient.newHttpClient();
        HttpResponse<String> createUserResponseCheck = httpClientCheck.send(requestCheck, HttpResponse.BodyHandlers.ofString());

        String checkUser = createUserResponseCheck.body();
        MatcherAssert.assertThat(checkUser, containsString(creatingUser.getEmail()));
    }
}
