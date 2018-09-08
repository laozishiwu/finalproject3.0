package com.baizhi.controller;

import com.baizhi.entity.City;
import com.baizhi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping("/addCity.do")
    @ResponseBody
    public String addCity(City city) {
        cityService.addCity(city);
        return "redirect:/city/findAll.do";
    }

    @RequestMapping("/deleteCity.do")
    @ResponseBody
    public Integer deleteCity(Integer id) {
        cityService.removeCity(id);
        //return "redirect:/city/findAll.do";
        return id;
    }

    @RequestMapping("/modifyCity.do")
    //@ResponseBody
    public String modifyCity(City city) {
        cityService.modifyCity(city);
        System.out.println(city + "===================");
        //return "redirect:/city/findByPage.do";
        return "redirect:/city/findAll.do";
    }

    @RequestMapping("/findCityByname.do")
    @ResponseBody
    public City findCityByname(HttpSession model, String name) {
        City emp = cityService.findCityByname(name);
        model.setAttribute("employee", emp);
        return emp;
    }

    @RequestMapping("/findCity.do")
    public String findCity(Model model, Integer id) {
        City emp = cityService.findCity(id);
        model.addAttribute("employee", emp);
        //return "redirect:/city/modifyCity.do";
        return "other/update";
    }

    @ResponseBody
    @RequestMapping("/findAll.do")
    public List<City> findAll(Model model, City city) {
        List<City> list = cityService.findAll();
        model.addAttribute("employee", list);
        for (City emp : list) {
            System.out.println(emp);
        }
        return list;
        //return "other/city";


    }

    @RequestMapping("/findLikename.do")
    //@ResponseBody
    public String findLikename(String name) {
        City city = cityService.findLikename(name);
        System.out.println(city);
        return "redirect:/city/findAll.do";
    }

    //批量删除
	/*private int[] ids;
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}*/
    @RequestMapping("/modifyremoveBachAcc.do")
    @ResponseBody
    public String modifyremoveBachAcc(int[] ids) {
        System.out.println("%%%%%%%%%%%%%%%%%%%%" + ids);
        cityService.removeBachAcc(ids);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^" + ids);
        return "redirect:/city/findAll.do";
    }

    @RequestMapping("/findByPage.do")
    @ResponseBody
    public Map<String, Object> findByPage(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<String, Object>();
        //总跳数：total
        int total = 0;
        List<City> totals = cityService.findAll();
        for (City city : totals) {
            total++;
            System.out.println(city);
        }
        //当前页数：rows
        List<City> emps = cityService.findBypage(page, rows);
        System.out.println(page + "&&&&&&&&&&&&&&&&" + rows);
        map.put("total", total);
        map.put("rows", emps);
        System.out.println(map);
        return map;
    }
}















