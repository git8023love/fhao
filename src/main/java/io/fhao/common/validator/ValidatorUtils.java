package io.fhao.common.validator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import io.fhao.common.exception.FhaoException;

import java.util.Set;

/**
 * 参考文档：http://docs.jboss.org/hibernate/validator/5.4/reference/en-US/html_single/
 * @author hgw
 * @Description: TODO(hibernate-validator校验工具类)
 * @date 2017-6-23 15:07
 */
public class ValidatorUtils {
    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 校验对象
     * @param object        待校验对象
     * @param groups        待校验的组
     * @throws FhaoException  校验不通过，FhaoException
     */
    public static void validateEntity(Object object, Class<?>... groups)
            throws FhaoException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            StringBuilder msg = new StringBuilder();
            for(ConstraintViolation<Object> constraint:  constraintViolations){
                msg.append(constraint.getMessage()).append("<br>");
            }
            throw new FhaoException(msg.toString());
        }
    }
}
