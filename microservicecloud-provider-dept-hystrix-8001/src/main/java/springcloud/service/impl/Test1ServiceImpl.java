package springcloud.service.impl;

import org.springframework.stereotype.Service;
import springcloud.service.Test1Service;
@Service
public class Test1ServiceImpl implements Test1Service {
    @Override
    public String get() {
        return "服务者提供数据";
    }
}
