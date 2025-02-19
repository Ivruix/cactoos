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
package org.cactoos.text;

import org.cactoos.Text;

/**
 * {@link Text} envelope.
 *
 * @since 0.32
 * @checkstyle AbstractClassNameCheck (500 lines)
 */
public abstract class TextEnvelope implements Text {

    /**
     * Wrapped Text.
     */
    private final Text origin;

    /**
     * Ctor.
     * @param text Text representing the text value.
     */
    public TextEnvelope(final Text text) {
        this.origin = text;
    }

    @Override
    public final String asString() throws Exception {
        return this.origin.asString();
    }

    @Override
    public final String toString() {
        return this.origin.toString();
    }

    @Override
    public final boolean equals(final Object obj) {
        return this.origin.equals(obj);
    }

    @Override
    public final int hashCode() {
        return this.origin.hashCode();
    }
}
