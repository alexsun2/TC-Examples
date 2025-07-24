// TC_TYPE: observer

package Observer.JavaExample1;

import java.io.File;

public interface EventListener {
    void update(String eventType, File file);
}
