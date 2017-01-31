package tv.superawesome.lib;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;

import tv.superawesome.lib.sautils.SAUtils;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class SAUtils_System_Tests extends ApplicationTestCase<Application> {
    public SAUtils_System_Tests() {
        super(Application.class);
    }

    public class TestActivity extends Activity {
        //
    }

    @SmallTest
    public void testScaleFactor () throws Exception {

    }

    @SmallTest
    public void testRealScreenSize () throws Exception {

    }

    @SmallTest
    public void testSystemSize () throws Exception {
        // when
        SAUtils.SASystemSize systemSize = SAUtils.getSystemSize();
    }

    @SmallTest
    public void testVerboseSystemDetails () throws Exception {
        // given
        SAUtils.SASystemSize systemSize = SAUtils.getSystemSize();

        // when
        String expected1 = "android_phone";
        String expected2 = "android_tablet";

        // then
        String result = SAUtils.getVerboseSystemDetails();

        if (systemSize == SAUtils.SASystemSize.phone) {
            assertEquals(result, expected1);
        } else {
            assertEquals(result, expected2);
        }
    }

    @SmallTest
    public void testAppLabel () throws Exception {
        // given
        Context context1 = null;
        Context context2 = getContext();

        // when
        String expected1 = "Unknown";
        String expected2 = "SAUtilsDemoApp";

        // then
        String result1 = SAUtils.getAppLabel(context1);
        String result2 = SAUtils.getAppLabel(context2);

        assertEquals(result1, expected1);
        assertEquals(result2, expected2);
    }

    @SmallTest
    public void testIsClassAvailable () throws Exception {
        // given
        String given1 = "tv.superawesome.lib.sautils.SAAlert";
        String given2 = "tv.superawesome.lib.sautils.SAAlertInterface";
        String given3 = "tv.superawesome.lib.sautils.SALoadScreen";
        String given4 = "tv.superawesome.lib.sautils.SAUtils";
        String given5 = "com.someclass.NotFound";
        String given6 = null;

        // then
        boolean result1 = SAUtils.isClassAvailable(given1);
        boolean result2 = SAUtils.isClassAvailable(given2);
        boolean result3 = SAUtils.isClassAvailable(given3);
        boolean result4 = SAUtils.isClassAvailable(given4);
        boolean result5 = SAUtils.isClassAvailable(given5);
        boolean result6 = SAUtils.isClassAvailable(given6);

        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertTrue(result4);
        assertFalse(result5);
        assertFalse(result6);
    }



}