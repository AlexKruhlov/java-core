package ua.com.readurl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Objects.nonNull;

public class UrlReceiverUtil {
    private static final String END_OF_LINE_TEMPLATE = "([\\r\\n])";
    private static final String EMPTY_STRING = "";
    private static final String WHITE_SPACE = " ";

    private static final String EX_INSIDE_FINALLY = "Exception inside finally";

    public static String convertPageIntoString(String url) {
        URL urlObj;
        URLConnection urlConnection;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        final StringBuilder resultedStrBuilder = new StringBuilder();
        try {
            urlObj = new URL(url);
            urlConnection = urlObj.openConnection();
            inputStreamReader = new InputStreamReader(urlConnection.getInputStream(), UTF_8);
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedReader.lines()
                    .map(line -> line.replaceAll(END_OF_LINE_TEMPLATE, EMPTY_STRING))
                    .map(line -> line.replaceAll(WHITE_SPACE, EMPTY_STRING))
                    .forEach(resultedStrBuilder::append);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (nonNull(bufferedReader)) {
                try {
                    bufferedReader.close();
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println(EX_INSIDE_FINALLY);
                }
            }
        }
        return resultedStrBuilder.toString();
    }
}
