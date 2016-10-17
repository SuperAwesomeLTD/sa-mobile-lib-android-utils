package tv.superawesome.lib;

import android.graphics.Rect;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import tv.superawesome.lib.sautils.SAUtils;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class SAUtis_Aux_Tests {
    @Test
    public void testFrameMapping () throws Exception {
        // given
        Rect oldFrame = new Rect(0, 30, 280, 45);
        Rect newFrame = new Rect(0, 0, 200, 100);

        // when
        Rect expected = new Rect(95, 0, 90, 45);

        // then
        Rect result = SAUtils.mapOldSizeIntoNewSize(newFrame.right, newFrame.bottom, oldFrame.right, newFrame.bottom);
        assertEquals(result.right, expected.right);
        assertEquals(result.bottom, expected.bottom);
    }

    @Test
    public void testRectInRect () throws Exception {
        // given
        Rect given1 = new Rect(0, 250, 320, 45);
        Rect given2 = new Rect(-23, 720, 250, 45);
        Rect given3 = new Rect(0, 0, 320, 684);

        // then
        boolean result1 = SAUtils.isTargetRectInFrameRect(given1, given3);
        boolean result2 = SAUtils.isTargetRectInFrameRect(given2, given3);
        // assertEquals(result1, true);
        // assertEquals(result2, false);
    }

    @Test
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

    @Test
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