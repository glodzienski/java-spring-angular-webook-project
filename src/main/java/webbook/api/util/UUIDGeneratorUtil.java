package webbook.api.util;

import java.util.UUID;

public class UUIDGeneratorUtil {
    public static String get() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
