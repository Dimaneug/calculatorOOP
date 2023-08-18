package app.logger;

import java.io.IOException;

public interface Loggable {
    void log(String msg) throws IOException;
}
