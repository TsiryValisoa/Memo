package mg.tsiry.memo.converter;

import java.util.List;

/**
 * Create the abstract method of the converter.
 * @param <T> The parameter you want to convert into S.
 * @param <S> The parameter you want to convert into T.
 */
public interface Converter<T, S> {

    /**
     * Convert the S into T.
     *
     * @param source the parameter convert to T.
     * @return the T.
     */
    T convertToTO(S source);

    /**
     * Convert the list S into list T.
     *
     * @param sourceList the parameter list convert to list T.
     * @return the list T.
     */
    List<T> convertToListTO(List<S> sourceList);

    /**
     * Convert the T into S.
     *
     * @param to the parameter convert to S.
     * @return the S.
     */
    S convertFromTO(T to);

    /**
     * Convert the list T into list S.
     *
     * @param toList the parameter list convert to list S.
     * @return the list S.
     */
    List<S> convertFromListTO(List<T> toList);
}
