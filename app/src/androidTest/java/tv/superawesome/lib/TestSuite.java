package tv.superawesome.lib;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by gabriel.coman on 17/10/16.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SAUtils_ArrayExt_Tests.class,
        SAUtils_Network_Tests.class,
        SAUtils_Aux_Tests.class,
        SAUtils_System_Tests.class
})
public class TestSuite {
}
