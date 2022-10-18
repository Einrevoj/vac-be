package capstone.project.service;

import capstone.project.dto.MemberListDTO;
import capstone.project.entity.MemberListEntity;
import capstone.project.exception.UserAlreadyExist;
import capstone.project.model.MemberListRequest;
import capstone.project.repository.MemberListRepository;
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
public class MemberListService {

    private final MemberListRepository memberListRepository;
    private final ModelMapper modelMapper;
    private final DateTimeUtil dateTimeUtil;


    public List<MemberListDTO> getAllMemberList() {

//    get all data from database
        List<MemberListEntity> allMemberList = memberListRepository.findAll(Sort.by(Sort.Direction.ASC, "createdDate"));

//        Initialize dto
        List<MemberListDTO> allMemberListDTO = new ArrayList<>();

        allMemberList.forEach(memberlist -> {
            allMemberListDTO.add(modelMapper.map(memberlist, MemberListDTO.class));
        });
        return allMemberListDTO;
    }
    public MemberListDTO getMemberList(UUID memberlistId) {
//        Get memberlist from database
        MemberListEntity memberlist = memberListRepository.findBymemberlistId(memberlistId);

        if (memberlist == null) throw new UserAlreadyExist("MemberList doesn't exist");

        return modelMapper.map(memberlist, MemberListDTO.class);
    }

    public List<MemberListDTO> addMemberList(MemberListRequest newMemberList) {
//        Save new memberlist to database
        memberListRepository.save(MemberListEntity
                .builder()
                .memberlistId(UUID.randomUUID())
                .firstName(newMemberList.getFirstName())
                .lastName(newMemberList.getLastName())
                .contactNumber(newMemberList.getContactNumber())
                .status(newMemberList.getStatus())
                .createdDate(dateTimeUtil.currentDate())
                .modifiedDate(dateTimeUtil.currentDate())
                .build());

        return getAllMemberList();

    }

    public List<MemberListDTO> deleteMemberList(UUID memberlistId) {

        // Get product
        MemberListEntity product = memberListRepository.findBymemberlistId(memberlistId);

        // Check if product exist
        if(product == null) throw new UserAlreadyExist("MemberList doesn't exist");

        // Delete product
       memberListRepository.deleteBymemberlistId(memberlistId);

        return getAllMemberList();
    }

}
