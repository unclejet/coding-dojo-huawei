package com.uj.study.ip_identity.main;

import com.uj.study.ip_identity.model.Address;
import com.uj.study.ip_identity.validator.*;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/5/19 下午4:39
 * @description：
 */
public class ValidatorFactory {
    private static ValidatorFactory instance = new ValidatorFactory();
    private static ClassAValidator classAValidator = new ClassAValidator();
    private static ClassBValidator classBValidator = new ClassBValidator();
    private static ClassCValidator classCValidator = new ClassCValidator();
    private static ClassDValidator classDValidator = new ClassDValidator();
    private static ClassEValidator classEValidator = new ClassEValidator();
    private static ClassOtherValidator classOtherValidator = new ClassOtherValidator();
    private static ErrorValidator errorValidator = new ErrorValidator();

    private ValidatorFactory() {
    }

    public static ValidatorFactory getInstance() {
        return instance;
    }

    public AddressValidator selectBy(Address address) {
        int[] ipSegment = address.getIp().getSegment();
        if (ipSegment[0] >= 1 && ipSegment[0] <= 126) {
            return classAValidator;
        }
        if (ipSegment[0] >= 128 && ipSegment[0] <= 191) {
            return classBValidator;
        }
        if (ipSegment[0] >= 192 && ipSegment[0] <= 223) {
            return classCValidator;
        }
        if (ipSegment[0] >= 224 && ipSegment[0] <= 239) {
            return classDValidator;
        }
        if (ipSegment[0] >= 240 && ipSegment[0] <= 255) {
            return classEValidator;
        }
        if (ipSegment[0] == 0 || ipSegment[0] == 127) {
            return classOtherValidator;
        }
        return null;
    }

    public ErrorValidator getErrorValidator() {
        return errorValidator;
    }
}
