package com.patentshow.controller;


import com.patentshow.service.PatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by unclexiao on 2018/1/9.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/statistics", produces = "application/json;charset=UTF-8")
public class PatentController {
    @Autowired
    private PatentService patentService;


//******重写*****

    @RequestMapping(value = "/patent/applyyear", method = RequestMethod.GET)
    public Map<String, Object> getPatentNumByApplyYear() {
        return patentService.getPatentNumByApplyYear();
    }

    @RequestMapping(value = "/patent/applyseason", method = RequestMethod.GET)
    public Map<String, Object> getPatentNumByApplySeason() {
        return patentService.getPatentNumByApplySeason();
    }

    @RequestMapping(value = "/patent/applydate", method = RequestMethod.GET)
    public Map<String, Object> getPatentNumByApplyDay() {
        return patentService.getPatentNumByApplyDay();
    }

    @RequestMapping(value = "/patent/publicyear", method = RequestMethod.GET)
    public Map<String, Object> getPatentNumByPublicYear() {
        return patentService.getPatentNumByPublicYear();
    }

    @RequestMapping(value = "/patent/publicseason", method = RequestMethod.GET)
    public Map<String, Object> getPatentNumByPublicSeason() {
        return patentService.getPatentNumByPubliceason();
    }

    @RequestMapping(value = "/patent/publicdate", method = RequestMethod.GET)
    public Map<String, Object> getPatentNumByPublicDay() {
        return patentService.getPatentNumByPublicDay();
    }


    @RequestMapping(value = "/patent/type", method = RequestMethod.GET)
    public Map<String, Object> getPatentNumByType() {
        return patentService.getPatentTypeNum();
    }


    @RequestMapping(value = "/researchers/publicdate", method = RequestMethod.GET)
    public Map<String, Object> getResearcherNumByPublicDay() {
        return patentService.getResearcherNumByPublicDay();
    }

    @RequestMapping(value = "/researchers/publicseason", method = RequestMethod.GET)
    public Map<String, Object> getResearcherNumByPublicSeason() {
        return patentService.getResearcherNumByPublicSeason();
    }

    @RequestMapping(value = "/patent/classifycode/big/type", method = RequestMethod.GET)
    public Map<String, Object> getPatentByTypeAndBigClassifyCode() {
        return patentService.getPatentByTypeAndBigClassifyCode();
    }


    @RequestMapping(value = "/patent/classifycode/small/type", method = RequestMethod.GET)
    public Map<String, Object> getPatentByTypeAndSmallClassifyCode() {
        return patentService.getPatentByTypeAndSmallClassifyCode();
    }



    @RequestMapping(value = "/patent/classifycode/big/type/{year}",method = RequestMethod.GET)
    public Map<String,Object> getPatentByTypeAndBigClassifyCode(@PathVariable("year") int year){
        return patentService.getPatentByTypeAndSmallClassifyCode(year);
    }


    @RequestMapping(value = "/patent/classifycode/small/type/{year}",method = RequestMethod.GET)
    public Map<String,Object> getPatentByTypeAndSmallClassifyCode(@PathVariable("year") int year){
        return patentService.getPatentByTypeAndSmallClassifyCode(year);
    }


}
