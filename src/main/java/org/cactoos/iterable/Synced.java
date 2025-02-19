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
package org.cactoos.iterable;

import java.util.Iterator;

/**
 * Synchronized iterable.
 *
 * <p>
 * This class should be used very carefully. You must understand that it will
 * fetch the entire content of the encapsulated {@link Iterable} on each method
 * call. It doesn't cache the data anyhow. If you don't need this
 * {@link Iterable} to re-fresh its content on every call, by doing round-trips
 * to the encapsulated iterable, use {@link Sticky}.
 * </p>
 *
 * <p>
 * Objects of this class are thread-safe.
 * </p>
 * @param <X> Type of item
 * @since 0.24
 */
public final class Synced<X> implements Iterable<X> {

    /**
     * The iterable.
     */
    private final Iterable<? extends X> origin;

    /**
     * Sync lock.
     */
    private final Object lock;

    /**
     * Ctor.
     * @param src The underlying iterable
     */
    @SafeVarargs
    public Synced(final X... src) {
        this(new IterableOf<>(src));
    }

    /**
     * Ctor.
     * @param iterable The iterable synchronize access to.
     */
    public Synced(final Iterable<? extends X> iterable) {
        this(new Object(), iterable);
    }

    /**
     * Ctor.
     * @param lck The lock to synchronize with.
     * @param iterable The iterable synchronize access to.
     */
    public Synced(final Object lck, final Iterable<? extends X> iterable) {
        this.origin = iterable;
        this.lock = lck;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterator<X> iterator() {
        synchronized (this.lock) {
            return (Iterator<X>) this.origin.iterator();
        }
    }
}
