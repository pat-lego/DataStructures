package io.github.patlego.datastructures.lists;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

public interface List {

    public @Nonnull @Nonnegative Integer size();

    public @Nonnull Boolean isEmpty();

    public @Nonnull Item getHead();

    public @Nonnull Item getTail();

    public @Nonnull Boolean exists(@Nonnull Item item);

    public @Nonnull Boolean add(@Nonnull Item item);

    public @Nonnull Boolean remove(@Nonnull Item item);
}
