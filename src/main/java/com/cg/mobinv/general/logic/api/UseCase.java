package com.cg.mobinv.general.logic.api;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
<<<<<<< master
 * This is a {@link Qualifier} to mark all use-cases. In your use-case implementation add the annotations
 * {@link javax.inject.Named} and {@link UseCase}. In your component facade implementation add the annotations
 * {@link javax.inject.Inject} and {@link UseCase} to the setters in order to inject your use case implementations.
=======
 * This is a {@link Qualifier} to mark all use-cases. In your use-case implementation add the
 * annotations {@link javax.inject.Named} and {@link UseCase}. In your component facade
 * implementation add the annotations {@link javax.inject.Inject} and {@link UseCase} to the setters
 * in order to inject your use case implementations.
 *
>>>>>>> HEAD~0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface UseCase {

}
