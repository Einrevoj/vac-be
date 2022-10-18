package capstone.project.controller;

import capstone.project.dto.MemberListDTO;
import capstone.project.model.MemberListRequest;
import capstone.project.service.MemberListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/memberlist")
@RequiredArgsConstructor
public class MemberListController {

    private final MemberListService memberListService;

    @GetMapping("/getAll")
    public List<MemberListDTO> getAllMemberList() {
        return memberListService.getAllMemberList();
    }

    @GetMapping("/getById/{memberlistId}")
    public MemberListDTO getMemberList(@PathVariable UUID memberlistId) {
        return memberListService.getMemberList(memberlistId);
    }

    @PutMapping("/add")
    public List<MemberListDTO> addMemberList(@RequestBody MemberListRequest memberlistRequest) {
        return memberListService.addMemberList(memberlistRequest);
    }

    @DeleteMapping("/delete/{memberlistId}")
    public List<MemberListDTO> deleteMemberList(@PathVariable UUID memberlistId) {
        return memberListService.deleteMemberList(memberlistId);
    }


}
