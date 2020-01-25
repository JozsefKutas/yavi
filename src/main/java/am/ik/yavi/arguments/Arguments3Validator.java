/*
 * Copyright (C) 2018-2020 Toshiaki Maki <makingx@gmail.com>
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

import java.util.List;
import java.util.Locale;

import am.ik.yavi.core.CollectionValidator;
import am.ik.yavi.core.ConstraintCondition;
import am.ik.yavi.core.ConstraintGroup;
import am.ik.yavi.core.ConstraintPredicates;
import am.ik.yavi.core.ConstraintViolations;
import am.ik.yavi.core.Validator;
import am.ik.yavi.core.ValidatorSubset;
import am.ik.yavi.fn.Either;
import am.ik.yavi.fn.Pair;
import am.ik.yavi.message.MessageFormatter;

/**
 * @since 0.3.0
 */
public final class Arguments3Validator<A1, A2, A3, X>
		extends Validator<Arguments3<A1, A2, A3>> {
	private final Arguments3.Mapper<A1, A2, A3, X> mapper;

	public Arguments3Validator(String messageKeySeparator,
			List<ConstraintPredicates<Arguments3<A1, A2, A3>, ?>> constraintPredicates,
			List<CollectionValidator<Arguments3<A1, A2, A3>, ?, ?>> collectionValidators,
			List<Pair<ConstraintCondition<Arguments3<A1, A2, A3>>, ValidatorSubset<Arguments3<A1, A2, A3>>>> conditionalValidators,
			MessageFormatter messageFormatter, Arguments3.Mapper<A1, A2, A3, X> mapper) {
		super(messageKeySeparator, constraintPredicates, collectionValidators,
				conditionalValidators, messageFormatter);
		this.mapper = mapper;
	}

	public ConstraintViolations validateArgs(A1 a1, A2 a2, A3 a3,
			ConstraintGroup constraintGroup) {
		return this.validate(Arguments.of(a1, a2, a3), Locale.getDefault(),
				constraintGroup);
	}

	public ConstraintViolations validateArgs(A1 a1, A2 a2, A3 a3, Locale locale) {
		return this.validate(Arguments.of(a1, a2, a3), locale, ConstraintGroup.DEFAULT);
	}

	public ConstraintViolations validateArgs(A1 a1, A2 a2, A3 a3, Locale locale,
			ConstraintGroup constraintGroup) {
		return this.validate(Arguments.of(a1, a2, a3), locale, constraintGroup);
	}

	public ConstraintViolations validateArgs(A1 a1, A2 a2, A3 a3) {
		return this.validate(Arguments.of(a1, a2, a3), Locale.getDefault(),
				ConstraintGroup.DEFAULT);
	}

	public Either<ConstraintViolations, X> validateArgsToEither(A1 a1, A2 a2, A3 a3) {
		return this
				.validateToEither(Arguments.of(a1, a2, a3), Locale.getDefault(),
						ConstraintGroup.DEFAULT)
				.rightMap(values -> values.map(this.mapper));
	}

	public Either<ConstraintViolations, X> validateArgsToEither(A1 a1, A2 a2, A3 a3,
			ConstraintGroup constraintGroup) {
		return this.validateToEither(Arguments.of(a1, a2, a3), Locale.getDefault(),
				constraintGroup).rightMap(values -> values.map(this.mapper));
	}

	public Either<ConstraintViolations, X> validateArgsToEither(A1 a1, A2 a2, A3 a3,
			Locale locale) {
		return this
				.validateToEither(Arguments.of(a1, a2, a3), locale,
						ConstraintGroup.DEFAULT)
				.rightMap(values -> values.map(this.mapper));
	}

	public Either<ConstraintViolations, X> validateArgsToEither(A1 a1, A2 a2, A3 a3,
			Locale locale, ConstraintGroup constraintGroup) {
		ConstraintViolations violations = this.validate(Arguments.of(a1, a2, a3), locale,
				constraintGroup);
		if (violations.isValid()) {
			return Either.right(Arguments.of(a1, a2, a3).map(this.mapper));
		}
		else {
			return Either.left(violations);
		}
	}
}
