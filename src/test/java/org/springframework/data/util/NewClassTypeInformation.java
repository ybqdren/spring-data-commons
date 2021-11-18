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

import org.springframework.core.ResolvableType;
import org.springframework.util.Assert;

/**
 * @author Christoph Strobl
 * @since 2021/11
 */
public class NewClassTypeInformation<S> extends NewTypeDiscoverer<S> {


	static <S> TypeInformation<S> from(Class<S> type) {

		Assert.notNull(type, "Type must not be null!");
		return new NewClassTypeInformation<S>(type);
	}

	NewClassTypeInformation(Class<S> type) {
		super(ResolvableType.forClass(type));
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}
}
