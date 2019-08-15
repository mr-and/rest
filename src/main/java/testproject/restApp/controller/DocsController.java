package testproject.restApp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import testproject.restApp.model.Docs;
import testproject.restApp.service.DocsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class DocsController {
    private DocsService docsService;

    private static final Logger logger =
            LoggerFactory.getLogger(DocsController.class);

    @Autowired
    public void setDocsService(DocsService docsService) {
        this.docsService = docsService;
    }

    @RequestMapping(value = "/doclist", method = RequestMethod.GET)
    public ModelAndView allDocs(){
        logger.info("info");
        logger.error("error");
        List<Docs> docs = docsService.allDocs();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("doclist");
        modelAndView.addObject("docsList", docs);
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView root(){
        logger.info("info");
        logger.error("error");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("greetings");
        return modelAndView;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        logger.info("info");
        logger.error("error");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/adddoc", method = RequestMethod.GET)
     public ModelAndView addDocPage(){
        logger.info("info");
        logger.error("error");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adddoc");
        return modelAndView;
    }

    @RequestMapping(value = "/adddoc", method = RequestMethod.POST)
    public ModelAndView addDoc(@ModelAttribute("doc") Docs docs) {
        logger.info("info");
        logger.error("error");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/doclist");
        docsService.add(docs);
        return modelAndView;
    }

    @RequestMapping(value = "/deldoc", method = RequestMethod.GET)
    public ModelAndView delDocPage() {
        logger.info("info");
        logger.error("error");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deldoc");
        return modelAndView;
    }

    @RequestMapping(value = "/deldoc", method = RequestMethod.POST)
    public ModelAndView delDoc(@ModelAttribute("number") int number) {
        logger.info("info");
        logger.error("error");
        List<Docs> docs = docsService.allDocs();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/doclist");
        for (Docs doc : docs) {
            if(doc.getNumber() == number) {
                docsService.delDoc(doc);
            }
        }
        return modelAndView;
    }


    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        logger.info("info");
        logger.error("error");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        logger.info("info");
        logger.error("error");
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }


}
