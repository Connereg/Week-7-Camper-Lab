package com.example.week7camperlab.service;

import com.example.week7camperlab.model.Camper;
import com.example.week7camperlab.repository.CamperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CamperService {
    @Autowired
    CamperRepository camperRepository;

    public Camper createCamper(Camper camper) {
        return camperRepository.save(camper);
    }

    public List<Camper> getCampers() {
        return camperRepository.findAll();
    }

    public Camper getCamper(Integer camperId) {
        return camperRepository.findById(camperId).get();
    }

    public Camper updateCamper(Integer id, Camper camperData) {
        Camper updatedCamper = camperRepository.findById(id).get();
        updatedCamper.setName(camperData.getName());
        updatedCamper.setAge(camperData.getAge());
        return camperRepository.save(updatedCamper);
    }

    public void deleteCamper(Integer id) {
       camperRepository.deleteById(id);
    }

}


//package org.example.springwebdemo.service;
//
//        import org.example.springwebdemo.model.Member;
//        import org.example.springwebdemo.repository.MemberRepository;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.stereotype.Service;
//
//        import java.util.List;
//
//@Service
//public class MemberService {
//    @Autowired
//    MemberRepository memberRepository;
//
//    public Member createMember(Member member) {
//        return memberRepository.save(member);
//    }
//
//    public List<Member> getMembers() {
//        return memberRepository.findAll();
//    }
//
//    public Member getMember(Integer id) {
//        return memberRepository.findById(id).get();
//    }
//
//    public Member updateMember(Integer id, Member memberData) {
//        Member member = memberRepository.findById(id).get();
//        member.setName(memberData.getName());
//        member.setEmail(memberData.getEmail());
//        return memberRepository.save(member);
//    }
//
//    public void deleteMember(Integer id) {
//        memberRepository.deleteById(id);
//    }
//}
