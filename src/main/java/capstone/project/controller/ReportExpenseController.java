package capstone.project.controller;

import capstone.project.dto.ReportExpenseDTO;
import capstone.project.model.ReportExpenseRequest;
import capstone.project.service.ReportExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/reportexpense")
@RequiredArgsConstructor
public class ReportExpenseController {
    private final ReportExpenseService reportExpenseService;


    @GetMapping("/getAll")
    public List<ReportExpenseDTO> getAllReportExpense() {
        return reportExpenseService.getAllReportExpense();
    }

    @GetMapping("/getById/{expenseId}")
    public ReportExpenseDTO getReportExpense(@PathVariable UUID expenseId) {
        return reportExpenseService.getReportExpense(expenseId);
    }

    @PutMapping("/add")
    public List<ReportExpenseDTO> addReportExpense(@RequestBody ReportExpenseRequest reportExpenseRequest) {
        return reportExpenseService.addReportExpense(reportExpenseRequest);
    }

    @DeleteMapping("/delete/{expenseId}")
    public List<ReportExpenseDTO> deleteReportExpense(@PathVariable UUID expenseId) {
        return reportExpenseService.deleteReportExpense(expenseId);
    }
}
