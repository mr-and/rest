package testproject.restApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import testproject.restApp.model.Docs;
import testproject.restApp.service.DocsService;

import java.util.List;


@Controller
public class DocsController {
    private DocsService docsService;

    @Autowired
    public void setDocsService(DocsService docsService) {
        this.docsService = docsService;
    }

    @RequestMapping(value = "/doclist", method = RequestMethod.GET)
    public ModelAndView allDocs(){
        List<Docs> docs = docsService.allDocs();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("doclist");
        modelAndView.addObject("docsList", docs);
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView root(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("greetings");
        return modelAndView;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/adddoc", method = RequestMethod.GET)
     public ModelAndView addDocPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adddoc");
        return modelAndView;
    }

    @RequestMapping(value = "/adddoc", method = RequestMethod.POST)
    public ModelAndView addDoc(@ModelAttribute("doc") Docs docs) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/doclist");
        docsService.add(docs);
        return modelAndView;
    }

    @RequestMapping(value = "/deldoc", method = RequestMethod.GET)
    public ModelAndView delDocPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deldoc");
        return modelAndView;
    }

    @RequestMapping(value = "/deldoc", method = RequestMethod.POST)
    public ModelAndView delDoc(@ModelAttribute("number") int number) {
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

}
