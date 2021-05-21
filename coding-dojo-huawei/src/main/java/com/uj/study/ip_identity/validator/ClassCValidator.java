package com.uj.study.ip_identity.validator;

import com.uj.study.ip_identity.model.Address;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/5/20 下午4:20
 * @description：
 * C类地址192.0.0.0~223.255.255.255;
 * 私有IP192.168.0.0～192.168.255.255
 */
public class ClassCValidator extends AddressValidator {
    @Override
    public Address.Type verifyClassType(Address address) {
        return isPrivateIp(address) ? Address.Type.P : Address.Type.C;
    }

    private boolean isPrivateIp(Address address) {
        int[] ipSegment = address.getIp().getSegment();
        return ipSegment[0] == 192 && ipSegment[1] == 168;
    }
}