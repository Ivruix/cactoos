/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017-2025 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.cactoos.bytes;

import java.util.Base64;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.llorllale.cactoos.matchers.Assertion;

/**
 * Test case for {@link Base64Bytes}.
 *
 * @since 0.20.2
 * @checkstyle JavadocMethodCheck (500 lines)
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
final class Base64BytesTest {

    @Test
    void checkDecodeBasicDecoder() throws Exception {
        new Assertion<>(
            "Must decode bytes using the Base64 encoding basic scheme",
            new Base64Bytes(
                new BytesOf(
                    "SGVsbG8h"
                )
            ).asBytes(),
            new IsEqual<>(
                new BytesOf("Hello!").asBytes()
            )
        ).affirm();
    }

    @Test
    void checkDecodeUrlDecoder() throws Exception {
        new Assertion<>(
            "Must decode bytes using the Base64 encoding url scheme",
            new Base64Bytes(
                new BytesOf(
                    "SGVsbG8h"
                ), Base64.getUrlDecoder()
            ).asBytes(),
            new IsEqual<>(
                new BytesOf("Hello!").asBytes()
            )
        ).affirm();
    }

    @Test
    void checkDecodeMimeDecoder() throws Exception {
        new Assertion<>(
            "Must decode bytes using the Base64 encoding mime scheme",
            new Base64Bytes(
                new BytesOf(
                    "SGVsbG8h"
                ), Base64.getMimeDecoder()
            ).asBytes(),
            new IsEqual<>(
                new BytesOf("Hello!").asBytes()
            )
        ).affirm();
    }

}
