import org.dream.intf.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * Copyright (C), 2002-2015, 苏宁易购电子商务有限公司
 * FileName: Test.java
 * Author:   Administrator
 * Date:     2015-1-7 上午9:27:35
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TestUnit {
    @Autowired
    UserService helloService;
    
    @Test
    public void testHelloService(){
       // String helloString = helloService.sayHello("jack");
        //System.out.println(helloString);
    }
}
