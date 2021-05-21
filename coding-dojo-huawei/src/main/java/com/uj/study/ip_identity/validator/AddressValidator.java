package com.uj.study.ip_identity.validator;

import com.uj.study.ip_identity.model.Address;
import com.uj.study.ip_identity.main.ValidatorFactory;

import static com.uj.study.ip_identity.model.Address.*;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/5/12 上午11:47
 * @description：
 */
public abstract class AddressValidator {

    protected abstract Type verifyClassType(Address address);

    public Type verifyAddressType(Address address) {
        return isValidAddress(address) ? verifyClassType(address) : Type.W;
    }

    protected boolean isValidAddress(Address address) {
        return ValidatorFactory.getInstance().getErrorValidator()
                .verifyClassType(address) == Type.R ? true : false;
    }
}
