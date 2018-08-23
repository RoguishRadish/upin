package com.common.constant;

/**
 * 全局静态资源：
 *
 */
public class Const {

    public static final String SESSION_SECURITY_CODE = "sessionSecCode";
    public static final String SESSION_MENULIST = "menuList";//当前菜单
    public static final int DONE_REGISTER_OK=2;//已经注册过
    public static final int NORMAL_PAGE_SIZE = 20;

    public static final int MIN_PAGE_SIZE = 5;
    
    public static final String SERVER_ERROR = "500";
    
    /**
     * 邮箱配置文件位置
     */
    public static final String EMAIL_CONFIG = "/mail.properties";
    /**
     * 微信配置文件位置
     */
    public static final String WEIXIN_CONFIG = "/weixin/mp.properties";
    /**
     * 上传配置文件位置
     */
    public static final String UPLOAD_CONFIG = "upload.properties";
    /**
     * 没有权限返回的URL
     */
    public static final String NO_AUTHORIZED_URL = "system/noAuthorized";//没有权限返回的URL
    /**
     * 没有权限返回中文说明
     */
    public static final String NO_AUTHORIZED_MSG = "当前角色没有权限";//
    /**
     * 返回值 没有权限 100
     */
    public static final int NO_AUTHORIZED = 100;
    /**
     * 返回值 成功(1)
     */
    public static final int SUCCEED = 1;
    /**
     * 返回值 失败(0)
     */
    public static final int FAIL = 0;
    /**
     * 菜单类型 (1)
     */
    public static final String RESOURCES_TYPE_MENU = "1";
    /**
     * 功能类型(2)
     */
    public static final String RESOURCES_TYPE_FUNCTION = "2";
    /**
     * 按钮类型(3)
     */
    public static final String RESOURCES_TYPE_BUTTON = "3";
    /**
     * 保存成功
     */
    public static final String SAVE_SUCCEED = "保存成功";
    /**
     * 保存失败
     */
    public static final String SAVE_FAIL = "保存失败";
    /**
     * 删除成功
     */
    public static final String DEL_SUCCEED = "删除成功";
    /**
     * 删除失败
     */
    public static final String DEL_FAIL = "删除失败";
    /**
     * 修改成功
     */
    public static final String UPDATE_SUCCEED = "修改成功";
    /**
     * 修改失败
     */
    public static final String UPDATE_FAIL = "修改失败";
    /**
     * 数据获取成功
     */
    public static final String DATA_SUCCEED = "数据获取成功";
    /**
     * 数据获取失败
     */
    public static final String DATA_FAIL = "数据获取失败";
    /**
     * 保存成功
     */
    public static final String SEND_SUCCEED = "发送成功";
    /**
     * 保存成功
     */
    public static final String SEND_FAIL = "发送失败";
    /**
     * 办理成功
     */
    public static final String PROCESS_SUCCEED = "办理成功";
    /**
     * 办理失败
     */
    public static final String PROCESS_FAIL = "办理失败";
    /**
     * 发布成功
     */
    public static final String PUBLISH_SUCCEED = "发布成功";
    /**
     * 发布失败
     */
    public static final String PUBLISH_FAIL = "发布失败";

    /**
     * 更新Email配置成功
     */
    public static final String SAVE_EMAIL_SETTING_SUCCEED = "更新EMAIL配置成功";

    /**
     * 更新微信配置成功
     */
    public static final String SAVE_WEXIN_SETTING_SUCCEED = "更新微信配置成功";

    /**
     * 密码不正确
     */
    public static final String WRONG_PASSWD = "密码不正确";
    /**
     * 两次密码不一致
     */
    public static final String INCONSISTENT_PASSWD = "两次密码不一致";

    /**
     * 登录名已存在
     */
    public static final String EXISTED_LOGINNAME = "登录名已存在或无效";

    /**
     * 已有重复文件夹名称
     */
    public static final String SAVE_FAILED_DUP_DIR_NAME = "已有重复文件夹名称";

    /**
     * 请先删除文件夹下文件
     */
    public static final String DELETE_FAILED_DIR_NOT_EMPTY = "请先删除文件夹下文件";

    public static final String ENCODING = "UTF-8";

    /**
     * activiti begin *
     */
    public static final String DEFAULT_APPLICANT_KEY = "applicant";

    public static final String DEFAULT_POS_TYPE_KEY = "posType";

    public static final String DEFAULT_IS_CHIEF_PRESIDENT_KEY = "isChiefPrsdt";

    public static final String DEFAULT_ORG_ID_KEY = "orgId";

    public static final String DEFAULT_APPROVER_KEY = "approver";

    public static final String DEFAULT_AUDIT_KEY = "auditPass";

    /**
     * 状态有效1
     */
    public static final String STATUS_VALID = "1";
    /**
     * 状态无效0
     */
    public static final String STATUS_INVALID = "0";

    /**
     * 附件在OSS上的默认存储路径
     */
    public static final String OSS_DEFAULT_DIR = "upload/default";
    /**
     * email附件在OSS上的存储路径
     */
    public static final String OSS_EMAIL_DIR = "upload/email/";
    /**
     * email附件在OSS上的存储路径
     */
    public static final String OSS_FORM_DESIGN_DIR = "upload/formdesign/";
    /**
     * 捐赠协议(donate agreement)附件在OSS上的存储路径
     */
    public static final String OSS_AGREEMENT_DIR = "upload/agreement/";
    /**
     * 立项附件在OSS上的存储路径
     */
    public static final String OSS_PROJECT_ESTABLISH_DIR = "upload/project/establish/";

	public static final String EXECUTE_SUCCEED = "执行成功！";
	
	public static final String EXECUTE_FAIl = "执行失败！";
	
}
