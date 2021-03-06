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

import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * A class resolver which uses the context classloader to resolve classes.
 */
public class ContextClassResolver extends AbstractClassResolver {

    private static final PrivilegedAction<ClassLoader> classLoaderAction = new PrivilegedAction<ClassLoader>() {
        public ClassLoader run() {
            return Thread.currentThread().getContextClassLoader();
        }
    };

    /**
     * Construct a new instance.
     */
    public ContextClassResolver() {
    }

    /**
     * Construct a new instance.
     *
     * @param enforceSerialVersionUid {@code true} if an exception should be thrown on an incorrect serialVersionUID
     */
    public ContextClassResolver(final boolean enforceSerialVersionUid) {
        super(enforceSerialVersionUid);
    }

    /** {@inheritDoc} */
    protected ClassLoader getClassLoader() {
        final SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            return AccessController.doPrivileged(classLoaderAction);
        } else {
            return Thread.currentThread().getContextClassLoader();
        }
    }
}
