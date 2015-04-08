/*
 Copyright 2015 Mateusz Szczap

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/
package pl.matisoft.soy.function;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Singleton;
import com.google.template.soy.data.SoyValue;
import com.google.template.soy.data.restricted.StringData;
import com.google.template.soy.jssrc.restricted.JsExpr;
import com.google.template.soy.jssrc.restricted.SoyJsSrcFunction;
import com.google.template.soy.shared.restricted.SoyJavaFunction;
import com.google.template.soy.shared.restricted.SoyPureFunction;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;

@Singleton
@SoyPureFunction
public class LowerCaseFunction implements SoyJavaFunction, SoyJsSrcFunction {

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
    public JsExpr computeForJsSrc(final List<JsExpr> args) {
        final JsExpr arg = args.get(0);

        return new JsExpr(String.format("%s.toLowerCase()", arg.getText()), Integer.MAX_VALUE);
    }

    @Override
    public Set<Integer> getValidArgsSizes() {
        return ImmutableSet.of(1);
    }

}
