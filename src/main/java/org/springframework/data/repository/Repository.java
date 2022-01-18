/*
 * Copyright 2011-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.repository;

import org.springframework.stereotype.Indexed;

/**
 * <p> Repository 位于 Spring Data Common 中，是 Spring Data 中做数据库操作的最底层的抽象接口、最顶级的父类 </p>
 *
 * <p>
 *     Repository 仅仅起到一个标识作用，此接口定义了所有 Repostory 操作的实体和 ID 两个泛型参数。
 *     我们不需要继承任何接口，只要继承这个接口，就可以使用 Spring JPA 里面提供的很多约定的方法查询和注解查询
 *  </p>
 *
 * <p>
 *     管理域类以及域类的 id 类型作为类型参数，此接口主要作为标记接口捕获要使用的类型，
 *     并帮助你发现扩展此接口的接口
 * </p>
 *
 * <p>
 *     Spring 底层做动态代理的时候发现只要是它的子类或者实现类，都代表存储库操作
 * </p>
 *
 * Central repository marker interface. Captures the domain type to manage as well as the domain type's id type. General
 * purpose is to hold type information as well as being able to discover interfaces that extend this one during
 * classpath scanning for easy Spring bean creation.
 * <p>
 * Domain repositories extending this interface can selectively expose CRUD methods by simply declaring methods of the
 * same signature as those declared in {@link CrudRepository}.
 * 
 * @see CrudRepository
 * @param <T> the domain type the repository manages
 * @param <ID> the type of the id of the entity the repository manages
 * @author Oliver Gierke
 */
@Indexed
public interface Repository<T, ID> {

}
