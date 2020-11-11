package tr.com.beyt.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EjsParserApplication {
    public static void main(String[] args) throws Throwable {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        engine.eval(Files.newBufferedReader(Paths.get("src/main/resources/portable_ejs.js"), StandardCharsets.UTF_8));
        engine.eval("packageName = 'tr.com.mahmut';");
        engine.eval("result=render('" + Files.readString(Paths.get("./src/main/resources/TestFile.java.ejs"),
                StandardCharsets.UTF_8).replace("\n", "\\n' + \n'") + "', {packageName: packageName});");
        System.out.println(engine.get("result"));
    }
}
