/*
 * Copyright (C), 2002-2015, �����׹������������޹�˾
 * FileName: UserMapper.java
 * Author:   Administrator
 * Date:     2015-1-12 ����9:52:51
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author>      <time>      <version>    <desc>
 * �޸�������             �޸�ʱ��            �汾��                  ����
 */
package org.dream.dao;

import org.dream.bean.UserBean;

/**
 * ���ݿ������
 *
 * @author Administrator
 * @see [�����/����]����ѡ��
 * @since [��Ʒ/ģ��汾] ����ѡ��
 */
public interface UserMapper {
    UserBean queryByUserId(int userId);
    int save(UserBean userBean);
}
