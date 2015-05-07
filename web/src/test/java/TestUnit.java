import java.util.List;

import org.dream.bean.res.CommonRes;
import org.dream.bean.res.request.ResReq;
import org.dream.bean.response.ResultBean;
import org.dream.intf.res.ResService;
import org.dream.web.intf.res.ResEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations = { "classpath:conf/spring/spring-bean.xml",
        "classpath:conf/spring/spring-servlet.xml" })
public class TestUnit extends AbstractTestNGSpringContextTests {
    @Autowired
    ResService      resService;

    @Autowired
    ResEntryService resEntryService;

    public void test1() {
        List<CommonRes> res = resService.queryMyRes("1181526248@qq.com");
        System.out.println(res);
    }

    @Test
    public void publishImageRes() {
        ResReq resBeanReq = new ResReq();
        resBeanReq.setTxtContent("ceshi2");
        resBeanReq.setImageUrls("http://www.baidu.com,http://www.taobao.com");
        ResultBean<Object> obj = resEntryService.addImageRes(resBeanReq, 16);
        System.out.println(obj.toString());
    }
}
