package MySpringMVC.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import MySpringMVC.dao.SimpleTableViewDAOImpl;
import MySpringMVC.model.District;

@Controller
public class SimpleTableViewController {

    @Autowired
    private SimpleTableViewDAOImpl simpleTableViewDAO;

    @RequestMapping(value = "/viewSimpleTable")
    public ModelAndView listSimpleTable(ModelAndView model) throws IOException {
        List<District> simpleTableList = simpleTableViewDAO.list(); //lel modify
        model.addObject("listSimpleTable", simpleTableList);
        model.setViewName("SimpleTableView");

        return model;
    }


    @RequestMapping(value = "/viewSimpleTable2", method = RequestMethod.GET)
    public ModelAndView listSimpleTable2() {
        simpleTableViewDAO.list();
        return new ModelAndView("redirect:/viewSimpleTable");
    }
}
