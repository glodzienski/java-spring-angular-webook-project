package webbook.api.core.helper;

import java.util.UUID;

public class UUIDGeneratorHelper {
    public static String get() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
