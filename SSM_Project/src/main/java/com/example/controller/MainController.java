package com.example.controller;

import com.example.model.User;
import com.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/main")
@RestController()
public class MainController {
    @RequestMapping("/testMVC")
    @ResponseBody
    public Map<String, Object> testMVC() {
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("name", "martin");
        return responseMap;
    }

    @RequestMapping ( "/wildcard/{variable1}" )
    @ResponseBody
    public String testWildcard(@PathVariable String variable1) {
        System.out.println( "wildcard------------" );
        return variable1;
    }

    @RequestMapping ( "/requestParam" )
    @ResponseBody
    public String testRequestParam(@RequestParam String name) {
        return name;
    }

    @Autowired
    private RoleService roleService;

//    get all users
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> testSQL() {
        try {
            return roleService.getAllRoles();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//        get all users no hide
    @RequestMapping(value = "/getAllnohide", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getAllnohide() {
        try {
            return roleService.getAllRoles_Total();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    get specific user
    @RequestMapping(value = "/getUserById/{id}",method = RequestMethod.GET)
    public List<Map<String, Object>> getUser(@PathVariable("id") Integer id) {
        try {
            return roleService.findUser(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    delete specific user
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public List<Map<String,Object>> deleteUser(@PathVariable("id") Integer id) {
        try {
            roleService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return roleService.getAllRoles();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    add a new user
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public  List<Map<String, Object>> addUser(User user, Model model) {
        if (!roleService.getUserbyName(user).isEmpty()) {
            String str = "you cannot add a user with duplicated name";
            System.out.println("you cannot add a user with duplicated name");
            model.addAttribute("str", str);
            return null;
        } else {
            try {
                roleService.insert(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                return roleService.getAllRoles();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

//    update a existed user
    @RequestMapping(value = "/updateuser", method = RequestMethod.PUT)
    public  List<Map<String, Object>> updateUser(User user, Model model) {
        if (!roleService.getUserbyName(user).isEmpty()) {
            String str = "you cannot update a user with duplicated name";
            System.out.println("you cannot update a user with duplicated name");
            model.addAttribute("str", str);
            return null;
        } else {
            try {
                roleService.update(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                return roleService.getAllRoles();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

    }

//    delete a user in the way of tombstone
    @RequestMapping(value = "/tombstone", method = RequestMethod.GET)
    public List<Map<String, Object>> tombstone(User user, Model model) {
        try {
            roleService.tombstone(user);
            System.out.println("this user is marked in tombstone");
            String str = "this user is marked in tombstone";
            model.addAttribute("str", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return roleService.getAllRoles();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//       recover specific user
    @RequestMapping(value = "/recover", method = RequestMethod.GET)
    public List<Map<String,Object>> recoverTheUser(User user) {
        try {
            roleService.recoverUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return roleService.getAllRoles();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
