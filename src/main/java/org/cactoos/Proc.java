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
package org.cactoos;

import org.cactoos.proc.IoCheckedProc;
import org.cactoos.proc.UncheckedProc;

/**
 * Procedure.
 *
 * <p>If you don't want to have any checked exceptions being thrown
 * out of your {@link Proc}, you can use
 * {@link UncheckedProc} decorator. Also
 * you may try {@link IoCheckedProc}.</p>
 *
 * <p>There is no thread-safety guarantee.
 *
 * @param <X> Type of input
 * @see org.cactoos.func.FuncOf
 * @since 0.1
 */
@FunctionalInterface
public interface Proc<X> {

    /**
     * Execute it.
     * @param input The argument
     * @throws Exception If fails
     */
    void exec(X input) throws Exception;
}
