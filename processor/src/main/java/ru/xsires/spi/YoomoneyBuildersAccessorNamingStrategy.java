package ru.xsires.spi;

import org.mapstruct.ap.spi.DefaultAccessorNamingStrategy;
import org.mapstruct.ap.spi.util.IntrospectorUtils;

import javax.lang.model.element.ExecutableElement;

/**
 * Умеет работать с with методами, поддерживает работу с nullable через методы
 */
public class YoomoneyBuildersAccessorNamingStrategy extends DefaultAccessorNamingStrategy {


    @Override
    protected boolean isFluentSetter(ExecutableElement method) {
        return false;
    }

    @Override
    public boolean isSetterMethod(ExecutableElement method) {
        return isBuilderWithMethod(method) || super.isSetterMethod(method);
    }

    private boolean isBuilderWithMethod(ExecutableElement method) {
        String methodName = method.getSimpleName().toString();
        return methodName.startsWith("with")
                && methodName.length() > 4
                && method.getParameters().size() == 1;
    }

    @Override
    public boolean isGetterMethod(ExecutableElement method) {
        String returnTypQualifiedName = getQualifiedName(method.getReturnType());
        // считаем что все Optional Getter нам не подходят
        // вместо них используем getPropertyOrThrow и getPropertyOrNull
        if (returnTypQualifiedName.equals("java.util.Optional")) {
            return false;
        }
        return super.isGetterMethod(method);
    }

    @Override
    public String getPropertyName(ExecutableElement getterOrSetterMethod) {
        if (isBuilderWithMethod(getterOrSetterMethod)) {
            return IntrospectorUtils.decapitalize(getterOrSetterMethod.getSimpleName().toString().substring(4));
        }
        return super.getPropertyName(getterOrSetterMethod);
    }
}
