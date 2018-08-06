package cn.catherine.greendaogenerate;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Property;
import org.greenrobot.greendao.generator.Schema;

import java.io.IOException;

/**
 * GreenDaoExample
 * <p>
 * cn.catherine.greendaogenerate
 * <p>
 * created by catherine in 八月/05/2018/下午10:49
 */
public class My {

    public static void main(String[] args) throws Exception {
        Schema schema=new Schema(1,"cn.catherine.data");
        Entity entity=schema.addEntity("Person");
        entity.addIdProperty();
        entity.addStringProperty("name");
        entity.addIntProperty("age");

        Entity son=schema.addEntity("Son");
        son.addIdProperty();
        son.addStringProperty("name");
        son.addIntProperty("age");
        Property fatherId=son.addLongProperty("fatherId").getProperty();

        Entity father=schema.addEntity("Father");
        father.addIdProperty();
        father.addStringProperty("hobby");
        father.addIntProperty("tall");

        son.addToOne(father,fatherId);

        new DaoGenerator().generateAll(schema,"app/src/main/java");
    }
}
