package dream.org.android001.bean.account;

import java.util.Date;

/**
 * Created by Administrator on 2015/4/26.
 */
public class Account {
    public int     id;

    public String  email;       // 用户名--email

    public String  nickName;    // 昵称

    public String  imgUrl;      // 头像图片地址

    public String  accessToken; // 临时访问令牌（有效期一个月）

    public boolean accountState; // 账户状态：0:未激活;1:正常（已激活）;2:禁用

    public Date    createTime;  // 创建时间

    public Date modifyTime;  // 最后修改时间
}
