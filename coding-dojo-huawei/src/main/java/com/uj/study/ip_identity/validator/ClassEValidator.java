package com.uj.study.ip_identity.validator;

import com.uj.study.ip_identity.model.Address;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/5/20 下午4:39
 * @description：
 */
public class ClassEValidator extends AddressValidator {
    @Override
    public Address.Type verifyClassType(Address address) {
        return  Address.Type.E;
    }
}
