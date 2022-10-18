package capstone.project.service;

import capstone.project.dto.ProfileDTO;
import capstone.project.entity.ProfileEntity;
import capstone.project.exception.UserAlreadyExist;
import capstone.project.model.ProfileRequest;
import capstone.project.repository.ProfileRepository;
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
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final ModelMapper modelMapper;
    private final DateTimeUtil dateTimeUtil;

    public List<ProfileDTO> getAllProfile() {
//        Get all data from database
        List<ProfileEntity> allProfile = profileRepository.findAll(Sort.by(Sort.Direction.ASC, "createdDate"));

//        Initialize dto
        List<ProfileDTO> allProfileDTO = new ArrayList<>();

        allProfile.forEach(profile -> {
            allProfileDTO.add(modelMapper.map(profile, ProfileDTO.class));
        });
        return allProfileDTO;
    }

    public ProfileDTO getProfile(UUID memberId) {

        // Get profile from database
        ProfileEntity profile = profileRepository.findByMemberId(memberId);

        if (profile == null) throw new UserAlreadyExist("Profile doesn't exist");

        return modelMapper.map(profile, ProfileDTO.class);
    }


    public List<ProfileDTO> addProfile(ProfileRequest newProfile) {

        // Save new product to database
        profileRepository.save(ProfileEntity
                .builder()
                .memberId(UUID.randomUUID())
                .email(newProfile.getEmail())
                .imageLink(null)
                .contactNumber(newProfile.getContactNumber())
                .birthday(newProfile.getBirthday())
                .address(newProfile.getAddress())
                .occupation(newProfile.getOccupation())
                .employer(newProfile.getEmployer())
                .position(newProfile.getPosition())
                .createdDate(dateTimeUtil.currentDate())
                .modifiedDate(dateTimeUtil.currentDate())
                .build());

        return getAllProfile();
    }

    public List<ProfileDTO> deleteProfile(UUID memberId) {

        // Get product
        ProfileEntity profile = profileRepository.findByMemberId(memberId);

        // Check if product exist
        if(profile == null) throw new UserAlreadyExist("Profile doesn't exist");

        // Delete product
        profileRepository.deleteByMemberId(memberId);

        return getAllProfile();
    }
}