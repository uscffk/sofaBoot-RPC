package com.example.sofabootconsumer.service;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;

import com.example.sofabootcommon.facade.IProductService;
import org.springframework.stereotype.Service;

/**
 * @author 房发科
 * @create 2022/8/16
 */

@Service
public class IConsumeServiceImpl implements IConsumeService {

    @SofaReference(interfaceType = IProductService.class,
    binding = @SofaReferenceBinding(bindingType = "bolt"))
    private IProductService productService;

    @Override
    public void consume() {
        String productRs = productService.product();
        System.out.println(productRs);
    }
}
