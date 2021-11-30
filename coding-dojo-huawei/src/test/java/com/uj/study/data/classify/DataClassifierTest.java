package com.uj.study.data.classify;

import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/11/22 下午12:47
 * @description：
 */
public class DataClassifierTest {
    @Test
    void sortSequenceRAndUnique() {
        String[] sequ = {"6", "3", "6", "3", "0"};
        assertThat(DataClassifier.sortSequenceR(sequ), containsInAnyOrder("0", "3", "6"));
    }

    @Test
    void structureSequenceI() {
        String[] si = {"123", "456", "786"};
        List<DataInput> dataInputList = DataClassifier.structureSequenceI(si);
        assertThat(dataInputList.size(), is(3));
        DataInput dataInput = dataInputList.stream().filter(di->"786".equals(di.getData())).findAny().get();
        assertThat(dataInput.getIndex(), is(2));
    }

    @Test
    void classify() {
        String[] sr = {"6", "3", "6", "3", "0"};
        String[] si = {"123", "456", "786"};
        assertThat(DataClassifier.classify(sr, si), is("10 3 1 0 123 6 2 1 456 2 786"));

        si = new String[]{"123", "456", "786", "453", "46", "7", "5", "3", "665", "453456", "745", "456", "786", "453", "123"};
        assertThat(DataClassifier.classify(sr, si), is("30 3 6 0 123 3 453 7 3 9 453456 13 453 14 123 6 7 1 456 2 786 4 46 8 665 9 453456 11 456 12 786"));


    }
}
