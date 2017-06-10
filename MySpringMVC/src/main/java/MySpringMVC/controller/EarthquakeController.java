package MySpringMVC.controller;

import MySpringMVC.dao.EarthquakeDAO;
import MySpringMVC.model.Earthquake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class EarthquakeController {

    @Autowired
    private EarthquakeDAO EarthquakeDAO;

    @RequestMapping(value = "/viewEarthquake/{pageId}")
    public ModelAndView listEarthquake(ModelAndView model,@PathVariable Integer pageId) throws IOException {
        int total = 50;
        if(pageId == 1){
            model.addObject("pageId", pageId);
        }
        else {
            pageId = (pageId - 1) * total + 1;
            model.addObject("pageId", (pageId/total)+1);
        }
        List<Earthquake> listEarthquake = EarthquakeDAO.list(pageId, total);
        model.addObject("listEarthquake", listEarthquake);
        model.setViewName("EarthquakeView");

        return model;
    }

    @RequestMapping(value = "/newEarthquake", method = RequestMethod.GET)
    public ModelAndView newEarthquake(ModelAndView model) {
        Earthquake newEarthquake = new Earthquake();
        model.addObject("Earthquake", newEarthquake);
        model.setViewName("EarthquakeForm");
        return model;
    }

    @RequestMapping(value = "/saveEarthquake", method = RequestMethod.POST)
    public ModelAndView saveEarthquake(@ModelAttribute Earthquake Earthquake) {
        EarthquakeDAO.saveOrUpdate(Earthquake);
        return new ModelAndView("redirect:/viewEarthquake/1");
    }

    @RequestMapping(value = "/deleteEarthquake", method = RequestMethod.GET)
    public ModelAndView deleteEarthquake(HttpServletRequest request) {
        int quake_id = Integer.parseInt(request.getParameter("id"));
        EarthquakeDAO.delete(quake_id);
        return new ModelAndView("redirect:/viewEarthquake/1");
    }

    @RequestMapping(value = "/editEarthquake", method = RequestMethod.GET)
    public ModelAndView editEarthquake(HttpServletRequest request) {
        int quake_id = Integer.parseInt(request.getParameter("id"));
        Earthquake Earthquake = EarthquakeDAO.get(quake_id);
        ModelAndView model = new ModelAndView("EarthquakeForm");
        model.addObject("Earthquake", Earthquake);

        return model;
    }

}
