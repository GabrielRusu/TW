package MySpringMVC.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import MySpringMVC.dao.SimpleTableViewDAOImpl;
import MySpringMVC.model.PopStatistics;
import MySpringMVC.model.ProjectActivity;

@Controller
public class SimpleTableViewController {

    @Autowired
    private SimpleTableViewDAOImpl simpleTableViewDAO;

    @RequestMapping(value = "/viewSimpleTable/{pageId}")
    public ModelAndView listSimpleTable(ModelAndView model, @PathVariable Integer pageId) throws IOException {
        int total = 50;
        if(pageId == 1){
            model.addObject("pageId", pageId);
        }
        else {
            pageId = (pageId - 1) * total + 1;
            model.addObject("pageId", (pageId/total)+1);
        }
        List<PopStatistics> simpleTableList = simpleTableViewDAO.list(pageId, total);
        model.addObject("listSimpleTable", simpleTableList);
        model.setViewName("SimpleTableView");

        return model;
    }

    @RequestMapping(value = "/viewSimpleTable2/{pageId}")
    public ModelAndView listSimpleTable2(ModelAndView model, @PathVariable Integer pageId) throws IOException {
        int total = 50;
        if(pageId == 1){
            model.addObject("pageId", pageId);
        }
        else {
            pageId = (pageId - 1) * total + 1;
            model.addObject("pageId", (pageId/total)+1);
        }
        List<ProjectActivity> simpleTableList = simpleTableViewDAO.list2(pageId, total);
        model.addObject("listSimpleTable2", simpleTableList);
        model.setViewName("SimpleTableView2");

        return model;
    }

}

