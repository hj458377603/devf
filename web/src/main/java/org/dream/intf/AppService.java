/*
 * Copyright (C), 2002-2015, �����׹������������޹�˾
 * FileName: AppService.java
 * Author:   Administrator
 * Date:     2015-1-12 ����1:05:08
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author>      <time>      <version>    <desc>
 * �޸�������             �޸�ʱ��            �汾��                  ����
 */
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
