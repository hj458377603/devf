import java.util.List;

import org.dream.bean.res.CommonRes;
import org.dream.intf.res.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations = { "classpath:conf/mybatis-config.xml",
        "classpath:conf/spring/spring-bean.xml", "classpath:conf/spring/spring-servlet.xml" })
public class TestUnit extends AbstractTestNGSpringContextTests {
    @Autowired
    ResService resService;

    @Test
    public void test1() {
        List<CommonRes> res = resService.queryMyRes("458377603@qq.com");
        System.out.println(res);
    }
}
