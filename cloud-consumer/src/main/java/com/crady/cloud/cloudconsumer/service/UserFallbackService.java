package com.crady.cloud.cloudconsumer.service;

import com.crady.cloud.api.bean.User;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:Crady
 * @date:2018/6/26 17:59
 * @desc: Feign服务降级demo
 * feign.hystrix.enabled=true开关一定要打开
 **/
/**使用Fallback和FallbackFactory两者不能同时存,使用Fallback主要要修改映射路径不能和接口一样，不然会报错**/
//@FeignClient(value = "cloud-service",fallback = UserFallbackService.UserFallbackServiceFallback.class)
@FeignClient(value = "cloud-service/service",fallbackFactory = UserFallbackService.UserServiceFallbackFactory.class)
public interface UserFallbackService extends com.crady.cloud.api.service.UserService {

    /**
     * 使用Fallback实现服务降级，使用此种方式注意要修改映射路径不能喝接口一样
     */
    @Component
    @RequestMapping("fallback")
    class UserFallbackServiceFallback implements UserFallbackService {
        @Override
        public String hello(String words) {
            return "fallback版-调用hello出错!";
        }
        @Override
        public User editUser(User user) {
            User u = new User();
            u.setName("fallback版-调用editUser出错!");
            return u;
        }
    }

    /**
     * 使用FallbackFactory实现服务降级
     */
    @Component
    class UserServiceFallbackFactory implements FallbackFactory<UserFallbackService> {
        @Override
        public UserFallbackService create(Throwable throwable) {
            return new UserFallbackService() {
                @Override
                public String hello(String words) {
                    return "fallbackfactory版-调用hello出错!";
                }

                @Override
                public User editUser(User user) {
                    User u = new User();
                    u.setName("fallbackfactory版-调用editUser出错!");
                    return u;
                }
            };
        }
    }
}
