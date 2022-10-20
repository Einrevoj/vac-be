package capstone.project.controller;

import capstone.project.dto.InvestmentDTO;
import capstone.project.model.InvestmentRequest;
import capstone.project.service.InvestmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/investment")
@RequiredArgsConstructor
public class InvestmentController {

    private final InvestmentService investmentService;


    @GetMapping("/getAll")
    public List<InvestmentDTO> getAllInvestment() {
        return investmentService.getAllInvestment();
    }

    @GetMapping("/getById/{investmentId}")
    public InvestmentDTO getInvestment(@PathVariable UUID investmentId) {
        return investmentService.getInvestment(investmentId);
    }

    @PutMapping("/add")
    public List<InvestmentDTO> addInvestment(@RequestBody InvestmentRequest investmentRequest) {
        return investmentService.addInvestment(investmentRequest);
    }

    @DeleteMapping("/delete/{investmentId}")
    public List<InvestmentDTO> deleteInvestment(@PathVariable UUID investmentId) {
        return investmentService.deleteInvestment(investmentId);
    }

}
