package air.dontunsneak.client;

import air.dontunsneak.Config;

public class SneakState {
    private static boolean screenOpen = false;
    private static boolean wasSneakingBeforeScreen = false;

    public static boolean shouldKeepSneaking() {
        return Config.enabled && screenOpen && wasSneakingBeforeScreen;
    }

    public static void onScreenOpening(boolean currentlySneaking) {
        if (!screenOpen) wasSneakingBeforeScreen = currentlySneaking;
        screenOpen = true;
    }

    public static void onScreenClosed() {
        screenOpen = false;
        wasSneakingBeforeScreen = false;
    }
}
