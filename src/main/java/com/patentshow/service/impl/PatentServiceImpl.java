package com.patentshow.service.impl;

import com.patentshow.common.constant.BaseConstant;
import com.patentshow.common.error.ShouldBeEqualException;
import com.patentshow.common.error.ShouldNotBeLessException;
import com.patentshow.repository.PatentRepository;
import com.patentshow.service.PatentService;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.*;

/**
 * Created by unclexiao on 2018/1/9.
 */
@Service
@Transactional
public class PatentServiceImpl implements PatentService {

    @Autowired
    private PatentRepository patentRepository;


    public Map<String, Object> getPatentNumByApplyYear() {
        Map<String, Object> result = new HashMap<String, Object>();
        Map queryRes = patentRepository.getPatentNumByApplyYear();
        if (queryRes == null) {
            result.put("result", "");
            result.put("message", "list of patent's number by publicity date cannot be  null ");
            result.put("code", BaseConstant.NULLRETURN);
        }
        result.put("result", queryRes);
        result.put("message", "");
        result.put("code", BaseConstant.SUCCESS);

        return result;
    }

    public Map<String, Object> getPatentNumByApplySeason() {
        Map<String, Object> result = new HashMap<String, Object>();
        Map queryRes = patentRepository.getPatentNumByApplySeason();
        if (queryRes == null) {
            result.put("result", "");
            result.put("message", "list of patent's number by publicity date cannot be  null ");
            result.put("code", BaseConstant.NULLRETURN);
        }
        result.put("result", queryRes);
        result.put("message", "");
        result.put("code", BaseConstant.SUCCESS);

        return result;
    }

    public Map<String, Object> getPatentNumByApplyDay() {

        Map<String, Object> result = new HashMap<String, Object>();
        List queryRes = patentRepository.getPatentNumByApplyDay();
        if (queryRes == null) {
            result.put("result", "");
            result.put("message", "list of patent's number by publicity date cannot be  null ");
            result.put("code", BaseConstant.NULLRETURN);
        }
        result.put("result", queryRes);
        result.put("message", "");
        result.put("code", BaseConstant.SUCCESS);

        return result;
    }

    public Map<String, Object> getPatentNumByPublicYear() {
        Map<String, Object> result = new HashMap<String, Object>();
        Map queryRes = patentRepository.getPatentNumByPublicYear();
        if (queryRes == null) {
            result.put("result", "");
            result.put("message", "list of patent's number by publicity date cannot be  null ");
            result.put("code", BaseConstant.NULLRETURN);
        }
        result.put("result", queryRes);
        result.put("message", "");
        result.put("code", BaseConstant.SUCCESS);

        return result;
    }

    public Map<String, Object> getPatentNumByPubliceason() {
        Map<String, Object> result = new HashMap<String, Object>();
        Map queryRes = patentRepository.getPatentNumByPublicSeason();
        if (queryRes == null) {
            result.put("result", "");
            result.put("message", "list of patent's number by publicity date cannot be  null ");
            result.put("code", BaseConstant.NULLRETURN);
        }
        result.put("result", queryRes);
        result.put("message", "");
        result.put("code", BaseConstant.SUCCESS);

        return result;
    }

    public Map<String, Object> getPatentNumByPublicDay() {
        Map<String, Object> result = new HashMap<String, Object>();
        List queryRes = patentRepository.getPatentNumByPublicDay();
        if (queryRes == null) {
            result.put("result", "");
            result.put("message", "list of patent's number by publicity date cannot be  null ");
            result.put("code", BaseConstant.NULLRETURN);
        }
        result.put("result", queryRes);
        result.put("message", "");
        result.put("code", BaseConstant.SUCCESS);

        return result;
    }

    public Map<String, Object> getPatentTypeNum() {
        Map<String, Object> result = new HashMap<String, Object>();
        Map queryRes = patentRepository.getPatentTypeNum();
        if (queryRes == null) {
            result.put("result", "");
            result.put("message", "list of patent's number by publicity date cannot be  null ");
            result.put("code", BaseConstant.NULLRETURN);
        }
        result.put("result", queryRes);
        result.put("message", "");
        result.put("code", BaseConstant.SUCCESS);

        return result;
    }

    public Map<String, Object> getPatentByTypeAndBigClassifyCode() {
        Map<String, Object> result = new HashMap<String, Object>();
        Map queryRes = patentRepository.getPatentByTypeAndBigClassifyCode();
        if (queryRes == null) {
            result.put("result", "");
            result.put("message", "list of patent's number by publicity date cannot be  null ");
            result.put("code", BaseConstant.NULLRETURN);
        }
        result.put("result", queryRes);
        result.put("message", "");
        result.put("code", BaseConstant.SUCCESS);

        return result;
    }

    public Map<String, Object> getPatentByTypeAndSmallClassifyCode() {
        Map<String, Object> result = new HashMap<String, Object>();
        Map queryRes = patentRepository.getPatentByTypeAndSmallClassifyCode();
        if (queryRes == null) {
            result.put("result", "");
            result.put("message", "list of patent's number by publicity date cannot be  null ");
            result.put("code", BaseConstant.NULLRETURN);
        }
        result.put("result", queryRes);
        result.put("message", "");
        result.put("code", BaseConstant.SUCCESS);

        return result;
    }

    public Map<String, Object> getPatentByTypeAndBigClassifyCode(int year) {
        Map<String, Object> result = new HashMap<String, Object>();
        Map queryRes = patentRepository.getPatentByTypeAndBigClassifyCode(year);
        if (queryRes == null) {
            result.put("result", "");
            result.put("message", "list of patent's number by publicity date cannot be  null ");
            result.put("code", BaseConstant.NULLRETURN);
        }
        result.put("result", queryRes);
        result.put("message", "");
        result.put("code", BaseConstant.SUCCESS);

        return result;
    }

    public Map<String, Object> getPatentByTypeAndSmallClassifyCode(int year) {
        Map<String, Object> result = new HashMap<String, Object>();
        Map queryRes = patentRepository.getPatentByTypeAndSmallClassifyCode(year);
        if (queryRes == null) {
            result.put("result", "");
            result.put("message", "list of patent's number by publicity date cannot be  null ");
            result.put("code", BaseConstant.NULLRETURN);
        }
        result.put("result", queryRes);
        result.put("message", "");
        result.put("code", BaseConstant.SUCCESS);

        return result;
    }

    public Map<String, Object> getResearcherNumByPublicDay() {
        Map<String, Object> result = new HashMap<String, Object>();
        List queryRes = patentRepository.getResearcherNumByPublicDay();
        if (queryRes == null) {
            result.put("result", "");
            result.put("message", "list of patent's number by publicity date cannot be  null ");
            result.put("code", BaseConstant.NULLRETURN);
        }
        result.put("result", queryRes);
        result.put("message", "");
        result.put("code", BaseConstant.SUCCESS);

        return result;
    }

    public Map<String, Object> getResearcherNumByPublicSeason() {
        Map<String, Object> result = new HashMap<String, Object>();
        Map queryRes = patentRepository.getResearcherNumByPublicSeason();
        if (queryRes == null) {
            result.put("result", "");
            result.put("message", "list of patent's number by publicity date cannot be  null ");
            result.put("code", BaseConstant.NULLRETURN);
        }
        result.put("result", queryRes);
        result.put("message", "");
        result.put("code", BaseConstant.SUCCESS);

        return result;
    }

}
