package MySpringMVC.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import MySpringMVC.dao.PopulationDAO;
import MySpringMVC.model.Population;

@Controller
public class PopulationController {

    @Autowired
    private PopulationDAO populationDAO;

    @RequestMapping(value = "/viewPopulation/{pageId}")
    public ModelAndView listPopulation(ModelAndView model,@PathVariable Integer pageId) throws IOException {
        int total = 50;
        if(pageId == 1){
            model.addObject("pageId", pageId);
        }
        else {
            pageId = (pageId - 1) * total + 1;
            model.addObject("pageId", (pageId/total)+1);
        }
        List<Population> listPopulation = populationDAO.list(pageId, total);
        model.addObject("listPopulation", listPopulation);
        model.setViewName("PopulationView");

        return model;
    }

    @RequestMapping(value = "/newPopulation", method = RequestMethod.GET)
    public ModelAndView newPopulation(ModelAndView model) {
        Population newPopulation = new Population();
        model.addObject("population", newPopulation);
        model.setViewName("PopulationForm");
        return model;
    }

    @RequestMapping(value = "/savePopulation", method = RequestMethod.POST)
    public ModelAndView savePopulation(@ModelAttribute Population population) {
        populationDAO.saveOrUpdate(population);
        return new ModelAndView("redirect:/viewPopulation/1");
    }

    @RequestMapping(value = "/deletePopulation", method = RequestMethod.GET)
    public ModelAndView deletePopulation(HttpServletRequest request) {
        int mun_id = Integer.parseInt(request.getParameter("mun_id"));
        int dis_id = Integer.parseInt(request.getParameter("dis_id"));
        populationDAO.delete(mun_id, dis_id);
        return new ModelAndView("redirect:/viewPopulation/1");
    }

    @RequestMapping(value = "/editPopulation", method = RequestMethod.GET)
    public ModelAndView editPopulation(HttpServletRequest request) {
        int mun_id = Integer.parseInt(request.getParameter("mun_id"));
        int dis_id = Integer.parseInt(request.getParameter("dis_id"));
        Population population = populationDAO.get(mun_id, dis_id);
        ModelAndView model = new ModelAndView("PopulationForm");
        model.addObject("population", population);

        return model;
    }

}
