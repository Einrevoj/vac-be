package capstone.project.controller;


import capstone.project.dto.ReportIncomeDTO;
import capstone.project.model.ReportIncomeRequest;
import capstone.project.service.ReportIncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/reportincome")
@RequiredArgsConstructor
public class ReportIncomeController {
    private final ReportIncomeService reportIncomeService;


    @GetMapping("/getAll")
    public List<ReportIncomeDTO> getAllReportIncome() {
        return reportIncomeService.getAllReportIncome();
    }

    @GetMapping("/getById/{incomeId}")
    public ReportIncomeDTO getReportIncome(@PathVariable UUID incomeId) {
        return reportIncomeService.getReportIncome(incomeId);
    }

    @PutMapping("/add")
    public List<ReportIncomeDTO> addReportIncome(@RequestBody ReportIncomeRequest reportIncomeRequest) {
        return reportIncomeService.addReportIncome(reportIncomeRequest);
    }

    @DeleteMapping("/delete/{incomeId}")
    public List<ReportIncomeDTO> deleteReportIncome(@PathVariable UUID incomeId) {
        return reportIncomeService.deleteReportIncome(incomeId);
    }

}
