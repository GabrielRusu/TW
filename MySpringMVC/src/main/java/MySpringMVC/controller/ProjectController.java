package MySpringMVC.controller;

import MySpringMVC.dao.ProjectDAO;
import MySpringMVC.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    private ProjectDAO ProjectDAO;

    @RequestMapping(value = "/viewProject/{pageId}")
    public ModelAndView listProject(ModelAndView model,@PathVariable Integer pageId) throws IOException {
        int total = 50;
        if(pageId == 1){
            model.addObject("pageId", pageId);
        }
        else {
            pageId = (pageId - 1) * total + 1;
            model.addObject("pageId", (pageId/total)+1);
        }
        List<Project> listProject = ProjectDAO.list(pageId, total);
        model.addObject("listProject", listProject);
        model.setViewName("ProjectView");

        return model;
    }

    @RequestMapping(value = "/newProject", method = RequestMethod.GET)
    public ModelAndView newProject(ModelAndView model) {
        Project newProject = new Project();
        model.addObject("Project", newProject);
        model.setViewName("ProjectForm");
        return model;
    }

    @RequestMapping(value = "/saveProject", method = RequestMethod.POST)
    public ModelAndView saveProject(@ModelAttribute Project Project) {
        ProjectDAO.saveOrUpdate(Project);
        return new ModelAndView("redirect:/viewProject/1");
    }

    @RequestMapping(value = "/deleteProject", method = RequestMethod.GET)
    public ModelAndView deleteProject(HttpServletRequest request) {
        int clus_id = Integer.parseInt(request.getParameter("clus_id"));
        ProjectDAO.delete(clus_id);
        return new ModelAndView("redirect:/viewProject/1");
    }

    @RequestMapping(value = "/editProject", method = RequestMethod.GET)
    public ModelAndView editProject(HttpServletRequest request) {
        int clus_id = Integer.parseInt(request.getParameter("clus_id"));
        Project Project = ProjectDAO.get(clus_id);
        ModelAndView model = new ModelAndView("ProjectForm");
        model.addObject("Project", Project);

        return model;
    }

}
