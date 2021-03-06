/*
 * JBoss, Home of Professional Open Source
 * Copyright 2008, JBoss Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.marshalling;

/**
 * A class resolver which uses a predefined classloader.
 */
public class SimpleClassResolver extends AbstractClassResolver {
    private final ClassLoader classLoader;

    /**
     * Construct a new instance, specifying a classloader.
     *
     * @param classLoader the classloader to use
     */
    public SimpleClassResolver(final ClassLoader classLoader) {
        this(false, classLoader);
    }

    /**
     * Construct a new instance, specifying a classloader and a flag which determines whether {@code serialVersionUID}
     * matching will be enforced.
     *
     * @param enforceSerialVersionUid {@code true} to throw an exception on unmatched {@code serialVersionUID}
     * @param classLoader the classloader to use
     */
    public SimpleClassResolver(final boolean enforceSerialVersionUid, final ClassLoader classLoader) {
        super(enforceSerialVersionUid);
        this.classLoader = classLoader;
    }

    /** {@inheritDoc} */
    protected ClassLoader getClassLoader() {
        return classLoader;
    }
}
