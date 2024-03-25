package com.pjh.basic.service.implement;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.ByteBuffer;

import org.springframework.stereotype.Service;

import com.pjh.basic.service.BasicService;


// Service 레이어:
// - 실제 비지니즈 로직(연산)을 실행하는 영역
// - 트랜잭션 처리나 유효성 검사(직전 비지니스 로직 결과에 대한)를 수행하기도 함
// - Controller로부터 받은 요청 데이터에 대해서 필요에 따라 Repository등을 거쳐 연산을 진행하고
// Controller에 응답에 대한 데이터를 반환

import jakarta.websocket.EncodeException;
import jakarta.websocket.RemoteEndpoint.Basic;


// @Service : 해당 클래스를 Spring Bean으로 등록하는 어노테이션, 역할은 @Component와 동일
// @Component: 해당 클래스를 Spring Bean으로 등록하는 어노테이션
// Spring Bean: 제어의 역전을 통해서 의존성 주입시 해당 클래스의 인스턴스를 Spring Framework가
// 제어하는 요소 
@Service
public class BasicServiceImplement implements BasicService 
{
    
   @Override
    public String getHello(){
        return "Hello Springboot!!";
    }

    @Override
    public String getApple(){
        return "Get Mapping 으로 만든 메서드";
    }
}
