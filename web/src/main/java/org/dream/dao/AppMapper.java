/*
 * Copyright (C), 2002-2015, �����׹������������޹�˾
 * FileName: AppMapper.java
 * Author:   Administrator
 * Date:     2015-1-12 ����1:02:00
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author>      <time>      <version>    <desc>
 * �޸�������             �޸�ʱ��            �汾��                  ����
 */
package org.dream.dao;

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
public interface AppMapper {
    List<AppBean> queryAllAppList();
}
