package com.example.pardBackEnd_SJ.member.service;

import com.example.pardBackEnd_SJ.member.dto.MemberCreateDTO;
import com.example.pardBackEnd_SJ.member.dto.MemberReadDTO;
import com.example.pardBackEnd_SJ.member.entity.Member;
import com.example.pardBackEnd_SJ.member.repo.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepo memberRepo;

    public void createMember(MemberCreateDTO dto) {
        memberRepo.save(new Member().toEntity(dto));
    }
    /*
    MemberCreateDTO (dto)를 받음
    Member 엔티티 내의 toEntity()를 사용하여 [dto -> Member 엔티티]로 변환
    데이터베이스에 저장
     */

    public MemberReadDTO findById(Long id) { // 주어진 ID에 해당하는 멤버를 조회
        return new MemberReadDTO().toDTO(memberRepo.findById(id).orElseThrow());
        // id에 해당하는 멤버의 엔티티 객체를 가져옴
        // MemberReadDTO 내의 toDTO() 메서드를 사용하여, 클라이언트에게 전송할 수 있게끔 엔티티를 dto로 변환
        // '.orElseThrow()' -> 해당 ID에 해당하는 멤버가 없을 경우 예외를 던짐.
    }

    public List<MemberReadDTO> findAll() {
        return memberRepo.findAll()
                .stream()
                .map(member -> new MemberReadDTO().toDTO(member))
                .collect(Collectors.toList());
    }
    /*
    데이터베이스에서 모든 멤버를 가져옴
    stream과 map을 이용해서 각각의 멤버를 MemberReadDTO로 변환
    리스트 형태로 반환
     */

    public List<MemberReadDTO> findByPart(String part) { // 파라미터로 part를 받음
        return memberRepo.findByPart(part) // 특정 파트에 해당하는 멤버를 데이터베이스에서 찾음
                .stream() // 스트림으로 변환
                .map(member -> new MemberReadDTO().toDTO(member)) // 각각의 멤버를 MemberReadDTO로 변환
                .collect(Collectors.toList()); // 스트림 -> 리스트
    }

    /*

        stream : 리스트를 스트림으로 변환 -> 데이터를 연속된 요소로 나타냄
        map : 각 멤버를 MemberReadDTO로 변환 ->  변환한 모든 데이터를 모아서 새로운 스트림을 만들어서 반환
        collect : 변환한 MemberReadDTO를 리스트로 수집 -> MemberReadDTO 객체들의 리스트가 반환

    */

    public void deleteById(Long id) {
        memberRepo.deleteById(id);
    }
}
