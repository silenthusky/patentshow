package repository;

import com.alibaba.fastjson.JSON;
import com.patentshow.repository.PatentRepository;
import org.junit.Test;
import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by unclexiao on 2018/1/9.
 */
public class RepositoryTest extends BaseJunit4Test{


    @Autowired
    private PatentRepository repository;

//    @Test
//    @Transactional
//    public void test1(){
//
//        Map<String,String>res = repository.getResearcher();
//
//        for(String key : res.keySet()){
//            System.out.println(key+"----"+res.get(key));
//        }
//
//    }
//
//    @Test
//    public void test(){
//        String s = "2013.03.13";
//        String t = "2015-6-6 00:28:04";
//        Pattern pattern =  Pattern.compile("[0-9]{4}\\.[0-9]{2}\\.[0-9]{2}");
//        System.out.println(pattern.matcher(s).matches());
//        System.out.println(pattern.matcher(t).matches());
//    }
//
//
//    @Test
//    public void test2(){
//        String s = "F16D55/224(2006.01)I;F16D65/18(2012.01)I;B23Q1/28(2006.01)I;F16D121/04(2012.01)N";
//
//        String[] ss = s.split(";");
//        for(String str : ss){
//            int index = str.indexOf("(");
//            System.out.println(index);
//            System.out.println(str.substring(0,index));
//        }
//    }
//
//
//    @Test
//    @Transactional
//    public void test3(){
//        Map<Object,Object> res = repository.getTypesNumByClassifyCode();
//        for(Object k : res.keySet()){
//            System.out.println(k.toString()+"--"+res.get(k));
//        }
//    }



//
//    @Test
//    @Transactional
//    public void test4(){
//        List<Map<String,Integer>> result = new ArrayList<Map<String, Integer>>();
//
////        //总数
////        Map<String,Integer> ss = repository.getTypesNumByClassifyCode();
////
////        //发明型
////        Map<String,Integer> res = repository.getPatentNumByType("发明专利");
////
////        //实用新型
////        Map<String,Integer> ress = repository.getPatentNumByType("实用新型");
//
//
//        System.out.println(ss.size());
//        System.out.println(res.size());
//        System.out.println(ress.size());
//
//    }



    @Test
    @Transactional
    public void test5(){
//        List queryRes = repository.getPatentNumByApplyDay();
//        System.out.println(queryRes.toString());

//        Map queryRes1 = repository.getPatentNumByApplySeason();
//        System.out.println(JSON.toJSON(queryRes1));

//        Map queryRes2 = repository.getPatentNumByApplyYear();
//        System.out.println(JSON.toJSON(queryRes2));

//        List queryRes3 = repository.getPatentNumByApplyDay();
//        System.out.println(JSON.toJSON(queryRes3));

//        List queryRes4 = repository.getPatentNumByPublicDay();
//        System.out.println(JSON.toJSON(queryRes4));
//
//        Map queryRes5 = repository.getPatentNumByPublicSeason();
//        System.out.println(JSON.toJSON(queryRes5));

//
//        Map queryRes6 = repository.getPatentNumByPublicYear();
//        System.out.println(JSON.toJSON(queryRes6));


//        Map queryRes7 = repository.getPatentTypeNum();
//        System.out.println(JSON.toJSON(queryRes7));


//        Map queryRes8 = repository.getResearcherNumByPublicSeason();
//        System.out.println(JSON.toJSON(queryRes8));
//
//        List queryRes9 = repository.getResearcherNumByPublicDay();
//        System.out.println(JSON.toJSON(queryRes9));

//        Map queryRes10 = repository.getPatentByTypeAndBigClassifyCode();
//        System.out.println(JSON.toJSON(queryRes10));

//        Map queryRes11 = repository.getPatentByTypeAndSmallClassifyCode();
//        System.out.println(JSON.toJSON(queryRes11));
//
//        Map queryRes12 = repository.getPatentByTypeAndBigClassifyCode(1990);
//        System.out.println(JSON.toJSON(queryRes12));



//        Map queryRes13 = repository.getPatentByTypeAndSmallClassifyCode(1990);
//        System.out.println(JSON.toJSON(queryRes13));


//
//        List queryRes13 = repository.getPatentNumByApplyDay();
//        System.out.println(JSON.toJSON(queryRes13));
//
//        List queryRes14 = repository.getPatentNumByPublicDay();
//        System.out.println(JSON.toJSON(queryRes14));

//        List queryRes15 = repository.getResearcherNumByPublicDay();
//        System.out.println(JSON.toJSON(queryRes15));


//        Map queryRes1 = repository.getPatentNumByApplySeason();
//        System.out.println(JSON.toJSON(queryRes1));
//
//        Map queryRes2 = repository.getPatentNumByApplyYear();
//        System.out.println(JSON.toJSON(queryRes2));
//
//        Map queryRes5 = repository.getPatentNumByPublicSeason();
//        System.out.println(JSON.toJSON(queryRes5));
////
//
//        Map queryRes6 = repository.getPatentNumByPublicYear();
//        System.out.println(JSON.toJSON(queryRes6));
//
//
        Map queryRes7 = repository.getPatentTypeNum();
        System.out.println(JSON.toJSON(queryRes7));
//
//
//        Map queryRes8 = repository.getResearcherNumByPublicSeason();
//        System.out.println(JSON.toJSON(queryRes8));
//
//
//        Map queryRes10 = repository.getPatentByTypeAndBigClassifyCode();
//        System.out.println(JSON.toJSON(queryRes10));
//
//        Map queryRes11 = repository.getPatentByTypeAndSmallClassifyCode();
//        System.out.println(JSON.toJSON(queryRes11));
//
//        Map queryRes12 = repository.getPatentByTypeAndBigClassifyCode(1990);
//        System.out.println(JSON.toJSON(queryRes12));


//        Map queryRes13 = repository.getPatentByTypeAndSmallClassifyCode(1990);
//        System.out.println(JSON.toJSON(queryRes13));


    }




}

