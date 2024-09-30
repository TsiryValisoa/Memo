package mg.tsiry.memo.converter;

import mg.tsiry.memo.dto.response.PaginationResponse;
import mg.tsiry.memo.to.PageInfoTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Holding the converter of paginationResponse and pageInfoTO.
 *
 * @author Tsiry Valisoa
 */
@Component
public class PaginationResponseConverter implements Converter<PageInfoTO, PaginationResponse> {

    /**
     * Throwing the exception of the variable source converted to PageInfoTO.
     *
     * @param source the parameter convert to PageInfoTO.
     * @return an exception.
     */
    @Override
    public PageInfoTO convertToTO(PaginationResponse source) {
        throw new UnsupportedOperationException();
    }

    /**
     * Throwing the exception of the list variable source converted to list PageInfoTO.
     *
     * @param sourceList the parameter list convert to list PageInfoTO.
     * @return an exception.
     */
    @Override
    public List<PageInfoTO> convertToListTO(List<PaginationResponse> sourceList) {
        throw new UnsupportedOperationException();
    }

    /**
     * Convert the to to PaginationResponse.
     *
     * @param to the parameter convert to PaginationResponse.
     * @return the paginationResponse converted.
     */
    @Override
    public PaginationResponse convertFromTO(PageInfoTO to) {
        PaginationResponse paginationResponse = new PaginationResponse();
        paginationResponse.setTotalRecords(to.getTotalElements());
        paginationResponse.setTotalPages(to.getTotalPages());
        paginationResponse.setCurrentPage(to.getCurrentPage());
        paginationResponse.setNextPage(to.getNextPage());
        paginationResponse.setPreviousPage(to.getPreviousPage());
        return paginationResponse;
    }

    /**
     * Convert the list to to list PaginationResponse.
     *
     * @param toList the parameter list convert to list PaginationResponse.
     * @return the list paginationResponse converted.
     */
    @Override
    public List<PaginationResponse> convertFromListTO(List<PageInfoTO> toList) {
        return toList.stream()
                .map(this::convertFromTO)
                .toList();
    }
}
