package network.controller;

import network.model.Location;
import network.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "location")
public class LocationCtr {
    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/addLocation.do")
    public String addLocation() {
        return "addLocation";
    }

    @RequestMapping("/add.do")
    public String add(Location location, HttpServletResponse response) {
        locationService.add(location);
        return "redirect:./addLocation.do";
    }
}
