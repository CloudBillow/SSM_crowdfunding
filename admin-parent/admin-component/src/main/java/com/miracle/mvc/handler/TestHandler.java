package com.miracle.mvc.handler;

import com.miracle.entity.Admin;
import com.miracle.service.api.AdminService;
import com.miracle.util.CrowdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Miracle
 * @version v1.0
 * @description TODO
 * @date 2021-03-27 1:10
 */
@Controller
public class TestHandler {
    @Autowired
    private AdminService adminService;
    private final Logger logger = LoggerFactory.getLogger(TestHandler.class);

    @RequestMapping("/test/ssm.html")
    public String hello(Model model, HttpServletRequest request) {
        boolean isJsonRequest = CrowdUtil.isJsonRequest(request);
        logger.info("isJsonRequest = " + isJsonRequest);
        List<Admin> adminList = adminService.getAll();
        model.addAttribute("adminList", adminList);
        return "target";
    }

    @PostMapping("/send/array.json")
    public String testArray(@RequestBody List<Integer> array, HttpServletRequest request) {
        boolean isJsonRequest = CrowdUtil.isJsonRequest(request);
        logger.info("isJsonRequest = " + isJsonRequest);
        for (Integer integer : array) {
            System.out.println(integer);
        }
        int a = 10/0;
        return "target";
    }
}
