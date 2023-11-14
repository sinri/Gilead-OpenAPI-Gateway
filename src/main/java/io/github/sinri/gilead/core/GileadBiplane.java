package io.github.sinri.gilead.core;

import io.github.sinri.drydock.air.plane.Biplane;
import io.github.sinri.keel.facade.Keel;
import io.github.sinri.keel.facade.async.KeelAsyncKit;

public class Gilead extends Biplane {

    @Override
    protected void flyAsBiplane() {
        getLogger().info("flyAsBiplane start");

        KeelAsyncKit.sleep(3000L)
                .eventually(v -> {
                    getLogger().info("flyAsBiplane end");
                    return Keel.close();
                });
    }
}
