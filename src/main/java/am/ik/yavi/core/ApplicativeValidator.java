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
package am.ik.yavi.core;

import java.util.Locale;

import am.ik.yavi.fn.Validation;

/**
 * Applicative validator class
 * @param <T> Target class
 * @since 0.6.0
 */
@FunctionalInterface
public interface ApplicativeValidator<T> {
	Validated<T> validate(T target, Locale locale, ConstraintGroup constraintGroup);

	default Validated<T> validate(T target) {
		return this.validate(target, Locale.getDefault(), ConstraintGroup.DEFAULT);
	}

	default Validated<T> validate(T target, ConstraintGroup constraintGroup) {
		return this.validate(target, Locale.getDefault(), constraintGroup);
	}

	default Validated<T> validate(T target, Locale locale) {
		return this.validate(target, locale, ConstraintGroup.DEFAULT);
	}

	static <T> ApplicativeValidator<T> of(ValidatorSubset<T> validator) {
		return (target, locale, constraintGroup) -> {
			final ConstraintViolations violations = validator.validate(target, locale,
					constraintGroup);
			if (violations.isValid()) {
				return Validated.of(Validation.success(target));
			}
			else {
				return Validated.of(Validation.failure(violations));
			}
		};
	}
}