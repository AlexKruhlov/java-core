package ua.com.readurl;

import jdk.nashorn.internal.runtime.regexp.RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    public static void main(String[] args) {
//        final String str = UrlReceiverUtil.convertPageIntoString("https://en.wikipedia.org/wiki/Wiki");
        final String str = UrlReceiverUtil.convertPageIntoString("https://my.ukrsibbank.com/ru/personal/");

        System.out.println(str);

//        Pattern pattern = Pattern.compile("https?://.*?(?=\")");
        Pattern pattern = Pattern.compile("USD|[0-9.]+");

        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }


    }
}
