/*
 * Copyright (C), 2002-2015, �����׹������������޹�˾
 * FileName: HelloServiceImpl.java
 * Author:   Administrator
 * Date:     2015-1-7 ����9:26:13
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author>      <time>      <version>    <desc>
 * �޸�������             �޸�ʱ��            �汾��                  ����
 */
package org.dream.service;

import org.dream.bean.UserBean;
import org.dream.dao.UserMapper;
import org.dream.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ��һ�仰���ܼ�����<br>
 * ��������ϸ������
 * 
 * @author Administrator
 * @see [�����/����]����ѡ��
 * @since [��Ʒ/ģ��汾] ����ѡ��
 */
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public UserBean queryByUserId(int userId) {
        UserBean userBean = userMapper.queryByUserId(userId);
        return userBean;
    }

    public int save(UserBean userBean) {        
        return userMapper.save(userBean);
    }

}
