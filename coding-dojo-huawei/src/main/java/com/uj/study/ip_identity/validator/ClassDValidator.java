package com.uj.study.ip_identity.validator;

import com.uj.study.ip_identity.model.Address;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/5/20 下午4:28
 * @description：
 * D类地址224.0.0.0~239.255.255.255；
 */
public class ClassDValidator extends AddressValidator {
    @Override
    public Address.Type verifyClassType(Address address) {
        return  Address.Type.D;
    }
}
