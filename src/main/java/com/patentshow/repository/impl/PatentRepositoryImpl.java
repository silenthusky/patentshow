package com.patentshow.repository.impl;


import com.patentshow.repository.PatentRepository;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author unclexiao
 * @date 2018/1/9
 */
@Repository
public class PatentRepositoryImpl implements PatentRepository {


    private static final Pattern pattern = Pattern.compile("[0-9]{4}\\.[0-9]{2}\\.[0-9]{2}");

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    /**
     * 抽象公用方法
     *
     * @param sql
     * @param alias1
     * @param alias2
     * @return
     */
    public List getListBySql(String sql, String alias1, String alias2) {

        List<Object[]> queryRes = getCurrentSession().createSQLQuery(sql)
                .addScalar(alias1, StandardBasicTypes.STRING)
                .addScalar(alias2, StandardBasicTypes.INTEGER)
                .setCacheable(true)
                .list();

        if (queryRes == null || queryRes.size() == 0) {
            return null;
        }

        List<Map<Object, Object>> res = new ArrayList<Map<Object, Object>>();
        for (Object[] objects : queryRes) {
            Map<Object, Object> item = new HashMap<Object, Object>();
            if (objects[0] != null) {
                item.put(objects[0], objects[1]);
                res.add(item);
            }
        }
        return res;
    }

    public Map getMapBySql(String sql, String alias1, String alias2, String alias3, Object[] params) {
        SQLQuery query = getCurrentSession().createSQLQuery(sql)
                .addScalar(alias1, StandardBasicTypes.STRING)
                .addScalar(alias2, StandardBasicTypes.STRING)
                .addScalar(alias3, StandardBasicTypes.INTEGER);

        for (int i = 0; i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
        List<Object[]> queryRes = query
                .setCacheable(true)
                .list();
        if (queryRes == null || queryRes.size() == 0) {
            return null;
        }

        Map<Object, Object> res = new HashMap<Object, Object>();

        for (Object[] objects : queryRes) {
            //判断年分是否已经存在
            if (!res.containsKey(objects[0])) {
                Map<Object, Object> item = new HashMap<Object, Object>(3);
                item.put(objects[1], objects[2]);
                List<Map<Object, Object>> items = new ArrayList<Map<Object, Object>>();
                items.add(item);

                res.put(objects[0], items);
            } else {
                //如果年份已经存在
                List<Map<Object, Object>> items = (List<Map<Object, Object>>) res.get(objects[0]);

                Map<Object, Object> item = new HashMap<Object, Object>(3);
                item.put(objects[1], objects[2]);
                items.add(item);

                res.put(objects[0], items);
            }

        }
        return res;

    }

    public Map getMapBySql(String sql, String alias1, String alias2, String alias3) {

        List<Object[]> queryRes = getCurrentSession().createSQLQuery(sql)
                .addScalar(alias1, StandardBasicTypes.STRING)
                .addScalar(alias2, StandardBasicTypes.STRING)
                .addScalar(alias3, StandardBasicTypes.INTEGER)
                .setCacheable(true)
                .list();

        if (queryRes == null || queryRes.size() == 0) {
            return null;
        }

        Map<Object, Object> res = new HashMap<Object, Object>();

        for (Object[] objects : queryRes) {
            //判断年分是否已经存在
            if (!res.containsKey(objects[0])) {
                Map<Object, Object> item = new HashMap<Object, Object>(3);
                item.put(objects[1], objects[2]);
                List<Map<Object, Object>> items = new ArrayList<Map<Object, Object>>();
                items.add(item);

                res.put(objects[0], items);
            } else {
                //如果年份已经存在
                List<Map<Object, Object>> items = (List<Map<Object, Object>>) res.get(objects[0]);

                Map<Object, Object> item = new HashMap<Object, Object>(3);
                item.put(objects[1], objects[2]);
                items.add(item);

                res.put(objects[0], items);
            }

        }
        return res;
    }

    public List getPatentNumByApplyDay() {

//        String sql = "select t_date.pdate as applyDate ,count(a.applyDateId) as patentNum from (select distinct(apply_number) as applyNumber , patent.apply_date_id as applyDateId from patent) a,t_date where t_date.id=a.applyDateId group by a.applyDateId";
        String sql = "select distinct(apply_number),t_date.pdate as applyDate ,count(t_date.id) as patentNum from patent ,t_date where  patent.apply_date_id=t_date.id  group by  patent.apply_date_id";
//        List<Object[]> queryRes = getCurrentSession().createSQLQuery(sql)
//                .addScalar("applyDate", StandardBasicTypes.STRING)
//                .addScalar("patentNum",StandardBasicTypes.INTEGER)
//                .list();
//
//        if(queryRes ==null || queryRes.size()==0){
//            return null;
//        }
//
//        List<Map<Object,Object>> res = new ArrayList<Map<Object,Object>>();
//        for(Object[] objects : queryRes){
//            Map<Object,Object> item = new HashMap<Object, Object>();
//            if(objects[0]!=null){
//                item.put(objects[0],objects[1]);
//                res.add(item);
//            }
//        }
//        return res;
        return getListBySql(sql, "applyDate", "patentNum");
    }

    public Map getPatentNumByApplySeason() {
      //  String sql = "select t_date.year as applyYear ,t_date.season as applySeason,count(t_date.season) as patentNum from (select distinct(apply_number) as applyNumber , patent.apply_date_id as applyDateId from patent) a,t_date where t_date.id=a.applyDateId group by t_date.year, t_date.season";
       String sql ="select distinct(apply_number),t_date.year as applyYear,t_date.season as applySeason,count(t_date.id) as patentNum from patent ,t_date where  patent.apply_date_id=t_date.id  group by t_date.year, t_date.season";
        return getMapBySql(sql, "applyYear", "applySeason", "patentNum");
//        List<Object[]> queryRes = getCurrentSession().createSQLQuery(sql)
//                .addScalar("applyYear", StandardBasicTypes.STRING)
//                .addScalar("applySeason",StandardBasicTypes.STRING)
//                .addScalar("patentNum",StandardBasicTypes.INTEGER)
//                .list();
//
//        if(queryRes ==null || queryRes.size()==0){
//            return null;
//        }
//
//        Map<Object,Object> res = new HashMap<Object, Object>();
//
//        for(Object[] objects : queryRes){
//            //判断年分是否已经存在
//            if(!res.containsKey(objects[0])){
//                Map<Object,Object> item = new HashMap<Object, Object>(3);
//                item.put(objects[1],objects[2]);
//                List<Map<Object,Object>> items = new ArrayList<Map<Object, Object>>();
//                items.add(item);
//
//                res.put(objects[0],items);
//            }else{
//                //如果年份已经存在
//                List<Map<Object,Object>> items = (List<Map<Object, Object>>) res.get(objects[0]);
//
//                Map<Object,Object> item = new HashMap<Object, Object>(3);
//                item.put(objects[1],objects[2]);
//                items.add(item);
//
//                res.put(objects[0],items);
//            }
//
//        }
//        return res;
    }

    public Map getPatentNumByApplyYear() {
        Map<Object, Object> queryRes = getPatentNumByApplySeason();

        if (queryRes == null) {
            return null;
        }

        Map<Object, Object> res = new HashMap<Object, Object>();
        for (Object key : queryRes.keySet()) {
            List<Map<Object, Object>> items = (List<Map<Object, Object>>) queryRes.get(key);
            //将得到一年所有季度的数据累加
            int patentNum = 0;
            for (Map<Object, Object> item : items) {
                for (Object k : item.keySet()) {
                    patentNum += (Integer) item.get(k);
                }
            }
            res.put(key, patentNum);
        }

        return res;
    }

    public List getPatentNumByPublicDay() {

        //String sql = "select t_date.pdate as publicDate,count(a.dateId) as patentNum from (select distinct(apply_number) as applyNumber , patent.publicity_date_id as dateId from patent) a,t_date where t_date.id=a.dateId group by  t_date.id order by t_date.pdate desc";
        String sql = "select distinct(apply_number),t_date.pdate as publicDate,count(t_date.id) as patentNum from patent ,t_date where  patent.publicity_date_id=t_date.id  group by  patent.publicity_date_id";
        return getListBySql(sql, "publicDate", "patentNum");
//        List<Object[]> queryRes = getCurrentSession().createSQLQuery(sql)
//                .addScalar("publicDate", StandardBasicTypes.STRING)
//                .addScalar("patentNum",StandardBasicTypes.INTEGER)
//                .list();
//
//        if(queryRes ==null || queryRes.size()==0){
//            return null;
//        }
//
//        List<Map<Object,Object>> res = new ArrayList<Map<Object,Object>>();
//        for(Object[] objects : queryRes){
//            Map<Object,Object> item = new HashMap<Object, Object>();
//            if(objects[0]!=null){
//                item.put(objects[0],objects[1]);
//                res.add(item);
//            }
//        }
//        return res;
    }

    public Map getPatentNumByPublicSeason() {

      //  String sql = "select t_date.year as publicYear,t_date.season as publicSeason,count(t_date.season) as patentNum from (select distinct(apply_number) as applyNumber , patent.publicity_date_id as dateId from patent) a,t_date where t_date.id=a.dateId group by t_date.year, t_date.season order by t_date.year desc";
        String sql = "select distinct(apply_number),t_date.year as publicYear,t_date.season as publicSeason,count(t_date.id) as patentNum from patent ,t_date where  patent.publicity_date_id=t_date.id  group by t_date.year, t_date.season";
        return getMapBySql(sql, "publicYear", "publicSeason", "patentNum");
//        List<Object[]> queryRes = getCurrentSession().createSQLQuery(sql)
//                .addScalar("publicYear", StandardBasicTypes.STRING)
//                .addScalar("publicSeason",StandardBasicTypes.STRING)
//                .addScalar("patentNum",StandardBasicTypes.INTEGER)
//                .list();
//
//        if(queryRes ==null || queryRes.size()==0){
//            return null;
//        }
//
//        Map<Object,Object> res = new HashMap<Object, Object>();
//
//        for(Object[] objects : queryRes){
//            //判断年分是否已经存在
//            if(!res.containsKey(objects[0])){
//                Map<Object,Object> item = new HashMap<Object, Object>(3);
//                item.put(objects[1],objects[2]);
//                List<Map<Object,Object>> items = new ArrayList<Map<Object, Object>>();
//                items.add(item);
//
//                res.put(objects[0],items);
//            }else{
//                //如果年份已经存在
//                List<Map<Object,Object>> items = (List<Map<Object, Object>>) res.get(objects[0]);
//
//                Map<Object,Object> item = new HashMap<Object, Object>(3);
//                item.put(objects[1],objects[2]);
//                items.add(item);
//
//                res.put(objects[0],items);
//            }
//
//        }
//        return res;
    }

    public Map getPatentNumByPublicYear() {
        Map<Object, Object> queryRes = getPatentNumByPublicSeason();
        if (queryRes == null) {
            return null;
        }
        Map<Object, Object> res = new HashMap<Object, Object>();
        for (Object key : queryRes.keySet()) {
            List<Map<Object, Object>> items = (List<Map<Object, Object>>) queryRes.get(key);
            //将得到一年所有季度的数据累加
            int patentNum = 0;
            for (Map<Object, Object> item : items) {
                for (Object k : item.keySet()) {
                    patentNum += (Integer) item.get(k);
                }
            }
            res.put(key, patentNum);
        }

        return res;
    }

    public Map getPatentTypeNum() {
        //String sql = "select a.type as patentType,count(*) as patentnum from (select distinct(apply_number) as applyNumber,type from patent )a where a.type in (1,2,3) group by a.type";
        String sql = "select  distinct type as patentType,count(apply_number) as patentnum from  patent where type =1 or type =2 or type =3 group by type";

        List<Object[]> queryRes = getCurrentSession().createSQLQuery(sql)
                .addScalar("patentType", StandardBasicTypes.STRING)
                .addScalar("patentnum", StandardBasicTypes.INTEGER)
                .setCacheable(true)
                .list();

        if (queryRes == null || queryRes.size() == 0) {
            return null;
        }

        Map<Object, Object> res = new HashMap<Object, Object>();

        for (Object[] objects : queryRes) {
            res.put(objects[0], objects[1]);
        }

        return res;
    }

    public List getResearcherNumByPublicDay() {

        //String sql = "select t_date.pdate as publicDate,sum(a.invente_man_num) as researcherNum from(select distinct(apply_number) as applyNumber,patent.invente_man_num,patent.publicity_date_id from patent )a,t_date  where a.publicity_date_id=t_date.id  group by a.publicity_date_id";
        String sql = "select t_date.pdate as publicDate,sum(patent.invente_man_num) as researcherNum  from patent ,t_date where  patent.publicity_date_id=t_date.id  group by  patent.apply_date_id";
        return getListBySql(sql, "publicDate", "researcherNum");
//        List<Object[]> queryRes = getCurrentSession().createSQLQuery(sql)
//                .addScalar("publicDate", StandardBasicTypes.STRING)
//                .addScalar("researcherNum",StandardBasicTypes.INTEGER)
//                .list();
//
//        if(queryRes ==null || queryRes.size()==0){
//            return null;
//        }
//
//        List<Map<Object,Object>> res = new ArrayList<Map<Object,Object>>();
//        for(Object[] objects : queryRes){
//            Map<Object,Object> item = new HashMap<Object, Object>();
//            if(objects[0]!=null){
//                item.put(objects[0],objects[1]);
//                res.add(item);
//            }
//        }
//        return res;
    }

    public Map getResearcherNumByPublicSeason() {
        //String sql = "select t_date.year as publicYear,t_date.season as publicSeason, sum(a.invente_man_num) as researcherNum from (select distinct(apply_number),invente_man_num,publicity_date_id from patent ) a,t_date where a.publicity_date_id = t_date.id  group by t_date.year, t_date.season";
        String sql = "select t_date.year as publicYear ,t_date.season as publicSeason,sum(patent.invente_man_num)  as researcherNum from patent ,t_date where  patent.publicity_date_id=t_date.id  group by  t_date.year,t_date.season";
        return getMapBySql(sql, "publicYear", "publicSeason", "researcherNum");
//        List<Object[]> queryRes = getCurrentSession().createSQLQuery(sql)
//                .addScalar("publicYear", StandardBasicTypes.STRING)
//                .addScalar("publicSeason",StandardBasicTypes.STRING)
//                .addScalar("researcherNum",StandardBasicTypes.INTEGER)
//                .list();
//
//        if(queryRes ==null || queryRes.size()==0){
//            return null;
//        }
//
//        Map<Object,Object> res = new HashMap<Object, Object>();
//
//        for(Object[] objects : queryRes){
//            //判断年分是否已经存在
//            if(!res.containsKey(objects[0])){
//                Map<Object,Object> item = new HashMap<Object, Object>(3);
//                item.put(objects[1],objects[2]);
//                List<Map<Object,Object>> items = new ArrayList<Map<Object, Object>>();
//                items.add(item);
//
//                res.put(objects[0],items);
//            }else{
//                //如果年份已经存在
//                List<Map<Object,Object>> items = (List<Map<Object, Object>>) res.get(objects[0]);
//
//                Map<Object,Object> item = new HashMap<Object, Object>(3);
//                item.put(objects[1],objects[2]);
//                items.add(item);
//
//                res.put(objects[0],items);
//            }
//
//        }
//        return res;
    }

    public Map getPatentByTypeAndBigClassifyCode() {

        String sql = "select patent.classify_code_big as classifyCodeBig,patent.type as patentType,count(patent.type) as patentNum from patent where patent.classify_code_big!=\"\" group by patent.classify_code_big,patent.type";

        return getMapBySql(sql, "classifyCodeBig", "patentType", "patentNum");


//        List<Object[]> queryRes = getCurrentSession().createSQLQuery(sql)
//                .addScalar("classifyCodeBig", StandardBasicTypes.STRING)
//                .addScalar("patentType",StandardBasicTypes.STRING)
//                .addScalar("patentNum",StandardBasicTypes.INTEGER)
//                .list();
//
//        if(queryRes ==null || queryRes.size()==0){
//            return null;
//        }
//
//        Map<Object,Object> res = new HashMap<Object, Object>();
//
//        for(Object[] objects : queryRes){
//            //判断分类号是否已经存在
//            if(!res.containsKey(objects[0])){
//                Map<Object,Object> item = new HashMap<Object, Object>(3);
//                item.put(objects[1],objects[2]);
//                List<Map<Object,Object>> items = new ArrayList<Map<Object, Object>>();
//                items.add(item);
//
//                res.put(objects[0],items);
//            }else{
//                //如果分类号已经存在
//                List<Map<Object,Object>> items = (List<Map<Object, Object>>) res.get(objects[0]);
//
//                Map<Object,Object> item = new HashMap<Object, Object>(3);
//                item.put(objects[1],objects[2]);
//                items.add(item);
//
//                res.put(objects[0],items);
//            }
//
//        }
//        return res;
    }

    public Map getPatentByTypeAndSmallClassifyCode() {
        String sql = "select patent.classify_code_small as classifyCodeSmall,patent.type as patentType,count(patent.type) as patentNum from patent where patent.classify_code_small !=\"\"  group by patent.classify_code_small,patent.type";
        return getMapBySql(sql, "classifyCodeSmall", "patentType", "patentNum");
//        List<Object[]> queryRes = getCurrentSession().createSQLQuery(sql)
//                .addScalar("classifyCodeSmall", StandardBasicTypes.STRING)
//                .addScalar("patentType",StandardBasicTypes.STRING)
//                .addScalar("patentNum",StandardBasicTypes.INTEGER)
//                .list();
//
//        if(queryRes ==null || queryRes.size()==0){
//            return null;
//        }
//
//        Map<Object,Object> res = new HashMap<Object, Object>();
//
//        for(Object[] objects : queryRes){
//            //判断分类号是否已经存在
//            if(!res.containsKey(objects[0])){
//                Map<Object,Object> item = new HashMap<Object, Object>(3);
//                item.put(objects[1],objects[2]);
//                List<Map<Object,Object>> items = new ArrayList<Map<Object, Object>>();
//                items.add(item);
//
//                res.put(objects[0],items);
//            }else{
//                //如果分类号已经存在
//                List<Map<Object,Object>> items = (List<Map<Object, Object>>) res.get(objects[0]);
//
//                Map<Object,Object> item = new HashMap<Object, Object>(3);
//                item.put(objects[1],objects[2]);
//                items.add(item);
//
//                res.put(objects[0],items);
//            }
//
//        }
//        return res;
    }

    public Map getPatentByTypeAndBigClassifyCode(int year) {
        String sql = "select patent.classify_code_big as classifyCodeBig,patent.type as patentType,count(patent.type) as patentNum from patent,t_date where patent.classify_code_big!=\"\" and t_date.id = patent.publicity_date_id group by patent.classify_code_big,patent.type ";
        return getMapBySql(sql, "classifyCodeBig", "patentType", "patentNum", new Object[]{year});
//        List<Object[]> queryRes = getCurrentSession().createSQLQuery(sql)
//                .addScalar("classifyCodeBig", StandardBasicTypes.STRING)
//                .addScalar("patentType",StandardBasicTypes.STRING)
//                .addScalar("patentNum",StandardBasicTypes.INTEGER)
//                .setParameter(0,year)
//                .list();
//
//        if(queryRes ==null || queryRes.size()==0){
//            return null;
//        }
//
//        Map<Object,Object> res = new HashMap<Object, Object>();
//
//        for(Object[] objects : queryRes){
//            //判断分类号是否已经存在
//            if(!res.containsKey(objects[0])){
//                Map<Object,Object> item = new HashMap<Object, Object>(3);
//                item.put(objects[1],objects[2]);
//                List<Map<Object,Object>> items = new ArrayList<Map<Object, Object>>();
//                items.add(item);
//
//                res.put(objects[0],items);
//            }else{
//                //如果分类号已经存在
//                List<Map<Object,Object>> items = (List<Map<Object, Object>>) res.get(objects[0]);
//
//                Map<Object,Object> item = new HashMap<Object, Object>(3);
//                item.put(objects[1],objects[2]);
//                items.add(item);
//
//                res.put(objects[0],items);
//            }
//
//        }
//        return res;
    }

    public Map getPatentByTypeAndSmallClassifyCode(int year) {
        String sql = "select patent.classify_code_small as classifyCodeSmall,patent.type as patentType,count(patent.type) as patentNum from patent,t_date where patent.classify_code_small!= \"\" and t_date.year=? and  t_date.id = patent.publicity_date_id group by  patent.classify_code_small,patent.type";
        return getMapBySql(sql, "classifyCodeSmall", "patentType", "patentNum", new Object[]{year});

//        List<Object[]> queryRes = getCurrentSession().createSQLQuery(sql)
//                .addScalar("classifyCodeSmall", StandardBasicTypes.STRING)
//                .addScalar("patentType",StandardBasicTypes.STRING)
//                .addScalar("patentNum",StandardBasicTypes.INTEGER)
//                .setParameter(0,year)
//                .list();
//
//        if(queryRes ==null || queryRes.size()==0){
//            return null;
//        }
//
//        Map<Object,Object> res = new HashMap<Object, Object>();
//
//        for(Object[] objects : queryRes){
//            //判断分类号是否已经存在
//            if(!res.containsKey(objects[0])){
//                Map<Object,Object> item = new HashMap<Object, Object>(3);
//                item.put(objects[1],objects[2]);
//                List<Map<Object,Object>> items = new ArrayList<Map<Object, Object>>();
//                items.add(item);
//
//                res.put(objects[0],items);
//            }else{
//                //如果分类号已经存在
//                List<Map<Object,Object>> items = (List<Map<Object, Object>>) res.get(objects[0]);
//
//                Map<Object,Object> item = new HashMap<Object, Object>(3);
//                item.put(objects[1],objects[2]);
//                items.add(item);
//
//                res.put(objects[0],items);
//            }
//
//        }
//        return res;
    }

}
