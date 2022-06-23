package com.example.earthquake_s2.controller;

import com.example.earthquake_s2.data.EarthQuake;
import com.example.earthquake_s2.service.EarthQuakeService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController
public class EarthQuakeController {

        private final EarthQuakeService service;

    public EarthQuakeController(EarthQuakeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(){
        return "Home Page";
    }

    @GetMapping("/logout")
    public String logOut(HttpServletRequest request) throws ServletException {
        request.logout();
        return "logout";
    }

    @GetMapping("/get/all")
    public EarthQuake[] getAll (){
        return service.getEarthQuake();
    }

    @GetMapping("/get/restricted")
    public EarthQuake[] getRestricted (){
        return service.getEarthQuakesLessthan8();
    }

    @GetMapping("/get/byplace/{place}")
    public EarthQuake[] getByPlace (@PathVariable String place){
        return service.getEarthQuakesByPlace(place);
    }

    @GetMapping("/get/restrictedbyplace/{place}")
    public EarthQuake[] getRestrictedByPlace (@PathVariable String place){
        return service.getEarthQuakesByPlaceAndMagnitudeLessThan8(place);
    }

    @PostMapping("/add")
    public Mono<EarthQuake> addEarthQuake (@RequestBody EarthQuake earthQuake){
        return service.addEarthQuake(earthQuake);
    }

    @PutMapping("/update")
    public Mono<EarthQuake> updateEarthQuake (@RequestBody EarthQuake earthQuake){
        return service.updateEarthQuake(earthQuake);
    }

    @DeleteMapping("/delete")
    public Mono<EarthQuake> delete (){
        return service.deleteEarthQuake();
    }
}
