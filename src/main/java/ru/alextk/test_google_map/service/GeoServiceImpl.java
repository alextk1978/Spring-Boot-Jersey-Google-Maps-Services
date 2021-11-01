package ru.alextk.test_google_map.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.alextk.test_google_map.model.GeoResult;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author Alexey Tkachenko
 */

@Slf4j
@Service
public class GeoServiceImpl implements GeoService {
    @Value("${google_map_geoCoding_url}")
    private String urlGeocode;

    @Value("${google_map_geoDecoding_url}")
    private String urlGeoDecode;

    @Value("${google_map_api_key}")
    private String apiKey;

    @Override
    public GeoResult getGeocode (String address) {
        log.debug("Старт метода GetGeocode с параметром {}", address);
        return getResponseFromGoogleMapApi(urlGeocode, address);
    }

    @Override
    public GeoResult getAddress (String code) {
        log.debug("Старт метода GetAddress с параметром {}", code);
        return getResponseFromGoogleMapApi(urlGeoDecode, code);
    }

    private GeoResult getResponseFromGoogleMapApi (String url, String addressOrCode) {
        log.debug("Старт метода getResponseFromGoogleMapApi с параметром {}", addressOrCode);
        String encodedAddress = URLEncoder.encode(addressOrCode, StandardCharsets.UTF_8);
        log.debug("Кодируем параметр запроса. Результат кодирования: {}", encodedAddress);
        String urlResult = url + encodedAddress + "&location_type=ROOFTOP&result_type=street_address&key=" + apiKey;
        log.debug("Формируем URL запроса: {}", urlResult);

        GeoResult mapEntity = null;

        var client = ClientBuilder.newClient();
        log.debug("Создаем объект Client");

        Response response = client.target(urlResult).request().get();
        log.debug("Получаем ответ от сервера Гугла {}", response);

        if (response.getStatus() != 200) {
            log.error("Error response : {}", response.getStatusInfo());
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        try {
            mapEntity = response.readEntity(GeoResult.class);
            log.debug("Получаем объект MapEntity из Response");
        } catch (Exception e) {
            log.error("Ошибка получения entity из response: {}", Arrays.toString(e.getStackTrace()));
        }
        return mapEntity;
    }
}
