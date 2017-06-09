package MySpringMVC.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import MySpringMVC.dao.SimpleTableViewDAOImpl;
import MySpringMVC.model.PopStatistics;
import MySpringMVC.model.ProjectActivity;

@Controller
public class SimpleTableViewController {

    @Autowired
    private SimpleTableViewDAOImpl simpleTableViewDAO;

    @RequestMapping(value = "/viewSimpleTable")
    public ModelAndView listSimpleTable(ModelAndView model) throws IOException {
        List<PopStatistics> simpleTableList = simpleTableViewDAO.list();
        model.addObject("listSimpleTable", simpleTableList);
        model.setViewName("SimpleTableView");

        return model;
    }

    @RequestMapping(value = "/viewSimpleTable2")
    public ModelAndView listSimpleTable2(ModelAndView model) throws IOException {
        List<ProjectActivity> simpleTableList = simpleTableViewDAO.list2();
        model.addObject("listSimpleTable2", simpleTableList);
        model.setViewName("SimpleTableView2");

        return model;
    }

}
