package cn.kingfeeling.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author zemal-tan
 * @description
 * @create 2017-08-01 17:18
 */

//@Configuration
public class UrlMappingConfig {

//    @Value("${page.login}")
//    public String pageLogin;
//
//    @Value("${page.logout}")
//    public String pageLogout;
//
//    @Value("${page.index}")
//    public String pageIndex;

    public static final String loginPage = "base/login";

    public static final String indexPage = "base/index";

    public static final String unauthorizedPage = "base/unauthorized";

    public static final String menuInsert = "menu/save";

    public static final String menuDelete = "menu/delete";

    public static final String menuFind = "menu/find";

    public static final String menuUpdate = "menu/update";


}
