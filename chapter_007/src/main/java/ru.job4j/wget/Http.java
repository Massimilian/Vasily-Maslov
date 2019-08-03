package ru.job4j.wget;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

public class Http implements Callable {
    private final Downloadable downl;
    private long speedShooter = 0L;

    public Http(Downloadable downl) {
        this.downl = downl;
    }


    @Override
    public String call() throws Exception {
        return sendGet();
    }

    /**
     * Method for getting new info
     *
     * @return
     * @throws Exception
     */
    private String sendGet() throws Exception {
        URL obj = new URL(downl.getRequest()); // создаём Url, в который передаём искомый адрес
        HttpURLConnection con = (HttpURLConnection) obj.openConnection(); // открываем соединение с сайтом, адрем которого мы указали в url.
        con.setRequestMethod("GET"); // устанавливаем метод "получить информацию"
        con.setRequestProperty("User-Agent", "Mozilla/5.0"); // уточнение особенностей соединения
        int responseCode = con.getResponseCode(); // получение ответа от сайта (200 - всё хорошо)
        System.out.println("\nSending 'GET' request to URL : " + downl.getRequest());
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); // переносим информацию с соединения в буфер
        String inputLine;
        int count = 0;
        StringBuffer response = new StringBuffer();
        long currentTime = System.nanoTime();
        while ((inputLine = in.readLine()) != null) {
            speedShooter += inputLine.length();
            if (speedShooter >= downl.getSpeed()) {
                if (System.nanoTime() - currentTime < 1000000000) {
                    System.out.printf("...download limited; %d seconds passed...%s", ++count, System.lineSeparator());
                    Thread.currentThread().sleep(1000);
                    speedShooter = 0;
                    currentTime = System.nanoTime();
                }
            }
            response.append(inputLine); // записываем в строку.
        }
        in.close();
        System.out.printf("...download finished!%s", System.lineSeparator());
        return response.toString();
    }
}


