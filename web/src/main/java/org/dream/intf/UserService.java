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
