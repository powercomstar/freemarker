/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package freemarker.ext.beans;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

final class AllowAllMemberAccessPolicy implements MemberAccessPolicy {
    public static final AllowAllMemberAccessPolicy INSTANCE = new AllowAllMemberAccessPolicy();

    private AllowAllMemberAccessPolicy() {
    }

    public static final ClassMemberAccessPolicy CLASS_POLICY_INSTANCE = new ClassMemberAccessPolicy() {
        @Override
        public boolean isMethodExposed(Method method) {
            return true;
        }

        @Override
        public boolean isConstructorExposed(Constructor<?> constructor) {
            return true;
        }

        @Override
        public boolean isFieldExposed(Field field) {
            return true;
        }
    };

    @Override
    public ClassMemberAccessPolicy forClass(Class<?> contextClass) {
        return CLASS_POLICY_INSTANCE;
    }
}
