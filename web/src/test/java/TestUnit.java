import org.dream.intf.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * Copyright (C), 2002-2015, �����׹������������޹�˾
 * FileName: Test.java
 * Author:   Administrator
 * Date:     2015-1-7 ����9:27:35
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author>      <time>      <version>    <desc>
 * �޸�������             �޸�ʱ��            �汾��                  ����
 */

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author Administrator
 * @see [�����/����]����ѡ��
 * @since [��Ʒ/ģ��汾] ����ѡ��
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
