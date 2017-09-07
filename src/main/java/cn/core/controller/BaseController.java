package cn.core.controller;

import cn.core.domain.BaseBean;
import cn.core.security.domain.SysUser;
import cn.core.service.base.IBaseService;
import cn.core.utils.LoggerUtils;
import cn.core.utils.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UrlPathHelper;

import javax.annotation.Resource;
import javax.persistence.MappedSuperclass;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 基本控制器
 */
@MappedSuperclass
public class BaseController<E extends BaseBean>{

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public static final String CMD_EDIT = "edit";
    public static final String CMD_NEW = "new";
    public static final String MODEL = "model";
    protected static final String idField = BaseBean.ID_FIELD;

    /**
     * 状态删除字段 delStatus ,boolean型
     */
    protected static final String delField = BaseBean.DEL_STATUS_FIELD;
    /**
     * 状态字段 status ,boolean型
     */
    protected static final String statusField = BaseBean.STATUS_FIELD;

    /**
     * 文件分隔符 \ or /
     */
    protected static final String FILE_SEPARATOR = System
            .getProperty("file.separator");
    /**
     * 路径分隔符 ;
     */
    protected static final String PATH_SEPARATOR = System
            .getProperty("path.separator");
    /**
     * 行分隔符 /r/n
     */
    protected static final String LINE_SEPARATOR = System
            .getProperty("line.separator");


    /**
     * 当前登录用户
     */
    public final static String CURRENT_ADMIN_USER = "current_admin_user";

    /**
     * JSP页面模板主文件路径
     * @return
     */
    private String pageDirectoryView = "default";

    /**
     * jsp页面视图模板块模板文件夹
     */
    private String moduleDirectoryView = "";

    /**
     * 当前页面操作主数据模型
     */
    protected Class<E> entityClass;

    /**
     * 通用service
     */
    @Resource(name = "baseSimpleServiceImpl")
    protected IBaseService service;



    public BaseController() {
        Class<?> clz = getClass();

        Type tp = clz.getGenericSuperclass();
        if (tp instanceof ParameterizedType) {
            // 获取泛型化的父类
            ParameterizedType type = (ParameterizedType) tp;
            // 获取泛型运行期真实的类型
            this.entityClass = (Class<E>) type.getActualTypeArguments()[0];

        }
    }

    public Class<E> getEntityClass() {
        return entityClass;
    }

    protected String getPageDirectoryView(){
        return pageDirectoryView + FILE_SEPARATOR + getModuleDirectoryView();
    }

    public void setPageDirectoryView(String pageDirectoryView) {
        this.pageDirectoryView = pageDirectoryView;
    }

    public String getModuleDirectoryView() {
        if (null != this.moduleDirectoryView && !"".equals(this.moduleDirectoryView)) {
            return moduleDirectoryView + FILE_SEPARATOR;
        }
        return moduleDirectoryView;
    }

    public void setModuleDirectoryView(String moduleDirectoryView) {
        this.moduleDirectoryView = moduleDirectoryView;
    }

    /**
     * MVC初始化之前
     * @return
     */
    protected void beforeInitBinder(WebDataBinder binder){

    }

    /**
     * MVC初始化之后
     * @return
     */
    protected void afterInitBinder(WebDataBinder binder){

    }

    /**
     * 当前登录用户
     */
    protected SysUser user = null;

    protected String getTemplateDirectoryView(){
        return pageDirectoryView;
    }

    /**
     * 获得当前的访问路径
     */
    protected String getCurrentUrl(){
        HttpServletRequest request = this.getRequest();
        UrlPathHelper helper = new UrlPathHelper();
        StringBuffer buff = request.getRequestURL();
        String uri = request.getRequestURI();
        String orgiUri = helper.getOriginatingRequestUri(request);
        buff.replace(buff.length() - uri.length(), buff.length(), orgiUri);
        String queryString = helper.getOriginatingQueryString(request);
        if (queryString != null) {
            buff.append("?").append(queryString);
        }
        return buff.toString();
    }

    /**
     * 设置http页面默认视图模型
     */
    @RequestMapping(value="/view",method= RequestMethod.GET)
    public ModelAndView doView(@RequestParam(value = "v", required = false) String v){
        ModelAndView mv = new ModelAndView();
        beforeDefault(mv);
		/*mv.addObject("user",getCurrentSysUser());*/
        mv.setViewName(getPageDirectoryView()+getClass().getSimpleName().toString().replace("Sys", "")
                .replace("Controller", "").toLowerCase());
        afterDefault(mv);
        return mv;
    }

    protected HttpServletRequest getRequest(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    protected String getLoginUrl(){
        return (String)getSession("admin_loginUrl");
    }

    /**
     *
     * 得到session中的对象
     */
    protected Object getSession(String key){
        return getRequest().getSession().getAttribute(key);
    }

    /**
     * 当前登录用户
     *
     * @return SysUser
     */
    protected SysUser getCurrentSysUser(){
        if (user == null) {
            user = (SysUser) RequestUtils.getSession(CURRENT_ADMIN_USER);
        }
        return user;
    }

    protected void beforeDefault(ModelAndView mv){

    }

    protected void afterDefault(ModelAndView mv){

    }

}

