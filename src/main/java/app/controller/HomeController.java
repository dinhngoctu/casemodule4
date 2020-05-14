package app.controller;

import app.model.TestEntity;
import app.service.serviceInterface.ITestEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ITestEntityService testEntityService;

    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    @GetMapping("/test")
    public String getListTest(Model model) {
        List<TestEntity> tests = testEntityService.findAll();
        System.out.println(tests.get(0).getId());
        model.addAttribute("tests", tests);
        return "tables_test";
    }
}
