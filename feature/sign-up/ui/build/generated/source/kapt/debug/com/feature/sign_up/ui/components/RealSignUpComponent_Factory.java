package com.feature.sign_up.ui.components;

import com.arkivanov.decompose.ComponentContext;
import com.feature.sign_up.domain.use_case.SignUpUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class RealSignUpComponent_Factory {
  private final Provider<SignUpUseCase> signUpUseCaseProvider;

  public RealSignUpComponent_Factory(Provider<SignUpUseCase> signUpUseCaseProvider) {
    this.signUpUseCaseProvider = signUpUseCaseProvider;
  }

  public RealSignUpComponent get(ComponentContext componentContext, Function0<Unit> onSignUpClick,
      Function0<Unit> onBackClick) {
    return newInstance(componentContext, onSignUpClick, onBackClick, signUpUseCaseProvider.get());
  }

  public static RealSignUpComponent_Factory create(Provider<SignUpUseCase> signUpUseCaseProvider) {
    return new RealSignUpComponent_Factory(signUpUseCaseProvider);
  }

  public static RealSignUpComponent newInstance(ComponentContext componentContext,
      Function0<Unit> onSignUpClick, Function0<Unit> onBackClick, SignUpUseCase signUpUseCase) {
    return new RealSignUpComponent(componentContext, onSignUpClick, onBackClick, signUpUseCase);
  }
}
