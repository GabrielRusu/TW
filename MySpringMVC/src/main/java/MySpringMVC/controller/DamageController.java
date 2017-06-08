package MySpringMVC.controller;

import MySpringMVC.dao.DamageDAO;
import MySpringMVC.model.Damage;
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
public class DamageController {
    @Autowired
    private DamageDAO DamageDAO;

    @RequestMapping(value = "/viewDamage")
    public ModelAndView listDamage(ModelAndView model) throws IOException {
        List<Damage> listDamage = DamageDAO.list();
        model.addObject("listDamage", listDamage);
        model.setViewName("DamageView");

        return model;
    }

    @RequestMapping(value = "/newDamage", method = RequestMethod.GET)
    public ModelAndView newDamage(ModelAndView model) {
        Damage newDamage = new Damage();
        model.addObject("Damage", newDamage);
        model.setViewName("DamageForm");
        return model;
    }

    @RequestMapping(value = "/saveDamage", method = RequestMethod.POST)
    public ModelAndView saveDamage(@ModelAttribute Damage Damage) {
        DamageDAO.saveOrUpdate(Damage);
        return new ModelAndView("redirect:/viewDamage");
    }

    @RequestMapping(value = "/deleteDamage", method = RequestMethod.GET)
    public ModelAndView deleteDamage(HttpServletRequest request) {
        int dis_id = Integer.parseInt(request.getParameter("dis_id"));
        DamageDAO.delete(dis_id);
        return new ModelAndView("redirect:/viewDamage");
    }

    @RequestMapping(value = "/editDamage", method = RequestMethod.GET)
    public ModelAndView editDamage(HttpServletRequest request) {
        int dis_id = Integer.parseInt(request.getParameter("dis_id"));
        Damage Damage = DamageDAO.get(dis_id);
        ModelAndView model = new ModelAndView("DamageForm");
        model.addObject("Damage", Damage);

        return model;
    }

}
