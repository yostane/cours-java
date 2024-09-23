///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS com.github.lalyos:jfiglet:0.0.9

import com.github.lalyos.jfiglet.FigletFont;
import static java.lang.System.*;

public class DependenciesDemo {

    public static void main(String... args) throws Exception {
        out.println(FigletFont.convertOneLine("Hello DevoxxMA"));
    }
}
