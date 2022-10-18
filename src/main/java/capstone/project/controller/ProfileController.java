package capstone.project.controller;

import capstone.project.dto.MemberListDTO;
import capstone.project.dto.ProfileDTO;
import capstone.project.model.MemberListRequest;
import capstone.project.model.ProfileRequest;
import capstone.project.service.MemberListService;
import capstone.project.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/getAll")
    public List<ProfileDTO> getAllProfile() {
        return profileService.getAllProfile();
    }

    @GetMapping("/getById/{memberId}")
    public ProfileDTO getProfile(@PathVariable UUID memberId) {
        return profileService.getProfile(memberId);
    }

    @PutMapping("/add")
    public List<ProfileDTO> addProfile(@RequestBody ProfileRequest profileRequest) {
        return profileService.addProfile(profileRequest);
    }

    @DeleteMapping("/delete/{memberId}")
    public List<ProfileDTO> deleteProfile(@PathVariable UUID memberId) {
        return profileService.deleteProfile(memberId);
    }
}
