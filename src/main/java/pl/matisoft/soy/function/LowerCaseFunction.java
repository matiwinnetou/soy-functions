package pl.matisoft.soy.function;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Singleton;
import com.google.template.soy.data.SoyValue;
import com.google.template.soy.data.restricted.StringData;
import com.google.template.soy.shared.restricted.SoyJavaFunction;
import com.google.template.soy.shared.restricted.SoyPureFunction;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;

@Singleton
@SoyPureFunction
public class LowerCaseFunction implements SoyJavaFunction {

    @Inject
    public LowerCaseFunction() {}

    @Override
    public SoyValue computeForJava(final List<SoyValue> args) {
        final SoyValue arg = args.get(0);

        if (arg instanceof StringData) {
            final StringData stringData = (StringData) arg;

            return StringData.forValue(stringData.getValue().toLowerCase());
        }

        return arg;
    }

    @Override
    public String getName() {
        return "lowerCase";
    }

    @Override
    public Set<Integer> getValidArgsSizes() {
        return ImmutableSet.of(1);
    }

}
