package MySpringMVC.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import MySpringMVC.dao.PopulationDAO;
import MySpringMVC.model.Population;

public class PopulationController {
    @Autowired
    private PopulationDAO populationDAO;

    @RequestMapping(value = "/viewPopulation")
    public ModelAndView listPopulation(ModelAndView model) throws IOException {
        List<Population> listPopulation = populationDAO.list();
        model.addObject("listPopulation", listPopulation);
        model.setViewName("PopulationView");

        return model;
    }

    @RequestMapping(value = "/newPopulation", method = RequestMethod.GET)
    public ModelAndView newPopulation(ModelAndView model) {
        Population newPopulation = new Population();
        model.addObject("Population", newPopulation);
        model.setViewName("PopulationForm");
        return model;
    }

    @RequestMapping(value = "/savePopulation", method = RequestMethod.POST)
    public ModelAndView savePopulation(@ModelAttribute Population population) {
        populationDAO.saveOrUpdate(population);
        return new ModelAndView("redirect:/viewPopulation");
    }

    @RequestMapping(value = "/deletePopulation", method = RequestMethod.GET)
    public ModelAndView deletePopulation(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("mun_id"));
        populationDAO.delete(id);
        return new ModelAndView("redirect:/viewPopulation");
    }

    @RequestMapping(value = "/editPopulation", method = RequestMethod.GET)
    public ModelAndView editPopulation(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("mun_id"));
        Population population = populationDAO.get(id);
        ModelAndView model = new ModelAndView("PopulationForm");
        model.addObject("Population", population);

        return model;
    }

}
