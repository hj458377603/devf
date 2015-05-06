package org.dream.bean.res;

/**
 * 资源类型
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum ResType {
    Text(1), Image(2);

    // 成员变量
    private int value;

    // 构造方法
    private ResType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
