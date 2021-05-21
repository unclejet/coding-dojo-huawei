package com.uj.study.ip_identity.validator;

import com.uj.study.ip_identity.model.Address;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/5/20 下午12:11
 * @description：
 * B类地址128.0.0.0~191.255.255.255;
 * 私网IP 172.16.0.0～172.31.255.255
 *
 */
public class ClassBValidator extends AddressValidator {
    @Override
    public Address.Type verifyClassType(Address address) {
        return isPrivateIp(address) ? Address.Type.P : Address.Type.B;
    }

    private boolean isPrivateIp(Address address) {
        int[] ipSegment = address.getIp().getSegment();
        return ipSegment[0] == 172 &&
                (ipSegment[1] >= 16 && ipSegment[1] <= 31);
    }
}
