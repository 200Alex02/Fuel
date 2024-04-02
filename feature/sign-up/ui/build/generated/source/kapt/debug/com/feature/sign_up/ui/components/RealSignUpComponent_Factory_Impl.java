package com.feature.sign_up.ui.components;

import com.arkivanov.decompose.ComponentContext;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

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
public final class RealSignUpComponent_Factory_Impl implements RealSignUpComponent.Factory {
  private final RealSignUpComponent_Factory delegateFactory;

  RealSignUpComponent_Factory_Impl(RealSignUpComponent_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public RealSignUpComponent invoke(ComponentContext componentContext,
      Function0<Unit> onSignUpClick, Function0<Unit> onBackClick) {
    return delegateFactory.get(componentContext, onSignUpClick, onBackClick);
  }

  public static Provider<RealSignUpComponent.Factory> create(
      RealSignUpComponent_Factory delegateFactory) {
    return InstanceFactory.create(new RealSignUpComponent_Factory_Impl(delegateFactory));
  }
}
