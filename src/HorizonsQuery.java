import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class HorizonsQuery {
    public static void main(String[] args) {
        String file_name = "query_parameters.txt"; // Nombre de archivo predeterminado

        if (args.length > 0) {
            file_name = args[0];
        }

        processFile(file_name);
    }

    private static void processFile(String file_name) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file_name));

            // Leer los parámetros del archivo
            List<String> parameters = new ArrayList<>();
            String line;
            while ((line = fileReader.readLine()) != null) {
                parameters.add(line);
            }
            fileReader.close();

            // Construir la URL de la solicitud con los parámetros
            String baseUrl = "https://ssd.jpl.nasa.gov/api/horizons.api";
            StringBuilder urlBuilder = new StringBuilder(baseUrl);
            //urlBuilder.append("?format=text"); // Formato de texto plano
            urlBuilder.append("?format=json"); // Formato JSON

            for (String parameter : parameters) {
                String[] parts = parameter.split("=");
                if (parts.length == 2) {
                    String paramName = parts[0].trim();
                    String paramValue = parts[1].trim();

                    String encodedParamName = URLEncoder.encode(paramName, "UTF-8");
                    String encodedParamValue = URLEncoder.encode(paramValue, "UTF-8");

                    urlBuilder.append("&").append(encodedParamName).append("=").append(encodedParamValue);
                }
            }

            URL url = new URL(urlBuilder.toString());

            // Realizar la solicitud POST
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            // Leer la respuesta del servidor
            BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            while ((line = responseReader.readLine()) != null) {
                response.append(line);
                response.append("\n");
            }
            responseReader.close();

            // Guardar la respuesta en un archivo
            String outputFileName = "results.txt";
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFileName));
            fileWriter.write(response.toString());
            fileWriter.close();

            System.out.println("Resultado guardado en " + outputFileName);

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
