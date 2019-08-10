package com.news.order.feign;

import com.news.common.model.request.LoginRequest;
import com.news.common.model.response.TokenResponse;
import com.news.common.result.SingleResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

/**
 * RequestMapping必须跟cloud服务的Controller对应
 * 不支持GET方法传递POJO,可以拆成一个个单独的属性放在参数里
 *
 * @author zhangkai
 * @date 2019年07月20日 22:22
 */
@FeignClient(value = "news-user-service")
public interface UserServiceFeign {

    @RequestMapping(value = "/user/login",method = RequestMethod.GET)
    SingleResult<TokenResponse> userLogin(@Valid @RequestBody LoginRequest request);
}
