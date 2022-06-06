/*
 * Copyright (C) 2018-2022 Toshiaki Maki <makingx@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package am.ik.yavi.arguments;

import java.util.Locale;
import java.util.function.Supplier;

import am.ik.yavi.core.ConstraintContext;
import am.ik.yavi.core.ConstraintGroup;
import am.ik.yavi.core.Validated;
import am.ik.yavi.core.Validator;
import am.ik.yavi.fn.Function12;
import am.ik.yavi.jsr305.Nullable;

/**
 * Generated by https://github.com/making/yavi/blob/develop/scripts/generate-args.sh
 *
 * @since 0.7.0
 */
public class DefaultArguments12Validator<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, X>
		implements
		Arguments12Validator<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, X> {
	protected final Validator<Arguments12<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12>> validator;
	protected final Function12<? super A1, ? super A2, ? super A3, ? super A4, ? super A5, ? super A6, ? super A7, ? super A8, ? super A9, ? super A10, ? super A11, ? super A12, ? extends X> mapper;

	public DefaultArguments12Validator(
			Validator<Arguments12<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12>> validator,
			Function12<? super A1, ? super A2, ? super A3, ? super A4, ? super A5, ? super A6, ? super A7, ? super A8, ? super A9, ? super A10, ? super A11, ? super A12, ? extends X> mapper) {
		this.validator = validator;
		this.mapper = mapper;
	}

	/**
	 * @since 0.10.0
	 */
	@Override
	public DefaultArguments12Validator<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Supplier<X>> lazy() {
		return new DefaultArguments12Validator<>(this.validator,
				(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12) -> () -> this.mapper
						.apply(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12));
	}

	@Override
	public Validated<X> validate(@Nullable A1 a1, @Nullable A2 a2, @Nullable A3 a3,
			@Nullable A4 a4, @Nullable A5 a5, @Nullable A6 a6, @Nullable A7 a7,
			@Nullable A8 a8, @Nullable A9 a9, @Nullable A10 a10, @Nullable A11 a11,
			@Nullable A12 a12, Locale locale, ConstraintContext constraintContext) {
		return this.validator.applicative()
				.validate(Arguments.of(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12),
						locale, constraintContext)
				.map(values -> values.map(this.mapper));
	}
}