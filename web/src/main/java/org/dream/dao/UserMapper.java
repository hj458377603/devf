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
