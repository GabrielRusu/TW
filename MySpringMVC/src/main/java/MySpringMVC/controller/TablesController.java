package MySpringMVC.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import MySpringMVC.dao.TablesDAOImpl;
import MySpringMVC.model.District;

@Controller
public class TablesController {

    @Autowired
    private TablesDAOImpl tablesDAO;

    @RequestMapping(value = "/viewTables", method = RequestMethod.GET)
    public ModelAndView viewTables(ModelAndView model) {
        model.setViewName("TablesView");
        return model;
    }

    @RequestMapping(value = "/updateTables", method = RequestMethod.GET)
    public ModelAndView updateTables() {
        tablesDAO.updatePopulation();
        return new ModelAndView("redirect:/viewTables");
    }
}
