package io.github.sinri.gilead.passage.check;

import io.github.sinri.keel.helper.KeelHelpers;
import io.vertx.core.Future;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

public class TribeCheckerAlpha implements TribeChecker {
    @Override
    public Future<Void> check(@Nonnull String tribe, @Nonnull String nonce, @Nonnull String checksum, @Nullable String body) {
        return fetchSecretForTribe(tribe)
                .compose(secret -> {
                    String expectedChecksum = KeelHelpers.digestHelper().md5(tribe + "@" + nonce + "@" + secret);
                    if (!Objects.equals(expectedChecksum, checksum)) {
                        return Future.failedFuture("Kill this Ephraimite!");
                    }
                    return Future.succeededFuture();
                });
    }

}
