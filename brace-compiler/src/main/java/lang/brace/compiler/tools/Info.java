package lang.brace.compiler.tools;

import javax.xml.bind.annotation.*;

/**
 * this doc was created on 02.07.2022
 * This class belongs to the brace-lang project
 *
 * @author Generix030
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Info {

    @XmlAttribute
    String name;

    @XmlElement(name = "main.class")
    String main;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }
}
