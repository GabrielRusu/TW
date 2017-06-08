package MySpringMVC.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import MySpringMVC.dao.MapViewDAOImpl;
import MySpringMVC.model.District;
import MySpringMVC.model.MapInfo;

@Controller
public class MapViewController {

    @Autowired
    private MapViewDAOImpl mapViewDAO;

    @RequestMapping(value = "/viewMap")
    public ModelAndView listMap(ModelAndView model, HttpServletRequest request) throws IOException {
        int hazard = Integer.parseInt(request.getParameter("hazard"));
        List<MapInfo> listMapInfo = mapViewDAO.list(hazard);

        model.addObject("listMapInfo", listMapInfo);
        model.setViewName("MapView");

        return model;
    }

    @RequestMapping(value = "/viewMap2", method = RequestMethod.GET)
    public ModelAndView listMap2(HttpServletRequest request) {
        int hazard = Integer.parseInt(request.getParameter("hazard"));
        List<MapInfo> listMapInfo = mapViewDAO.list(hazard);

        ModelAndView model = new ModelAndView();
        model.addObject("listMapInfo", listMapInfo);
        model.setViewName("MapView");

        return model;
    }

}
