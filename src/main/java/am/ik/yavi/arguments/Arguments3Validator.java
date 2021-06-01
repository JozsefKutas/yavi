/*
 * Copyright (C) 2018-2021 Toshiaki Maki <makingx@gmail.com>
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

import am.ik.yavi.core.ConstraintGroup;
import am.ik.yavi.core.ConstraintViolationsException;
import am.ik.yavi.core.Validated;
import am.ik.yavi.core.Validator;
import am.ik.yavi.fn.Function3;

/**
 * Generated by https://github.com/making/yavi/blob/develop/scripts/generate-args.sh
 *
 * @since 0.3.0
 */
public final class Arguments3Validator<A1, A2, A3, X> {
	private final Validator<Arguments3<A1, A2, A3>> validator;
	private final Function3<? super A1, ? super A2, ? super A3, ? extends X> mapper;

	public Arguments3Validator(Validator<Arguments3<A1, A2, A3>> validator,
			Function3<? super A1, ? super A2, ? super A3, ? extends X> mapper) {
		this.validator = validator;
		this.mapper = mapper;
	}

	public Validated<X> validate(A1 a1, A2 a2, A3 a3) {
		return this.validator.applicative().validate(Arguments.of(a1, a2, a3),
				Locale.getDefault(), ConstraintGroup.DEFAULT)
				.map(values -> values.map(this.mapper));
	}

	public Validated<X> validate(A1 a1, A2 a2, A3 a3, ConstraintGroup constraintGroup) {
		return this.validator.applicative()
				.validate(Arguments.of(a1, a2, a3), Locale.getDefault(), constraintGroup)
				.map(values -> values.map(this.mapper));
	}

	public Validated<X> validate(A1 a1, A2 a2, A3 a3, Locale locale) {
		return this.validator.applicative()
				.validate(Arguments.of(a1, a2, a3), locale, ConstraintGroup.DEFAULT)
				.map(values -> values.map(this.mapper));
	}

	public Validated<X> validate(A1 a1, A2 a2, A3 a3, Locale locale,
			ConstraintGroup constraintGroup) {
		return this.validator.applicative()
				.validate(Arguments.of(a1, a2, a3), locale, constraintGroup)
				.map(values -> values.map(this.mapper));
	}

	/**
	 * Use {@link #validate(Object, Object, Object)} instead
	 */
	@Deprecated
	public Validated<X> validateArgs(A1 a1, A2 a2, A3 a3) {
		return this.validator.applicative().validate(Arguments.of(a1, a2, a3),
				Locale.getDefault(), ConstraintGroup.DEFAULT)
				.map(values -> values.map(this.mapper));
	}

	/**
	 * Use {@link #validate(Object, Object, Object, ConstraintGroup)} instead
	 */
	@Deprecated
	public Validated<X> validateArgs(A1 a1, A2 a2, A3 a3,
			ConstraintGroup constraintGroup) {
		return this.validator.applicative()
				.validate(Arguments.of(a1, a2, a3), Locale.getDefault(), constraintGroup)
				.map(values -> values.map(this.mapper));
	}

	/**
	 * Use {@link #validate(Object, Object, Object, Locale)} instead
	 */
	@Deprecated
	public Validated<X> validateArgs(A1 a1, A2 a2, A3 a3, Locale locale) {
		return this.validator.applicative()
				.validate(Arguments.of(a1, a2, a3), locale, ConstraintGroup.DEFAULT)
				.map(values -> values.map(this.mapper));
	}

	/**
	 * Use {@link #validate(Object, Object, Object, Locale, ConstraintGroup)} instead
	 */
	@Deprecated
	public Validated<X> validateArgs(A1 a1, A2 a2, A3 a3, Locale locale,
			ConstraintGroup constraintGroup) {
		return this.validator.applicative()
				.validate(Arguments.of(a1, a2, a3), locale, constraintGroup)
				.map(values -> values.map(this.mapper));
	}

	public void validateAndThrowIfInvalid(A1 a1, A2 a2, A3 a3) {
		this.validator.validate(Arguments.of(a1, a2, a3))
				.throwIfInvalid(ConstraintViolationsException::new);
	}

	public void validateAndThrowIfInvalid(A1 a1, A2 a2, A3 a3,
			ConstraintGroup constraintGroup) {
		this.validator.validate(Arguments.of(a1, a2, a3), constraintGroup)
				.throwIfInvalid(ConstraintViolationsException::new);
	}

	public X validated(A1 a1, A2 a2, A3 a3) throws ConstraintViolationsException {
		return this.validate(a1, a2, a3).orElseThrow(ConstraintViolationsException::new);
	}

	public X validated(A1 a1, A2 a2, A3 a3, ConstraintGroup constraintGroup)
			throws ConstraintViolationsException {
		return this.validate(a1, a2, a3, constraintGroup)
				.orElseThrow(ConstraintViolationsException::new);
	}

	public X validated(A1 a1, A2 a2, A3 a3, Locale locale)
			throws ConstraintViolationsException {
		return this.validate(a1, a2, a3, locale)
				.orElseThrow(ConstraintViolationsException::new);
	}

	public X validated(A1 a1, A2 a2, A3 a3, Locale locale,
			ConstraintGroup constraintGroup) throws ConstraintViolationsException {
		return this.validate(a1, a2, a3, locale, constraintGroup)
				.orElseThrow(ConstraintViolationsException::new);
	}
}
