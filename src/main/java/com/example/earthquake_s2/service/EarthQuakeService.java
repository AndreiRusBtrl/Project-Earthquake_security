package com.example.earthquake_s2.service;

import com.example.earthquake_s2.data.EarthQuake;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class EarthQuakeService {

    private final WebClient webClient;

    public EarthQuakeService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8080/db/api/v1/").build();
    }

    public EarthQuake[] getEarthQuake() {
        return webClient
                .get()
                .uri("/get_all_earthquakes")
                .retrieve()
                .bodyToMono(EarthQuake[].class).block();
    }

    public EarthQuake[] getEarthQuakesLessthan8() {
        return webClient
                .get()
                .uri("/get_restricted_earthquakes")
                .retrieve()
                .bodyToMono(EarthQuake[].class).block();
    }

    public EarthQuake[] getEarthQuakesByPlace(String place) {
        return webClient
                .get()
                .uri("/get/"+place)
                .retrieve()
                .bodyToMono(EarthQuake[].class).block();
    }

    public EarthQuake[] getEarthQuakesByPlaceAndMagnitudeLessThan8(String place) {
        return webClient
                .get()
                .uri("/get_restricted/"+place)
                .retrieve()
                .bodyToMono(EarthQuake[].class).block();
    }

    public Mono<EarthQuake> addEarthQuake(EarthQuake earthQuake) {
        return webClient
                .post()
                .uri("/add")
                .body(Mono.just(earthQuake), EarthQuake.class)
                .retrieve()
                .bodyToMono(EarthQuake.class);
    }

    public Mono<EarthQuake> updateEarthQuake(EarthQuake earthQuake, int id) {
        return webClient
                .put()
                .uri("/update/"+ id)
                .body(Mono.just(earthQuake), EarthQuake.class)
                .retrieve()
                .bodyToMono(EarthQuake.class);
    }

    public Mono<EarthQuake> deleteEarthQuake(int id) {
        return webClient
                .delete()
                .uri("/delete/"+ id)
                .retrieve()
                .bodyToMono(EarthQuake.class);
    }

    public EarthQuake createEarthQuake(String occuredOn,
                                       double latitude,
                                       double longitude,
                                       float depth,
                                       float magnitude,
                                       String calculationMethod,
                                       String networkId,
                                       String place,
                                       String cause){
        EarthQuake earthQuake = new EarthQuake();
        earthQuake.setOccurredOn(occuredOn);
        earthQuake.setLatitude(latitude);
        earthQuake.setLongitude(longitude);
        earthQuake.setDepth(depth);
        earthQuake.setMagnitude(magnitude);
        earthQuake.setCalculationMethod(calculationMethod);
        earthQuake.setNetworkId(networkId);
        earthQuake.setPlace(place);
        earthQuake.setCause(cause);

        return earthQuake;
    }
}
