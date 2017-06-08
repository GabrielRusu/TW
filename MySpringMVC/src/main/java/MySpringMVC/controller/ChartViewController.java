package MySpringMVC.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import MySpringMVC.dao.ChartViewDAOImpl;
import MySpringMVC.model.District;

@Controller
public class ChartViewController {

    @Autowired
    private ChartViewDAOImpl chartViewDAO;

    @RequestMapping(value = "/viewChart")
    public ModelAndView listChart(ModelAndView model) throws IOException {
        List<District> chartList = chartViewDAO.list(); //lel modify
        model.addObject("listChart", chartList);
        model.setViewName("ChartView");

        return model;
    }

    @RequestMapping(value = "/viewChart2", method = RequestMethod.GET)
    public ModelAndView listChart2() {
        chartViewDAO.get(2); //modifyyy
        return new ModelAndView("redirect:/viewChart");
    }
}
