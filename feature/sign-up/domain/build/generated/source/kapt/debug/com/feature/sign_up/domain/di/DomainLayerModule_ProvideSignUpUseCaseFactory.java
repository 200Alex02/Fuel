package com.feature.sign_up.domain.di;

import com.feature.sign_up.domain.repository.SignUpRepository;
import com.feature.sign_up.domain.use_case.SignUpUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class DomainLayerModule_ProvideSignUpUseCaseFactory implements Factory<SignUpUseCase> {
  private final DomainLayerModule module;

  private final Provider<SignUpRepository> signUpRepositoryProvider;

  public DomainLayerModule_ProvideSignUpUseCaseFactory(DomainLayerModule module,
      Provider<SignUpRepository> signUpRepositoryProvider) {
    this.module = module;
    this.signUpRepositoryProvider = signUpRepositoryProvider;
  }

  @Override
  public SignUpUseCase get() {
    return provideSignUpUseCase(module, signUpRepositoryProvider.get());
  }

  public static DomainLayerModule_ProvideSignUpUseCaseFactory create(DomainLayerModule module,
      Provider<SignUpRepository> signUpRepositoryProvider) {
    return new DomainLayerModule_ProvideSignUpUseCaseFactory(module, signUpRepositoryProvider);
  }

  public static SignUpUseCase provideSignUpUseCase(DomainLayerModule instance,
      SignUpRepository signUpRepository) {
    return Preconditions.checkNotNullFromProvides(instance.provideSignUpUseCase(signUpRepository));
  }
}
