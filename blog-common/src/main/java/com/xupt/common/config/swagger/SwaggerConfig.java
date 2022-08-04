package com.xupt.common.config.swagger;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/*


        定义在类上： @Api(tags="")
        定义在方法上： @ApiOperation(value="")
        定义在参数上： @ApiParam

        修改UI https://blog.csdn.net/z17806289513/article/details/123659224

        (1) 导入依赖

        <!--springfox-swagger-->
        <dependency>
         <groupId>io.springfox</groupId>
         <artifactId>springfox-swagger2</artifactId>
        </dependency>

        <!--SwaggerBootstrapUi -->
        <dependency>
          <groupId>com.github.xiaoymin</groupId>
          <artifactId>swagger-bootstrap-ui</artifactId>

        </dependency>

        (2)接口访问

         http://host:{host}:host:{port}/doc.html
* */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                // and() 只允许 .not() 不允许
                //.paths(Predicates.and(PathSelectors.regex("/error.*")))
                //.paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("网站-课程中心API文档")
                .description("本文档描述了课程中心微服务接口定义")
                .version("1.0")
                .contact(new Contact("Helen", "http://atguigu.com",
                        "55317332@qq.com"))
                .build();
    }
}