package com.uj.study.ip_identity.validator;

import com.uj.study.ip_identity.model.Address;
import com.uj.study.ip_identity.model.Address.Type;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/5/13 上午11:48
 * @description：
 * A类地址1.0.0.0~126.255.255.255;
 * 私网IP范围是：
 *  *
 *  * 10.0.0.0～10.255.255.255
 */
public class ClassAValidator extends AddressValidator {
    @Override
    public Type verifyClassType(Address address) {
        return isPrivateIp(address) ? Type.P : Type.A;
    }

    private boolean isPrivateIp(Address address) {
        int[] ipSegment = address.getIp().getSegment();
        return ipSegment[0] == 10;
    }
}
