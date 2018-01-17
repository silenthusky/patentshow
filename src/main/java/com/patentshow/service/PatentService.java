package com.patentshow.service;

import java.util.List;
import java.util.Map;

/**
 * Created by unclexiao on 2018/1/9.
 */
public interface PatentService {


    //*********重写****
    Map<String, Object> getPatentNumByApplyYear();

    Map<String, Object> getPatentNumByApplySeason();

    Map<String, Object> getPatentNumByApplyDay();


    Map<String, Object> getPatentNumByPublicYear();

    Map<String, Object> getPatentNumByPubliceason();

    Map<String, Object> getPatentNumByPublicDay();


    Map<String, Object> getPatentTypeNum();


    Map<String, Object> getPatentByTypeAndBigClassifyCode();

    Map<String, Object> getPatentByTypeAndSmallClassifyCode();

    Map<String, Object> getPatentByTypeAndBigClassifyCode(int year);

    Map<String, Object> getPatentByTypeAndSmallClassifyCode(int year);


    Map<String, Object> getResearcherNumByPublicDay();

    Map<String, Object> getResearcherNumByPublicSeason();

}
