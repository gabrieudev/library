package com.api.library.service;

import com.api.library.dto.LoanDTO;
import com.api.library.exception.EntityNotFoundException;
import com.api.library.model.Loan;
import com.api.library.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private MappingService mappingService;

    /**
     * Retrieves a loan by its id
     *
     * @param id the loan's id
     * @return the loan's DTO
     */
    public LoanDTO getById(Long id) {
        Loan loan = loanRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Loan not found with this id: " + id)
        );
        return mappingService.toDto(loan);
    }

    /**
     * Saves a loan
     *
     * @param loanDTO the loan's DTO
     */
    public void save(LoanDTO loanDTO) {
        Loan loan = mappingService.toModel(loanDTO);
        loanRepository.save(loan);
    }

    /**
     * Updates a loan
     *
     * @param id the loan's id
     * @param loanDTO the loan's DTO
     * @return the updated loan's DTO
     * @throws EntityNotFoundException if id is not found
     */
    public LoanDTO update(Long id, LoanDTO loanDTO) {
        Loan loan = loanRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Loan not found with this id: " + id)
        );
        mappingService.toModel(loanDTO, loan);
        Loan updatedLoan = loanRepository.save(loan);
        return mappingService.toDto(updatedLoan);
    }

    /**
     * Deletes a loan by its id
     *
     * @param id the loan's id
     * @throws EntityNotFoundException if id is not found
     */
    public void delete(Long id) {
        Loan loan = loanRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Loan not found with this id: " + id)
        );
        loanRepository.delete(loan);
    }

    /**
     * Retrieves the loans
     *
     * @return the Page of loans
     */
    public Page<LoanDTO> getAll(Pageable pageable) {
        return loanRepository.findAll(pageable).map(
                loan -> mappingService.toDto(loan)
        );
    }

}

