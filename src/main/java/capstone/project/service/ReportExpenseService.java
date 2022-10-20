package capstone.project.service;

import capstone.project.dto.ReportExpenseDTO;
import capstone.project.entity.ReportExpenseEntity;
import capstone.project.exception.UserAlreadyExist;
import capstone.project.model.ReportExpenseRequest;
import capstone.project.repository.ReportExpenseRepository;
import capstone.project.util.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReportExpenseService {

    private ReportExpenseRepository reportExpenseRepository;
    private final ModelMapper modelMapper;
    private final DateTimeUtil dateTimeUtil;

    public List<ReportExpenseDTO> getAllReportExpense() {
//        Get all data from database
        List<ReportExpenseEntity> allReportExpense = reportExpenseRepository.findAll(Sort.by(Sort.Direction.ASC, "createdDate"));

//        Initialize dto
        List<ReportExpenseDTO> allReportExpenseDTO = new ArrayList<>();

        allReportExpense.forEach(reportExpense -> {
            allReportExpenseDTO.add(modelMapper.map(reportExpense, ReportExpenseDTO.class));
        });
        return allReportExpenseDTO;
    }

    public ReportExpenseDTO getReportExpense(UUID expenseId) {

        // Get profile from database
        ReportExpenseEntity reportExpense = reportExpenseRepository.findByExpenseId(expenseId);

        if (reportExpense == null) throw new UserAlreadyExist("Expense doesn't exist");

        return modelMapper.map(reportExpense, ReportExpenseDTO.class);
    }

    public List<ReportExpenseDTO> addReportExpense(ReportExpenseRequest newReportExpense) {

        // Save new product to database
        reportExpenseRepository.save(ReportExpenseEntity
                .builder()
                .expenseId(UUID.randomUUID())
                .expenseFrom(newReportExpense.getExpenseFrom())
                .amount(newReportExpense.getAmount())
                .withdrawnFrom(newReportExpense.getWithdrawnFrom())
                .accountNumber(newReportExpense.getAccountNumber())
                .proofTrans(newReportExpense.getProofTrans())
                .createdDate(dateTimeUtil.currentDate())
                .modifiedDate(dateTimeUtil.currentDate())
                .build());

        return getAllReportExpense();
    }

    public List<ReportExpenseDTO> deleteReportExpense(UUID expenseId) {

        // Get income
        ReportExpenseEntity reportExpense = reportExpenseRepository.findByExpenseId(expenseId);

        // Check if income exist
        if(reportExpense == null) throw new UserAlreadyExist("Expense doesn't exist");

        // Delete income
        reportExpenseRepository.deleteByExpenseId(expenseId);

        return getAllReportExpense();
    }
}
