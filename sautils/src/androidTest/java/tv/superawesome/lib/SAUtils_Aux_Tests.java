package tv.superawesome.lib;

import android.app.Application;
import android.graphics.Rect;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import tv.superawesome.lib.sautils.SAUtils;

/**
 * Created by gabriel.coman on 17/10/16.
 */
public class SAUtils_Aux_Tests extends ApplicationTestCase<Application> {
    public SAUtils_Aux_Tests() {
        super(Application.class);
    }

    @SmallTest
    public void testFrameMapping () throws Exception {
        // given
        Rect oldFrame = new Rect(0, 30, 280, 45);
        Rect newFrame = new Rect(0, 0, 200, 100);

        // when
        Rect expected = new Rect(0, 33, 200, 32);

        // then
        Rect result = SAUtils.mapOldSizeIntoNewSize(newFrame.right, newFrame.bottom, oldFrame.right, oldFrame.bottom);

        assertEquals(result.right, expected.right);
        assertEquals(result.bottom, expected.bottom);
    }

    @SmallTest
    public void testRectInRect () throws Exception {
        // given
        Rect given1 = new Rect(0, 250, 320, 45);
        Rect given2 = new Rect(-23, 720, 250, 45);
        Rect given3 = new Rect(0, 0, 320, 684);

        // then
        boolean result1 = SAUtils.isTargetRectInFrameRect(given1, given3);
        boolean result2 = SAUtils.isTargetRectInFrameRect(given2, given3);
        assertTrue(result1);
        assertFalse(result2);
    }

    @SmallTest
    public void testRandomNumber () throws Exception {
        // given
        int lower = 0;
        int upper = 58;

        // then
        int result = SAUtils.randomNumberBetween(lower, upper);
        boolean result1 = result <= upper;
        boolean result2 = result >= upper;
        assertTrue(result1);
        assertFalse(result2);
    }

    @SmallTest
    public void testGenerateUniqueKey () throws Exception {
        // given
        int bound = 100;
        List<String> uniqueKeys = new ArrayList<>();
        for (int i = 0; i < bound; i++) {
            uniqueKeys.add(SAUtils.generateUniqueKey());
        }

        // when
        boolean allUniques = true;
        for (int i = 0; i < bound; i++) {
            boolean hasFound = false;

            for (int j = 0; j < bound && j != i; j++) {
                String uniquei = uniqueKeys.get(i);
                String uniquej = uniqueKeys.get(j);
                if (uniquei.equals(uniquej)) {
                    hasFound = true;
                    break;
                }
            }

            if (hasFound) {
                allUniques = false;
                break;
            }
        }

        // then
        assertTrue(allUniques);
    }
}
