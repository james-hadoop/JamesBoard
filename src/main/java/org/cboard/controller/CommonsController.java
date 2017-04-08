package org.cboard.controller;


import org.cboard.dto.DashboardMenu;
import org.cboard.dto.User;
import org.cboard.services.AdminSerivce;
import org.cboard.services.AuthenticationService;
import org.cboard.services.MenuService;
import org.cboard.services.ServiceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yfyuan on 2016/7/25.
 */
@RestController
@RequestMapping("/commons")
public class CommonsController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private AdminSerivce adminSerivce;

    @RequestMapping(value = "/getUserDetail")
    public User getUserDetail() {
        return authenticationService.getCurrentUser();
    }

    @RequestMapping(value = "/getMenuList")
    public List<DashboardMenu> getMenuList() {
        return menuService.getMenuList();
    }

    @RequestMapping(value = "/changePwd")
    public ServiceStatus changePwd(@RequestParam(name = "curPwd") String curPwd, @RequestParam(name = "newPwd") String newPwd, @RequestParam(name = "cfmPwd") String cfmPwd) {
        return adminSerivce.changePwd(authenticationService.getCurrentUser().getUserId(), curPwd, newPwd, cfmPwd);
    }
}
