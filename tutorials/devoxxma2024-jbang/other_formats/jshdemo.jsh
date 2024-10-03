///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS com.github.lalyos:jfiglet:0.0.9

import com.github.lalyos.jfiglet.FigletFont;

System.out.println("hello from jshell");
System.out.println(FigletFont.convertOneLine("DevoxxMA"));