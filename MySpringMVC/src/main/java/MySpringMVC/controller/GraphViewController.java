package MySpringMVC.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import MySpringMVC.dao.GraphViewDAOImpl;
import MySpringMVC.model.District;

@Controller
public class GraphViewController {

    @Autowired
    private GraphViewDAOImpl graphViewDAO;

    @RequestMapping(value = "/viewGraph")
    public ModelAndView listGraph(ModelAndView model) throws IOException {
        List<District> graphList = graphViewDAO.list(); //lel modify
        model.addObject("listChart", graphList);
        model.setViewName("GraphView");

        return model;
    }

    @RequestMapping(value = "/viewGraph2", method = RequestMethod.GET)
    public ModelAndView listGraph2() {
        graphViewDAO.get(2);
        return new ModelAndView("redirect:/viewGraph");
    }
}
