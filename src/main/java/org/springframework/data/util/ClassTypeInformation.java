/*
 * Copyright 2021. the original author or authors.
 *
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

/*
 * Copyright 2021. the original author or authors.
 *
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

/*
 * Copyright 2021 the original author or authors.
 *
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
package org.springframework.data.util;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.core.ResolvableType;
import org.springframework.util.Assert;
import org.springframework.util.ConcurrentReferenceHashMap;
import org.springframework.util.ConcurrentReferenceHashMap.ReferenceType;

/**
 * @author Christoph Strobl
 * @since 2021/11
 */
public class ClassTypeInformation<S> extends NewTypeDiscoverer<S> {

	public static final ClassTypeInformation<Collection> COLLECTION = new ClassTypeInformation(Collection.class);
	public static final ClassTypeInformation<List> LIST = new ClassTypeInformation(List.class);
	public static final ClassTypeInformation<Set> SET = new ClassTypeInformation(Set.class);
	public static final ClassTypeInformation<Map> MAP = new ClassTypeInformation(Map.class);
	public static final ClassTypeInformation<Object> OBJECT = new ClassTypeInformation(Object.class);

	private static final Map<Class<?>, ClassTypeInformation<?>> cache = new ConcurrentReferenceHashMap<>(64,
			ReferenceType.WEAK);

	public static TypeInformation<?> fromReturnTypeOf(Method method) {
		// todo open issue in FW for ResolvableType.forMethod(method)
		return new NewTypeDiscoverer(ResolvableType.forType(method.getGenericReturnType(), ResolvableType.forClass(method.getDeclaringClass())));
	}

	Class<?> type;

	static {
		Arrays.asList(COLLECTION, LIST, SET, MAP, OBJECT).forEach(it -> cache.put(it.getType(), it));
	}

	public static <S> ClassTypeInformation<S> from(Class<S> type) {

		Assert.notNull(type, "Type must not be null!");
		System.out.println("type: " + type);

		return (ClassTypeInformation<S>) cache.computeIfAbsent(type, ClassTypeInformation::new);
	}

	ClassTypeInformation(Class<S> type) {
		super(ResolvableType.forClass(type));
		this.type = type;
	}

	@Override
	public Class<S> getType() {
		return (Class<S>) type;
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}
}
