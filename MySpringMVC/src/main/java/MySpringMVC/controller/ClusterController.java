package MySpringMVC.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import MySpringMVC.dao.ClusterDAO;
import MySpringMVC.model.Cluster;

@Controller
public class ClusterController {

    @Autowired
    private ClusterDAO ClusterDAO;

    @RequestMapping(value = "/viewCluster")
    public ModelAndView listCluster(ModelAndView model) throws IOException {
        List<Cluster> listCluster = ClusterDAO.list();
        model.addObject("listCluster", listCluster);
        model.setViewName("ClusterView");

        return model;
    }

    @RequestMapping(value = "/newCluster", method = RequestMethod.GET)
    public ModelAndView newCluster(ModelAndView model) {
        Cluster newCluster = new Cluster();
        model.addObject("Cluster", newCluster);
        model.setViewName("ClusterForm");
        return model;
    }

    @RequestMapping(value = "/saveCluster", method = RequestMethod.POST)
    public ModelAndView saveCluster(@ModelAttribute Cluster Cluster) {
        ClusterDAO.saveOrUpdate(Cluster);
        return new ModelAndView("redirect:/viewCluster");
    }

    @RequestMapping(value = "/deleteCluster", method = RequestMethod.GET)
    public ModelAndView deleteCluster(HttpServletRequest request) {
        int clus_id = Integer.parseInt(request.getParameter("id"));
        ClusterDAO.delete(clus_id);
        return new ModelAndView("redirect:/viewCluster");
    }

    @RequestMapping(value = "/editCluster", method = RequestMethod.GET)
    public ModelAndView editCluster(HttpServletRequest request) {
        int clus_id = Integer.parseInt(request.getParameter("id"));
        Cluster Cluster = ClusterDAO.get(clus_id);
        ModelAndView model = new ModelAndView("ClusterForm");
        model.addObject("Cluster", Cluster);

        return model;
    }
}
