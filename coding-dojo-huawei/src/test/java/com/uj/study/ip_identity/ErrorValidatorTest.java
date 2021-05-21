package com.uj.study.ip_identity;

import com.uj.study.ip_identity.model.Address;
import com.uj.study.ip_identity.model.IP;
import com.uj.study.ip_identity.model.Netmask;
import com.uj.study.ip_identity.validator.ErrorValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.uj.study.ip_identity.model.Address.Type.W;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/5/13 下午12:14
 * @description：
 */
class ErrorValidatorTest {

    private ErrorValidator validator;

    @BeforeEach
    void setUp() {
        validator = new ErrorValidator();
    }

    @Test
    void verifyIp_invalidNumber() {
        IP ip = new IP(new int[]{1, -1, 0, 0});
        Address address = new Address(ip, null);
        assertThat(validator.verifyClassType(address), is(W));

        ip = new IP(new int[]{1, 1, 0, 256});
        address = new Address(ip, null);
        assertThat(validator.verifyClassType(address), is(W));
    }

    @Test
    void verifyIp_numberCountLess4_invalid() {
        IP ip = new IP(new int[]{19, 0, 0});
        Address address = new Address(ip, null);
        assertThat(validator.verifyClassType(address), is(W));
    }

    @Test
    void verifyIp_allBinaryOne_invalid() {
        IP ip = new IP(new int[]{255, 255, 255, 255});
        Address address = new Address(ip, null);

        assertThat(validator.verifyClassType(address), is(W));
    }

    @Test
    void verifyIp_allZero_invalid() {
        IP ip = new IP(new int[]{0, 0, 0, 0});
        Address address = new Address(ip, null);

        assertThat(validator.verifyClassType(address), is(W));
    }

    @Test
    void verifyNetmask_oneAfterZero_invalid() {
        IP ip = new IP(new int[]{10, 0, 0, 0});
        Netmask netmask = new Netmask(new int[]{255, 255, 255, 32});
        Address address = new Address(ip, netmask);
        assertThat(validator.verifyClassType(address), is(W));
    }

    @Test
    void verifyNetmask_numberCountLess4_invalid() {
        IP ip = new IP(new int[]{19, 0, 0, 1});
        Netmask netmask = new Netmask(new int[]{255, 255, 255});
        Address address = new Address(ip, netmask);
        assertThat(validator.verifyClassType(address), is(W));
    }
}