package capstone.project.service;

import capstone.project.dto.InvestmentDTO;
import capstone.project.entity.InvestmentEntity;
import capstone.project.exception.UserAlreadyExist;
import capstone.project.model.InvestmentRequest;
import capstone.project.repository.InvestmentRepository;
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
public class InvestmentService {

    private InvestmentRepository investmentRepository;
    private final ModelMapper modelMapper;
    private final DateTimeUtil dateTimeUtil;

    public List<InvestmentDTO> getAllInvestment() {
//        Get all data from database
        List<InvestmentEntity> allInvestment = investmentRepository.findAll(Sort.by(Sort.Direction.ASC, "createdDate"));

//        Initialize dto
        List<InvestmentDTO> allInvestmentDTO = new ArrayList<>();

        allInvestment.forEach(investment -> {
            allInvestmentDTO.add(modelMapper.map(investment, InvestmentDTO.class));
        });
        return allInvestmentDTO;
    }

    public InvestmentDTO getInvestment(UUID investmentId) {

        // Get profile from database
        InvestmentEntity investment = investmentRepository.findByInvestmentId(investmentId);

        if (investment == null) throw new UserAlreadyExist("Investment doesn't exist");

        return modelMapper.map(investment, InvestmentDTO.class);
    }
    public List<InvestmentDTO> addInvestment(InvestmentRequest newInvestment) {

        // Save new product to database
        investmentRepository.save(InvestmentEntity
                .builder()
                .investmentId(UUID.randomUUID())
                .investmentTo(newInvestment.getInvestmentTo())
                .amount(newInvestment.getAmount())
                .withdrawnFrom(newInvestment.getWithdrawnFrom())
                .platFormUsed(newInvestment.getPlatFormUsed())
                .proofTrans(newInvestment.getProofTrans())
                .createdDate(dateTimeUtil.currentDate())
                .modifiedDate(dateTimeUtil.currentDate())
                .build());

        return getAllInvestment();
    }
    public List<InvestmentDTO> deleteInvestment(UUID investmentId) {

        // Get income
        InvestmentEntity investment = investmentRepository.findByInvestmentId(investmentId);

        // Check if income exist
        if(investment == null) throw new UserAlreadyExist("Investment doesn't exist");

        // Delete income
        investmentRepository.deleteByInvestmentId(investmentId);

        return getAllInvestment();
    }
}
