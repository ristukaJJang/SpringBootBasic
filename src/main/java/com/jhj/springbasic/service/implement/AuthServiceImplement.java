package com.jhj.springbasic.service.implement;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jhj.springbasic.dto.PostUserRequestDto;
import com.jhj.springbasic.dto.SignInRequestDto;
import com.jhj.springbasic.entity.SampleUserEntity;
import com.jhj.springbasic.provider.JwtProvider;
import com.jhj.springbasic.repository.SampleUserRepository;
import com.jhj.springbasic.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService{

    private final JwtProvider jwtProvider;
    private final SampleUserRepository sampleUserRepository;

    // PasswordEncoder 인터페이스 : 비밀번호를 안전하고 쉽게 암호화하여 관리할 수 있도록 하는 인터페이스
    // - 구현체 : BcryptPasswordEncoder, ScryptPasswordEncoder, Pbkdf2PasswordEncoder
    // String encode(평문 비밀번호) : 평문 비밀번호를 암호화하여 반환
    // boolean matches(평문 비밀번호, 암호화된 비밀번호) : 평문 비밀번호와 암호화된 비밀번호가 일치하는지 여부 반환
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String signUp(PostUserRequestDto dto) {

        try {
            String userId = dto.getUserId();
            boolean isExistedId = sampleUserRepository.existsByUserId(userId);
            if(isExistedId) return "존재하는 아이디입니다.";

            String telNumber = dto.getTelNumber();
            boolean isExistedTelNumber = sampleUserRepository.existsByTelNumber(telNumber);
            if(isExistedTelNumber) return "존재하는 전화번호입니다.";

            String password = dto.getPassword();
            String name = dto.getName();
            String address = dto.getAddress();

            // SampleUserEntity userEntity = new SampleUserEntity(userId, password, name, address, telNumber);
            // userEntity.setUserId(userId);
            // userEntity.setPassword(password);

            // SampleUserEntity userEntity = 
            //     SampleUserEntity.builder()
            //                     .userId(userId)
            //                     .password(password)
            //                     .name(name)
            //                     .address(address)
            //                     .telNumber(telNumber).build();

            // 비밀번호 암호화
            String password1 = dto.getPassword();
            String encodedPassword = passwordEncoder.encode(password1);
            dto.setPassword(encodedPassword);

            SampleUserEntity userEntity = new SampleUserEntity(dto);
            sampleUserRepository.save(userEntity);
            return "성공";

        } catch(Exception exception) {
            exception.printStackTrace();
            return "예외발생";
        }
        
    }

    @Override
    public String signIn(SignInRequestDto dto) {
        try{
            String userId = dto.getUserId();
            SampleUserEntity userEntity = sampleUserRepository.findByUserId(userId);
            if(userEntity == null) return "로그인 정보가 일치하지 않습니다.";

            String password = dto.getPassword();
            String encodedPassword = userEntity.getPassword(); //암호화 되어 있음
            boolean isMatched = passwordEncoder.matches(password, encodedPassword);
            if(!isMatched) return "로그인 정보가 일치하지 않습니다.";

            String token = jwtProvider.create(userId);
            return token;
        } catch(Exception exception) {
            return "예외";
        }
        
    }
    
}
