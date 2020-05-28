package pl.mzlnk.emergencyspotapi.utils.distance;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class BiOptional<T, U> {

    public static <T, U> BiOptional<T, U> of(Optional<T> first, Optional<U> second) {
        BiOptional<T, U> biOptional = new BiOptional<>();

        biOptional.first = first;
        biOptional.second = second;

        return biOptional;
    }

    private Optional<T> first;
    private Optional<U> second;

    public void ifPresentOrElse(BiConsumer<T, U> action, Runnable emptyAction) {
        this.first.ifPresentOrElse(first -> {
                    this.second.ifPresentOrElse(second -> {
                                action.accept(first, second);
                            },
                            emptyAction::run
                    );
                },
                emptyAction::run
        );
    }

    public <R> Optional<R> map(BiFunction<T, U, R> mapper) {
        if(this.first.isEmpty() || this.second.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(mapper.apply(first.get(), second.get()));
    }

}
