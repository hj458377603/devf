package org.dream.service;

import java.util.List;

import org.dream.bean.AppBean;
import org.dream.dao.AppMapper;
import org.dream.intf.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author Administrator
 * @see [�����/����]����ѡ��
 * @since [��Ʒ/ģ��汾] ����ѡ��
 */
@Service
public class AppServiceImpl implements AppService {
    @Autowired
    AppMapper appMapper;
    
    public List<AppBean> queryAllAppBeans() {
        return appMapper.queryAllAppList();
    }

}
