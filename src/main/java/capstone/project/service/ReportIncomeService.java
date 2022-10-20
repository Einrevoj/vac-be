package capstone.project.service;

import capstone.project.dto.ReportIncomeDTO;
import capstone.project.entity.ReportIncomeEntity;
import capstone.project.exception.UserAlreadyExist;
import capstone.project.model.ReportIncomeRequest;
import capstone.project.repository.ReportIncomeRepository;
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
public class ReportIncomeService {

    private ReportIncomeRepository reportIncomeRepository;

    private final ModelMapper modelMapper;
    private final DateTimeUtil dateTimeUtil;

    public List<ReportIncomeDTO> getAllReportIncome() {
//        Get all data from database
        List<ReportIncomeEntity> allReportIncome = reportIncomeRepository.findAll(Sort.by(Sort.Direction.ASC, "createdDate"));

//        Initialize dto
        List<ReportIncomeDTO> allReportIncomeDTO = new ArrayList<>();

        allReportIncome.forEach(reportIncome -> {
            allReportIncomeDTO.add(modelMapper.map(reportIncome, ReportIncomeDTO.class));
        });
        return allReportIncomeDTO;
    }

    public ReportIncomeDTO getReportIncome(UUID incomeId) {

        // Get profile from database
        ReportIncomeEntity reportIncome = reportIncomeRepository.findByIncomeId(incomeId);

        if (reportIncome == null) throw new UserAlreadyExist("Income doesn't exist");

        return modelMapper.map(reportIncome, ReportIncomeDTO.class);
    }

    public List<ReportIncomeDTO> addReportIncome(ReportIncomeRequest newReportIncome) {

        // Save new product to database
        reportIncomeRepository.save(ReportIncomeEntity
                .builder()
                .incomeId(UUID.randomUUID())
                .incomeFrom(newReportIncome.getIncomeFrom())
                .amount(newReportIncome.getAmount())
                .accountNumber(newReportIncome.getAccountNumber())
                .accountName(newReportIncome.getAccountName())
                .proofTrans(newReportIncome.getProofTrans())
                .createdDate(dateTimeUtil.currentDate())
                .modifiedDate(dateTimeUtil.currentDate())
                .build());

        return getAllReportIncome();
    }

    public List<ReportIncomeDTO> deleteReportIncome(UUID incomeId) {

        // Get income
        ReportIncomeEntity reportIncome = reportIncomeRepository.findByIncomeId(incomeId);

        // Check if income exist
        if(reportIncome == null) throw new UserAlreadyExist("Income doesn't exist");

        // Delete income
        reportIncomeRepository.deleteByIncomeId(incomeId);

        return getAllReportIncome();
    }
}
