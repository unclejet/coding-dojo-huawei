package com.uj.study.ip_identity.io;

import com.uj.study.ip_identity.utils.Utils;
import com.uj.study.ip_identity.main.ValidatorFactory;
import com.uj.study.ip_identity.model.Address;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.uj.study.ip_identity.model.Address.Type.*;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/5/12 下午12:29
 * @description：
 */
public class NetworkReporter {
    public static String report(Map<String, String> userInputs) {
        List<Address> addressList = Utils.transform(userInputs);
        Map<Address.Type, List<Address>> types = addressList.stream()
                .collect(Collectors.groupingBy(address -> {
                    return ValidatorFactory.getInstance().selectBy(address).verifyAddressType(address);
                }));
        return String.format("%s %s %s %s %s %s %s",
                types.containsKey(A) ? types.get(A).size() : 0,
                types.containsKey(B) ? types.get(B).size() : 0,
                types.containsKey(C) ? types.get(C).size() : 0,
                types.containsKey(D) ? types.get(D).size() : 0,
                types.containsKey(E) ? types.get(E).size() : 0,
                types.containsKey(W) ? types.get(W).size() : 0,
                types.containsKey(P) ? types.get(P).size() : 0);
    }
}
