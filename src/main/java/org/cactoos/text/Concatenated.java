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
import org.cactoos.iterable.IterableOf;
import org.cactoos.iterable.Mapped;

/**
 * Concatenate a Text.
 *
 * <p>There is no thread-safety guarantee.
 *
 * @since 0.47
 */
public final class Concatenated extends TextEnvelope {

    /**
     * Ctor.
     * @param txts Texts to be concatenated
     */
    public Concatenated(final Text... txts) {
        this(new IterableOf<>(txts));
    }

    /**
     * Ctor.
     * @param strs CharSequences to be concatenated
     */
    public Concatenated(final CharSequence... strs) {
        this(
            new Mapped<>(
                TextOf::new,
                new IterableOf<>(strs)
            )
        );
    }

    /**
     * Ctor.
     * @param txts Texts to be concatenated
     */
    public Concatenated(final Iterable<? extends Text> txts) {
        super(new Joined(new TextOf(""), txts));
    }
}
