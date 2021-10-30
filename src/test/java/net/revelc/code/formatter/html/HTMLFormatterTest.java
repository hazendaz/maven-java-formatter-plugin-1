/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.revelc.code.formatter.html;

import static java.util.Collections.emptyMap;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.revelc.code.formatter.AbstractFormatterTest;
import net.revelc.code.formatter.LineEnding;

/**
 * @author yoshiman
 */
class HTMLFormatterTest extends AbstractFormatterTest {

    @Test
    void testDoFormatFile() throws Exception {
        // Handle linux vs windows since this formatter does not accept line endings directly
        String expectedHash = LineEnding.LF.isSystem()
                ? "1cfe5e48635d8618be4d490a5e7f690ef8e1dfc7e24303457030e281068bbebac44b552ae52ac88f03bf10e72ed0582904d665afc54bade395fd3d183abe0cba"
                : "07ecccd712ce282ae1253ddae11819f3746f4f7494ee40d85a63def1f996625548c8e8c32e56e83bbd744b26b4fbab27d0d84f0f4eab6ebe4f854997943e7761";
        LineEnding lineEnding = LineEnding.LF.isSystem() ? LineEnding.LF : LineEnding.CRLF;
        twoPassTest(emptyMap(), new HTMLFormatter(), "someFile.html", expectedHash, lineEnding);
    }

    @Test
    void testIsIntialized() throws Exception {
        HTMLFormatter htmlFormatter = new HTMLFormatter();
        assertFalse(htmlFormatter.isInitialized());
        htmlFormatter.init(emptyMap(), new AbstractFormatterTest.TestConfigurationSource(TEST_OUTPUT_PRIMARY_DIR));
        assertTrue(htmlFormatter.isInitialized());
    }

}
