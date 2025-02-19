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
package org.cactoos.proc;

import java.util.concurrent.atomic.AtomicInteger;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.llorllale.cactoos.matchers.Assertion;
import org.llorllale.cactoos.matchers.Throws;

/**
 * Test case for {@link ProcNoNulls}.
 * @since 0.11
 * @checkstyle JavadocMethodCheck (500 lines)
 */
@SuppressWarnings("PMD.JUnitTestsShouldIncludeAssert")
final class ProcNoNullsTest {

    @Test
    void failForNullProc() {
        new Assertion<>(
            "Doesn't fail for null proc",
            () -> {
                new ProcNoNulls<>(null).exec(new Object());
                return 1;
            },
            new Throws<>(IllegalArgumentException.class)
        ).affirm();
    }

    @Test
    void failForNullInput() {
        new Assertion<>(
            "Doesn't fail for null input",
            () -> {
                new ProcNoNulls<>(input -> { }).exec(null);
                return 1;
            },
            new Throws<>(IllegalArgumentException.class)
        ).affirm();
    }

    @Test
    void okForNoNulls() throws Exception {
        final AtomicInteger counter = new AtomicInteger();
        new ProcNoNulls<>(AtomicInteger::incrementAndGet)
            .exec(counter);
        new Assertion<>(
            "Can't involve the \"Proc.exec(X input)\" method",
            counter.get(),
            new IsEqual<>(1)
        ).affirm();
    }
}
