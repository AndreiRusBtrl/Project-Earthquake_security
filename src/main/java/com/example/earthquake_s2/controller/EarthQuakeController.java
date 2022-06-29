package com.example.earthquake_s2.controller;

import com.example.earthquake_s2.data.EarthQuake;
import com.example.earthquake_s2.service.EarthQuakeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class EarthQuakeController {

    private final EarthQuakeService service;

    public EarthQuakeController(EarthQuakeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("earthquakes", service.getEarthQuakesByPlaceAndMagnitudeLessThan8("Van"));
        return "index";
    }

    @GetMapping("/logout")
    public String logOut(HttpServletRequest request) throws ServletException {
        request.logout();
        return "index";
    }

    @GetMapping("/login")
    public String logIn() {
        return "redirect:http://localhost:8180/auth/realms/SpringBootKeycloak/protocol/openid-connect/auth?response_type=code&client_id=login-app&redirect_uri=http%3A%2F%2Flocalhost%3A8081%2Fsso%2Flogin&state=57f8e908-6019-4f25-a443-12ad26e8f7f1&login=true&scope=openid";
    }

    @GetMapping("/get/all")
    public String getAll(Model model) {
        model.addAttribute("earthquakes", service.getEarthQuake());
        return "admin";
    }

    @GetMapping("/get/restricted")
    public String getRestricted(Model model) {
        model.addAttribute("earthquakes", service.getEarthQuakesLessthan8());
        return "user";
    }

//    @GetMapping("/get/byplace/{place}")
//    public EarthQuake[] getByPlace(@PathVariable String place) {
//        return service.getEarthQuakesByPlace(place);
//    }
//
//    @GetMapping("/get/restrictedbyplace/{place}")
//    public EarthQuake[] getRestrictedByPlace(@PathVariable String place) {
//        return service.getEarthQuakesByPlaceAndMagnitudeLessThan8(place);
//    }

    @GetMapping("/add")
    public String earthQuakeAddGet(Model model) {
        model.addAttribute("EarthQuake", new EarthQuake());
        return "checkout";
    }

//    @PostMapping("/add")
//    public Mono<EarthQuake> addEarthQuake(@RequestBody EarthQuake earthQuake, Model model) {
//        model.addAttribute("contact", new EarthQuake());
//        return service.addEarthQuake(earthQuake);
//    }

    @PostMapping("/add")
    public String addEarthQuake(@RequestParam ("occuredOn") String occuredOn,
                                          @RequestParam ("latitude") double latitude,
                                          @RequestParam ("longitude") double longitude,
                                          @RequestParam ("depth") float depth,
                                          @RequestParam ("magnitude") float magnitude,
                                          @RequestParam ("calculationMethod") String calculationMethod,
                                          @RequestParam ("networkId") String networkId,
                                          @RequestParam ("place") String place,
                                          @RequestParam ("cause") String cause) {

        EarthQuake earthQuake = service.createEarthQuake(occuredOn, latitude, longitude, depth, magnitude, calculationMethod, networkId, place, cause);
        service.addEarthQuake(earthQuake);
        return "index";
    }

    @PutMapping("/update/{id}")
    public String updateEarthQuake(@RequestBody EarthQuake earthQuake, @PathVariable int id) {
        service.updateEarthQuake(earthQuake, id);
        return "index";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.deleteEarthQuake(id);
        return "index";
    }
}
