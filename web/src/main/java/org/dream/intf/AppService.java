package org.dream.intf;

import java.util.List;

import org.dream.bean.AppBean;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author Administrator
 * @see [�����/����]����ѡ��
 * @since [��Ʒ/ģ��汾] ����ѡ��
 */
public interface AppService {
    List<AppBean> queryAllAppBeans();
}
