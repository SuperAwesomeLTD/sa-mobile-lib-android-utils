package tv.superawesome.lib.sautils;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tv.superawesome.lib.sautils.array.TestSAUtils_RemoveAllButFirstElement;
import tv.superawesome.lib.sautils.aux.TestSAUtils_GenerateUniqueKey;
import tv.superawesome.lib.sautils.aux.TestSAUtils_IsTargetRectInFrameRect;
import tv.superawesome.lib.sautils.aux.TestSAUtils_MapSourceSizeIntoBoundingSize;
import tv.superawesome.lib.sautils.aux.TestSAUtils_RandomNumberBetween;
import tv.superawesome.lib.sautils.network.TestSAUtils_EncodeDictAsJsonDict;
import tv.superawesome.lib.sautils.network.TestSAUtils_EncodeURL;
import tv.superawesome.lib.sautils.network.TestSAUtils_FindBaseURLFromResourceURL;
import tv.superawesome.lib.sautils.network.TestSAUtils_FormGetQueryFromDict;
import tv.superawesome.lib.sautils.network.TestSAUtils_GetCachebuster;
import tv.superawesome.lib.sautils.network.TestSAUtils_IsJSONEmpty;
import tv.superawesome.lib.sautils.network.TestSAUtils_IsValidEmail;
import tv.superawesome.lib.sautils.network.TestSAUtils_IsValidURL;

/**
 * Created by gabriel.coman on 17/10/16.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestSAUtils_RemoveAllButFirstElement.class,
        TestSAUtils_IsTargetRectInFrameRect.class,
        TestSAUtils_GenerateUniqueKey.class,
        TestSAUtils_MapSourceSizeIntoBoundingSize.class,
        TestSAUtils_RandomNumberBetween.class,
        TestSAUtils_EncodeDictAsJsonDict.class,
        TestSAUtils_EncodeURL.class,
        TestSAUtils_FindBaseURLFromResourceURL.class,
        TestSAUtils_FormGetQueryFromDict.class,
        TestSAUtils_GetCachebuster.class,
        TestSAUtils_IsJSONEmpty.class,
        TestSAUtils_IsValidEmail.class,
        TestSAUtils_IsValidURL.class
})
public class TestSuite {
}
