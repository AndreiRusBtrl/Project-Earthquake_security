package com.example.earthquake_s2.service;

import com.example.earthquake_s2.data.EarthQuake;
import org.springframework.stereotype.Service;
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

    public Mono<EarthQuake> updateEarthQuake(EarthQuake earthQuake) {
        return webClient
                .put()
                .uri("/update")
                .body(Mono.just(earthQuake), EarthQuake.class)
                .retrieve()
                .bodyToMono(EarthQuake.class);
    }

    public Mono<EarthQuake> deleteEarthQuake() {
        return webClient
                .delete()
                .uri("/delete")
                .retrieve()
                .bodyToMono(EarthQuake.class);
    }
}
