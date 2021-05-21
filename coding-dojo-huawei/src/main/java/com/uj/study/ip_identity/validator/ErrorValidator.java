package com.uj.study.ip_identity.validator;

import com.uj.study.ip_identity.model.Address;
import com.uj.study.ip_identity.model.Address.Type;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/5/13 下午12:04
 * @description：
 */
public class ErrorValidator extends AddressValidator {
    @Override
    public Type verifyClassType(Address address) {
        return isInvalidIp(address) || isInvalidNetmask(address)?  Type.W : Type.R;
    }

    private boolean isInvalidIp(Address address) {
        Predicate<Address> isInvalidFormat = add -> isInvalidFormat(add.getIpStream());
        Predicate<Address> isInvalidNumber = add -> isInvalidNumber(add.getIpStream());
        Predicate<Address> isAllOne = add -> isAllOne(add.getIpStream());
        Predicate<Address> isAllZero = add -> isAllZero(add.getIpStream());
        return  isInvalidFormat
                .or(isInvalidNumber)
                .or(isAllOne)
                .or(isAllZero)
                .test(address) ;
    }

    private boolean isInvalidFormat(IntStream intStream) {
        return intStream.count() < 4 ? true : false;
    }

    private boolean isInvalidNetmask(Address address) {
        Predicate<Address> isInvalidFormat = add -> isInvalidFormat(add.getNetmaskStream());
        Predicate<Address> isInvalidNumber = add -> isInvalidNumber(add.getNetmaskStream());
        Predicate<Address> isAllOne = add -> isAllOne(add.getNetmaskStream());
        Predicate<Address> isAllZero = add -> isAllZero(add.getNetmaskStream());
        Predicate<Address> isOneAfterZero = add -> isOneAfterZeroInvalid(add.getNetmaskStream());
        return isInvalidFormat
                .or(isInvalidNumber)
                .or(isAllOne)
                .or(isAllZero)
                .or(isOneAfterZero)
                .test(address) ;
    }

    private boolean isAllOne(IntStream intStream) {
        return intStream.allMatch(i -> i == 255);
    }

    private boolean isAllZero(IntStream intStream) {
        return intStream.allMatch(i -> i == 0);
    }

    private boolean isInvalidNumber(IntStream intStream) {
        return intStream.anyMatch(i -> i < 0 || i > 255);
    }

    private boolean isOneAfterZeroInvalid(IntStream netmaskStream) {
        String binaryStr = netmaskStream
                .mapToObj(n -> String.format("%08d", Integer.valueOf(Integer.toBinaryString(n))))
                .collect(Collectors.joining());
        int idx1 = binaryStr.indexOf('1', binaryStr.indexOf('0'));
        return idx1 > 0 ? true : false;
    }
}
