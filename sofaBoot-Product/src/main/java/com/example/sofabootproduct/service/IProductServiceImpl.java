package com.example.sofabootproduct.service;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.example.sofabootcommon.facade.IProductService;
import org.springframework.stereotype.Service;

/**
 * @author 房发科
 * @create 2022/8/16
 */

@Service
@SofaService(
        interfaceType = IProductService.class,
        bindings = {
        @SofaServiceBinding(
                bindingType = "bolt"
        )
        })
public class IProductServiceImpl implements IProductService {


    @Override
    public String product() {
        return "Hello,world!";
    }
}
