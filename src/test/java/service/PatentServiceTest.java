package service;

import com.patentshow.service.PatentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import repository.BaseJunit4Test;

import javax.transaction.Transactional;
import java.util.Map;

/**
 * Created by unclexiao on 2018/1/9.
 */
public class PatentServiceTest extends BaseJunit4Test{
    @Autowired
    private PatentService patentService;

//    @Test
//    @Transactional
//    public void test1(){
//       Map<String,Object> res = patentService.getAllPatentsNumByApplyDate();
//       if((Integer)res.get("code") == 0){
//           System.out.println(res.get("result"));
//       }
//        System.out.println(res.get("message"));
//    }
}
