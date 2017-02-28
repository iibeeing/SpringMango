package com.mango.jtt.core.base;
// 注意这里的Service类，如果是非分布式，不使用dubbo则用Spring的类，否则使用dubbo的类
//import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Service;
import com.mango.jtt.provider.ISysProvider;
//@Service(interfaceClass = ISysProvider.class)
@Service
public class SysProviderImpl extends BaseProviderImpl implements ISysProvider {
	
}