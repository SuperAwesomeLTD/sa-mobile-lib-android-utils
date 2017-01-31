package tv.superawesome.lib;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tv.superawesome.lib.sautils.SAUtils;

/**
 * Created by gabriel.coman on 17/10/16.
 */
public class SAUtils_ArrayExt_Tests extends ApplicationTestCase<Application> {
    public SAUtils_ArrayExt_Tests() {
        super(Application.class);
    }

    @SmallTest
    public void testRemoveAllButFirst1 () {
        // given
        List<String> given = Arrays.asList("one", "two", "three");

        // when
        List<String> expected = new ArrayList<>();
        expected.add(given.get(0));

        // then
        List<String> result = SAUtils.removeAllButFirstElement(given);

        assertEquals(result.size(), expected.size());
        assertEquals(result, expected);
    }

    @SmallTest
    public void testRemoveAllButFirst2 () {
        // given
        List<String> given = new ArrayList<>();

        // when
        List<String> expected = new ArrayList<>();

        // then
        List<String> result = SAUtils.removeAllButFirstElement(given);

        assertEquals(result.size(), expected.size());
        assertEquals(result, expected);
    }

    @SmallTest
    public void testRemoveAllButFirst3 () {
        // given
        List<String> given = null;

        // then
        List<String> result = SAUtils.removeAllButFirstElement(given);

        assertNull(result);
    }
}
