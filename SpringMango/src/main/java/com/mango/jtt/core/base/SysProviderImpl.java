package com.mango.jtt.core.base;

//import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Service;

import com.mango.jtt.provider.ISysProvider;

//@Service(interfaceClass = ISysProvider.class)
@Service
public class SysProviderImpl extends BaseProviderImpl implements ISysProvider {
	
}