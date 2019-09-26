package com.chen.extend;

import com.chen.service.TestService;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author chenzepeng
 * @date 2019-08-29
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{TestService.class.getName()};
    }
}
