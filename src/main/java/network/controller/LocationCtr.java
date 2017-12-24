package network.controller;

import com.github.pagehelper.PageInfo;
import network.model.Location;
import network.model.Teacher;
import network.service.LocationPageService;
import network.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "location")
public class LocationCtr {
    @Autowired
    private LocationService locationService;
    @Autowired
    private LocationPageService locationPageService;

    @RequestMapping(value = "/addLocation.do")
    public String addLocation() {
        return "addLocation";
    }

    @RequestMapping(value = "/add.do")
    public
    @ResponseBody
    Map<String, Object> add(HttpServletRequest request, HttpServletResponse response) {
        String locationName = request.getParameter("locationName");
        String minLcationX = request.getParameter("minLcationX");
        String maxLcationX = request.getParameter("maxLcationX");
        String minLcationY = request.getParameter("minLcationY");
        String maxLcationY = request.getParameter("maxLcationY");

        Location location = new Location();
        location.setLocationName(locationName);
        location.setMinLcationX(Double.parseDouble(minLcationX));
        location.setMaxLcationX(Double.parseDouble(maxLcationX));
        location.setMinLcationY(Double.parseDouble(minLcationY));
        location.setMaxLocationY(Double.parseDouble(maxLcationY));

        locationService.add(location);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "success");
        return map;

    }

    @RequestMapping(value = "/delete.do")
    public
    @ResponseBody
    Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response) {
        Long lId = Long.parseLong(request.getParameter("lId").toString());
        locationService.delete(lId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "success");
        return map;
    }

    @RequestMapping(value = "/locationList.do")
    public ModelAndView displayRegistrations(Integer pageNo, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        PageInfo<Location> page = locationPageService.queryByPage(pageNo, 10);
        ModelAndView mv = new ModelAndView("locationList");
        System.out.println("size:" + page.getList().size());
        mv.addObject("locationList", page.getList());
        mv.addObject("totalPage", page.getPages());
        mv.addObject("currentPage", page.getPageNum());
        return mv;
    }
}
