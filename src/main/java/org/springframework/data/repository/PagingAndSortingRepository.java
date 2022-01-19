/*
 * Copyright 2008-2021 the original author or authors.
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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * PagingAndSortingRepository 除了集成了 {@link CrudRepository} 所有基本方法外，
 * 它还增加了 < 分页和排序等对查询结果进行限制 >  的基本的、常用的、通用的一些分页方法
 *
 * <p>
 *     {@link PagingAndSortingRepository} 和 {@link CrudRepository} 都是 Spring Data Common 的标准接口，
 *     如果我们采用 JPA ，那它对应的实体类就是 Spring-Data-JPA 中的 SimpleJpaRepository。
 *     如果是其他的 NoSQL 的实现，例如 Mongodb ，那么就是 Spring-Data-Mongodb 的实体类
 * </p>
 *
 *
 * Extension of {@link CrudRepository} to provide additional methods to retrieve entities using the pagination and
 * sorting abstraction.
 *
 * @author Oliver Gierke
 * @see Sort
 * @see Pageable
 * @see Page
 */
@NoRepositoryBean
public interface PagingAndSortingRepository<T, ID> extends CrudRepository<T, ID> {

	/**
	 * 根据排序获取所有对象的集合
	 *
	 * Returns all entities sorted by the given options.
	 *
	 * @param sort
	 * @return all entities sorted by the given options
	 */
	Iterable<T> findAll(Sort sort);

	/**
	 * 根据分页和排序进行查询，并用 Page 对象封装。
	 *
	 * {@link Pageable} 对象包含分页和 {@link Sort} 对象
	 *
	 * Returns a {@link Page} of entities meeting the paging restriction provided in the {@code Pageable} object.
	 *
	 * @param pageable
	 * @return a page of entities
	 */
	Page<T> findAll(Pageable pageable);
}
