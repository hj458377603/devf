/*
 * Copyright (C), 2002-2015, �����׹������������޹�˾
 * FileName: HelloService.java
 * Author:   Administrator
 * Date:     2015-1-7 ����9:25:29
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author>      <time>      <version>    <desc>
 * �޸�������             �޸�ʱ��            �汾��                  ����
 */
package org.dream.intf;

import org.dream.bean.UserBean;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author Administrator
 * @see [�����/����]����ѡ��
 * @since [��Ʒ/ģ��汾] ����ѡ��
 */
public interface UserService {    
    UserBean queryByUserId(int userId);
    
    int save(UserBean userBean);
}
