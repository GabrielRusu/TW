package MySpringMVC.controller;

import MySpringMVC.dao.VillageDAO;
import MySpringMVC.model.Village;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;


@Controller
public class VillageController {

    @Autowired
    private VillageDAO villageDAO;

    @RequestMapping(value = "/viewVillage")
    public ModelAndView listVillage(ModelAndView model) throws IOException {
        List<Village> listVillage = villageDAO.list();
        model.addObject("listVillage", listVillage);
        model.setViewName("VillageView");

        return model;
    }

    @RequestMapping(value = "/newVillage", method = RequestMethod.GET)
    public ModelAndView newVillage(ModelAndView model) {
        Village newVillage = new Village();
        model.addObject("Village", newVillage);
        model.setViewName("VillageForm");
        return model;
    }

    @RequestMapping(value = "/saveVillage", method = RequestMethod.POST)
    public ModelAndView saveVillage(@ModelAttribute Village Village) {
        villageDAO.saveOrUpdate(Village);
        return new ModelAndView("redirect:/viewVillage");
    }

    @RequestMapping(value = "/deleteVillage", method = RequestMethod.GET)
    public ModelAndView deleteVillage(HttpServletRequest request) {
        int vil_id = Integer.parseInt(request.getParameter("id"));
        villageDAO.delete(vil_id);
        return new ModelAndView("redirect:/viewVillage");
    }

    @RequestMapping(value = "/editVillage", method = RequestMethod.GET)
    public ModelAndView editVillage(HttpServletRequest request) {
        int vil_id = Integer.parseInt(request.getParameter("id"));
        Village Village = villageDAO.get(vil_id);
        ModelAndView model = new ModelAndView("VillageForm");
        model.addObject("Village", Village);

        return model;
    }
}
