package com.example.board.service.implementations;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.board.dto.request.auth.SignUpRequestDto;
import com.example.board.dto.response.ResponseDto;
import com.example.board.entity.UserEntity;
import com.example.board.repository.UserRepository;
import com.example.board.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplementation implements AuthService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto) {
        
        try {

            String email = dto.getEmail();
            boolean isExistEmail = userRepository.existsByEmail(email);
            if (isExistEmail) return ResponseDto.duplicateEmail();

            String nickname = dto.getNickname();
            boolean isExistNickname = userRepository.existsByNickname(nickname);
            if (isExistNickname) return ResponseDto.duplicateNickname();

            String telNumber = dto.getTelNumber();
            boolean isExistTelNumber = userRepository.existsByTelNumber(telNumber);
            if (isExistTelNumber) return ResponseDto.duplicateTelNumber();

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

            return ResponseDto.success();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

    }
    
}
