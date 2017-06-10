package MySpringMVC.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import MySpringMVC.dao.TablesDAOImpl;

@Controller
public class TablesController {

    @Autowired
    private TablesDAOImpl tablesDAO;

    @RequestMapping(value = "/viewTables", method = RequestMethod.GET)
    public ModelAndView viewTables(ModelAndView model) {
        model.setViewName("TablesView");
        return model;
    }

    @RequestMapping(value = "/updateChart", method = RequestMethod.GET)
    public ModelAndView updateChart(ModelAndView model) {
        model.setViewName("TablesView");
        tablesDAO.createChart();
        return model;
    }

    @RequestMapping(value = "/updateChart2", method = RequestMethod.GET)
    public ModelAndView updateChart2(ModelAndView model) {
        model.setViewName("TablesView");
        tablesDAO.createChart2();
        return model;
    }

    @RequestMapping(value = "/updateTables", method = RequestMethod.GET)
    public ModelAndView updateTables() {
        tablesDAO.updatePopulation();
        return new ModelAndView("redirect:/viewTables");
    }
}

